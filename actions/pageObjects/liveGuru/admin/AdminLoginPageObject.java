package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageUIs.liveGuru.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUserNameTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
		senKeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToUserNameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
	

}
