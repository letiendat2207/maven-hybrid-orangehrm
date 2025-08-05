package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.editNavigation.ContactDetailPageObject;
import pageObjects.editNavigation.DependentsPageObject;
import pageObjects.editNavigation.JobPageObject;
import pageObjects.editNavigation.PersonalDetailPageObject;

public class Login_08_Page_Navigator extends BaseTest {
    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName) {
        driver = getBrowserDriver(appUrl, browserName);

        loginPage = PageGeneratorGeneric.getPage(LoginPageObject.class, driver);

        adminUsername = "bitcoinism";
        adminPassword = "Bitcoinism21$$$";
        employeeFirstname = "Le";
        employeeLastname = "Dat";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        dashboardPage.sleepInSeconds(2);

        employeeListPage = dashboardPage.clickToPIMModule();
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(employeeFirstname);
        addEmployeePage.enterToLastNameTextbox(employeeLastname);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        personalDetailPage.sleepInSeconds(2);

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), employeeFirstname);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), employeeLastname);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Page_Navigator() {

        // Tu Personal qua Contact
        contactDetailPage = personalDetailPage.openContactDetailPage();

        // Tu Contact qua Job
        jobPage = contactDetailPage.openJobPage();

        // Tu Job qua Dependent
        dependentPage = jobPage.openDependentPage();

        // Tu Dependent qua Personal
        personalDetailPage = dependentPage.openPersonalDetailPage();

        // Tu Personal qua Job
        jobPage = personalDetailPage.openJobPage();

        contactDetailPage = jobPage.openContactDetailPage();

        dependentPage = contactDetailPage.openDependentPage();

        personalDetailPage = dependentPage.openPersonalDetailPage();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private AddEmployeePageObject addEmployeePage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentPage;
    private String employeeID, adminUsername, adminPassword, employeeFirstname, employeeLastname;
}
