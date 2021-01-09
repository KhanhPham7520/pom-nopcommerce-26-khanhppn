package pageUIs;

public class HeaderPageUI extends AbstractPageUI {
    public static final String WISHLIST_LINK = "//a[@class='ico-wishlist']";
    public static final String SHOPPING_CART_LINK = "//a[@class='ico-cart']";
    public static final String HOME_IMAGE_LINK = "//img[@alt='nopCommerce demo store']/parent::a";

    public static final String LINK_NAME_OF_HEADER_MENU = "//div[@class='header-menu']/ul[@class='top-menu notmobile']/li/a[contains(text(),'%s')]";
    public static final String ITEM_LINK_OF_HEADER_MENU = "//div[@class='header-menu']/ul[@class='top-menu notmobile']/li/a[contains(text(),'%s')]//parent::li//ul//li//a[contains(text(),'%s')]";

    // Info item in shopping cart

    public static final String PRODUCT_NAME_SHOPPING_CART = "//div[@class='name']//a";
    public static final String PRODUCT_PROCESSOR_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']";
    public static final String PRODUCT_RAM_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[1]";
    public static final String PRODUCT_HDD_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[2]";
    public static final String PRODUCT_OS_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[3]";
    public static final String PRODUCT_SOFTWARE_FIRST_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[4]";
    public static final String PRODUCT_SOFTWARE_SECOND_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[5]";
    public static final String PRODUCT_SOFTWARE_THIRD_SHOPPING_CART = "//div[@class='product']//div[@class='attributes']//br[6]";

    public static final String PRODUCT_UNIT_PRICE_SHOPPING_CART = "//div[@class='product']//div[@class='price']//span[contains(text(),'$%s.00')]";
    public static final String PRODUCT_QUANTITY_SHOPPING_CART = "//div[@class='product']//div[@class='quantity']//span[contains(text(),'%s')]";
    public static final String PRODUCT_SUBTOTAL_SHOPPING_CART = "//div[@class='name']//a[contains(text(),'%s')]";

}
