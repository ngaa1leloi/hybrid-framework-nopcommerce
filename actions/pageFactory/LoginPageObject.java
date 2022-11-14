package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	@FindBy(xpath =  "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unSuccessfulErrorMessage;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senKeyToElement(driver, emailTextbox, emailAddress);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senKeyToElement(driver, passwordTextbox, password);

	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unSuccessfulErrorMessage);
		return getElementText(driver, unSuccessfulErrorMessage);
	}
}
