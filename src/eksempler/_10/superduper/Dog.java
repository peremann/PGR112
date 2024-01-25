package eksempler._10.superduper;

public class Dog extends Animal{
    private int age;
    private String name;

    public Dog(int id){
        this(id, 0, null);
    }

    public Dog(int id, String name){
        this(id, 0, name);
    }
    public Dog(int id, int age, String name) {
        super(id);
        System.out.println("Inne i dog const");
        this.age = age;
        this.name = name;
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
