package loesninger._13;

public record Country(String code, String name, Continent continent,
                      String region, float surfaceArea, int indepYear, int population,
                      float lifeExpectancy, float gnp, float gnpOld,
                      String localName, String governmentForm, String headOfState,
                      int capital, String code2) {
}
