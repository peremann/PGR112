package loesninger._10.shapes;

import java.awt.*;

public class Square extends Rectangle {

    public double getSide(){
        return getWidth();
    }

    public Square(){
        super(1.0, 1.0);
    }
    public Square(double side){
        super(side, side);
    }

    public Square(Color color, boolean filled, double side, MovablePoint topLeft, MovablePoint bottomRight) {
        super(color, filled, side, side, topLeft, bottomRight);
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
