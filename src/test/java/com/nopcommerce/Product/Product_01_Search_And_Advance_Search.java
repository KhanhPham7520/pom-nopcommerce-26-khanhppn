package com.nopcommerce.Product;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.ProductData;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.FooterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;

public class Product_01_Search_And_Advance_Search extends AbstractTest {
	WebDriver driver;
	SearchPageObject searchPage;

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	FooterPageObject footerPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		searchPage = PageGeneratorManager.getSearchPage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		footerPage = PageGeneratorManager.getFooterPage(driver);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage = homePage.clickToLoginLink();
		loginPage.inputCorrectEmail();
		loginPage.inputCorrectPassword();
		homePage = loginPage.clickToLoginButton();
		homePage.clickToSearchLinkFooter();

	}

	@BeforeMethod
	public void beforeMethod() {
		searchPage = footerPage.clickToSearchLink();
	}

	@Test
	public void TC_01_Search_Empty_Data() throws Exception {

		searchPage.inputKeyword("");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.displayMessageWarning(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Not_Existing_Data() {

		searchPage.inputKeyword("Macbook Pro 2050");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.displayMessageNoResult(), GlobalConstants.NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE);
	}

	@Test
	public void TC_03_Search_Relative_Product_Name() {

		searchPage.inputKeyword("Lenovo");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.isProduct_First_Displayed(), ProductData.searchProduct.Lenovo_IdeaCentre_600_All_in_One_PC);

		verifyEquals(searchPage.isProduct_Second_Displayed(), ProductData.searchProduct.Lenovo_Thinkpad_X1_Carbon_Laptop);

	}

	@Test
	public void TC_04_Search_Absolutely_Product_Name() {

		searchPage.inputKeyword("ThinkPad X1 Carbon");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.isProduct_Second_Displayed(), ProductData.searchProduct.Lenovo_Thinkpad_X1_Carbon_Laptop);
	}

	@Test
	public void TC_05_Advance_Search_Parent_Categories() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.uncheckAutoSearchSubCat();

		searchPage.clickSearchButton();

		verifyEquals(searchPage.displayMessageNoResult(), GlobalConstants.NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE);

	}

	@Test
	public void TC_06_Advanced_Search_Sub_Category() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.clickSearchButton();

		verifyEquals(searchPage.display_Apple_Product(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_07_Advance_Search_Incorrect_Manufacturer() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.selectedManufacturer("HP");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.displayMessageNoResult(), GlobalConstants.NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE);

	}

	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.selectedManufacturer("Apple");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.display_Apple_Product(), ProductData.searchProduct.Apple_MacBook_Pro_13_inch);
	}

	@Test
	public void TC_09_Advanced_Within_Price_Range() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.selectedManufacturer("Apple");

		searchPage.inputPriceFrom("1000");

		searchPage.inputPriceTo("2000");

		searchPage.clickSearchButton();

		Assert.assertEquals(searchPage.display_Apple_Product(), ProductData.searchProduct.Apple_MacBook_Pro_13_inch);
	}

	@Test
	public void TC_10_Advanced_Search_Price_Range_Lower_Than_Product_Price() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.selectedManufacturer("Apple");

		searchPage.inputPriceFrom("1000");

		searchPage.inputPriceTo("1700");

		searchPage.clickSearchButton();

		verifyEquals(searchPage.displayMessageNoResult(), GlobalConstants.NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE);

	}

	@Test
	public void TC_11_Advanced_Search_Price_Range_Higher_Than_Product_Price() {
		searchPage.inputKeyword("Apple MacBook Pro");

		searchPage.checkAdvanceSearchCheckbox();

		searchPage.selectCategory("Computers");

		searchPage.checkAutoSearchSubCatCheckbox();

		searchPage.selectedManufacturer("Apple");

		searchPage.inputPriceFrom("1900");

		searchPage.inputPriceTo("5000");

		searchPage.clickSearchButton();

		Assert.assertEquals(searchPage.displayMessageNoResult(), GlobalConstants.NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
