package loesninger._12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Program {
    public ArrayList<Artist> readArtistsFromFile() throws FileNotFoundException {
        File file = new File("files/artisterMedIdentifikasjon.txt");
        ArrayList<Artist> artists = new ArrayList<>();
        try (Scanner scanner = new Scanner(file);){
            System.out.println("Reading content from file..");
            while(scanner.hasNextLine()){
                Artist artist = new Artist();
                String idAsText = scanner.nextLine();
                int id = Integer.parseInt(idAsText);
                artist.setId(id);
                String artistName = scanner.nextLine();
                artist.setArtistName(artistName);
                String birthDateAsString = scanner.nextLine();
                artist.setDateOfBirth(LocalDate.parse(birthDateAsString));
                String artistCity = scanner.nextLine();
                artist.setCity(artistCity);
                String artistCountry = scanner.nextLine();
                artist.setCountry(artistCountry);
                scanner.nextLine();
                artists.add(artist);
            }
        }
        System.out.println("Done content from file..");
        return artists;
    }

    public Set<Artist> readArtistsFromFileToSet() throws FileNotFoundException {
        File file = new File("files/artisterMedIdentifikasjon.txt");
        Set<Artist> artists = new HashSet<>();
        try (Scanner scanner = new Scanner(file);){
            System.out.println("Reading content from file..");
            while(scanner.hasNextLine()){
                Artist artist = new Artist();
                String idAsText = scanner.nextLine();
                int id = Integer.parseInt(idAsText);
                artist.setId(id);
                String artistName = scanner.nextLine();
                artist.setArtistName(artistName);
                String birthDateAsString = scanner.nextLine();
                artist.setDateOfBirth(LocalDate.parse(birthDateAsString));
                String artistCity = scanner.nextLine();
                artist.setCity(artistCity);
                String artistCountry = scanner.nextLine();
                artist.setCountry(artistCountry);
                scanner.nextLine();
                artists.add(artist);
            }
        }
        System.out.println("Done content from file..");
        return artists;
    }

    public Map<Integer, Artist> readArtistsFromFileToMap() throws FileNotFoundException {
        File file = new File("files/artisterMedIdentifikasjon.txt");
        Map<Integer, Artist> artists = new HashMap<>();
        try (Scanner scanner = new Scanner(file);){
            System.out.println("Reading content from file..");
            while(scanner.hasNextLine()){
                Artist artist = new Artist();
                String idAsText = scanner.nextLine();
                int id = Integer.parseInt(idAsText);
                artist.setId(id);
                String artistName = scanner.nextLine();
                artist.setArtistName(artistName);
                String birthDateAsString = scanner.nextLine();
                artist.setDateOfBirth(LocalDate.parse(birthDateAsString));
                String artistCity = scanner.nextLine();
                artist.setCity(artistCity);
                String artistCountry = scanner.nextLine();
                artist.setCountry(artistCountry);
                scanner.nextLine();
                artists.put(id, artist);
            }
        }
        System.out.println("Done content from file..");
        return artists;
    }

    public void writeArtistToFile(ArrayList<Artist> artists) throws IOException {
        System.out.println("Writing artists to file");
        File file = new File("files/artisterMedId.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for (Artist a: artists){
            writer.write(a.getId() + "\n");
            writer.write(a.getArtistName() + "\n");
            writer.write(a.getDateOfBirth().toString() + "\n");
            writer.write(a.getCity() + "\n");
            writer.write(a.getCountry() + "\n");
            writer.write("---\n");
        }
        writer.close();
    }
}
