package fakestore.pages.productPages;

import fakestore.pages.BasePage;

public class BaseProductPage extends BasePage {

    private final String SELECTOR_PRODUCT_TITLE                     = "//h1[@class='product_title entry-title']";
    private final String SELECTOR_PRICE                             = "//p[@class='price']//bdi";
    private final String SELECTOR_STOCK_AVAILABILITY                = "//p[@class='stock in-stock']";
    private final String SELECTOR_QUANTITY_INPUT                    = "//div[@class='quantity']/input";
    private final String SELECTOR_ADD_TO_CART_BUTTON                = "//button[@name='add-to-cart']";
    private final String SELECTOR_EXPRESS_CHECKOUT_BUTTON           = "//iframe[@name='__privateStripeFrame5293']";
    private final String SELECTOR_WISHLIST_BUTTON                   = "//a[@class='add_to_wishlist single_add_to_wishlist']";
    private final String SELECTOR_DESCRIPTION_TAB                   = "//li[@id='tab-title-description']/a";
    private final String SELECTOR_ADDITIONAL_INFORMATION_TAB        = "//li[@id='tab-title-additional_information']/a";
    private final String SELECTOR_REVIEWS_TAB                       = "//li[@id='tab-title-reviews']/a";
    private final String SELECTOR_RELATED_PRODUCTS_SECTION          = "//section[@class='related products']";
    private final String SELECTOR_STICKY_ADD_TO_CART_BUTTON         = "//a[@class='storefront-sticky-add-to-cart__content-button button alt']";
    private final String SELECTOR_PREVIOUS_PRODUCT                  = "//nav[@class='storefront-product-pagination']/a[@rel='prev']";
    private final String SELECTOR_NEXT_PRODUCT                      = "//nav[@class='storefront-product-pagination']/a[@rel='next']";


    public String getProductTitle(){
        return getTextFromElement(SELECTOR_PRODUCT_TITLE);
    }

    public String getPrice() {
        return getTextFromElement(SELECTOR_PRICE);
    }

    public String getStockAvailability() {
        return getTextFromElement(SELECTOR_STOCK_AVAILABILITY);
    }

    public void addQuantity(String quantity) {
        inputTextToElement(SELECTOR_QUANTITY_INPUT, quantity);
    }

    public void increaseQuantity() {
        getElement(SELECTOR_QUANTITY_INPUT).focus();
        getElement(SELECTOR_QUANTITY_INPUT).click();
    }

    public void addProductToCart() {
        clickElement(SELECTOR_ADD_TO_CART_BUTTON);
    }

    public void buyProductWithLink() {
        clickElement(SELECTOR_EXPRESS_CHECKOUT_BUTTON);
    }

    public void addProductToWishlist() {
        clickElement(SELECTOR_WISHLIST_BUTTON);
    }

    public void viewProductDescription() {
        clickElement(SELECTOR_DESCRIPTION_TAB);
    }

    public void viewAdditionalInformation() {
        clickElement(SELECTOR_ADDITIONAL_INFORMATION_TAB);
    }

    public void viewReviews() {
        clickElement(SELECTOR_REVIEWS_TAB);
    }

    public void viewRelatedProducts() {
        scrollToElement(SELECTOR_RELATED_PRODUCTS_SECTION);
    }

    public void addProductToCartWithStickyButton() {
        clickElement(SELECTOR_STICKY_ADD_TO_CART_BUTTON);
    }

    public void goToPreviousProduct() {
        clickElement(SELECTOR_PREVIOUS_PRODUCT);
    }

    public void goToNextProduct() {
        clickElement(SELECTOR_NEXT_PRODUCT);
    }


}

