package pageUIs;

public class WishListPageUI {

    public static final String WISHLIST_URL = "//a[@class='share-link']";
    public static final String WISHLIST_HEADER_PAGE = "//div[@class='page-title']//h1";
    public static final String ADD_TO_CART_CHECKBOX = "//input[@name='addtocart']";
    public static final String WISHLIST_PRODUCT_NAME = "//a[@class='product-name' and contains(text(),'%s')]";
    public static final String ADD_TO_CART_BUTTON = "//input[@name='addtocartbutton']";

    // Remove Product
    public static final String REMOVE_PRODUCT_CHECKBOX = "//a[text()='%s']//preceding::td[@class='remove-from-cart']//input[@name='removefromcart']";
    public static final String CLICK_TO_BUTTON = "//input[@value='%s']";
    public static final String WISHLIST_EMPTY_MSG = "//div[@class='no-data' and contains(text(),'The wishlist is empty!')]";
    public static final String PRODUCT_INFO_ROW = "//a[text()='%s']";
}
