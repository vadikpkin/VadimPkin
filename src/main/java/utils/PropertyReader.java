package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {

    private static final String PATH = "src/test/resources/properties/hw4.properties";

    private PropertyReader() {
    }

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

    public static String readProp(String property, String fileName) {

        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {

            Properties prop = new Properties();

            prop.load(input);

            return (prop.getProperty(property));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        throw new RuntimeException("Property reading failed");
    }

}
