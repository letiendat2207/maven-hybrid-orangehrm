package pageFactory.orangeHRM;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    // Define các Locator/ Element
    @FindBy(how = How.CSS, using = "input[name='username']")
    private WebElement usernameTextbox;

    @FindBy(name = "password")
    private WebElement passwordTexbox;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button')]")
    private WebElement loginButton;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Bắt buộc cac Locator/ Element là kiểu dữ liệu WebElement
    // Sự thay đổi về common Class BasePage

    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, usernameTextbox);
        sendkeyToElement(driver, usernameTextbox, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, passwordTexbox);
        sendkeyToElement(driver, passwordTexbox, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
