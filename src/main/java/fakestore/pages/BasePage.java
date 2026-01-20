package fakestore.pages;

import com.microsoft.playwright.*;

import java.util.Objects;

public class BasePage {

    private final String SELECTOR_SHOP_TAB = "//div[@class = 'primary-navigation']//a[text() = 'Sklep']";
    private final String SELECTOR_ORDER_TAB = "//div[@class = 'primary-navigation']//a[text() = 'Zamówienie']";
    private final String SELECTOR_BASKET_TAB = "//div[@class = 'primary-navigation']//a[text() = 'Koszyk']";
    private final String SELECTOR_MYACCOUNT_TAB = "//div[@class = 'primary-navigation']//a[text() = 'Moje konto']";
    private final String SELECTOR_WISHLIST_TAB = "//div[@class = 'primary-navigation']//a[text() = 'Lista życzeń']";

    private Page currentPage;



    private BrowserContext getBrowser() {
        Playwright playwright = Playwright.create();
        BrowserContext browserContext = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)).newContext();
        return browserContext;
    }

    public void setCurrentPage(Page page) {
        this.currentPage = page;
    }

    public Page newPage() {
        setCurrentPage(getBrowser().newPage());
        return currentPage();
    }

    public Page currentPage() {
        if (Objects.isNull(currentPage)) {
            return newPage();
        }
        return currentPage;
    }

    public void loadUrl(String url) {
        currentPage().navigate(url);
    }

    public void closeBrowser() {
        getBrowser().close();
    }

    public Locator getElement(String selector) {
        return currentPage().locator(selector);
    }

    public String getTextFromElement(String selector) {
        return currentPage().locator(selector).innerText();
    }

    public void goToShopTab() {
        currentPage().locator(SELECTOR_SHOP_TAB).click();
    }

    public void goToOrderTab() {
        currentPage().locator(SELECTOR_ORDER_TAB).click();
    }

    public void goToBasketTab() {
        currentPage().locator(SELECTOR_BASKET_TAB).click();
    }

    public void goToMyAccountTab() {
        currentPage().locator(SELECTOR_MYACCOUNT_TAB).click();
    }

    public void goToWishlistTab() {
        currentPage().locator(SELECTOR_WISHLIST_TAB).click();
    }

}
