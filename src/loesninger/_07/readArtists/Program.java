package loesninger._07.readArtists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public void readFromFile() throws FileNotFoundException {
        File file = new File("files/lesFraFil.txt");
        try (Scanner scanner = new Scanner(file);){
            System.out.println("Reading content from file..");
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
        System.out.println("Done content from file..");
    }

    public void writeToFile() throws IOException {
        File file = new File("files/skrivTilFil.txt");
        file.createNewFile();
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(file)){
            System.out.println("Writing content to file..");
            for (int i = 0; i<5; i++){
                System.out.println("Enter some text:");
                String s = scanner.nextLine();
                writer.write(s);
                writer.write("\n");
            }
        }
    }
    public ArrayList<Artist> readArtistsFromFile() throws FileNotFoundException {
        File file = new File("files/artister.txt");
        ArrayList<Artist> artists = new ArrayList<>();
        try (Scanner scanner = new Scanner(file);){
            System.out.println("Reading content from file..");
            while(scanner.hasNextLine()){
                Artist artist = new Artist();
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

    public void writeArtistToFile(ArrayList<Artist> artists) throws IOException {
        System.out.println("Writing artists to file");
        File file = new File("files/artister.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for (Artist a: artists){
            writer.write(a.getArtistName() + "\n");
            writer.write(a.getDateOfBirth().toString() + "\n");
            writer.write(a.getCity() + "\n");
            writer.write(a.getCountry() + "\n");
            writer.write("---\n");
        }
        writer.close();
    }
}
