package com.pom.setUpAccount;

import com.basepage.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SetUpMyAccount extends AbstractBasePage {
    //Constructor of class LoginPageEmail
    // To initialize elements.
    public SetUpMyAccount(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    /***
     * Locators
     * */
    // Locator of first name
    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement txb_firstName;

    // Locator of last name
    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement txb_lastName;

    // Locator of email
    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    // Locator of month button
    @FindBy(xpath = "//*[@id='birthMonth']")
    private WebElement btn_month;

    // Locator of month
    @FindBy(xpath = "//*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']")
    private List<WebElement> monthList;

    // Locator of day button
    @FindBy(xpath = "//*[@id='birthDay']")
    private WebElement btn_day;

    // Locator of day
    @FindBy(xpath = "//*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']")
    private List<WebElement> dayList;

    // Locator of year button
    @FindBy(xpath = "//*[@id='birthYear']")
    private WebElement btn_year;

    // Locator of year
    @FindBy(xpath = "//*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']")
    private List<WebElement> yearList;

    // Locator of submit button
    @FindBy(xpath = "//*[contains(text(),'Next: Location')]")
    private WebElement btn_submit;



    /***
     * Method
     */

    //Send key to first name field
    public void send_firstName(String firstName) {
        sendKeyToTextBox(txb_firstName, firstName);

    }

    //Send key to class name field
    public void send_className(String lastName) {
        sendKeyToTextBox(txb_lastName, lastName);

    }

    //Send key to email field
    public void send_emailName(String email) {
        sendKeyToTextBox(emailField, email);

    }

    //Input valid data into first name textbox
    public void fillSuccess_firstName() {
        send_firstName("Trang");
    }

    //Input valid data into last name textbox
    public void fillSuccess_lastName() {
        send_className("Nguyen");
    }

    //Input valid data into Email textbox
    public void fillSuccess_Email() {
        send_emailName("amazon.test.250620@gmail.com");
    }

    //Click on month button
    public void clickOn_monthButton() {
        submitButton(btn_month);
    }

    //Select month
    public void select_month(int monthNumber){
        clickButton(monthList.get(monthNumber));
    }

    //select option of month
    public void fill_monthDetails() {
        select_month(0);
    }

    //Click on day button
    public void clickOn_dayButton() {
        submitButton(btn_day);
    }


    //Select day
    public void select_day(int dayNumber){
        clickButton(dayList.get(dayNumber));
    }

    //select option of day
    public void fill_dayDetails() {
        select_day(0);
    }

    //Click on year button
    public void clickOn_yearButton() {
        submitButton(btn_year);
    }

    //Select day
    public void select_year(int yearNumber){
        clickButton(yearList.get(yearNumber));
    }

    //select option of day
    public void fill_yearDetails() {
        select_year(0);
    }

    //Click on submit button
    public void clickOn_submitButton() {
        submitButton(btn_submit);
    }


}
