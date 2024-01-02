package loesninger._09;

public class Square extends Rectangle {

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        setWidth(side);
        setHeight(side);
    }

    @Override
    public String toString() {
        return "Square{} " + super.toString();
    }

    public void uniqueSquareMethod(){
        System.out.println("I am a Square!");
    }

}
