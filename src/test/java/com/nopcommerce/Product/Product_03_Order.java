package com.nopcommerce.Product;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.ProductData;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.CheckOutPO;
import pageObjects.DesktopsPageObject;
import pageObjects.HeaderPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.ProductPageObject;
import pageObjects.ShoppingCartPageObject;
import pageUIs.CheckOutPageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.ProductPageUI;
import pageUIs.ShoppingCartPageUI;

public class Product_03_Order extends AbstractTest {

    ShoppingCartPageObject shoppingCartPage;
    // Data Test
    String productName = "Build your own computer";
    String processorName = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
    String ramName = "8GB [+$60.00]";
    String hddName = "400 GB [+$100.00]";
    String osName = "Vista Premium [+$60.00]";
    String softwareNameFirst = "Microsoft Office [+$50.00]";
    String softwareNameSecond = "Acrobat Reader [+$10.00]";
    String softwareNameThird = "Total Commander [+$5.00]";
    String productPrice = "$1,500.00";
    // Edit product info
    String editProcessorName = "2.2 GHz Intel Pentium Dual-Core E2200";
    String editRamName = "4GB [+$20.00]";
    String editHddName = "320 GB";
    String editOsName = "Vista Home";

	String editProductQuantity = "2";
    String editProductPriceResult = "$1,320.00";
    String editPriceCart = "$1,320.00";
    String editPriceTotal = "$2,640.00";
    String emptyShoppingCartMsg = "Your Shopping Cart is empty!";

    int priceProduct;
    int quantityProduct;

    int totalPrice = priceProduct * quantityProduct;

    // Billing info
    String billingFirstName = "Auto";
    String billingLastName = "Test";
    String billingEmail = "johnwick_111222@gmail.com";
    String billingCountry = "Australia";
    String billingCity = "Melbourne";
    String billingAddressOne = "123 Melbourne";
    String billingZipPostalCode = "999777";
    String billingPhone = "0988555777";
    String billingCheckOrMoneyOrderPaymentMethod = "Check / Money Order";
    String billingCreditCardPaymentMethod = "Credit Card";

    // Shipping info
    String shippingFirstName = "Auto123";
    String shippingLastName = "Test123";
    String shippingEmail = "johnwick_123456@gmail.com";
    String shippingCountry = "Yemen";
    String shippingCity = "Akaqui";
    String shippingAddressOne = "1234 Akaqui St";
    String shippingZipPostalCode = "888222";
    String shippingPhone = "0912458213";
    String shippingPaymentMethod = "Ground";

    String phoneLabel = "Phone: ";
    String emailLabel = "Email: ";

    String orderNumber;

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;
    private HeaderPageObject headerPage;
    private DesktopsPageObject desktopsPage;
    private CheckOutPO checkOutPO;
    private MyAccountPageObject myAccountPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
        productPage = PageGeneratorManager.getProductPageObject(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        headerPage = PageGeneratorManager.getHeaderPage(driver);
        desktopsPage = PageGeneratorManager.getDesktopPage(driver);
        checkOutPO = PageGeneratorManager.getCheckOutPage(driver);
        myAccountPage = PageGeneratorManager.getMyAccountPageObject(driver);

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

        verifyEquals(productPage.getProductPrice(), productPrice);

        productPage.clickAddToCart();

        shoppingCartPage = productPage.clickToAddToCarLinkSuccessNotificationBar(driver);

        verifyEquals(shoppingCartPage.getTextElement(driver, ProductPageUI.PRODUCT_NAME_AFTER_ADD_TO_CART_SUCCESS, productName), productName);
    }

