package com.nopcommerce.Product;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import pageUIs.CheckOutPageUI;
import pageUIs.ShoppingCartPageUI;

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

    int priceProduct;
    int quantityProduct;

    int totalPrice = priceProduct * quantityProduct;


    String billingName ="Auto";
    String billingEmail = "johnwick_111222@gmail.com";
    String billingPhone = "12312312312";
    String billingAddressOne = "123 Address";
    String billingCity = "123 Address";
    String billingCountry = "Venezuela";

    String paymentMethod = "Check / Money Order";


    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;
    private HeaderPageObject headerPage;
    private DesktopsPageObject desktopsPage;
    private CheckOutPageObject checkoutPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
        productPage = PageGeneratorManager.getProductPageObject(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        headerPage = PageGeneratorManager.getHeaderPage(driver);
        desktopsPage = PageGeneratorManager.getDesktopPage(driver);
        checkoutPage = PageGeneratorManager.getCheckOutPage(driver);

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

        System.out.println("Processor Name :  " + getTextElement(driver, "//div[@class='product']//following-sibling::div[@class='attributes']"));
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

   @Test
    public void TC_04_Update_Shopping_Cart() {

       desktopsPage = headerPage.clickToTextOfHeaderMenu("Computers","Desktops");

       productPage = desktopsPage.clickIntoProductLink("Lenovo IdeaCentre 600 All-in-One PC");

       productPage.clickAddToCart();

       shoppingCartPage =  productPage.clickToShoppingCart(driver);

       shoppingCartPage.inputToQuantityTextbox("5");

       shoppingCartPage.clickToButton("Update shopping cart");

       verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.PRICE_TOTAL_TABLE),"$2,500.00");
    }

    @Test
    public void TC_05_Checkout_Order_Payment_Method_By_Cheque() {

        desktopsPage = headerPage.clickToTextOfHeaderMenu("Computers","Notebooks");

        productPage = desktopsPage.clickIntoProductLink("Apple MacBook Pro 13-inch");

        productPage.clickAddToCart();

        shoppingCartPage =  productPage.clickToShoppingCart(driver);

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.ESTIMATING_SHIPPING_BUTTON);

        shoppingCartPage.switchToPopUpModal(driver);

        shoppingCartPage.selectDropdownByVisibleText(driver,ShoppingCartPageUI.SELECT_COUNTRY_ESTIMATING_SHIPPING,"Viet Nam");

        shoppingCartPage.sendKeyToElement(driver, ShoppingCartPageUI.ZIP_POSTAL_CODE_ESTIMATING_SHIPPING, "550000");

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.APPLY_BUTTON_ESTIMATING_SHIPPING);

      //  shoppingCartPage.switchToParentScreen(driver);

        shoppingCartPage.clickIntoCheckbox(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);

        checkoutPage = shoppingCartPage.clickIntoCheckoutButton(driver, ShoppingCartPageUI.CHECK_OUT_BUTTON);

        checkoutPage.clickIntoCheckbox(driver, CheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);

        checkoutPage.inputDynamicTextbox(driver, "Auto", "BillingNewAddress_FirstName");

        checkoutPage.inputDynamicTextbox(driver, "Test", "BillingNewAddress_LastName");

        checkoutPage.inputDynamicTextbox(driver, "johnwick_111222@gmail.com", "BillingNewAddress_Email");

        checkoutPage.selectDynamicItemInDropdown(driver, "Australia", "BillingNewAddress_CountryId");

        checkoutPage.inputDynamicTextbox(driver, "Melbourne", "BillingNewAddress_City");

        checkoutPage.inputDynamicTextbox(driver, "123 Victoria St", "BillingNewAddress_Address1");

        checkoutPage.inputDynamicTextbox(driver, "999777", "BillingNewAddress_ZipPostalCode");

        checkoutPage.inputDynamicTextbox(driver, "0988555777", "BillingNewAddress_PhoneNumber");

        checkoutPage.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_BILLING_ADDRESS);

        checkoutPage.clickToDynamicInputTypeElement(driver, "shippingoption_0");

        checkoutPage.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_METHOD);

        checkoutPage.clickToDynamicInputTypeElement(driver, "paymentmethod_0");

        checkoutPage.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_METHOD);

        checkoutPage.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_INFO);


    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
