package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    private long LONG_TIMEOUT = 30;

    JavascriptExecutor jsExecutor;

    private List<WebElement> getListWebElement(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public WebElement getWebElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendkeyAlert(WebDriver driver, String valueToSend) {
        driver.switchTo().alert().sendKeys(valueToSend);
    }

    public void waitToAlertPresence(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void switchToWindowById(WebDriver driver, String windowId) {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Loop through all handles
        for (String handle : windowHandles) {
            // If the handle matches the desired window ID, switch to it
            if (handle.equals(windowId)) {
                driver.switchTo().activeElement();
                System.out.println("Switched to window with ID: " + windowId);
                return;
            }
        }
        throw new RuntimeException("Window with ID " + windowId + " not found.");
    }

    public static void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Loop through each window handle
        for (String handle : windowHandles) {
            // Switch to the window
            driver.switchTo().window(handle);

            // Check the title of the current window
            if (driver.getTitle().equals(windowTitle)) {
                System.out.println("Switched to window with title: " + windowTitle);
                return;
            }
        }
        throw new RuntimeException("Window with title '" + windowTitle + "' not found.");
    }

    public static void closeAllWindowsWithoutParent(WebDriver driver, String parentWindowHandle) {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Loop through each window handle
        for (String handle : windowHandles) {
            // Skip the parent window
            if (!handle.equals(parentWindowHandle)) {
                // Switch to the window and close it
                driver.switchTo().window(handle);
                System.out.println("Closing window with handle: " + handle);
                driver.close();
            }
        }
        // Switch back to the parent window
        driver.switchTo().window(parentWindowHandle);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSend){
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(valueToSend);
    }

    public void selectItemDropdown(WebDriver driver, String locator, String textItem){
        new Select((getWebElement(driver,locator))).selectByVisibleText(textItem);
    }

    public String getSelectItemDropdown(WebDriver driver, String locator, String textItem){
        return new Select((getWebElement(driver,locator))).getFirstSelectedOption().getText();
    }

    public void isDropdownMultiple(WebDriver driver, String locator, String textItem){

    }

//    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
//        explicitWait.until(ExpectedConditions.elementToBeClickable(get))
//        getWebElement(driver, parentLocator).click();
//        //sleepInSecond(1);
//
//        explicitWait = new WebDriverWait(driver, LONG_TIMEOUT);
//        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
//
//        for (WebElement item : allItems) {
//            if (item.getText().trim().equals(expectedItem)) {
//                jsExecutor = (JavascriptExecutor) driver;
//                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
//                sleepInSecond(1);
//
//                item.click();
//                sleepInSecond(1);
//                break;
//            }
//        }
//    }

    public String getCssValue(WebDriver driver, String locator, String propertyName){
        return getWebElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaByRgb(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize(WebDriver driver, String locator){
        return getListWebElement(driver,locator).size();
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator){
        if(!getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }

    public void uncheckToCheckboxRadio(WebDriver driver, String locator){
        if(getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getWebElement(driver, locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator){
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator){
        return getWebElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getWebElement(driver,locator));
    }

    public WebDriver switchToDefaultContent(WebDriver driver){
        return driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void doubleToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getWebElement(driver, locator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public void getDomain(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("return document.domain");
    }


}