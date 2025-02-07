package com.revton.qa.pages;

import com.revton.qa.utils.ConfigUtils;
import com.revton.qa.utils.ElementActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Feature("Home Page") // Allure feature annotation to categorize tests
public class HomePage {
    private final WebDriver driver;
    private final ElementActions actions;

    // Locators for search functionality
    private final By searchButton = By.id("menu-search-icon"); // Search button
    private final By searchInput = By.id("search"); // Search input field
    private final By homePageTitle = By.xpath("//p[contains(text(),'ECOMMERCE MADE HAPPY')]"); // Homepage title locator

    // Constructor for HomePage
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    @Step("Navigate to Home Page") // Step annotation for better Allure reporting
    public void navigateToHomPage() {
        driver.get(ConfigUtils.getInstance().getBaseUrl()); // Open the base URL
    }

    @Step("Verify if Home Page title is correct")
    public boolean isTitleCorrect() {
        return actions.isDisplayed(homePageTitle); // Check if homepage title is displayed
    }

    @Step("Search for product: {productName}")
    public ProductPage searchProduct(String productName) {
        actions.click(searchButton); // Click the search button to open the search bar
        actions.sendKeysWithEnter(searchInput, productName); // Enter product name and press Enter
        return new ProductPage(driver); // Navigate to ProductPage after searching
    }
}
