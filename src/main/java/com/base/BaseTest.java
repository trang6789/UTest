package com.base;

import com.utilities.propertyreader.PropertyReaderManager;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private WebDriver driver;
    public WebDriverManager webDriverManager;
    public Properties OR;
    private static Logger logger = LogManager.getLogger(BaseTest.class.getName());;
    private static final String screenShotsFolder = "Screenshots";

    public WebDriver getDriver() {
        if (driver == null) {
            webDriverManager = new WebDriverManager();
            driver = webDriverManager.getDriver();
            OR = PropertyReaderManager.getInstance().getObjectRepositoryReader().getProperties();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public String getScreenshotPath(String result, WebDriver driver) throws IOException {

        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+result+".png";
        FileHandler.copy(source,new File(destinationFile));
        return destinationFile;

    }
}
