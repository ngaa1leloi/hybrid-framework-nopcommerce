package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getDriverBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.sleepInSecond(2);
		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageNumberActived("5"));
		homePage.sleepInSecond(2);
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		homePage.sleepInSecond(2);
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		homePage.sleepInSecond(2);
	}

	@Test
	public void Table_02_Enter_To_Header_Textbox() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Females", "4750");
		homePage.enterToHeaderTextboxByLabel("Country", "Suriname");
		homePage.enterToHeaderTextboxByLabel("Total", "9650");
	

		homePage.sleepInSecond(2);
		homePage.enterToHeaderTextboxByLabel("Females", "1974");
		homePage.enterToHeaderTextboxByLabel("Country", "New Caledonia");
		homePage.enterToHeaderTextboxByLabel("Total", "4048");

	}

	@Test
	public void Table_03_Get_Row_At_All_Page() {
		homePage.getValueEachRowAtAllPage();

	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
