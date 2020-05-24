package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.AbstractNopCommercePageUI;

public class FooterPageObject extends AbstractPages {
    WebDriver driver;

    public FooterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CompareProductPageObject clickToCompareProductListLink() {
        waitToElementClickable(driver, AbstractNopCommercePageUI.FOOTER_COMPARE_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_COMPARE_LINK);
        return new CompareProductPageObject(driver);
    }

    public RecentViewProductPageObject clickToRecentViewProductLink() {
        waitToElementClickable(driver, AbstractNopCommercePageUI.FOOTER_RECENT_VIEW_PRODUCT_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_RECENT_VIEW_PRODUCT_LINK);
        return new RecentViewProductPageObject(driver);
    }

    public SearchPageObject clickToSearchLink() {
        waitToElementClickable(driver, AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);
        return new SearchPageObject(driver);
    }

}
