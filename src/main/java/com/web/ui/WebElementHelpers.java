package com.web.ui;

import org.openqa.selenium.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class WebElementHelpers extends WebElementVerifications {
    private final static Logger LOGGER = Logger.getLogger(WebElementHelpers.class.getName());
    private final Actions action = new Actions(driver);

    public WebElementHelpers(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendKeyToTextBox(final WebElement editBox, final String valueToType) {
        waitForElementToBeVisible(editBox);
        LOGGER.info("Clear text in text box");
        editBox.clear();
        LOGGER.info(String.format("Send keys: %s into text box", valueToType));
        editBox.sendKeys(valueToType);
    }

    public void clearCommand(final WebElement clearCommand) {
        waitForElementToBeVisible(clearCommand);
        LOGGER.info("Clear command");
        clearCommand.clear();
    }


    public void submitButton(final WebElement submitButton){
        waitForElementToBeClickable(submitButton);
        LOGGER.info("The button is submitted");
        submitButton.submit();
    }

    public boolean isElementDisplayedOnPage(final WebElement element){
        waitForElementToBeVisible(element);
        if(element.isDisplayed()){
            LOGGER.info("The element is displayed");
            return true;
        }
        else {
            LOGGER.info("The element is not displayed");
            return false;
        }
    }

    public String getTextInElement(final WebElement element){
        waitForElementToBeVisible(element);
        LOGGER.info("Get text inner of Element");
        String textInElement = element.getText();
        return textInElement;
    }

    public void IsSelectedCommand(final WebElement selectCommand) {
        waitForElementToBeVisible(selectCommand);
        LOGGER.info("Select command");
        selectCommand.isSelected();
    }

    public void getCssValueCommand(final WebElement getValue, final String returnValue) {
        waitForElementToBeVisible(getValue);
        LOGGER.info("Get CSS value");
        getValue.getCssValue(returnValue);
    }

    public void getAttributeCommand(final WebElement getAttribute, final String returnValue) {
        waitForElementToBeVisible(getAttribute);
        LOGGER.info("Get attribute of element.");
        getAttribute.getAttribute(returnValue);
    }

    public void getLocationOfElement(final WebElement element){
        waitForElementToBeVisible(element);
        Point location = element.getLocation();
        LOGGER.info("X cordinate: "+location.getX() +"Y cordinate: "+location.getY());
    }

    //Click Command by WebElement
    public void clickButton(final WebElement clickbtn){
        waitForElementToBeClickable(clickbtn);
        LOGGER.info("Button is clicked.");
        clickbtn.click();
    }

    //IsEnabled Command
    public boolean IsEnabledElement(final WebElement element){
        waitForElementToBeVisible(element);
        if (element.isEnabled()){
            LOGGER.info("The element is enabled.");
            return true;
        }
        else {
            LOGGER.info("The element is not enabled.");
            return false;
        }
    }

    //GetTagName Command
    public String getTagName(final WebElement element){
        waitForElementToBeVisible(element);
        LOGGER.info("Tag name of the element: "+ element.getTagName());
        return element.getTagName();
    }

    //getSize Command
    public Dimension getSize(final WebElement element){
        waitForElementToBeVisible(element);
        Dimension elementSize = element.getSize();
        LOGGER.info("Width of the element: " + elementSize.getWidth());
        LOGGER.info("Height of the element: " + elementSize.getHeight());
        return elementSize;
    }

}
