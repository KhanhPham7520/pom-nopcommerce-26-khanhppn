package com.nopcommerce.Login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.CustomerData;
import com.relevantcodes.extentreports.LogStatus;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfig.ExtentTestManager;

public class Login_01_Validate_Login_Form extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void TC_01_Login_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Login_With_Empty_Data");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 01 : Input Email Blank");
		log.info("Step 01: Input Email Blank");
		loginPage.inputEmail(CustomerData.LoginData.EMAIL_BLANK);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 02 : Click to Login button");
		log.info("Step 02 : Click to Login button");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 03 : Verify error");
		log.info("Step 03 : Verify error");
		verifyEquals(loginPage.getErrorMessage(driver, "Email-error", "Please enter your email"), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPage.inputEmail(CustomerData.LoginData.INVALID_EMAIL);
		loginPage.clickToLoginButton();
		verifyEquals(loginPage.getErrorMessage(driver, "Email-error", "Wrong email"), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Email_No_Registered() {
		loginPage.inputEmail(CustomerData.LoginData.EMAIL_NO_REGISTER);
		loginPage.clickToLoginButton();
		verifyEquals(loginPage.isNoRegisteredEmail(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_With_Registered_Email_And_No_Enter_Password() {
		loginPage.inputEmail(CustomerData.REGISTERED_EMAIL);
		loginPage.inputPassword(CustomerData.LoginData.PASSWORD_BLANK);
		loginPage.clickToLoginButton();
		verifyEquals(loginPage.isNoEnterPassword(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_With_Registered_Email_And_Wrong_Password() {
		loginPage.inputEmail(CustomerData.REGISTERED_EMAIL);
		loginPage.inputPassword(CustomerData.LoginData.WRONG_PASSWORD);
		loginPage.clickToLoginButton();
		verifyEquals(loginPage.isRegisteredEmailAndWrongPassword(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_With_Valid_Email_And_Valid_Password() {
		loginPage.inputEmail(CustomerData.REGISTERED_EMAIL);
		loginPage.inputPassword(CustomerData.REGISTERD_PASSWORD);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(loginPage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
