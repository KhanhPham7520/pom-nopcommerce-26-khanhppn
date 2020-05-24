package pageObjects;

import commons.AbstractPages;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.Admin.AdminHomePageObject;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPages {

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputRegisteredEmail(String inputRegisteredEmail) {
        clearExistedData(driver, LoginPageUI.EMAIL_TEXTBOX);
        findElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX).sendKeys(inputRegisteredEmail);
    }

    public void inputCorrectEmail() {
        clearExistedData(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, GlobalConstants.USER_EMAIL);
    }

    public void inputCorrectAdminEmail() {
        clearExistedData(driver, LoginPageUI.ADMIN_EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.ADMIN_EMAIL_TEXTBOX, GlobalConstants.ADMIN_EMAIL);
    }

    public void inputCorrectPassword() {
        clearExistedData(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, GlobalConstants.USER_PASSWORD);
    }

    public void inputCorrectAdminPassword() {
        clearExistedData(driver, LoginPageUI.ADMIN_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.ADMIN_PASSWORD_TEXTBOX, GlobalConstants.ADMIN_PASSWORD);
    }

    public void inputToPasswordTextbox(String inputRegisteredPassword) {
        clearExistedData(driver, LoginPageUI.PASSWORD_TEXTBOX);
        findElementByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX).sendKeys(inputRegisteredPassword);
    }

    public HomePageObject clickToLoginButton() {
        waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }

    public AdminHomePageObject clickToAdminLoginButton() {
        waitToElementClickable(driver, LoginPageUI.ADMIN_LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.ADMIN_LOGIN_BUTTON);
        return PageGeneratorManager.getAdminHomePage(driver);
    }

    public boolean isMyAccountDisplayed() {
        return findElementByXpath(driver, LoginPageUI.MY_ACCOUNT_AFTER_LOGIN_SUCCESS).isDisplayed();
    }

    public boolean isEmptyEmailMessage() {
        return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE);
    }

    public void inputEmail(String inputEmail) {
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, inputEmail);
    }

    public boolean isWrongEmailMessage() {
        return isElementDisplayed(driver, LoginPageUI.WRONG_EMAIL_MESSAGE);
    }

    public String isNoRegisteredEmail() {
        waitToElementVisible(driver, LoginPageUI.EMAIL_NO_REGISTERED_MESSAGE);
        return getTextElement(driver, LoginPageUI.EMAIL_NO_REGISTERED_MESSAGE);
    }

    public void inputPassword(String inputPassword) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, inputPassword);
    }

    public String isNoEnterPassword() {
        waitToElementVisible(driver, LoginPageUI.NO_ENTER_PASSWORD_MESSAGE);
        return getTextElement(driver, LoginPageUI.NO_ENTER_PASSWORD_MESSAGE);
    }

    public String isRegisteredEmailAndWrongPassword() {
        waitToElementVisible(driver, LoginPageUI.REGISTERED_EMAIL_WRONG_PASSWORD);
        return getTextElement(driver, LoginPageUI.REGISTERED_EMAIL_WRONG_PASSWORD);
    }

    public boolean isMyAccountLinkDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.MY_ACCOUNT_AFTER_LOGIN_SUCCESS);
    }

}
