package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;
import pageUIs.openCart.user.UserHomePageUI;
import pageUIs.orangeHRM.commonNavigation.AddEmployeePageUI;
import pageUIs.orangeHRM.commonNavigation.BasePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPO clickToMyAccount() {
        waitElementVisible(driver, UserHomePageUI.MY_ACCOUNT_DROPDOWN);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_DROPDOWN);
        waitElementVisible(driver, UserHomePageUI.LOGIN_SECTION);
        clickToElement(driver, UserHomePageUI.LOGIN_SECTION);
        return PageGenerator.getPage(UserLoginPO.class, driver);
    }
}
