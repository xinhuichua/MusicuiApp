package com.example.musicuiapp;

import java.util.Random;

public class PopularSongCollection {
    public Song[] songs = new Song[4];

    public PopularSongCollection() {
        prepareSongs();

    }

    public void prepareSongs() {
        Song imSotired = new Song(
                "S1013",
                "i'm so tired...",
                "LAUV",
                "Playing from Top Hits",
                "c066ee13f04cb53b3b5033079f06200a44b18cf1?cid=2afe87a64b0042dabf51f37318616965",
                2.71,
                "lauv_album"
        );

        Song iDontcare = new Song(
                "S1014",
                "I Don't Care",
                "Ed Sheeran ft. Justin Bieber",
                "Playing from Top Hits",
                "40d2bf0a16b4a4c7e5747a57943f9c0bbf5bc5ab?cid=2afe87a64b0042dabf51f37318616965",
                3.67,
                "edsheeran_idontcare"
        );

        Song onMyway = new Song(
                "S1015",
                "On My Way",
                "Alan Walker",
                "Playing from Top Hits",
                "a2b7d391b7082492253beea21178df5557a4f9bf?cid=2afe87a64b0042dabf51f37318616965",
                3.23,
                "alanwalker_album"

        );
        Song fallingLikethestars = new Song(
                "S1016",
                "Falling like the Stars",
                "James Arthur",
                "Playing from Top Hits",
                "07122d8ecd5fbec4e57fab791d86df8e9e5aaa82?cid=2afe87a64b0042dabf51f37318616965",
                3.55,
                "jamesarthur_album"

        );




        songs[0] = imSotired;
        songs[1] = iDontcare;
        songs[2] = onMyway;
        songs[3] = fallingLikethestars;

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
        for (int index = 3; index < songs.length; index--) {
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