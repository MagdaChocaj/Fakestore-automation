package fakestore.pages;

import com.microsoft.playwright.*;

public class MainPage extends BasePage {

    private final String MAIN_PAGE_URL                          = "https://fakestore.testelka.pl/";
    private final String SELECTOR_HEADER                        = "//header[@class='entry-header']/h1";
    private final String SELECTOR_SECTION                       = "//main[@id = 'main']//section[@class='storefront-product-section storefront-product-categories']";


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
        return getElement(SELECTOR_SECTION);
    }

    public Locator getProductSection(String sectionName) {
        return getElement(String.format("//main[@id = 'main']//section/h2[text() = '%s']",sectionName));
    }

    public void selectProductFromSection(String sectionName, String productName) {
        clickElement(String.format("//main[@id = 'main']//section/h2[text() = '%s']/preceding::section//h2[text() = '%s']/parent::a",sectionName,productName));

    }

    /*public String getProductNameFromSection(String sectionName, int productIndex) {
        String productName = getTextFromElement(String.format("//main[@id = 'main']//section/h2[text() = '%s']/preceding::section//a",sectionName, productIndex));

        return productName;
    }

     */



}
