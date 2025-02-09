package tests.testCases;

import com.revton.qa.dto.CheckoutData;
import com.revton.qa.dto.SearchData;
import com.revton.qa.pages.*;
import com.revton.qa.utils.TestDataUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.RetryAnalyzer;
import tests.base.TestBase;

/**
 * Test class for verifying the complete end-to-end purchase flow.
 */
public class PurchaseFlowTest extends TestBase {

    // Initialize Logger
    private static final Logger logger = LogManager.getLogger(PurchaseFlowTest.class);

    @Test(retryAnalyzer = RetryAnalyzer.class) // Apply RetryAnalyzer for flaky tests
    public void purchaseFlowTest()  {
        logger.info("Starting purchaseFlowTest...");

        // Load test data for checkout and product search
        CheckoutData checkoutData = TestDataUtils.loadCheckoutData();
        SearchData searchData = TestDataUtils.loadSearchData();
        logger.info("Test data loaded successfully.");

        // Page object declarations
        HomePage homePage;
        ProductPage productPage;
        CartPage cartPage;
        CheckoutPage checkoutPage;
        OrderConfirmationPage orderConfirmationPage;

        // Step 1: Navigate to Home Page and verify title
        homePage = new HomePage(driver);
        homePage.navigateToHomPage();
        Assert.assertTrue(homePage.isTitleCorrect(), "Home page title is incorrect!");
        logger.info("Navigated to Home Page and verified title.");

        // Step 2: Search for a product and select it
        productPage = homePage.searchProduct(searchData.getProductName())
                .selectProduct(searchData.getProductName());
        logger.info("Searched for product: " + searchData.getProductName());

        // Validate that the product page opened successfully
        Assert.assertTrue(productPage.isProductPageOpened(searchData.getProductName()), "Product page did not open!");
        logger.info("Product page opened successfully.");

        // Step 3: Add product to the cart message appearance
        cartPage = productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCartSuccessfully(), "Product was not added to the cart!");
        logger.info("Product added to cart successfully.");

        // Navigate to Cart Page and verify product presence
        cartPage.navigateToCartPage();
        Assert.assertTrue(cartPage.isProductAddedToCart(searchData.getProductName()), "Product was not added to the cart!");
        logger.info("Navigated to Cart Page and verified product presence.");

        // Step 4: Proceed to check out and fill the checkout form
        checkoutPage = cartPage.proceedToCheckout()
                .fillCheckoutForm(checkoutData)
                .selectShippingMethod("fixed")  // Select shipping method
                .clickNextButton();             // Proceed to payment
        logger.info("Checkout form filled and shipping method selected.");

        // Assertion: Verify checkout form is filled correctly
        Assert.assertTrue(checkoutPage.isCheckoutFormFilledCorrectly(checkoutData), "Checkout form was not filled correctly!");
        Assert.assertTrue(checkoutPage.isPaymentMethodPageDisplayed(), "Payment Method page was not displayed!");
        logger.info("Checkout form verified and payment method page displayed.");

        // Step 5: Place the order
        orderConfirmationPage = checkoutPage.clickPlaceOrderButton();
        logger.info("Order placed successfully.");

        // Assertion: Verify order confirmation page is displayed
        Assert.assertTrue(orderConfirmationPage.isConfirmationPageSuccessMessageDisplayed(), "Order confirmation page was not displayed!");
        logger.info("Order confirmation page verified.");
    }
}