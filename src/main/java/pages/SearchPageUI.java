package pages;

public class SearchPageUI extends AbstractPageUI {
    public static final String INPUT_KEYWORD_TEXTBOX = "//input[@class='search-text']";
    public static final String ADVANCE_SEARCH_CHECKBOX = "//input[@type='checkbox' and @name='adv']";
    public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
    public static final String AUTOMATICALLY_SEARCH_SUB_CAT_CHECKBOX = "//input[@id='isc']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
    public static final String PRICE_FROM_TEXTBOX = "//input[@class='price-from']";
    public static final String PRICE_TO_TEXTBOX = "//input[@class='price-to']";
    public static final String SEARCH_BUTTON = "//input[@class='button-1 search-button']";

    public static final String MESSAGE_WARNING = "//div[@class='warning']";
    public static final String MESSAGE_NO_RESULT = "//div[@class='no-result']";

    public static final String LENOVO_SEARCH_RESULT_PRODUCT_FIRST = "//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]";
    public static final String LENOVO_SEARCH_RESULT_PRODUCT_SECOND = "//a[contains(text(),'Lenovo Thinkpad X1 Carbon Laptop')]";

    public static final String APPLE_MACBOOK_PRO_13_INCH_PRODUCT = "//a[contains(text(),'Apple MacBook Pro 13-inch')]";
}
