package eksempler._08._super;

public class ParentClass {
    protected String stringInParentClass;

    public String getStringInParentClass() {
        return stringInParentClass;
    }

    public void setStringInParentClass(String stringInParentClass) {
        this.stringInParentClass = stringInParentClass;
    }

    public void fantasticMethod(){
        System.out.println("This is a beautiful method originated in the Parent class!");
    }

    public void printState(){
        System.out.println("----- My beautiful state ----------");
        System.out.println("stringInParentClass:"+stringInParentClass);
    }

}
