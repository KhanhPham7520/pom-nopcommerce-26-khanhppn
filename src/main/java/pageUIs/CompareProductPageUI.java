package pageUIs;

public class CompareProductPageUI {

    //// tr[@class='product-name']//td//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]/parent::td/parent::tr/following-sibling::tr[@class='product-price']//td[text()='$500.00']
    // public static final String PRODUCT_INFO = "tr[@class='product-name']"
    // + "//td//a[contains(text(),'%s')]"
    // + "/parent::td"
    // + "/parent::tr"
    // + "/following-sibling::tr[@class='product-price']"
    // + "//td";
    public static final String PRODUCT_INFO = "//tr[@class='product-name']//td//a[contains(text(),'%s')]";
}
