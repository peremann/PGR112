package loesninger._13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SongAnalyzerTest {
    SongAnalyzer songAnalyzer = new SongAnalyzer();
    private static List<SongPlayedEvent> songs;

    @Test
    public void testTotalAirPlay(){
        int answer = songAnalyzer.totalAirPlay(songs);
        assertEquals(168+168+130+162+157+769+616+616+257+616, answer);
    }

    @Test
    public void testTotalAirPlayPinkFloyd(){
        int answer = songAnalyzer.totalAirPlayForArtist(songs, "Pink Floyd");
        assertEquals(769+616+616+616, answer);
    }
    @Test
    public void testTotalAirPlayDummyBand(){
        int answer = songAnalyzer.totalAirPlayForArtist(songs, "DummyBand");
        assertEquals(0, answer);
    }

    @Test
    public void testTotalAirPlayMelisAlbum(){
        int answer = songAnalyzer.totalAirPlayForAlbum(songs, "Melis");
        assertEquals(168+168+157, answer);
    }
    @Test
    public void testTotalAirPlayDummyAlbum(){
        int answer = songAnalyzer.totalAirPlayForAlbum(songs, "DummyAlbum");
        assertEquals(0, answer);
    }

    @Test
    public void testSongsPlayedFromMelis(){
        List<String> melisSongs = songAnalyzer.allAlbumSongsPlayed(songs, "Melis");
        assertEquals(2, melisSongs.size());
    }
    @Test
    public void testSongsPlayedFromDummyAlbum(){
        List<String> dummySongs = songAnalyzer.allAlbumSongsPlayed(songs, "DummyAlbum");
        assertEquals(0, dummySongs.size());
    }

    @Test
    public void testUniqueSongsPlayedWithMaxLength200(){
        long answer = songAnalyzer.uniqueSongsPlayedWithMaxLength(songs, 200);
        assertEquals(4, answer);
    }
    @Test
    public void testUniqueSongsPlayedWithMaxLengthNegative(){
        long answer = songAnalyzer.uniqueSongsPlayedWithMaxLength(songs, -100);
        assertEquals(0, answer);
    }

    @Test
    public void testShortestSongPlayed(){
        Optional<Song> song = songAnalyzer.shortestSongPlayed(songs);
        assertEquals(130, song.get().getSeconds());
    }
    @Test
    public void testShortestSongPlayed_EmptyList(){
        Optional<Song> song = songAnalyzer.shortestSongPlayed(new ArrayList<>());
        assertTrue(song.isEmpty());
    }

    @Test
    public void testGetArbitrarySongPlayedWithinTimeFrame(){
        LocalDateTime ldt1 = LocalDateTime.parse("2024-02-06T19:50:45.349");
        LocalDateTime ldt2 = LocalDateTime.parse("2024-02-09T13:23:23.000");
        Optional<SongPlayedEvent> song = songAnalyzer.getArbitrarySongPlayedWithinTimeFrame(songs, ldt1, ldt2);
        assertFalse(song.isEmpty());
    }
    @Test
    public void testGetArbitrarySongPlayedWithinTimeFrameNoHit(){
        LocalDateTime ldt1 = LocalDateTime.parse("1999-02-06T12:23:23.000");
        LocalDateTime ldt2 = LocalDateTime.parse("2000-02-06T13:23:23.000");
        Optional<SongPlayedEvent> song = songAnalyzer.getArbitrarySongPlayedWithinTimeFrame(songs, ldt1, ldt2);
        assertTrue(song.isEmpty());
    }

    @Test
    public void testGetAllSongsPlayedOnSpecificDate(){
        List<SongPlayedEvent> songsPlayed = songAnalyzer.getAllSongsPlayedOnSpecificDate(songs, LocalDate.of(2024, 2, 6));
        assertEquals(3, songsPlayed.size());
    }
    @Test
    public void testGetAllSongsPlayedOnSpecificDateNoResult(){
        List<SongPlayedEvent> songsPlayed = songAnalyzer.getAllSongsPlayedOnSpecificDate(songs, LocalDate.of(1999, 2, 6));
        assertEquals(0, songsPlayed.size());
    }

    @Test
    public void testIsSongPlayedWithWordInTitle(){
        Optional<SongPlayedEvent> songPlayed = songAnalyzer.isSongPlayedWithWordInTitle(songs, "elastic");
        assertTrue(songPlayed.isPresent());
    }
    @Test
    public void testIsSongPlayedWithWordInTitleNoResult(){
        Optional<SongPlayedEvent> songPlayed = songAnalyzer.isSongPlayedWithWordInTitle(songs, "WordNotPresent");
        assertFalse(songPlayed.isPresent());
    }

    @Test
    public void testGetPlayedSongs(){
        List<Song> songsPlayed = songAnalyzer.getPlayedSongs(songs, 20, 200);
        assertEquals(3, songsPlayed.size());
    }
    @Test
    public void testGetPlayedSongsNoResult(){
        List<Song> songsPlayed = songAnalyzer.getPlayedSongs(songs, 2, 300);
        assertEquals(0, songsPlayed.size());
    }

    @BeforeAll
    public static void init(){
        songs = new ArrayList<>();
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-06T19:50:45.349"), new Song("Rock", "Postgirobygget", "Den andre siden av gjerdet", "Melis", 168)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-07T19:50:45.349"), new Song("Rock", "Postgirobygget", "Den andre siden av gjerdet", "Melis", 168)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-06T20:50:45.349"), new Song("Country", "Taylor Swift", "Should've Said No", "Taylor Swift", 130)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-06T21:50:45.349"), new Song("Country", "Taylor Swift", "I'm Only Me When I'm With You", "Taylor Swift", 162)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-08T13:50:45.349"), new Song("Rock", "Postgirobygget", "Fatter ikke hva jeg gjør galt", "Melis", 157)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-08T14:50:45.349"), new Song("Progressive rock", "Pink Floyd", "Money", "The Dark Side of the Moon", 769)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-08T19:50:45.349"), new Song("Progressive rock", "Pink Floyd", "Brain Damage", "The Dark Side of the Moon", 616)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-08T20:50:45.349"), new Song("Progressive rock", "Pink Floyd", "Brain Damage", "The Dark Side of the Moon", 616)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-09T13:50:45.349"), new Song("Electropop", "Sia", "Elastic Heart", "1000 Forms of Fear", 257)));
        songs.add(new SongPlayedEvent(LocalDateTime.parse("2024-02-09T19:50:45.349"), new Song("Progressive rock", "Pink Floyd", "Brain Damage", "The Dark Side of the Moon", 616)));
    }

}
