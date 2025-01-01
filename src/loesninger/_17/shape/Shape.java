package loesninger._17.shape;

import java.awt.*;

public abstract class Shape implements Movable {
    private int id;
    private Color color;
    private boolean filled;

    public Shape(int id){
        this(id, Color.RED, true);
    }

    public Shape(int id, Color color, boolean filled) {
        this.id = id;
        this.color = color;
        this.filled = filled;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", color=" + color +
                ", filled=" + filled +
                '}';
    }
}
