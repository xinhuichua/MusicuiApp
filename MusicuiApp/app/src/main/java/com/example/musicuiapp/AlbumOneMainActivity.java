package com.example.musicuiapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.musicuiapp.util.AppUtil;

public class AlbumOneMainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    ListView listView;
    ImageButton btnSearch;
    ImageButton btnBack;
    Button btnSettings;


    private AlbumOneCollectionActivity albumOneCollectionActivity = new AlbumOneCollectionActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_one_main);
        btnBack = findViewById(R.id.btnBack);
        //listView = findViewById((R.id.listView));
        btnSearch = findViewById(R.id.btnSearch);
        btnSettings = findViewById(R.id.btnSettings);

        btnSearch.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(AlbumOneMainActivity.this, SearchSongListActivity.class); //This allows user login to go AlbumOneMainActivity

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //LoginActivity goes to the next screen which is the AlbumOneMainActivity
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(AlbumOneMainActivity.this, LibraryActivity.class); //This allows user login to go back to library after pressing ont he back button

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //AlbumOneMainActivity goes to the next screen which is the LibraryActivity
            }
        });


    }


    public void handleSelection(View view) {
        //1. Get the ID of the selected song
        String resourceId = AppUtil.getResourceId(this, view);

        //2. Search for the selected album based on the ID so that all information/data of
        //the album can be retrieved from album Song collection
        Song selectedSong = albumOneCollectionActivity.searchById(resourceId);

        // 3.Popup a message on the screen to show the title of the song.
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

        sendDataToActivity(selectedSong);

    }

    public void sendDataToActivity(Song song) {
        //1.create Intent to go to play song class
        Intent intent = new Intent(this, AlbumOnePlaySongActivity.class);

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


