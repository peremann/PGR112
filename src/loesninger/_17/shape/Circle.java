package loesninger._17.shape;


import java.awt.*;

public class Circle extends Shape {
    private double radius;

    private MovablePoint center;

    public Circle(int id) {
        this(id, 1.0);
    }

    public Circle(int id, double radius) {
        super(id);
        this.radius = radius;
        this.center = new MovablePoint();
    }
    public Circle(int id, Color color, boolean filled, double radius, MovablePoint center) {
        super(id, color, filled);
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    @Override
    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                "} " + super.toString();
    }

    @Override
    public void moveUp(double distance) {
        center.moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        center.moveDown(distance);
    }

    @Override
    public void moveRight(double distance) {
        center.moveRight(distance);
    }

    @Override
    public void moveLeft(double distance) {
        center.moveLeft(distance);
    }

    public void uniqueCircleMethod(){
        System.out.println("I am a circle!");
    }
}
