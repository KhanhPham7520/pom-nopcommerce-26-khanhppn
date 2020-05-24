package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductPageUI;

public class CompareProductPageObject extends AbstractPages {
    WebDriver driver;

    public CompareProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInfoDisplayed(String productName) {
        // String productPrice;
        waitToElementVisible(driver, CompareProductPageUI.PRODUCT_INFO, productName);
        return isElementDisplayed(driver, CompareProductPageUI.PRODUCT_INFO, productName);
    }

}
