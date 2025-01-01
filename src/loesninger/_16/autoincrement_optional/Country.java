package loesninger._16.autoincrement_optional;

public record Country(String code, String name, Continent continent,
                      String region, float surfaceArea, int indepYear, int population,
                      float lifeExpectancy, float gnp, float gnpOld,
                      String localName, String governmentForm, String headOfState,
                      int capital, String code2) {
}
