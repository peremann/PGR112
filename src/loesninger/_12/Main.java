package loesninger._12;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        ArrayList<Artist> artists = null;
        Set<Artist> artistSet = null;
        Map<Integer, Artist> map = null;
        try {
            artists = p.readArtistsFromFile();
            artistSet = p.readArtistsFromFileToSet();
            map = p.readArtistsFromFileToMap();
            System.out.println("Look at this beautiful list of artists!");
            //Collections.sort(artists);
            for (Artist a:
                    artists) {
                a.printString();
            }
            System.out.println("---");
            for (Artist a:
                    artistSet) {
                a.printString();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception when calling readArtistsFromFile:"+e.getMessage());
            e.printStackTrace();
        }
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        while(choice!=2){
            System.out.println("Make a pick:");
            System.out.println("1: See information about artist");
            System.out.println("2: Quit");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> showArtistById(map);
                case 2 -> quit();
                default -> {System.out.println("Please pick 1-2");}
            }
        }

    }

    private static void showArtistById(Map<Integer, Artist> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter artist id:");
        int choice = scanner.nextInt();
        Artist artist = map.get(choice);
        if(artist == null){
            System.out.println("Artist not found");
        } else{
            System.out.println(artist);
        }
    }

    private static void quit() {
        System.out.println("Bye!");
    }

    private static void showArtistsOrderedByBirth(ArrayList<Artist> artists) {
        System.out.println("Artists ordered by birth:");
        Collections.sort(artists, (a1, a2) ->{return a1.getDateOfBirth().compareTo(a2.getDateOfBirth());});
        for (Artist a:
                artists) {
            a.printString();
        }
    }

    private static void showArtistsOrderedByName(ArrayList<Artist> artists) {
        System.out.println("Artists ordered by name:");
        Collections.sort(artists, new ArtistNameComparator());
        for (Artist a:
                artists) {
            a.printString();
        }
    }
}