package myproject.com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class Property {
    private static Properties properties;

    public static String getData(String key) {
        return getDataProperty("src/main/resources/data.properties", key);
    }

    private static String getDataProperty(String Path, String Key) {
        String propertyValue = null;
        try (FileInputStream fis = new FileInputStream(Path)) {
            properties = new Properties();
            PropertyResourceBundle resourceBundle = new PropertyResourceBundle(new InputStreamReader(fis));
            propertyValue = resourceBundle.getString(Key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}