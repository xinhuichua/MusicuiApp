package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    Button btnProfile, btnSettings, btnTrending, btnMusicLibrary, btnSearching, btnRecent, btnGuide, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnProfile);
        btnSettings = findViewById(R.id.btnSettings);
        btnTrending = findViewById(R.id.btnTrending);
        btnMusicLibrary = findViewById(R.id.btnMusicLibrary);
        btnSearching = findViewById(R.id.btnSearching);
        btnRecent = findViewById(R.id.btnRecent);
        btnGuide = findViewById(R.id.btnGuide);
        logout = findViewById(R.id.logout);

       btnProfile.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this,ProfileActivity.class); //This allows user login to go AlbumOneMainActivity

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT); //LoginActivity goes to the next screen which is the AlbumOneMainActivity
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this,SettingsActivity.class); //This allows user login to go AlbumOneMainActivity
                        Toast.makeText(MainActivity.this, "You clicked onto Settings", Toast.LENGTH_SHORT).show(); //pop up message to show that user click onto profile activity
                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT); //LoginActivity goes to the next screen which is the AlbumOneMainActivity
            }
        });

        btnTrending.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this,PopularMainActivity.class); //From Dashboard screen to PopularMainSong Activity
                        Toast.makeText(MainActivity.this, "You clicked onto Trending", Toast.LENGTH_SHORT).show(); //pop up message to show that user click onto profile activity
                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
        btnMusicLibrary.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this, LibraryActivity.class); //From Dashboard screen to Library
                        Toast.makeText(MainActivity.this, "You clicked onto Song Library", Toast.LENGTH_SHORT).show(); //pop up message to show that user click onto Library
                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });

        btnSearching.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this, SearchSongListActivity.class); //From Dashboard screen to Library
                        Toast.makeText(MainActivity.this, "You clicked onto Search", Toast.LENGTH_SHORT).show(); //pop up message to show that user click onto Library
                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(MainActivity.this, LibraryActivity.class); //From Dashboard screen to Library
                        Toast.makeText(MainActivity.this, "You have successfully logged out", Toast.LENGTH_SHORT).show(); //pop up message to show that user click onto Library
                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
            }

    }
