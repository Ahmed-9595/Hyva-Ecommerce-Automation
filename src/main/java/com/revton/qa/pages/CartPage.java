package com.revton.qa.pages;

import com.revton.qa.utils.ElementActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Feature("Cart Page") // Allure feature annotation to categorize tests
public class CartPage {
    private final WebDriver driver;
    private final ElementActions actions;
    private final By cartPageButton = By.id("menu-cart-icon"); // Cart icon button
    private final By checkoutButton = By.xpath("//*[@href='https://demo.hyva.io/checkout/']"); // Checkout button

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    @Step("Navigate to Cart Page") // Step annotation for navigating to the cart page
    public void navigateToCartPage() {
        actions.click(cartPageButton);
    }

    // Method to generate the locator for the product link based on the product name
    public By getProductName(String productName) {
        return By.xpath("//a[contains(@aria-label, 'Product \"" + productName.trim() + "\"')]");
    }

    @Step("Verify if product '{productName}' is added to cart") // Step annotation for checking product in cart
    public boolean isProductAddedToCart(String productName) {
        return actions.isDisplayed(getProductName(productName));
    }

    @Step("Proceed to checkout") // Step annotation for proceeding to checkout
    public CheckoutPage proceedToCheckout() {
        driver.findElement(checkoutButton).click(); // Click on the checkout button
        return new CheckoutPage(driver); // Return a new instance of the CheckoutPage class
    }
}
