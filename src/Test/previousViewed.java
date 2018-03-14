package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class previousViewed extends Browser {

	Report rpt = new Report();
	//Browser br = new Browser();
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void ExecuteCase() throws Exception {
		Login();
		shopNow(); //TC -03
		addToComapre(); //tc - 04,05
		loveIt(); //tc-06
		
	}

	// CC_PV_05/04s
	@BeforeTest
	public void Login() throws Exception {
		// click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		 click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "user@test.com");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "Royalcyber1");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
			//click("xpath=html/body/div[2]/div[1]/div[2]/div[2]/div[4]/ul/li[3]/a[1]");
			Thread.sleep(6000);
//			click("xpath=.//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
			click("xpath=//a[contains(text(),'My Account')]"); //my acc
		
		
	}

	
	public void compare_Previous() throws Exception {
		Thread.sleep(30000);
		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
		if (findTheElement(
				"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products Displayed - For Verify Products");
			rpt.Pass("Products Displayed - For Verify Products");
			rpt.Category("CC_Previous Viewed - Verify Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products is NOT Displayed - For Verify Products");
			rpt.Fail("Products Page is NOT Displayed - For Verify Products");
			rpt.Category("CC_Previously Viewed - Verify Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		//click("id=departmentLink_3074457345616682180_alt");
		if (findTheElement(
				"id=departmentLink_3074457345616682180_alt")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Select Products",
					"Select Products Displayed - For Verify Select Products");
			rpt.Pass("Select Products Displayed - For Verify Select Products");
			rpt.Category("CC_Previous Viewed - Verify Select Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=departmentLink_3074457345616682180_alt");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Select Products is NOT Displayed - For Verify Select Products");
			rpt.Fail("Select Products Page is NOT Displayed - For Verify Select Products");
			rpt.Category("CC_Previously Viewed - Verify Select Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		/*
		 * click(
		 * "xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722799_link_9b']"
		 * ); browser.navigate().back();
		 * 
		 * click(
		 * "xpath=/html/body/div[3]/div[3]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div/a/img]"
		 * ); browser.navigate().back();
		 */
		Thread.sleep(30000);

		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Add Product To Compare",
					"Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Pass("Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previous Viewed - Verify Add Product To Compare ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Add Product To Compare is NOT Displayed - For Verify Add Product To Compare");
			rpt.Fail("Add Product To Compare Page is NOT Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previously Viewed - Verify Add Product To Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		String beforeComparep1 = getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722799_link_9b']");
		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);

		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Add Product To Compare",
					"Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Pass("Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previous Viewed - Verify Add Product To Compare ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label");
		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Add Product To Compare is NOT Displayed - For Verify Add Product To Compare");
			rpt.Fail("Add Product To Compare Page is NOT Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previously Viewed - Verify Add Product To Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		String beforecomparep2 = getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616731405_link_9b']");
		Thread.sleep(2000);
		//click("xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Compare Previously Viewed",
					"Compare Previously Viewed Displayed - For Verify Compare Previously Viewed");
			rpt.Pass("Compare Previously Viewed Displayed - For Verify Compare Previously Viewed");
			rpt.Category("CC_Previous Viewed - Verify Compare Previously Viewed ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Compare Previously Viewed is NOT Displayed - For Verify Compare Previously Viewed");
			rpt.Fail("Compare Previously Viewed Page is NOT Displayed - For Verify Compare Previously Viewed");
			rpt.Category("CC_Previously Viewed - Verify Compare Previouslt Viewed");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}


		String AftrerComparep1 = getText("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div[4]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div[2]");
		String AftrerComparep2 = getText("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div[4]/div/div/div[1]/div[2]/div/div[3]/div/div[3]/div[2]");
		if (beforeComparep1.equals(AftrerComparep1)
				&& beforecomparep2.equals(AftrerComparep2)) {
			System.out.println("Compare is working Fine And Passed");

		} else {
			System.out.println("Compare Functionality Failed");
		}
	}

	
	// CC_PV_06
	public void loveIt() throws Exception {
		//Thread.sleep(30000);
//		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
//		if (findTheElement(
//				"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
//				.isDisplayed()) {
//			rpt.createTest("CC - Previous Viewed - Verify Products",
//					"Products Displayed - For Verify Products");
//			rpt.Pass("Products Displayed - For Verify Products");
//			rpt.Category("CC_Previous Viewed - Verify Products ");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
//
//		} else {
//			rpt.createTest("CC - Previous Viewed - Verify Products",
//					"Products is NOT Displayed - For Verify Products");
//			rpt.Fail("Products Page is NOT Displayed - For Verify Products");
//			rpt.Category("CC_Previously Viewed - Verify Products");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//
//		//click("id=departmentLink_3074457345616682180_alt");
//		if (findTheElement(
//				"id=departmentLink_3074457345616682180_alt")
//				.isDisplayed()) {
//			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
//					"Selecting Products Displayed - For Verify Selecting Products");
//			rpt.Pass("Selecting Products Displayed - For Verify Selecting Products");
//			rpt.Category("CC_Previous Viewed - Verify Selecting Products ");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("id=departmentLink_3074457345616682180_alt");
//
//		} else {
//			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
//					"Selecting Products is NOT Displayed - For Verify Selecting Products");
//			rpt.Fail("Selecting Products Page is NOT Displayed - For Verify Selecting Products");
//			rpt.Category("CC_Previously Viewed - Verify Selecting Products");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(30000);
//		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img");
//		if (findTheElement(
//				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img")
//				.isDisplayed()) {
//			rpt.createTest("CC - Previous Viewed - Verify Love It Functionality",
//					"Love It Functionality Displayed - For Verify Love It Functionality");
//			rpt.Pass("Love It Functionality Displayed - For Verify Love It Functionality");
//			rpt.Category("CC_Previous Viewed - Verify Love It Functionality ");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img");
//
//		} else {
//			rpt.createTest("CC - Previous Viewed - Verify Love It Functionality",
//					"Love It Functionality is NOT Displayed - For Verify Love It Functionality");
//			rpt.Fail("Love It Functionality Page is NOT Displayed - For Verify Love It Functionality");
//			rpt.Category("CC_Previously Viewed - Verify Love It Functionality");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
		
		//click("css=img.icon heartIcon");
		if (findTheElement(
				"xpath=//div/div[2]/div/div[2]/div/span/div[2]/div/a/span")
				.isDisplayed())
		{
			rpt.createTest("CC - Previous Viewed - Verify Love It",
					"Product is added to wishlist from previously viewed section - For Verify Love It");
			rpt.Pass("Product is added to wishlist from previously viewed section - For Verify Love It");
			rpt.Category("CC_Previous Viewed - Verify Love It ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("css=img.icon heartIcon");
			click("xpath=//div/div[2]/div/div[2]/div/span/div[2]/div/a/span");

		} else 
		{
			rpt.createTest("CC - Previous Viewed - Verify Love It",
					"Product NOT added to wishlist from previously viewed section - For Verify Love It");
			rpt.Fail("Product NOT added to wishlist from previously viewed section - For Verify Love It");
			rpt.Category("CC_Previously Viewed - Verify Love It");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("link=WISHLIST");
		Thread.sleep(2000);
		click("link=Remove");
		Thread.sleep(2000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping");
		Thread.sleep(2000);
		click("id=widget_minishopcart");
		Thread.sleep(2000);
		click("id=GotoCartButton1");
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
		Thread.sleep(2000);
		 click("id=myAccountQuickLink");
		   Thread.sleep(2000);
		   click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	}

	
	// //TC -03
	public void shopNow() throws Exception {
		Thread.sleep(30000);
//		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
//				if (findTheElement(
//						"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
//						.isDisplayed()) {
//					rpt.createTest("CC - Previous Viewed - Verify Products",
//							"Products Displayed - For Verify Products");
//					rpt.Pass("Products Displayed - For Verify Products");
//					rpt.Category("CC_Previous Viewed - Verify Products ");
//					String path = rpt.CaptureScreen(browser, "ValidMessage");
//					rpt.imgPathPass(path);
//					click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
//
//				} else {
//					rpt.createTest("CC - Previous Viewed - Verify Products",
//							"Products is NOT Displayed - For Verify Products");
//					rpt.Fail("Products Page is NOT Displayed - For Verify Products");
//					rpt.Category("CC_Previously Viewed - Verify Products");
//					String path = rpt.CaptureScreen(browser, "InvalidMessage");
//					rpt.imgPathFail(path);
//				}
//
//				//click("id=departmentLink_3074457345616682180_alt");
//				if (findTheElement(
//						"id=departmentLink_3074457345616682180_alt")
//						.isDisplayed()) {
//					rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
//							"Selecting Products Displayed - For Verify Selecting Products");
//					rpt.Pass("Selecting Products Displayed - For Verify Selecting Products");
//					rpt.Category("CC_Previous Viewed - Verify Selecting Products ");
//					String path = rpt.CaptureScreen(browser, "ValidMessage");
//					rpt.imgPathPass(path);
//					click("id=departmentLink_3074457345616682180_alt");
//
//				} else {
//					rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
//							"Selecting Products is NOT Displayed - For Verify Selecting Products");
//					rpt.Fail("Selecting Products Page is NOT Displayed - For Verify Selecting Products");
//					rpt.Category("CC_Previously Viewed - Verify Selecting Products");
//					String path = rpt.CaptureScreen(browser, "InvalidMessage");
//					rpt.imgPathFail(path);
//				}
//		Thread.sleep(30000);
		//click("xpath=//*[@id='listViewAdd2Cart_3074457345616722799']");
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_image']");
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Creative')]"); //product
		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_image']");
		Thread.sleep(3000);
		//click("id=id=contentImage_1_HeaderStoreLogo_Content");
		browser.navigate().back();
		Thread.sleep(3000);
		
		if (findTheElement(
				"xpath=//a[contains(text(),'BUY NOW')]")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Shop Now",
					"Product is added to cart from previously viewed section - For Verify Shop Now");
			rpt.Pass("Product is added to cart from previously viewed section - For Verify Shop Now");
			rpt.Category("CC_Previous Viewed - Verify Shop Now ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//a[contains(text(),'BUY NOW')]");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Shop Now",
					"Product NOT added to cart from previously viewed section - For Verify Shop Now");
			rpt.Fail("Product NOT added to cart from previously viewed section - For Verify Shop Now");
			rpt.Category("CC_Previously Viewed - Verify Shop Now");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		click("id=MiniShopCartCloseButton_2"); 
		
		
	}
	//tc-04
	public void addToComapre()throws Exception
	{
		//click("xpath=//div[@class='product_option']//label[contains(text(),'Compare')]");
		//click("css=div.compare_target compare_target_hidden");
		//click("xpath=//div/div[2]/div[7]/label");
		if (findTheElement(
				"xpath=//div/div[2]/div[7]/label")
				.isDisplayed())
		{
			rpt.createTest("CC - Previous Viewed - Verify Add To Comapre",
					"Product is added to comapre from previously viewed section - For Verify Add To Comapre");
			rpt.Pass("Product is added to comapre from previously viewed section - For Verify Add To Comapre");
			rpt.Category("CC_Previous Viewed - Verify Add To Comapre ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div/div[2]/div[7]/label");

		} else 
		{
			rpt.createTest("CC - Previous Viewed - Verify Add To Comapre",
					"Product NOT added to comapre from previously viewed section - For Verify Add To Comapre");
			rpt.Fail("Product NOT added to comapre from previously viewed section - For Verify Add To Comapre");
			rpt.Category("CC_Previously Viewed - Verify Add To Comapre");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//tc-05
		jse.executeScript("window.scrollBy(0,90)");
		Thread.sleep(2000);
		click("xpath=//div[2]/div/div[2]/div[7]/label");
		Thread.sleep(2000);
		click("id=stickyCompare");
		Thread.sleep(2000);
		String title=Browser.getTitle();
		System.out.println(title);
		
		if(title.contains("Circuit City - Compare Products"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CC - Previous Viewed", "Compare from Previously Viewed section is navigated to Comapare Products page : " +title);
	         rpt.Pass("Compare from Previously Viewed section is navigated to Comapare Products page : " +title);
	         rpt.Category("CC - Previous Viewed");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CC - Previous Viewed", "Compare from Previously Viewed section NOT navigated to Comapare Products page");
	         rpt.Fail("Compare from Previously Viewed section NOT navigated to Comapare Products page");
	         rpt.Category("CC - Previous Viewed");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=compareBackLink");
		Thread.sleep(2000);
	}

}
