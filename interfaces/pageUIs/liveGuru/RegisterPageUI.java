package pageUIs.liveGuru;

import org.testng.Assert;

public class RegisterPageUI {
	public static final String ACCOUNT_LINK ="//a/span[text()='Account']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='firstname']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='lastname']";
	public static final String EMAIL_TEXTBOX = "//input[@id='email_address']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='confirmation']";
	public static final String REGISTER_BUTTON = "//button[@title='Register']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//div[@id='advice-required-entry-firstname']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//div[@id='advice-required-entry-lastname']";
	public static final String REQUIRED_ENTRY_EMAIL_ERROR_MESSAGE = "//div[@id='advice-required-entry-email_address']";
	public static final String VALIDATE_EMAIL_ERROR_MESSAGE = "//div[@id='advice-validate-email-email_address']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//li[@class='error-msg']";
	public static final String REQUIRED_ENTRY_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-required-entry-password']";
	public static final String VALIDATE_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-validate-password-password']";
	public static final String REQUIRED_ENTRY_CONFIRM_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-required-entry-confirmation']";
	public static final String VALIDATE_CONFIRM_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-validate-cpassword-confirmation']";
	public static final String REGISTER_SUCCESS_MESSAGE = "//li[@class='success-msg']";


}
