package com.utilities.propertyreader;

import com.utilities.webdrivers.DriverType;
import com.utilities.webdrivers.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {
    private Properties properties;
    private final String configPropertiesFilePath = "src/main/resources/properties/Config.Properties";

    // Read and load properties file
    public ConfigPropertiesReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(configPropertiesFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("Configuration file is not found at: " + configPropertiesFilePath);
        }
    }

    //=============================================================================================
    // Get Browser Type
    public DriverType getBrowserType() {
        String browserType = properties.getProperty("browser");
        if(browserType == null || browserType.equalsIgnoreCase("chrome")) {
            return DriverType.CHROME;
        } else if(browserType.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else {
            throw new RuntimeException("Browser Name Key value in Config.Properties file is not matched : " + browserType);
        }
    }

    // getEnvironment
    public EnvironmentType getEnvironment() {
        String environmentType = properties.getProperty("environment");
        if(environmentType == null || environmentType.equalsIgnoreCase("local")) {
            return EnvironmentType.LOCAL;
        } else if(environmentType.equals("remote")) {
            return EnvironmentType.REMOTE;
        } else {
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentType);
        }

    }

    //=============================================================================================
    // get path of driver folder
    public String getChromeDriverPath() {
        String driverPath = properties.getProperty("chromeDriverPath");
        if(driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("driverPath not specified in the Config.properties file.");
        }
    }

    public String getApplicationURL() {
        String baseURL = properties.getProperty("baseUrl");
        if(baseURL != null) {
            return baseURL;
        } else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }

    public long getImplicitWaitTime() {
        if(properties.getProperty("ImplicitWaitTime") != null) {
            int implicitWaitTime = Integer.parseInt( properties.getProperty("ImplicitWaitTime"));
            return implicitWaitTime;
        } else {
            throw new RuntimeException("There's no specific implicit wait time configured in property file");
        }

    }
}
