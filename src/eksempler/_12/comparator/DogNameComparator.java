package eksempler._12.comparator;

import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog d1, Dog d2) {
        return d1.getName().compareTo(d2.getName());
    }
}
