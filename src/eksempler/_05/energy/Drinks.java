package eksempler._05.energy;

import java.util.ArrayList;
import java.util.Random;

public class Drinks {
    ArrayList<EnergyDrink> energyDrinks = new ArrayList<>();

    public void addEnergyDrink(EnergyDrink energyDrink){
        energyDrinks.add(energyDrink);
    }

    public int nrOfEnergyDrinks(){
        return energyDrinks.size();
    }

    public void removeEnergyDrink(EnergyDrink energyDrink){
        energyDrinks.remove(energyDrink);
    }

    public EnergyDrink removeRandomEnergyDrink(){
        Random r = new Random();
        int i = r.nextInt(energyDrinks.size());
        return energyDrinks.remove(i);
    }

}
