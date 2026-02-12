package fakestore.pages;

import fakestore.actions.Actions;

public class BasePage extends Actions {

    //private final String SELECTOR_TAB                               = "//div[@class = 'primary-navigation']//a";
    private final String SELECTOR_CART_CONTENTS = "//a[@class = 'cart-contents']";
    private final String SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON = "//ul[@class='woocommerce-mini-cart cart_list product_list_widget']//a[1]";
    private final String SELECTOR_GO_TO_PRODUCT_BUTTON = "//ul[@class='woocommerce-mini-cart cart_list product_list_widget']//a[2]";
    private final String SELECTOR_VIEW_CART_BUTTON = "//p[@class='woocommerce-mini-cart__buttons buttons']//a[1]";
    private final String SELECTOR_CHECKOUT_BUTTON = "//p[@class='woocommerce-mini-cart__buttons buttons']//a[2]";
    private final String SELECTOR_SEARCH_FIELD_INPUT = "//input[@id='woocommerce-product-search-field-0']";
    private final String SELECTOR_LOGO_BUTTON = "//a[@class='custom-logo-link']";
    //private final String SELECTOR_BREADCRUMB_NAVIGATION = "//nav[@class = 'woocommerce-breadcrumb']";
    private final String SELECTOR_PRODUCT_CATEGORY_WIDGET = "//div[@id='woocommerce_product_categories-3']";
    private final String SELECTOR_RECENTLY_VIEWED_PRODUCTS_WIDGET = "//div[@id='woocommerce_recently_viewed_products-3']";

    public BasePage() {
        super();
    }

    public void goToTab(String tabName) {

        clickElement(String.format("//div[@class = 'primary-navigation']//a[text() = '%s']", tabName));
    }

    public void clickLogo() {
        clickElement(SELECTOR_LOGO_BUTTON);
    }

    public void goToCart() {
        clickElement(SELECTOR_CART_CONTENTS);
    }

    public void viewCartContents() {
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void cartContentsRemoveProduct() {
        clickElement(SELECTOR_REMOVE_PRODUCT_FROM_CART_BUTTON);
    }

    public void cartContentsGoToProduct() {
        clickElement(SELECTOR_GO_TO_PRODUCT_BUTTON);
    }

    public void cartContentsViewCart() {
        clickElement(SELECTOR_VIEW_CART_BUTTON);
    }

    public void cartContentsGoToCheckout() {
        clickElement(SELECTOR_CHECKOUT_BUTTON);
    }

    public void getCartContents() {
        hoverOverElement(SELECTOR_CART_CONTENTS);
    }

    public void selectBreadcrumbNavigationItem(String itemName) {
        clickElement(String.format("//nav[@class = 'woocommerce-breadcrumb']/a[text() = '%s']", itemName));
    }

    public void searchForText(String searchText) {
        fillInputWithText(SELECTOR_SEARCH_FIELD_INPUT, searchText);
        pressKeyOnKeyboard(SELECTOR_SEARCH_FIELD_INPUT, "Enter");
    }

    public void selectProductCategory(String categoryName) {
        clickElement(String.format("//main[@id = 'main']//section[@class='storefront-product-section storefront-product-categories']//a[contains(@aria-label, '%s')]", categoryName));
    }
}
