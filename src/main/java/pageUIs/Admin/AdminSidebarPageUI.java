package pageUIs.Admin;

import pageUIs.AbstractNopCommercePageUI;

public class AdminSidebarPageUI extends AbstractNopCommercePageUI {

    public static final String CATALOG_LINK = "//span[text()='Catalog']/parent::a";

    public static final String PRODUCTS_SUB_ITEM_LINK = "//span[text()='Products']/parent::a[@href='/Admin/Product/List']";

    public static final String CUSTOMERS_DROPDOWN_LINK = "//span[text()='Customers']//preceding-sibling::i[@class='fa fa-user']//parent::a";
    public static final String CUSTOMERS_DROPDOWN_ITEM = "//span[@class='menu-item-title' and text()='Customers']//preceding-sibling::i//parent::a";

}
