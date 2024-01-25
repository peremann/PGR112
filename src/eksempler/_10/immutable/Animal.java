package eksempler._10.immutable;

public abstract class Animal {
    private final int id;

    public Animal(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract void makeSound();

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                '}';
    }
}
