package com.utilities.webdrivers;

import com.utilities.propertyreader.PropertyReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private WebDriver driver;
    private DriverType driverType;
    private EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = PropertyReaderManager.getInstance().getConfigPropertiesReader().getBrowserType();
        environmentType = PropertyReaderManager.getInstance().getConfigPropertiesReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public WebDriver createDriver() {
        switch(environmentType) {
            case LOCAL: driver = createLocalDriver();
                break;
            case REMOTE: driver = createRemoteDriver();
                break;
        }
        return driver;
    }
    public WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    };
    public WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, PropertyReaderManager.getInstance().getConfigPropertiesReader()
                        .getChromeDriverPath());
                driver = new ChromeDriver();
            case FIREFOX:
                //driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
