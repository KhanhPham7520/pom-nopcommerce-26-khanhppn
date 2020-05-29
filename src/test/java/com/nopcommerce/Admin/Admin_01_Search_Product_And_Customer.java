package com.nopcommerce.Admin;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.Admin.*;
import pageObjects.LoginPageObject;
import pageUIs.AbstractNopCommercePageUI;
import pageUIs.Admin.AdminSearchCustomerPageUI;
import pageUIs.bankGuru.EditCustomerPageUI;

public class Admin_01_Search_Product_And_Customer extends AbstractTest {

    WebDriver driver;
    AdminHomePageObject adminHomePage;
    AdminSidebarPageObject adminSidebarPage;
    AdminProductPageObject adminProductPage;
    AdminEditProductDetailPageObject adminEditProductPage;
    AdminSearchCustomerPageObject adminSearchCustomerPage;
    AdminAddNewCustomerPageObject adminAddNewCustomerPage;
    AdminEditCustomerPageObject adminEditCustomerPage;
    // Test Data
    String productName = "Lenovo IdeaCentre 600 All-in-One PC";
    String SKU = "LE_IC_600";
    String price = "500";
    String stockQuantity = "10000";
    String productType = "Simple";
    // Expected Message
    String noDataMessage = "No data available in table";
    // Create New Customer
    // String email = "automationfc" + randomNumber() + "@gmail.com";
    String email = "automationfc@gmail.com";
    String password = "1234567";
    String firstName = "Automation";
    String lastName = "FC";
    String DOB = "1/1/2000";
    String companyName = "Automation FC";
    String customerRole = "Guests";
    String adminComment = "Add new Customer(Guest)";
    private LoginPageObject loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriverOfAdmin(browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
        adminSidebarPage = PageGeneratorManager.getAdminSidebar(driver);
        adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
        adminEditProductPage = PageGeneratorManager.getAdminEditProductPage(driver);
        adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
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

        verifyEquals(adminProductPage.verifyProductName(productName), productName);
        verifyEquals(adminProductPage.verifyProductSKU(), SKU);
        verifyEquals(adminProductPage.verifyProductPrice(), price);
        verifyEquals(adminProductPage.verifyProductStockQuantity(), stockQuantity);
        verifyEquals(adminProductPage.verifyProductType(), productType);
        verifyTrue(adminProductPage.isPublished());

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

        verifyEquals(adminProductPage.verifyNoDataMessage(), noDataMessage);
    }

    @Test
    public void TC_06_Go_Directly_To_Product_SKU() {

        adminSidebarPage.clickToCatalogLink();

        adminProductPage = adminSidebarPage.clickToProductLink();

        adminProductPage.inputSKUTextbox(SKU);

        adminEditProductPage = adminProductPage.clickGoSKUButton();

        verifyEquals(adminEditProductPage.getProductName(), productName);

    }

    @Test
    public void TC_07_Create_New_Customer() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminAddNewCustomerPage = adminSearchCustomerPage.clickToAddNewButton();

        adminAddNewCustomerPage.inputEmailTextbox(email);

        adminAddNewCustomerPage.inputPasswordTextbox(password);

        adminAddNewCustomerPage.inputFirstNameTextbox(firstName);

        adminAddNewCustomerPage.inputLastNameTextbox(lastName);

        adminAddNewCustomerPage.selectMaleGender();

        adminAddNewCustomerPage.selectDOB(driver, DOB);

        adminAddNewCustomerPage.inputCompanyNameTextbox(companyName);

        adminAddNewCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminAddNewCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminAddNewCustomerPage.selectActiveStatus(true);

        adminAddNewCustomerPage.inputAdminComment(adminComment);

        adminAddNewCustomerPage.clickSaveButton();

        verifyTrue(adminAddNewCustomerPage.isAddedSuccessfulDisplayed());
    }

    @Test
    public void TC_08_Search_Customer_With_Email() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputEmailTextbox(email);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminSearchCustomerPage.clickSearchButton();

//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"3"), "Automation FC");

