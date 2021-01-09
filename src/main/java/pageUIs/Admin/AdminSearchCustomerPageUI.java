package pageUIs.Admin;

import pageUIs.AbstractPageUI;

public class AdminSearchCustomerPageUI extends AbstractPageUI {

    public static final String EMAIL_TEXTBOX = "//input[@name='SearchEmail']";
    public static final String FIRSTNAME_TEXTBOX = "//input[@name='SearchFirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@name='SearchLastName']";
    public static final String BIRTH_MONTH_SELECT = "//select[@name='SearchMonthOfBirth']";
    public static final String BIRTH_DAY_SELECT = "//select[@name='SearchDayOfBirth']";
    public static final String COMPANY_TEXTBOX = "//input[@name='SearchCompany']";
    public static final String SEARCH_BUTTON = "//button[@id='search-customers']";

    public static final String RESULT_NAME_TABLE = "//tr[@role='row']//td[%s]";
    public static final String EDIT_BUTTON = "//a[text()='Edit']";
}
