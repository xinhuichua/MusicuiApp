package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.musicuiapp.util.AppUtil;

public class PopularMainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    ListView listView;
    ImageButton btnSearch, btnLibrary;


    private PopularSongCollection popularSongCollection = new PopularSongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_main);
        //listView = findViewById((R.id.listView));
        btnSearch = findViewById(R.id.btnSearch);
        btnLibrary = findViewById(R.id.btnLibrary);
        btnSearch.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(PopularMainActivity.this, SearchSongListActivity.class); //User can search for songs.

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //
            }
        });
        btnLibrary.setOnClickListener(new View.OnClickListener() //this method allows us to be able to tap on the library icon
        {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(PopularMainActivity.this, LibraryActivity.class); //Once user press on the library button,user will go to library

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //
            }
        });

    }


    public void handleClick(View view) {
        //1. Get the ID of the selected song
        String resourceId = AppUtil.getResourceId(this, view);

        //2. Search for the selected album based on the ID so that all information/data of
        //the album can be retrieved from album Song collection
        Song selectedSong = popularSongCollection.searchById(resourceId);

        // 3.Popup a message on the screen to show the title of the song.
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

        sendDataToActivity(selectedSong);

    }

    public void sendDataToActivity(Song song) {
        //1.create Intent to go to play song class
        Intent intent = new Intent(this,PopularPlaySongActivity.class);

        //set value
        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artist", song.getArtist());
        intent.putExtra("album", song.getAlbum());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());


        //start activity
        startActivity(intent);


    }


}

