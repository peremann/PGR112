package loesninger._16.australiaSplit;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    private final WorldService worldService;
    public Program(){
        worldService = new WorldService();
    }
    public void splitAustralia() throws FileNotFoundException, SQLException {
        System.out.println("Updating world database with Australia split");
        File file = new File("files/australia.txt");
        try(Scanner reader = new Scanner(file);
            Connection con = worldService.getWorldDS().getConnection()){
            boolean autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            try {
                while(reader.hasNext()){
                    Country country = readCountry(reader);
                    worldService.addCountry(country, con);
                    int nrOfCities = Integer.parseInt(reader.nextLine());
                    for (int i = 0; i<nrOfCities; i++){
                        worldService.moveCity(Integer.parseInt(reader.nextLine()), country.code(), con);
                    }
                    int nrOfCountryLanguages = Integer.parseInt(reader.nextLine());
                    for (int i = 0; i<nrOfCountryLanguages; i++){
                        worldService.addCountryLanguage(readCountryLanguage(reader, country.code()), con);
                    }
                    reader.nextLine(); // Reading --- separator
                }
                worldService.deleteLanguagesInCountry("AUS", con);
                worldService.deleteCountry("AUS", con);
                con.commit();
            } catch (SQLException sqle){
                con.rollback();
                throw new RuntimeException(sqle);
            } finally {
                con.setAutoCommit(autoCommit);
            }
        }
        System.out.println("Australia split done");
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
