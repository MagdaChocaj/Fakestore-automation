import fakestore.models.Customer;
import fakestore.pages.CartPage;
import fakestore.pages.MainPage;
import fakestore.pages.OrderPage;
import fakestore.pages.ShopPage;
import fakestore.pages.categoryPages.WindsurfingPage;
import fakestore.pages.productPages.windsurfingProducts.ProductGreeceLimnosPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaceOrderTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final WindsurfingPage windsurfingPage = new WindsurfingPage();
    private final ProductGreeceLimnosPage productGreeceLimnosPage = new ProductGreeceLimnosPage();
    private final CartPage cartPage = new CartPage();
    private final OrderPage orderPage = new OrderPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Test
    public void placeOrderTest(){
        mainPage.goToTab("Sklep");
        shopPage.selectCategory(1);
        assertEquals("Windsurfing", windsurfingPage.getHeader(), "Category is incorrect");
        String productName = windsurfingPage.getProductName(3);
        windsurfingPage.selectProduct(3);
        assertEquals(productName, productGreeceLimnosPage.getProductName(), "Name of the product is incorrect");
        productGreeceLimnosPage.viewAdditionalInformation();
        productGreeceLimnosPage.viewReviews();
        productGreeceLimnosPage.viewProductDescription();
        productGreeceLimnosPage.addQuantity("2");
        assertNotEquals("1", productGreeceLimnosPage.getQuantity());
        productGreeceLimnosPage.addProductToCart();
        assertThat(productGreeceLimnosPage.getSuccessMessage()).isVisible();
        productGreeceLimnosPage.clickViewCartButtonInSuccessMessage();
        cartPage.clickProceedToCheckoutButton();
        orderPage.fillConsumerDetailsAndCreateAnAccount();
        orderPage.addAdditionalDetails("Jeśli mnie nie będzie, proszę zostawić paczkę u sąsiada obok.");
        orderPage.fillCardDetails();
        orderPage.goToCheckout();

    }
}
