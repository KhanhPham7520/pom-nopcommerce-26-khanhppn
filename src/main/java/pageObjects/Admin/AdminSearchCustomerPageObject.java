package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPageUI;
import pages.Admin.AdminSearchCustomerPageUI;

public class AdminSearchCustomerPageObject extends AbstractPages {

    WebDriver driver;
    Select select;

    public AdminSearchCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminAddNewCustomerPageObject clickToAddNewButton() {
        waitToElementClickable(driver, AbstractPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AbstractPageUI.ADD_NEW_BUTTON);
        return new AdminAddNewCustomerPageObject(driver);
    }

    public void inputEmailTextbox(String email) {
        waitToElementVisible(driver, AdminSearchCustomerPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AdminSearchCustomerPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputFistNameTextbox(String firstName) {
        waitToElementVisible(driver, AdminSearchCustomerPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, AdminSearchCustomerPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void selectBirthMonth(String birthMonth) {
        waitToElementClickable(driver, AdminSearchCustomerPageUI.BIRTH_MONTH_SELECT);
        select = new Select(findElementByXpath(driver, AdminSearchCustomerPageUI.BIRTH_MONTH_SELECT));
        clickToElement(driver, AdminSearchCustomerPageUI.BIRTH_MONTH_SELECT);
        select.selectByVisibleText(birthMonth);
    }

    public void selectBirthDay(String birthDay) {
        select = new Select(findElementByXpath(driver, AdminSearchCustomerPageUI.BIRTH_DAY_SELECT));
        clickToElement(driver, AdminSearchCustomerPageUI.BIRTH_DAY_SELECT);
        select.selectByVisibleText(birthDay);
    }


    public void inputLastNameTextbox(String lastName) {
        waitToElementVisible(driver, AdminSearchCustomerPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, AdminSearchCustomerPageUI.LASTNAME_TEXTBOX, lastName);
    }


    public void inputCompanyTextbox(String company) {
        waitToElementVisible(driver, AdminSearchCustomerPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, AdminSearchCustomerPageUI.COMPANY_TEXTBOX, company);
    }

    public void clickSearchButton() {
        waitToElementClickable(driver, AdminSearchCustomerPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminSearchCustomerPageUI.SEARCH_BUTTON);
    }


    public AdminEditCustomerPageObject clickToEditInTable() {
        waitToElementClickable(driver, AdminSearchCustomerPageUI.EDIT_BUTTON);
        clickToElement(driver, AdminSearchCustomerPageUI.EDIT_BUTTON);
        return new AdminEditCustomerPageObject(driver);
    }


}
