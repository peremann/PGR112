package eksempler._09.abstractClass;

public class Cat extends Mammal{
    @Override
    public void animalSound() {
        System.out.println("The cat says miaaauuu");
    }

    @Override
    public void provideMilkForBaby() {
        System.out.println("Providing milk for my kitten through one of my "+
                getNumberOfTeats() + " teats.");
    }
}
