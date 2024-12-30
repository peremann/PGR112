package eksempler._09.casting;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Pig pig = new Pig();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(pig);

        for (Animal a: animals){
            a.animalSound();
            a.sleep();
            if(a instanceof Cat c){
                c.exclusiveCatMethod();
            } else if (a instanceof Pig p){
                p.exclusivePigMethod();
            }
        }
    }
}
