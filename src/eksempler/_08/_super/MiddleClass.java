package eksempler._08._super;

public class MiddleClass extends ParentClass{
    protected String stringInMiddleClass;

    public String getStringInMiddleClass() {
        return stringInMiddleClass;
    }

    public void setStringInMiddleClass(String stringInMiddleClass) {
        this.stringInMiddleClass = stringInMiddleClass;
    }

    @Override
    public void printState(){
        super.printState();
        System.out.println("stringInMiddleClass:"+stringInMiddleClass);
    }

}
