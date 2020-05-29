package pageUIs;

public class CheckOutPageUI extends AbstractNopCommercePageUI {
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";

    public static final String CONTINUE_BUTTON_BILLING_ADDRESS = "//div[@id='billing-buttons-container']//input[@type='button' and @title='Continue']";

    public static final String CONTINUE_BUTTON_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONTINUE_BUTTON_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONTINUE_BUTTON_PAYMENT_INFO = "//div[@id='payment-info-buttons-container']//following-sibling::input[@value='Continue']";
}
