package Test;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class orderHistoryModule extends Browser {
	Report rpt = new Report();
	Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void executeAll() throws Exception {
		Login();
		addProduct_order();
//		chk_AccSection();
//		navigateOptions();
//		verifyOrderHistory();
//		detailedOrderDetails();
//		searchOrderByID();
//		searchOrderWithKeyword();
//		searchOrderByCategory();

	}

	public void Login() throws Exception {
		// Registering User
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys(
				"xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']",
				"user@test.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys(
				"xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']",
				"Royalcyber1");
		click("id=Header_GlobalLogin_WC_AccountDisplay_links_2");// Signin Button
		Thread.sleep(4000);
		click("id=wishListQuickLink_alt");
		click("xpath=//*[@id=\"myAccountQuickLink\"]");
		Thread.sleep(5000);
		waitForPageElementToBeDisplayed("xpath=//*[@id=\"Header_GlobalLogin_loggedInDropdown\"]");
		// click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[2]/div[4]/div[1]/a");
		if (findTheElement(
				"xpath=//a[@href='https://qalive.circuitcity.com/TrackOrderStatus?catalogId=3074457345616676668&langId=-1&storeId=10801&orderStatusStyle=strong']")
						.isDisplayed()) {
			rpt.createTest("CC - Order History - Verify Login", "Order history link Displayed - For Verify Login");
			rpt.Pass("Order history link Displayed - For Verify Login");
			rpt.Category("CC_Order History  - Verify Login ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//a[@href='https://qalive.circuitcity.com/TrackOrderStatus?catalogId=3074457345616676668&langId=-1&storeId=10801&orderStatusStyle=strong']");

		} else {
			rpt.createTest("CC - Order History  - Verify Login",
					"Order history link is NOT Displayed - For Verify Login");
			rpt.Fail("Order history link is NOT Displayed - For Verify Login");
			rpt.Category("CC_Order History - Verify Login");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}
	public void addProduct_order()throws Exception 
	{
		sendKeys("id=SimpleSearchForm_SearchTerm","lenovo");
		Thread.sleep(2000);
		click("css=div.submitButton");
		Thread.sleep(2000);
		
	}

	public void chk_AccSection() throws Exception {
		Map<String, String> ids = new HashMap<String, String>();
		ids.put("Settings", "section_button_settings");
		ids.put("Wishlist", "section_button_wishlists");
		ids.put("Orders", "section_button_orders");
		ids.put("Coupons", "section_button_coupons");
		for (Map.Entry<String, String> id : ids.entrySet()) {
			if (findTheElement("xpath=//*[@id='" + id.getValue() + "']").isDisplayed()) {
				// System.out.println(id.getKey() + " is displayed ");
				// rpt.createTest("CC-Address Book-Check Account section",
				// "Message"+id.getKey()+" Displayed For Account Section:");

				rpt.createTest("CC-Order History -Check Account Section",
						"Message :" + id.getKey() + " Displayed - For Account Section");
				rpt.Pass("Message :" + id.getKey() + " Displayed - For Account Section");
				rpt.Category("CC_Order History -Check Account Section");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);

			} else {
				// System.out.println(id.getKey() + " is not displayed ");
				// rpt.createTest("CC-Address Book-Check Account section",
				// "Message"+id.getKey()+" is NOT Displayed For Account Section:");

				rpt.createTest("CC-Order History -Check Account Section",
						"Message :" + id.getKey() + "is NOT Displayed - For Account Section");
				rpt.Pass("Message :" + id.getKey() + " NOT Displayed - For Account Section");
				rpt.Category("CC_Order History -Check Account Section");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);

			}
		}
	}

	// CC_ACC_003, CC_ACC_004, CC_ACC_005, CC_ACC_006
	public void navigateOptions() throws Exception {
		Map<String, String> ids = new HashMap<String, String>();
		ids.put("All_Orders", "WC_MyAccountSidebarDisplayf_links_5");
		ids.put("Recurring_Orders", "WC_MyAccountSidebarDisplayf_links_5a");
		ids.put("Subscriptions", "WC_MyAccountSidebarDisplayf_links_5b");
		for (Map.Entry<String, String> id : ids.entrySet()) {
			if (findTheElement("xpath=//*[@id='" + id.getValue() + "']").isDisplayed()) {
				// System.out.println(id.getKey() + " is displayed ");
				// rpt.createTest("CC-Address Book-Check Account section",
				// "Message"+id.getKey()+" Displayed For Account Section:");

				rpt.createTest("CC-Order History -Check order_History Section",
						"Message :" + id.getKey() + " Displayed - For order_History Section");
				rpt.Pass("Message :" + id.getKey() + " Displayed - For order_History Section");
				rpt.Category("CC_Order History -Check Account Section");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);

			} else {
				// System.out.println(id.getKey() + " is not displayed ");
				// rpt.createTest("CC-Address Book-Check Account section",
				// "Message"+id.getKey()+" is NOT Displayed For Account Section:");

				rpt.createTest("CC-Order History -Check Account Section",
						"Message :" + id.getKey() + "is NOT Displayed - For order_History Section");
				rpt.Pass("Message :" + id.getKey() + " NOT Displayed - For order_History Section");
				rpt.Category("CC_Order History -Check Account Section");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);

			}
		}
		// CC_ACC_005
		// click("id=WC_MyAccountSidebarDisplayf_links_5a");
		if (findTheElement("id=WC_MyAccountSidebarDisplayf_links_5a").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Recurring orders navigation",
					"Recurring Orders option Displayed - For Verify Recurring orders navigation");
			rpt.Pass("Recurring Orders option Displayed - For Verify Recurring orders navigation");
			rpt.Category("CC_Order History  - Verify Recurring orders navigation ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=WC_MyAccountSidebarDisplayf_links_5a");
		} else {
			rpt.createTest("CC - Order History - Verify Recurring orders navigation",
					"Recurring Orders option is NOT Displayed - For Verify Recurring orders navigation");
			rpt.Fail("Recurring Orders option is NOT Displayed - For Verify Recurring orders navigation");
			rpt.Category("CC_Order History  - Verify Recurring orders navigation");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_ACC_006
		// click("id=WC_MyAccountSidebarDisplayf_links_5b");
		if (findTheElement("id=WC_MyAccountSidebarDisplayf_links_5b").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Subscriptions navigation",
					"Subscription link Displayed - For Verify Subscriptions navigation");
			rpt.Pass("Subscription link Displayed - For Verify Subscriptions navigation");
			rpt.Category("CC_Order History  - Verify Subscriptions navigation ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=WC_MyAccountSidebarDisplayf_links_5b");
		} else {
			rpt.createTest("CC - Order History - Verify Subscriptions navigation",
					"Subscription link is NOT Displayed - For Verify Subscriptions navigation");
			rpt.Fail("Subscription link is NOT Displayed - For Verify Subscriptions navigation");
			rpt.Category("CC_Order History  - Verify Subscriptions navigation");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_ACC_004
		// click("id=WC_MyAccountSidebarDisplayf_links_5");
		if (findTheElement("id=WC_MyAccountSidebarDisplayf_links_5").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify All orders navigation",
					"All Orders link Displayed - For Verify All orders navigation");
			rpt.Pass("All Orders link Displayed - For Verify All orders navigation");
			rpt.Category("CC_Order History  - Verify All orders navigation ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=WC_MyAccountSidebarDisplayf_links_5");
		} else {
			rpt.createTest("CC - Order History - Verify All orders navigation",
					"All Orders link is NOT Displayed - For Verify All orders navigation");
			rpt.Fail("All Orders link is NOT Displayed - For Verify All orders navigation");
			rpt.Category("CC_Order History  - Verify All orders navigation");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

	}

	// CC_ACC_007
	public void verifyOrderHistory() throws Exception {
		Thread.sleep(3000);
		if (findTheElement("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]")
				.isDisplayed()
				&& findTheElement(
						"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]")
								.isDisplayed()
				&& findTheElement(
						"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[4]")
								.isDisplayed()
				&& findTheElement(
						"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]")
								.isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Order History details",
					"Each Order's history details is Displayed - For Verify Order History details");
			rpt.Pass("Each Order's history details is Displayed - For Verify Order History details");
			rpt.Category("CC_Order History  - Verify Order History details");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - Order History - Verify Order History details",
					"Each Order's history details is NOT Displayed - For Verify Order History details");
			rpt.Fail("Each Order's history details is NOT Displayed - For Verify Order History details");
			rpt.Category("CC_Order History  - Verify Order History details");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_ACC_008
	public void detailedOrderDetails() throws Exception {
		// click("id=Processed_actionButton1");
		if (findTheElement("css=div.button_secondary actionButton").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Detailed order history",
					"View Details Button Displayed - For Verify Detailed order history");
			rpt.Pass("View Details Button Displayed - For Verify Detailed order history");
			rpt.Category("CC_Order History  - Verify Detailed order history");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("css=div.button_secondary actionButton");// View Details Button
		} else {
			rpt.createTest("CC - Order History - Verify Detailed order history",
					"View Details Button is NOT Displayed - For Verify Detailed order history");
			rpt.Fail("View Details Button is NOT Displayed - For Verify Detailed order history");
			rpt.Category("CC_Order History  - Verify Detailed order history");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);

		// Detailed Order history Page
		if (findTheElement("id=orderDetail_content").isDisplayed() && findTheElement("id=orderInfo").isDisplayed()
				&& findTheElement("id=summaryOfChanges").isDisplayed()
				&& findTheElement("id=OrderDetail_Shipping_DetailDiv").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Detailed order history",
					"Detailed Page of Order is Displayed - For Verify Detailed order history");
			rpt.Pass("Detailed Page of Order is Displayed - For Verify Detailed order history");
			rpt.Category("CC_Order History  - Verify Detailed order history");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - Order History - Verify Detailed order history",
					"Detailed Page of Order is NOT Displayed - For Verify Detailed order history");
			rpt.Fail("Detailed Page of Order is NOT Displayed - For Verify Detailed order history");
			rpt.Category("CC_Order History  - Verify Detailed order history");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		browser.navigate().back();
	}

	// CC_ACC_009, CC_ACC_010, CC_ACC_011
	public void searchOrderByID() throws Exception {

		Robot r = new Robot();
		// Search with OrderID
		click("id=orderSearchTerm");
		if (findTheElement("id=orderSearchTerm").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Search option",
					"Search Input is Displayed - For Verify Search option");
			rpt.Pass("Search Input is Displayed - For Verify Search option");
			rpt.Category("CC_Order History  - Verify Search option");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("id=orderSearchTerm", "140512587573");
		} else {
			rpt.createTest("CC - Order History - Verify Search option",
					"Search Input is NOT Displayed - For Verify Search option");
			rpt.Fail("Search Input is NOT Displayed - For Verify Search option");
			rpt.Category("CC_Order History  - Verify Search option");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		click("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button/i");
		Thread.sleep(5000);
		String val = getText(
				"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[4]/div/span[2]");
		if (val.equals("140512587573")) {
			rpt.createTest("CC -Order History  - Verify Search result",
					"Search result is Displayed - For Verify Search result");
			rpt.Pass("Search result is Displayed - For Verify Search result");
			rpt.Category("CC_Order History  - Verify Search result");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - Order History - Verify Search result(ID)",
					"Search result is NOT Displayed - For Verify Search result(ID)");
			rpt.Fail("Search result is NOT Displayed - For Verify Search result(ID)");
			rpt.Category("CC_Order History  - Verify Search result(ID)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("id=orderSearchTerm");
		sendKeys("id=orderSearchTerm", "");
	}

	public void searchOrderWithKeyword() throws Exception {
		doubleClick("id=orderSearchTerm");
		Thread.sleep(3000);
		// Search with a keyword
		if (findTheElement("id=orderSearchTerm").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Search option(Keyword)",
					"Search Input is Displayed - For Verify Search option(Keyword)");
			rpt.Pass("Search Input is Displayed - For Verify Search option(Keyword)");
			rpt.Category("CC_Order History  - Verify Search option(Keyword)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("id=orderSearchTerm", "Lenovo");
		} else {
			rpt.createTest("CC - Order History - Verify Search option(Keyword)",
					"Search Input is NOT Displayed - For Verify Search option(Keyword)");
			rpt.Fail("Search Input is NOT Displayed - For Verify Search option(Keyword)");
			rpt.Category("CC_Order History  - Verify Search option(Keyword)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		click("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button/i");
		click("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/h1");
		Thread.sleep(8000);
		if (getText(
				"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/p[1]/a")
						.contentEquals("Lenovo")) {
			rpt.createTest("CC -Order History  - Verify Search result(Keyword)",
					"Search result is Displayed - For Verify Search result(Keyword)");
			rpt.Pass("Search result is Displayed - For Verify Search result(Keyword)");
			rpt.Category("CC_Order History  - Verify Search result(Keyword)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - Order History - Verify Search result(Keyword)",
					"Search result is NOT Displayed - For Verify Search result(Keyword)");
			rpt.Fail("Search result is NOT Displayed - For Verify Search result(Keyword)");
			rpt.Category("CC_Order History  - Verify Search result(Keyword)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("id=orderSearchTerm");
		sendKeys("id=orderSearchTerm", "");
	}

	public void searchOrderByCategory() throws Exception {
		doubleClick("id=orderSearchTerm");
		Thread.sleep(3000);
		// Search with a keyword
		if (findTheElement("id=orderSearchTerm").isDisplayed()) {
			rpt.createTest("CC -Order History  - Verify Search option(Category)",
					"Search Input is Displayed - For Verify Search option(Category)");
			rpt.Pass("Search Input is Displayed - For Verify Search option(Category)");
			rpt.Category("CC_Order History  - Verify Search option(Category)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("id=orderSearchTerm", "Headset");
		} else {
			rpt.createTest("CC - Order History - Verify Search option(Category)",
					"Search Input is NOT Displayed - For Verify Search option(Category)");
			rpt.Fail("Search Input is NOT Displayed - For Verify Search option(Category)");
			rpt.Category("CC_Order History  - Verify Search option(Category)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		click("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button/i");
		click("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/h1");
		Thread.sleep(8000);
		if (getText(
				"xpath=/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/p[1]/a")
						.contentEquals("Headset")) {
			rpt.createTest("CC -Order History  - Verify Search result(Category)",
					"Search result is Displayed - For Verify Search result(Category)");
			rpt.Pass("Search result is Displayed - For Verify Search result(Category)");
			rpt.Category("CC_Order History  - Verify Search result(Category)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - Order History - Verify Search result(Category)",
					"Search result is NOT Displayed - For Verify Search result(Category)");
			rpt.Fail("Search result is NOT Displayed - For Verify Search result(Category)");
			rpt.Category("CC_Order History  - Verify Search result(Category)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
	}

}
