package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class FundTransferPageObject extends AbstractPages {

    private final WebDriver driver;

    public FundTransferPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
