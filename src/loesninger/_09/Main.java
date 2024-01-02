package loesninger._09;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setFilled(true);
        c.setColor(Color.BLACK);
        c.setRadius(2.5);
        MovablePoint mp1 = new MovablePoint();
        mp1.setX(0.0);
        mp1.setY(0.0);
        c.setCenter(mp1);
        System.out.println(c);
        System.out.println("Circle Area:" + c.getArea());
        System.out.println("Circle Perimeter:" + c.getPerimeter());

        Rectangle r = new Rectangle();
        r.setColor(Color.BLUE);
        r.setFilled(false);
        r.setWidth(3.2);
        r.setHeight(2.1);
        MovablePoint mp2 = new MovablePoint();
        mp2.setX(1.0);
        mp2.setY(1.0);
        r.setTopLeft(mp2);

        MovablePoint mp3 = new MovablePoint();
        mp3.setX(2.0);
        mp3.setY(-1.0);
        r.setBottomRight(mp3);
        System.out.println(r);
        System.out.println("Rectangle Area:" + r.getArea());
        System.out.println("Rectangle Perimeter:" + r.getPerimeter());

        Square s = new Square();
        s.setColor(Color.CYAN);
        s.setFilled(true);
        s.setSide(3.3);
        MovablePoint mp4 = new MovablePoint();
        mp4.setX(2.0);
        mp4.setY(2.0);
        s.setTopLeft(mp4);

        MovablePoint mp5 = new MovablePoint();
        mp5.setX(4.0);
        mp5.setY(-4.0);
        s.setBottomRight(mp5);
        System.out.println(s);
        System.out.println("Square Area:" + s.getArea());
        System.out.println("Square Perimeter:" + s.getPerimeter());
        
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(r);
        shapes.add(s);
        System.out.println("------");
        for (int i = 0; i<shapes.size(); i++){
            shapes.get(i).moveUp(i+1);
            shapes.get(i).moveRight(i+1);
        }

        for (Shape shapes2 :
                shapes) {
            System.out.println(shapes2.toString());
            if(shapes2 instanceof Circle circle){
                circle.uniqueCircleMethod();
            } else if(shapes2 instanceof Square square){
                square.uniqueSquareMethod();
            } else if(shapes2 instanceof Rectangle rectangle){
                rectangle.uniqueRectangleMethod();
            }
        }
    }
}
