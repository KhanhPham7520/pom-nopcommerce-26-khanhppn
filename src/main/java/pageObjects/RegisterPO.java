package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.AbstractPageUI;
import pageUIs.RegisterPageUI;

import java.util.Random;

public class RegisterPO extends AbstractPages {

    public static String randomEmail = "coronavirusdisease" + randomNumber() + "@hotmail.com";
    public static String passwordRegistered = "Abc123456789";
    private final WebDriver driver;
    private Select select;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    // Random Method
    public static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt();
    }

    public void inputToFirstName() {
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, "Coronadisease");
    }

    public void clickToMaleRadioButton() {
        waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);


    }

    public void inputToLastName() {
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, "Virus");
    }

    public void inputToCompany() {
        sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, " Corona Virus");
    }

    public void selectDayDropdown() {
        select = new Select(findElementByXpath(driver, RegisterPageUI.DATE_DROPDOWN));
        select.selectByVisibleText("1");
    }

    public void selectMonthDropdown() {
        select = new Select(findElementByXpath(driver, RegisterPageUI.MONTH_DROPDOWN));
        select.selectByVisibleText("March");
    }

    public void inputToTextbox(WebDriver driver, String valueInput, String... values) {
        waitToElementVisible(driver, AbstractPageUI.INPUT_TEXTBOX, values);
        sendKeyToElement(driver, AbstractPageUI.INPUT_TEXTBOX, valueInput, values);
    }

    public void selectYearDropdown() {
        select = new Select(findElementByXpath(driver, RegisterPageUI.YEAR_DROPDOWN));
        select.selectByVisibleText("1986");
    }

    public String inputToEmail() {
        findElementByXpath(driver, RegisterPageUI.EMAIL_TEXTBOX).sendKeys(randomEmail);
        return randomEmail;
    }

    public void clickToRegisterButton() {
        findElementByXpath(driver, RegisterPageUI.REGISTER_BUTTON).click();
    }

    public boolean getRegisterSuccessMessage() {
        return findElementByXpath(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT).isDisplayed();
    }

    public void clickToLogOutLink() {
        findElementByXpath(driver, RegisterPageUI.LOG_OUT_LINK).click();
    }

    public String inputToPassword() {
        findElementByXpath(driver, RegisterPageUI.PASSWORD_TEXTBOX).sendKeys(passwordRegistered);
        return passwordRegistered;
    }

    public void inputToConfirmPassword() {
        findElementByXpath(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX).sendKeys("Abc123456789");
    }


    public void clickButton(WebDriver driver, String... values) {
        waitToElementClickable(driver, AbstractPageUI.INPUT_TEXTBOX, values);
        clickIntoButton(driver, AbstractPageUI.INPUT_TEXTBOX, values);
    }

    public void clickRadio(WebDriver driver, String... values) {
        waitToElementClickable(driver, AbstractPageUI.INPUT_RADIO, values);
        clickIntoButton(driver, AbstractPageUI.INPUT_RADIO, values);
    }


    public String getExistedMessage() {
        waitToElementVisible(driver, RegisterPageUI.EXISTED_EMAIL_MESSAGE);
        return getTextElement(driver, RegisterPageUI.EXISTED_EMAIL_MESSAGE);
    }

    public String getCompleteRegistrationMessage() {
        waitToElementVisible(driver, RegisterPageUI.REGISTER_COMPLETE);
        return getTextElement(driver, RegisterPageUI.REGISTER_COMPLETE);
    }

    public void selectBirthDate(WebDriver driver, String selectItem, String... values) {
        waitToElementClickable(driver, RegisterPageUI.SELECT_DROPDOWN, values);
        Select select = new Select(findElementByXpath(driver, RegisterPageUI.SELECT_DROPDOWN, values));

        clickToElement(driver, RegisterPageUI.SELECT_DROPDOWN, values);
        select.selectByVisibleText(selectItem);
    }

}
