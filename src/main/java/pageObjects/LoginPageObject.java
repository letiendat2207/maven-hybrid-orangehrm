package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    // Ham khoi tao (Constructor Method)
    // Map driver tu Test Class qua Page Object class
    // Se duoc chay dau tien khi class nay duoc goi toi
    // Neu khong viet ham khoi tao thi trinh bien dich no se tao ra cho class nay 1 ham khoi tao rong (Built-In)
    // Neu viet thi no se dung ham do minh define (User Define)
    // Cung ten voi ten Class chua no
    // Khong co gia tri tra ve
    // Co 1 hoac nhieu tham so/ co 1 hoac nhieu ham khoi tao
    // The hien cho tinh chat da hinh trong OOP
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
