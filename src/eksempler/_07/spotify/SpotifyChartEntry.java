package eksempler._07.spotify;

import java.time.LocalDate;

public class SpotifyChartEntry {
    private LocalDate date;
    private int position;
    private String positionMovement;
    private String artistAndTitle;
    private int daysOnChart;
    private String chartPeak;
    private int streams;
    private int streamAdjustment;
    private int streamsSevenDays;
    private int streamsSevenDaysAdjustment;
    private int streamsTotal;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPositionMovement() {
        return positionMovement;
    }

    public void setPositionMovement(String positionMovement) {
        this.positionMovement = positionMovement;
    }

    public String getArtistAndTitle() {
        return artistAndTitle;
    }

    public void setArtistAndTitle(String artistAndTitle) {
        this.artistAndTitle = artistAndTitle;
    }

    public int getDaysOnChart() {
        return daysOnChart;
    }

    public void setDaysOnChart(int daysOnChart) {
        this.daysOnChart = daysOnChart;
    }

    public String getChartPeak() {
        return chartPeak;
    }

    public void setChartPeak(String chartPeak) {
        this.chartPeak = chartPeak;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    public int getStreamAdjustment() {
        return streamAdjustment;
    }

    public void setStreamAdjustment(int streamAdjustment) {
        this.streamAdjustment = streamAdjustment;
    }

    public int getStreamsSevenDays() {
        return streamsSevenDays;
    }

    public void setStreamsSevenDays(int streamsSevenDays) {
        this.streamsSevenDays = streamsSevenDays;
    }

    public int getStreamsSevenDaysAdjustment() {
        return streamsSevenDaysAdjustment;
    }

    public void setStreamsSevenDaysAdjustment(int streamsSevenDaysAdjustment) {
        this.streamsSevenDaysAdjustment = streamsSevenDaysAdjustment;
    }

    public int getStreamsTotal() {
        return streamsTotal;
    }

    public void setStreamsTotal(int streamsTotal) {
        this.streamsTotal = streamsTotal;
    }

    @Override
    public String toString() {
        return "SpotifyChartEntry{" +
                "date=" + date +
                ", position=" + position +
                ", positionMovement='" + positionMovement + '\'' +
                ", artistAndTitle='" + artistAndTitle + '\'' +
                ", daysOnChart=" + daysOnChart +
                ", chartPeak='" + chartPeak + '\'' +
                ", streams=" + streams +
                ", streamAdjustment=" + streamAdjustment +
                ", streamsSevenDays=" + streamsSevenDays +
                ", streamsSevenDaysAdjustment=" + streamsSevenDaysAdjustment +
                ", streamsTotal=" + streamsTotal +
                '}';
    }
}
