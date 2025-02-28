package eksempler._09.memorabilia;

public class SportEquipment extends Memorabilia{

    private String sport;

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
