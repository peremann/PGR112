package loesninger._13;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SongReader {
    List<SongPlayedEvent> songsPlayed = new ArrayList<>();
    List<Song> songs = new ArrayList<>();
    public List<SongPlayedEvent> readSongsFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<SongPlayedEvent> songs = new ArrayList<>();
        while(scanner.hasNextLine()){
            LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
            String genre = scanner.nextLine();
            String artist = scanner.nextLine();
            String songTitle = scanner.nextLine();
            String albumTitle = scanner.nextLine();
            int seconds = Integer.parseInt(scanner.nextLine());
            scanner.nextLine(); // reading separator
            songs.add(new SongPlayedEvent(time, new Song(genre, artist, songTitle, albumTitle, seconds)));
        }
        return songs;
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
    public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


}
