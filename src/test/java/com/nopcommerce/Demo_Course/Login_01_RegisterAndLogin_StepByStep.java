package com.nopcommerce.Demo_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login_01_RegisterAndLogin_StepByStep {

    private WebDriver driver;
    private Select select;
    private String password;
    private String email;
    // private String emailHash = "khanhpln1234@hotmail.com";
    // WebElement email = driver.findElement(By.xpath(""));

    @BeforeTest
    public void beforeTest() {
        // driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

        email = "khanhpln" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";
    }

    @Test
    public void TC_01_Register_To_System() {
        // click to Register Link

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Khanh");
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Pham");
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        select.selectByVisibleText("1");

        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        select.selectByVisibleText("February");

        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        select.selectByValue("1986");

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        System.out.println("Email after sendkey : " + email);

        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Corona Virus");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='register-button']")).click();

        // verify registered success
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='register-continue']")).click();

        // click log out system
        driver.findElement(By.xpath("//a[text()='Log out']")).click();

        // verify home page is displayed after logout
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Register']")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_02_Login_To_System() {
        System.out.println("Email after jump in to test case 02 : " + email);

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
