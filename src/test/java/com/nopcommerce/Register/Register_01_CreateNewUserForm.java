package com.nopcommerce.Register;

import Data_Faker.DataHelperForLanguageEn;
import com.nopcommerce.data.CustomerData;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPO;

public class Register_01_CreateNewUserForm extends AbstractTest {

    RegisterPO registerPage;
    HomePageObject homePage;
    private WebDriver driver;
    private String password;
    private String email;
    private DataHelperForLanguageEn dataHelperForLanguageEn;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        registerPage = PageGeneratorManager.getRegisterPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);

        dataHelperForLanguageEn = DataHelperForLanguageEn.getData();

        email = dataHelperForLanguageEn.getEmail();
        password = dataHelperForLanguageEn.getPassword();
    }

    @BeforeMethod
    public void beforeMethod() {
        registerPage = homePage.clickToRegisterLink();
    }

    @Test
    public void TC_01_Register_With_Empty_Data() {

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getErrorMessage(driver, "FirstName-error", "First name is required."), "First name is required.");

        verifyEquals(registerPage.getErrorMessage(driver, "LastName-error", "Last name is required."), "Last name is required.");

        verifyEquals(registerPage.getErrorMessage(driver, "Password-error", "Password is required."), "Password is required.");

        verifyEquals(registerPage.getErrorMessage(driver, "ConfirmPassword-error", "Password is required."), "Password is required.");
    }

    @Test
    public void TC_02_Register_With_Invalid_Email() {

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.INVALID_EMAIL, "Email");

        registerPage.clickButton(driver, "register-button");

        verifyEquals(registerPage.getErrorMessage(driver, "Email-error", "Wrong email"), "Wrong email");

    }

    @Test
    public void TC_03_Register_With_Existed_Email() {

        registerPage.clickRadio(driver, "gender-male");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.FIRST_NAME, "FirstName");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.LAST_NAME, "LastName");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHDAY, "DateOfBirthDay");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHMONTH, "DateOfBirthMonth");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHYEAR, "DateOfBirthYear");

        registerPage.inputToTextbox(driver, CustomerData.REGISTERED_EMAIL, "Email");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.COMPANY, "Company");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.INVALID_PASSWORD, "Password");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.INVALID_PASSWORD, "ConfirmPassword");

        registerPage.clickButton(driver, "register-button");

        verifyEquals(registerPage.getExistedMessage(), "The specified email already exists");
    }

    @Test
    public void TC_04_Register_Password_With_Lower_Than_6_Characters() {

        registerPage.clickRadio(driver, "gender-male");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.FIRST_NAME, "FirstName");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.LAST_NAME, "LastName");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHDAY, "DateOfBirthDay");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHMONTH, "DateOfBirthMonth");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHYEAR, "DateOfBirthYear");

        registerPage.inputToTextbox(driver, email, "Email");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.COMPANY, "Company");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.INVALID_LOWER_THAN_6_CHARS_PASSWORD, "Password");

        registerPage.clickButton(driver, "register-button");

        verifyTrue(registerPage.isDisplayed(driver, "//span[@id='Password-error']"));

    }

    @Test
    public void TC_05_Register_Password_And_Confirm_Password_Not_Equal() {

        registerPage.clickRadio(driver, "gender-male");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.FIRST_NAME, "FirstName");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.LAST_NAME, "LastName");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHDAY, "DateOfBirthDay");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHMONTH, "DateOfBirthMonth");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHYEAR, "DateOfBirthYear");

        registerPage.inputToTextbox(driver, email, "Email");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.COMPANY, "Company");

        registerPage.inputToTextbox(driver, CustomerData.REGISTERD_PASSWORD, "Password");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.INVALID_PASSWORD, "ConfirmPassword");

        registerPage.clickButton(driver, "register-button");

        verifyTrue(registerPage.findElementByXpath(driver, "//span[text()='The password and confirmation password do not match.']").isDisplayed());

    }

    @Test
    public void TC_06_Register_Valid_Info() {

        registerPage.clickRadio(driver, "gender-male");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.FIRST_NAME, "FirstName");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.LAST_NAME, "LastName");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHDAY, "DateOfBirthDay");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHMONTH, "DateOfBirthMonth");

        registerPage.selectBirthDate(driver, CustomerData.NewCustomer.BIRTHYEAR, "DateOfBirthYear");

        registerPage.inputToTextbox(driver, email, "Email");

        registerPage.inputToTextbox(driver, CustomerData.NewCustomer.COMPANY, "Company");

        registerPage.inputToTextbox(driver, password, "Password");

        registerPage.inputToTextbox(driver, password, "ConfirmPassword");

        registerPage.clickButton(driver, "register-button");

        verifyEquals(registerPage.getCompleteRegistrationMessage(), "Your registration completed");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }
}
