package eksempler._15.memorabilia;

import java.time.Year;

public class SportEquipment extends Memorabilia {

    private String sport;

    public SportEquipment(int id, String name, Year year, String celebrityInvolved, String description, int askingPrice, String sport) {
        super(id, name, year, celebrityInvolved, description, askingPrice);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "SportEquipment{" +
                "sport='" + sport + '\'' +
                "} " + super.toString();
    }
}
