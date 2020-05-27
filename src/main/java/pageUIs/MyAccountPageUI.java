package pageUIs;

public class MyAccountPageUI extends AbstractNopCommercePageUI {

	public static final String GENDER_MALE_RADIO = "//div[@class='gender']//span[@class='male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@name='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@name='LastName']";
	public static final String SELECT_DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String SELECT_MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String SELECT_YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@name='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@name='Company']";
	public static final String SAVE_BUTTON = "//input[@name='save-info-button']";

	public static final String ADD_NEW_ADDRESS_BUTTON = "//input[@value='Add new']";

	public static final String ADDRESSES_LINK = "//li[@class='customer-addresses inactive']//a";

	public static final String GET_TEXT_DYNAMIC_ACCOUNT = "//li[@class='%s']";

}
