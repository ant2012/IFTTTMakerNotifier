package ru.ant.iot.ifttt.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ant on 16.05.2016.
 */
public class PropertiesManager extends Loggable {
    private final String APP_PROPERTIES_FILENAME = "app.properties";

    private static PropertiesManager ourInstance = new PropertiesManager();

    public static PropertiesManager getInstance() {
        return ourInstance;
    }

    private final Properties properties;

    public String getProperty(String key){
        return (String) properties.get(key);
    }

    private PropertiesManager() {
        InputStream appPropsStream = ClassLoader.getSystemResourceAsStream(APP_PROPERTIES_FILENAME);
        if (appPropsStream == null) log.error("Error loading properties from " + APP_PROPERTIES_FILENAME);
        properties = new Properties();
        try {
            properties.load(appPropsStream);
        } catch (IOException e) {
            log.error("Error loading properties from " + APP_PROPERTIES_FILENAME);
        }
    }
}