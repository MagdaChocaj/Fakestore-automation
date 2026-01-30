package fakestore.pages;

import com.microsoft.playwright.*;

public class MainPage extends BasePage {

    private final String MAIN_PAGE_URL                          = "https://fakestore.testelka.pl/";
    private final String SELECTOR_HEADER                        = "//header[@class='entry-header']/h1";
    private final String SELECTOR_PRODUCT_CATEGORY_SECTION      = "//section[@aria-label= 'Kategorie produktów']";
    private final String SELECTOR_NEW_PRODUCTS_SECTION          = "//section[@aria-label= 'Najnowsze Produkty']";
    private final String SELECTOR_POPULAR_PRODUCTS_SECTION      = "//section[@aria-label= 'Popularne Produkty']";
    private final String SELECTOR_DISCOUNTED_PRODUCTS_SECTION   = "//section[@aria-label= 'Produkty w promocji']";
    private final String SELECTOR_BESTSELLER_PRODUCTS_SECTION   = "//section[@aria-label= 'Bestsellery']";
    private final String SELECTOR_FIRST_ITEM                    = "//li[1]/a[1]";
    private final String SELECTOR_SECOND_ITEM                   = "//li[2]/a[1]";
    private final String SELECTOR_THIRD_ITEM                    = "//li[3]/a[1]";
    private final String SELECTOR_FOURTH_ITEM                   = "//li[4]/a[1]";

    public MainPage() {
        super();
    }

    public void openBrowserAndLoadMainPage () {
        loadUrl(MAIN_PAGE_URL);
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public Page getMainPage() {
        return getCurrentPage();
    }

    public Locator getProductCategorySection() {
        return getElement(SELECTOR_PRODUCT_CATEGORY_SECTION);
    }

    public Locator getProductSection(String sectionName) {

        String sectionSelector = "";

        if(sectionName == "Nowości"){
            sectionSelector = SELECTOR_NEW_PRODUCTS_SECTION;
        } else if (sectionName == "Popularne") {
            sectionSelector = SELECTOR_POPULAR_PRODUCTS_SECTION;
        } else if (sectionName == "W promocji"){
            sectionSelector = SELECTOR_DISCOUNTED_PRODUCTS_SECTION;
        } else if (sectionName == "Bestsellery") {
            sectionSelector = SELECTOR_BESTSELLER_PRODUCTS_SECTION;
        } else {
            System.out.println("Incorrect section name. Please enter a correct value.");
        }

        return getElement(sectionSelector);
    }

    public void selectCategory(int categoryIndex) {

        switch (categoryIndex) {
            case (1) -> clickElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_FIRST_ITEM);
            case (2) -> clickElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_SECOND_ITEM);
            case (3) -> clickElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_THIRD_ITEM);
            case (4) -> clickElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_FOURTH_ITEM);
        }
    }

    public void selectProductFromSection(String sectionName, int productIndex) {
        String sectionSelector = "";

        if(sectionName == "Nowości"){
            sectionSelector = SELECTOR_NEW_PRODUCTS_SECTION;
        } else if (sectionName == "Popularne") {
            sectionSelector = SELECTOR_POPULAR_PRODUCTS_SECTION;
        } else if (sectionName == "W promocji"){
            sectionSelector = SELECTOR_DISCOUNTED_PRODUCTS_SECTION;
        } else if (sectionName == "Bestsellery") {
            sectionSelector = SELECTOR_BESTSELLER_PRODUCTS_SECTION;
        } else {
            System.out.println("Incorrect section name. Please enter a correct value.");
        }

        switch (productIndex) {
            case (1) -> clickElement(sectionSelector + SELECTOR_FIRST_ITEM);
            case (2) -> clickElement(sectionSelector + SELECTOR_SECOND_ITEM);
            case (3) -> clickElement(sectionSelector + SELECTOR_THIRD_ITEM);
            case (4) -> clickElement(sectionSelector + SELECTOR_FOURTH_ITEM);
        }
    }

    public String getCategoryName(int categoryIndex) {

        String categoryName = null;

        switch (categoryIndex) {
            case (1) -> categoryName = getTextFromElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_FIRST_ITEM);
            case (2) -> categoryName = getTextFromElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_SECOND_ITEM);
            case (3) -> categoryName = getTextFromElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_THIRD_ITEM);
            case (4) -> categoryName = getTextFromElement(SELECTOR_PRODUCT_CATEGORY_SECTION + SELECTOR_FOURTH_ITEM);
        }
        return categoryName;
    }

    public String getProductNameFromSection(String sectionName, int productIndex) {
        String sectionSelector = "";
        String productName = null;

        if(sectionName == "Nowości"){
            sectionSelector = SELECTOR_NEW_PRODUCTS_SECTION;
        } else if (sectionName == "Popularne") {
            sectionSelector = SELECTOR_POPULAR_PRODUCTS_SECTION;
        } else if (sectionName == "W promocji"){
            sectionSelector = SELECTOR_DISCOUNTED_PRODUCTS_SECTION;
        } else if (sectionName == "Bestsellery") {
            sectionSelector = SELECTOR_BESTSELLER_PRODUCTS_SECTION;
        } else {
            System.out.println("Incorrect section name. Please enter a correct value.");
        }

        switch (productIndex) {
            case (1) -> productName = getTextFromElement(sectionSelector + SELECTOR_FIRST_ITEM + "/h2");
            case (2) -> productName = getTextFromElement(sectionSelector + SELECTOR_SECOND_ITEM + "/h2");
            case (3) -> productName = getTextFromElement(sectionSelector + SELECTOR_THIRD_ITEM + "/h2");
            case (4) -> productName = getTextFromElement(sectionSelector + SELECTOR_FOURTH_ITEM + "/h2");
        }
        return productName;
    }

}
