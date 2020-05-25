package com.nopcommerce.Product;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pageUIs.NotebooksPageUI;

public class Product_04_Sort_Display_Paging extends AbstractTest {

    SearchPageObject searchPage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    ProductPageObject productPage;
    HeaderPageObject headerPage;
    NotebooksPageObject notebooksPage;
    String navigationLabel = "Computers";
    String navigationItem = "Notebooks";
    String selectNameAToZ = "Name: A to Z";
    String selectNameZToA = "Name: Z to A";
    String selectLowToHigh = "Price: Low to High";
    String selectHighToLow = "Price: High to Low";
    String threeProductsPerPage = "3";
    String sixProductsPerPage = "6";
    String nineProductsPerPage = "9";
    int threeProductsPerPageVerify = 3;
    int sixProductsPerPageVerify = 6;
    int nineProductsPerPageVerify = 9;
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        notebooksPage = PageGeneratorManager.getNotebooksPage(driver);

        loginPage = homePage.clickToLoginLink();
        loginPage.inputCorrectEmail();
        loginPage.inputCorrectPassword();
        homePage = loginPage.clickToLoginButton();

        Assert.assertTrue(loginPage.isMyAccountDisplayed());

        notebooksPage = homePage.selectProductItemInNavigationBar(driver, navigationLabel, navigationItem);
    }

    @Test
    public void TC_01_Sort_With_Name_A_To_Z() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, selectNameAToZ);
        // printBrowserConsoleLogs(driver);

        verifyTrue(notebooksPage.isNameSortedAscending(driver));
    }

    @Test
    public void TC_02_Sort_With_Name_Z_To_A() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, selectNameZToA);

        verifyTrue(notebooksPage.isNameSortedDescending(driver));

    }

    @Test
    public void TC_03_Sort_With_Price_Low_To_High() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, selectLowToHigh);

        verifyTrue(notebooksPage.isPriceSortedAscending(driver));
    }

    @Test
    public void TC_04_Sort_With_Price_High_To_Slow() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, selectHighToLow);

        verifyTrue(notebooksPage.isPriceSortedDescending(driver));

    }

    @Test
    public void TC_05_Display_With_3_Products_Per_Page() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, threeProductsPerPage);

        boolean isHigherThanZeroPageIsDisplayed = notebooksPage.getListItem() > 0;
        boolean isThreeProductsPerPageDisplayed = notebooksPage.getListItem() <= threeProductsPerPageVerify;
        if (isHigherThanZeroPageIsDisplayed && isThreeProductsPerPageDisplayed) {
            verifyTrue(isHigherThanZeroPageIsDisplayed);
            verifyTrue(isThreeProductsPerPageDisplayed);
        } else {
            verifyFalse(isHigherThanZeroPageIsDisplayed);
            verifyFalse(isThreeProductsPerPageDisplayed);
        }

    }

    @Test
    public void TC_06_Display_With_6_Products_Per_Page() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, sixProductsPerPage);
        scrollToBottomPage(driver);

        boolean isHigherThanZeroPageIsDisplayed = notebooksPage.getListItem() > 0;
        boolean isSixProductsPerPageDisplayed = notebooksPage.getListItem() <= sixProductsPerPageVerify;
        if (isHigherThanZeroPageIsDisplayed && isSixProductsPerPageDisplayed) {
            verifyTrue(isHigherThanZeroPageIsDisplayed);
            verifyTrue(isSixProductsPerPageDisplayed);
        } else {
            verifyFalse(isHigherThanZeroPageIsDisplayed);
            verifyFalse(isSixProductsPerPageDisplayed);
        }

        verifyFalse(notebooksPage.isPaginationLinkDisplayed());
    }

    @Test
    public void TC_07_Display_With_9_Products_Per_Page() {
        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN);
        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, nineProductsPerPage);
        scrollToBottomPage(driver);

        boolean isHigherThanZeroPageIsDisplayed = notebooksPage.getListItem() > 0;
        boolean isNineProductsPerPageDisplayed = notebooksPage.getListItem() <= nineProductsPerPageVerify;
        if (isHigherThanZeroPageIsDisplayed && isNineProductsPerPageDisplayed) {
            verifyTrue(isHigherThanZeroPageIsDisplayed);
            verifyTrue(isNineProductsPerPageDisplayed);
        } else {
            verifyFalse(isHigherThanZeroPageIsDisplayed);
            verifyFalse(isNineProductsPerPageDisplayed);
        }
        verifyFalse(notebooksPage.isPaginationLinkDisplayed());

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }
}
