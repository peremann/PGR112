package loesninger._13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongAnalyzer {
    /**
     * Returns the total amount of playing time for all songs haven been played.
     * @param songsPlayed the songs played
     * @return the total amount of playing time for all songs haven been played.
     */
    public int totalAirPlay(List<SongPlayedEvent> songsPlayed){
        //return songsPlayed.stream().reduce(0, (partialResult, song) ->partialResult + song.getSong().getSeconds(), Integer::sum);
        return songsPlayed.stream()
                .map(s->s.getSong().getSeconds())
                .reduce(0, Integer::sum);
    }

    /**
     * Returns the total amount of playing time for songs from specific artist.
     * @param songsPlayed all songs played
     * @param artist the artist to look for
     * @return the total amount of playing time for songs from specific artist
     */
    public int totalAirPlayForArtist(List<SongPlayedEvent> songsPlayed, String artist){
        return songsPlayed.stream()
                .filter(s->s.getSong().getArtist().equalsIgnoreCase(artist))
                .map(s->s.getSong().getSeconds())
                .reduce(0, Integer::sum);
    }

    /**
     * Returns the total amount of playing time for songs from specific album.
     * @param songsPlayed all songs played
     * @param album the album to look for
     * @return the total amount of playing time for songs from specific album
     */
    public int totalAirPlayForAlbum(List<SongPlayedEvent> songsPlayed, String album){
        return songsPlayed.stream()
                .filter(s->s.getSong().getAlbumTitle().equalsIgnoreCase(album))
                .map(s->s.getSong().getSeconds())
                .reduce(0, Integer::sum);
    }

    /**
     * Returns a list of song titles from specific album present in list of played songs
     *
     * @param songsPlayed the played songs to look through
     * @param album       the album to look for
     * @return a unique list of title of played songs found on album
     */
    public List<String> allAlbumSongsPlayed(List<SongPlayedEvent> songsPlayed, String album){
        return songsPlayed.stream()
                .filter(s->s.getSong().getAlbumTitle().equalsIgnoreCase(album))
                .map((song->song.getSong().getSongTitle()))
                .distinct()
                .toList();
    }

    /**
     * Returns the number of unique songs, in list of played songs, within a maximum length
     *
     * @param songsPlayed the played songs to look through
     * @param maxLength  the maximum length of the song (in seconds)
     * @return the number of unique songs played within the maximum length
     */
    public long uniqueSongsPlayedWithMaxLength(List<SongPlayedEvent> songsPlayed, int maxLength){
        return songsPlayed.stream()
                .map(SongPlayedEvent::getSong)
                .distinct()
                .filter(s->s.getSeconds()<=maxLength)
                .count();
    }

    /**
     * Returns the played song with the shortest length
     *
     * @param songsPlayed the played songs to look through
     * @return the shortest song played (if found)
     */
    public Optional<Song> shortestSongPlayed(List<SongPlayedEvent> songsPlayed){
        return songsPlayed.stream()
                .map(SongPlayedEvent::getSong)
                .distinct()
                .min(Comparator.comparingInt(Song::getSeconds));
    }

    /**
     * Returns a song played within time frame
     *
     * @param songsPlayed the played songs to look through
     * @param start the start of time frame
     * @param end the end of time frame
     * @return a song played within time frame (if found)
     */
    public Optional<SongPlayedEvent> getArbitrarySongPlayedWithinTimeFrame(List<SongPlayedEvent> songsPlayed, LocalDateTime start, LocalDateTime end){
        return songsPlayed.stream()
                .filter(s->s.getTime()
                        .isAfter(start) && s.getTime()
                        .isBefore(end))
                .findAny();
    }

    /**
     * Returns all songs played on a specific date
     *
     * @param songsPlayed the played songs to look through
     * @param date the date to look for
     * @return all songs played on a specific date
     */
    public List<SongPlayedEvent> getAllSongsPlayedOnSpecificDate(List<SongPlayedEvent> songsPlayed, LocalDate date){
        return songsPlayed.stream()
                .filter(s->s.getTime().toLocalDate().isEqual(date))
                .toList();
    }

    /**
     * Checks if song with word in title has been played (case-insensitive)
     *
     * @param songsPlayed the played songs to look through
     * @param word the word to look for in title
     * @return a songs with word in title (if found)
     */
    public Optional<SongPlayedEvent> isSongPlayedWithWordInTitle(List<SongPlayedEvent> songsPlayed, String word){
        return songsPlayed.stream()
                .filter(s->s.getSong().getSongTitle().toLowerCase().contains(word.toLowerCase()))
                .findAny();
    }

    /**
     * Get played songs adhering to title and length restrictions
     *
     * @param songsPlayed the played songs to look through
     * @param maxTitleLength the maximum number of characters in song title
     * @param minSongLength the minimum song length (in seconds)
     * @return the unique songs adhering to title and length restrictions
     */
    public List<Song> getPlayedSongs(List<SongPlayedEvent> songsPlayed, int maxTitleLength, int minSongLength){
        return songsPlayed.stream()
                .map(SongPlayedEvent::getSong)
                .distinct()
                .filter(song -> song.getSongTitle().length()<=maxTitleLength)
                .filter(song -> song.getSeconds()>=minSongLength)
                .toList();
    }
}
