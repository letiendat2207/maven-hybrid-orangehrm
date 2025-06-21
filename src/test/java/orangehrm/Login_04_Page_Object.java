package orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login_04_Page_Object extends BaseTest {
    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName) {
        driver = getBrowserDriver(appUrl, browserName);

        loginPage = new LoginPageObject();
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        // Action Login Page
        loginPage.enterToUsernameTextbox("Admin");
        loginPage.enterToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();

        // Action Dashboard Page
        dashboardPage = new DashboardPageObject();
        dashboardPage.clickToPIMModule();

        // Action Employee List Page
        employeeListPage = new EmployeeListPageObject();
        employeeListPage.clickToAddEmployeeButton();

        // Action Add Employee Page
        addEmployeePage = new AddEmployeePageObject();
        addEmployeePage.enterToFirstNameTextbox("");
        addEmployeePage.enterToLastNameTextbox("");
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();

        // Action personal detail page
        personalDetailPage = new PersonalDetailPageObject();
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), "");
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), "");
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_EditEmployee() {

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
    private String employeeID;
}
