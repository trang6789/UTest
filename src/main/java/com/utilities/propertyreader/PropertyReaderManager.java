package com.utilities.propertyreader;

public class PropertyReaderManager {
    private static PropertyReaderManager instance;
    private static ConfigPropertiesReader configPropertiesReader;
    private static ObjectRepositoryReader objectRepositoryReader;

    // private constructor in singleton design pattern
    private PropertyReaderManager() {}

    public static PropertyReaderManager getInstance() {
        if(instance == null) {
            instance = new PropertyReaderManager();
        }

        return instance;
    }

    public ConfigPropertiesReader getConfigPropertiesReader() {
        return (configPropertiesReader == null) ? new ConfigPropertiesReader() : configPropertiesReader;
    }

    public ObjectRepositoryReader getObjectRepositoryReader() {
        return  (objectRepositoryReader == null) ? new ObjectRepositoryReader() : objectRepositoryReader;
    }
}
