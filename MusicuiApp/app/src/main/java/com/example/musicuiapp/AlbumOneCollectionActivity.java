package com.example.musicuiapp;

import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AlbumOneCollectionActivity {
    public Song[] songs = new Song[7];

    public AlbumOneCollectionActivity() {
        prepareSongs();

    }

    public void prepareSongs() {
        Song introPersona = new Song(
                "S1001",
                "Intro: Persona",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "cdb39e2a244c28523e6f34fc686a15251d2a03a6?cid=2afe87a64b0042dabf51f37318616965",
                2.85,
                "bts_persona_album"
        );

        Song boyWithLuv = new Song(
                "S1002",
                "Boy With Luv",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "d16797fb391fb909f3c46454d7cf89a2718f8171?cid=2afe87a64b0042dabf51f37318616965",
                3.83,
                "bts_persona_album"
        );

        Song makeItRight = new Song(
                "S1003",
                "Make Me Right",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "27d07e11fef56c0f8cb8a7e77a445e7371971ea5?cid=2afe87a64b0042dabf51f37318616965",
                3.77,
                "bts_persona_album"

        );
        Song mikrokosmos = new Song(
                "S1004",
                "Mikrokosmos",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "3f29d0aa131984a690e3cc10629b2faa2303e69c?cid=2afe87a64b0042dabf51f37318616965",
                3.74,
                "bts_persona_album"

        );
        Song dionysus = new Song(
                "S1005",
                "Dionysus",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "a862e818956230137be205f8d69aac014361f554?cid=2afe87a64b0042dabf51f37318616965",
                4.15,
                "bts_persona_album"

        );
        Song jamiasvu = new Song(
                "S1006",
                "Jamais Vu",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "698f1a4a1767f3ea64e40b04d9be33d923b8f827?cid=2afe87a64b0042dabf51f37318616965",
                3.79,
                "bts_persona_album"

        );
        Song home = new Song(
                "S1007",
                "HOME",
                "BTS",
                "Playing from MAP OF THE SOUL : PERSONA",
                "9fb02e3c757ce10d6dc027ca750a94143e9e3dc2?cid=2afe87a64b0042dabf51f37318616965",
                3.90,
                "bts_persona_album"

        );



        songs[0] = introPersona;
        songs[1] = boyWithLuv;
        songs[2] = makeItRight;
        songs[3] = mikrokosmos;
        songs[4] = dionysus;
        songs[5] = jamiasvu;
        songs[6] = home;

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
        for (int index = 11; index < songs.length; index--) {
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




