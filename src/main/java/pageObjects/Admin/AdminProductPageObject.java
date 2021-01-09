package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.Admin.AdminProductPageUI;

public class AdminProductPageObject extends AbstractPages {

    WebDriver driver;

    public AdminProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToProductNameTextbox(String productName) {
        waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
        sendKeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    public void clickToSearchButton() {
        waitToElementClickable(driver, AdminProductPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);

    }

    public String verifyProductName(String productName) {
        waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TBL, productName);
        return getTextElement(driver, AdminProductPageUI.PRODUCT_NAME_TBL, productName);
    }

    public String verifyProductSKU() {
        waitToElementVisible(driver, AdminProductPageUI.SKU_TBL);
        return getTextElement(driver, AdminProductPageUI.SKU_TBL);
    }

    public String verifyProductPrice() {
        waitToElementVisible(driver, AdminProductPageUI.PRICE_TBL);
        return getTextElement(driver, AdminProductPageUI.PRICE_TBL);
    }

    public String verifyProductStockQuantity() {
        waitToElementVisible(driver, AdminProductPageUI.STOCK_QUANTITY_TBL);
        return getTextElement(driver, AdminProductPageUI.STOCK_QUANTITY_TBL);
    }

    public String verifyProductType() {
        waitToElementVisible(driver, AdminProductPageUI.PRODUCT_TYPE_TBL);
        return getTextElement(driver, AdminProductPageUI.PRODUCT_TYPE_TBL);
    }

    public boolean isPublished() {
        waitToElementVisible(driver, AdminProductPageUI.IS_PUBLISHED_TBL);
        return isDisplayed(driver, AdminProductPageUI.IS_PUBLISHED_TBL);
    }

    public void selectCategory(String selectValue) {
        waitToElementClickable(driver, AdminProductPageUI.CATEGORY_SELECT);
        select = new Select(findElementByXpath(driver, AdminProductPageUI.CATEGORY_SELECT));

        clickToElement(driver, AdminProductPageUI.CATEGORY_SELECT);
        select.selectByVisibleText(selectValue);
    }

    public void checkSearchSubCategory() {
        waitToElementClickable(driver, AdminProductPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
        clickToElement(driver, AdminProductPageUI.SEARCH_SUB_CATEGORY_CHECKBOX);
    }

    public String verifyNoDataMessage() {
        waitToElementVisible(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
        return getTextElement(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
    }

    public void selectManufacturer(String selectManufacturer) {
        waitToElementClickable(driver, AdminProductPageUI.MANUFACTURER_SELECT);
        select = new Select(findElementByXpath(driver, AdminProductPageUI.MANUFACTURER_SELECT));

        clickToElement(driver, AdminProductPageUI.MANUFACTURER_SELECT);
        select.selectByVisibleText(selectManufacturer);
    }

    public void inputSKUTextbox(String inputSKU) {
        waitToElementVisible(driver, AdminProductPageUI.SKU_TEXTBOX);
        sendKeyToElement(driver, AdminProductPageUI.SKU_TEXTBOX, inputSKU);
    }

    public AdminEditProductDetailPageObject clickGoSKUButton() {
        waitToElementClickable(driver, AdminProductPageUI.GO_SKU_BUTTON);
        clickToElement(driver, AdminProductPageUI.GO_SKU_BUTTON);
        return new AdminEditProductDetailPageObject(driver);
    }
}
