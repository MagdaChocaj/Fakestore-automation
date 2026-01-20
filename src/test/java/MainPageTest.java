import fakestore.pages.BasePage;
import fakestore.pages.MainPage;
import fakestore.pages.ShopPage;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest {

    private final MainPage mainPage = new MainPage();
    private final BasePage basePage = new BasePage();
    private final ShopPage shopPage = new ShopPage();

    @Test
    public void loadBrowserAndOpenMainPageTest() {
        mainPage.openBrowserAndLoadMainPage();
        assertThat(mainPage.currentPage()).hasURL("https://fakestore.testelka.pl/");
        assertEquals("Wybierz podróż dla siebie!", mainPage.getHeader());

    }

    @Test
    public void navigateToShopPageTest(){
        mainPage.openBrowserAndLoadMainPage();
        mainPage.goToShopTab();
        assertEquals("Sklep", shopPage.getHeader());
    }

    @AfterEach
    public void closeBrowser(){
        basePage.closeBrowser();
    }

}
