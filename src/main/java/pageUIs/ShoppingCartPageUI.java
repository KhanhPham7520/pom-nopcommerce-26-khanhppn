package pageUIs;

public class ShoppingCartPageUI extends AbstractNopCommercePageUI {

    public static final String PRODUCT_NAME = "//td[@class='product']//a[contains(text(),'%s')]";
    public static final String EMPTY_PRODUCT_WISHLIST = "//span[text()='Wishlist']//following-sibling::span[text()='(0)']";

    public static final String BUTTON = "//div[@class='common-buttons']//input[@value='%s']";

    // Shopping Cart Info
    public static final String INFO_PRODUCT_IN_CART = "//div[@class='product']//following-sibling::div[@class='attributes']";
    public static final String EDIT_ITEM_LINK = "//div[@class='edit-item']//a[text()='Edit']";

    public static final String PRICE_UNIT_PRICE_TABLE = "//span[@class='product-unit-price']";
    public static final String PRICE_TOTAL_TABLE = "//span[@class='product-subtotal']";

    public static final String REMOVE_CHECKBOX = "//input[@name='removefromcart']";
    public static final String SHOPPING_CART_EMPTY = "//div[@class='no-data']";

    public static final String QUANTITY_TEXTBOX = "//label[text()='Qty.:']//following-sibling::input";

    public static final String ESTIMATING_SHIPPING_BUTTON = "//a[contains(text(),'Estimate shipping')]";

    public static final String SELECT_COUNTRY_ESTIMATING_SHIPPING = "//select[@id='CountryId']";

    public static final String ZIP_POSTAL_CODE_ESTIMATING_SHIPPING = "//input[@id='ZipPostalCode']";

    public static final String APPLY_BUTTON_ESTIMATING_SHIPPING = "//input[@value='Apply']";

    public static final String TERM_OF_SERVICE_CHECKBOX = "//input[@id='termsofservice']";

    public static final String CHECK_OUT_BUTTON = "//button[@id='checkout']";

    public static final String ESTIMATE_SHPPING_OPTION_POPUP = "//div[@class='estimate-shipping-row shipping-option active']";

    public static final String SHOPPING_CART_IS_EMPTY_MESSAGE = "//div[@class='no-data']";






}
