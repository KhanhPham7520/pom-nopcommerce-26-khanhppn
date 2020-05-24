package com.nopcommerce.Admin;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Admin.*;
import pageObjects.LoginPageObject;

import java.util.Random;

public class Admin_01_Search_Product_And_Customer extends AbstractTest {

    WebDriver driver;
    AdminHomePageObject adminHomePage;
    AdminSidebarPageObject adminSidebarPage;
    AdminProductPageObject adminProductPage;
    AdminEditProductDetailPageObject adminEditProductPage;
    AdminSearchCustomerPageObject adminSearchCustomerPage;
    AdminAddNewCustomerPageObject adminAddNewCustomerPage;
    // Test Data
    String productName = "Lenovo IdeaCentre 600 All-in-One PC";
    String SKU = "LE_IC_600";
    String price = "500";
    String stockQuantity = "10000";
    String productType = "Simple";
    boolean isPublished;
    // Expected Message
    String noDataMessage = "No data available in table";
    String addNewCustomerSuccess = "The new customer has been added successfully";
    // Create New Customer
    // String email = "automationfc" + randomNumber() + "@gmail.com";
    String email = "automationfc@gmail.com";
    String password = "1234567";
    String firstName = "Automation";
    String lastName = "FC";
    String gender = "Male";
    String DOB = "1/1/2000";
    String companyName = "Automation FC";
    String customerRole = "Guests";
    boolean isActived = true;
    String adminComment = "Add new Customer(Guest)";
    String addNewCustomerSuccessMsg = "The new customer has been added successfully";
    String randomEmail = "jsstaham" + randomNumber() + "hotmail.com";
    private LoginPageObject loginPage;

    // Random Method
    public static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt();
    }

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriverOfAdmin(browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
        adminSidebarPage = PageGeneratorManager.getAdminSidebar(driver);
        adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
        adminEditProductPage = PageGeneratorManager.getAdminEditProductPage(driver);
        adminSearchCustomerPage = PageGeneratorManager.getAdminSearchCustomerPage(driver);
        adminAddNewCustomerPage = PageGeneratorManager.getAdminAddNewCustomerPage(driver);

        loginPage.inputCorrectAdminEmail();
        loginPage.inputCorrectAdminPassword();
        adminHomePage = loginPage.clickToAdminLoginButton();
    }

    @Test
    public void TC_01_Search_With_Product_Name() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputToProductNameTextbox(productName);
        adminProductPage.clickToSearchButton();

        Assert.assertEquals(adminProductPage.verifyProductName(productName), productName);
        Assert.assertEquals(adminProductPage.verifyProductSKU(), SKU);
        Assert.assertEquals(adminProductPage.verifyProductPrice(), price);
        Assert.assertEquals(adminProductPage.verifyProductStockQuantity(), stockQuantity);
        Assert.assertEquals(adminProductPage.verifyProductType(), productType);
        Assert.assertTrue(adminProductPage.isPublished());

    }

    @Test
    public void TC_02_Search_With_Product_Name_Parent_Category_Unchecked() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputToProductNameTextbox(productName);
        adminProductPage.selectCategory("Computers");
        adminProductPage.clickToSearchButton();

        verifyEquals(adminProductPage.verifyNoDataMessage(), noDataMessage);
    }

    @Test
    public void TC_03_Search_With_Product_Name_Parent_Category_Checked() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputToProductNameTextbox(productName);
        adminProductPage.selectCategory("Computers");
        adminProductPage.checkSearchSubCategory();
        adminProductPage.clickToSearchButton();

        verifyEquals(adminProductPage.verifyProductName(productName), productName);
        verifyEquals(adminProductPage.verifyProductSKU(), SKU);
        verifyEquals(adminProductPage.verifyProductPrice(), price);
        verifyEquals(adminProductPage.verifyProductStockQuantity(), stockQuantity);
        verifyEquals(adminProductPage.verifyProductType(), productType);
        verifyTrue(adminProductPage.isPublished());
    }

    @Test
    public void TC_04_Search_With_Product_Name_Child_Category() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputToProductNameTextbox(productName);
        adminProductPage.selectCategory("Computers >> Desktops");
        adminProductPage.clickToSearchButton();

        verifyEquals(adminProductPage.verifyProductName(productName), productName);
        verifyEquals(adminProductPage.verifyProductSKU(), SKU);
        verifyEquals(adminProductPage.verifyProductPrice(), price);
        verifyEquals(adminProductPage.verifyProductStockQuantity(), stockQuantity);
        verifyEquals(adminProductPage.verifyProductType(), productType);
        verifyTrue(adminProductPage.isPublished());
    }

    @Test
    public void TC_05_Search_With_Product_Name_Manufacturer() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputToProductNameTextbox(productName);
        adminProductPage.selectCategory("All");
        adminProductPage.selectManufacturer("Apple");
        adminProductPage.clickToSearchButton();

        Assert.assertEquals(adminProductPage.verifyNoDataMessage(), noDataMessage);
    }

    @Test
    public void TC_06_Go_Directly_To_Product_SKU() {
        adminSidebarPage.clickToCatalogLink();
        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputSKUTextbox(SKU);
        adminEditProductPage = adminProductPage.clickGoSKUButton();

        Assert.assertEquals(adminEditProductPage.getProductName(), productName);

    }

    @Test
    public void TC_07_Create_New_Customer() {
        adminSidebarPage.clickCustomerMenuLink();
        adminSidebarPage.clickToCustomersLink();

        adminAddNewCustomerPage = adminSearchCustomerPage.clickToAddNewButton();
        adminAddNewCustomerPage.inputEmailTextbox(email);
        adminAddNewCustomerPage.inputPasswordTextbox(password);
        adminAddNewCustomerPage.inputFirstNameTextbox(firstName);
        adminAddNewCustomerPage.inputLastNameTextbox(lastName);
        adminAddNewCustomerPage.selectMaleGender();
        adminAddNewCustomerPage.selectDOB(DOB);
        adminAddNewCustomerPage.inputCompanyNameTextbox(companyName);
        // adminAddNewCustomerPage.selectCustomerRoles(customerRole);
        adminAddNewCustomerPage.selectActiveStatus(true);
        adminAddNewCustomerPage.inputAdminComment(adminComment);
        adminAddNewCustomerPage.clickSaveButton();

        // Assert.assertEquals(adminAddNewCustomerPage.verifyAddNewCustomerSuccess(), addNewCustomerSuccess);
        Assert.assertTrue(adminAddNewCustomerPage.isAddedSuccessfulDisplayed());
    }

    @Test
    public void TC_08_Search_Customer_With_Email() {
        adminSidebarPage.clickCustomerMenuLink();
        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputEmailTextbox("automationfc@gmail.com");
        // adminSearchCustomerPage.deleteRegisterdRole(driver);
        adminSearchCustomerPage.clickSearchButton();

        // Verify Name of table
        Assert.assertEquals(adminSearchCustomerPage.verifyResultTable("3"), "Automation FC");

        // Verify Company name of table
        Assert.assertEquals(adminSearchCustomerPage.verifyResultTable("5"), "Automation FC");
    }

    @Test
    public void TC_09_Search_Customer_With_FirstName_And_LastName() {
        adminSidebarPage.clickCustomerMenuLink();
        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputFistNameTextbox(firstName);
        adminSearchCustomerPage.inputLastNameTextbox(lastName);
        // adminSearchCustomerPage.selectCustomerRole(customerRole);
        adminSearchCustomerPage.clickSearchButton();

    }

    @Test
    public void TC_10_Search_Customer_With_Company() {

    }

    @AfterTest
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
