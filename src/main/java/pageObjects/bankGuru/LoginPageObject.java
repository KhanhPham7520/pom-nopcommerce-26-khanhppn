package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractBankPageObject {

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageUrl() {
        return getCurrentPageUrl(driver);
    }

    public RegisterPageObject clickToHereLink() {
        waitToElementClickable(driver, LoginPageUI.HERE_LINK);
        clickToElement(driver, LoginPageUI.HERE_LINK);
        return new RegisterPageObject(driver);
    }

    public void inputUserIDTxt(String userID) {
        waitToElementVisible(driver, LoginPageUI.USER_NAME_TXT);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TXT, userID);
    }

    public void inputPasswordTxt(String password) {
        waitToElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public void clickLoginButton() {
        waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public HomePageObject loginAsUser(String userID, String password) {
        inputUserIDTxt(userID);
        inputPasswordTxt(password);
        return new HomePageObject(driver);
    }

}
