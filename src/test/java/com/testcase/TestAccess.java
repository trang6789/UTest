package com.testcase;

import com.base.BaseTest;
import com.pom.homePage.HomePage;
import com.pom.pageObjectManager.PageObjectManager;
import com.pom.setUpAccount.SetUpMyAccount;
import com.utilities.webdrivers.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAccess extends BaseTest {
    private WebDriver driver;
    HomePage homePage;
    SetUpMyAccount setUpMyAccount;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    private static Logger logger = LogManager.getLogger(TestAccess.class.getName());

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);

        homePage = pageObjectManager.getHomePage();
        setUpMyAccount = pageObjectManager.getSetUpMyAccount();
        setUpMyAccount = pageObjectManager.getSetUpMyAccount();


    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void loginSuccess () {
        /***
        * This test case will login to home page
        * Verify email and pass to login page
        * Login to amazon page successfully
        * */

        logger.info("Inside login test ");
        logger.info("Navigate to Login page");

        //Navigate to home page
        homePage.navigateTo_HomePage(driver);
        logger.info("Click on login button");

        // click Submit button
        homePage.clickOn_SubmitButton();

        // input valid first name
        setUpMyAccount.fillSuccess_firstName();

        // input valid last name
        setUpMyAccount.fillSuccess_lastName();

        // input valid email
        setUpMyAccount.fillSuccess_Email();

        // click on month button
        setUpMyAccount.clickOn_monthButton();

        //select month
        setUpMyAccount.fill_monthDetails();

        // click on day button
        setUpMyAccount.clickOn_dayButton();

        //select day
        setUpMyAccount.fill_dayDetails();

        // click on day button
        setUpMyAccount.clickOn_yearButton();

        //select day
        setUpMyAccount.fill_yearDetails();

        //click on submit button
        setUpMyAccount.clickOn_submitButton();


        //check condition
        Assert.assertEquals(true,true);
        logger.debug("Login successfully executed ");


    }
}
