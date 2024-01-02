package eksempler._09.abstractClass;

public abstract class Mammal extends Animal{

    private  int numberOfTeats;

    public int getNumberOfTeats() {
        return numberOfTeats;
    }

    public void setNumberOfTeats(int numberOfTeats) {
        this.numberOfTeats = numberOfTeats;
    }

    public void regulateBodyHeat(){
        System.out.println("Change in temp. Regulating body heat.");
    }

    public abstract void provideMilkForBaby();
}
