package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopComerce.BasePageUI;
import pageUIs.nopComerce.CustomerInforPageUI;

public class AddressPageObject extends BasePage {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}



}