    @Test
    public void TC_02_Edit_Product_In_Shopping_Cart() {

        shoppingCartPage = headerPage.clickToShoppingCartLink();

        shoppingCartPage.clickToEditItemLink();

        productPage.selectProcessor(editProcessorName);

        productPage.selectRAM(editRamName);

        productPage.selectHDD(editHddName);

        productPage.selectOS(editOsName);

        productPage.unselectSoftwareForEditProductInfo(softwareNameSecond);

        productPage.unselectSoftwareForEditProductInfo(softwareNameThird);

        productPage.inputQuantityProduct(editProductQuantity);

        verifyEquals(productPage.getProductPrice(), editProductPriceResult);

        productPage.clickIntoButton(driver, ProductPageUI.DYNAMIC_INPUT_TYPE, "add-to-cart-button-1");

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

        desktopsPage = headerPage.clickToTextOfHeaderMenu("Computers", "Desktops");

        productPage = desktopsPage.clickIntoProductLink("Lenovo IdeaCentre 600 All-in-One PC");

        productPage.clickAddToCart();

        shoppingCartPage = productPage.clickToShoppingCart(driver);

        shoppingCartPage.inputToQuantityTextbox("5");

        shoppingCartPage.clickToButton("Update shopping cart");

        verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.PRICE_TOTAL_TABLE), "$2,500.00");
    }

    @Test
    public void TC_05_Checkout_Order_Payment_Method_By_Cheque() {

        desktopsPage = headerPage.clickToTextOfHeaderMenu("Computers", "Notebooks");

        productPage = desktopsPage.clickIntoProductLink("Apple MacBook Pro 13-inch");

        productPage.clickAddToCart();

        shoppingCartPage = productPage.clickToShoppingCart(driver);

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.ESTIMATING_SHIPPING_BUTTON);

        shoppingCartPage.switchToPopUpModal(driver);

        shoppingCartPage.selectDropdownByVisibleText(driver, ShoppingCartPageUI.SELECT_COUNTRY_ESTIMATING_SHIPPING, "Viet Nam");

        shoppingCartPage.sendKeyToElement(driver, ShoppingCartPageUI.ZIP_POSTAL_CODE_ESTIMATING_SHIPPING, "550000");

        shoppingCartPage.waitToShippingOptionDisplayed(driver);

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.APPLY_BUTTON_ESTIMATING_SHIPPING);

        shoppingCartPage.clickIntoCheckbox(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);

        checkOutPO = shoppingCartPage.clickIntoCheckoutButton(driver);

        checkOutPO.clickIntoCheckbox(driver, CheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);

        checkOutPO.selectNewBillingAddress(driver, "New Address");

        checkOutPO.inputToTextbox(driver, billingFirstName, "BillingNewAddress_FirstName");

        checkOutPO.inputToTextbox(driver, billingLastName, "BillingNewAddress_LastName");

        checkOutPO.inputToTextbox(driver, billingEmail, "BillingNewAddress_Email");

        checkOutPO.selectItemInDropdown(driver, billingCountry, "BillingNewAddress_CountryId");

        checkOutPO.inputToTextbox(driver, billingCity, "BillingNewAddress_City");

        checkOutPO.inputToTextbox(driver, billingAddressOne, "BillingNewAddress_Address1");

        checkOutPO.inputToTextbox(driver, billingZipPostalCode, "BillingNewAddress_ZipPostalCode");

        checkOutPO.inputToTextbox(driver, billingPhone, "BillingNewAddress_PhoneNumber");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_BILLING_ADDRESS);

        checkOutPO.selectItemInDropdown(driver, "New Address", "shipping-address-select");

        checkOutPO.inputToTextbox(driver, shippingFirstName, "ShippingNewAddress_FirstName");

        checkOutPO.inputToTextbox(driver, shippingLastName, "ShippingNewAddress_LastName");

        checkOutPO.inputToTextbox(driver, shippingEmail, "ShippingNewAddress_Email");

        checkOutPO.selectItemInDropdown(driver, shippingCountry, "ShippingNewAddress_CountryId");

        checkOutPO.inputToTextbox(driver, shippingCity, "ShippingNewAddress_City");

        checkOutPO.inputToTextbox(driver, shippingAddressOne, "ShippingNewAddress_Address1");

        checkOutPO.inputToTextbox(driver, shippingZipPostalCode, "ShippingNewAddress_ZipPostalCode");

        checkOutPO.inputToTextbox(driver, shippingPhone, "ShippingNewAddress_PhoneNumber");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_ADDRESS);

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_METHOD);

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_METHOD);

        verifyEquals(checkOutPO.getDynamicTextOfCheckoutPage(driver, "NOP SOLUTIONS"), "NOP SOLUTIONS");

        verifyEquals(checkOutPO.getDynamicTextOfCheckoutPage(driver, "your address here,"), "your address here,");

        verifyEquals(checkOutPO.getDynamicTextOfCheckoutPage(driver, "New York, NY 10001"), "New York, NY 10001");

        verifyEquals(checkOutPO.getDynamicTextOfCheckoutPage(driver, "USA"), "USA");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_INFO);

        // verify Billing Info of Confirm Order
        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "name"), billingFirstName.concat(" ").concat(billingLastName));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "email"), emailLabel.concat(billingEmail));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "phone"), phoneLabel.concat(billingPhone));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "address1"), billingAddressOne);

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "city-state-zip"), billingCity.concat(",").concat(billingZipPostalCode));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "country"), billingCountry);

        verifyEquals(checkOutPO.getTextConfirmBillingPaymentMethod(driver, "Check / Money Order").trim(), billingCheckOrMoneyOrderPaymentMethod.trim());

        // verify Shipping Info of Confirm Order
        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "name"), shippingFirstName.concat(" ").concat(shippingLastName));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "email"), emailLabel.concat(shippingEmail));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "phone"), phoneLabel.concat(shippingPhone));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "address1"), shippingAddressOne);

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "city-state-zip"), shippingCity.concat(",").concat(shippingZipPostalCode));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "country"), shippingCountry);

        verifyEquals(checkOutPO.getTextForConfirmShippingMethod(driver, "Ground").trim(), shippingPaymentMethod.trim());

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONFIRM_ORDER_BUTTON);

        verifyEquals(checkOutPO.getTextElement(driver, CheckOutPageUI.THANK_YOU_ORDER_COMPLETE_MESSAGE), "Thank you");

        verifyEquals(checkOutPO.getTextElement(driver, CheckOutPageUI.ORDER_SUCESSFULLY_PROCESSED_MESSAGE), "Your order has been successfully processed!");

        ProductData.orderProduct.orderNumber = checkOutPO.getOrderNumberFromSuccessMessage();

        verifyEquals(checkOutPO.getTextElement(driver, CheckOutPageUI.ORDER_NUMBER).trim(), ProductData.orderProduct.orderNumber);

        homePage = checkOutPO.clickIntoCompleteOrderButton();

        myAccountPage = homePage.clickToHeaderMyAccountLink();

        myAccountPage.clickIntoLink(driver, MyAccountPageUI.ORDER_LINK_NAVIGATION_BAR);

        verifyEquals(myAccountPage.getOrderNumberFromMyAccountPage(), ProductData.orderProduct.orderNumber);

        myAccountPage.clickIntoButton(driver, MyAccountPageUI.DETAILS_ORDER_BUTTON);

        verifyEquals(myAccountPage.getTextElement(driver, MyAccountPageUI.ORDER_NUMBER_IN_ORDER_INFORMATION_PAGE), ProductData.orderProduct.getOrderNumber());

        // get current datename from system

    }

    @Test
    public void TC_06_Checkout_Order_Payment_Method_By_Card() {

        desktopsPage = headerPage.clickToTextOfHeaderMenu("Computers", "Notebooks");

        productPage = desktopsPage.clickIntoProductLink("Apple MacBook Pro 13-inch");

        productPage.clickAddToCart();

        shoppingCartPage = productPage.clickToShoppingCart(driver);

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.ESTIMATING_SHIPPING_BUTTON);

        shoppingCartPage.switchToPopUpModal(driver);

        shoppingCartPage.selectDropdownByVisibleText(driver, ShoppingCartPageUI.SELECT_COUNTRY_ESTIMATING_SHIPPING, "Viet Nam");

        shoppingCartPage.sendKeyToElement(driver, ShoppingCartPageUI.ZIP_POSTAL_CODE_ESTIMATING_SHIPPING, "550000");

        shoppingCartPage.waitToShippingOptionDisplayed(driver);

        shoppingCartPage.clickIntoButton(driver, ShoppingCartPageUI.APPLY_BUTTON_ESTIMATING_SHIPPING);

        shoppingCartPage.clickIntoCheckbox(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);

        checkOutPO = shoppingCartPage.clickIntoCheckoutButton(driver);

        checkOutPO.clickIntoCheckbox(driver, CheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);

        checkOutPO.selectNewBillingAddress(driver, "New Address");

        checkOutPO.inputToTextbox(driver, billingFirstName, "BillingNewAddress_FirstName");

        checkOutPO.inputToTextbox(driver, billingLastName, "BillingNewAddress_LastName");

        checkOutPO.inputToTextbox(driver, billingEmail, "BillingNewAddress_Email");

        checkOutPO.selectItemInDropdown(driver, billingCountry, "BillingNewAddress_CountryId");

        checkOutPO.inputToTextbox(driver, billingCity, "BillingNewAddress_City");

        checkOutPO.inputToTextbox(driver, billingAddressOne, "BillingNewAddress_Address1");

        checkOutPO.inputToTextbox(driver, billingZipPostalCode, "BillingNewAddress_ZipPostalCode");

        checkOutPO.inputToTextbox(driver, billingPhone, "BillingNewAddress_PhoneNumber");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_BILLING_ADDRESS);

        checkOutPO.selectItemInDropdown(driver, "New Address", "shipping-address-select");

        checkOutPO.inputToTextbox(driver, shippingFirstName, "ShippingNewAddress_FirstName");

        checkOutPO.inputToTextbox(driver, shippingLastName, "ShippingNewAddress_LastName");

        checkOutPO.inputToTextbox(driver, shippingEmail, "ShippingNewAddress_Email");

        checkOutPO.selectItemInDropdown(driver, shippingCountry, "ShippingNewAddress_CountryId");

        checkOutPO.inputToTextbox(driver, shippingCity, "ShippingNewAddress_City");

        checkOutPO.inputToTextbox(driver, shippingAddressOne, "ShippingNewAddress_Address1");

        checkOutPO.inputToTextbox(driver, shippingZipPostalCode, "ShippingNewAddress_ZipPostalCode");

        checkOutPO.inputToTextbox(driver, shippingPhone, "ShippingNewAddress_PhoneNumber");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_ADDRESS);

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_METHOD);

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CREDIT_CARD_PAYMENT_METHOD_RADIO);

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_METHOD);

        checkOutPO.selectItemInDropdown(driver, "Visa", "CreditCardType");

        checkOutPO.inputToTextbox(driver, "Pham Phan Nhat Khanh", "CardholderName");

        checkOutPO.inputToTextbox(driver, "4539754630929804", "CardNumber");

        checkOutPO.selectItemInDropdown(driver, "03", "ExpireMonth");

        checkOutPO.selectItemInDropdown(driver, "2029", "ExpireYear");

        checkOutPO.inputToTextbox(driver, "1234", "CardCode");

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONTINUE_AFTER_INPUT_CARD);

        // verify Billing Info of Confirm Order
        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "name"), billingFirstName.concat(" ").concat(billingLastName));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "email"), emailLabel.concat(billingEmail));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "phone"), phoneLabel.concat(billingPhone));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "address1"), billingAddressOne);

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "city-state-zip"), billingCity.concat(",").concat(billingZipPostalCode));

        verifyEquals(checkOutPO.getTextForBillingInfoConfirmOrderPage(driver, "country"), billingCountry);

        verifyEquals(checkOutPO.getTextConfirmBillingPaymentMethod(driver, "Credit Card"), billingCreditCardPaymentMethod);

        // verify Shipping Info of Confirm Order
        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "name"), shippingFirstName.concat(" ").concat(shippingLastName));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "email"), emailLabel.concat(shippingEmail));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "phone"), phoneLabel.concat(shippingPhone));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "address1"), shippingAddressOne);

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "city-state-zip"), shippingCity.concat(",").concat(shippingZipPostalCode));

        verifyEquals(checkOutPO.getTextForShippingInfoConfirmOrderPage(driver, "country"), shippingCountry);

        verifyEquals(checkOutPO.getTextForConfirmShippingMethod(driver, "Ground").trim(), shippingPaymentMethod.trim());

        checkOutPO.clickIntoButton(driver, CheckOutPageUI.CONFIRM_ORDER_BUTTON);

