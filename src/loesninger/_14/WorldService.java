package loesninger._14;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorldService {
    private static final String DB_URL = "jdbc:mysql://localhost/world";
    private static final String USER = "per";
    private static final String PWD = "per";

    private static final String GET_ALL_COUNTRIES_SQL = "SELECT * FROM Country";
    private static final String GET_ALL_CITIES_SQL = "SELECT * FROM City";
    private static final String GET_ALL_CITIES_BY_COUNTRY_CODE_SQL = "SELECT * FROM City WHERE CountryCode=";

    public List<Country> getAllCountries() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_COUNTRIES_SQL);
        ) {
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String continent = rs.getString("continent");
                float surfaceArea = rs.getFloat("surfaceArea");
                int population = rs.getInt("population");
                int indepYear = rs.getInt("indepYear");
                int capital = rs.getInt("capital");
                countries.add(new Country(code, name, continent, surfaceArea, population,
                        indepYear, capital));
            }
        }
        return countries;
    }

    public List<City> getAllCities() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_CITIES_SQL);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String countryCode = rs.getString("countryCode");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                cities.add(new City(id, name, countryCode, district, population));
            }
        }
        return cities;
    }

    public List<City> getAllCitiesByCountryCode(String countryCode) throws SQLException {
        List<City> cities = new ArrayList<>();
        String query =  String.format(GET_ALL_CITIES_BY_COUNTRY_CODE_SQL+"'%s'", countryCode);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                cities.add(new City(id, name, countryCode, district, population));
            }
        }
        return cities;
    }
}
