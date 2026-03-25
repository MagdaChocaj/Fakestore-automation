package fakestore.pages.Base;

import com.microsoft.playwright.Page;

public class CategoryPage extends BasePage {

    private final String SELECTOR_HEADER                        = "//header[@class='woocommerce-products-header']/h1";


    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getCategoryPage(){
        return getCurrentPage();
    }

    public void selectProduct(int productIndex) {

    }

    public String getProductName(int productIndex) {

        String productName = "";


        return productName;
    }
}
