package eksempler._10.immutable;

public final class Dog extends Animal {
    private final int age;
    private final String name;

    public Dog(int id, int age, String name) {
        super(id);
        this.age = age;
        this.name = name;
    }

    public Dog(int id) {
        this(id, 0, "No_name");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public void makeSound() {
        System.out.println("Voff voff");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
