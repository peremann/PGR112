package loesninger._13;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SongReader reader = new SongReader();
        List<SongPlayedEvent> songsPlayed = reader.readSongsFromFile("files/songsPlayed.txt");
        SongAnalyzer songAnalyzer = new SongAnalyzer();
        int totalAirPlay = songAnalyzer.totalAirPlay(songsPlayed);
        // Added some use of printf and a seconds converter.
        System.out.printf("Total airplay: %s%n",secondConvert(totalAirPlay));
        int airPlayPostgirobygget = songAnalyzer.totalAirPlayForArtist(songsPlayed, "Postgirobygget");
        System.out.printf("Airplay PGB: %s%n",secondConvert(airPlayPostgirobygget));
        int airPlayTaylorSwift = songAnalyzer.totalAirPlayForAlbum(songsPlayed, "Taylor Swift");
        System.out.printf("Airplay Taylor Swift: %s%n",secondConvert(airPlayTaylorSwift));
        List<String> songsPlayedOnThriller = songAnalyzer.allAlbumSongsPlayed(songsPlayed, "Thriller");
        System.out.println("Thriller songs played:");
        songsPlayedOnThriller.forEach(System.out::println);
        long nrOfSongs = songAnalyzer.uniqueSongsPlayedWithMaxLength(songsPlayed, 100);
        System.out.println("Songs within max length:"+nrOfSongs);
        Optional<Song> shortestSong = songAnalyzer.shortestSongPlayed(songsPlayed);
        System.out.println("Shortest song:");
        shortestSong.ifPresent(System.out::println);
        LocalDateTime ldt1 = LocalDateTime.parse("2024-02-06T12:23:23.000");
        LocalDateTime ldt2 = LocalDateTime.parse("2024-02-06T13:23:23.000");
        Optional<SongPlayedEvent> songPlayed = songAnalyzer.getArbitrarySongPlayedWithinTimeFrame(songsPlayed, ldt1, ldt2);
        System.out.println("Song played within time frame:");
        songPlayed.ifPresent(System.out::println);
        System.out.println("Songs played on Feb. sixth:");
        List<SongPlayedEvent> songOnSpecificDate = songAnalyzer.getAllSongsPlayedOnSpecificDate(songsPlayed, LocalDate.of(2024, 2, 6));
        songOnSpecificDate.forEach(System.out::println);
        Optional<SongPlayedEvent> possibleSongPlayed = songAnalyzer.isSongPlayedWithWordInTitle(songsPlayed, "elastic");
        System.out.println("Song played with Elastic in title:");
        possibleSongPlayed.ifPresent(System.out::println);
        List<Song> songList = songAnalyzer.getPlayedSongs(songsPlayed, 12, 300);
        System.out.println("Song played with max title length 12 and minSongLength 300:");
        songList.forEach(System.out::println);
    }

    /*
    Added a seconds converter for convenience
     */
    private static String secondConvert(int seconds){
        long hours = TimeUnit.SECONDS.toHours(seconds);
        long minutes = TimeUnit.SECONDS.toMinutes(seconds) -
                (hours*60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) -
                (minutes*60)- (hours*60*60);
        return String.format("%s Hours, %s Minutes, %s Seconds", hours, minutes, second);
    }
}

