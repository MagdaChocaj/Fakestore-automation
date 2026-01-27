package fakestore.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

public class MainPage extends BasePage {

    private final String MAIN_PAGE_URL                          = "https://fakestore.testelka.pl/";
    private final String SELECTOR_HEADER                        = "//header[@class='entry-header']/h1";
    private final String SELECTOR_PRODUCT_CATEGORY_SECTION      = "//section[@aria-label= 'Kategorie produktów']";
    private final String SELECTOR_WINDSURFING_CATEGORY          = "//a[@href='https://fakestore.testelka.pl/product-category/windsurfing/']";
    private final String SELECTOR_NEW_PRODUCTS_SECTION          = "//section[@aria-label= 'Najnowsze Produkty']";
    private final String SELECTOR_FIRST_NEW_PRODUCT             = "//section[@aria-label= 'Najnowsze Produkty']//li[1]/a[1]";
    private final String SELECTOR_SECOND_NEW_PRODUCT            = "//section[@aria-label= 'Najnowsze Produkty']//li[2]/a[1]";
    private final String SELECTOR_THIRD_NEW_PRODUCT             = "//section[@aria-label= 'Najnowsze Produkty']//li[3]/a[1]";
    private final String SELECTOR_FOURTH_NEW_PRODUCT            = "//section[@aria-label= 'Najnowsze Produkty']//li[4]/a[1]";

    public MainPage() {
        super();
    }

    public void openBrowserAndLoadMainPage () {
        loadUrl(MAIN_PAGE_URL);
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getMainPage(){
        return getCurrentPage();
    }

    public void selectCategory (){

    }

    public Locator getProductCategorySection() {
        return getElement(SELECTOR_PRODUCT_CATEGORY_SECTION);
    }

    public void goToWindsurfingCategory() {
        clickElement(SELECTOR_WINDSURFING_CATEGORY);
    }

    public Locator getNewProductsSection() {
        return getElement(SELECTOR_NEW_PRODUCTS_SECTION);
    }

    public void selectNewProduct(int productIndex) {

        switch(productIndex) {
            case(1):
                clickElement(SELECTOR_FIRST_NEW_PRODUCT);
                break;
            case(2):
                clickElement(SELECTOR_SECOND_NEW_PRODUCT);
                break;
            case(3):
                clickElement(SELECTOR_THIRD_NEW_PRODUCT);
                break;
            case(4):
                clickElement(SELECTOR_FOURTH_NEW_PRODUCT);
                break;
        }
    }

}
