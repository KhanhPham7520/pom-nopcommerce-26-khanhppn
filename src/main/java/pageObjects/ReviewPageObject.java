package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pages.ReviewPageUI;

public class ReviewPageObject extends AbstractPages {

    private final WebDriver driver;

    public ReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputReviewTitle(String inputTitle) {
        waitToElementVisible(driver, ReviewPageUI.REVIEW_TITLE_TEXTBOX);
        findElementByXpath(driver, ReviewPageUI.REVIEW_TITLE_TEXTBOX).sendKeys(inputTitle);
    }

    public void inputReviewText(String inputText) {
        findElementByXpath(driver, ReviewPageUI.REVIEW_TEXT_TEXTAREA).sendKeys(inputText);
    }

    public void selectRatingNoExcellent() {
        clickIntoRadioButton(driver, ReviewPageUI.RATING_PRODUCT_NOT_EXCELLENT_RADIO);
    }

    public void clickSubmitReview() {
        clickIntoButton(driver, ReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public boolean isReviewAddSucessfully() {
        return isDisplayed(driver, ReviewPageUI.ADD_REVIEW_SUCCESS_MSG);
    }

}
