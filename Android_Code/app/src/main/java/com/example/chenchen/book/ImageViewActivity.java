package com.example.chenchen.book;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;


import static tools.ImageTool.getData;

public class ImageViewActivity extends Activity {
    private Bitmap mBitmap;
    private ImageView imageView;
    private String imageUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what == 1){
                imageView.setImageBitmap(mBitmap);
            }
        };
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            Message msg = new Message();
            msg.what = 1;
            mBitmap = getData(imageUrl);
            handler.sendMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        imageView = findViewById(R.id.netImage);
        new Thread(runnable).start();

    }
}
