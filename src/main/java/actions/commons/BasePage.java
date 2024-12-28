package actions.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    private long LONG_TIMEOUT = 30;

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

}
