package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.WishListPageUI;

public class WishListPageObject extends AbstractPages {
    WebDriver driver;

    public WishListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToWishListURL() {
        waitToElementClickable(driver, WishListPageUI.WISHLIST_URL);
        clickToElement(driver, WishListPageUI.WISHLIST_URL);
    }

    public boolean isHeaderWishlistDisplayed() {
        waitToElementClickable(driver, WishListPageUI.WISHLIST_HEADER_PAGE);
        return isDisplayed(driver, WishListPageUI.WISHLIST_HEADER_PAGE);
    }

    public void clickCheckBoxAddToCart() {
        waitToElementClickable(driver, WishListPageUI.ADD_TO_CART_CHECKBOX);
        clickToElement(driver, WishListPageUI.ADD_TO_CART_CHECKBOX);
    }

    public ShoppingCartPageObject clickAddToCartButton() {
        waitToElementClickable(driver, WishListPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishListPageUI.ADD_TO_CART_BUTTON);
        return new ShoppingCartPageObject(driver);
    }

    public void clickToRemoveProductCheckbox(String productName) {
        waitToElementClickable(driver, WishListPageUI.REMOVE_PRODUCT_CHECKBOX, productName);
        clickToElement(driver, WishListPageUI.REMOVE_PRODUCT_CHECKBOX, productName);
    }

    public void clickToUpdateWishListButton() {
        waitToElementClickable(driver, WishListPageUI.CLICK_TO_BUTTON, "Update wishlist");
        clickToElement(driver, WishListPageUI.CLICK_TO_BUTTON, "Update wishlist");
    }

    public boolean isEmptyWishListDisplayed() {
        waitToElementVisible(driver, WishListPageUI.WISHLIST_EMPTY_MSG);
        return isDisplayed(driver, WishListPageUI.WISHLIST_EMPTY_MSG);
    }

    public boolean isInfoProductNoDisplayed(String productName) {
        waitToElementInvisible(driver, WishListPageUI.PRODUCT_INFO_ROW, productName);
        return isElementNoDisplayed(driver, WishListPageUI.PRODUCT_INFO_ROW, productName);
    }
}
