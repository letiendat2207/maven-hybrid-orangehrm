package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login_07_Switch_Page extends BaseTest {
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
    public void Employee_02_Contact_Detail() {
        // Tu Personal qua Contact
        contactDetailPage = personalDetailPage.openContactDetailPage(driver);

        // Tu Contact qua Job
        jobPage = contactDetailPage.openJobPage(driver);

        // Tu Job qua Dependent
        dependentPage = jobPage.openDependentPage(driver);

        // Tu Dependent qua Personal
        personalDetailPage = dependentPage.openPersonalDetailPage(driver);

        // Tu Personal qua Job
        jobPage = personalDetailPage.openJobPage(driver);

        contactDetailPage = jobPage.openContactDetailPage(driver);

        dependentPage = contactDetailPage.openDependentPage(driver);

        personalDetailPage = dependentPage.openPersonalDetailPage(driver);
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
