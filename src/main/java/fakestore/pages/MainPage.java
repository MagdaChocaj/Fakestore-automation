package fakestore.pages;


public class MainPage extends BasePage {
    private final String MainPageUrl        = "https://fakestore.testelka.pl/";
    private final String SELECTOR_HEADER    = "//header[@class='entry-header']/h1";

    public MainPage() {
        super();
    }

    public void openBrowserAndLoadMainPage () {
        currentPage().navigate(MainPageUrl);
    }

    public String getHeader() {
        return getTextFromElement(SELECTOR_HEADER);
    }

    public String returnPageUrl (){
        return currentPage().url();
    }

}
