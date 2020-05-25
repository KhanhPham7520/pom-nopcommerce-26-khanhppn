package com.nopcommerce.commons;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Common_02_LoginToSystem extends AbstractTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);
        System.out.println("Driver at CM2 : " + driver.toString());

        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        loginPage = homePage.clickToLoginLink();
        loginPage.inputRegisteredEmail(registerPage.inputToEmail());
        loginPage.inputToPasswordTextbox(registerPage.inputToPassword());
        loginPage.clickToLoginButton();
        Assert.assertTrue(loginPage.isMyAccountDisplayed());

        // closeBrowserAndDriver(driver);
    }

}
