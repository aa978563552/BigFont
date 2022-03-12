package com.example.chenchen.book;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.util.ArrayList;

import adapter.CommentAdapter;
import bean.CommentBean;

public class ShopDetailActivity extends Activity {


    BaseAdapter mAdapter;
    ListView mList_comment;
    Context mContext;
    ArrayList<CommentBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_detail);
        LayoutInflater inflater = LayoutInflater.from(ShopDetailActivity.this);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearLayout_main);
        RelativeLayout layout = (RelativeLayout) inflater.inflate(
                R.layout.nav_item, null).findViewById(R.id.RelativeLayout_item);
        linearlayout.addView(layout);


        mData = new ArrayList<CommentBean>();
        mData.add(new CommentBean(11324, "Neo Chen", R.mipmap.buy1, "This bolt is not hard to screw.This bolt is not hard to screw."));
        mData.add(new CommentBean(21422, "Mary Wang", R.mipmap.buy2, "It's very easy to use"));


        mContext = ShopDetailActivity.this;
        mList_comment = findViewById(R.id.list_comment);

        mAdapter = new CommentAdapter(mData, R.layout.shop_list_list_item) {
            @Override
            public void bindView(final ViewHolder holder, final Object obj) {
                holder.setImageResource(R.id.icon, ((CommentBean) obj).getImgsrc());
                holder.setText(R.id.txt_name, ((CommentBean) obj).getName());
                holder.setComment(R.id.comment, ((CommentBean) obj).getComment());

            }
        };




        mList_comment.setAdapter(mAdapter);


    }
    public void buttonClick(View view) {
        Toast.makeText(this, "点击了头部Nav", Toast.LENGTH_SHORT).show();
    }

}
