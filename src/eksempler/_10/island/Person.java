package eksempler._10.island;

public class Person {
    private String name;
    private Person closestRelative;

    public Person(String name){
        this.name = name;
    }

    public Person(String name, Person closestRelative){
        this.name = name;
        this.closestRelative = closestRelative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getClosestRelative() {
        return closestRelative;
    }

    public void setClosestRelative(Person closestRelative) {
        this.closestRelative = closestRelative;
    }
}
