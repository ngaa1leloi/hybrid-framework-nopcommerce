package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isEmlementDispayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickStartButton() {
		List<WebElement> listStartButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : listStartButtons) {
			startButton.click();
			sleepInSecond(2);
		}
		
	}
	
	public boolean isFileUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isEmlementDispayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isFileImageUploadedByName(String fileName) {
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);	
	}

}
