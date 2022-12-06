package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.Admin.AdminSidebarPageUI;

public class AdminSidebarPageObject extends AbstractPages {

    WebDriver driver;

    public AdminSidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminProductPageObject clickToProductLink() {
        waitToElementClickable(driver, AdminSidebarPageUI.PRODUCTS_SUB_ITEM_LINK);
        clickToElement(driver, AdminSidebarPageUI.PRODUCTS_SUB_ITEM_LINK);
        return new AdminProductPageObject(driver);
    }

    public void clickToCatalogLink() {
        waitToElementClickable(driver, AdminSidebarPageUI.CATALOG_LINK);
        clickToElement(driver, AdminSidebarPageUI.CATALOG_LINK);
    }

    public void clickCustomerMenuLink() {
        waitToElementClickable(driver, AdminSidebarPageUI.CUSTOMERS_DROPDOWN_LINK);
        clickToElement(driver, AdminSidebarPageUI.CUSTOMERS_DROPDOWN_LINK);
    }

    public AdminSearchCustomerPageObject clickToCustomersLink() {
        waitToElementClickable(driver, AdminSidebarPageUI.CUSTOMERS_DROPDOWN_ITEM);
        clickToElement(driver, AdminSidebarPageUI.CUSTOMERS_DROPDOWN_ITEM);
        return new AdminSearchCustomerPageObject(driver);
    }

}
