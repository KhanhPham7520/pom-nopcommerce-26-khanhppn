package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.ProductPageUI;

public class ProductPageObject extends AbstractPages {
    WebDriver driver;
    Select select;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProcessor(String processorName) {
        waitToElementClickable(driver, ProductPageUI.PROCESSOR_DROPDOWN);
        select = new Select(findElementByXpath(driver, ProductPageUI.PROCESSOR_DROPDOWN_ITEM, processorName));

        clickToElement(driver, ProductPageUI.PROCESSOR_DROPDOWN);
        select.selectByVisibleText(processorName);
    }

    public void selectRAM(String ramName) {
        waitToElementClickable(driver, ProductPageUI.RAM_DROPDOWN);
        select = new Select(findElementByXpath(driver, ProductPageUI.RAM_DROPDOWN_ITEM, ramName));

        clickToElement(driver, ProductPageUI.RAM_DROPDOWN);
        select.selectByVisibleText(ramName);
    }

    public void selectHDD(String hddValue) {
        waitToElementClickable(driver, ProductPageUI.HDD_RADIO, hddValue);
        clickToElement(driver, ProductPageUI.HDD_RADIO, hddValue);
    }

    public void selectOS(String osName) {
        waitToElementClickable(driver, ProductPageUI.VISTA_RADIO, osName);
        clickToElement(driver, ProductPageUI.VISTA_RADIO, osName);
    }

    public void selectSoftware(String productName) {
        waitToElementClickable(driver, ProductPageUI.SOFTWARE_CHECKBOX, productName);
        if (findElementByXpath(driver, ProductPageUI.SOFTWARE_CHECKBOX, productName).isSelected() == false) {
            clickToElement(driver, ProductPageUI.SOFTWARE_CHECKBOX, productName);
        }
    }

    public void uncheckIntoCheckbox(String locator,String... productName) {
        waitToElementClickable(driver, locator, productName);
        clickToElement(driver, locator, productName);
    }

    public void unselectSoftwareForEditProductInfo(String... productName) {
        waitToElementClickable(driver, ProductPageUI.SOFTWARE_CHECKBOX, productName);
        uncheckIntoCheckbox(ProductPageUI.DYNAMIC_CHECKBOX_PRODUCT,productName);
    }

    public ShoppingCartPageObject clickAddToCart () {
            waitToElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
            clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
            return new ShoppingCartPageObject(driver);
        }

        public void clickAddToWishList () {
            waitToElementClickable(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
            clickIntoButton(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
        }

        public boolean isProductAddedWishlistSuccessful () {
            return isDisplayed(driver, ProductPageUI.ADD_TO_WISHLIST_SUCCESS_MSG);
        }

        public WishListPageObject clickToWishlistNotificationLink () {
            waitToElementClickable(driver, ProductPageUI.WISHLIST_LINK);
            clickToElement(driver, ProductPageUI.WISHLIST_LINK);
            return new WishListPageObject(driver);
        }

        public String getProductName (String productName){
            waitToElementVisible(driver, ProductPageUI.PRODUCT_NAME, productName);
            return getTextElement(driver, ProductPageUI.PRODUCT_NAME, productName);
        }

        public String getAddToCartSuccessMsg () {
            waitToElementVisible(driver, ProductPageUI.ADD_TO_CART_SUCCESS_MSG);
            return getTextElement(driver, ProductPageUI.ADD_TO_CART_SUCCESS_MSG);

        }

        public ShoppingCartPageObject clickShoppingCarNotiBar () {
            waitToElementVisible(driver, ProductPageUI.SHOPPING_CART_LINK_BAR_NOTI);
            clickToElement(driver, ProductPageUI.SHOPPING_CART_LINK_BAR_NOTI);
            return new ShoppingCartPageObject(driver);
        }

        public void inputQuantityProduct (String inputValue){
            waitToElementVisible(driver, ProductPageUI.PRODUCT_QUANTITY);
            sendKeyToElement(driver, ProductPageUI.PRODUCT_QUANTITY, inputValue);
        }

        public String getProductPrice () {
            waitToElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
            return getTextElement(driver, ProductPageUI.PRODUCT_PRICE);
        }

        public ShoppingCartPageObject clickToAddToCarLinkSuccessNotificationBar (WebDriver driver){
            waitToElementClickable(driver, ProductPageUI.SHOPPING_CART_LINK_BAR_NOTI);
            clickToElement(driver, ProductPageUI.SHOPPING_CART_LINK_BAR_NOTI);
            return new ShoppingCartPageObject(driver);
        }

    }
