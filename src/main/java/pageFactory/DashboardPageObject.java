package pageFactory;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.DashboardPageUI;


public class DashboardPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//span[text()='PIM']/parent::a")
    private WebElement pimModule;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToPIMModule() {
        waitElementVisible(driver, pimModule);
        clickToElement(driver, pimModule);
    }
}
