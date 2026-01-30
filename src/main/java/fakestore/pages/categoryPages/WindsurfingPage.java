package fakestore.pages.categoryPages;

import com.microsoft.playwright.Page;
import fakestore.pages.MainPage;

public class WindsurfingPage extends MainPage {
    private final String SELECTOR_HEADER                        = "//header[@class='woocommerce-products-header']/h1";
    private final String WINDSURFING_PAGE_URL                   = "https://fakestore.testelka.pl/product-category/windsurfing/";
    private final String SELECTOR_FIRST_PRODUCT                 = "//ul[@class='products columns-3']//li[1]/a[1]";
    private final String SELECTOR_SECOND_PRODUCT                = "//ul[@class='products columns-3']//li[2]/a[1]";
    private final String SELECTOR_THIRD_PRODUCT                 = "//ul[@class='products columns-3']//li[3]/a[1]";
    private final String SELECTOR_FOURTH_PRODUCT                = "//ul[@class='products columns-3']//li[4]/a[1]";
    private final String SELECTOR_FIFTH_PRODUCT                 = "//ul[@class='products columns-3']//li[4]/a[1]";
    private final String SELECTOR_SIXTH_PRODUCT                 = "//ul[@class='products columns-3']//li[4]/a[1]";


    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getWindurfingPage(){
        return getCurrentPage();
    }

    public void waitForWindsurfingPage() {
        waitForPage(WINDSURFING_PAGE_URL);
    }

    public void selectProduct(int productIndex) {

        switch(productIndex) {
            case(1):
                clickElement(SELECTOR_FIRST_PRODUCT);
                break;
            case(2):
                clickElement(SELECTOR_SECOND_PRODUCT);
                break;
            case(3):
                clickElement(SELECTOR_THIRD_PRODUCT);
                break;
            case(4):
                clickElement(SELECTOR_FOURTH_PRODUCT);
                break;
            case(5):
                clickElement(SELECTOR_FIFTH_PRODUCT);
                break;
            case(6):
                clickElement(SELECTOR_SIXTH_PRODUCT);
                break;
        }
    }

    public String getProductName(int productIndex) {

        String productName = "";
        switch(productIndex) {
            case (1):
                productName = getTextFromElement(SELECTOR_FIRST_PRODUCT + "/h2");
                break;
            case (2):
                productName = getTextFromElement(SELECTOR_SECOND_PRODUCT + "/h2");
                break;
            case (3):
                productName = getTextFromElement(SELECTOR_THIRD_PRODUCT + "/h2");
                break;
            case (4):
                productName = getTextFromElement(SELECTOR_FOURTH_PRODUCT + "/h2");
                break;
            case (5):
                productName = getTextFromElement(SELECTOR_FIFTH_PRODUCT + "/h2");
                break;
        }
        return productName;
    }
}
