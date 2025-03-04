package eksempler._10.memorabilia;

import java.time.Year;

public abstract class Memorabilia {
    private int id;
    private String name;
    private Year year;
    private String celebrityInvolved;
    private String description;
    private int askingPrice;

    public Memorabilia(int id, String name, Year year, String celebrityInvolved, String description, int askingPrice) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.celebrityInvolved = celebrityInvolved;
        this.description = description;
        this.askingPrice = askingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Memorabilia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", celebrityInvolved='" + celebrityInvolved + '\'' +
                ", description='" + description + '\'' +
                ", askingPrice=" + askingPrice +
                '}';
    }

}
