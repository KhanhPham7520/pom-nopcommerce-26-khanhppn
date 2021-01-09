package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login_08_RegisterAndLogin_Dynamic_Locator extends AbstractTest {

    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPO registerPage;
    private LoginPageObject loginPage;
    private FooterMyAccountPageObject myAccountPage;
    private FooterNewProductPageObject newProductPage;
    private FooterSearchPageObject searchPage;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String autURL) {
        driver = getBrowserDriver(browserName, autURL);
        System.out.println("Driver at test class : " + driver.toString());

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Register_To_System() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToMaleRadioButton();
        // registerPage.sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, "Corona");
        registerPage.inputToFirstName();
        // registerPage.sendKeyToElement(driver, "//input[@id='LastName']", "Virus");
        registerPage.inputToLastName();
        // selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "1");
        registerPage.selectDayDropdown();
        // selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "February");
        registerPage.selectMonthDropdown();
        // selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1986");
        registerPage.selectYearDropdown();
        // sendKeyToElement(driver, "//input[@id='Email']", email);
        registerPage.inputToEmail();
        // sendKeyToElement(driver, "//input[@id='Company']", "Corona Virus");
        registerPage.inputToCompany();
        // sendKeyToElement(driver, "//input[@id='Password']", password);
        registerPage.inputToPassword();
        // sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        registerPage.inputToConfirmPassword();
        // clickToElement(driver, "//input[@id='register-button']");
        registerPage.clickToRegisterButton();
        // Assert.assertEquals(resultText, "Your registration completed");
        Assert.assertTrue(registerPage.getRegisterSuccessMessage());
        // clickToElement(driver, "//a[@class='ico-logout']");

    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
