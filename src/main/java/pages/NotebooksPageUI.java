package pages;

public class NotebooksPageUI extends AbstractPageUI {

    public static final String SORT_BY_POSITION_DROPDOWN = "//select[@id='products-orderby']";
    public static final String SORT_BY_PRICE_DROPDOWN = "//select[@id='products-pagesize']";

    public static final String DYNAMIC_CURRENT_PAGE = "//li[@class='current-page']//span[text()='%s']";
    public static final String NEXT_PAGE_ICON = "//li[@class='next-page']//a[text()='Next']";
    public static final String PREVIOUS_PAGE_ICON = "//li[@class='previous-page']//a[text()='Previous']";
    public static final String PAGINATION_LINK = "//div[@class='pager']";

}
