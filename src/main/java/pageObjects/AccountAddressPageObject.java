package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.AccountAddressPageUI;
import pageUIs.MyAccountPageUI;

public class AccountAddressPageObject extends AbstractPages {
    private final WebDriver driver;
    private Select select;

    public AccountAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewButton() {
        waitToElementClickable(driver, MyAccountPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADD_NEW_ADDRESS_BUTTON);
    }

    public void inputFirstNameTextbox(String inputValue) {
        sendKeyToElement(driver, AccountAddressPageUI.FIRST_NAME_TEXTBOX, inputValue);
    }

    public void inputLastNameTextbox(String inputValue) {
        sendKeyToElement(driver, AccountAddressPageUI.LAST_NAME_TEXTBOX, inputValue);
    }

    public void selectContryValue(String selectCountryValue) {
        waitToElementClickable(driver, AccountAddressPageUI.COUNTRY_SELECT);
        select = new Select(findElementByXpath(driver, AccountAddressPageUI.COUNTRY_SELECT));

        clickToElement(driver, AccountAddressPageUI.COUNTRY_SELECT);
        select.selectByVisibleText(selectCountryValue);
    }

    public void inputCityTextbox(String inputCity) {
        sendKeyToElement(driver, AccountAddressPageUI.CITY_TEXTBOX, inputCity);
    }

    public void inputEmailTextbox(String inputEmail) {
        sendKeyToElement(driver, AccountAddressPageUI.EMAIL_TEXTBOX, inputEmail);
    }

    public void inputAddress1Textbox(String inputAddress) {
        sendKeyToElement(driver, AccountAddressPageUI.ADDRESS_1_TEXTBOX, inputAddress);

    }

    public void inputPostalTextbox(String postalValue) {
        sendKeyToElement(driver, AccountAddressPageUI.POSTAL_CODE_TEXTBOX, postalValue);

    }

    public void inputPhoneNumberTextbox(String inputPhoneNumber) {
        sendKeyToElement(driver, AccountAddressPageUI.PHONE_NUMBER_TEXTBOX, inputPhoneNumber);

    }

    public void clickSaveButton() {
        clickIntoButton(driver, AccountAddressPageUI.SAVE_BUTTON);
    }

}
