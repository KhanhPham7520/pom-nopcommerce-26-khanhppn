package com.nopcommerce.Demo_Course;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login_02_RegisterAndLogin_AbstractPage_Extend extends AbstractPages {

    private WebDriver driver;
    private String password;
    private String email;

    private HomePageObject homePage;
    private LoginPageObject loginPage;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openUrl(driver, "https://demo.nopcommerce.com/");

        email = "coronavirus" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";
    }

    @Test
    public void TC_01_Register_To_System() {
        // click to Register Link
        // registerPage = homePage.clickToRegisterLink();

        // registerPage.clickToMaleRadioButton();
        //
        // registerPage.inputToFirstName("");
        //
        // registerPage.inputToLastName("");
        //
        // registerPage.selectDayDropdown("");
        //
        // registerPage.selectMonthDropdown("");
        //
        // registerPage.selectYearDropdown("");
        //
        // registerPage.inputToEmailTextbox("");
        //
        // registerPage.inputToConfirmPasswordTextbox("");
        //
        // registerPage.inputToConfirmPasswordTextbox("");
        //
        // registerPage.inputToConfirmPasswordTextbox("");
        //
        // registerPage.clickToRegisterButton();
        //
        // registerPage.getRegisterSuccessMessage();
        //
        // homePage = registerPage.clickToLogOutLink();

    }

    @Test
    public void TC_02_Login_To_System() {
        loginPage = homePage.clickToLoginLink();

        // loginPage.inputToEmailTextbox("");

        // loginPage.inputToConfirmPasswordTextbox("");

        // homePage = loginPage.clickToRegisterButton();

        // Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }
}
