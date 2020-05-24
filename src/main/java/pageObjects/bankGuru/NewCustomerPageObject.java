package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends AbstractBankPageObject {

    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
