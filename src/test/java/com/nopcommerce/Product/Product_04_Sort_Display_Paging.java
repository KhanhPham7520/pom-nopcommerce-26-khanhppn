package com.nopcommerce.Product;

import com.nopcommerce.data.ProductData;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NotebooksPageObject;
import pages.NotebooksPageUI;

public class Product_04_Sort_Display_Paging extends AbstractTest {

    LoginPageObject loginPage;
    HomePageObject homePage;
    NotebooksPageObject notebooksPage;
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

        verifyTrue(loginPage.isMyAccountDisplayed());

        notebooksPage = homePage.selectProductItemInNavigationBar(driver, ProductData.sortAndDisplayData.Navigation_Label, ProductData.sortAndDisplayData.Navigation_Item);
    }

    @Test
    public void TC_01_Sort_With_Name_A_To_Z() {

        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, ProductData.sortAndDisplayData.Select_Name_A_To_Z);

        verifyTrue(notebooksPage.isNameSortedAscending(driver));
    }

    @Test
    public void TC_02_Sort_With_Name_Z_To_A() {

        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, ProductData.sortAndDisplayData.Select_Name_Z_To_A);

        verifyTrue(notebooksPage.isNameSortedDescending(driver));

    }

    @Test
    public void TC_03_Sort_With_Price_Low_To_High() {

        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, ProductData.sortAndDisplayData.Select_Price_Low_To_High);

        verifyTrue(notebooksPage.isPriceSortedAscending(driver));
    }

    @Test
    public void TC_04_Sort_With_Price_High_To_Slow() {

        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN);

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_POSITION_DROPDOWN, ProductData.sortAndDisplayData.Select_Price_High_To_Low);

        verifyTrue(notebooksPage.isPriceSortedDescending(driver));

    }

    @Test
    public void TC_05_Display_With_3_Products_Per_Page() {

        notebooksPage.clickToElement(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN);

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, ProductData.sortAndDisplayData.Three_Products_Per_Page);

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

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, ProductData.sortAndDisplayData.Six_Products_Per_Page);

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

        notebooksPage.selectDropdownByVisibleText(driver, NotebooksPageUI.SORT_BY_PRICE_DROPDOWN, ProductData.sortAndDisplayData.Nine_Products_Per_Page);

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
