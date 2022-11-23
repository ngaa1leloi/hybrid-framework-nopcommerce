package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopComerce.user.BasePageUI;
import pageUIs.nopComerce.user.UserCustomerInforPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}



}
