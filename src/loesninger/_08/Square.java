package loesninger._08;

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
}
