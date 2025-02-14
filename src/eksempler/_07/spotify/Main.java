package eksempler._07.spotify;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Program program = new Program();
        //program.run();

        //program.checkWriteToFile();

        File file = new File("files/norwayTop40.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<SpotifyChartEntry> entries = new ArrayList<>();
        while(scanner.hasNextLine()){
            SpotifyChartEntry entry = new SpotifyChartEntry();
            entry.setDate(LocalDate.parse("2025-02-12"));
            int position = Integer.parseInt(scanner.nextLine());
            entry.setPosition(position);
            String positionMovement = scanner.nextLine();
            entry.setPositionMovement(positionMovement);
            String artistAndTitle = scanner.nextLine();
            entry.setArtistAndTitle(artistAndTitle);
            int days = Integer.parseInt(scanner.nextLine());
            entry.setDaysOnChart(days);
            String chartPeak = scanner.nextLine();
            entry.setChartPeak(chartPeak);
            int streams = Integer.parseInt(removeCommas(scanner.nextLine()));
            entry.setStreams(streams);
            int streamsAdj = Integer.parseInt(removeCommas(scanner.nextLine()));
            entry.setStreamAdjustment(streamsAdj);
            int sevenDayStream = Integer.parseInt(removeCommas(scanner.nextLine()));
            entry.setStreamsSevenDays(sevenDayStream);
            int sevenDaysAdj = Integer.parseInt(removeCommas(scanner.nextLine()));
            entry.setStreamsSevenDaysAdjustment(sevenDaysAdj);
            int streamsTotal = Integer.parseInt(removeCommas(scanner.nextLine()));
            entry.setStreamsTotal(streamsTotal);
            entries.add(entry);
        }
        for (SpotifyChartEntry entry : entries) {
            System.out.println(entry);
        }


    }

    private static String removeCommas(String streamsAsText) {
        streamsAsText = streamsAsText.replaceAll(",", "");
        return streamsAsText;
    }
}
