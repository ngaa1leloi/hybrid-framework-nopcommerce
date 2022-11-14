package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	@FindBy(id = "register-button")
	private WebElement registerButton;
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	@FindBy(xpath = "//div[contains(@class, 'validation-summary-errors')]//li")
	private WebElement existingEmailErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		senKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToFirstLastNamebox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		senKeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senKeyToElement(driver, emailTextbox, emailAddress);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senKeyToElement(driver, passwordTextbox, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		senKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

}
