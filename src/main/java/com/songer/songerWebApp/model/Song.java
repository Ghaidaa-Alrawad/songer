package com.songer.songerWebApp.model;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String songTitle;

    private int songLength;

    private int songTrackNumber;

    @ManyToOne
    private Album album;

    public Song(){}

    public Song(String songTitle, int songLength, int songTrackNumber, Album album) {
        this.songTitle = songTitle;
        this.songLength = songLength;
        this.songTrackNumber = songTrackNumber;
        this.album = album;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    public int getSongTrackNumber() {
        return songTrackNumber;
    }

    public void setSongTrackNumber(int songTrackNumber) {
        this.songTrackNumber = songTrackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
