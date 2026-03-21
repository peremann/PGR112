package loesninger._16.australiaSplitUsingDTO_v2;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorldService {
    private final MysqlDataSource worldDS;
    private static final String ADD_COUNTRY_SQL = "INSERT INTO country VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_COUNTRY_LANGUAGE_SQL = "INSERT INTO CountryLanguage VALUES (?,?,?,?)";
    private static final String DELETE_COUNTRY_SQL = "DELETE FROM Country WHERE code=?";
    private static final String DELETE_ALL_LANGUAGES_IN_COUNTRY_SQL = "DELETE FROM CountryLanguage WHERE CountryCode=?";
    private static final String UPDATE_CITY_PLACEMENT_SQL = "UPDATE City SET CountryCode=? WHERE id=?";

    public WorldService(){
        worldDS = new MysqlDataSource();
        worldDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        worldDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        worldDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        worldDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        worldDS.setPassword(PropertiesProvider.PROPS.getProperty("pwd"));
    }

    public MysqlDataSource getWorldDS() {
        return worldDS;
    }

    public int addCountry(Country newCountry, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(ADD_COUNTRY_SQL)
        ) {
            stmt.setString(1, newCountry.code());
            stmt.setString(2, newCountry.name());
            stmt.setString(3, newCountry.continent());
            stmt.setString(4, newCountry.region());
            stmt.setFloat(5, newCountry.surfaceArea());
            stmt.setInt(6, newCountry.indepYear());
            stmt.setInt(7, newCountry.population());
            stmt.setFloat(8, newCountry.lifeExpectancy());
            stmt.setFloat(9, newCountry.gnp());
            stmt.setFloat(10, newCountry.gnpOld());
            stmt.setString(11, newCountry.region());
            stmt.setString(12, newCountry.governmentForm());
            stmt.setString(13, newCountry.headOfState());
            stmt.setInt(14, newCountry.capital());
            stmt.setString(15, newCountry.code2());
            return stmt.executeUpdate();
        }
    }

    public int addCountryLanguage(CountryLanguage newCountryLanguage, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(ADD_COUNTRY_LANGUAGE_SQL)
        ) {
            stmt.setString(1, newCountryLanguage.countryCode());
            stmt.setString(2, newCountryLanguage.language());
            String booleanValue = (newCountryLanguage.isOfficial()) ? "T" : "F";
            stmt.setString(3, booleanValue);
            stmt.setFloat(4, newCountryLanguage.percentage());
            return stmt.executeUpdate();
        }
    }

    public int moveCity(int cityId, String newCountryCode, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE_CITY_PLACEMENT_SQL)
        ) {
            stmt.setString(1, newCountryCode);
            stmt.setInt(2, cityId);
            return stmt.executeUpdate();
        }
    }

    public int deleteCountry(String countryCode, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_COUNTRY_SQL)
        ) {
            stmt.setString(1, countryCode);
            return stmt.executeUpdate();
        }
    }

    public int deleteLanguagesInCountry(String countryCode, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_ALL_LANGUAGES_IN_COUNTRY_SQL)
        ) {
            stmt.setString(1, countryCode);
            return stmt.executeUpdate();
        }
    }
}
