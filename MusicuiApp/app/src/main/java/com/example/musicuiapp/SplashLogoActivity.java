package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashLogoActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_logo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent homeIntent = new Intent(SplashLogoActivity.this, LoginActivity.class);

                startActivity(homeIntent);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

