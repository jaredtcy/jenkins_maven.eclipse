package com.sddevops.jenkins_maven.eclipse;

import java.util.*;

public class SongCollection {

    private ArrayList<Song> songs = new ArrayList<>();
    private int capacity;

    // Default constructor initializes with a capacity of 20
    public SongCollection() {
        this.capacity = 20;
    }

    // Constructor that accepts a capacity parameter
    public SongCollection(int capacity) {
        this.capacity = capacity;
    }

    // Getter for the list of songs
    public List<Song> getSongs() {
        return songs;
    }

    // Add a song to the collection if the size is less than capacity
    public void addSong(Song song) {
        if (songs.size() < capacity) {  // Check if the collection is not full
            songs.add(song);
        }
    }

    // Sort songs by title using the Song's title comparator
    public ArrayList<Song> sortSongsByTitle() {
        // Case-insensitive sorting by title
        Collections.sort(songs, Song.titleComparator);
        return songs;
    }

    // Sort songs by song length using the Song's song length comparator
    public ArrayList<Song> sortSongsBySongLength() {
        Collections.sort(songs, Song.songLengthComparator);
        return songs;
    }

    // Find a song by its ID
    public Song findSongsById(String id) {
        for (Song s : songs) {
            if (s.getId().equals(id)) return s;
        }
        return null;  // Return null if no song is found
    }

    // Find a song by its title
    public Song findSongByTitle(String title) {
        for (Song s : songs) {
            if (s.getTitle().equals(title)) return s;
        }
        return null;  // Return null if no song is found
    }
}
