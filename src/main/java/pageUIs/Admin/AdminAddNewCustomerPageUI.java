package pageUIs.Admin;

import pageUIs.AbstractNopCommercePageUI;

public class AdminAddNewCustomerPageUI extends AbstractNopCommercePageUI {

    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
    public static final String MALE_GENDER_RADIO = "//input[@id='Gender_Male']";
    public static final String DOB_DATEPICKER = "//input[@id='DateOfBirth']";
    public static final String COMPANY_NAME = "//input[@id='Company']";
    public static final String IS_ACTIVED_CHECKBOX = "//input[@id='Active']";
    public static final String ADMIN_COMMENT_TEXTBOX = "//textarea[@id='AdminComment']";
    public static final String SAVE_BUTTON = "//button[@name='save']";
    public static final String ADD_NEW_CUSTOMER_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";

}
