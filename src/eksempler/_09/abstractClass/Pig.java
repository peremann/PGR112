package eksempler._09.abstractClass;

public class Pig extends Mammal{
    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void provideMilkForBaby() {
        System.out.println("Providing milk for my piglet through one of my " +
                getNumberOfTeats() + " teats.");
    }
}
