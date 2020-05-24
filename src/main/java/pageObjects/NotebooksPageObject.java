package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.AbstractNopCommercePageUI;
import pageUIs.NotebooksPageUI;

public class NotebooksPageObject extends AbstractPages {

    WebDriver driver;

    public NotebooksPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getListItem() {
        waitToElementVisible(driver, AbstractNopCommercePageUI.PRODUCT_TITLE);
        return findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_TITLE).size();

    }

    public boolean isNextIconDisplayed() {
        waitToElementVisible(driver, NotebooksPageUI.NEXT_PAGE_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.NEXT_PAGE_ICON);
    }

    public boolean isPreviousIconDisplayed() {
        waitToElementVisible(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
    }

    public void clickNextIcon() {
        waitToElementClickable(driver, NotebooksPageUI.NEXT_PAGE_ICON);
        clickToElement(driver, NotebooksPageUI.NEXT_PAGE_ICON);
    }

    public void clickPreviousIcon() {
        waitToElementClickable(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
        clickToElement(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
    }

    public void clickToDynamicNumberPage(String numberPage) {
        waitToElementClickable(driver, NotebooksPageUI.DYNAMIC_CURRENT_PAGE, numberPage);
        clickToElement(driver, NotebooksPageUI.DYNAMIC_CURRENT_PAGE, numberPage);
    }

    public boolean isPaginationLinkDisplayed() {
        return isElementDisplayed(driver, NotebooksPageUI.PAGINATION_LINK);
    }
}
