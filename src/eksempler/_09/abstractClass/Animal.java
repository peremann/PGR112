package eksempler._09.abstractClass;

public abstract class Animal {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Abstract method (does not have a body)
    public abstract void animalSound();

    public void sleep(){
        System.out.println("Zzz");
    }
}
