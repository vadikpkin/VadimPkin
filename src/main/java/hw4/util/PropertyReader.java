package hw4.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String read(String property) {

        try (InputStream input = new FileInputStream("src/test/resources/hw4/suites/hw4.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            return (prop.getProperty(property));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
