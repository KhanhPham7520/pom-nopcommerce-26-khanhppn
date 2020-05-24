package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;
import pageUIs.bankGuru.AbstractBankPageUI;
import pageUIs.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractBankPageObject {

    private final WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmailEmailID(String email) {
        waitToElementVisible(driver, RegisterPageUI.EMAIL_ID_TXT);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TXT, email);
    }

    public void clickSubmitButton() {
        waitToElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
        clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
    }

    public String getUserIDText() {
        waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
        return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
    }

    public String getPasswordText() {
        waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
        return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
    }

    public EditCustomerPageObject clickMenuLinkToAddress(WebDriver driver, String value) {
        waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK, value);
        clickToElement(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK, value);
        return new EditCustomerPageObject(driver);
    }
}
