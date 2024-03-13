package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(ProfileActivity.this, MainActivity.class); //From Profile Screen to MainActivity

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
    }
    }
