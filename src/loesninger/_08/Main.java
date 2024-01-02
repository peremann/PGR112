package loesninger._08;

import java.awt.Color;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setFilled(true);
        c.setColor(Color.BLACK);
        c.setRadius(2.5);
        System.out.println(c);
        System.out.println("Circle Area:" + c.getArea());
        System.out.println("Circle Perimeter:" + c.getPerimeter());

        Rectangle r = new Rectangle();
        r.setColor(Color.BLUE);
        r.setFilled(false);
        r.setWidth(3.2);
        r.setHeight(2.1);
        System.out.println(r);
        System.out.println("Rectangle Area:" + r.getArea());
        System.out.println("Rectangle Perimeter:" + r.getPerimeter());

        Square s = new Square();
        s.setColor(Color.CYAN);
        s.setFilled(true);
        s.setSide(3.3);
        System.out.println(s);
        System.out.println("Square Area:" + s.getArea());
        System.out.println("Square Perimeter:" + s.getPerimeter());

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(r);
        shapes.add(s);
        System.out.println("------");
        for (Shape shape :
                shapes) {
            System.out.println(shape.toString());
        }
    }
}
