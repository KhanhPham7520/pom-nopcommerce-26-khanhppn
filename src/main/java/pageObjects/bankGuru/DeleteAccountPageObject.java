package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPageObject extends AbstractPages {

    private final WebDriver driver;

    public DeleteAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
