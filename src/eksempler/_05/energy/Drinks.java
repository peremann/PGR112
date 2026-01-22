package eksempler._05.energy;

import java.util.ArrayList;

public class Drinks {
    ArrayList<EnergyDrink> energyDrinks = new ArrayList<>();

    public void addEnergyDrink(EnergyDrink energyDrink){
        energyDrinks.add(energyDrink);
    }

    public int nrOfEnergyDrinks(){
        return energyDrinks.size();
    }


}
