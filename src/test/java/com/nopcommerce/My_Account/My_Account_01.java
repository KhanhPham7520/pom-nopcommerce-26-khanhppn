package com.nopcommerce.My_Account;

import Data_Faker.DataHelperForLanguageEn;
import com.nopcommerce.data.MyAccountData;
import com.nopcommerce.data.ProductData;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import pageUIs.MyAccountPageUI;

public class My_Account_01 extends AbstractTest {

	// Update Info
//	private final String MyAccountData.updateData.updateBirthDay = "1";
//	private final String MyAccountData.updateData.updateBirthMonth = "January";
//	private final String MyAccountData.updateData.updateBirthYear = "1999";
	private final String newPostalCode = "09";
	private WebDriver driver;
	private HomePageObject homePage;
	private DesktopsPageObject desktopPage;
	private ComputerPageObject computerPage;
	private ReviewPageObject reviewPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	private AccountAddressPageObject accountAddressPage;
	private DataHelperForLanguageEn dataHelperForLanguageEn;
	private String updateFirstname;
	private String updateLastname;
	private String updateEmail;
	private String updateCompany;
	// Add New Address Data
	private String newFirstname;
	private String newLastname;
	private String newEmail;
	String newCountry = "Afghanistan";
	private String newCity;
	private String newAddress;
	private String newPhoneNumber;

	private String name = newFirstname + newLastname;
//	private String new_city_state = newCity + "," + newPostalCode;
	String new_city_state;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		computerPage = PageGeneratorManager.getComputerPageObject(driver);
		accountAddressPage = PageGeneratorManager.getAccountAddressPage(driver);
		reviewPage = PageGeneratorManager.getReviewPageObject(driver);
		accountAddressPage = PageGeneratorManager.getAccountAddressPage(driver);

		loginPage = homePage.clickToLoginLink();
		loginPage.inputCorrectEmail();
		loginPage.inputCorrectPassword();
		homePage = loginPage.clickToLoginButton();

		dataHelperForLanguageEn = DataHelperForLanguageEn.getData();
		updateFirstname = dataHelperForLanguageEn.getFirstName();
		updateLastname = dataHelperForLanguageEn.getLastName();
		updateEmail = dataHelperForLanguageEn.getEmail();
		updateCompany = dataHelperForLanguageEn.getCompany();

		newFirstname = dataHelperForLanguageEn.getFirstName();
		newLastname = dataHelperForLanguageEn.getLastName();
		newEmail = dataHelperForLanguageEn.getEmail();
		newCity = dataHelperForLanguageEn.getCity();
		newAddress = dataHelperForLanguageEn.getAddress();
		newPhoneNumber = dataHelperForLanguageEn.getPhone();
	}

	@Test
	public void TC_01_Update_Customer_Info_Success() {

		myAccountPage = homePage.clickToMyAccountLink();

		myAccountPage.selectMaleGenderRadio();

		myAccountPage.inputFirstNameTextbox(updateFirstname);

		myAccountPage.inputLastNameTextbox(updateLastname);

		myAccountPage.selectDayInDropdown(MyAccountData.updateData.updateBirthDay);

		myAccountPage.selectMonthInDropdown(MyAccountData.updateData.updateBirthMonth);

		myAccountPage.selectYearInDropdown(MyAccountData.updateData.updateBirthYear);

		myAccountPage.inputEmailTextbox(updateEmail);

		myAccountPage.inputCompanyTextbox(updateCompany);

		myAccountPage.clickSaveButton();

		verifyEquals(myAccountPage.getTextFromRadioButton(driver, "value", "gender-male"), MyAccountData.updateData.updateGender);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value","FirstName"), updateFirstname);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value","LastName"), updateLastname);

		verifyEquals(findElementByXpath(driver, MyAccountPageUI.SELECT_DAY_DROPDOWN).getAttribute("value"), MyAccountData.updateData.updateBirthDay);

		verifyEquals(findElementByXpath(driver, MyAccountPageUI.SELECT_YEAR_DROPDOWN).getAttribute("value"), MyAccountData.updateData.updateBirthYear);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value","Email"), updateEmail);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value","Company"), updateCompany);

	}

	@Test
	public void TC_02_Add_Address() {
		myAccountPage = homePage.clickToMyAccountLink();

		accountAddressPage = myAccountPage.clickToAddressLink();

		accountAddressPage.clickAddNewButton();

		accountAddressPage.inputFirstNameTextbox(newFirstname);

		accountAddressPage.inputLastNameTextbox(newLastname);

		accountAddressPage.inputEmailTextbox(newEmail);

		accountAddressPage.selectContryValue(newCountry);

		accountAddressPage.inputCityTextbox(newCity);

		accountAddressPage.inputAddress1Textbox(newAddress);

		accountAddressPage.inputPostalTextbox(newPostalCode);

		accountAddressPage.inputPhoneNumberTextbox(newPhoneNumber);

		accountAddressPage.clickSaveButton();

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "name"), name);

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "email"), "Email: " + newEmail);

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "phone"), "Phone number: " + newPhoneNumber);

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "address1"), newAddress);

		String newCityStateExpected = newCity.concat(", ").concat(newPostalCode);

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "city-state-zip"), newCityStateExpected);

		verifyEquals(myAccountPage.getDynamicTextFromInputTextbox(driver, "country"), newCountry);

	}

	// @Test
	public void TC_03_Change_Password() {
	}

	@Test
	public void TC_04_Add_Review_Product() {


		computerPage = homePage.clickToComputerLink();

		desktopPage = computerPage.clickIntoDesktopLink();

		desktopPage.clickIntoProductLink(ProductData.ReviewProduct.productName);

		reviewPage = desktopPage.clickAddToReview();

		reviewPage.inputReviewTitle(ProductData.ReviewProduct.reviewTitle);

		reviewPage.inputReviewText(ProductData.ReviewProduct.reviewText);

		reviewPage.selectRatingNoExcellent();

		reviewPage.clickSubmitReview();

		verifyTrue(reviewPage.isReviewAddSucessfully());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
