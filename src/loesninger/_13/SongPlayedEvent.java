package loesninger._13;

import java.time.LocalDateTime;
import java.util.Objects;

public class SongPlayedEvent {
     private LocalDateTime time;
     private Song song;

    public SongPlayedEvent(LocalDateTime time, Song song) {
        this.time = time;
        this.song = song;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongPlayedEvent that = (SongPlayedEvent) o;
        return Objects.equals(time, that.time) && Objects.equals(song, that.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, song);
    }

    @Override
    public String toString() {
        return "SongPlayedEvent{" +
                "time=" + time +
                ", song=" + song +
                '}';
    }
}
