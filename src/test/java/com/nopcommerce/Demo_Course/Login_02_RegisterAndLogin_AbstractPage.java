package com.nopcommerce.Demo_Course;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login_02_RegisterAndLogin_AbstractPage {

    private WebDriver driver;
    private String password;
    private String email;
    private AbstractPage abstractPage;
    // private String emailHash = "khanhpln1234@hotmail.com";
    // WebElement email = driver.findElement(By.xpath(""));

    @BeforeTest
    public void beforeTest() {

        abstractPage = new AbstractPage();

        System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        abstractPage.openUrl("https://demo.nopcommerce.com/");
        email = "coronavirus" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";

        // Init Abstract Page

        abstractPage = new AbstractPage(driver);
    }

    @Test
    public void TC_01_Register_To_System() {
        // click to Register Link
        abstractPage.openUrl("https://demo.nopcommerce.com/");

        abstractPage.clickToElement("//a[@class='ico-register']");
        abstractPage.clickToElement("//input[@id='gender-male']");
        abstractPage.sendKeyToElement("//input[@id='FirstName']", "ab");
        abstractPage.sendKeyToElement("//input[@id='LastName']", "cd");

        abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "1");

        abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");

        abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1986");

        abstractPage.sendKeyToElement("//input[@id='Email']", email);

        abstractPage.sendKeyToElement("//input[@id='Company']", "Corona Virus");

        abstractPage.sendKeyToElement("//input[@id='Password']", password);

        abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password);

        abstractPage.clickToElement("//input[@id='register-button']");

        String resultText = abstractPage.getTextElement("//input[@id='register-button']");
        Assert.assertEquals(resultText, "Your registration completed");

        abstractPage.clickToElement("//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login_To_System() {
        System.out.println("Email after jump in to test case 02 : " + email);
        abstractPage.clickToElement("//a[@class='ico-login']");
        abstractPage.sendKeyToElement("//input[@id='Email']", email);
        abstractPage.sendKeyToElement("//input[@id='Password']", password);
        abstractPage.clickToElement("//input[@class='button-1 login-button']");
        Assert.assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account']"));

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
