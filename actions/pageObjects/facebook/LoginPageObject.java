package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
		return isEmlementDispayed(driver, LoginPageUI.EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
		return isEmlementDispayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
		senKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX_ADDRESS_TEXTBOX, value);
		
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX_ADDRESS_TEXTBOX);
	}

	public void clickToCloseRegisterForm() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}
	

}
