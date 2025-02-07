package tests.testCases;

import com.revton.qa.dto.CheckoutData;
import com.revton.qa.dto.SearchData;
import com.revton.qa.pages.*;
import com.revton.qa.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

/**
 * Test class for verifying the complete end-to-end purchase flow.
 */
public class PurchaseFlowTest extends TestBase {

    @Test
    public void testEndToEndPurchaseFlow()  {
        // Load test data for checkout and product search
        CheckoutData checkoutData = TestDataUtils.loadCheckoutData();
        SearchData searchData = TestDataUtils.loadSearchData();

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

        // Step 2: Search for a product and select it
        productPage = homePage.searchProduct(searchData.getProductName())
                .selectProduct(searchData.getProductName());

        // Validate that the product page opened successfully
        Assert.assertTrue(productPage.isProductPageOpened(searchData.getProductName()), "Product page did not open!");

        // Step 3: Add product to the cart
        cartPage = productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCartSuccessfully(), "Product was not added to the cart!");

        // Navigate to Cart Page and verify product presence
        cartPage.navigateToCartPage();
        Assert.assertTrue(cartPage.isProductAddedToCart(searchData.getProductName()), "Product was not added to the cart!");

        // Step 4: Proceed to check out and fill the checkout form
        checkoutPage = cartPage.proceedToCheckout()
                .fillCheckoutForm(checkoutData)
                .selectShippingMethod("fixed")  // Select shipping method
                .clickNextButton();             // Proceed to payment

        // Assertion: Verify checkout form is filled correctly
        Assert.assertTrue(checkoutPage.isCheckoutFormFilledCorrectly(checkoutData), "Checkout form was not filled correctly!");
        Assert.assertTrue(checkoutPage.isPaymentMethodPageDisplayed(), "Payment Method page was not displayed!");

        // Step 5: Place the order
        orderConfirmationPage = checkoutPage.clickPlaceOrderButton();

        // Assertion: Verify order confirmation page is displayed
        Assert.assertTrue(orderConfirmationPage.isConfirmationPageSuccessMessageDisplayed(), "Order confirmation page was not displayed!");
    }
}
