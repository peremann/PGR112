package eksempler._10.superduper;

public class Dog extends Animal{
    private int age;
    private String name;

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

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
