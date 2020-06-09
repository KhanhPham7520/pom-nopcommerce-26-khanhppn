package com.nopcommerce.Demo_Course;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;

public class Login_10_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Assert() {

		log.info("TC_01_Assert - Step 01: Open New Customer Page");
		verifyTrue(true);

		log.info("TC_01_Assert - Step 02: Verify New Customer page is displayed");
		Assert.assertTrue(true);

		log.info("TC_01_Assert - Step 03: Verify New Customer form not displayed");
		Assert.assertFalse(false);

		log.info("TC_01_Assert - Step 04: Verify Home Page not displayed");
		Assert.assertTrue(true);

		// Assert.assertFalse(true, "Thong bao ra cai message nay khi bi fail");
		Assert.assertEquals("Automation FC", "AutomationFC", "Actual Result and Expected Result are not equal");
	}

	@Test(enabled = true)
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

	@Test(enabled = true)
	public void TC_03_Dynamic_Less() {

	}

	// Xử lý khởi tạo đối tượng page ở chính cái step trong test case
	@Test(enabled = false)
	public void TC_04_Dynamic_More() {
	}

	@AfterTest
	public void afterTest() {
		closeBrowserAndDriver(driver);
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
