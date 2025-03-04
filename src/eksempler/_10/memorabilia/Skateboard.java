package eksempler._10.memorabilia;

import java.time.Year;

public class Skateboard extends Memorabilia {
    private String skateboardType;

    public Skateboard(int id, String name, Year year, String celebrityInvolved, String description, int askingPrice, String skateboardType) {
        super(id, name, year, celebrityInvolved, description, askingPrice);
        this.skateboardType = skateboardType;
    }

    public String getSkateboardType() {
        return skateboardType;
    }

    public void setSkateboardType(String skateboardType) {
        this.skateboardType = skateboardType;
    }

    @Override
    public String toString() {
        return "Skateboard{" +
                "skateboardType='" + skateboardType + '\'' +
                "} " + super.toString();
    }
}
