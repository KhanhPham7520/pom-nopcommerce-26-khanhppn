package com.nopcommerce.Demo_Course;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login_03_RegisterAndLogin_PageObject extends AbstractPages {

    private WebDriver driver;
    private String password;
    private String email;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        email = "coronavirus" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";
    }

    @Test
    public void TC_01_Register_To_System() {
        // click to Register Link
        openUrl(driver, "https://demo.nopcommerce.com/");

        clickToElement(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//input[@id='gender-male']");
        sendKeyToElement(driver, "//input[@id='FirstName']", "Corona");
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
        System.out.println("Email after jump in to test case 02 : " + email);
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
