package pageUI;

import org.openqa.selenium.WebDriver;

public class RegisterPageUI {

    private WebDriver driver;

    public RegisterPageUI(WebDriver driver){
        this.driver = driver;
    }

    public static final String FIRST_NAME_TEXT_BOX = "//input[@id='FirstName']";

    public static final String LAST_NAME_TEXT_BOX = "//input[@id='LastName']";

    public static final String EMAIL_TEXT_BOX = "//label[@for='Email']//following-sibling::input[@type='email']";

    public static final String PASSWORD_TEXT_BOX = "//input[@id='Password']";

    public static final String CONFIRM_PASSWORD_TEXT_BOX = "//input[@id='ConfirmPassword']";

    public static final String REGISTER_BUTTON = "//input[@id='register-button']";
}
