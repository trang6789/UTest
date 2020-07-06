package com.pom.pageObjectManager;

import com.pom.homePage.HomePage;
import com.pom.setUpAccount.SetUpMyAccount;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private SetUpMyAccount setUpMyAccount;

    //create an object of the page object manager
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    //create an instance of home page
    public HomePage getHomePage(){
        return (homePage == null)? homePage = new HomePage(driver):homePage;
    }

    //create an instance of Login email page
    public SetUpMyAccount getSetUpMyAccount(){
        return (setUpMyAccount == null)? setUpMyAccount = new SetUpMyAccount(driver) : setUpMyAccount;
    }


}
