package com.nopcommerce.My_Account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Data_Faker.DataHelperForLanguageVi;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.AccountAddressPageObject;
import pageObjects.ComputerPageObject;
import pageObjects.DesktopsPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.ReviewPageObject;
import pageUIs.AccountAddressPageUI;
import pageUIs.MyAccountPageUI;

public class My_Account_01 extends AbstractTest {

	// Update Info
	private final String updateGender = "M";
	private final String updateBirthDay = "1";
	private final String updateBirthMonth = "January";
	private final String updateBirthYear = "1999";
	private final String newPostalCode = "09";
	private WebDriver driver;
	private HomePageObject homePage;
	private DesktopsPageObject desktopPage;
	private ComputerPageObject computerPage;
	private ReviewPageObject reviewPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	private AccountAddressPageObject accountAddressPage;
	private DataHelperForLanguageVi dataHelperForLanguageVi;
	private String updateFirstname;
	private String updateLastname;
	private String updateEmail = "carson.murazik@gmail.com";
	private String updateCompany;
	// Add New Address Data
	private String newFirstname;
	private String newLastname;
	private String newEmail;
	private String newCountry = "Guyana";
	private String newCity;
	private String newAddress;
	private String newPhoneNumber;

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

		dataHelperForLanguageVi = DataHelperForLanguageVi.getData();
		updateFirstname = dataHelperForLanguageVi.getFirstName();
		updateLastname = dataHelperForLanguageVi.getLastName();
		updateEmail = dataHelperForLanguageVi.getEmail();
		updateCompany = dataHelperForLanguageVi.getCompany();

		newFirstname = dataHelperForLanguageVi.getFirstName();
		newLastname = dataHelperForLanguageVi.getLastName();
		newEmail = dataHelperForLanguageVi.getEmail();
		newCountry = dataHelperForLanguageVi.getCountry();
		newCity = dataHelperForLanguageVi.getCity();
		newAddress = dataHelperForLanguageVi.getAddress();
		newPhoneNumber = dataHelperForLanguageVi.getPhone();
	}

	@Test
	public void TC_01_Update_Customer_Info_Success() {
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.selectMaleGenderRadio();
		myAccountPage.inputFirstNameTextbox(updateFirstname);

		myAccountPage.inputLastNameTextbox(updateLastname);
		myAccountPage.selectDayInDropdown(updateBirthDay);
		myAccountPage.selectMonthInDropdown(updateBirthMonth);
		myAccountPage.selectYearInDropdown(updateBirthYear);
		myAccountPage.inputEmailTextbox(updateEmail);
		myAccountPage.inputCompanyTextbox(updateCompany);
		myAccountPage.clickSaveButton();

		verifyEquals(myAccountPage.getTextFromRadioButton(driver, "value", "gender-male"), updateGender);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "FirstName"), updateFirstname);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "LastName"), updateLastname);

		verifyEquals(findElementByXpath(driver, MyAccountPageUI.SELECT_DAY_DROPDOWN).getAttribute("value"), updateBirthDay);

		verifyEquals(findElementByXpath(driver, MyAccountPageUI.SELECT_YEAR_DROPDOWN).getAttribute("value"), updateBirthYear);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Email"), updateEmail);

		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Company"), updateCompany);

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

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.FIRST_NAME_TEXTBOX).getAttribute("value"), newFirstname);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_FirstName"), newFirstname);

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.LAST_NAME_TEXTBOX).getAttribute("value"), newLastname);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_LastName"), newLastname);

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.EMAIL_TEXTBOX).getAttribute("value"), newEmail);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_Email"), newEmail);

		verifyEquals(findElementByXpath(driver, AccountAddressPageUI.COUNTRY_SELECT).getAttribute("value"), newCountry);

		verifyEquals(findElementByXpath(driver, AccountAddressPageUI.CITY_TEXTBOX).getAttribute("value"), newCity);

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.ADDRESS_1_TEXTBOX).getAttribute("value"), newAddress);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_Address1"), newAddress);

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.POSTAL_CODE_TEXTBOX).getAttribute("value"), newPostalCode);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_ZipPostalCode"), newPostalCode);

		// Assert.assertEquals(findElementByXpath(driver, AccountAddressPageUI.PHONE_NUMBER_TEXTBOX).getAttribute("value"), newPhoneNumber);
		verifyEquals(myAccountPage.getTextFromInputTextbox(driver, "value", "Address_PhoneNumber"), newPhoneNumber);

	}

	// @Test
	public void TC_03_Change_Password() {

	}

	// @Test
	public void TC_04_Add_Review_Product() {
		computerPage = homePage.clickToComputerLink();

		desktopPage = computerPage.clickIntoDesktopLink();

		desktopPage.clickIntoProductLink("Lenovo IdeaCentre 600 All-in-One PC");

		reviewPage = desktopPage.clickAddToReview();

		reviewPage.inputReviewTitle("Product Quality");

		reviewPage.inputReviewText("Product Quality is not exellent");

		reviewPage.selectRatingNoExcellent();

		reviewPage.clickSubmitReview();

		Assert.assertTrue(reviewPage.isReviewAddSucessfully());

	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
