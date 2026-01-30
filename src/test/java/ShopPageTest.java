import fakestore.pages.BasePage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import fakestore.pages.categoryPages.WindsurfingPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopPageTest {

    private final MainPage mainPage = new MainPage();
    private final ShopPage shopPage = new ShopPage();
    private final BasePage basePage = new BasePage();
    private final WindsurfingPage windsurfingPage = new WindsurfingPage();

    @BeforeEach
    public void initializeDriver(){
        mainPage.openBrowserAndLoadMainPage();
    }

    @Order(1)
    @Test
    public void selectCategoryTest(){
        mainPage.goToShopTab();
        shopPage.selectCategory(1);
        assertEquals("Windsurfing", windsurfingPage.getHeader(), "Category is correct");
    }

    @Order(2)
    @Test

    @AfterAll
    public  void closeBrowser(){
        basePage.closeBrowser();
    }
}
