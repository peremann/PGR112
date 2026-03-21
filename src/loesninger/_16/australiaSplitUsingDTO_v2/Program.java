package loesninger._16.australiaSplitUsingDTO_v2;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Program {
    private final WorldService worldService;
    public Program(){
        worldService = new WorldService();
    }
    public void splitAustralia() throws FileNotFoundException, SQLException {
        System.out.println("Updating world database with Australia split");
        List<Country> newCountries = new FileReader().readFromFile();
        try(Connection con = worldService.getWorldDS().getConnection()){
            boolean autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            try {
                for (Country newCountry : newCountries) {
                    worldService.addCountry(newCountry, con);
                    List<CountryLanguage> newLanguages = newCountry.countryLanguages();
                    for (CountryLanguage newLanguage : newLanguages) {
                        worldService.addCountryLanguage(newLanguage, con);
                    }
                    List<Integer> cityIds = newCountry.cityIds();
                    for (Integer cityId : cityIds) {
                        worldService.moveCity(cityId, newCountry.code(), con);
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
