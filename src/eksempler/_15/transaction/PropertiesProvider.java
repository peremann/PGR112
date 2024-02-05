package eksempler._15.transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;

    private PropertiesProvider(){}

    static{
        String appConfigPath = "files/brettspill.properties";
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            System.out.println("Unable to load properties:"+e.getMessage());
        }
    }
}
