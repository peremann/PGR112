package loesninger._16.australiaSplitUsingDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public SplitAustraliaDTO readFromFile() throws FileNotFoundException {
        File file = new File("files/australia.txt");
        ArrayList<Country> newCountries = new ArrayList<>();
        ArrayList<CountryLanguage> newCountryLanguages = new ArrayList<>();
        HashMap<String, List<Integer>> citiesInCountries = new HashMap<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNext()){
                Country country = readCountry(reader);
                newCountries.add(country);
                int nrOfCities = Integer.parseInt(reader.nextLine());
                List<Integer> citiesToMove = new ArrayList<>();
                for (int i = 0; i<nrOfCities; i++){
                    citiesToMove.add(Integer.parseInt(reader.nextLine()));
                }
                citiesInCountries.put(country.code(), citiesToMove);
                int nrOfCountryLanguages = Integer.parseInt(reader.nextLine());
                for (int i = 0; i<nrOfCountryLanguages; i++){
                    CountryLanguage newCountryLanguage = readCountryLanguage(reader, country.code());
                    newCountryLanguages.add(newCountryLanguage);
                }
                reader.nextLine(); // Reading --- separator
            }
        }
        return new SplitAustraliaDTO(newCountries, newCountryLanguages, citiesInCountries);
    }

    private CountryLanguage readCountryLanguage(Scanner reader, String countryCode) {
        String language = reader.nextLine();
        String isOfficialText = reader.nextLine();
        boolean isOfficial = isOfficialText.equalsIgnoreCase("T");
        String percentage = reader.nextLine();
        return new CountryLanguage(countryCode, language, isOfficial, Float.parseFloat(percentage));
    }

    private Country readCountry(Scanner reader) {
        String code = reader.nextLine();
        String name = reader.nextLine();
        String continent = reader.nextLine();
        String region = reader.nextLine();
        String surfaceAreaText = reader.nextLine();
        String indepYear = reader.nextLine();
        String population = reader.nextLine();
        String lifeExpectancy = reader.nextLine();
        String gnp = reader.nextLine();
        String gnpOld = reader.nextLine();
        String localName = reader.nextLine();
        String governmentForm = reader.nextLine();
        String headOfState = reader.nextLine();
        String capital = reader.nextLine();
        String code2 = reader.nextLine();
        return new Country(code, name, continent, region,
                Float.parseFloat(surfaceAreaText), Integer.parseInt(indepYear),
                Integer.parseInt(population), Float.parseFloat(lifeExpectancy),
                Float.parseFloat(gnp), Float.parseFloat(gnpOld),
                localName, governmentForm, headOfState,
                Integer.parseInt(capital), code2);
    }
}
