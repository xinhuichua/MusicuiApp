package com.example.musicuiapp;

import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AlbumTwoCollectionActivity {
    public Song[] songs = new Song[5];

    public AlbumTwoCollectionActivity() {
        prepareSongs();

    }

    public void prepareSongs() {
        Song alwaysyou = new Song(
                "S1008",
                "Always You",
                "ASTRO",
                "Playing from RISE UP",
                "d8ac0ca66002d3d3208027c992ae278c5a04bfaa?cid=2afe87a64b0042dabf51f37318616965",
                3.73,
                "astro_riseup_album"
        );

        Song byyourside = new Song(
                "S1009",
                "By Your Side",
                "ASTRO",
                "Playing from RISE UP",
                "869ccb5f4c8d18be2ba712368a620a2f96916086?cid=2afe87a64b0042dabf51f37318616965",
                3.41,
                "astro_riseup_album"
        );

        Song callOut = new Song(
                "S1010",
                "Call Out",
                "ASTRO",
                "Playing from RISE UP",
                "58b83314f17f2b7f384ea26cc1ba8c3ea42d6015?cid=2afe87a64b0042dabf51f37318616965",
                3.56,
                "astro_riseup_album"

        );
        Song stayWithme = new Song(
                "S1011",
                "Stay With Me",
                "ASTRO",
                "Playing from RISE UP",
                "dc0badaf645b1049c5805f566fd16b848557dfa3?cid=2afe87a64b0042dabf51f37318616965",
                3.68,
                "astro_riseup_album"

        );
        Song reallove = new Song(
                "S1012",
                "Real Love",
                "ASTRO",
                "Playing from RISE UP",
                "9b98a252b5ec6c0c0206c72aefded2b06dbd807b?cid=2afe87a64b0042dabf51f37318616965",
                3.72,
                "astro_riseup_album"

        );


        songs[0] = alwaysyou;
        songs[1] = byyourside;
        songs[2] = callOut;
        songs[3] = stayWithme;
        songs[4] = reallove;

    }

    public Song searchById(String id) {
        //1. define a variable
        Song song = null; // we use null to represent nth

        //travel the array, search for ID
        for (int index = 0; index < songs.length; index++) {
            song = songs[index];

            if (song.getId().equals(id)) {
                //found matching id
                return song;
            }
        }
        //nothing found return null
        return null;


    }

    public Song getNextSong(String currentSongId) {

        Song song = null;
        for (int index = 0; index < songs.length; index++) {
            String tempSongId = songs[index].getId();

            if (tempSongId.equals(currentSongId) && (index < songs.length - 1)) {
                song = songs[index + 1];

                break;

            }

        }
        return song;
    }

    public Song getPreviousSong(String currentSongId) {

        Song song = null;
        for (int index = 4; index < songs.length; index--) {
            String tempSongId = songs[index].getId();

            if (tempSongId.equals(currentSongId) && (index < songs.length + 1)) {
                song = songs[index - 1];

                break;


            }

        }
        return song;
    }


    public Song getShuffleSong(String currentSongId) {

        final int maximum = songs.length - 1;
        final int minimum = 0;
        final int random = new Random().nextInt((maximum - minimum) + 1);

        Song song = null;

        song = songs[random];
        return song;

    }

}




