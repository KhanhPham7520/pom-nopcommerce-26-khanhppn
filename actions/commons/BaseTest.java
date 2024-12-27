package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {

    protected void clickToElement(WebDriver driver, By by){
        driver.findElement(by).click();
    }

    protected void clickToElement(WebDriver driver, String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    protected String getElementText(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }
}
