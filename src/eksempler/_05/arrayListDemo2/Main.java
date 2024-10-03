package eksempler._05.arrayListDemo2;

public class Main {
    public static void main(String[] args) {
        PersonRegister pr = new PersonRegister();
        Person p1 = new Person();
        p1.setName("Per");
        p1.setAge(50);
        pr.addPerson(p1);
        Person p2 = new Person();
        p2.setName("Malin");
        p2.setAge(15);
        pr.addPerson(p2);
        System.out.println("Persons in register:"+pr.personsInRegister());
    }
}
