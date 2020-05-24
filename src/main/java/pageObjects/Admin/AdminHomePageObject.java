package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class AdminHomePageObject extends AbstractPages {
    WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
