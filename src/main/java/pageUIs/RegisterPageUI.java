package pageUIs;

public class RegisterPageUI extends AbstractNopCommercePageUI {
    public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
    public static final String FIRST_NAME_TEXTBOX = "//input[@name='FirstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@name='LastName']";
    public static final String DATE_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";

    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "//div[@class='buttons']//input[@id='register-button']";

    public static final String REGISTER_SUCCESS_TEXT = "//div[@class='result']";
    public static final String LOG_OUT_LINK = "//a[text()='Log out']";

    public static final String EXISTED_EMAIL_MESSAGE = "//li[text()='The specified email already exists']";

    public static final String REGISTER_COMPLETE = "//div[text()='Your registration completed']";

}
