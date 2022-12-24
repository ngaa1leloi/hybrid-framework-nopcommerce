package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest{
	private WebDriver driver;
	LoginPageObject loginPage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforClass(String browserName, String url) {
		driver = getDriverBrowser(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailAddressTextbox("test123@mail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		loginPage.enterToEmailAddressTextbox("");
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@Test
	public void TC_03_Verify_Element_Unisplayed_Not_In_DOM() {
		loginPage.clickToCloseRegisterForm();
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
