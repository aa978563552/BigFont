package com.example.chenchen.book;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.CommentAdapter;
import adapter.ProductAdapter;
import bean.CommentBean;
import bean.ProductBean;
import my.MyListView;

public class ShopCarActivity extends Activity {

    BaseAdapter mAdapter_shop;
    BaseAdapter mAdapter_price;
    ListView mList_shop;
    ListView mList_shop_price;
    Context mContext;
    ArrayList<ProductBean> mDataProduct;
    ArrayList<ProductBean> mDataPrice;
    ScrollView mScrollview;
    LinearLayout mLinerLaytout;
    DisplayMetrics outMetrics;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_car);
        LayoutInflater inflater = LayoutInflater.from(ShopCarActivity.this);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearLayout_main);
        RelativeLayout layout = (RelativeLayout) inflater.inflate(
                R.layout.nav_item, null).findViewById(R.id.RelativeLayout_item);
        linearlayout.addView(layout);


        outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);



        mScrollview = findViewById(R.id.shop_list_scrollview);
        mLinerLaytout = findViewById(R.id.shop_car_linerlayout);

        mDataProduct = new ArrayList<ProductBean>();
        mDataProduct.add(new ProductBean("screw1", "$143",R.mipmap.store1, "You'll have to unscrew the handles to paint the door."));
        mDataProduct.add(new ProductBean("screw2", "$132",R.mipmap.store2, "The screw was so tight that it wouldn't move."));
        mDataProduct.add(new ProductBean("screw3", "$143",R.mipmap.store3, "You'll have to unscrew the handles to paint the door."));
        mDataProduct.add(new ProductBean("screw4", "$132",R.mipmap.store4, "The screw was so tight that it wouldn't move."));

        mDataPrice = new ArrayList<ProductBean>();
        mDataPrice.add(new ProductBean("screw1", "$143",R.mipmap.store1, "You'll have to unscrew the handles to paint the door."));
        mDataPrice.add(new ProductBean("screw2", "$132",R.mipmap.store2, "The screw was so tight that it wouldn't move."));
        mDataPrice.add(new ProductBean("screw3", "$143",R.mipmap.store3, "You'll have to unscrew the handles to paint the door."));
        mDataPrice.add(new ProductBean("screw4", "$132",R.mipmap.store4, "The screw was so tight that it wouldn't move."));

        mContext = ShopCarActivity.this;
        mList_shop = findViewById(R.id.list_shop);
        mList_shop_price = findViewById(R.id.list_price);

        mAdapter_shop = new ProductAdapter(mDataProduct, R.layout.shop_car_price_item) {
            @Override
            public void bindView(final ViewHolder holder, final Object obj) {
                holder.setImageResource(R.id.icon, ((ProductBean)obj).getImgsrc());
                holder.setText(R.id.txt_name, ((ProductBean)obj).getName());
                holder.setCast(R.id.shop_price, ((ProductBean)obj).getCast());
                holder.setCast(R.id.des, ((ProductBean)obj).getDes());
            }
        };

        mAdapter_price = new ProductAdapter(mDataPrice, R.layout.shop_car_price_total_item) {
            @Override
            public void bindView(final ViewHolder holder, final Object obj) {
                holder.setText(R.id.shop_car_name, ((ProductBean)obj).getName());
                holder.setCast(R.id.shop_car_price, ((ProductBean)obj).getCast());
            }
        };

        mList_shop.setAdapter(mAdapter_shop);
        mList_shop_price.setAdapter(mAdapter_price);

        mScrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                /*
                  先说getMeasuredHeight()和getHeight()，这两个方法都是获取组件高度的，在普通布局中，
                  如果组件本身没有超过手机屏幕，那么这两个方法获取的组件高度相等；但是如果在像ScrollView这种滑动布局中，
                  组件往往会超出屏幕，那么getHeight()获取的高度就是屏幕显示的高度，不确切的说就是屏幕高度，
                  而getMeasuredHeight()获取的是这个组件实际大小，包括显示的部分和超出屏幕的部分。
                 */


                if(scrollY+mScrollview.getHeight() >= mLinerLaytout.getHeight()){
                    Toast.makeText(mContext, "商品列表已经滑动到底部了", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
