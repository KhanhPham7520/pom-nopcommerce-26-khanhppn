package pageUIs.bankGuru;

public abstract class AbstractBankPageUI {
    public static final String DYNAMIC_MENU_LINK = "//a[text()='%s']";

    public static final String DYNAMIC_TEXTBOX_BANKGURU = "//input[@name='%s']";
    public static final String DYNAMIC_RADIO_BANKGURU = "//input[@value='%s']";
    public static final String DYNAMIC_TEXTAREA_BANKGURU = "//textarea[@name='addr']";
    public static final String DYNAMIC_BUTTON_BANKGURU = "//input[@value='%s']";
    public static final String DYNAMIC_DROPDOWN_BANKGURU = "//select[@name='%s']";

    public static final String DYNAMIC_BANKGURU_HEADER_TEXT = "//p[text()='%s']";
}
