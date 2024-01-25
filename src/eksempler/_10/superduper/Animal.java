package eksempler._10.superduper;

public abstract class Animal {
    private int id;

    public Animal(int id) {
        System.out.println("Inne i animal const");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void makeSound();

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                '}';
    }
}
