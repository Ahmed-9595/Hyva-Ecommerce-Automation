package com.revton.qa.pages;

import com.revton.qa.dto.CheckoutData;
import com.revton.qa.utils.ElementActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Feature("Checkout Page") // Allure feature annotation to categorize tests
public class CheckoutPage {
    private final WebDriver driver;
    private final ElementActions actions;

    // Locators for checkout fields
    private final By emailField = By.id("customer-email");
    private final By firstNameField = By.name("firstname");
    private final By lastNameField = By.name("lastname");
    private final By streetField = By.name("street[0]");
    private final By countryDropdown = By.name("country_id");
    private final By stateDropdown = By.name("region_id");
    private final By cityField = By.name("city");
    private final By zipField = By.name("postcode");
    private final By phoneField = By.name("telephone");
    private final By fixedRateOption = By.xpath("//input[@value='flatrate_flatrate']");
    private final By tableRateOption = By.xpath("//input[@value='tablerate_bestway']");
    private final By nextButton = By.xpath("//button[@class='button action continue primary']");
    private final By paymentMethodTitleDisplayed = By.xpath("//div[@data-role=\"title\" and contains(text(),'Payment Method')]");
    private final By placeOrderButton = By.xpath("//button[@class='action primary checkout' and @title='Place Order']");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    @Step("Fill in email field: ")
    public CheckoutPage fillEmailField(String email) {
        actions.sendKeys(emailField, email);
        return this;
    }

    @Step("Fill in first name field")
    public CheckoutPage fillFirstNameField(String firstName) {
        actions.sendKeys(firstNameField, firstName);
        return this;
    }

    @Step("Fill in last name field")
    public CheckoutPage fillLastNameField(String lastName) {
        actions.sendKeys(lastNameField, lastName);
        return this;
    }

    @Step("Fill in street address")
    public CheckoutPage fillStreetField(String street) {
        actions.sendKeys(streetField, street);
        return this;
    }

    @Step("Select country")
    public CheckoutPage selectCountryDropdown(String country) {
        actions.selectByVisibleText(countryDropdown, country);
        return this;
    }

    @Step("Select state")
    public CheckoutPage selectStateDropdown(String state) {
        actions.selectByVisibleText(stateDropdown, state);
        return this;
    }

    @Step("Fill in city")
    public CheckoutPage fillCityField(String city) {
        actions.sendKeys(cityField, city);
        return this;
    }

    @Step("Fill in ZIP code")
    public CheckoutPage fillZipField(String zip) {
        actions.sendKeys(zipField, zip);
        return this;
    }

    @Step("Fill in phone number")
    public CheckoutPage fillPhoneField(String phone) {
        actions.sendKeys(phoneField, phone);
        return this;
    }

    @Step("Fill checkout form with provided data")
    public CheckoutPage fillCheckoutForm(CheckoutData data) {
        return fillEmailField(data.getEmailAddress())
                .fillFirstNameField(data.getFirstName())
                .fillLastNameField(data.getLastName())
                .fillStreetField(data.getStreetAddress())
                .selectCountryDropdown(data.getCountry())
                .selectStateDropdown(data.getStateProvince())
                .fillCityField(data.getCity())
                .fillZipField(data.getZipPostalCode())
                .fillPhoneField(data.getPhoneNumber());
    }

    @Step("Select shipping method")
    public CheckoutPage selectShippingMethod(String method) {
        switch (method.toLowerCase()) {
            case "fixed":
                actions.click(fixedRateOption);
                break;
            case "table":
                actions.click(tableRateOption);
                break;
            default:
                throw new IllegalArgumentException("Invalid shipping method: " + method);
        }
        return this;
    }


    @Step("Verify if checkout form is filled correctly")
    public boolean isCheckoutFormFilledCorrectly(CheckoutData data) {
        return actions.getAttribute(emailField, "value").trim().equals(data.getEmailAddress()) &&
                actions.getAttribute(firstNameField, "value").trim().equals(data.getFirstName()) &&
                actions.getAttribute(lastNameField, "value").trim().equals(data.getLastName()) &&
                actions.getAttribute(streetField, "value").trim().equals(data.getStreetAddress()) &&
                actions.getAttribute(countryDropdown, "value").trim().equals("US") &&
                actions.getAttribute(stateDropdown, "value").trim().equals("12") &&
                actions.getAttribute(cityField, "value").trim().equals(data.getCity()) &&
                actions.getAttribute(zipField, "value").trim().equals(data.getZipPostalCode()) &&
                actions.getAttribute(phoneField, "value").trim().equals(data.getPhoneNumber());
    }

    @Step("Click Next button to proceed to payment")
    public CheckoutPage clickNextButton() {
        actions.click(nextButton);
        return this;
    }

    @Step("Verify if payment method page is displayed")
    public boolean isPaymentMethodPageDisplayed() {
        return actions.isDisplayed(paymentMethodTitleDisplayed);
    }

    @Step("Click Place Order button to complete the purchase")
    public OrderConfirmationPage clickPlaceOrderButton() {
        actions.click(placeOrderButton);
        return new OrderConfirmationPage(driver);
    }
}
