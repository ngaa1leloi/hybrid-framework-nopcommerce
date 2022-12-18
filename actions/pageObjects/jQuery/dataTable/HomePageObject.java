package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATON_PAGE_BY_NUMER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATON_PAGE_BY_NUMER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String label, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, label);
		senKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, label);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, label);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATON_PAGE_ACTIVE_BY_NUMER, pageNumber);
		return isEmlementDispayed(driver, HomePageUI.PAGINATON_PAGE_ACTIVE_BY_NUMER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElemmentSize(driver, HomePageUI.TOTAL_PAGINATION);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATON_PAGE_BY_NUMER, String.valueOf(index));
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}

		}
		for (String value : allRowValueAllPage) {
			System.out.println("----------------------------------");
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columName, String rowNumber, String value) {
		int columnIndex = getElemmentSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		senKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,
				String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columName, String rowNumber, String value) {
		int columnIndex = getElemmentSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
		
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columName, String rowNumber) {
		int columnIndex = getElemmentSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}

	public void unCheckToCheckboxByColumeNameAtRowNumber(String columName, String rowNumber) {
		int columnIndex = getElemmentSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		unCheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}

}
