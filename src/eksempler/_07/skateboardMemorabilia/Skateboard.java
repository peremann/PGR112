package eksempler._07.skateboardMemorabilia;

import java.time.Year;

public class Skateboard {
    private int id;
    private String model;
    private Year year;
    private String celebrityInvolved;
    private String description;
    private int askingPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getCelebrityInvolved() {
        return celebrityInvolved;
    }

    public void setCelebrityInvolved(String celebrityInvolved) {
        this.celebrityInvolved = celebrityInvolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }

    @Override
    public String toString() {
        return "Skateboard{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", celebrityInvolved='" + celebrityInvolved + '\'' +
                ", description='" + description + '\'' +
                ", askingPrice=" + askingPrice +
                '}';
    }
}
