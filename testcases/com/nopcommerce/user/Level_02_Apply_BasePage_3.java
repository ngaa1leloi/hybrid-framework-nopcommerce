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

public class Level_02_Apply_BasePage_3 extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		emailAddress = "abc" + genarateRanomNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Register_01_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");

		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		senKeyToElement(driver, "//input[@id='LastName']", "FC");
		senKeyToElement(driver, "//input[@id='Email']", "abc");
		senKeyToElement(driver, "//input[@id='Password']", "123456");
		senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		senKeyToElement(driver, "//input[@id='LastName']", "FC");
		senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		senKeyToElement(driver, "//input[@id='Password']", "123456");
		senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickable(driver, "//a[@class='ico-logout']");
		clickElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void Register_04_Exist_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		senKeyToElement(driver, "//input[@id='LastName']", "FC");
		senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		senKeyToElement(driver, "//input[@id='Password']", "123456");
		senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'validation-summary-errors')]//li"),
				"The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		senKeyToElement(driver, "//input[@id='LastName']", "FC");
		senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		senKeyToElement(driver, "//input[@id='Password']", "12345");
		senKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");

		senKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		senKeyToElement(driver, "//input[@id='LastName']", "FC");
		senKeyToElement(driver, "//input[@id='Email']", emailAddress);
		senKeyToElement(driver, "//input[@id='Password']", "123456");
		senKeyToElement(driver, "//input[@id='ConfirmPassword']", "111111");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
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
