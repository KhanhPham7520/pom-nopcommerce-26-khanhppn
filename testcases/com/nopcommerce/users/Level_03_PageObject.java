package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_03_PageObject extends BasePage {

    WebDriver driver;
    String emailAddress;

    HomePageObject homePage;
    CustomerInfoPageObject customerInfoPage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;

    @BeforeClass
    public void beforeClass() {

        // Set the path to the ChromeDriver executable (adjust the path if needed)
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
        }else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
        }


        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized"); // Start Chrome maximized
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-infobars"); // Disable infobars
        options.addArguments("--remote-allow-origins=*"); // Allow remote origins (if required)
      //  options.addArguments("--headless"); // Optional: Run tests in headless mode (no GUI)

        // Add platform-specific options
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            options.addArguments("--kiosk"); // Optional: Start in kiosk mode for Mac
        }else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            options.addArguments("--disable-gpu"); // Disable GPU acceleration (optional for Windows)
        }

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePageObject(driver);
    }

    @Test
    public void TC_01_Register() {
        homePage.clickToRegisterLink();

//        registerPage = new RegisterPageObject();
//        registerPage.enterToFirstNameTextbox("");
//        registerPage.enterToLastNameTextbox("");
//        registerPage.enterToEmailTextbox("");
//        registerPage.enterToPasswordTextbox("");
//        registerPage.enterToConfirmPasswordTextbox("");
//
//        registerPage.clickToRegisterButton();
//
//        Assert.assertEquals("","", "Your registration completed");
//        registerPage.getRegisterSuccessMessage();
//
//        // Navigate back to Home Page
//        homePage = new HomePageObject();
    }

    @Test
    public void TC_02_Login(){
//        homePage.clickToLoginLink();
//
//        loginPage = new LoginPageObject();
//        loginPage.enterToEmailTextbox();
//        loginPage.enterToPasswordTextbox();
//        loginPage.clickToLoginButton();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
