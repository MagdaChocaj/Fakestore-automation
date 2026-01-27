package fakestore.pages.categoryPages;

import com.microsoft.playwright.Page;
import fakestore.pages.MainPage;

public class WindsurfingPage extends MainPage {
    private final String SELECTOR_HEADER                        = "//header[@class='woocommerce-products-header']/h1";
    private final String WINDSURFING_PAGE_URL                   = "https://fakestore.testelka.pl/product-category/windsurfing/";

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getWindurfingPage(){
        return getCurrentPage();
    }

    public void waitForWindsurfingPage() {
        waitForPage(WINDSURFING_PAGE_URL);
    }
}
