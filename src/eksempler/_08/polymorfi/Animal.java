package eksempler._08.polymorfi;

public class Animal {
    private boolean isBaby;

    public boolean isBaby() {
        return isBaby;
    }

    public void setBaby(boolean baby) {
        isBaby = baby;
    }

    public void makeSound(){
        System.out.println("Hmm, what is an animal sound really?");
    }
}
