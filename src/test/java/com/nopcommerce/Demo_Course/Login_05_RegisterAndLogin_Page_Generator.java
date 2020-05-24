package com.nopcommerce.Demo_Course;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pageUIs.RegisterPageUI;

import java.util.Random;

public class Login_05_RegisterAndLogin_Page_Generator extends AbstractPages {

    private WebDriver driver;
    private String password;
    private String email;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "/Users/apple/Desktop/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");

        // Nhược : Ko tuân theo nguyên tắc đóng gói OOP
        // homePage = new HomePageObject(driver);
        homePage = PageGeneratorManager.getHomePage(driver);

        email = "coronavirus" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";
    }

    @Test
    public void TC_01_Register_To_System() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToMaleRadioButton();

        //registerPage.waitToElementDisplayed(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        registerPage.sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, "Corona");

        sendKeyToElement(driver, "//input[@id='LastName']", "Virus");

        // selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "1");

        // selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "February");

        // selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1986");

        sendKeyToElement(driver, "//input[@id='Email']", email);

        sendKeyToElement(driver, "//input[@id='Company']", "Corona Virus");

        sendKeyToElement(driver, "//input[@id='Password']", password);

        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        clickToElement(driver, "//input[@id='register-button']");

        String resultText = getTextElement(driver, "//div[text()='Your registration completed']");
        Assert.assertEquals(resultText, "Your registration completed");

    }

    @Test
    public void TC_02_Login_To_System() {
        clickToElement(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[text()='Log in']");
        sendKeyToElement(driver, "//input[@id='Email']", email);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        clickToElement(driver, "//input[@class='button-1 login-button']");
        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

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
