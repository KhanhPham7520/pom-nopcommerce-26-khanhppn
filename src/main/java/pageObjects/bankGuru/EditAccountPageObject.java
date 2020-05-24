package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class EditAccountPageObject extends AbstractPages {

    private final WebDriver driver;

    public EditAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
