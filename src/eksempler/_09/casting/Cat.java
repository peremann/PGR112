package eksempler._09.casting;

public class Cat implements Animal{
    @Override
    public void animalSound() {
        System.out.println("The cat says miaow");
    }

    @Override
    public void sleep() {
        System.out.println("ZzZz");
    }

    public void exclusiveCatMethod(){
        System.out.println("zvsdfvsfg");
    }
}
