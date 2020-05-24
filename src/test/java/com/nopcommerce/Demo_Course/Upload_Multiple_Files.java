package com.nopcommerce.Demo_Course;

import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Upload_Multiple_Files extends AbstractTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String seleniumFileName = "Selenium.jpeg";
    String appiumFileName = "Appium.png";
    String specflowFileName = "Specflow.png";

    String[] fileName = {seleniumFileName, appiumFileName, specflowFileName};

    @BeforeClass
    public void beforeClass() {
        System.setProperty(GlobalConstants.CHROME_DRIVER_SYSTEM_KEY, GlobalConstants.CHROME_DRIVER_SYSTEM_VALUE);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Sendkeys() throws Exception {
        driver.get("http://blueimp.github.io/jQuery-File-Upload/");

        // Upload 1 file
        uploadMultipleFiles(seleniumFileName);
        Thread.sleep(3000);

        // Verify
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());

        driver.navigate().refresh();

        // Upload 2 file
        uploadMultipleFiles(specflowFileName, appiumFileName);
        Thread.sleep(3000);

        // Verify
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

        driver.navigate().refresh();

        // Upload 3 file
        uploadMultipleFiles(fileName);
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

    }

    public void uploadMultipleFiles(String... fileNames) {
        String filePath = System.getProperty("user.dir") + "/uploadFiles/";
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(fullFileName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
