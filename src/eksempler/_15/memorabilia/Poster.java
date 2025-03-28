package eksempler._15.memorabilia;

import java.time.Year;

public class Poster extends Memorabilia {
    private int width;
    private int height;

    public Poster(int id, String name, Year year, String celebrityInvolved, String description, int askingPrice, int width, int height) {
        super(id, name, year, celebrityInvolved, description, askingPrice);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }
}
