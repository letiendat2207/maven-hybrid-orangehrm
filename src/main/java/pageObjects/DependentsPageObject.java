package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;
import pageUIs.DependentsPageUI;
import pageUIs.JobPageUI;


public class DependentsPageObject extends BasePage {
    private WebDriver driver;

    public DependentsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
