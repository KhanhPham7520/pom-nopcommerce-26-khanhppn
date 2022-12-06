package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.AbstractPageUI;
import pages.NotebooksPageUI;

public class NotebooksPageObject extends AbstractPages {

    WebDriver driver;

    public NotebooksPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getListItem() {
        waitToElementVisible(driver, AbstractPageUI.PRODUCT_TITLE);
        return findElementsByXpath(driver, AbstractPageUI.PRODUCT_TITLE).size();

    }

    public boolean isNextIconDisplayed() {
        waitToElementVisible(driver, NotebooksPageUI.NEXT_PAGE_ICON);
        return isDisplayed(driver, NotebooksPageUI.NEXT_PAGE_ICON);
    }

    public boolean isPreviousIconDisplayed() {
        waitToElementVisible(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
        return isDisplayed(driver, NotebooksPageUI.PREVIOUS_PAGE_ICON);
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
        return isDisplayed(driver, NotebooksPageUI.PAGINATION_LINK);
    }
}
