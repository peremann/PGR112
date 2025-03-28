package eksempler._15.memorabilia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;
    private PropertiesProvider(){}

    static{
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream("files/memorabilia.properties"));
        } catch (IOException e) {
            System.out.println("Unable to load properties:"+e.getMessage());
        }
    }
}
