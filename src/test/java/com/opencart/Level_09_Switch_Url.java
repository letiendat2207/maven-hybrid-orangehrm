package com.opencart;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserRegisterPO;
import java.util.Random;
import pageObjects.orangeHRM.commonNavigation.*;
import pageObjects.orangeHRM.editNavigation.ContactDetailPageObject;
import pageObjects.orangeHRM.editNavigation.DependentsPageObject;
import pageObjects.orangeHRM.editNavigation.JobPageObject;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;
import pageUIs.openCart.user.UserHomePageUI;

public class Level_09_Switch_Url extends BaseTest {
    private String userURL, adminURL;

    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void beforeClass(String userURL, String adminURL, String browserName) {
        this.userURL = userURL;
        this.adminURL = adminURL;

        // Mo browser len se la trang User
        driver = getBrowserDriver(userURL, browserName);

        userHomePage = PageGenerator.getPage(UserHomePO.class, driver);

        userFirstName = "Le" + getRandomNumber();
        userLastName = "Dat" + getRandomNumber();
        userEmail = "bitcoin" + getRandomNumber() + "@gmail.com";
        userPassword = "Bitcoin@123" + getRandomNumber();

        adminUserName = "bitcoinism";
        adminPassword = "Bitcoinism21$$$";
    }

    @Test
    public void OpenCart_01_Logging_And_Logout() {
        // User -> Admin
        // Login ben Admin
        // Thao tác ben Admin
        // Log out khoi Admin
        userLoginPage = userHomePage.clickToMyAccount();
        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmailAddress(userEmail);
        userRegisterPage.enterToPassword(userPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButton();

        userHomePage = userRegisterPage.clickToLogoutLinkAtUserSite(driver);


        adminLoginPage = userHomePage.openAdminSite(driver, adminURL);

        adminLoginPage.enterToUsername(adminUserName);
        adminLoginPage.enterToPassword(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        adminDashboardPage.closeNotificationPopUp();
        adminCustomerPage = adminDashboardPage.openCustomerPage();
        adminLoginPage = adminCustomerPage.clickToLogoutLinkAtAdminSite(driver);

        // Quay lai User
        userHomePage = adminLoginPage.openUserSite(driver, userURL);

        // Login ben User
        userLoginPage = userHomePage.clickToMyAccount();
        userLoginPage.enterEmail(userEmail);
        userLoginPage.enterPassword(userPassword);
        userLoginPage.clickToLoginButton();
    }

    @Test
    public void OpenCart_02_Logging_Without_Logout() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    private WebDriver driver;
    private AdminCustomerPO adminCustomerPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private UserRegisterPO userRegisterPage;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private static String userFirstName, userLastName, userEmail, userPassword;
    private String adminUserName, adminPassword;
}
