package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class CheckOutPageObject extends AbstractPages {
    WebDriver driver;

    public CheckOutPageObject(WebDriver driver){
        this.driver = driver;
    }
}
