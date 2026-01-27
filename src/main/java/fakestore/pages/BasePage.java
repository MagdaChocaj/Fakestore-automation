package fakestore.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import fakestore.driver.DriverManager;
import fakestore.driver.INewBrowserContext;

import java.util.Objects;

public class BasePage {

    private final String SELECTOR_SHOP_TAB                      = "//div[@class = 'primary-navigation']//a[text() = 'Sklep']";
    private final String SELECTOR_ORDER_TAB                     = "//div[@class = 'primary-navigation']//a[text() = 'Zamówienie']";
    private final String SELECTOR_BASKET_TAB                    = "//div[@class = 'primary-navigation']//a[text() = 'Koszyk']";
    private final String SELECTOR_MYACCOUNT_TAB                 = "//div[@class = 'primary-navigation']//a[text() = 'Moje konto']";
    private final String SELECTOR_WISHLIST_TAB                  = "//div[@class = 'primary-navigation']//a[text() = 'Lista życzeń']";

    private static DriverManager driverManager = null;


    public BasePage() {
        super();
    }

    public static INewBrowserContext getDriver() {
        if (Objects.isNull(driverManager)) {
            driverManager = new DriverManager();
        }

        return DriverManager.getDriver();
    }

    public void loadUrl(String url) {
        getDriver().currentPage().navigate(url);
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
        System.out.println("Url" + " " + url + " " + "has been loaded");
    }

    public String getUrl() {
        return getDriver().currentPage().url();
    }

    public Page getCurrentPage() {
        return getDriver().currentPage();
    }

    public void closeBrowser() {
        getDriver().currentPage().context().close();
    }

    public Locator getElement(String selector) {
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
        return getDriver().currentPage().locator(selector);
    }

    public String getTextFromElement(String selector) {
        return getElement(selector).innerText();
    }

    public void goToShopTab() {
        getElement(SELECTOR_SHOP_TAB).click();
    }

    public void goToOrderTab() {
        getElement(SELECTOR_ORDER_TAB).click();
    }

    public void goToBasketTab() {
        getElement(SELECTOR_BASKET_TAB).click();
    }

    public void goToMyAccountTab() {
        getElement(SELECTOR_MYACCOUNT_TAB).click();
    }

    public void goToWishlistTab() {
        getElement(SELECTOR_WISHLIST_TAB).click();
    }

    public void scrollDown() {
        getDriver().currentPage().mouse().down();
    }

    public void waitForPage(String url) {
        getDriver().currentPage().waitForURL(url);
        getDriver().currentPage().waitForLoadState(LoadState.LOAD);
        System.out.println("Url" + " " + url + " " + "has been loaded");
    }

    public void verifyIfVisible(String selector){
        getElement(selector).isVisible();
    }

    public void clickElement(String selector) {
        getElement(selector).click();
    }
}
