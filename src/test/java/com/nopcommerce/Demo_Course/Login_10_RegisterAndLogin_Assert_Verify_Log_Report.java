package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_10_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest {
    private WebDriver driver;
    // private HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        // driver = getBrowserDriver(browserName);

        // homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Assert() {
        System.out.println("TC_01_Assert - Step 01: Open New Customer Page");

        log.info("TC_01_Assert - Step 02: Verify New Customer page is displayed");
        Assert.assertTrue(true);

        log.info("TC_01_Assert - Step 03: Verify New Customer form not displayed");
        Assert.assertFalse(false);

        log.info("TC_01_Assert - Step 04: Verify Home Page not displayed");
        Assert.assertTrue(true);

        // Assert.assertFalse(true, "Thong bao ra cai message nay khi bi fail");
        Assert.assertEquals("Automation FC", "AutomationFC", "Actual Result and Expected Result are not equal");
    }

    @Test
    public void TC_02_Login_To_System() {
        log.info("TC_02 - Step 01 : Open New CustomerPage");

        log.info("TC_02 - Step 02 : Verify New Customer Page displayed");
        verifyTrue(true);

        log.info("TC_02 - Step 03 : Verify New Customer Form not displayed");
        verifyTrue(false);

        log.info("TC_02 - Step 04 : Verify Home Page not displayed");
        verifyTrue(true);

        log.info("TC_02 - Step 05 : Verify New Customer form not displayed");
        verifyTrue(false);
    }

    @Test(description = "Only use in case less page")
    public void TC_03_Dynamic_Less() {

    }

    // Xử lý khởi tạo đối tượng page ở chính cái step trong test case
    @Test(description = "Only use in case more page")
    public void TC_04_Dynamic_More() {
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
