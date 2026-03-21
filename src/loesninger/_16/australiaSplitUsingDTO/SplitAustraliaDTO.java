package loesninger._16.australiaSplitUsingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record SplitAustraliaDTO(ArrayList<Country> newCountries, ArrayList<CountryLanguage> newCountryLanguages,
                                HashMap<String, List<Integer>> citiesInCountries) {
}
