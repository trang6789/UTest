package com.utilities.propertyreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoryReader {
    private Properties properties;
    private final String objectRepositoryFilePath = "src/main/resources/properties/OR.Properties";

    public ObjectRepositoryReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(objectRepositoryFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file is not found at: " + objectRepositoryFilePath);
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
