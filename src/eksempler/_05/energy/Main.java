package eksempler._05.energy;

public class Main {
    public static void main(String[] args) {
        EnergyDrink ed1 = new EnergyDrink();
        ed1.setBrand("Monster");
        ed1.setName("Mango loco");
        ed1.setSize(500);

        EnergyDrink ed2 = new EnergyDrink();
        ed2.setBrand("Monster");
        ed2.setName("Mango loco poco");
        ed2.setSize(400);

        Drinks drinks = new Drinks();
        drinks.addEnergyDrink(ed1);
        drinks.addEnergyDrink(ed2);

        int nrOfDrinks = drinks.nrOfEnergyDrinks();
        System.out.println("Nr of drinks:"+nrOfDrinks);

        //drinks.removeEnergyDrink(ed2);
        //nrOfDrinks = drinks.nrOfEnergyDrinks();
        //System.out.println("Nr of drinks:"+nrOfDrinks);

        EnergyDrink biggestEnergyDrink = drinks.biggestEnergyDrink();
        System.out.println("Biggest drink: " + biggestEnergyDrink);
    }
}
