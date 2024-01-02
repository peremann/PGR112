package loesninger._07.readArtists;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        try {
            p.readFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Exception when calling readFromFile:"+e.getMessage());
            e.printStackTrace();
        }
        try {
            p.writeToFile();
        } catch (IOException e) {
            System.out.println("Exception when writing to file:"+e.getMessage());
            e.printStackTrace();
        }
        try {
            ArrayList<Artist> artists = p.readArtistsFromFile();
            System.out.println("Look at this beautiful list of artists!");
            for (Artist a:
                 artists) {
                a.printString();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception when calling readArtistsFromFile:"+e.getMessage());
            e.printStackTrace();
        }
        /*
        try {
            ArrayList<Artist> artists = p.readArtistsFromFile();
            Artist a = artists.get(0);
            a.setArtistName("Prince the symbol");
            p.writeArtistToFile(artists);
        } catch (Exception e) {
            System.out.println("Exception when writing to file:"+e.getMessage());
            e.printStackTrace();
        }
         */

    }
}