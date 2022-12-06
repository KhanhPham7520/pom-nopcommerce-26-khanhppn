package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.HeaderPageUI;

public class HeaderPageObject extends AbstractPages {
    WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WishListPageObject clickToWishListLink() {
        waitToElementClickable(driver, HeaderPageUI.WISHLIST_LINK);
        clickToElement(driver, HeaderPageUI.WISHLIST_LINK);
        return new WishListPageObject(driver);
    }

    public ShoppingCartPageObject clickToShoppingCartLink() {
        waitToElementClickable(driver, HeaderPageUI.SHOPPING_CART_LINK);
        clickToElement(driver, HeaderPageUI.SHOPPING_CART_LINK);
        return new ShoppingCartPageObject(driver);
    }

    public HomePageObject clickToHomeLinkImage() {
        waitToElementClickable(driver, HeaderPageUI.HOME_IMAGE_LINK);
        clickToElement(driver, HeaderPageUI.HOME_IMAGE_LINK);
        return new HomePageObject(driver);
    }

    public void clickToDynamicTextOfHeaderMenu(String linkName, String... values) {
        waitToElementClickable(driver, HeaderPageUI.LINK_NAME_OF_HEADER_MENU, linkName);
        hoverToElement(driver, HeaderPageUI.LINK_NAME_OF_HEADER_MENU, linkName);
        clickToElement(driver, HeaderPageUI.ITEM_LINK_OF_HEADER_MENU, values);
    }

    public void hoverShoppingCart() {
        waitToElementVisible(driver, HeaderPageUI.SHOPPING_CART_LINK);
        hoverToElement(driver, HeaderPageUI.SHOPPING_CART_LINK);
    }

    public String getProductNameInShoppingCart() {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_NAME_SHOPPING_CART);
        return getTextElement(driver, HeaderPageUI.PRODUCT_NAME_SHOPPING_CART);
    }

    public String getProductProcessorInShoppingCart() {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_PROCESSOR_SHOPPING_CART);
        return getTextElement(driver, HeaderPageUI.PRODUCT_PROCESSOR_SHOPPING_CART);
    }

    public String getProductRAMInShoppingCart() {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_RAM_SHOPPING_CART);
        return getTextElement(driver, HeaderPageUI.PRODUCT_RAM_SHOPPING_CART);
    }

    public String getProductHDDInShoppingCart(String productHDD) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_HDD_SHOPPING_CART, productHDD);
        return getTextElement(driver, HeaderPageUI.PRODUCT_HDD_SHOPPING_CART, productHDD);
    }

    public String getProductOSInShoppingCart(String productOSShoppingCart) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_OS_SHOPPING_CART, productOSShoppingCart);
        return getTextElement(driver, HeaderPageUI.PRODUCT_OS_SHOPPING_CART, productOSShoppingCart);
    }

    public String getProductSoftwareFirstInShoppingCart(String softwareFirst) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_SOFTWARE_FIRST_SHOPPING_CART, softwareFirst);
        return getTextElement(driver, HeaderPageUI.PRODUCT_SOFTWARE_FIRST_SHOPPING_CART, softwareFirst);
    }

    public String getProductSoftwareSecondInShoppingCart(String softwareSecond) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_SOFTWARE_SECOND_SHOPPING_CART, softwareSecond);
        return getTextElement(driver, HeaderPageUI.PRODUCT_SOFTWARE_SECOND_SHOPPING_CART, softwareSecond);
    }

    public String getProductSoftwareThirdInShoppingCart(String softwareThird) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_SOFTWARE_THIRD_SHOPPING_CART, softwareThird);
        return getTextElement(driver, HeaderPageUI.PRODUCT_SOFTWARE_THIRD_SHOPPING_CART, softwareThird);
    }

    public String getProductUnitPriceInShoppingCart(String unitPrice) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_UNIT_PRICE_SHOPPING_CART, unitPrice);
        return getTextElement(driver, HeaderPageUI.PRODUCT_UNIT_PRICE_SHOPPING_CART, unitPrice);
    }

    public String getProductQuantityInShoppingCart(String quantity) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_QUANTITY_SHOPPING_CART, quantity);
        return getTextElement(driver, HeaderPageUI.PRODUCT_QUANTITY_SHOPPING_CART, quantity);
    }

    public String getProductSubtotalInShoppingCart(String subtotal) {
        waitToElementVisible(driver, HeaderPageUI.PRODUCT_SUBTOTAL_SHOPPING_CART, subtotal);
        return getTextElement(driver, HeaderPageUI.PRODUCT_SUBTOTAL_SHOPPING_CART, subtotal);
    }


    public DesktopsPageObject clickToTextOfHeaderMenu(String linkName, String values) {
        waitToElementClickable(driver, HeaderPageUI.LINK_NAME_OF_HEADER_MENU, linkName);
        hoverToElement(driver, HeaderPageUI.LINK_NAME_OF_HEADER_MENU, linkName);
        clickToElement(driver, HeaderPageUI.ITEM_LINK_OF_HEADER_MENU, linkName, values);
        return new DesktopsPageObject(driver);
    }
}
