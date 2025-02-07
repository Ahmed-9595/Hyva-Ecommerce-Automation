package com.revton.qa.pages;

import com.revton.qa.utils.ElementActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Feature("Product Page") // Allure feature annotation to categorize tests
public class ProductPage {
    private final WebDriver driver;
    private final ElementActions actions;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    // Dynamic Locator: Product Link by Title
    public By getProductLink(String productName) {
        return By.cssSelector(String.format("a[title='%s']", productName));
    }

    // Static Locators
    private final By addToCartButton = By.id("product-addtocart-button"); // Add to Cart Button
    private final By successMessage = By.xpath("//*[@class='message success']"); // Success Message
    private final By productPageTitle = By.xpath("//*[@class='base' and @data-ui-id = 'page-title-wrapper']"); // Product Page Title

    @Step("Select product") // Step annotation for selecting a product
    public ProductPage selectProduct(String productName) {
        actions.click(getProductLink(productName)); // Use dynamic locator
        return this;
    }

    @Step("Add product to cart") // Step annotation for adding a product to cart
    public CartPage addToCart() {
        actions.click(addToCartButton);
        return new CartPage(driver);
    }

    @Step("Verify if product page is opened for actualProductName")
    public boolean isProductPageOpened(String actualProductName) {
        String productTitleName = actions.getText(productPageTitle).trim();
        boolean isPageOpened = productTitleName.equalsIgnoreCase(actualProductName); // Case-insensitive comparison

        if (!isPageOpened) {
            System.err.println("Mismatch! Expected: " + actualProductName + ", but found: " + productTitleName);
        }
        return isPageOpened;
    }

    @Step("Verify if product is added to cart successfully")
    public boolean isProductAddedToCartSuccessfully() {
        return actions.waitForVisibilityOfElement(successMessage).isDisplayed();
    }
}
