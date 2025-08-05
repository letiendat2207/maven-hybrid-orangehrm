package pageFactory;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalDetailPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    @FindBy(how = How.XPATH, using = "//input[@name='firstName']")
    private WebElement firstnameTextbox;

    @FindBy(how = How.XPATH, using = "//input[@name='lastName']")
    private WebElement lastnameTexbox;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdTextbox;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, firstnameTextbox);
        return getElementDomProperty(driver, firstnameTextbox, "value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, lastnameTexbox);
        return getElementDomProperty(driver, lastnameTexbox, "value");
    }

    public String getEmployeeIDTextboxValue() {
        waitElementVisible(driver, employeeIdTextbox);
        return getElementDomProperty(driver, employeeIdTextbox, "value");
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
