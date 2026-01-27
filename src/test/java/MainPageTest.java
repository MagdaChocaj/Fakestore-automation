import fakestore.pages.BasePage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import fakestore.pages.categoryPages.WindsurfingPage;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest {

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
    public void loadBrowserAndOpenMainPageTest() {
        assertThat(mainPage.getMainPage()).hasURL("https://fakestore.testelka.pl/");
        assertEquals("Wybierz podróż dla siebie!", mainPage.getHeader(), "Header is correct");

    }

    @Order(2)
    @Test
    public void navigateToShopPageTest() {
        mainPage.goToShopTab();
        assertEquals("Sklep", shopPage.getHeader(), "Header is correct");
    }

    @Order(3)
    @Test
    public void selectCategoryTest(){
        assertThat(mainPage.getProductCategorySection()).isVisible();
        mainPage.goToWindsurfingCategory();
        assertEquals("Windsurfing", windsurfingPage.getHeader(), "Header is correct");
        assertThat(windsurfingPage.getWindurfingPage()).hasURL("https://fakestore.testelka.pl/product-category/windsurfing/");
    }
    @Order(4)
    @Test
    public void selectNewProductTest(){
        assertThat(mainPage.getNewProductsSection()).isVisible();
        mainPage.selectNewProduct(2);

    }

    @AfterAll
    public void closeBrowser(){
        basePage.closeBrowser();
    }

}
