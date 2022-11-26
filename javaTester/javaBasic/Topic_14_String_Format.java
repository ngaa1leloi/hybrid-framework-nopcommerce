package javaBasic;

public class Topic_14_String_Format {

	public static String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'block-account-navigation')] //a[text()='Customer info']";
	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')] //a[text()='Addresses']";
	public static String REWARD_POINT_LINK = "xpath=//div[contains(@class,'block-account-navigation')] //a[text()='Reward points']";
	public static String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'block-account-navigation')] //a[text()='My product reviews']";

	public static String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//div[contains(@class,'block-account-navigation')] //a[text()='%s']";
	public static String DYNAMIC_LINK = "xpath=//div[contains(@class,'%s')] //a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Reward points");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "My product reviews");
		clickToLink(DYNAMIC_LINK, "block-account-navigation", "My product reviews");
	}

	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println(locator);
	}

}
