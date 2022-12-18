package com.jquery.uploadfile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;
import pageUIs.jQuery.uploadFile.BasePageUI;

public class Level_11_Upload_File extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	private String javaFileName = "java.png";
	private String jsFileName = "js.png";
	private String phpFileName = "php.png";
	private String rubyFileName = "ruby.jpg";
	private String[] multipleFileNames = {javaFileName, jsFileName, phpFileName, rubyFileName};

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getDriverBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_TYPE, javaFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
	}
	
	@Test
	public void Upload_02_Multiple_Files() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, BasePageUI.UPLOAD_FILE_TYPE, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(jsFileName));
		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileUploadedByName(jsFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(jsFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
