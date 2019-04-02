package com.shared.vivek.quickdoc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main1 extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i1=new Intent(Main1.this,Main2.class);
                startActivity(i1);
                finish();
        }

    },SPLASH_DISPLAY_LENGTH);
}
}