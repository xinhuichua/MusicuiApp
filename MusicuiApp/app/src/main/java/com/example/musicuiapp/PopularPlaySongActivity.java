package com.example.musicuiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicuiapp.util.AppUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class PopularPlaySongActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";

    private String songId = "";
    private String title = "";
    private String artist = "";
    private String album = "";
    private String fileLink = "";
    private String coverArt = "";
    private String url = "";
    private Handler mHandler = new Handler();
    private int SPLASH_TIME_OUT = 2000;


    //This is the built in MediaPlayer Object that we will use
    //to play music
    private MediaPlayer player = null;

    //This is the position of the song in playback
    //we set it to 0 here so that it starts at the beginning.
    private int musicPosition = 0;

    //We need to create an instance of the AlbumOneCollectionActivity object
    //so that we can get the next and previous song.
    private PopularSongCollection popularSongCollection = new PopularSongCollection();


    private SeekBar songSeekBar;


    Button btnNext, btnPrevious, btnPlay, btnShuffle, btnLoop;
    ImageButton btnBack, btnShare;
    TextView txtSongTitle;
    TextView txtArtist;
    TextView txtAlbum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_two_play_song);

        btnPlay = findViewById(R.id.btnPlay);

        setTitle(" Now Playing: " + title + " - " + artist);


        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnShuffle = (Button) findViewById(R.id.btnShuffle);
        btnLoop = (Button) findViewById(R.id.btnLoop);
        songSeekBar = (SeekBar) findViewById(R.id.songSeekBar);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnShare = (ImageButton) findViewById(R.id.btnShare);




        txtSongTitle = (TextView) findViewById(R.id.txtSongTitle);
        txtArtist = (TextView) findViewById(R.id.txtArtist);
        txtAlbum = (TextView) findViewById(R.id.txtAlbum);


        retrieveData();
        displaySong(title, album, artist, coverArt);

        btnBack.setOnClickListener(new View.OnClickListener() //after user key in sign up details, the screen will proceed to AlbumOneMainActivity
        {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent homeIntent = new Intent(PopularPlaySongActivity.this, PopularMainActivity.class); //This allows user login to go back to library after pressing ont he back button

                        startActivity(homeIntent);

                        finish(); //
                    }


                }, SPLASH_TIME_OUT); //AlbumOneMainActivity goes to the next screen which is the LibraryActivity
            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_SEND); //share your music
                myIntent.setType("text/plain");
                // String shareBody = ""
                String shareSub = "Musicui";
                // myIntent.putExtra(Intent.EXTRA_TEXT.shareBody);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));

            }
        });


    }


    private void retrieveData() {
        Bundle songData = this.getIntent().getExtras();
        songId = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        album = songData.getString("album");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");

        url = BASE_URL + fileLink;
    }

    private void displaySong(String title, String album, String artist, String coverArt) {
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);

        TextView txtAlbum = findViewById(R.id.txtAlbum);
        txtAlbum.setText(album);

        TextView txtArtist = findViewById(R.id.txtArtist);
        txtArtist.setText(artist);

        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);
        ImageView ivCoverArt = findViewById(R.id.imgCoverArt);
        ivCoverArt.setImageResource(imageId);


    }


    private void preparePlayer() {
        player = new MediaPlayer();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {   //mp > { = new Mediaplayer PreparedListener
                mp.start();
                songSeekBar.setMax(player.getDuration());
                songSeekBar.postDelayed(mUpdateSeekbar, 0);
                songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            if (player != null) {
                                player.seekTo(progress);
                            }
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btnPlay.setBackgroundResource(R.drawable.icons_play);

            }
        });
        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Runnable mUpdateSeekbar = new Runnable() {
        @Override
        public void run() {
            if (player != null) { // ! = not//
                songSeekBar.setProgress(player.getCurrentPosition());
                songSeekBar.postDelayed(this, 50);  // 50(in milliseconds) how fast it updates the seekbar to update the time elapsed in the song
            }
        }
    };


    public void playOrPauseMusic(View view) {
        if (player == null) {
            preparePlayer();
        }

        if (!player.isPlaying()) {
            if (musicPosition > 0) ;
            {
                player.seekTo(musicPosition);
            }

            player.start();
            //play button change to pause
            //int imageid = AppUtil.getImageIdFromDrawable(this, play);//(this,filename)
            btnPlay.setBackgroundResource(R.drawable.icons_pause);


            setTitle("Now Playing: " + title + " - " + artist);

            gracefullyStopWhenMusicEnd();
        } else {
            pauseMusic();
        }
    }


    private void pauseMusic() {
        player.pause();
        musicPosition = player.getCurrentPosition();
        // change pause to play
        btnPlay.setBackgroundResource(R.drawable.icons_play);


    }


    private void gracefullyStopWhenMusicEnd() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopActivities();
            }
        });
    }

    private void stopActivities() {
        if (player != null) {
            player.stop();
            player.release();

            player = null;

            btnPlay.setBackgroundResource(R.drawable.icons_play);


        }

    }

    public void playNext(View view) {
        Song nextSong = popularSongCollection.getNextSong(songId);

        if (nextSong != null) {
            songId = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFileLink();
            coverArt = nextSong.getCoverArt();

            url = BASE_URL + fileLink;

            displaySong(title, album, artist, coverArt);

            stopActivities();

            playOrPauseMusic(view);
        }

    }

    public void playPrevious(View view) {
        Song prevSong = popularSongCollection.getPreviousSong(songId);
        if (prevSong != null) {
            songId = prevSong.getId();
            title = prevSong.getTitle();
            artist = prevSong.getArtist();
            album = prevSong.getAlbum();
            fileLink = prevSong.getFileLink();
            coverArt = prevSong.getCoverArt();

            url = BASE_URL + fileLink;

            displaySong(title, album, artist, coverArt);

            stopActivities();

            playOrPauseMusic(view);


        }
    }

    public void playShuffle(View view) {
        Song shuffleSong = popularSongCollection.getShuffleSong(songId);
        if (shuffleSong != null) {
            songId = shuffleSong.getId();
            title = shuffleSong.getTitle();
            artist = shuffleSong.getArtist();
            album = shuffleSong.getAlbum();
            fileLink = shuffleSong.getFileLink();
            coverArt = shuffleSong.getCoverArt();

            btnShuffle.setBackgroundResource(R.drawable.icon_shufflegreen);

            url = BASE_URL + fileLink;

            displaySong(title, album, artist, coverArt);

            stopActivities();


            playOrPauseMusic(view);

        } else{


            btnShuffle.setBackgroundResource(R.drawable.icon_shuffle);

        }
    }

    private boolean flag = false;


    public void playLoop(View view) {

        if (flag) {
            player.setLooping(false);
            btnLoop.setBackgroundResource(R.drawable.icons_repeat);
        } else {

            player.setLooping(true);
            btnLoop.setBackgroundResource(R.drawable.icons_repeatone);

        }
        flag = !flag;

    }
}