//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"5"), "Automation FC");
    }

    @Test
    public void TC_09_Search_Customer_With_FirstName_And_LastName() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputFistNameTextbox(firstName);

        adminSearchCustomerPage.inputLastNameTextbox(lastName);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminSearchCustomerPage.clickSearchButton();

    }

    @Test
    public void TC_10_Search_Customer_With_Company() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputCompanyTextbox(companyName);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminSearchCustomerPage.clickSearchButton();

//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"3"),companyName);
//
//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"4"),customerRole);
//
//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"5"),companyName);

    }

    @Test
    public void TC_11_Search_Customer_Full_Data() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputEmailTextbox(email);

        adminSearchCustomerPage.inputFistNameTextbox(firstName);

        adminSearchCustomerPage.inputLastNameTextbox(lastName);

        adminSearchCustomerPage.selectBirthMonth("1");

        adminSearchCustomerPage.selectBirthDay("1");

        adminSearchCustomerPage.inputCompanyTextbox(companyName);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminSearchCustomerPage.clickSearchButton();

//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"3"),companyName);

//		verifyEquals(adminSearchCustomerPage.getTextResultTable(driver,"4"),customerRole);

        //	verifyEquals(adminSearchCustomerPage.getTextResultTable("5"),companyName);

    }

    @Test
    public void TC_12_Edit_Customer() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputEmailTextbox(email);

        adminSearchCustomerPage.inputFistNameTextbox(firstName);

        adminSearchCustomerPage.inputLastNameTextbox(lastName);

        adminSearchCustomerPage.selectBirthMonth("1");

        adminSearchCustomerPage.selectBirthDay("1");

        adminSearchCustomerPage.inputCompanyTextbox(companyName);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.REGISTERED_ROLE_DELETE);

        adminSearchCustomerPage.clickToElement(driver, AdminSearchCustomerPageUI.CUSTOMER_ROLE_LISTBOX);

        adminSearchCustomerPage.selectCustomerRoles(driver, customerRole);

        adminSearchCustomerPage.clickSearchButton();

        adminEditCustomerPage = adminSearchCustomerPage.clickToEditInTable();

        adminEditCustomerPage.inputDynamicTextbox(driver, "edit_automationfc@gmail.com", "Email");

        adminEditCustomerPage.inputDynamicTextbox(driver, "Edit Automation", "FirstName");

        adminEditCustomerPage.inputDynamicTextbox(driver, "Edit FC", "LastName");

        adminEditCustomerPage.selectDOB(driver, "2/2");

        adminEditCustomerPage.inputDynamicTextbox(driver, "Edit Automation FC", "Company");

        adminEditCustomerPage.inputToDynamicTextArea(driver, "Edit Customer (Guests)", "AdminComment");

        adminEditCustomerPage.clickIntoButton(driver, AbstractNopCommercePageUI.DYNAMIC_BUTTON_CLICK, "save");

        verifyTrue(adminEditCustomerPage.isUpdatedCustomerInfoSucess(driver));
    }

    @Test
    public void TC_15_Delete_Customer() {

        adminSidebarPage.clickCustomerMenuLink();

        adminSearchCustomerPage = adminSidebarPage.clickToCustomersLink();

        adminSearchCustomerPage.inputEmailTextbox("edit_automationfc@gmail.com");

        adminSearchCustomerPage.inputFistNameTextbox("Edit Automation");

        adminSearchCustomerPage.inputLastNameTextbox("Edit FC");

        adminSearchCustomerPage.selectBirthMonth("2");

        adminSearchCustomerPage.selectBirthDay("2");

        adminSearchCustomerPage.inputCompanyTextbox("Edit Automation FC");

        adminSearchCustomerPage.clickSearchButton();

        adminEditCustomerPage = adminSearchCustomerPage.clickToEditInTable();

        adminEditCustomerPage.clickIntoButton(driver, EditCustomerPageUI.DELETE_SPAN);

        adminEditCustomerPage.clickDeletedInConfirmBox(driver);

        verifyTrue(adminEditCustomerPage.isDeletedCustomerInfoSucess(driver));

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
