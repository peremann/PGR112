package loesninger._16.australiaSplitUsingDTO_v2;

import java.util.List;

public record Country(String code, String name, String continent,
                      String region, float surfaceArea, int indepYear, int population,
                      float lifeExpectancy, float gnp, float gnpOld,
                      String localName, String governmentForm, String headOfState,
                      int capital, String code2, List<Integer> cityIds, List<CountryLanguage> countryLanguages) {
}
