package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCart.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstName(String userFirstName) {
        waitElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, userFirstName);
    }

    public void enterToLastName(String userLastName) {
        waitElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, userLastName);
    }

    public void enterToEmailAddress(String userEmail) {
        waitElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, userEmail);
    }

    public void enterToPassword(String userPassword) {
        waitElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, userPassword);
    }

    public void acceptPrivacyCheckbox() {
        scrollToElementOnTop(driver, UserRegisterPageUI.ACCEPT_PRIVACY_CHECKBOX);
        waitElementClickable(driver, UserRegisterPageUI.ACCEPT_PRIVACY_CHECKBOX);
        checkToCheckbox(driver, UserRegisterPageUI.ACCEPT_PRIVACY_CHECKBOX);
    }

    public void clickContinueButton() {
        scrollToElementOnTop(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        waitElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
    }
}
