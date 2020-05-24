package com.nopcommerce.Product;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;

public class Product_03_Order extends AbstractTest {

    ShoppingCartPageObject shoppingCartPage;
    // Data Test
    String productName = "Build your own computer";
    String processorName = "2.2 GHz Intel Pentium Dual-Core E2200";
    String productProcessorText = "Processor: ";
    String productProcessorVerifyResult = productProcessorText.concat(processorName);
    String ramName = "8GB [+$60.00]";
    String productRAMText = "RAM : ";
    String productRamVerifyResult = productRAMText.concat(ramName);
    String hddName = "400 GB [+$100.00]";
    String osName = "Vista Premium [+$60.00]";
    String softwareNameFirst = "Microsoft Office [+$50.00]";
    String softwareNameSecond = "Acrobat Reader [+$10.00]";
    String softwareNameThird = "Total Commander [+$5.00]";
    // Edit product info
    String editProcessorName = "2.2 GHz Intel Pentium Dual-Core E2200";
    String editRamName = "4GB [+$20.00]";
    String editHddName = "320 GB";
    String editOsName = "Vista Home";
    String editSoftwareName = "Microsoft Office";
    String editProductQuantity = "2";
    String editProductPriceResult = "$1,320.00";
    String editPriceCart = "$1,320.00";
    String editPriceTotal = "$2,640.00";
    String emptyShoppingCartMsg = "Your Shopping Cart is empty!";
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;
    private HeaderPageObject headerPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
        productPage = PageGeneratorManager.getProductPageObject(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        headerPage = PageGeneratorManager.getHeaderPage(driver);

        loginPage = homePage.clickToLoginLink();
        loginPage.inputCorrectEmail();
        loginPage.inputCorrectPassword();
        homePage = loginPage.clickToLoginButton();
        productPage = homePage.clickToProductLink(productName);
    }

    @Test
    public void TC_01_Add_Product_To_Cart() {
        productPage.selectProcessor(processorName);
        productPage.selectRAM(ramName);

        productPage.selectHDD(hddName);

        productPage.selectOS(osName);

        productPage.selectSoftware(softwareNameFirst);
        productPage.selectSoftware(softwareNameSecond);
        productPage.selectSoftware(softwareNameThird);

        productPage.clickAddToCart();
        verifyEquals(productPage.getAddToCartSuccessMsg(), "The product has been added to your shopping cart");

        shoppingCartPage = productPage.clickShoppingCarNotiBar();

        System.out.println("Processor Name :  " + shoppingCartPage.getProductInfo());
        // verifyEquals(shoppingCartPage.getTextProcessorName(), "Processor: " + processorName);
    }

    @Test
    public void TC_02_Edit_Product_In_Shopping_Cart() {
        shoppingCartPage = headerPage.clickToShoppingCartLink();

        shoppingCartPage.clickToEditItemLink();

        productPage.selectProcessor(editProcessorName);

        productPage.selectRAM(editRamName);

        productPage.selectHDD(editHddName);

        productPage.selectOS(editOsName);

        productPage.selectSoftware(editSoftwareName);

        productPage.inputQuantityProduct(editProductQuantity);

        verifyEquals(productPage.getProductPrice(), editProductPriceResult);

        productPage.clickAddToCart();

        shoppingCartPage = productPage.clickShoppingCarNotiBar();

        verifyEquals(shoppingCartPage.getProductPriceResultTable(), editPriceCart);
        verifyEquals(shoppingCartPage.getProductTotalTable(), editPriceTotal);
    }

    @Test
    public void TC_03_Remove_From_Cart() {
        shoppingCartPage = productPage.clickToShoppingCart(driver);
        shoppingCartPage.clickToRemoveCheckbox();
        shoppingCartPage.clickToButton("Update shopping cart");

        verifyEquals(shoppingCartPage.getEmptyShoppingCartMsg(), emptyShoppingCartMsg);

    }

    // @Test
    public void TC_04_Update_Shopping_Cart() {
    }

    // @Test
    public void TC_05_Checkout_Order_Payment_Method_By_Cheque() {

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
