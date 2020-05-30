package pageObjects;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.*;

public class HomePageObject extends AbstractPages {
    private final WebDriver driver;

    // khởi tạo element
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject clickToLoginLink() {
        waitToElementVisible(driver, AbstractNopCommercePageUI.HEADER_LOGIN_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.HEADER_LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitToElementVisible(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
    }

    public ComputerPageObject clickToComputerLink() {
        waitToElementClickable(driver, HomePageHeaderMenuUI.COMPUTER_HEADER);
        clickIntoLink(driver, HomePageHeaderMenuUI.COMPUTER_HEADER);
        return PageGeneratorManager.getComputerPageObject(driver);
    }

    public void clickToSearchLinkFooter() {
        findElementByXpath(driver, HomePageUI.SEARCH_LINK_FOOTER).click();

    }

    public ProductPageObject clickToProductLink(String productLink) {
        waitToElementClickable(driver, ProductPageUI.PRODUCT_LINK, productLink);
        clickToElement(driver, ProductPageUI.PRODUCT_LINK, productLink);
        return PageGeneratorManager.getProductPageObject(driver);
    }

    public MyAccountPageObject clickToHeaderMyAccountLink() {
        waitToElementClickable(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
        return new MyAccountPageObject(driver);
    }

    public void clickAddToCompareList(WebDriver driver, String... values) {
        waitToElementClickable(driver, ProductPageUI.DYNAMIC_BUTTON, values);
        clickToElement(driver, ProductPageUI.DYNAMIC_BUTTON, values);
    }

    public boolean isAddToComparisonSuccess() {
        waitToElementVisible(driver, HomePageUI.ADD_TO_COMPARISON_SUCCESS_MSG);
        return isElementDisplayed(driver, HomePageUI.ADD_TO_COMPARISON_SUCCESS_MSG);
    }

    public void clickToSubCatItem(String valueItem) {
        waitToElementClickable(driver, SubCategoryItemPageUI.SUB_CATEGORY_ITEM_LINK, valueItem);
        clickToElement(driver, SubCategoryItemPageUI.SUB_CATEGORY_ITEM_LINK, valueItem);
    }

    public void clickToMenuLink(String linkName) {
        waitToElementClickable(driver, AbstractNopCommercePageUI.LINK_NAME_OF_HEADER_MENU, linkName);
        clickToElement(driver, AbstractNopCommercePageUI.LINK_NAME_OF_HEADER_MENU, linkName);
    }

}
