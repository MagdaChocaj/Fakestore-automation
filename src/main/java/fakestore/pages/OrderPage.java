package fakestore.pages;

import fakestore.models.Customer;
import fakestore.models.PaymentDetails;
import fakestore.pages.Base.BasePage;

public class OrderPage extends BasePage {

    private final String SELECTOR_EMAIL_INPUT                               = "";
    private final String SELECTOR_FIRST_NAME_INPUT                          = "";
    private final String SELECTOR_LAST_NAME_INPUT                           = "";
    private final String SELECTOR_STREET_INPUT                              = "";
    private final String SELECTOR_POSTAL_CODE_INPUT                         = "";
    private final String SELECTOR_CITY_INPUT                                = "";
    private final String SELECTOR_PHONE_NUMBER_INPUT                        = "";
    private final String SELECTOR_CREATE_ACCOUNT_CHECKBOX                   = "";
    private final String SELECTOR_PASSWORD_INPUT                            = "";
    private final String SELECTOR_SHOW_PASSWORD_BUTTON                      = "";
    private final String SELECTOR_ADDITIONAL_INFORMATION_INPUT              = "";
    private final String SELECTOR_COUNTRY_DROPDOWN                          = "";
    private final String SELECTOR_CARD_NUMBER_INPUT                         = "";
    private final String SELECTOR_CARD_EXPIRATION_DATE_INPUT                = "";;
    private final String SELECTOR_CARD_CVC_NUMBER                           = "";
    private final String SELECTOR_BLIK_RADIO_BUTTON                         = "";
    private final String SELECTOR_CARD_RADIO_BUTTON                         = "";
    private final String SELECTOR_BLIK_CODE_INPUT                           = "";
    private final String SELECTOR_ACCEPT_TERMS_AND_CONDITIONS_CHECKBOX      = "";
    private final String SELECTOR_PLACE_ORDER_BUTTON                        = "";

    Customer customer = new Customer();
    PaymentDetails paymentDetails = new PaymentDetails();
    String password;

    public void fillConsumerDetailsAndCreateAnAccount() {
        inputTextToElement(SELECTOR_EMAIL_INPUT, customer.getEmail());
        inputTextToElement(SELECTOR_FIRST_NAME_INPUT, customer.getFirstName());
        inputTextToElement(SELECTOR_LAST_NAME_INPUT, customer.getLastName());
        inputTextToElement(SELECTOR_STREET_INPUT, customer.getAddress());
        inputTextToElement(SELECTOR_POSTAL_CODE_INPUT, customer.getPostalCode());
        inputTextToElement(SELECTOR_CITY_INPUT, customer.getCity());
        inputTextToElement(SELECTOR_PHONE_NUMBER_INPUT, customer.getPhoneNumber());
        clickElement(SELECTOR_CREATE_ACCOUNT_CHECKBOX);
        inputTextToElement(SELECTOR_PASSWORD_INPUT, customer.generatePassword());
        clickElement(SELECTOR_SHOW_PASSWORD_BUTTON);
    }

    public void addAdditionalDetails(String text) {
        inputTextToElement(SELECTOR_ADDITIONAL_INFORMATION_INPUT, text);
    }

    public void fillCardDetails() {
        inputTextToElement(SELECTOR_CARD_NUMBER_INPUT, paymentDetails.getCardNumber());
        inputTextToElement(SELECTOR_CARD_EXPIRATION_DATE_INPUT, paymentDetails.getCardExpirationDate());
        inputTextToElement(SELECTOR_CARD_CVC_NUMBER, paymentDetails.getCardCVCCode());
    }

    public void goToCheckout() {
        clickElement(SELECTOR_ACCEPT_TERMS_AND_CONDITIONS_CHECKBOX);
        clickElement(SELECTOR_PLACE_ORDER_BUTTON);
    }

    public void payWithBlik() {
        clickElement(SELECTOR_BLIK_RADIO_BUTTON);
        inputTextToElement(SELECTOR_BLIK_CODE_INPUT, paymentDetails.getBlikCode());

    }
}
