package pageObjects.editNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorGeneric;
import pageUIs.BasePageUI;
import pageUIs.editNavigation.EditNavigatorPageUI;

public class EditNavigatorPageObject extends BasePage {
    WebDriver driver;

    public EditNavigatorPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailPageObject openPersonalDetailPage() {
        waitElementClickable(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);
    }

    public DependentsPageObject openDependentPage() {
        waitElementClickable(driver, EditNavigatorPageUI.DEPENDENT_LINK);
        clickToElement(driver, EditNavigatorPageUI.DEPENDENT_LINK);
        return PageGeneratorGeneric.getPage(DependentsPageObject.class, driver);
    }

    public ContactDetailPageObject openContactDetailPage() {
        waitElementClickable(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(ContactDetailPageObject.class, driver);
    }

    public JobPageObject openJobPage() {
        waitElementClickable(driver, EditNavigatorPageUI.JOB_LINK);
        clickToElement(driver, EditNavigatorPageUI.JOB_LINK);
        return PageGeneratorGeneric.getPage(JobPageObject.class, driver);
    }
}
