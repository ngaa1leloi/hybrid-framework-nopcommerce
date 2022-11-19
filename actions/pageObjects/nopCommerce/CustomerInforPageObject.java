package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopComerce.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage{
	WebDriver driver;
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInforPageIsDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isEmlementDispayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	

}
