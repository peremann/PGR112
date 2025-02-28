package eksempler._09.memorabilia;

import java.time.Year;

public class Skateboard extends Memorabilia{
    private String skateboardType;

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
