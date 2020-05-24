package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    long longTimeOut = 15;
    Actions action;
    WebElement element;
    By byXpath;
    WebDriverWait waitExplicit;
    private WebDriver driver;
    private Select select;

    public AbstractPage() {

    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPage(WebDriverWait waitExplicit) {

    }

    public void openUrl(String urlValue) {
        driver.get(urlValue);
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public void back() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendKeyToAlert(String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public List<WebElement> findElementsByXpath(String locator) {
        return driver.findElements(byXpathLocator(locator));

    }

    public void clickToElement(String locator) {
        findElementByXpath(locator).click();
    }

    public void sendKeyToElement(String locator, String value) {
        driver.findElement(byXpathLocator(locator)).sendKeys(value);
    }

    public WebElement findElementByXpath(String locator) {
        return driver.findElement(byXpathLocator(locator));
    }

    public int countElementNumber(String locator) {
        return findElementsByXpath(locator).size();
    }

    public String getAttributeElement(String locator, String attributeName) {
        return findElementByXpath(locator).getAttribute(attributeName);
    }

    public boolean isElementDisplayed(String locator) {
        return findElementByXpath(locator).isDisplayed();
    }

    public boolean isControlEnabled(String locator) {
        return findElementByXpath(locator).isEnabled();
    }

    public void hoverMouseToElement(String locator) {
        action = new Actions(driver);
        element = findElementByXpath(locator);
        action.moveToElement(element).perform();
    }

    public void doubleClickToElement(String locator) {
        action = new Actions(driver);
        element = findElementByXpath(locator);
    }

    public By byXpathLocator(String locator) {
        return byXpath = By.xpath(locator);
    }

    public void waitToElementDisplayed(String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
    }

    public void waitToElementClickable(String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    // Click into button element
    public void clickIntoButton(String locator) {
        findElementByXpath(locator).click();
    }

    public void clickIntoLink(String locator) {
        findElementByXpath(locator).click();
    }

    public void clickIntoCheckbox(String locator) {
        findElementByXpath(locator).click();
    }

    public void clickIntoRadioButton(String locator) {
        findElementByXpath(locator).click();
    }

    public void clickIntoRadionButton(String locator) {
        findElementByXpath(locator).click();
    }

    public void selectItemInDropdown(String locator, String valueItem) {
        element = findElementByXpath(locator);
        select = new Select(element);
        select.selectByVisibleText(valueItem);
    }

    public String getTextElement(String locator) {
        return findElementByXpath(locator).getText();
    }

    public void scrollToBottonPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void clearData(String locator) {
        findElementByXpath(locator).clear();
    }

}
