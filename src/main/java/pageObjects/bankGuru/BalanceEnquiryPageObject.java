package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class BalanceEnquiryPageObject extends AbstractPages {

    private final WebDriver driver;

    public BalanceEnquiryPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
