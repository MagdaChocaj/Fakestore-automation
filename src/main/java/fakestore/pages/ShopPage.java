package fakestore.pages;

public class ShopPage extends BasePage{

    private final String SHOP_PAGE_URL = "https://fakestore.testelka.pl/shop/";
    private final String SELECTOR_HEADER = "//main [@id = 'main']//h1";

    public ShopPage() {
        super();
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }
}
