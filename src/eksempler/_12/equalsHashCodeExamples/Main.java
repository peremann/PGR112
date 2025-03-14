package eksempler._12.equalsHashCodeExamples;

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // are two objects equal?
        Person p1 = new Person(51, "Per");
        Person p2 = new Person(51, "Per");
        System.out.println("Objects are equal? Try 1: "+p1.equals(p2));

        // implementation in the Object class: They are equal if they are the same objects...

        // How can we get equals = true, without changing Person?
        p2 = p1;
        System.out.println("Objects are equal? Try 2: "+p1.equals(p2));

        // We may override the equals() implementation.
        // Override equals in Person, run project again... What happened?

        // Remove equals and hashcode
        // Set p2 to be a new object again, so we have two objects
        p2 = new Person(51, "Per");
        // Put both objects in a hashset
        Set<Person> persons = new HashSet<>();
        persons.add(p1);
        persons.add(p2);
        // Go through all objects in the set
        persons.forEach(System.out::println);

        // What happened, and why?

        // Create equals in Person again, and try again...

        // What happened now, and why?

        // Create a third Person object with the same values
        Person p3 = new Person(51, "Per");
        // Check if the new object is in the set
        boolean inSet = persons.contains(p3);
        System.out.println("Person 3 in set?: "+inSet);

        // Remove hashCode, run the code again. What happened?

        // Remove equals, run the code again. What happened?


        // Lesson learned: Create equals() and hashCode() for value objects
    }
}
