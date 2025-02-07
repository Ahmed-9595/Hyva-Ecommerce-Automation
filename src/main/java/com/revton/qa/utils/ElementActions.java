package com.revton.qa.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ElementActions {

    private final WebDriver driver;
    private final FluentWait<WebDriver> wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    // Click an element
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Send text to a field
    public void sendKeysWithEnter(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text ,Keys.ENTER);
    }
    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Check if element is displayed
    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Select a value from a dropdown by visible text
    public void selectByVisibleText(By locator, String value) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        dropdown.selectByVisibleText(value);
    }

    // Get attribute value of an element
    public String getAttribute(By locator, String attributeName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attributeName);
    }


   // Check if an element is enabled
    public boolean isEnabled(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }

    // Wait for element to be visible
    public WebElement waitForVisibilityOfElement(By locator) {
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element ;
    }

     // Wait for element to be clickable

    public WebElement waitForElementToBeClickable(By locator) {
        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element ;
    }
    // Wait for element to be presense
    public WebElement waitForPresenceOfElement(By locator) {
        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element ;
    }

}

