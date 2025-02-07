package com.revton.qa.pages;

import com.revton.qa.utils.ElementActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Feature("Order Confirmation Page") // Allure feature annotation to categorize tests
public class OrderConfirmationPage {
    private final WebDriver driver;
    private final ElementActions actions;
    private final By successMessage = By.xpath("//span[@class='base' and text()='Thank you for your purchase!']"); // Success message locator

    // Constructor
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    @Step("Verify if order confirmation success message is displayed") // Step annotation for verification
    public boolean isConfirmationPageSuccessMessageDisplayed() {
        return actions.waitForVisibilityOfElement(successMessage).isDisplayed(); // Check if success message is visible
    }
}
