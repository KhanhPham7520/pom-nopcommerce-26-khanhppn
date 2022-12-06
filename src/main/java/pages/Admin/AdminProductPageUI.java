package pages.Admin;

public class AdminProductPageUI {
    public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
    public static final String SEARCH_BUTTON = "//button[@id='search-products']";

    public static final String PRODUCT_NAME_TBL = "//tr[@class='odd']//td[contains(text(),'%s')]";
    public static final String SKU_TBL = "//tr[@class='odd']//td[4]";
    public static final String PRICE_TBL = "//tr[@class='odd']//td[5]";
    public static final String STOCK_QUANTITY_TBL = "//tr[@class='odd']//td[6]";
    public static final String PRODUCT_TYPE_TBL = "//tr[@class='odd']//td[7]";
    public static final String IS_PUBLISHED_TBL = "//tr[@class='odd']//td[8]//i[@nop-value='true']";

    public static final String CATEGORY_SELECT = "//select[@name='SearchCategoryId']";
    public static final String MANUFACTURER_SELECT = "//select[@name='SearchManufacturerId']";

    public static final String SKU_TEXTBOX = "//input[@id='GoDirectlyToSku']";
    public static final String GO_SKU_BUTTON = "//button[@id='go-to-product-by-sku']";

    public static final String SEARCH_SUB_CATEGORY_CHECKBOX = "//input[@id='SearchIncludeSubCategories']";
    public static final String NO_DATA_AVAILABLE_MESSAGE = "//tr[@class='odd']//td[@class='dataTables_empty']";

}
