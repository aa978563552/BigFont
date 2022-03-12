package com.example.chenchen.book;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class AActivity extends AppCompatActivity {
    AActivity mContext = this;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Button button = findViewById(R.id.toB);
        Button button_toast = findViewById(R.id.toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,BActivity.class);
                mContext.startActivity(intent);
            }
        });

        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(mContext, TransparentActivity.class);
                startActivity(intent);
            }
        });
    }




    @Override
    protected void onPause() {
        Log.d("test_status","onPause");
        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.d("test_status","onStop");
        super.onStop();
    }
}
