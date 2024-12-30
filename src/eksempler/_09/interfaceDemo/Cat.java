package eksempler._09.interfaceDemo;

public class Cat implements Animal{
    @Override
    public void animalSound() {
        System.out.println("The cat says miao");
    }

    @Override
    public void sleep() {
        System.out.println("ZzZzZ");
    }

    public void someMethod(){
        System.out.println("zsfgjhasfg ");
    }
}
