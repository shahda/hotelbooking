package com.packt.hotelbook.utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();

    InputStream inputStream = null;

    public PropertyReader() {
        loadProperties();

    }

    private void loadProperties() {

        try {
            inputStream = new FileInputStream("src/com.packt.hotelbook.utilis/config.properties");
            properties.load(inputStream);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public String reaadProperty(String key) {

        return properties.getProperty(key);
    }
}