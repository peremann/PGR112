package eksempler._13.intro;

import java.util.function.Predicate;

public class EFilter implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.toLowerCase().contains("e");
    }
}
