package loesninger._12;

import java.time.LocalDate;
import java.util.Objects;

public class Artist {
    private int id;
    private String artistName;
    private LocalDate dateOfBirth;
    private String city;
    private String country;

    public Artist(int id, String artistName, LocalDate dateOfBirth, String city, String country) {
        this.id = id;
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.country = country;
    }

    public Artist(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id && Objects.equals(artistName, artist.artistName) && Objects.equals(dateOfBirth, artist.dateOfBirth) && Objects.equals(city, artist.city) && Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistName, dateOfBirth, city, country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void printString(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