//		verifyEquals(checkoutPage.getTextElement(driver, CheckOutPageUI.THANK_YOU_ORDER_COMPLETE_MESSAGE), "Thank you");

        verifyEquals(checkOutPO.getTextElement(driver, CheckOutPageUI.ORDER_SUCESSFULLY_PROCESSED_MESSAGE), "Your order has been successfully processed!");

        ProductData.orderProduct.orderNumber = checkOutPO.getOrderNumberFromSuccessMessage();

        verifyEquals(checkOutPO.getTextElement(driver, CheckOutPageUI.ORDER_NUMBER).trim(), ProductData.orderProduct.getOrderNumber());

        homePage = checkOutPO.clickIntoCompleteOrderButton();

        myAccountPage = homePage.clickToHeaderMyAccountLink();

        myAccountPage.clickIntoLink(driver, MyAccountPageUI.ORDER_LINK_NAVIGATION_BAR);

        verifyEquals(myAccountPage.getOrderNumberFromMyAccountPage(), ProductData.orderProduct.orderNumber);

        myAccountPage.clickIntoButton(driver, MyAccountPageUI.DETAILS_ORDER_BUTTON);

        verifyEquals(myAccountPage.getTextElement(driver, MyAccountPageUI.ORDER_NUMBER_IN_ORDER_INFORMATION_PAGE, ProductData.orderProduct.orderNumber), ProductData.orderProduct.getOrderNumber());

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
