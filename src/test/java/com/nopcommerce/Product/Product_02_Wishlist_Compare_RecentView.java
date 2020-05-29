package com.nopcommerce.Product;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;

public class Product_02_Wishlist_Compare_RecentView extends AbstractTest {

    WebDriver driver;
    ShoppingCartPageObject shoppingCartPage;
    HeaderPageObject headerPage;
    FooterPageObject footerPage;
    CompareProductPageObject compareProductPage;
    RecentViewProductPageObject recentViewProductPage;
    String productName = "Apple MacBook Pro 13-inch";
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;
    private WishListPageObject wishlistPage;

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
        productPage = PageGeneratorManager.getProductPageObject(driver);
        wishlistPage = PageGeneratorManager.getWishListPage(driver);
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        headerPage = PageGeneratorManager.getHeaderPage(driver);
        compareProductPage = PageGeneratorManager.getCompareProductPage(driver);
        footerPage = PageGeneratorManager.getFooterPage(driver);
        recentViewProductPage = PageGeneratorManager.getRecentViewProductPage(driver);

        loginPage = homePage.clickToLoginLink();
        loginPage.inputCorrectEmail();
        loginPage.inputCorrectPassword();
        homePage = loginPage.clickToLoginButton();
        productPage = homePage.clickToProductLink(productName);
    }

    @Test
    public void TC_01_Add_To_Wishlist() {

        productPage.clickAddToWishList();

        verifyTrue(productPage.isProductAddedWishlistSuccessful());

        wishlistPage = productPage.clickToWishlistNotificationLink();

        wishlistPage.clickToWishListURL();

        verifyTrue(wishlistPage.isHeaderWishlistDisplayed());
    }

    @Test
    public void TC_02_Add_Product_To_Cart_From_Wishlist_Page() {
        wishlistPage.clickCheckBoxAddToCart();

        shoppingCartPage = wishlistPage.clickAddToCartButton();

        verifyTrue(shoppingCartPage.isProductNameDisplayedInCart(productName));

        wishlistPage = headerPage.clickToWishListLink();

        verifyTrue(wishlistPage.isInfoProductNoDisplayed(productName));
    }

    @Test
    public void TC_03_Remove_Product_In_Wishlish_Page() {

        wishlistPage = headerPage.clickToWishListLink();

        wishlistPage.clickToRemoveProductCheckbox(productName);

        wishlistPage.clickToUpdateWishListButton();

        verifyTrue(wishlistPage.isInfoProductNoDisplayed(productName));

        verifyTrue(wishlistPage.isEmptyWishListDisplayed());
    }

    @Test
    public void TC_04_Add_Product_To_Compare() {
        String productCompareFirst = "Build your own computer";
        String productCompareSecond = "Apple MacBook Pro 13-inch";

        homePage = headerPage.clickToHomeLinkImage();

        homePage.clickAddToCompareList(driver, productCompareFirst, "Add to compare list");

        verifyTrue(homePage.isAddToComparisonSuccess());

        homePage.clickAddToCompareList(driver, productCompareSecond, "Add to compare list");

        verifyTrue(homePage.isAddToComparisonSuccess());

        compareProductPage = footerPage.clickToCompareProductListLink();

        verifyTrue(compareProductPage.isProductNameDisplayed(productCompareFirst));


    }

    @Test
    public void TC_05_Recently_View_Product() {
        String thirdProduct = "Apple MacBook Pro 13-inch";
        String forthProduct = "Portable Sound Speakers";
        String fifthProduct = "adidas Consortium Campus 80s Running Shoes";

        homePage = productPage.openHomePage(driver);

        homePage.clickToMenuLink("Computers");

        homePage.clickToSubCatItem("Software");

        productPage = homePage.clickToProductLink("Windows 8 Pro");

        homePage = productPage.openHomePage(driver);

        homePage.clickToMenuLink("Electronics");

        homePage.clickToSubCatItem("Cell phones");

        productPage = homePage.clickToProductLink("Nokia Lumia 1020");

        homePage = productPage.openHomePage(driver);

        homePage.clickToMenuLink("Computers");

        homePage.clickToSubCatItem("Notebooks");

        productPage = homePage.clickToProductLink(thirdProduct);

        String productThree = productPage.getProductName(thirdProduct);

        homePage = headerPage.openHomePage(driver);

        homePage.clickToMenuLink("Electronics");

        homePage.clickToSubCatItem("Others");

        productPage = homePage.clickToProductLink(forthProduct);

        String productFourth = productPage.getProductName(forthProduct);

        homePage = productPage.openHomePage(driver);

        homePage.clickToMenuLink("Apparel");

        homePage.clickToSubCatItem("Shoes");

        productPage = homePage.clickToProductLink(fifthProduct);

        String productFifth = productPage.getProductName(fifthProduct);

        homePage = productPage.openHomePage(driver);

        recentViewProductPage = footerPage.clickToRecentViewProductLink();

        verifyEquals(productThree, thirdProduct);

        verifyEquals(productFourth, forthProduct);

        verifyEquals(productFifth, fifthProduct);

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }

}
