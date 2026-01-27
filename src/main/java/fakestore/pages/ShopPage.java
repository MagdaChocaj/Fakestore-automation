package fakestore.pages;


import com.microsoft.playwright.Page;

public class ShopPage extends BasePage {

    private final String SHOP_PAGE_URL = "https://fakestore.testelka.pl/shop/";
    private final String SELECTOR_HEADER = "//main [@id = 'main']//h1";
    Page shopPage;


    public ShopPage() {
        super();
    }

    public ShopPage(Page page) {
        this.shopPage = page;
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }
}
