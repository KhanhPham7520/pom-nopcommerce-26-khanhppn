package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.CompareProductPageUI;

public class CompareProductPageObject extends AbstractPages {
    WebDriver driver;

    public CompareProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplayed(String productName) {
        waitToElementVisible(driver, CompareProductPageUI.PRODUCT_NAME, productName);
        return isDisplayed(driver, CompareProductPageUI.PRODUCT_NAME, productName);
    }

    public boolean isProductPriceDisplayed(String productPrice) {
        waitToElementVisible(driver, CompareProductPageUI.PRODUCT_PRICE, productPrice);
        return isDisplayed(driver, CompareProductPageUI.PRODUCT_PRICE, productPrice);
    }

}
