package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;

public class Login_13_Sort_Asc_Desc extends AbstractTest {

    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Sort_Ascending() {

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
