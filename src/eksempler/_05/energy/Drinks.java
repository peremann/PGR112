package eksempler._05.energy;

import java.util.ArrayList;
import java.util.Random;

public class Drinks {
    private ArrayList<EnergyDrink> energyDrinks = new ArrayList<>();

    public ArrayList<EnergyDrink> getEnergyDrinks() {
        return energyDrinks;
    }

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

    public EnergyDrink biggestEnergyDrink(){
        int max = 0;
        EnergyDrink biggest = null;
        for (EnergyDrink energyDrink : energyDrinks) {
            if (energyDrink.getSize() > max) {
                max = energyDrink.getSize();
                biggest = energyDrink;
            }
        }
        return biggest;
    }

}
