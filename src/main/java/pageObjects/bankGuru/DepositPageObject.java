package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class DepositPageObject extends AbstractPages {

    private final WebDriver driver;

    public DepositPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
