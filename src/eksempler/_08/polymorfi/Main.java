package eksempler._08.polymorfi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Create animals and place in array list
        ArrayList<Animal> animals = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setBaby(true);
        animals.add(dog1);
        Dog dog2 = new Dog();
        dog2.setBaby(false);
        animals.add(dog2);
        Cat cat1 = new Cat();
        cat1.setBaby(false);
        animals.add(cat1);
        Cat cat2 = new Cat();
        cat2.setBaby(true);
        animals.add(cat2);
        for (Animal a: animals){
            a.makeSound();
        }

        // Traverse list. What is available? What happens?
    }
}
