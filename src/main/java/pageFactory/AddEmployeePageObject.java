package pageFactory;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.AddEmployeePageUI;

import java.util.List;

public class AddEmployeePageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    @FindBy(how = How.XPATH, using = "//input[@name='firstName']")
    private WebElement firstnameTextbox;

    @FindBy(how = How.XPATH, using = "//input[@name='lastName']")
    private WebElement lastnameTexbox;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdTextbox;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-left-space')]")
    private WebElement saveButton;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, firstnameTextbox);
        sendkeyToElement(driver, firstnameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, lastnameTexbox);
        sendkeyToElement(driver, lastnameTexbox, lastName);
    }

    public String getEmployeeID() {
        waitElementVisible(driver, employeeIdTextbox);
        return getElementDomProperty(driver, employeeIdTextbox, "value");
    }

    public void clickToSaveButton() {
        waitElementVisible(driver, saveButton);
        clickToElement(driver, saveButton);
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
