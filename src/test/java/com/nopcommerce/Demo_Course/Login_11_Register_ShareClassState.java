package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Login_11_Register_ShareClassState extends AbstractTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        loginPage = homePage.clickToLoginLink();
        loginPage.inputRegisteredEmail(registerPage.inputToEmail());
        loginPage.inputToPasswordTextbox(registerPage.inputToPassword());
        loginPage.clickToLoginButton();
        Assert.assertTrue(loginPage.isMyAccountDisplayed());
    }

    @Test
    public void TC_01_ViewProduct() {

    }

    @Test
    public void TC_02_Order() {

    }

    @Test
    public void TC_03_Payment() {

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }
}
