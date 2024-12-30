package eksempler._13.intro;

import java.util.function.Consumer;

public class StringPrinter implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
