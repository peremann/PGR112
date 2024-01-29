package loesninger._13;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldService {
    private static final String DB_URL = "jdbc:mysql://localhost/world";
    private static final String USER = "per";
    private static final String PWD = "per";

    private static final String GET_ALL_COUNTRIES_SQL = "SELECT * FROM Country";
    private static final String GET_ALL_CITIES_SQL = "SELECT * FROM City";
    private static final String GET_ALL_CITIES_BY_COUNTRY_CODE_SQL = "SELECT * FROM City WHERE CountryCode=";

    private static final Map<String, Continent> continentMapper;

    static{
        continentMapper = new HashMap<>();
        continentMapper.put("Asia", Continent.ASIA);
        continentMapper.put("Europe", Continent.EUROPE);
        continentMapper.put("North America", Continent.NORTH_AMERICA);
        continentMapper.put("Africa", Continent.AFRICA);
        continentMapper.put("Oceania", Continent.OCEANIA);
        continentMapper.put("Antarctica", Continent.ANTARCTICA);
        continentMapper.put("South America", Continent.SOUTH_AMERICA);
    }

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_COUNTRIES_SQL);
        ) {
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String continentString = rs.getString("continent");
                Continent continent = continentMapper.get(continentString);
                String region = rs.getString("region");
                float surfaceArea = rs.getFloat("surfaceArea");
                int indepYear = rs.getInt("indepYear");
                int population = rs.getInt("population");
                float lifeExpectancy = rs.getFloat("lifeExpectancy");
                float gnp = rs.getFloat("GNP");
                float gnpOld = rs.getFloat("GNPOld");
                String localName = rs.getString("localName");
                String governmentForm = rs.getString("governmentForm");
                String headOfState = rs.getString("headOfState");
                int capital = rs.getInt("capital");
                String code2 = rs.getString("code2");
                countries.add(new Country(code, name, continent, region, surfaceArea, indepYear,
                        population, lifeExpectancy, gnp, gnpOld, localName, governmentForm,
                        headOfState, capital, code2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public List<City> getAllCities(){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<City> getAllCitiesByCountryCode(String countryCode){
        String query =  String.format(GET_ALL_CITIES_BY_COUNTRY_CODE_SQL+"'%s'", countryCode);
        List<City> cities = new ArrayList<>();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
