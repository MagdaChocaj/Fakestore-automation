package fakestore.pages.productPages.climbingProducts;

import fakestore.pages.productPages.BaseProductPage;

public class ProductClimbingViaFerrata extends BaseProductPage {

    private final String VIA_FERRATA_PAGE_URL = "https://fakestore.testelka.pl/product/wspinaczka-via-ferraty/";

    public String getProductName() {
        return getProductTitle();
    }

    public String getURL() {
        return VIA_FERRATA_PAGE_URL;
    }


}
