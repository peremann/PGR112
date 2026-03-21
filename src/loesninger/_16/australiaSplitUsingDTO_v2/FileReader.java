package loesninger._16.australiaSplitUsingDTO_v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<Country> readFromFile() throws FileNotFoundException {
        File file = new File("files/australia.txt");
        List<Country> newCountries = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNext()){
                Country country = readCountry(reader);
                newCountries.add(country);
                reader.nextLine(); // Reading --- separator
            }
        }
        return newCountries;
    }

    private Country readCountry(Scanner reader) {
        // Country
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

        //Cities in country
        List<Integer> citiesToMove = readCityIds(reader);

        // CountryLanguages
        List<CountryLanguage> newCountryLanguages = readCountryLanguages(reader, code);
        return new Country(code, name, continent, region,
                Float.parseFloat(surfaceAreaText), Integer.parseInt(indepYear),
                Integer.parseInt(population), Float.parseFloat(lifeExpectancy),
                Float.parseFloat(gnp), Float.parseFloat(gnpOld),
                localName, governmentForm, headOfState,
                Integer.parseInt(capital), code2, citiesToMove, newCountryLanguages);
    }

    private List<CountryLanguage> readCountryLanguages(Scanner reader, String code) {
        int nrOfCountryLanguages = Integer.parseInt(reader.nextLine());
        List<CountryLanguage> newCountryLanguages = new ArrayList<>();
        for (int i = 0; i<nrOfCountryLanguages; i++){
            String language = reader.nextLine();
            String isOfficialText = reader.nextLine();
            boolean isOfficial = isOfficialText.equalsIgnoreCase("T");
            String percentage = reader.nextLine();
            newCountryLanguages.add(new CountryLanguage(code, language, isOfficial, Float.parseFloat(percentage)));
        }
        return newCountryLanguages;
    }

    private List<Integer> readCityIds(Scanner reader) {
        int nrOfCities = Integer.parseInt(reader.nextLine());
        List<Integer> citiesToMove = new ArrayList<>();
        for (int i = 0; i<nrOfCities; i++){
            int cityId = Integer.parseInt(reader.nextLine());
            citiesToMove.add(cityId);
        }
        return citiesToMove;
    }

}
