package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.CustomerInforPageUI;

public class RewardPointPageObject extends BasePage{
	WebDriver driver;
	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInforPageIsDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isEmlementDispayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	

}
