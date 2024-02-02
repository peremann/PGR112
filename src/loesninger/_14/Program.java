package loesninger._14;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {
    private final WorldService worldService;
    public Program(){
        worldService = new WorldService();
    }
    public void run() throws SQLException {
        System.out.println("Welcome to this beautiful program.");
        int choice = 0;
        Scanner userInput = new Scanner(System.in);
        while(choice!=7){
            presentMainMenu();
            choice = userInput.nextInt();
            switch(choice){
                case 1 -> presentAllCountries();
                case 2 -> presentAllCities();
                case 3 -> presentAllCitiesByCountryCode();
                case 4 -> addCity();
                case 5 -> updateCity();
                case 6 -> deleteCity();
                case 7 -> quit();
            }
        }
    }

    private void deleteCity() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter id for city to delete:");
        int id = Integer.parseInt(userInput.nextLine());
        int rowsAffected = worldService.deleteCity(id);
        if(rowsAffected==1){
            System.out.println("City deleted!");
        } else{
            System.out.println("Unable to delete city :(");
        }
    }

    private void updateCity() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = Integer.parseInt(userInput.nextLine());
        System.out.println("Enter new name:");
        String name = userInput.nextLine();
        System.out.println("Enter new country code:");
        String countryCode = userInput.nextLine();
        System.out.println("Enter new district:");
        String district = userInput.nextLine();
        System.out.println("Enter new population:");
        int population = Integer.parseInt(userInput.nextLine());
        City newCity = new City(id, name, countryCode, district, population);
        int rowsAffected = worldService.updateCity(newCity);
        if(rowsAffected==1){
            System.out.println("City updated!");
        } else{
            System.out.println("Unable to update city :(");
        }
    }

    private void addCity() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = Integer.parseInt(userInput.nextLine());
        System.out.println("Enter name:");
        String name = userInput.nextLine();
        System.out.println("Enter country code:");
        String countryCode = userInput.nextLine();
        System.out.println("Enter district:");
        String district = userInput.nextLine();
        System.out.println("Enter population:");
        int population = Integer.parseInt(userInput.nextLine());
        City newCity = new City(id, name, countryCode, district, population);
        int rowsAffected = worldService.addCity(newCity);
        if(rowsAffected==1){
            System.out.println("City added!");
        } else{
            System.out.println("Unable to add city :(");
        }
    }

    private void quit() {
        System.out.println("Bye!");
    }

    private void presentAllCitiesByCountryCode() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter country code:");
        String countryCode = userInput.nextLine();
        List<City> cities = worldService.getAllCitiesByCountryCode(countryCode);
        System.out.printf("Found %d cities.%n", cities.size());
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private void presentAllCities() throws SQLException {
        List<City> cities = worldService.getAllCities();
        System.out.printf("Found %d cities.%n", cities.size());
        System.out.println("Here are 10 of them");
        for (int i = 0; i < 10; i++) {
            System.out.println(cities.get(i));
        }
    }

    private void presentAllCountries() throws SQLException {
        List<Country> countries = worldService.getAllCountries();
        System.out.println("Here are all the countries:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private void presentMainMenu() {
        System.out.println("You have 7 choices:");
        System.out.println("1: Get all countries");
        System.out.println("2: Get all cities");
        System.out.println("3: Get cities by country code");
        System.out.println("4: Add city");
        System.out.println("5: Update city");
        System.out.println("6: Delete city");
        System.out.println("7: Quit");
    }
}
