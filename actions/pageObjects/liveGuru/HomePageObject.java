package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickRegisterLinkInDropdown() {
		waitForElementVisible(driver, HomePageUI.ACCOUNT_LINK);
		selectItemInCustomDropdown(driver, HomePageUI.ACCOUNT_LINK, HomePageUI.CHILD_ACCOUNT_LINK, "Register");
		return PageGeneratorManager.getRegisterPage(driver);
	}

}
