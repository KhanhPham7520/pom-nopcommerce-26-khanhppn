package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPages {
	private final WebDriver driver;
	Select select;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMaleGenderRadio() {
		clickIntoRadioButton(driver, MyAccountPageUI.GENDER_MALE_RADIO);
	}

	public void inputFirstNameTextbox(String inputFirstName) {
		waitToElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		clearExistedData(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, inputFirstName);
	}

	public void inputLastNameTextbox(String inputLastName) {
		waitToElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		clearExistedData(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, inputLastName);
	}

	public void selectDayInDropdown(String day) {
		waitToElementClickable(driver, MyAccountPageUI.SELECT_DAY_DROPDOWN);
		select = new Select(findElementByXpath(driver, MyAccountPageUI.SELECT_DAY_DROPDOWN));
		select.selectByVisibleText(day);
	}

	public void selectMonthInDropdown(String month) {
		waitToElementClickable(driver, MyAccountPageUI.SELECT_MONTH_DROPDOWN);
		select = new Select(findElementByXpath(driver, MyAccountPageUI.SELECT_MONTH_DROPDOWN));
		select.selectByVisibleText(month);
	}

	public void selectYearInDropdown(String year) {
		waitToElementClickable(driver, MyAccountPageUI.SELECT_YEAR_DROPDOWN);
		select = new Select(findElementByXpath(driver, MyAccountPageUI.SELECT_YEAR_DROPDOWN));
		select.selectByVisibleText(year);
	}

	public void inputEmailTextbox(String inputEmail) {
		waitToElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		clearExistedData(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, inputEmail);
	}

	public void inputCompanyTextbox(String inputCompanyValue) {
		waitToElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		clearExistedData(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, inputCompanyValue);
	}

	public void clickSaveButton() {
		waitToElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public AccountAddressPageObject clickToAddressLink() {
		waitToElementClickable(driver, MyAccountPageUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_LINK);
		return new AccountAddressPageObject(driver);
	}

//	public String getTextFromInputTextbox(WebDriver driver, String... values) {
//		waitToElementVisible(driver, AbstractNopCommercePageUI.INPUT_TEXTBOX, values);
//		return findElementByXpath(driver, AbstractNopCommercePageUI.INPUT_TEXTBOX, values).getAttribute("value");
//	}

	public String getDynamicTextFromInputTextbox(WebDriver driver, String values) {
		waitToElementVisible(driver, MyAccountPageUI.GET_TEXT_DYNAMIC_ACCOUNT, values);
		return findElementByXpath(driver, MyAccountPageUI.GET_TEXT_DYNAMIC_ACCOUNT, values).getAttribute("value");
	}

}
