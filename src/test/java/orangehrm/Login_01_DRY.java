package orangehrm;

// import tu thu vien

import javaSDET.Topic_01_Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

// import cac class - interface tu cac package khac

import java.time.Duration;

public class Login_01_DRY {
    WebDriver driver;
    WebDriverWait explicitWait;
    private Topic_01_Keywords topic01;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("");

        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']/parent::div/following-sibling::span")).getText(), "Required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/parent::div/following-sibling::span")).getText(), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("dat@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");

        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.orangehrm-login-error p.oxd-alert-content-text")).getText(), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345!@#$");

        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.orangehrm-login-error p.oxd-alert-content-text")).getText(), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Username_Password() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");

        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Assert.assertTrue(isAllLoadingIconInvisible());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header-title h6")).getText(), "Dashboard");
    }

    public boolean isAllLoadingIconInvisible() {
        return explicitWait.until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
