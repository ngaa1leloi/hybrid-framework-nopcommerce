package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.user.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	WebDriver driver;
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInforPageIsDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isEmlementDispayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	

}
