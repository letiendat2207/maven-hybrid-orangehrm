package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddEmployeePageUI;
import pageUIs.BasePageUI;
import pageUIs.DashboardPageUI;


public class DashboardPageObject extends BasePage {
    private WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPageObject clickToPIMModule() {
        waitElementClickable(driver, DashboardPageUI.PIM_MODULE);
        clickToElement(driver, DashboardPageUI.PIM_MODULE);
        return PageGeneratorGeneric.getPage(EmployeeListPageObject.class, driver);
    }
}
