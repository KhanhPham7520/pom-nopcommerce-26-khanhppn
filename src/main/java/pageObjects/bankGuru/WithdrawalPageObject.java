package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class WithdrawalPageObject extends AbstractPages {

    private final WebDriver driver;

    public WithdrawalPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
