package com.example.chenchen.book;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import adapter.ProductAdapter;
import bean.CommentBean;
import bean.ProductBean;

public class ShopListActivity extends Activity {
    BaseAdapter mAdapter;
    GridView mGrid_product;
    Context mContext;
    ArrayList<ProductBean> mData;
    Handler handler;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_list);
        LayoutInflater inflater = LayoutInflater.from(ShopListActivity.this);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearLayout_main);
        RelativeLayout layout = (RelativeLayout) inflater.inflate(
                R.layout.nav_item, null).findViewById(R.id.RelativeLayout_item);
        linearlayout.addView(layout);
        mData = new ArrayList<ProductBean>();


        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {

                Toast.makeText(mContext,"handler call", Toast.LENGTH_LONG).show();
                if (msg.what == 0) {
                    Toast.makeText(mContext, "服务器异常", Toast.LENGTH_LONG).show();
                } else if (msg.what == 1) {
                    String mString = msg.obj.toString();
                    mString = mString.substring(2,mString.length()-2);
                    String[] arrString = mString.split("\\},\\{"); // 用,分割
                    System.out.print(arrString);

                    for(int i = 0; i< arrString.length; i++ ){
                        mData.add(new ProductBean(String.valueOf(arrString[i])));
                    }
                    mGrid_product.setAdapter(mAdapter);
                    Toast.makeText(mContext, msg.obj.toString(), Toast.LENGTH_LONG).show();
                }
            };
        };


        /*
        mData.add(new ProductBean("screw1", "$143",R.mipmap.store1));
        mData.add(new ProductBean("screw2", "$132",R.mipmap.store2));
        mData.add(new ProductBean("screw3", "$323",R.mipmap.store3));
        mData.add(new ProductBean("screw4", "$313",R.mipmap.store4));
        mData.add(new ProductBean("screw5", "$233",R.mipmap.store5));
        mData.add(new ProductBean("screw6", "$653",R.mipmap.store6));
           */
        mContext = ShopListActivity.this;
        mGrid_product = findViewById(R.id.grid_product);

        mAdapter = new ProductAdapter(mData, R.layout.shop_list_grid_item) {
            @Override
            public void bindView(final ViewHolder holder, final Object obj) {
                holder.setImageResource(R.id.img_icon, ((ProductBean)obj).getImgsrc());
                holder.setText(R.id.txt_name, ((ProductBean)obj).getName());
                holder.setCast(R.id.txt_cast, ((ProductBean)obj).getCast());
                holder.getViewById(R.id.add_cast).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("ssss", "1111111111");
                    }
                });

                holder.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("ssss", mData.indexOf(obj)+"");

                    }
                });
                holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(mContext, "我们长按了"+((ProductBean)obj).getName(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        };



        fetch();



    }


    public void fetch() {
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                String path = "http://192.168.1.4:9999/list";

                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);

                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        byte[] b = new byte[1024];
                        int len = 0;
                        // 创建字节数组输出流,读取输入流的文本数据时,同步把数据写入数组输出流
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        while ((len = is.read(b)) != -1) {
                            bos.write(b, 0, len);
                        }
                        // 把字节数组输出流的数据转换成字节数组
                        String text = new String(bos.toByteArray(), "utf-8");
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = text;
                        handler.sendMessage(msg);
                    } else {
                        handler.sendEmptyMessage(0);
                    }
                } catch (Exception e) {
                    Log.d("SSSSSS","BBBBBBBBBBB");

                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
