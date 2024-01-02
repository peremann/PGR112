package eksempler._08.polymorfi;

public class Dog extends Animal{

    @Override
    public void makeSound(){
        if(isBaby()){
            System.out.println("Voff, voff");
        } else {
            System.out.println("VOFF VOFF!!!!");
        }
    }
}
