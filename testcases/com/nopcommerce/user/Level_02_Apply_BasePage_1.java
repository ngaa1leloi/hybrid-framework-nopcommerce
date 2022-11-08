package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = BasePage.getBasePageObject();
		emailAddress = "abc" + genarateRanomNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Register_01_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senKeyToElement(driver, "//input[@id='Email']", "abc");
		basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void Register_04_Exist_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class, 'validation-summary-errors')]//li"),
				"The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senKeyToElement(driver, "//input[@id='Password']", "12345");
		basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senKeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "111111");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
	}

	public int genarateRanomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
