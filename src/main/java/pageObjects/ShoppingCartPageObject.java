package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPages {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEmptyProductItemInWishList() {
        waitToElementVisible(driver, ShoppingCartPageUI.EMPTY_PRODUCT_WISHLIST);
        return isElementDisplayed(driver, ShoppingCartPageUI.EMPTY_PRODUCT_WISHLIST);
    }

    public boolean isProductNameDisplayedInCart(String productName) {
        waitToElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME, productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME, productName);
    }

    public void clickToButton(String buttonValue) {
        waitToElementClickable(driver, ShoppingCartPageUI.BUTTON, buttonValue);
        clickToElement(driver, ShoppingCartPageUI.BUTTON, buttonValue);
    }

    public String getProductInfo() {
        waitToElementPresence(driver, ShoppingCartPageUI.INFO_PRODUCT_IN_CART);
        return getTextElement(driver, ShoppingCartPageUI.INFO_PRODUCT_IN_CART);
    }

    public void clickToEditItemLink() {
        waitToElementClickable(driver, ShoppingCartPageUI.EDIT_ITEM_LINK);
        clickToElement(driver, ShoppingCartPageUI.EDIT_ITEM_LINK);
    }

    public String getProductPriceResultTable() {
        waitToElementVisible(driver, ShoppingCartPageUI.PRICE_UNIT_PRICE_TABLE);
        return getTextElement(driver, ShoppingCartPageUI.PRICE_UNIT_PRICE_TABLE);
    }

    public String getProductTotalTable() {
        waitToElementVisible(driver, ShoppingCartPageUI.PRICE_TOTAL_TABLE);
        return getTextElement(driver, ShoppingCartPageUI.PRICE_TOTAL_TABLE);
    }

    public void clickToRemoveCheckbox() {
        waitToElementClickable(driver, ShoppingCartPageUI.REMOVE_CHECKBOX);
        clickToElement(driver, ShoppingCartPageUI.REMOVE_CHECKBOX);
    }

    public String getEmptyShoppingCartMsg() {
        waitToElementVisible(driver, ShoppingCartPageUI.SHOPPING_CART_EMPTY);
        return getTextElement(driver, ShoppingCartPageUI.SHOPPING_CART_EMPTY);
    }

    public void inputToQuantityTextbox(String inputValue){
        waitToElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
        clearExistedData(driver,ShoppingCartPageUI.QUANTITY_TEXTBOX);
        sendKeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, inputValue);
    }


    public CheckOutPageObject clickIntoCheckoutButton(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
        return new CheckOutPageObject(driver);
    }
}
