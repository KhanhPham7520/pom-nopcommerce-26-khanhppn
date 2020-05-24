package com.nopcommerce.Demo_Course;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Data_Faker.DataHelperForLanguageEn;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageUIs.AbstractNopCommercePageUI;

public class Login_17_DataJson extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DataHelperForLanguageEn data;
	private AbstractPage abstractPage;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String password;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		data = DataHelperForLanguageEn.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		email = data.getEmail();
		companyName = data.getCompany();
		password = data.getPassword();

		abstractPage = new AbstractPage(driver);

	}

	@Test
	public void TC_01_Register_Valid_Info() {
		// click to Register Link
		driver.get("https://demo.nopcommerce.com/");

		abstractPage.clickToElement("//a[@class='ico-register']");
		abstractPage.clickToElement("//input[@id='gender-male']");
		abstractPage.sendKeyToElement("//input[@id='FirstName']", firstName);
		abstractPage.sendKeyToElement("//input[@id='LastName']", lastName);

		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "1");

		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");

		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1986");

		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		System.out.println("Email Registered : " + email);

		abstractPage.sendKeyToElement("//input[@id='Company']", companyName);

		abstractPage.sendKeyToElement("//input[@id='Password']", password);
		System.out.println("Password Registered : " + password);

		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password);
		System.out.println("Password Confirm Registered : " + password);

		abstractPage.clickToElement("//input[@id='register-button']");

		String resultText = abstractPage.getTextElement("//div[text()='Your registration completed']");
		Assert.assertEquals(resultText, "Your registration completed");
	}

	@Test
	public void TC_02_Login_With_Valid_Email_And_Valid_Password() {
		homePage.clickToElement(driver, AbstractNopCommercePageUI.HEADER_LOG_OUT_LINK);
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmail(email);
		System.out.println("Email login: " + email);
		loginPage.inputPassword(password);
		System.out.println("Password login: " + password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
