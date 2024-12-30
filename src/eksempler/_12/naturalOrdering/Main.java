package eksempler._12.naturalOrdering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog(2, "Passop");
        Dog d2 = new Dog(4, "Bajas");
        Dog d3 = new Dog(3, "Bajas");
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(d);
        dogs.add(d2);
        dogs.add(d3);
        Collections.sort(dogs);
        System.out.println("Sorted");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("d2 equals d3:"+d2.equals(d3));
        System.out.println("d2 compareTo d3:"+d2.compareTo(d3));
    }
}
