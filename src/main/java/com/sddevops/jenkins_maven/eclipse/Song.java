package com.sddevops.jenkins_maven.eclipse;

import java.util.Comparator;
import java.util.Objects;

public class Song {
    
    private String id;
    private String title;
    private String artist; // Changed from 'artiste' to 'artist'
    private double songLength;

    // Constructor
    public Song(String id, String title, String artist, double songLength) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songLength = songLength;
    }

    // Getter and setter methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() { // Renamed from getArtiste to getArtist
        return artist;
    }

    public void setArtist(String artist) { // Renamed from setArtiste to setArtist
        this.artist = artist;
    }

    public double getSongLength() {
        return songLength;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }

    // Override equals and hashCode for proper comparison

    @Override
    public int hashCode() {
        return Objects.hash(artist, id, songLength, title); // Changed from 'artiste' to 'artist'
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song other = (Song) obj;
        return Objects.equals(artist, other.artist) && Objects.equals(id, other.id)
                && Double.doubleToLongBits(songLength) == Double.doubleToLongBits(other.songLength)
                && Objects.equals(title, other.title); // Changed 'artiste' to 'artist'
    }

    // Comparator for sorting by title (case-insensitive)
    public static Comparator<Song> titleComparator = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return s1.getTitle().compareToIgnoreCase(s2.getTitle()); // Case-insensitive comparison
        }
    };

    // Comparator for sorting by song length
    public static Comparator<Song> songLengthComparator = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return Double.compare(s1.getSongLength(), s2.getSongLength()); // Use Double.compare for correct ordering
        }
    };
}
