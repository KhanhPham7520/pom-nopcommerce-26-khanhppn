package pageObjects.bankGuru;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPageObject extends AbstractPages {

    private final WebDriver driver;

    public DeleteCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
