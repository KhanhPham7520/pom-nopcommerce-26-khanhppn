package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.bankGuru.AbstractBankPageUI;
import pageUIs.bankGuru.RegisterPageUI;

public abstract class AbstractBankPageObject extends AbstractPages {
    /* BANKGURU */
    public void inputTextbox(WebDriver driver, String sendkeyValue, String value) {
        waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX_BANKGURU, value);
        if (value.contains("dob")) {
            removeAttributeInDOM(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX_BANKGURU, "type", value);
        }
        sendKeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX_BANKGURU, sendkeyValue, value);

    }

    public void inputRadioButton(WebDriver driver, String value) {
        waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_RADIO_BANKGURU, value);
        clickToElement(driver, AbstractBankPageUI.DYNAMIC_RADIO_BANKGURU, value);
    }

    public void inputTextArea(WebDriver driver, String sendkeyValue, String value) {
        waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA_BANKGURU, value);
        sendKeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA_BANKGURU, sendkeyValue, value);
    }

    public void clickButton(WebDriver driver, String value) {
        waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_BUTTON_BANKGURU, value);
        clickToElement(driver, AbstractBankPageUI.DYNAMIC_BUTTON_BANKGURU, value);
    }

    public void clickMenuLink(WebDriver driver, String value) {
        waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK, value);
        clickToElement(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK, value);
    }

    public String getBankGuruRowValueByRowName(WebDriver driver, String value) {
        waitToElementVisible(driver, RegisterPageUI.DYNAMIC_RESULT_ROW_DATA, value);
        return getTextElement(driver, RegisterPageUI.DYNAMIC_RESULT_ROW_DATA, value);
    }

    public String getTextMessage(WebDriver driver) {
        waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
        return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
    }

    public String getTextMessageForUpdating(WebDriver driver) {
        waitToElementVisible(driver, RegisterPageUI.UPDATE_SUCCESS_MSG);
        return getTextElement(driver, RegisterPageUI.UPDATE_SUCCESS_MSG);
    }

    public void selectBankGuruDropdownItemByName(WebDriver driver, String dropdownName, String value) {
        waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_DROPDOWN_BANKGURU, dropdownName);
        clickToElement(driver, AbstractBankPageUI.DYNAMIC_DROPDOWN_BANKGURU, dropdownName);
        selectItemInDropdown(driver, AbstractBankPageUI.DYNAMIC_DROPDOWN_BANKGURU, dropdownName, value);
    }

    public String getBankGuruHeaderText(WebDriver driver, String messageValue) {
        waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_BANKGURU_HEADER_TEXT, messageValue);
        return getTextElement(driver, AbstractBankPageUI.DYNAMIC_BANKGURU_HEADER_TEXT, messageValue);
    }
}
