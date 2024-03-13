package com.example.musicuiapp;

import android.widget.SeekBar;

public class Song {
    private String id;
    private String title;
    private String artist;
    private String album;
    private String fileLink;
    private double songLength;
    private String coverArt;


    public Song(String _id, String _title, String _artist, String _album, String _fileLink, double _songLength, String _coverArt) {
        this.id = (_id);
        this.title = (_title);
        this.artist = (_artist);
        this.album = (_album);
        this.fileLink = (_fileLink);
        this.setSongLength(_songLength);
        this.setCoverArt(_coverArt);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setArtist(String _artist) {
        this.artist = _artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }

    public double getSongLength() {
        return this.songLength;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }
}



