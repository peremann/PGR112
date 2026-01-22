package eksempler._05.energy;

public class EnergyDrink {
    private int size;
    private String name;
    private String brand;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "EnergyDrink{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
