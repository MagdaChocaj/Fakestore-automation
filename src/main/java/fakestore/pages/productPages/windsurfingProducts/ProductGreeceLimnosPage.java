package fakestore.pages.productPages.windsurfingProducts;

import fakestore.pages.productPages.BaseProductPage;

public class ProductGreeceLimnosPage extends BaseProductPage {

    private final String GREECE_LIMNOS_PAGE_URL = "";

    public String getProductName() {
        return getProductTitle();
    }

    public String getURL() {
        return GREECE_LIMNOS_PAGE_URL;
    }
}
