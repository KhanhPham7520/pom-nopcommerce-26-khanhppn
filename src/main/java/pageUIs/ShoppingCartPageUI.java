package pageUIs;

public class ShoppingCartPageUI extends AbstractNopCommercePageUI {

    public static final String NUMBER_ITEM_IN_SHOPPING_CART = "//span[@class='cart-qty' and text()='(%s)']";
    public static final String COUNT_NUMBER_IN_CART = "//a[@href='/cart' and text()='%s item(s)']";
    public static final String PICTURE_PRODUCT_LINK = "//a[@title='Show details for %s']";

    public static final String PRODUCT_NAME = "//td[@class='product']//a[contains(text(),'%s')]";
    public static final String TOTAL_PRICE_IN_CART = "//div[@class='totals']//following-sibling::strong[text()='$%s.00']";
    public static final String EMPTY_PRODUCT_WISHLIST = "//span[text()='Wishlist']//following-sibling::span[text()='(0)']";

    public static final String BUTTON = "//div[@class='common-buttons']//input[@value='%s']";

    // Shopping Cart Info
    public static final String INFO_PRODUCT_IN_CART = "//div[@class='product']//following-sibling::div[@class='attributes']";
    public static final String EDIT_ITEM_LINK = "//div[@class='edit-item']//a[text()='Edit']";

    public static final String PRICE_UNIT_PRICE_TABLE = "//span[@class='product-unit-price']";
    public static final String PRICE_TOTAL_TABLE = "//span[@class='product-subtotal']";

    public static final String REMOVE_CHECKBOX = "//input[@name='removefromcart']";
    public static final String SHOPPING_CART_EMPTY = "//div[@class='no-data']";
}
