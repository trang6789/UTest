package com.pom.homePage;

import com.basepage.AbstractBasePage;
import com.utilities.propertyreader.ConfigPropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends AbstractBasePage {
    // Create an instance of ConfigPropertiesReader
    ConfigPropertiesReader configFileReader;

    //Constructor of class HomePage
    // To initialize elements.
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locator of submit button
    @FindBy(xpath = "//*[contains(text(),'Earn money & learn new skills while helping world-class companies deliver amazing digital experiences.')]//following-sibling::a[contains(text(),'Become a uTester')]")
    private WebElement btn_submitHomepage;;

    // Navigate to home page
    public void navigateTo_HomePage(WebDriver driver){
        driver.get("https://www.utest.com/");
    }


    //Click on Sign in button
    public void clickOn_SubmitButton() {
        btn_submitHomepage.click();
    }
}
