package fakestore.pages;

import fakestore.actions.Actions;

public class BasePage extends Actions {

    private final String SELECTOR_MAIN_PAGE_TAB                     = "//div[@class = 'primary-navigation']//a[text() = 'Strona główna']";
    private final String SELECTOR_SHOP_TAB                          = "//div[@class = 'primary-navigation']//a[text() = 'Sklep']";
    private final String SELECTOR_ORDER_TAB                         = "//div[@class = 'primary-navigation']//a[text() = 'Zamówienie']";
    private final String SELECTOR_CART_TAB                          = "//div[@class = 'primary-navigation']//a[text() = 'Koszyk']";
    private final String SELECTOR_MYACCOUNT_TAB                     = "//div[@class = 'primary-navigation']//a[text() = 'Moje konto']";
    private final String SELECTOR_WISHLIST_TAB                      = "//div[@class = 'primary-navigation']//a[text() = 'Lista życzeń']";
    private final String SELECTOR_CART_CONTENTS                     = "//a[@class = 'cart-contents']";
    private final String SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON   = "//ul[@class='woocommerce-mini-cart cart_list product_list_widget']//a[1]";
    private final String SELECTOR_GO_TO_PRODUCT_BUTTON              = "//ul[@class='woocommerce-mini-cart cart_list product_list_widget']//a[2]";
    private final String SELECTOR_VIEW_CART_BUTTON                  = "//p[@class='woocommerce-mini-cart__buttons buttons']//a[1]";
    private final String SELECTOR_CHECKOUT_BUTTON                   = "//p[@class='woocommerce-mini-cart__buttons buttons']//a[2]";;
    private final String SELECTOR_SEARCH_FIELD_INPUT                = "//input[@id='woocommerce-product-search-field-0']";
    private final String SELECTOR_LOGO_BUTTON                       = "//a[@class='custom-logo-link']";
    private final String SELECTOR_BREADCRUMB_NAVIGATION             = "//nav[@class = 'woocommerce-breadcrumb']";
    private final String SELECTOR_PRODUCT_CATEGORY_WIDGET           = "//div[@id='woocommerce_product_categories-3']";
    private final String SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET   = "//div[@id='woocommerce_recently_viewed_products-3']";
    private final String SELECTOR_FIRST_ITEM                        = "//li[1]/a[1]";
    private final String SELECTOR_SECOND_ITEM                       = "//li[2]/a[1]";
    private final String SELECTOR_THIRD_ITEM                        = "//li[3]/a[1]";
    private final String SELECTOR_FOURTH_ITEM                       = "//li[4]/a[1]";


    public BasePage() {
        super();
    }

    public void goToMainPageTab() {
        clickElement(SELECTOR_MAIN_PAGE_TAB);
    }

    public void goToShopTab() {
        clickElement(SELECTOR_SHOP_TAB);
    }

    public void goToOrderTab() {
        clickElement(SELECTOR_ORDER_TAB);
    }

    public void goToCartTab() {
        clickElement(SELECTOR_CART_TAB);
    }

    public void goToMyAccountTab() {
        clickElement(SELECTOR_MYACCOUNT_TAB);
    }

    public void goToWishlistTab() {
        clickElement(SELECTOR_WISHLIST_TAB);
    }

    public void clickLogo(){
        clickElement(SELECTOR_LOGO_BUTTON);
    }

    public void goToCart() {
        clickElement(SELECTOR_CART_CONTENTS);
    }

    public void viewCartContents() {
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void cartContentsRemoveProduct(){
        clickElement(SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON);
    }

    public void cartContentsGoToProduct(){
        clickElement(SELECTOR_GO_TO_PRODUCT_BUTTON);
    }

    public void cartContentsViewCart(){
        clickElement(SELECTOR_VIEW_CART_BUTTON);
    }

    public void cartContentsGoToCheckout(){
        clickElement(SELECTOR_CHECKOUT_BUTTON);
    }

    public void getCartContents(){
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void selectBreadcrumbNavigationItem(int itemIndex){

        switch(itemIndex){
            case (1):
                clickElement(SELECTOR_BREADCRUMB_NAVIGATION + "/a[1]");
                break;
            case(2):
                clickElement(SELECTOR_BREADCRUMB_NAVIGATION + "/a[2]");
                break;
        }
    }

    public void searchForText (String searchText) {
        fillInputWithText(SELECTOR_SEARCH_FIELD_INPUT, searchText);
        pressKeyOnKeyboard(SELECTOR_SEARCH_FIELD_INPUT, "Enter");
    }

    public void selectProductCategory(int categoryIndex){

        switch (categoryIndex) {
            case (1) -> clickElement(SELECTOR_PRODUCT_CATEGORY_WIDGET + SELECTOR_FIRST_ITEM);
            case (2) -> clickElement(SELECTOR_PRODUCT_CATEGORY_WIDGET + SELECTOR_SECOND_ITEM);
            case (3) -> clickElement(SELECTOR_PRODUCT_CATEGORY_WIDGET + SELECTOR_THIRD_ITEM);
            case (4) -> clickElement(SELECTOR_PRODUCT_CATEGORY_WIDGET + SELECTOR_FOURTH_ITEM);
        }
    }

    public void selectLastViewedProduct(int productIndex){

        switch (productIndex) {
            case (1) -> clickElement(SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET + SELECTOR_FIRST_ITEM);
            case (2) -> clickElement(SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET + SELECTOR_SECOND_ITEM);
            case (3) -> clickElement(SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET + SELECTOR_THIRD_ITEM);
            case (4) -> clickElement(SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET + SELECTOR_FOURTH_ITEM);
        }
    }
}
