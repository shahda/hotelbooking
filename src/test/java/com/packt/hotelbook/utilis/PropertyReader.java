package com.packt.hotelbook.utilis;

import com.packt.hotelbook.stepDef.Cucumberhooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties = new Properties();

    private InputStream inputStream = null;

    public PropertyReader() {
        loadProperties();

    }

    private void loadProperties() {

        try {

            String propertiespath = Cucumberhooks.projectdirectory + "\\src\\test\\java\\com\\packt\\hotelbook\\utilis\\config.properties" ;
            inputStream = new FileInputStream(propertiespath);
            properties.load(inputStream);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public String reaadProperty(String key) {

        return properties.getProperty(key);
    }
}