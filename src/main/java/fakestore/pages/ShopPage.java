package fakestore.pages;


import com.microsoft.playwright.Page;

public class ShopPage extends BasePage {

    private final String SHOP_PAGE_URL = "https://fakestore.testelka.pl/shop/";
    private final String SELECTOR_HEADER = "//main [@id = 'main']//h1";
    private final String SELECTOR_FIRST_CATEGORY             = "//ul[@class='products columns-3']//li[1]/a[1]";
    private final String SELECTOR_SECOND_CATEGORY            = "//ul[@class='products columns-3']//li[2]/a[1]";
    private final String SELECTOR_THIRD_CATEGORY             = "//ul[@class='products columns-3']//li[3]/a[1]";
    private final String SELECTOR_FOURTH_CATEGORY            = "//ul[@class='products columns-3']//li[4]/a[1]";


    public ShopPage() {
        super();
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public void selectCategory(int categoryIndex) {

        switch(categoryIndex) {
            case(1):
                clickElement(SELECTOR_FIRST_CATEGORY);
                break;
            case(2):
                clickElement(SELECTOR_SECOND_CATEGORY);
                break;
            case(3):
                clickElement(SELECTOR_THIRD_CATEGORY);
                break;
            case(4):
                clickElement(SELECTOR_FOURTH_CATEGORY);
                break;
        }
    }
}
