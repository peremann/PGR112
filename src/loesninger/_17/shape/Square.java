package loesninger._17.shape;

import java.awt.*;

public class Square extends Rectangle {

    public double getSide(){
        return getWidth();
    }

    public Square(int id){
        super(id, 1.0, 1.0);
    }
    public Square(int id, double side){
        super(id, side, side);
    }

    public Square(int id, Color color, boolean filled, double side, MovablePoint topLeft, MovablePoint bottomRight) {
        super(id, color, filled, side, side, topLeft, bottomRight);
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
