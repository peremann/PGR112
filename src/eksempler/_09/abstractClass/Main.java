package eksempler._09.abstractClass;

public class Main {
    public static void main(String[] args) {
        // Create Animal object

        // Create pigs and cats
        Cat cat = new Cat();
        cat.setId(1);
        cat.setNumberOfTeats(8);
        Pig pig = new Pig();
        pig.setId(2);
        pig.setNumberOfTeats(10);

        pig.animalSound();
        pig.regulateBodyHeat();
        pig.provideMilkForBaby();
        cat.animalSound();
        cat.provideMilkForBaby();
        cat.regulateBodyHeat();


    }
}
