package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;
import pageObjects.Admin.*;

public class PageGeneratorManager {

    // Cấp phát việc khởi tạo đối tượng cho Home Page
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    // Cấp phát việc khởi tạo đối tượng cho Register Page
    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }

    // Cấp phát việc khởi tạo đối tượng cho Login Page
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }

    public static ComputerPageObject getComputerPageObject(WebDriver driver) {
        return new ComputerPageObject(driver);
    }

    public static DesktopsPageObject getDesktopPage(WebDriver driver) {
        return new DesktopsPageObject(driver);
    }

    public static ReviewPageObject getReviewPageObject(WebDriver driver) {
        return new ReviewPageObject(driver);
    }

    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
        return new FooterMyAccountPageObject(driver);
    }

    public static FooterSearchPageObject getFooterSearchPage(WebDriver driver) {
        return new FooterSearchPageObject(driver);
    }

    public static FooterNewProductPageObject getFooterNewProductPage(WebDriver driver) {
        return new FooterNewProductPageObject(driver);
    }

    public static ProductPageObject getProductPageObject(WebDriver driver) {
        return new ProductPageObject(driver);
    }

    public static AccountAddressPageObject getAccountAddressPage(WebDriver driver) {
        return new AccountAddressPageObject(driver);
    }

    public static WishListPageObject getWishListPage(WebDriver driver) {
        return new WishListPageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }

    public static HeaderPageObject getHeaderPage(WebDriver driver) {
        return new HeaderPageObject(driver);
    }

    public static CompareProductPageObject getCompareProductPage(WebDriver driver) {
        return new CompareProductPageObject(driver);
    }

    public static FooterPageObject getFooterPage(WebDriver driver) {
        return new FooterPageObject(driver);
    }

    public static RecentViewProductPageObject getRecentViewProductPage(WebDriver driver) {
        return new RecentViewProductPageObject(driver);
    }

    // Admin
    public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
        return new AdminHomePageObject(driver);
    }

    public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
        return new AdminProductPageObject(driver);
    }

    public static AdminSidebarPageObject getAdminSidebar(WebDriver driver) {
        return new AdminSidebarPageObject(driver);
    }

    public static AdminEditProductDetailPageObject getAdminEditProductPage(WebDriver driver) {
        return new AdminEditProductDetailPageObject(driver);
    }

    public static AdminSearchCustomerPageObject getAdminSearchCustomerPage(WebDriver driver) {
        return new AdminSearchCustomerPageObject(driver);
    }

    public static AdminAddNewCustomerPageObject getAdminAddNewCustomerPage(WebDriver driver) {
        return new AdminAddNewCustomerPageObject(driver);
    }

    public static NotebooksPageObject getNotebooksPage(WebDriver driver) {
        return new NotebooksPageObject(driver);
    }

    public static AdminEditCustomerPageObject getAdminEditCustomerPage(WebDriver driver) {
        return new AdminEditCustomerPageObject(driver);
    }

    public static CheckOutPO getCheckOutPage(WebDriver driver) {
        return new CheckOutPO(driver);
    }


}
