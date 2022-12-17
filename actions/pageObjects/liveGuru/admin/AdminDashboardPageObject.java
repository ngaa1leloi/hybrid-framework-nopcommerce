package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.liveGuru.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {

	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup(String popupLocator) {
		waitForElementVisible(driver, popupLocator);
		clickToElement(driver, popupLocator);
	}

	public void enterToHeaderTextboxByLabel(String label, String value) {
		int columnIndex = getElemmentSize(driver, AdminDashboardPageUI.COLUMN_INDEX_BY_NAME, label) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.TEXTBOX_BY_HEADER_NAME, String.valueOf(columnIndex));
		senKeyToElement(driver, AdminDashboardPageUI.TEXTBOX_BY_HEADER_NAME, value, String.valueOf(columnIndex));
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SEARCH_BUTTON);
	}

	public String getTextByRowNumberAndColumnName(String rowNumber, String ColumeName) {
		int columnIndex = getElemmentSize(driver, AdminDashboardPageUI.COLUMN_INDEX_BY_NAME, ColumeName) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.CELL_BY_ROW_AND_COLUMN, rowNumber,
				String.valueOf(columnIndex));
		return getElementText(driver, AdminDashboardPageUI.CELL_BY_ROW_AND_COLUMN, rowNumber,
				String.valueOf(columnIndex));
	}

	public void accountIsDisplayed(String name, String email) {
		Assert.assertEquals(getTextByRowNumberAndColumnName("1", "Name"), name);
		Assert.assertEquals(getTextByRowNumberAndColumnName("1", "Email"), email);
	}

}
