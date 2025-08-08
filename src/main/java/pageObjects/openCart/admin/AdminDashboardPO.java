package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminCustomerPageUI;
import pageUIs.openCart.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminCustomerPO openCustomerPage() {
        waitElementVisible(driver, AdminDashboardPageUI.CUSTOMER_SECTION);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMER_SECTION);
        waitElementVisible(driver, AdminDashboardPageUI.CUSTOMER_SUB_SECTION);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMER_SUB_SECTION);
        return PageGenerator.getPage(AdminCustomerPO.class, driver);
    }

    public void closeNotificationPopUp() {
        waitElementVisible(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON);
    }
}
