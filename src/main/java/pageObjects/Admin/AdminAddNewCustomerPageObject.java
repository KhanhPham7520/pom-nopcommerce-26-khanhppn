package pageObjects.Admin;

import commons.AbstractPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.Admin.AdminAddNewCustomerPageUI;

public class AdminAddNewCustomerPageObject extends AbstractPages {

    WebDriver driver;
    Select select;
    JavascriptExecutor jsExecutor;

    public AdminAddNewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmailTextbox(String inputEmail) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.EMAIL_TEXTBOX, inputEmail);
    }

    public void inputPasswordTextbox(String inputPassword) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.PASSWORD_TEXTBOX, inputPassword);
    }

    public void inputFirstNameTextbox(String inputFirstName) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.FIRSTNAME_TEXTBOX, inputFirstName);
    }

    public void inputLastNameTextbox(String inputLastName) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.LASTNAME_TEXTBOX, inputLastName);
    }

    public void selectMaleGender() {
        waitToElementClickable(driver, AdminAddNewCustomerPageUI.MALE_GENDER_RADIO);
        clickToElement(driver, AdminAddNewCustomerPageUI.MALE_GENDER_RADIO);
    }

    public void selectDOB(String inputDOB) {
        waitToElementClickable(driver, AdminAddNewCustomerPageUI.DOB_DATEPICKER);
        // clickToElement(driver, AdminAddNewCustomerPageUI.DOB_DATEPICKER);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.DOB_DATEPICKER, inputDOB);
    }

    public void inputCompanyNameTextbox(String inputCompanyName) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.COMPANY_NAME);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.COMPANY_NAME, inputCompanyName);
    }

    public void selectCustomerRoles(String selectValue) {
        waitToElementClickable(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXTBOX);
        clickToElement(driver, AdminAddNewCustomerPageUI.REGISTERED_ROLE_DELETE);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.CUSTOMER_ROLES_TEXTBOX, selectValue);
        pressEnter(driver);
    }

    public boolean selectActiveStatus(boolean isSelectedActive) {
        waitToElementClickable(driver, AdminAddNewCustomerPageUI.IS_ACTIVED_CHECKBOX);
        if (isSelectedActive == false) {
            // uncheck
            clickToElement(driver, AdminAddNewCustomerPageUI.IS_ACTIVED_CHECKBOX);
        }
        return true;
    }

    public void inputAdminComment(String commentValue) {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXTBOX);
        sendKeyToElement(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXTBOX, commentValue);
    }

    public void clickSaveButton() {
        waitToElementClickable(driver, AdminAddNewCustomerPageUI.SAVE_BUTTON);
        clickToElement(driver, AdminAddNewCustomerPageUI.SAVE_BUTTON);
    }

    public String verifyAddNewCustomerSuccess() {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS);
        return getTextElement(driver, AdminAddNewCustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS);
    }

    public boolean isAddedSuccessfulDisplayed() {
        waitToElementVisible(driver, AdminAddNewCustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS);
        return isElementDisplayed(driver, AdminAddNewCustomerPageUI.ADD_NEW_CUSTOMER_SUCCESS);
    }

}
