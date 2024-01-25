package loesninger._12;

import java.util.Comparator;

public class ArtistNameComparator implements Comparator<Artist>{
    @Override
    public int compare(Artist a1, Artist a2) {
        return a1.getArtistName().compareTo(a2.getArtistName());
    }
}
