package pageUIs;

public class CheckOutPageUI extends AbstractPageUI {
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";

    public static final String CONTINUE_BUTTON_BILLING_ADDRESS = "//div[@id='billing-buttons-container']//input[@type='button' and @title='Continue']";

    public static final String CONTINUE_BUTTON_SHIPPING_ADDRESS = "//div[@id='shipping-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONTINUE_BUTTON_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONTINUE_BUTTON_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONTINUE_BUTTON_PAYMENT_INFO = "//div[@id='payment-info-buttons-container']//following-sibling::input[@value='Continue']";

    public static final String CONFIRM_ORDER_BUTTON = "//div[@id='confirm-order-buttons-container']//following-sibling::input[@value='Confirm']";

    public static final String DYNAMIC_TEXT_PAYMENT_INFO = "//b[contains(text(),'%s')]";

    public static final String BILLING_INFO_CONFIRM_ORDER = "//div[@class='billing-info']//ul//li[@class='%s']";

    public static final String SHIPPING_INFO_CONFIRM_ORDER = "//div[@class='shipping-info']//ul//li[@class='%s']";

    public static final String CHECK_OR_MONEY_PAYMENT_METHOD_TEXT = "//input[@value='Payments.CheckMoneyOrder']//following-sibling::label";

    public static final String CREDIT_CARD_PAYMENT_METHOD_TEXT = "//input[@value='Payments.Manual']//following-sibling::label";

    public static final String CREDIT_CARD_PAYMENT_METHOD_RADIO = "//label[contains(text(),'Credit Card')]//preceding-sibling::input[@type='radio']";

    public static final String BILLING_PAYMENT_METHOD_CONFIRM_ORDER = "//li[@class='payment-method']//span[contains(text(),'Payment Method:')]//following-sibling::span[contains(text(),'%s')]";

    public static final String SHIPPING_PAYMENT_METHOD_CONFIRM_ORDER = "//li[@class='shipping-method']//span[contains(text(),'Shipping Method:')]//following-sibling::span[contains(text(),'%s')]";

    public static final String SELECT_BILLING_ADDRESS = "//select[@name='billing_address_id']";

    public static final String CONTINUE_AFTER_INPUT_CARD = "//input[@class='button-1 payment-info-next-step-button']";

    public static final String THANK_YOU_ORDER_COMPLETE_MESSAGE = "//div[@class='page checkout-page order-completed-page']//div[@class='page-title']//h1";

    public static final String ORDER_SUCESSFULLY_PROCESSED_MESSAGE = "//div[@class='section order-completed']//div[@class='title']//strong";

    public static final String ORDER_NUMBER = "//div[@class='order-number']//strong";

    public static final String CONTINUE_COMPLETED_ORDER = "//input[@class='button-1 order-completed-continue-button']";
}
