package com.sddevops.jenkins_maven.eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SongCollectionTest {
    private SongCollection sc;
    private Song s1;
    private Song s2;
    private Song s3;
    private Song s4;
    private final int SONG_COLLECTION_SIZE = 4;

    @BeforeEach
    void setUp() throws Exception {
        sc = new SongCollection();
        s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
        s3 = new Song("003", "MONTERO", "Lil Nas X", 2.3);
        s4 = new Song("004", "bad guy", "Billie Eilish", 3.14);
        sc.addSong(s1);
        sc.addSong(s2);
        sc.addSong(s3);
        sc.addSong(s4);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Clean up after each test
    }

    @Test
    void testAddSong() {
        // Assert that Song Collection has 4 songs initially
        assertEquals(SONG_COLLECTION_SIZE, sc.getSongs().size());
        
        // Act: Add another song
        Song newSong = new Song("005", "Levitating", "Dua Lipa", 3.23);
        sc.addSong(newSong);
        
        // Assert that Song Collection has 5 songs now
        assertEquals(SONG_COLLECTION_SIZE + 1, sc.getSongs().size());
    }

    @Test
    void testSortSongsByTitle() {
        // Sort by title
        sc.sortSongsByTitle();
        List<Song> sortedSongs = sc.getSongs();

        // Debugging: Print the sorted song titles to check their order
        System.out.println("Sorted Songs by Title:");
        for (Song song : sortedSongs) {
            System.out.println(song.getTitle());
        }

        // Assert that the list is sorted by title alphabetically (case-insensitive)
        assertEquals("bad guy", sortedSongs.get(0).getTitle(), "First song should be 'bad guy'");
        assertEquals("good 4 u", sortedSongs.get(1).getTitle(), "Second song should be 'good 4 u'");
        assertEquals("MONTERO", sortedSongs.get(2).getTitle(), "Third song should be 'MONTERO'");
        assertEquals("Peaches", sortedSongs.get(3).getTitle(), "Fourth song should be 'Peaches'");
    }

    @Test
    void testSortSongsBySongLength() {
        // Sort by song length
        sc.sortSongsBySongLength();
        List<Song> sortedSongs = sc.getSongs();
        
        // Assert that the songs are sorted by length in ascending order
        assertEquals(2.3, sortedSongs.get(0).getSongLength(), "First song should have the shortest length");
        assertEquals(3.14, sortedSongs.get(1).getSongLength(), "Second song should be the second shortest");
        assertEquals(3.18, sortedSongs.get(2).getSongLength(), "Third song should be the third shortest");
        assertEquals(3.59, sortedSongs.get(3).getSongLength(), "Fourth song should have the longest length");
    }

    @Test
    void testFindSongsById() {
        // Test find song by ID
        Song foundSong = sc.findSongsById("002");
        assertEquals(s2, foundSong, "The song with ID '002' should be 'Peaches' by Justin Bieber");
    }

    @Test
    void testFindSongByTitle() {
        // Test find song by title
        Song foundSong = sc.findSongByTitle("MONTERO");
        assertEquals(s3, foundSong, "The song with title 'MONTERO' should be by Lil Nas X");
    }

    @Test
    void testSetSongLength() {
        // Arrange
        Song song = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        
        // Act
        song.setSongLength(4.0); // Update the song length
        
        // Assert
        assertEquals(4.0, song.getSongLength(), "The song length should be updated to 4.0");
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        Song song1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        Song song2 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        
        // Act & Assert
        assertTrue(song1.equals(song2), "The songs should be equal because they have the same id, title, artist, and songLength.");
        assertEquals(song1.hashCode(), song2.hashCode(), "The hash codes should be the same for two equal songs.");
    }

    @Test
    void testSetTitleAndArtist() {
        // Arrange
        Song song = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
        
        // Act
        song.setTitle("bad guy");
        song.setArtist("Billie Eilish");
        
        // Assert
        assertEquals("bad guy", song.getTitle(), "The title should be updated to 'bad guy'");
        assertEquals("Billie Eilish", song.getArtist(), "The artist should be updated to 'Billie Eilish'");
    }
}
