package eksempler._08._super;

public class SubClass extends MiddleClass {
    private String stringInSubClass;

    public String getStringInSubClass() {
        return stringInSubClass;
    }

    public void setStringInSubClass(String stringInSubClass) {
        this.stringInSubClass = stringInSubClass;
    }

    @Override
    public void printState(){
        super.printState();
        System.out.println("stringInSubClass:"+stringInSubClass);
    }

}
