package pageUIs;

public class LoginPageUI extends AbstractNopCommercePageUI {
    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String LOGIN_BUTTON = "//input[@class='button-1 login-button']";

    public static final String LOGIN_FAILED_MESSAGE = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']";

    public static final String MY_ACCOUNT_AFTER_LOGIN_SUCCESS = "//div[@class='header-links']//a[text()='My account']";

    // MESSAGE
    public static final String EMPTY_EMAIL_MESSAGE = "//span[text()='Please enter your email']";
    public static final String WRONG_EMAIL_MESSAGE = "//span[text()='Wrong email']";
    public static final String EMAIL_NO_REGISTERED_MESSAGE = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']";
    public static final String NO_ENTER_PASSWORD_MESSAGE = "//div[@class='message-error validation-summary-errors']";
    public static final String REGISTERED_EMAIL_WRONG_PASSWORD = "//div[@class='message-error validation-summary-errors']";

    // Admin Page
    public static final String ADMIN_EMAIL_TEXTBOX = "//input[@name='Email']";
    public static final String ADMIN_PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String ADMIN_LOGIN_BUTTON = "//input[@class='button-1 login-button']";

}
