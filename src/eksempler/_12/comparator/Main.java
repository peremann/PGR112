package eksempler._12.comparator;

import java.util.*;

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
        // Call sort using DogNameComparator
        Collections.sort(dogs, new DogNameComparator());
        // Show lambda also?
        Collections.sort(dogs, (dog1, dog2) ->{return dog1.getName().compareTo(dog2.getName());});
        System.out.println("Sorted");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}
