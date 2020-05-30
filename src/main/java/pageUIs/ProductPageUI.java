package pageUIs;

public class ProductPageUI extends AbstractNopCommercePageUI {
    public static final String ADD_YOUR_REVIEW = "//a[text()='Add your review']";
    public static final String WISHLIST_LINK = "//a[text()='wishlist']";
    public static final String PRODUCT_NAME = "//h1[contains(text(),'%s')]";
    public static final String ADD_TO_WISHLIST_SUCCESS_MSG = "//div[@class='bar-notification success']";
    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']//input[@value='Add to wishlist']";
    // Product Item Info
    public static final String PROCESSOR_DROPDOWN = "//select[@name='product_attribute_1']";
    public static final String PROCESSOR_DROPDOWN_ITEM = "//option[contains(text(),'%s')]//parent::select";
    public static final String RAM_DROPDOWN = "//select[@name='product_attribute_2']";
    public static final String RAM_DROPDOWN_ITEM = "//option[contains(text(),'%s')]//parent::select[@name='product_attribute_2']";
    public static final String HDD_RADIO = "//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String VISTA_RADIO = "//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String SOFTWARE_CHECKBOX = "//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String PRODUCT_QUANTITY = "//input[@id='product_enteredQuantity_1']";
    public static final String PRODUCT_PRICE = "//span[@id='price-value-1']";
    // Add to Cart
    public static final String ADD_TO_CART_BUTTON = "//div[@class='add-to-cart-panel']//following-sibling::input[@value='Add to cart']";
    public static final String ADD_TO_CART_SUCCESS_MSG = "//div[@class='bar-notification success']//p[@class='content']";

    public static String PRODUCT_LINK = "//h2[@class='product-title']//a[contains(text(),'%s')]";

     public static final String PRODUCT_NAME_AFTER_ADD_TO_CART_SUCCESS = "//td[@class='product']//a[text()='%s']";

}
