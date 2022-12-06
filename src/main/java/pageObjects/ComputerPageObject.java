package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.ComputerPageUI;

public class ComputerPageObject extends AbstractPages {

    private final WebDriver driver;

    public ComputerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public DesktopsPageObject clickIntoDesktopLink() {
        waitToElementClickable(driver, ComputerPageUI.DESKTOP_LINK_CATEGORIES);
        findElementByXpath(driver, ComputerPageUI.DESKTOP_LINK_CATEGORIES).click();
        return new DesktopsPageObject(driver);
    }

}
