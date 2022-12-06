package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.AbstractPageUI;

public class FooterPageObject extends AbstractPages {
    WebDriver driver;

    public FooterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CompareProductPageObject clickToCompareProductListLink() {
        waitToElementClickable(driver, AbstractPageUI.FOOTER_COMPARE_LINK);
        clickToElement(driver, AbstractPageUI.FOOTER_COMPARE_LINK);
        return new CompareProductPageObject(driver);
    }

    public RecentViewProductPageObject clickToRecentViewProductLink() {
        waitToElementClickable(driver, AbstractPageUI.FOOTER_RECENT_VIEW_PRODUCT_LINK);
        clickToElement(driver, AbstractPageUI.FOOTER_RECENT_VIEW_PRODUCT_LINK);
        return new RecentViewProductPageObject(driver);
    }

    public SearchPageObject clickToSearchLink() {
        waitToElementClickable(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
        clickToElement(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
        return new SearchPageObject(driver);
    }

}
