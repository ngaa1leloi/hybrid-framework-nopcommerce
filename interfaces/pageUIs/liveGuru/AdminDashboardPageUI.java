package pageUIs.liveGuru;

public class AdminDashboardPageUI {
	public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@id='message-popup-window']//a[@title='close']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
	public static final String TEXTBOX_BY_HEADER_NAME = "xpath=//thead/tr[2]/th[%s]//input";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search']";
	
	public static final String CELL_BY_ROW_AND_COLUMN = "xpath=//table[@id='customerGrid_table']//tbody/tr[%s]/td[%s]";

}
