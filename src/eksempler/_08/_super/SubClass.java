package eksempler._08._super;

public class SubClass extends MiddleClass {
    private String stringInSubClass;

    public String getStringInSubClass() {
        return stringInSubClass;
    }

    public void setStringInSubClass(String stringInSubClass) {
        this.stringInSubClass = stringInSubClass;
    }

    public void printSubClassState(){
        System.out.println("---------------");
        System.out.println("stringInParentClass:"+stringInParentClass);
        System.out.println("stringInMiddleClass:"+stringInMiddleClass);
        System.out.println("stringInSubClass:"+stringInSubClass);
    }

}
