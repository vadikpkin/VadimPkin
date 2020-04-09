package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String PATH = "src/test/resources/properties/hw3_test_data.properties";

    public static String read(String property) {

        try (InputStream input = new FileInputStream(PATH)) {

            Properties prop = new Properties();

            prop.load(input);

            return (prop.getProperty(property));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        throw new RuntimeException("Property reading failed");
    }

}
