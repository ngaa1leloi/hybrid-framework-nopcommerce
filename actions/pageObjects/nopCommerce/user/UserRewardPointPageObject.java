package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.user.UserCustomerInforPageUI;

public class UserRewardPointPageObject extends BasePage{
	WebDriver driver;
	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInforPageIsDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isEmlementDispayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	

}
