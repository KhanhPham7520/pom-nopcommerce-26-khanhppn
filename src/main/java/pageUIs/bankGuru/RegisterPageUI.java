package pageUIs.bankGuru;

public class RegisterPageUI {
    public static final String EMAIL_ID_TXT = "//input[@name='emailid']";
    public static final String SUBMIT_BUTTON = "//input[@name='btnLogin']";

    public static final String USER_ID_TEXT = "//td[text()='User ID :']//following-sibling::td";
    public static final String PASSWORD_TEXT = "//td[text()='Password :']//following-sibling::td";

    public static final String REGISTER_SUCCESS_MSG = "//p[text()='Customer Registered Successfully!!!']";
    public static final String UPDATE_SUCCESS_MSG = "//p[text()='Customer details updated Successfully!!!']";
    public static final String DYNAMIC_RESULT_ROW_DATA = "//td[text()='%s']//following-sibling::td";
    public static final String BANKGURU_HEADER_TEXT = "//p[text()='%s']";
}
