package eksempler._05;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Create ArrayList
        PersonRegister pr = new PersonRegister();
        ArrayList<Person> persons = new ArrayList<>();
        Person p1 = new Person();
        pr.addPerson(p1);
        p1.setName("Per");
        p1.setAge(49);
        persons.add(p1);
        System.out.println("Size:"+persons.size());
        Person p2 = new Person();
        p2.setName("Ola");
        p2.setAge(48);
        persons.add(p2);
        for (Person p: persons){
            System.out.println("Person:"+p.toString());
        }
        System.out.println("Size:"+persons.size());



        // Will it hold primitives?
        //Place some persons in an arraylist
        //Look at import
        //Look at java API (IntelliJ and web)
        // What if the arraylist is a field?
        // Person register using arraylist of persons
    }
}
