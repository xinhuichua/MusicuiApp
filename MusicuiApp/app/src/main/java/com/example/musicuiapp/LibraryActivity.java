package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class LibraryActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    ImageView albumOne;
    ImageButton btnSearch, btnHits;
    ImageView albumTwo;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        btnSearch = findViewById(R.id.btnSearch);
        btnSettings = findViewById(R.id.btnSettings);
        btnHits = findViewById(R.id.btnHits);

        albumOne = findViewById(R.id.albumOne);
        albumTwo = findViewById(R.id.albumTwo);

        albumOne.setOnClickListener(new View.OnClickListener() //User click on the album it will go to song collection activity for this album
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(LibraryActivity.this, AlbumOneMainActivity.class); //This allows user login to go AlbumOneMainActivity

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //LoginActivity goes to the next screen which is the AlbumOneMainActivity
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() //User click on search icon to search for songs in library
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(LibraryActivity.this, SearchSongListActivity.class); //This allows user login to go AlbumOneMainActivity

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //LoginActivity goes to the next screen which is the AlbumOneMainActivity
            }
        });

        albumTwo.setOnClickListener(new View.OnClickListener() //User click on the album it will go to song collection activity for this album
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(LibraryActivity.this, AlbumTwoMainActivity.class); //Click on second album and will got songs in second album

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() //User click on the album it will go to song collection activity for this album
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(LibraryActivity.this, SettingsActivity.class); //From LibraryActivity to SettingsActivity

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
        btnHits.setOnClickListener(new View.OnClickListener() //User click on the album it will go to song collection activity for this album
        {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(LibraryActivity.this, PopularMainActivity.class); //From LibraryActivity to SettingsActivity

                        startActivity(homeIntent);

                        finish();
                    }


                }, SPLASH_TIME_OUT);
            }
        });
    }
}
