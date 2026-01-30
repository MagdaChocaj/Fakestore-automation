import fakestore.pages.CartPage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import fakestore.pages.categoryPages.WindsurfingPage;
import fakestore.pages.productPages.windsurfingProducts.ProductGreeceLimnosPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PlaceOrderTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final WindsurfingPage windsurfingPage = new WindsurfingPage();
    private final ProductGreeceLimnosPage productGreeceLimnosPage = new ProductGreeceLimnosPage();
    private final CartPage cartPage = new CartPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Test
    public void placeOrderTest(){
        mainPage.goToShopTab();
        shopPage.selectCategory(1);
        assertEquals("Windsurfing", windsurfingPage.getHeader(), "Category is incorrect");
        String productName = windsurfingPage.getProductName(3);
        windsurfingPage.selectProduct(3);
        assertEquals(productName, productGreeceLimnosPage.getProductName(), "Name of the product is incorrect");
        productGreeceLimnosPage.viewAdditionalInformation();
        productGreeceLimnosPage.viewReviews();
        productGreeceLimnosPage.viewProductDescription();
        productGreeceLimnosPage.increaseQuantity();
        assertNotEquals("1", productGreeceLimnosPage.getQuantity());
        productGreeceLimnosPage.addProductToCart();
        assertThat(productGreeceLimnosPage.getSuccessMessage()).isVisible();
        assertTrue(productGreeceLimnosPage.getSuccessMessageContent().contains("został dodany do koszyka."), "Success message does not match");
        productGreeceLimnosPage.clickViewCartButtonInSuccessMessage();
        cartPage.clickProceedToCheckoutButton();

    }
}
