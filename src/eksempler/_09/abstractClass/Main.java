package eksempler._09.abstractClass;

public class Main {
    public static void main(String[] args) {
        Pig pig = new Pig();
        pig.setId(1);
        pig.setNumberOfTeats(10);
        pig.animalSound();
        pig.provideMilkForBaby();
        pig.regulateBodyHeat();

        Cat cat = new Cat();
        cat.setId(2);
        cat.setNumberOfTeats(8);
        cat.animalSound();
        cat.provideMilkForBaby();
        cat.regulateBodyHeat();

    }
}
