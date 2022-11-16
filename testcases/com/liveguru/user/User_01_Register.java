package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.*;

public class User_01_Register extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browserName) {
		driver = getDriverBrowser(browserName);
		driver.get("http://live.techpanda.org/");
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "abc";
		lastName = "123";
		emailAddress = "abc" + genarateRanomNumber() + "@mail.vn";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "This is a required field.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.inputToEmailTextbox("abc@1");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getInvalidEmailErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_Success() {
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
	}

	@Test
	public void Register_04_Existing_Email() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),
				"There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
	}

	@Test
	public void Register_05_Password_Less_Than_6() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.inputToPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getValidatePasswordErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		registerPage = homePage.clickRegisterLinkInDropdown();
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getValidateConfirmPasswordErrorMessage(),
				"Please make sure your passwords match.");
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
