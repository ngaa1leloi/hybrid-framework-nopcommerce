package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.admin.AdminDashboardPageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.user.*;
import pageUIs.liveGuru.AdminDashboardPageUI;

public class Level_10_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	String firstName, lastName, emailAddress, password;
	String adminUserName, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getDriverBrowser(browserName);
		driver.get(GlobalConstants.USER_PAGE_URL);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "abc";
		lastName = "123";
		emailAddress = "abc" + genarateRanomNumber() + "@mail.vn";
		password = "123456";
		adminUserName = "user01";
		adminPassword = "guru99com";
	}

	@Test
	public void Register_01_Success() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),
				"Thank you for registering with Main Website Store.");
		homePage = registerPage.clickToLogoutLinkInDropdown();
		homePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		homePage.sleepInSecond(3);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.loginAsAdmin(adminUserName, adminPassword);
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
		adminDashboardPage.closePopup(AdminDashboardPageUI.CLOSE_POPUP_BUTTON);
		adminDashboardPage.sleepInSecond(3);
		adminDashboardPage.enterToHeaderTextboxByLabel("Name", firstName + " " + lastName);
		adminDashboardPage.enterToHeaderTextboxByLabel("Email", emailAddress);
		adminDashboardPage.clickToSearchButton();
		adminDashboardPage.sleepInSecond(3);
		adminDashboardPage.accountIsDisplayed(firstName + " " + lastName, emailAddress);
	}

	@AfterClass
	public void AfterClass() {
		//driver.quit();
	}
}
