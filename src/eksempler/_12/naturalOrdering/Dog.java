package eksempler._12.naturalOrdering;

import java.util.Objects;

public class Dog implements Comparable<Dog>{
    private int age;
    private String name;

    public Dog(int age, String name){
        this.age = age;
        this.name = name;
    }

    public Dog(int age){
        this.age = age;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /*
    Not recommended. compareTo does not align with equals
     */
    /*
    @Override
    public int compareTo(Dog d) {
        return this.name.compareTo(d.getName());
    }
     */

    /*
    As displayed in video.
    As name is of type String, we could do better regarding possible null values (not implemented here)
     */
    @Override
    public int compareTo(Dog d) {
        int i = this.name.compareTo(d.getName());
        if(i!=0){
            return i;
        } else {
            return this.age - d.getAge();
        }
    }
}
