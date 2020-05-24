package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

public class NewAccountPageObject extends AbstractBankPageObject {

    WebDriver driver;

    public NewAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
