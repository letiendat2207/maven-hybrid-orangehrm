package com.orangehrm;

import core.BasePage;
import javaSDET.Topic_01_Keywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_02_BasePage_III_Extend extends BasePage {
    WebDriver driver;
    WebDriverWait explicitWait;
    private Topic_01_Keywords topic01;
    private BasePage basePage;
    private String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty() {
        openUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "");
        sendkeyToElement(driver, "//input[@name='password']", "");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(getElementText(driver, "//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        openUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "dat@gmail.com");
        sendkeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//div[@class='orangehrm-login-error']//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        openUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "12345!@#$");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//div[@class='orangehrm-login-error']//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Username_Password() {
        openUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertTrue(isAllLoadingIconInvisible());
        Assert.assertEquals(getElementText(driver, "//div[@class='oxd-topbar-header-title']//h6"), "Dashboard");
    }

    public boolean isAllLoadingIconInvisible() {
        return waitListElementInvisible(driver, "//div[@class='oxd-loading-spinner']");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
