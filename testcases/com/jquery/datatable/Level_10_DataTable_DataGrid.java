package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getDriverBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	//@Test
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

	//@Test
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

	//@Test
	public void Table_03_Get_Row_At_All_Page() {
		homePage.getValueEachRowAtAllPage();

	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadDataButton();
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "Company 2");
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "3", "Company 3");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Contact Person 1");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "2", "5");
		//homePage.enterToTextboxByColumnNameAtRowNumber("Member Since", "2", "12-12-2022");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Hong Kong");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Taiwan");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.unCheckToCheckboxByColumeNameAtRowNumber("NPO?", "1");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Move Down");
		
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
