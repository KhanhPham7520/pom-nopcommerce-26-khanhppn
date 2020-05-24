package com.nopcommerce.Demo_Course;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Selenium_Version {

    WebDriver driver;

    @Test
    public void TC_01_New_Firefox() {
        // Selenium 2.53.1
        // Firefox 47.02.2 ( No using geckodriver )
        System.setProperty(GlobalConstants.FIREFOX_DRIVER_SYSTEM_KEY, GlobalConstants.FIREFOX_DRIVER_SYSTEM_VALUE);
        driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_02_New_Chrome() {
        // Selenium 2.53.1
        // Firefox 47.02.2 ( No using geckodriver )
        System.setProperty(GlobalConstants.CHROME_DRIVER_SYSTEM_KEY, GlobalConstants.CHROME_DRIVER_SYSTEM_VALUE);
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_03_New_Safari() {
        // Selenium lastest + Safari Browser
        driver = new SafariDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_03_New_Edge() {
        // Set the driver path
        System.setProperty(GlobalConstants.EDGE_DRIVER_SYSTEM_KEY, GlobalConstants.EDGE_DRIVER_SYSTEM_VALUE);
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.facebook.com/");
        driver.quit();
    }

}
