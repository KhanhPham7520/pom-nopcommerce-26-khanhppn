package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.ProductPageUI;

public class DesktopsPageObject extends AbstractPages {

    WebDriver driver;

    public DesktopsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ReviewPageObject clickAddToReview() {
        waitToElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW);
        clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW);
        return new ReviewPageObject(driver);
    }

    public void clickIntoDynamicProductLink(String productName) {
        waitToElementClickable(driver, "//h2[@class='product-title']//a[contains(text(),'" + productName + "')]");
        clickToElement(driver, "//h2[@class='product-title']//a[contains(text(),'" + productName + "')]");
    }

    public ProductPageObject clickIntoProductLink(String productName) {
        waitToElementClickable(driver, "//h2[@class='product-title']//a[contains(text(),'" + productName + "')]");
        clickToElement(driver, "//h2[@class='product-title']//a[contains(text(),'" + productName + "')]");
        return new ProductPageObject(driver);
    }

}
