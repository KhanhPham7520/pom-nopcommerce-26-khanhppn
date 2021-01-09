package com.nopcommerce.Demo_Course;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_01_ValidateLoginForm extends AbstractPages {
    // Locator
    String emailTextbox = "//input[@id='Email']";
    String passwordTextbox = "//input[@id='Password']";
    String loginButton = "//div[@class='buttons']//input[@class='button-1 login-button']";
    String registeredEmail = "automationfc.vn@gmail.com";
    String registeredPassword = "123456";

    // Data Registered
    // String registeredEmail_First = "corona1234@yopmail.com";
    // String registeredPassword_First = "Abc123456789";
    private WebDriver driver;
    private AbstractPages abstractPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://demo.nopcommerce.com/login");
    }

    @Test
    public void TC_01_Login_With_Empty_Data() {
        abstractPage.clickIntoButton(driver, loginButton);
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//span[text()='Please enter your email']"));
    }

    @Test
    public void TC_02_Login_With_Invalid_Email() {
        abstractPage.sendKeyToElement(driver, emailTextbox, "a");
        abstractPage.clickIntoButton(driver, loginButton);
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//span[text()='Wrong email']"));

    }

    @Test
    public void TC_03_Login_With_Email_No_Registered() {
        abstractPage.sendKeyToElement(driver, emailTextbox, "a@gmail.com");
        abstractPage.clickIntoButton(driver, loginButton);
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//div[text()='Login was unsuccessful. Please correct the errors and try again.']"));
    }

    @Test
    public void TC_04_Login_With_Registered_Email_And_No_Enter_Password() {
        abstractPage.sendKeyToElement(driver, emailTextbox, registeredEmail);
        abstractPage.sendKeyToElement(driver, passwordTextbox, "");
        abstractPage.clickIntoButton(driver, loginButton);
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//div[@class='message-error validation-summary-errors']"));
    }

    @Test
    public void TC_05_Login_With_Registered_Email_And_Wrong_Password() {
        abstractPage.sendKeyToElement(driver, emailTextbox, registeredEmail);
        abstractPage.sendKeyToElement(driver, passwordTextbox, "12345");
        abstractPage.clickIntoButton(driver, loginButton);
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//div[@class='message-error validation-summary-errors']"));
    }

    @Test
    public void TC_06_Login_With_Valid_Email_And_Valid_Password() {
        abstractPage.sendKeyToElement(driver, emailTextbox, registeredEmail);
        abstractPage.sendKeyToElement(driver, passwordTextbox, registeredPassword);
        abstractPage.clickIntoButton(driver, loginButton);
        // abstractPage.waitToElementDisplayed(driver, "//div[@class='header-links']//a[text()='My account']");
        Assert.assertTrue(abstractPage.isDisplayed(driver, "//div[@class='header-links']//a[text()='My account']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
