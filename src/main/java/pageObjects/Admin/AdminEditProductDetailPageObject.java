package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.Admin.AdminEditProductPageUI;

public class AdminEditProductDetailPageObject extends AbstractPages {

    WebDriver driver;

    public AdminEditProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        waitToElementVisible(driver, AdminEditProductPageUI.PRODUCT_NAME_TEXTBOX);
        return getAttributeElement(driver, AdminEditProductPageUI.PRODUCT_NAME_TEXTBOX, "value");
    }
}
