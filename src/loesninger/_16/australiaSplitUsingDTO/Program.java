package loesninger._16.australiaSplitUsingDTO;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {
    private final WorldService worldService;
    public Program(){
        worldService = new WorldService();
    }
    public void splitAustralia() throws FileNotFoundException, SQLException {
        System.out.println("Updating world database with Australia split");
        FileReader fileReader = new FileReader();
        SplitAustraliaDTO splitAustraliaDTO = fileReader.readFromFile();
        try(Connection con = worldService.getWorldDS().getConnection()){
            boolean autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            try {
                List<Country> newCountries = splitAustraliaDTO.newCountries();
                for (Country newCountry : newCountries) {
                    worldService.addCountry(newCountry, con);
                }
                List<CountryLanguage> newCountryLanguages = splitAustraliaDTO.newCountryLanguages();
                for (CountryLanguage newCountryLanguage : newCountryLanguages) {
                    worldService.addCountryLanguage(newCountryLanguage, con);
                }
                HashMap<String, List<Integer>> citiesInCountries = splitAustraliaDTO.citiesInCountries();
                Set<Map.Entry<String, List<Integer>>> entries = citiesInCountries.entrySet();
                for (Map.Entry<String, List<Integer>> entry : entries) {
                    String countryCode = entry.getKey();
                    List<Integer> cityIds = entry.getValue();
                    for (Integer cityId : cityIds) {
                        worldService.moveCity(cityId, countryCode, con);
                    }
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


}
