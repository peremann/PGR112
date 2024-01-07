package loesninger._10.shapes;

public class MovablePoint implements Movable {

    private double x,y;

    public MovablePoint(){
        this.x = 0;
        this.y = 0;
    }

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void moveUp(double distance) {
        this.y += distance;
    }

    @Override
    public void moveDown(double distance) {
        this.y -= distance;
    }

    @Override
    public void moveRight(double distance) {
        this.x += distance;
    }

    @Override
    public void moveLeft(double distance) {
        this.x -= distance;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
