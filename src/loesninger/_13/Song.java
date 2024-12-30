package loesninger._13;

import java.util.Objects;

public class Song {
    private String genre;
    private String artist;
    private String songTitle;
    private String albumTitle;
    private int seconds;

    public Song(String genre, String artist, String songTitle, String albumTitle, int seconds) {
        this.genre = genre;
        this.artist = artist;
        this.songTitle = songTitle;
        this.albumTitle = albumTitle;
        this.seconds = seconds;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return seconds == song.seconds && Objects.equals(genre, song.genre) && Objects.equals(artist, song.artist) && Objects.equals(songTitle, song.songTitle) && Objects.equals(albumTitle, song.albumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, artist, songTitle, albumTitle, seconds);
    }

    @Override
    public String toString() {
        return "Song{" +
                "genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", seconds=" + seconds +
                '}';
    }
}
