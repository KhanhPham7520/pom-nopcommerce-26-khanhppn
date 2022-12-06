package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.SearchPageUI;

public class SearchPageObject extends AbstractPages {

    private final WebDriver driver;
    Select select;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputKeyword(String searchValue) {
        clearExistedData(driver, SearchPageUI.INPUT_KEYWORD_TEXTBOX);
        findElementByXpath(driver, SearchPageUI.INPUT_KEYWORD_TEXTBOX).sendKeys(searchValue);
    }

    public void clickSearchButton() {
        findElementByXpath(driver, SearchPageUI.SEARCH_BUTTON).click();
    }

    public String isProduct_First_Displayed() {
        return findElementByXpath(driver, SearchPageUI.LENOVO_SEARCH_RESULT_PRODUCT_FIRST).getText();
    }

    public String isProduct_Second_Displayed() {
        return findElementByXpath(driver, SearchPageUI.LENOVO_SEARCH_RESULT_PRODUCT_SECOND).getText();
    }

    // In Progress for refactoring code
    public void isExistedProductForSearch(String searchProductValue, String searchResultProductValue) {
        searchProductValue = findElementByXpath(driver, SearchPageUI.INPUT_KEYWORD_TEXTBOX).getAttribute("value");

    }

    public String display_Apple_Product() {
        return findElementByXpath(driver, SearchPageUI.APPLE_MACBOOK_PRO_13_INCH_PRODUCT).getText();
    }

    public void checkAdvanceSearchCheckbox() {
        boolean checkAdvanceCheckbox = findElementByXpath(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX).isSelected();
        if (!checkAdvanceCheckbox) {
            findElementByXpath(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX).click();
        }
    }

    public void selectCategory(String selectCategoryValue) {
        select = new Select(findElementByXpath(driver, SearchPageUI.CATEGORY_DROPDOWN));
        select.selectByVisibleText(selectCategoryValue);
    }

    public void uncheckAutoSearchSubCat() {
        findElementByXpath(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
    }

    public void checkAutoSearchSubCatCheckbox() {
        boolean checkAutoSearchCheckbox = findElementByXpath(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CAT_CHECKBOX).isSelected();
        if (!checkAutoSearchCheckbox) {
            findElementByXpath(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CAT_CHECKBOX).click();
        }
    }

    public void selectedManufacturer(String selectManuValue) {
        select = new Select(findElementByXpath(driver, SearchPageUI.MANUFACTURER_DROPDOWN));
        select.selectByVisibleText(selectManuValue);
    }

    public void inputPriceFrom(String priceFromValue) {
        waitToElementVisible(driver, SearchPageUI.PRICE_FROM_TEXTBOX);
        clearExistedData(driver, SearchPageUI.PRICE_FROM_TEXTBOX);
        findElementByXpath(driver, SearchPageUI.PRICE_FROM_TEXTBOX).sendKeys(priceFromValue);
    }

    public void inputPriceTo(String priceToValue) {
        waitToElementVisible(driver, SearchPageUI.PRICE_TO_TEXTBOX);
        clearExistedData(driver, SearchPageUI.PRICE_TO_TEXTBOX);
        findElementByXpath(driver, SearchPageUI.PRICE_TO_TEXTBOX).sendKeys(priceToValue);
    }

    public boolean notMatchedFoundProduct_Displayed() {
        // TODO Auto-generated method stub
        return false;
    }

    public String displayMessageWarning() {
        waitToElementVisible(driver, SearchPageUI.MESSAGE_WARNING);
        return findElementByXpath(driver, SearchPageUI.MESSAGE_WARNING).getText();
    }

    public String displayMessageNoResult() {
        waitToElementVisible(driver, SearchPageUI.MESSAGE_NO_RESULT);
        return findElementByXpath(driver, SearchPageUI.MESSAGE_NO_RESULT).getText();
    }

}
