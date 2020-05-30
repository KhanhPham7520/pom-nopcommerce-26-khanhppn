package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckOutPageUI;

public class CheckOutPageObject extends AbstractPages {
    WebDriver driver;

    public CheckOutPageObject(WebDriver driver){
        this.driver = driver;
    }

    public String getDynamicTextOfCheckoutPage(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.DYNAMIC_TEXT_PAYMENT_INFO, values);
        return getTextElement(driver, CheckOutPageUI.DYNAMIC_TEXT_PAYMENT_INFO, values);

    }

    public String getTextForBillingInfoConfirmOrderPage(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.BILLING_INFO_CONFIRM_ORDER, values);
        return getTextElement(driver, CheckOutPageUI.BILLING_INFO_CONFIRM_ORDER, values);

    }
    public String getTextForShippingInfoConfirmOrderPage(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.SHIPPING_INFO_CONFIRM_ORDER, values);
        return getTextElement(driver, CheckOutPageUI.SHIPPING_INFO_CONFIRM_ORDER, values);
    }
    public String getTextForCheckOrMoneyPaymentMethod(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.CHECK_OR_MONEY_PAYMENT_METHOD_TEXT, values);
        return getTextElement(driver, CheckOutPageUI.CHECK_OR_MONEY_PAYMENT_METHOD_TEXT, values);
    }
    public String getTextForCreditCardPaymentMethod(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.CREDIT_CARD_PAYMENT_METHOD_TEXT, values);
        return getTextElement(driver, CheckOutPageUI.CREDIT_CARD_PAYMENT_METHOD_TEXT, values);
    }

    public String getTextForConfirmShippingMethod(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.SHIPPING_PAYMENT_METHOD_CONFIRM_ORDER, values);
        return getTextElement(driver, CheckOutPageUI.SHIPPING_PAYMENT_METHOD_CONFIRM_ORDER, values);
    }

    public String getTextConfirmBillingPaymentMethod(WebDriver driver, String... values){
        waitToElementVisible(driver, CheckOutPageUI.BILLING_PAYMENT_METHOD_CONFIRM_ORDER, values);
        return getTextElement(driver, CheckOutPageUI.BILLING_PAYMENT_METHOD_CONFIRM_ORDER, values);
    }

    public void selectNewBillingAddress(WebDriver driver, String selecItem){
        waitToElementClickable(driver, CheckOutPageUI.SELECT_BILLING_ADDRESS);
        selectDropdownByVisibleText(driver, CheckOutPageUI.SELECT_BILLING_ADDRESS, selecItem);
    }

    public String getOrderNumberFromSuccessMessage(){
        waitToElementVisible(driver, CheckOutPageUI.ORDER_NUMBER);
        return getTextElement(driver, CheckOutPageUI.ORDER_NUMBER).substring(13);
    }

    public HomePageObject clickIntoCompleteOrderButton() {
        waitToElementClickable(driver, CheckOutPageUI.CONTINUE_COMPLETED_ORDER);
        clickIntoButton(driver, CheckOutPageUI.CONTINUE_COMPLETED_ORDER);
        return new HomePageObject(driver);
    }
}
