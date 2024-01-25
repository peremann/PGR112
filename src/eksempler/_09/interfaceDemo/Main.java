package eksempler._09.interfaceDemo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create Cat class implementing Animal
        //Create cat and pig objects
        Cat cat = new Cat();
        Pig pig = new Pig();
        //Place in arraylist
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(pig);
        //Traverse
        for (Animal a: animals){
            a.animalSound();
            a.sleep();
        }
    }
}
