package eksempler._09.memorabilia;

public class Poster extends Memorabilia{
    private int width;
    private int height;

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
