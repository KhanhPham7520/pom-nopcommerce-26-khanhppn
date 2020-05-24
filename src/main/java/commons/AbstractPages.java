package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageUIs.AbstractNopCommercePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPages {

    protected Select select;
    protected JavascriptExecutor jsExcutor;
    long longTimeOut = 20;
    long shortTimeOut = 5;
    Actions action;
    WebElement element;
    By byXpath;
    WebDriverWait waitExplicit;
    WebDriverWait waitImplicit;
    Date date;
    private Actions actions;
    private WebDriver driver;

    public AbstractPages() {
        super();
    }

    public boolean isNameSortedDescending(WebDriver driver) {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_TITLE);

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        // copy to new arraylist for sorting in code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        // Collections.reverse(arrayList);
        return sortedList.equals(arrayList);

    }

    public boolean isNameSortedAscending(WebDriver driver) {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_TITLE);

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        // copy to new arraylist for sorting in code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }
        Collections.sort(arrayList);
        return sortedList.equals(arrayList);

    }

    public boolean isPriceSortedAscending(WebDriver driver) {
        ArrayList<Float> arrayList = new ArrayList<Float>();

        List<WebElement> elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_PRICE);

        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
        }

        // copy to new arraylist for sorting in code
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }
        Collections.sort(arrayList);
        return sortedList.equals(arrayList);

    }

    public boolean isPriceSortedDescending(WebDriver driver) {
        ArrayList<Float> arrayList = new ArrayList<Float>();

        List<WebElement> elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_PRICE);

        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
        }
        // copy to new arraylist for sorting in code
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        // Collections.reverse(arrayList);
        return sortedList.equals(arrayList);

    }

    public void sleepInSecond() {
        try {
            Thread.sleep(shortTimeOut * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openUrl(WebDriver driver, String urlValue) {
        driver.get(urlValue);
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void back(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshPage(WebDriver driver) {
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

    public void sendKeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(byXpathLocator(locator));

    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, values);
        return driver.findElements(byXpathLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
        findElementByXpath(driver, locator, values).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        clearExistedData(driver, locator);
        driver.findElement(byXpathLocator(locator)).sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String sendKeyValue, String... values) {
        findElementByXpath(driver, locator, values).clear();
        findElementByXpath(driver, locator, values).sendKeys(sendKeyValue);
    }

    public WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(byXpathLocator(locator));
    }

    public WebElement findElementByXpath(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, values);
        return driver.findElement(byXpathLocator(locator));
    }

    public int countElementNumber(WebDriver driver, String locator) {
        return findElementsByXpath(driver, locator).size();
    }

    public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
        return findElementByXpath(driver, locator).getAttribute(attributeName);
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            element = findElementByXpath(driver, locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        try {
            element = findElementByXpath(driver, locator, values);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNoDisplayed(WebDriver driver, String locator, String... values) {
        return !(findElementByXpath(driver, locator, values).isDisplayed());
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isEnabled();
    }

    public boolean isControlEnabled(WebDriver driver, String locator, String... values) {
        return findElementByXpath(driver, locator, values).isEnabled();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        element = findElementByXpath(driver, locator);
    }

    public By byXpathLocator(String locator) {
        return byXpath = By.xpath(locator);
    }

    public By byXpathLocator(String locator, String... values) {
        locator = String.format(locator, values);
        return byXpath = By.xpath(locator);
    }

    public void waitToElementVisible(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
    }

    public void waitToElementPresence(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
    }

    public void waitToElementVisible(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
    }

    public void waitToElementInvisible(WebDriver driver, String locator) {
        date = new Date();
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        try {
            System.out.println("Start time for wait invisible = " + date.toString());
            waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpathLocator(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("End time for wait invisible = " + new Date().toString());
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
    }

    public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
    }

    public void waitToElementClickable(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    public void waitToElementClickable(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... values) {
        jsExcutor = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator, values);
        jsExcutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
        sleepInSecond();
    }

    // Click into button element
    public void clickIntoButton(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void clickIntoButton(WebDriver driver, String locator, String... values) {
        waitToElementClickable(driver, locator, values);
        findElementByXpath(driver, locator, values).click();
    }

    public void clickIntoLink(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void clickIntoCheckbox(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void clickIntoRadioButton(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value, String valueItem) {
        element = findElementByXpath(driver, locator, value);
        select = new Select(element);
        select.selectByVisibleText(valueItem);

    }

    public String getTextElement(WebDriver driver, String locator) {
        waitToElementVisible(driver, locator);
        return findElementByXpath(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... values) {
        waitToElementVisible(driver, locator, values);
        return findElementByXpath(driver, locator, values).getText();
    }

    public void clearExistedData(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).clear();
    }

    public void selectDropdownByVisibleText(WebDriver driver, String locator, String inputText) {
        waitToElementClickable(driver, locator);
        Select select = new Select(findElementByXpath(driver, locator));
        select.selectByVisibleText(inputText);
    }

    public void selectCustomDropdownByVisibleText(WebDriver driver, String locator, String inputText) throws Exception {
        String allItemXpath = null;
        String expectedValueItem = null;
        WebElement parentDropdown = findElementByXpath(driver, locator);
        jsExcutor.executeScript("arguments[0].click();", parentDropdown);

        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpathLocator(allItemXpath)));
        List<WebElement> allItems = findElementsByXpath(driver, locator);
        System.out.println("All items : " + allItems);
        for (WebElement childElement : allItems) {
            if (childElement.getText().equalsIgnoreCase(expectedValueItem)) {
                if (childElement.isDisplayed()) {
                    System.out.println("Click by Selenium = " + childElement);
                    childElement.click();
                } else {
                    jsExcutor.executeScript("arguments[0].scrollIntoView(true)", childElement);
                    System.out.println("Click by JS = " + childElement.getText());
                    jsExcutor.executeScript("arguments[0].click()", childElement);
                }
                Thread.sleep(1000);
                break;
            }
        }

    }

    public void hoverToElement(WebDriver driver, String locator) {
        WebElement hoverElement = findElementByXpath(driver, locator);
        actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String value) {
        WebElement hoverElement = findElementByXpath(driver, locator, value);
        actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
    }

    public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_MY_ACCOUNT_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_MY_ACCOUNT_LINK);
        return PageGeneratorManager.getFooterMyAccountPage(driver);
    }

    public FooterSearchPageObject openFooterSearchPage(WebDriver driver) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);
        return PageGeneratorManager.getFooterSearchPage(driver);
    }

    public HomePageObject openHomePage(WebDriver driver) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.HOME_PAGE_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.HOME_PAGE_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public FooterNewProductPageObject openFooterNewProductPage(WebDriver driver) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK);
        return PageGeneratorManager.getFooterNewProductPage(driver);
    }

    // Trong trường hợp ít page (10-15)
    public AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
        // Factory Pattern
        switch (pageName) {
            case "Search":
                return PageGeneratorManager.getFooterSearchPage(driver);
            case "New products":
                return PageGeneratorManager.getFooterNewProductPage(driver);
            default:
                return PageGeneratorManager.getFooterMyAccountPage(driver);
        }

    }

    // Trong trường hợp nhiều page (n)
    public void openFooterPagesByName(WebDriver driver, String pageName) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
        clickToElement(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK, pageName);
    }

    public void selectItemInCustomDropdownList(String parentXpath, String childXpath, String expectedItem) {

        // click vào thẻ cha để nó xổ ra các item
        // driver.findElement(By.xpath(parentXpath)).click();
        findElementByXpath(driver, parentXpath).click();
        sleepInSecond();
        // lấy hết tất cả item gán vào 1 cái List
        // List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
        List<WebElement> allItems = driver.findElements(byXpathLocator(childXpath));
        System.out.println("Number items = " + allItems.size());

        // Wait cho tất cả item load lên thành công
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        // Dùng vòng lặp để duyệt qua các item
        for (int i = 0; i < allItems.size(); i++) {
            // Get text của item ra
            String itemText = allItems.get(i).getText();
            // Kiểm tra item có bằng item mình cần chọn ko
            if (itemText.equals(expectedItem)) {
                // Nếu như thỏa mãn thì click vào item đó
                allItems.get(i).click();
                // Thoát khỏi vòng lặp
                break;
            }

        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator) {
        date = new Date();
        System.out.println("Start time " + date.toString());
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = driver.findElements(By.xpath(locator));

        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time = " + new Date().toString());
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible / displayed");
            System.out.println("End time = " + new Date().toString());
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            overrideGlobalTimeout(driver, longTimeOut);
            return false;
        }
    }

    public void pressEnter(WebDriver driver) {
        action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }


    public NotebooksPageObject selectProductItemInNavigationBar(WebDriver driver, String navigationLabel, String navigationItem) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.LINK_NAME_OF_HEADER_MENU, navigationLabel);
        hoverToElement(driver, AbstractNopCommercePageUI.LINK_NAME_OF_HEADER_MENU, navigationLabel);
        clickToElement(driver, AbstractNopCommercePageUI.SUBLIST_OF_HEADER_MENU, navigationLabel, navigationItem);
        return new NotebooksPageObject(driver);
    }

    public ShoppingCartPageObject clickToShoppingCart(WebDriver driver) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.SHOPPING_CART_HEADER_LINK);
        clickToElement(driver, AbstractNopCommercePageUI.SHOPPING_CART_HEADER_LINK);
        return new ShoppingCartPageObject(driver);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExcutor = (JavascriptExecutor) driver;
        jsExcutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public String getErrorMessage(WebDriver driver, String... values) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.ERROR_MESSAGE_VALIDATION, values);
        return getTextElement(driver, AbstractNopCommercePageUI.ERROR_MESSAGE_VALIDATION, values);
    }

//    public String getTextFromInputTextbox(WebDriver driver, String... values){
//        waitToElementVisible(driver, AbstractNopCommercePageUI.INPUT_RADIO,values);
//       return getTextElement(driver, AbstractNopCommercePageUI.INPUT_RADIO,values);
//    }


//    public String getTextFromRadioButton(WebDriver driver, String... values){
//        return getTextElement(driver, AbstractNopCommercePageUI.INPUT_RADIO, values);
//    }

    public String getTextFromInputTextbox(WebDriver driver, String attributeName, String... values) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.INPUT_TEXTBOX, values);
        return findElementByXpath(driver, AbstractNopCommercePageUI.INPUT_TEXTBOX, values).getAttribute(attributeName);
    }

    public String getTextFromRadioButton(WebDriver driver, String attributeName, String... values) {
        waitToElementVisible(driver, AbstractNopCommercePageUI.INPUT_RADIO, values);
        return findElementByXpath(driver, AbstractNopCommercePageUI.INPUT_RADIO, values).getAttribute(attributeName);
    }
}
