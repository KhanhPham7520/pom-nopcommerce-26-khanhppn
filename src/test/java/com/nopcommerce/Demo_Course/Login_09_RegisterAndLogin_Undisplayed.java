package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPO;

import java.util.Date;
import java.util.Random;

public class Login_09_RegisterAndLogin_Undisplayed extends AbstractTest {

    HomePageObject homePage;
    WebElement element;
    RegisterPO registerPage;
    private WebDriver driver;
    private Date date;
    private String password;
    private String email;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String autURL) {
        driver = getBrowserDriver(browserName, autURL);
        System.out.println("Driver at test class : " + driver.toString());

        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        email = "khanhpln" + randomNumber() + "@hotmail.com";
        password = "Abc123456789";
    }

    @Test(description = "Check element displayed")
    public void TC_01_CheckDisplay() {
        registerPage = homePage.clickToRegisterLink();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        // First Name displayed
        Assert.assertTrue(registerPage.isDisplayed(driver, "//input[@id='FirstName']"));
        // Last Name
        Assert.assertTrue(registerPage.isDisplayed(driver, "//input[@id='LastName']"));
    }

    @Test(description = "Check element displayed")
    public void TC_02_CheckUndisplay_In_DOM() {
        // Request Verification token undisplayed ( có trong DOM)
        Assert.assertFalse(isElementDisplayed("input[name='__RequestVerificationToken']"));
        Assert.assertTrue(isElementDisplayed("input[name='__RequestVerificationToken']"));
    }

    @Test(description = "Check element displayed")
    public void TC_03_CheckUndisplay_Not_In_DOM() {
        Assert.assertFalse(isElementDisplayed("//input[@class='button-1 register-button']"));
        Assert.assertTrue(isElementDisplayed("//input[@class='button-1 register-button']"));

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public void startTime() {
        System.out.println("Start time = " + new Date());
    }

    public void endTime() {
        System.out.println("End time = " + new Date());
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

    public boolean isElementDisplayed(String locator) {
        try {
            element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            // throw exeption -> Catch sẽ bắt dc những Exception này
            // Không đánh fail test case tại thời điểm đang chạy
            e.printStackTrace();
            return false;
        }
    }

}
