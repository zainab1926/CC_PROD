package Test;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class PDPModule extends Browser {
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;
	Report rpt = new Report();
	Browser br = new Browser();
	CommonUtils email = new CommonUtils();
	String name=email.getRandomString(6);
	String nickname=email.getRandomString(6);
	String wishlist=email.getRandomString(6);
	String recipient = email.getRandomString(6)+"@test.com";
	String sender = email.getRandomString(6)+"@test.com";
	String sender_name=email.getRandomString(6);
	String location="120 Greenwich St, New York";
	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void executeAll() throws Exception 
	{
		Login();
		verifyPDpage();
//		chk_UISection();// UI 
		addToCart_PD();
		addToWishlist_PD();
		editQuantity();
		verifyBreadcrumb();
		verifyMiniCart();
		pdImageZoom();
		sendMail_Share();
		verifyColorOption();
		verifyinWishlistPage(); //TC 23
		nearImage(); //tc 28
		onImage(); //to ask for test data 
		addImage();
		
		//verifyPriceDetails(); out of scope
		
		verifyCategoryandProductHighlights();
		verifyTradeinCashAndPriceMatch();
		verifyTabs();
		VerifyWriteReviews();
	

	}
   public void Login()throws Exception
   {
	   click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "user@test.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "Royalcyber1");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
		//click("xpath=html/body/div[2]/div[1]/div[2]/div[2]/div[4]/ul/li[3]/a[1]");
		Thread.sleep(6000);
//		click("xpath=.//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
		click("xpath=//a[contains(text(),'My Account')]"); //my acc
   }


	// Step_to_PD_Page
	public void verifyPDpage() throws Exception {
		 Thread.sleep(3000);
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Appliances");//categories
		 Thread.sleep(3000);
		click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']");
		 Thread.sleep(3000);
//		Robot r = new Robot();
//		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
//		Thread.sleep(3000);
//		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
//		Thread.sleep(3000);
//		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
//		Thread.sleep(3000);
//		Screen s = new Screen();
//		Thread.sleep(6000);
//		Pattern img = new Pattern("C:\\Projects\\Circuit City\\CC\\Screenshots\\skl_pd_click.png");
//		Thread.sleep(5000);
//		s.click(img);
		// click("xpath=//img[@href=\'https://my14.digitalexperience.ibm.com/api/217849ca-8c55-4fae-922a-9abba9366cf1/delivery/v1/resources/58530a7d-1945-4513-8852-a67a60f987e7\']");
		//click("xpath=/html/body/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/div[3]");
		// Thread.sleep(3000);
	}

	// CC_PD_01
	public void chk_UISection() throws Exception {
		Map<String, String> ids = new HashMap<String, String>();
		ids.put("Name", "PageHeading_3074457345618265621");
		ids.put("Price", "offerPrice_3074457345616726692");
		ids.put("Description", "pdp-tab-default");
		ids.put("Add to Cart", "add2CartBtn");
		ids.put("Add to Wishlist", "3074457345616726692addToShoppingList");
		for (Map.Entry<String, String> id : ids.entrySet()) {
			if (findTheElement("xpath=//*[@id='" + id.getValue() + "']").isDisplayed()) {
				rpt.createTest("CC-PDP Module -Check UI section",
						"Message :" + id.getKey() + " Displayed - For UI section");
				rpt.Pass("Message :" + id.getKey() + " Displayed - For UI section");
				rpt.Category("CC_PDP Module -Check UI section");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);

			} else {
				rpt.createTest("CC-PDP Module -Check UI section",
						"Message :" + id.getKey() + "is NOT Displayed - For UI section");
				rpt.Pass("Message :" + id.getKey() + " NOT Displayed - For UI section");
				rpt.Category("CC_PDP Module -Check UI section");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);

			}
		}
	}

	// CC_PD_02
	public void addToCart_PD() throws Exception {
		Thread.sleep(5000);
		// click("id=add2CartBtn");
		if (findTheElement("id=add2CartBtn").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Add Product to cart",
					"Add_TO_Cart Button Displayed - Adding Product to cart");
			rpt.Pass("Add_TO_Cart Button Displayed - Adding Product to cart");
			rpt.Category("CC - PDP Module - Add Products to cart");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=add2CartBtn");
		} else {
			rpt.createTest("CC - PDP Module - Add Products to cart",
					"Add_TO_Cart Button Displayed - Adding Product to cart");
			rpt.Fail("Add_TO_Cart Button not Displayed - Adding Product to cart");
			rpt.Category("CC - PDP Module - Add Products to cart");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("id=GotoCartButton2");
		Thread.sleep(3000);
		click("id=WC_OrderItemDetailsf_links_2_1");
		Thread.sleep(3000);
		browser.navigate().back();
		browser.navigate().back();
		Thread.sleep(4000);
		//waitForPageElementToBeDisplayed("id=widget_product_image_viewer_2_-3021_3074457345618265628");

	}

	// CC_PD_03,4
	public void addToWishlist_PD() throws Exception {
		Thread.sleep(2000);
		// click("id=3074457345616726692addToShoppingList");
		if (findTheElement("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div/a/img").isDisplayed()) {
			Thread.sleep(2000);
			rpt.createTest("CC - PDP Module - Add Product to Wishlist",
					"Add_TO_Wishlist Button Displayed - Adding Product to Wishlist");
			rpt.Pass("Add_TO_Wishlist Button Displayed - Adding Product to Wishlist");
			rpt.Category("CC - PDP Module - Add Products to Wishlist");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div/a/img");
		} else {
			rpt.createTest("CC - PDP Module - Add Products to Wishlist",
					"Add_TO_Wishlist Button not Displayed - Adding Product to Wishlist");
			rpt.Fail("Add_TO_Wishlist Button not Displayed - Adding Product to Wishlist");
			rpt.Category("CC - PDP Module - Add Products to Wishlist");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("link=WISHLIST");
		Thread.sleep(3000);
//		click("link=Remove");
//		Thread.sleep(2000);
//		click("id=shoppingListCreateSuccessPopup_continue_shopping");
		
//		 click("id=allDepartmentsButton"); // Select Products
//		 Thread.sleep(3000);
//		 click("link=Appliances");//categories
//		 Thread.sleep(3000);
//		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']");
//		 Thread.sleep(3000);
//		 click("xpath=//div[2]/div/a[2]/img");
//		Thread.sleep(2000);
//		 click("link=Create a new Wish List");
//		Thread.sleep(2000);
//		 sendKeys("id=newListName",wishlist);
//		 click("xpath=//div[3]/div/div/div/div[3]/div/a/span"); //save
//		Thread.sleep(2000);
//		 click("id=shoppingListCreateSuccessPopup_continue_shopping");
		//Thread.sleep(2000);
		//jse.executeScript("window.scrollBy(4000,0)");
		Thread.sleep(2000);
		click("xpath=//*[@id='multipleWishlistController_link_create']"); 
		Thread.sleep(2000);
		click("xpath=//*[@id='newListName']");
		sendKeys("xpath=//*[@id='newListName']",wishlist);
		Thread.sleep(2000);
		click("xpath=//*[@id='CreateShoppingListPopup_div_create_save']"); //save
		Thread.sleep(2000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping"); //continue shopping pop up
		Thread.sleep(2000);
//		 click("link=Remove");
//		 Thread.sleep(2000);
//			click("id=shoppingListCreateSuccessPopup_continue_shopping");
//			Thread.sleep(2000);
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Appliances");//categories
		 Thread.sleep(3000);
		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']");
		 Thread.sleep(2000);
		 click("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div/a[2]");
		Thread.sleep(2000);
		 //click("xpath=//a[contains(text(),'wishlist')]");
		 if (findTheElement("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div[2]/div/div/div").isDisplayed()) {
				rpt.createTest("CC - PDP Module - Add Product to Wishlist",
						"New wishlist is created and product is added to new wishlist - Adding Product to Wishlist");
				rpt.Pass("New wishlist is created and product is added to new wishlist - Adding Product to Wishlist");
				rpt.Category("CC - PDP Module - Add Products to Wishlist");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div[2]/div/div/div");
			} else {
				rpt.createTest("CC - PDP Module - Add Products to Wishlist",
						"New wishlist NOT created and product NOT added to new wishlist - Adding Product to Wishlist");
				rpt.Fail("New wishlist NOT created and product NOT added to new wishlist - Adding Product to Wishlist");
				rpt.Category("CC - PDP Module - Add Products to Wishlist");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		Thread.sleep(2000);
		 click("link=WISHLIST");
			Thread.sleep(3000);
//			click("link=Remove");
//			Thread.sleep(2000);
//			click("id=shoppingListCreateSuccessPopup_continue_shopping");
//			Thread.sleep(2000);
			click("link=DELETE");
			Thread.sleep(2000);
			click("id=deleteShoppingListPopup_div_delete_yes");
			Thread.sleep(2000);
			click("xpath=//a[@id='shoppingListCreateSuccessPopup_continue_shopping']/div[2]");
			Thread.sleep(2000);
			click("link=Remove");
			Thread.sleep(2000);
			click("id=shoppingListCreateSuccessPopup_continue_shopping");
			Thread.sleep(2000);
	}

	// CC_PD_06
	public void editQuantity() throws Exception {
		Thread.sleep(2000);
		browser.navigate().back();
		Thread.sleep(2000);
		// click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[1]");
		if (findTheElement("xpath=//div[6]/div/div").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Increase Quantity",
					"Quantity_plus Button Displayed - Increase Quantity");
			rpt.Pass("Quantity_plus Button Displayed - Increase Quantity");
			rpt.Category("CC - PDP Module - Increase Quantity");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[6]/div/div");
		} else {
			rpt.createTest("CC - PDP Module - Increase Quantity",
					"Quantity_plus Button Displayed - Increase Quantity");
			rpt.Fail("Quantity_plus Button not Displayed - Increase Quantity");
			rpt.Category("CC - PDP Module - Increase Quantity");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[2]");
		if (findTheElement("xpath=//div[6]/div/div[2]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Decrease Quantity",
					"Quantity_minus Button Displayed - Decrease Quantity");
			rpt.Pass("Quantity_minus Button Displayed - Decrease Quantity");
			rpt.Category("CC - PDP Module - Decrease Quantity");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[6]/div/div[2]");
		} else {
			rpt.createTest("CC - PDP Module - Decrease Quantity",
					"Quantity_minus Button Displayed - Decrease Quantity");
			rpt.Fail("Quantity_minus Button not Displayed - Decrease Quantity");
			rpt.Category("CC - PDP Module - Decrease Quantity");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		findTheElement("xpath=//div[6]/input").clear();
		Thread.sleep(2000);
		 sendKeys("xpath=//div[6]/input","3");
		Thread.sleep(2000);
		 click("id=add2CartBtn");
		 Thread.sleep(2000);
		 click("id=MiniShopCartCloseButton_2"); //closing mini cart
		Thread.sleep(2000);
	}

	// CC_PD_08
	public void verifyBreadcrumb() throws Exception {
		
		String text=findTheElement("xpath=//div[@id='widget_breadcrumb']/ul").getText();
		System.out.println(text);
		if (findTheElement("xpath=//div[@id='widget_breadcrumb']/ul").isDisplayed()) {
			rpt.createTest("CC - PDP Module : Verify Breadcrumb",
					"Breadcrumb is displayed ");
			rpt.Pass("Breadcrumb is displayed ");
			rpt.Category("CC - PDP Module : Verify Breadcrumb");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("id=WC_BreadCrumb_Link_2_2_-3028_3074457345618265627");
		} else {
			rpt.createTest("CC - PDP Module : Verify Breadcrumb",
					"Breadcrumb NOT displayed ");
			rpt.Fail("Breadcrumb NOT displayed ");
			rpt.Category("CC - PDP Module : Verify Breadcrumb");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		if (findTheElement("xpath=(//a[contains(text(),'Appliances')])[3]").isDisplayed()) {
			rpt.createTest("CC - PDP Module : Verify Breadcrumb",
					"Breadcrumb is working properly,it navigated to the category page ");
			rpt.Pass("Breadcrumb is working properly,it navigated to the category page ");
			rpt.Category("CC - PDP Module : Verify Breadcrumb");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("id=WC_BreadCrumb_Link_2_2_-3028_3074457345618265627");
		} else {
			rpt.createTest("CC - PDP Module : Verify Breadcrumb",
					"Breadcrumb NOT working properly,it navigated to the category page ");
			rpt.Fail("Breadcrumb NOT working properly,it navigated to the category page ");
			rpt.Category("CC - PDP Module : Verify Breadcrumb");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		browser.navigate().back();

	}

	// CC_PD_10
	public void verifyMiniCart() throws Exception {
//		click("id=productPageAdd2Cart");
//		Thread.sleep(2000);
//		click("id=MiniShopCartCloseButton_2");
//		Thread.sleep(3000);
//		click("id=widget_minishopcart");
//		Thread.sleep(5000);
//		Map<String, String> ids = new HashMap<String, String>();
//		ids.put("Product Name", "MiniShopCartProdName_1060431");// Keeponchanging
//		ids.put("Product Image", "MiniShopCartProdImg_1060431");
//		ids.put("Go to Cart", "GotoCartButton1");
//		for (Map.Entry<String, String> id : ids.entrySet()) {
//			if (findTheElement("xpath=//*[@id='" + id.getValue() + "']").isDisplayed()) {
//				rpt.createTest("CC-PDP Module -Check MiniCart",
//						"Message :" + id.getKey() + " Displayed - For MiniCart - UI section");
//				rpt.Pass("Message :" + id.getKey() + " Displayed - For MiniCart - UI section");
//				rpt.Category("CC_PDP Module -Check MiniCart");
//				String path = rpt.CaptureScreen(browser, "ValidMessage");
//				rpt.imgPathPass(path);
//
//			} else {
//				rpt.createTest("CC-PDP Module -Check MiniCart",
//						"Message :" + id.getKey() + "is NOT Displayed - For MiniCart - UI section");
//				rpt.Pass("Message :" + id.getKey() + " NOT Displayed - For MiniCart - UI section");
//				rpt.Category("CC_PDP Module -Check MiniCart");
//				String path = rpt.CaptureScreen(browser, "InvalidMessage");
//				rpt.imgPathFail(path);
//			}
//		}
//		Thread.sleep(2000);
//		if (findTheElement("xpath=//*[@class=\'subtotal\']").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Check MiniCart",
//					"Subtotal_Div Button Displayed - Check MiniCart");
//			rpt.Pass("Subtotal_Div Button Displayed - Check MiniCart");
//			rpt.Category("CC - PDP Module - Check MiniCart");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Check MiniCart",
//					"Subtotal_Div Displayed - Check MiniCart");
//			rpt.Fail("Subtotal_Div Button not Displayed - Check MiniCart");
//			rpt.Category("CC - PDP Module - Check MiniCart");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
		Thread.sleep(3000);
		click("id=SimpleSearchForm_SearchTerm");
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		 click("id=autoSelectOption_0");
		 Thread.sleep(3000);
		// click("xpath=(//a[contains(text(),'BUY NOW')])[6]");
		 if (findTheElement("xpath=(//a[contains(text(),'BUY NOW')])[6]").isDisplayed()) {
				rpt.createTest("CC - PDP Module - Check MiniCart",
						"Product is added to cart from recommended accessories - Check MiniCart");
				rpt.Pass("Product is added to cart from recommended accessories - Check MiniCart");
				rpt.Category("CC - PDP Module - Check MiniCart");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=(//a[contains(text(),'BUY NOW')])[6]");
			} else {
				rpt.createTest("CC - PDP Module - Check MiniCart",
						"Product NOT added to cart from recommended accessories - Check MiniCart");
				rpt.Fail("Product NOT added to cart from recommended accessories - Check MiniCart");
				rpt.Category("CC - PDP Module - Check MiniCart");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 Thread.sleep(3000);
		 //click("id=MiniShopCartCloseButton_2");
		 Thread.sleep(2000);
		 click("id=add2CartBtn");
		 Thread.sleep(3000);
		 click("id=MiniShopCartCloseButton_2");
		 Thread.sleep(2000);
//		 click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b"); //remove
//		 Thread.sleep(2000);
	}

	// CC_PD_11
	public void pdImageZoom() throws Exception {

		Thread.sleep(3000);
		click("xpath=//div[@id='surround']/img");
		//click("id=productMainImage_3074457345616726692");
		// click("id=productMainImage_zoomedOut");
		if (findTheElement("id=productMainImage_zoomedOut").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Zoom product image(Zoom in)",
					"Product_image is Zoomed in - Verify Zoom product image(Zoom in)");
			rpt.Pass("Product_image is Zoomed in - Verify Zoom product image(Zoom in)");
			rpt.Category("CC - PDP Module -Verify Zoom product image(Zoom in)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=productMainImage_zoomedOut");
			
		} else {
			rpt.createTest("CC - PDP Module - Verify Zoom product image(Zoom in)",
					"Product_image is Zoomed in -Verify Zoom product image(Zoom in)");
			rpt.Fail("Product_image is not Zoomed in - Verify Zoom product image(Zoom in)");
			rpt.Category("CC - PDP Module - Verify Zoom product image(Zoom in)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		// click("id=productMainImage_zoomedIn");
		if (findTheElement("id=productMainImage_zoomedIn").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Zoom product image(Zoom out)",
					"Product_image is Zoomed out - Verify Zoom product image(Zoom out)");
			rpt.Pass("Product_image is Zoomed out - Verify Zoom product image(Zoom out)");
			rpt.Category("CC - PDP Module -Verify Zoom product image(Zoom out)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=productMainImage_zoomedIn");
		} else {
			rpt.createTest("CC - PDP Module - Verify Zoom product image(Zoom out)",
					"Product_image is Zoomed out -Verify Zoom product image(Zoom out)");
			rpt.Fail("Product_image is not Zoomed out - Verify Zoom product image(Zoom out)");
			rpt.Category("CC - PDP Module - Verify Zoom product image(Zoom out)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=closeButton");
		Thread.sleep(2000);
		click("id=GotoCartButtonTemp");
		 Thread.sleep(2000);
		 click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b"); //remove
		 Thread.sleep(2000);
	}

	// CC_PD_15
	public void sendMail_Share() throws Exception {
		 Thread.sleep(2000);
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Appliances");//categories
		 Thread.sleep(3000);
		click("xpath=//div[@class='product_listing_container']//li[3]/.//div[@class='product_name']");
		 Thread.sleep(3000);
		click("link=Share");
		if (findTheElement("xpath=//a[@id='email-friend-link']/i").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Share button with options is displayed - Verify Share/send Mail");
			rpt.Pass("Share button with options is displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module -Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//a[@id='email-friend-link']/i");
		} else {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Share button with options is displayed -Verify Share/send Mail");
			rpt.Fail("Share button with options is not displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module - Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("name=firstName");
		sendKeys("name=firstName", name);
		click("name=lastName");
		sendKeys("name=lastName", name);// sender
		Thread.sleep(1000);
		click("name=friend_firstName");
		sendKeys("name=friend_firstName", sender_name);
		click("name=friend_lastName");
		sendKeys("name=friend_lastName", name);// Recipient
		Thread.sleep(1000);
		click("id=pdpToEmail");
		sendKeys("id=pdpToEmail", recipient);
		click("name=message");
		sendKeys("name=message", "Test");// emailandmessage
		Thread.sleep(4000);
		if (findTheElement("xpath=(//button[@type='button'])[12]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Send Button is displayed - Verify Share/send Mail");
			rpt.Pass("Send Button is displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module -Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=(//button[@type='button'])[12]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Send Button is displayed -Verify Share/send Mail");
			rpt.Fail("Send Button is not displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module - Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		// click("id=clickableErrorMessageImg");
//		if (findTheElement("id=clickableErrorMessageImg").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
//					"Mail_Sent is displayed - Verify Share/send Mail");
//			rpt.Pass("Mail_Sent is displayed - Verify Share/send Mail");
//			rpt.Category("CC - PDP Module -Verify Share/send Mail");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("id=clickableErrorMessageImg");
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
//					"Mail_Sent is displayed -Verify Share/send Mail");
//			rpt.Fail("Mail_Sent is not displayed - Verify Share/send Mail");
//			rpt.Category("CC - PDP Module - Verify Share/send Mail");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
		Thread.sleep(2000);
	}

	// CC_PD_12,13,36
	public void verifyColorOption() throws Exception {
		Thread.sleep(3000);
		sendKeys("id=SimpleSearchForm_SearchTerm","Tripp Lite P568-006-RA 6FT HDMI CABLE RIGHT ANGLE HD");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);

		// click("id=attrValue_Color_entitledItem_3074457345616721769-button");
		if (findTheElement("xpath=//div[3]/div[4]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Color option",
					"Appropriate color is changed - Verify Color option");
			rpt.Pass("Appropriate color is changed - Verify Color option");
			rpt.Category("CC - PDP Module -Verify Color option");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//img[@alt='Black']");
		} else {
			rpt.createTest("CC - PDP Module - Verify Color option",
					"Appropriate color NOT changed -Verify Color option");
			rpt.Fail("Appropriate color NOT changed - Verify Color option");
			rpt.Category("CC - PDP Module - Verify Color option");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
//		Robot r = new Robot();
//		Thread.sleep(3000);
//		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
//		Thread.sleep(2000);
//		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
//		r.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(4000);
//		// CC_PD_13
//		if (findTheElement("xpath=//*[@class=\'in-stock\']").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Color option", "In_stock is displayed - Verify Color option");
//			rpt.Pass("In_stock is displayed - Verify Color option");
//			rpt.Category("CC - PDP Module -Verify Color option");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Color option", "In_stock is displayed -Verify Color option");
//			rpt.Fail("In_stock is not displayed - Verify Color option");
//			rpt.Category("CC - PDP Module - Verify Zoom Color option");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
		Thread.sleep(2000);
		//browser.navigate().back();
		click("id=widget_minishopcart");
		Thread.sleep(2000);
		click("id=GotoCartButton1");
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
		Thread.sleep(2000);
		//click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_2']/b");
		//Thread.sleep(2000);
	}

	// CC_PD_22,23
	public void verifyinWishlistPage() throws Exception {
//		Robot r = new Robot();
//		r.keyPress(KeyboardEvent.DOM_VK_PAGE_UP);
//		Thread.sleep(2000);
//		r.keyPress(KeyboardEvent.DOM_VK_PAGE_UP);
//		Thread.sleep(2000);
//		click("id=3074457345616726692addToShoppingList");
//		Thread.sleep(2000);
		click("id=wishListQuickLink_alt");
		Thread.sleep(2000);
		click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Appliances");//categories
		 Thread.sleep(3000);
		click("xpath=//div[@class='product_listing_container']//li[4]/.//div[@class='product_name']");
		 Thread.sleep(3000);
		 click("xpath=//div[4]/div[2]/div/div/div/span/div[2]/div/a/img");
		 Thread.sleep(2000);
		 click("id=wishListQuickLink_alt");
		 Thread.sleep(3000);
		//String id_pdt = findTheElement("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616726693_link_9b")
				//.getText();
		if (findTheElement("id=box").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Product in Wishlist",
					"Product is displayed - Verify Product in Wishlist");
			rpt.Pass("Product is displayed - Verify Product in Wishlist");
			rpt.Category("CC - PDP Module -Verify Product in Wishlist");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Product in Wishlist",
					"Product is displayed -Verify Product in Wishlist");
			rpt.Fail("Product is not displayed - Verify Product in Wishlist");
			rpt.Category("CC - PDP Module - Verify Product in Wishlist");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		//click("xpath=//div[@id='WC_WishListResultDisplay_div_5']/ul/li/div[2]/div[3]/div/a");
		Thread.sleep(2000);
//		click("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616726693_link_9b");
//		Thread.sleep(4000);
//		click("xpath=//[@class=\'top namePartPriceContainer\']");
//		String vfy = findTheElement("xpath=//*[@class=\'main_header\']").getText();
//		if (vfy.equals("3M PF170C4B 17.0 Gold Privacy Filter")) {
//			rpt.createTest("CC - PDP Module - Verify Product in Wishlist",
//					"Product is matched - Verify Product from Wishlist");
//			rpt.Pass("Product is matched - Verify Product from Wishlist");
//			rpt.Category("CC - PDP Module -Verify Product from Wishlist");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Product from Wishlist",
//					"Product is matched -Verify Product from Wishlist");
//			rpt.Fail("Product is not matched - Verify Product from Wishlist");
//			rpt.Category("CC - PDP Module - Verify Product from Wishlist");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
		if (findTheElement("xpath=//div[@id='WC_WishListResultDisplay_div_5']/ul/li/div[2]/div[3]/div/a").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Navigation to PDP",
					"Navigated to PDP page from wishlist page - Verify Navigation to PDP");
			rpt.Pass("Navigated to PDP page from wishlist page - Verify Navigation to PDP");
			rpt.Category("CC - PDP Module -Verify Navigation to PDP");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[@id='WC_WishListResultDisplay_div_5']/ul/li/div[2]/div[3]/div/a");
		} else {
			rpt.createTest("CC - PDP Module - Verify Navigation to PDP",
					"NOT Navigated to PDP page from wishlist page -Verify Navigation to PDP");
			rpt.Fail("NOT Navigated to PDP page from wishlist page - Verify Navigation to PDP");
			rpt.Category("CC - PDP Module - Verify Navigation to PDP");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}
	//28
	public void nearImage()throws Exception
	{
    // click("xpath=//div[5]/div/a");
     if (findTheElement("xpath=//div[5]/div/a").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Near Image of Product",
					"Near image of product is displayed - Verify Near Image of Product");
			rpt.Pass("Near image of product is displayed - Verify Near Image of Product");
			rpt.Category("CC - PDP Module - Verify Near Image of Product");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[5]/div/a");
		} else {
			rpt.createTest("CC - PDP Module - Verify Near Image of Product",
					"Near image of product NOT displayed - Verify Near Image of Product");
			rpt.Fail("Near image of product NOT displayed - Verify Near Image of Product");
			rpt.Category("CC - PDP Module - Verify Near Image of Product");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
     Thread.sleep(2000);
     
	}
	//29
	public void onImage()throws Exception
	{
		sendKeys("id=SimpleSearchForm_SearchTerm","Antec ONE Gaming Case");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		 if (findTheElement("css=div.badges.onsale-badge").isDisplayed()) {
				rpt.createTest("CC - PDP Module - Verify On Image of Product",
						"On image of product(ON SALE) is displayed - Verify On Image of Product");
				rpt.Pass("On image of product(ON SALE) is displayed - Verify On Image of Product");
				rpt.Category("CC - PDP Module - Verify On Image of Product");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				//click("xpath=//div[5]/div/a");
			} else {
				rpt.createTest("CC - PDP Module - Verify On Image of Product",
						"On image of product(ON SALE) NOT displayed - Verify On Image of Product");
				rpt.Fail("On image of product(ON SALE) NOT displayed - Verify On Image of Product");
				rpt.Category("CC - PDP Module - Verify On Image of Product");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
	     Thread.sleep(2000);
		
		
	}
	public void addImage()throws Exception
	{
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		click("css=div.addPhoto");
		Thread.sleep(2000);
		
		String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		click("xpath=//div[@id='pr-rating']/div/div");
		click("xpath=//div[@id='pr-rating']/div/div[2]");
		click("xpath=//div[@id='pr-rating']/div/div[3]");
		click("xpath=//div[@id='pr-rating']/div/div[4]");
		
		sendKeys("id=pr-headline-input","good product");
		Thread.sleep(2000);
		sendKeys("id=pr-comments","no comments");
		Thread.sleep(2000);
		click("xpath=//div[@id='pr-bottomline']/div[2]/div");
		Thread.sleep(2000);
		sendKeys("id=pr-name-input",nickname);
		Thread.sleep(2000);
		sendKeys("id=pr-location-input",location);
		Thread.sleep(2000);
		//add photo TO ASK
		//click("xpath=//div[@id='pr-war-form']/fieldset/div[13]/div/label");
		WebElement uploadElement = findTheElement("xpath=//div[@id='pr-war-form']/fieldset/div[13]/div/label");
        uploadElement.sendKeys("D:\\CC_QA\\apple-laptop-500x500.xlsx");
		Thread.sleep(2000);
		
		click("xpath=//div[@type='submit']");
		Thread.sleep(5000);
	       browser.close(); 
	       browser.switchTo().window(parentWindow); 
		     }
		  }
	}
	
	
	// CC_PD_032
	public void verifyPriceDetails() throws Exception {
		Thread.sleep(3000);
		if (findTheElement("id=price_display_3074457345616726692").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Price Details",
					"Price Details is displayed - Verify Price Details");
			rpt.Pass("Price Details is displayed - Verify Price Details");
			rpt.Category("CC - PDP Module -Verify Price Details");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Price Details",
					"Price Details is displayed -Verify Price Details");
			rpt.Fail("Price Details is not displayed - Verify Price Details");
			rpt.Category("CC - PDP Module - Verify Price Details");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PD_36, CC_PD_40
	public void verifyCategoryandProductHighlights() throws Exception {
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		// CC_PD_36
		if (findTheElement("css=div.installation-charges_main").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Category Display",
					"Category Display for Installation is displayed - Verify Category Display");
			rpt.Pass("Category Display for Installation is displayed - Verify Category Display");
			rpt.Category("CC - PDP Module -Verify Category Display");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Category Display",
					"Category Display for Installation is not displayed -Verify Category Display");
			rpt.Fail("Category Display for Installation is not displayed - Verify Category Display");
			rpt.Category("CC - PDP Module - Verify Category Display");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		
		if (findTheElement("xpath=//div[@id='special_offer_bundle']/div/div[2]/div").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Category Display",
					"Category Display for Bundles is displayed - Verify Category Display");
			rpt.Pass("Category Display for Bundles is displayed - Verify Category Display");
			rpt.Category("CC - PDP Module -Verify Category Display");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Category Display",
					"Category Display for Bundles is not displayed -Verify Category Display");
			rpt.Fail("Category Display for Bundles is not displayed - Verify Category Display");
			rpt.Category("CC - PDP Module - Verify Category Display");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_PD_40
//		if (findTheElement("xpath=//*[@class=\'prodHighLightContainer\']").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Product_Highlights",
//					"Product_Highlightsis displayed - Verify Product_Highlights");
//			rpt.Pass("Product_Highlights is displayed - Verify Product_Highlights");
//			rpt.Category("CC - PDP Module -Verify Product_Highlights");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Product_Highlights",
//					"Product_Highlights is displayed -Verify Product_Highlights");
//			rpt.Fail("Product_Highlights is not displayed - Verify Product_Highlights");
//			rpt.Category("CC - PDP Module - Verify Product_Highlights");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//
//		if (findTheElement("xpath=//*[@class=\'whatsIncludedContainer\']").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Product includes element",
//					"Product includes element displayed - Verify Product includes element");
//			rpt.Pass("Product includes element is displayed - Verify Product includes element");
//			rpt.Category("CC - PDP Module -Verify Product includes element");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Product includes element",
//					"Product includes element is displayed -Verify Product includes element");
//			rpt.Fail("Product includes element is not displayed - Verify Product includes element");
//			rpt.Category("CC - PDP Module - Verify Product includes element");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
	}

	// cc_PD_42,43
	public void verifyTradeinCashAndPriceMatch() throws Exception {
		if (findTheElement("xpath=(//a[contains(text(),'Learn more')])[3]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Trade_in_for_cash",
					"Trade_in_for_cash displayed and navigating to respective page - Verify Trade_in_for_cash");
			rpt.Pass("Trade_in_for_cash is displayed and navigating to respective page - Verify Trade_in_for_cash");
			rpt.Category("CC - PDP Module -Verify Trade_in_for_cash");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=(//a[contains(text(),'Learn more')])[3]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Trade_in_for_cash",
					"Trade_in_for_cash NOT displayed and navigating to respective page - Verify Trade_in_for_cash");
			rpt.Fail("Trade_in_for_cash NOT displayed and navigating to respective page - Verify Trade_in_for_cash");
			rpt.Category("CC - PDP Module - Verify Trade_in_for_cash");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		browser.navigate().back();
		Thread.sleep(3000);
		if (findTheElement("css=a.priceMatchGurantee").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Price Match Guarantee",
					"Price Match Guarantee displayed - Verify Price Match Guarantee");
			rpt.Pass("Price Match Guarantee is displayed - Verify Price Match Guarantee");
			rpt.Category("CC - PDP Module -Verify Price Match Guarantee");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//a[@href=\"http://qalive.circuitcity.com/en/shop/pricematch\"]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Price Match Guarantee",
					"Price Match Guarantee is displayed -Verify Price Match Guarantee");
			rpt.Fail("Price Match Guarantee is not displayed - Verify Price Match Guarantee");
			rpt.Category("CC - PDP Module - Verify Price Match Guarantee");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		//Thread.sleep(4000);
		//browser.navigate().back();
		Thread.sleep(3000);
		
		//44
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		click("xpath=//div[3]/div[2]/div/ul/li");
		Thread.sleep(2000);
		//click("xpath=//ul[@id='be-select']/li[2]");
		if (findTheElement("xpath=//ul[@id='be-select']/li[2]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify  Add on warranty",
					" Add on warranty successful - Verify  Add on warranty");
			rpt.Pass("Add on warranty successful - Verify  Add on warranty");
			rpt.Category("CC - PDP Module -Verify  Add on warranty");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//ul[@id='be-select']/li[2]");
		} else {
			rpt.createTest("CC - PDP Module - Verify  Add on warranty",
					"Add on warranty NOT successful -Verify  Add on warranty");
			rpt.Fail("Add on warranty NOT successful - Verify  Add on warranty");
			rpt.Category("CC - PDP Module - Verify  Add on warranty");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//45
		if (findTheElement("css=div.upgrade-container").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify   Show step up product ",
					" Upgrade model displayed - Verify Show step up product ");
			rpt.Pass("Upgrade model displayed - Verify Show step up product ");
			rpt.Category("CC - PDP Module -Verify Show step up product ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//ul[@id='be-select']/li[2]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Show step up product ",
					"Upgrade model NOT displayed - Verify Show step up product ");
			rpt.Fail("Upgrade model NOT displayed - Verify  Show step up product ");
			rpt.Category("CC - PDP Module - Verify  Show step up product ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		
		//46
		sendKeys("id=SimpleSearchForm_SearchTerm","IOGEAR GKM681R Wireless Compact Keyboard");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		if (findTheElement("css=div.free-shipping").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Rebates availability ",
					" Rebates availability displayed - Verify Rebates availability");
			rpt.Pass("Rebates availability displayed - Verify Rebates availability");
			rpt.Category("CC - PDP Module -Verify Rebates availability ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//ul[@id='be-select']/li[2]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Rebates availability ",
					"Rebates availability NOT displayed - Verify Rebates availability ");
			rpt.Fail("Rebates availability NOT displayed - Verify Rebates availability");
			rpt.Category("CC - PDP Module - Verify Rebates availability ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
	}

	// CC_PD_49,51,56
	public void verifyTabs() throws Exception {
		click("id=tab1");
		Thread.sleep(2000);
		if (findTheElement("id=pdp-tab-default").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs displayed - Verify Tabs");
			rpt.Pass("Tabs is displayed(i.e overview, specs, QA, learn, accessories) - Verify Tabs");
			rpt.Category("CC - PDP Module -Verify Tabs");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs is displayed - Verify Tabs");
			rpt.Fail("Tabs is not displayed(i.e overview, specs, QA, learn, accessories) - Verify Tabs");
			rpt.Category("CC - PDP Module - Verify Tabs");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_PD_51
		click("id=tab3");
		Thread.sleep(2000);
		if (findTheElement("id=pr-review-display").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Reviews ", "Review Tab displayed - Verify Reviews ");
			rpt.Pass("Review Tab is displayed - Verify Reviews ");
			rpt.Category("CC - PDP Module -Verify Reviews ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify TReviews abs", "Review Tab is displayed - Verify Reviews ");
			rpt.Fail("Review Tab is not displayed - Verify Reviews ");
			rpt.Category("CC - PDP Module - Verify Reviews ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//52
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		if (findTheElement("css=div.recomm_access").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Recommended Accessories ", "Recommended Accessories displayed - Verify Recommended Accessories ");
			rpt.Pass("Recommended Accessories is displayed - Verify Recommended Accessories ");
			rpt.Category("CC - PDP Module -Verify Recommended Accessories ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Recommended Accessories", "Recommended Accessories is displayed - Verify Recommended Accessories ");
			rpt.Fail("Recommended Accessories is not displayed - Verify Recommended Accessories ");
			rpt.Category("CC - PDP Module - Verify Recommended Accessories ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//53
		if (findTheElement("xpath=//div[@id='hideMoreAccessory']/h4/span").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify See All Accessories ", "See All Accessories displayed - Verify See All Accessories ");
			rpt.Pass("See All Accessories is displayed - Verify See All Accessories ");
			rpt.Category("CC - PDP Module -Verify See All Accessories ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[@id='hideMoreAccessory']/h4/span");
		} else {
			rpt.createTest("CC - PDP Module - Verify See All Accessories", "See All Accessories is displayed - Verify See All Accessories ");
			rpt.Fail("See All Accessories is not displayed - Verify See All Accessories ");
			rpt.Category("CC - PDP Module - Verify See All Accessories ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		
		//54
		if (findTheElement("xpath=//div[3]/div[7]/div").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Customers Also Viewed ", "Customers Also Viewed displayed - Verify Customers Also Viewed ");
			rpt.Pass("Customers Also Viewed is displayed - Verify Customers Also Viewed ");
			rpt.Category("CC - PDP Module -Verify Customers Also Viewed ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//div[@id='hideMoreAccessory']/h4/span");
		} else {
			rpt.createTest("CC - PDP Module - Verify Customers Also Viewed", "Customers Also Viewed is displayed - Verify Customers Also Viewed ");
			rpt.Fail("Customers Also Viewed is not displayed - Verify Customers Also Viewed ");
			rpt.Category("CC - PDP Module - Verify Customers Also Viewed ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//55
		if (findTheElement("xpath=//a[@id='add2CartBtn_SPECIAL-OFFER']/div[2]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify  Buy together and save ", " Buy together and savedisplayed - Verify  Buy together and save ");
			rpt.Pass(" Buy together and save is displayed - Verify  Buy together and save ");
			rpt.Category("CC - PDP Module -Verify  Buy together and save");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//div[@id='hideMoreAccessory']/h4/span");
		} else {
			rpt.createTest("CC - PDP Module - Verify  Buy together and save", " Buy together and save NOT displayed - Verify  Buy together and save");
			rpt.Fail(" Buy together and save is not displayed - Verify  Buy together and save ");
			rpt.Category("CC - PDP Module - Verify  Buy together and save ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//56
		jse.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		click("xpath=//div[@class='accessory '][1]//label[contains(text(),'Compare')]"); //compare 
		Thread.sleep(2000);
		click("xpath=//div[@class='accessory '][2]//label[contains(text(),'Compare')]"); //compare
		Thread.sleep(2000);
		click("xpath=//div[@class='accessory '][3]//label[contains(text(),'Compare')]"); //compare
		Thread.sleep(2000);
		click("xpath=//div[2]/div[2]/div[3]/div[2]/div[4]/a");
		Thread.sleep(2000);
		String pagetitle=getTitle();
		System.out.println(pagetitle);
		Thread.sleep(2000);
		if (pagetitle.contains("Circuit City - Compare Products")) {
			rpt.createTest("CC - PDP Module - Verify Compare ", " Compare Product is navigating to respective page - Verify Compare ");
			rpt.Pass("Compare Product is navigating to respective page - Verify Compare ");
			rpt.Category("CC - PDP Module -Verify Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//div[@id='hideMoreAccessory']/h4/span");
		} else {
			rpt.createTest("CC - PDP Module - Verify Compare", " Compare Product NOT navigating to respective page - Verify Compare");
			rpt.Fail(" Compare Product NOT navigating to respective page - Verify  Compare ");
			rpt.Category("CC - PDP Module - Verify Compare ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=compareBackLink");
		Thread.sleep(2000);
		
		//57
		if (findTheElement("css=div.installation-charges_main").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify  Installation details ", " Installation details is displayed - Verify  Installation details ");
			rpt.Pass("Installation details is displayed - Verify  Installation details ");
			rpt.Category("CC - PDP Module -Verify  Installation details");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("xpath=//section[@id='pr-review-snapshot']/section/section/div[2]");
		} else {
			rpt.createTest("CC - PDP Module - Verify  Installation details", " Installation details NOT displayed - Verify  Installation details");
			rpt.Fail("Installation details NOT displayed - Verify  Installation details ");
			rpt.Category("CC - PDP Module - Verify  Installation details ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		
		//59
		if (findTheElement("xpath=//section[@id='pr-review-snapshot']/section/section/div[2]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify SEE REVIEWS ", " See Reviews is navigating to respective page - Verify SEE REVIEWS ");
			rpt.Pass("See Reviews is navigating to respective page - Verify SEE REVIEWS ");
			rpt.Category("CC - PDP Module -Verify SEE REVIEWS");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//section[@id='pr-review-snapshot']/section/section/div[2]");
		} else {
			rpt.createTest("CC - PDP Module - Verify SEE REVIEWS", " See Reviews NOT navigating to respective page - Verify SEE REVIEWS");
			rpt.Fail("See Reviews NOT navigating to respective page - Verify  SEE REVIEWS ");
			rpt.Category("CC - PDP Module - Verify SEE REVIEWS ");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		// CC_PD_56
		
//		click("id=tab4");
//		Thread.sleep(2000);
//		if (findTheElement("xpath=//*[@class=\'compare_main pdp-compare\']").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Compare_Widget",
//					"Compare_Widget displayed - Verify Compare_Widget");
//			rpt.Pass("Compare_Widget is displayed - Verify Compare_Widget");
//			rpt.Category("CC - PDP Module -Verify Compare_Widget");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Compare_Widget",
//					"Compare_Widget is displayed -Verify Compare_Widget");
//			rpt.Fail("Compare_Widget is not displayed - Verify Compare_Widget");
//			rpt.Category("CC - PDP Module - Verify Compare_Widget");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(3000);
	}

	// CC_PD_60
	public void VerifyWriteReviews() throws Exception {
		//click("id=tab3");
		Thread.sleep(2000);
		if (findTheElement(
				"link=WRITE A REVIEW")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Write_review_hyperlink",
					"Write_review_hyperlink displayed - Verify Write_review_hyperlink");
			rpt.Pass("Write_review_hyperlink is displayed - Verify Write_review_hyperlink");
			rpt.Category("CC - PDP Module -Verify Write_review_hyperlink");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("link=WRITE A REVIEW");
		} else {
			rpt.createTest("CC - PDP Module - Verify Write_review_hyperlink",
					"Write_review_hyperlink is not displayed -Verify Write_review_hyperlink");
			rpt.Fail("Write_review_hyperlink is not displayed - Verify Write_review_hyperlink");
			rpt.Category("CC - PDP Module - Verify Write_review_hyperlink");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);

//		if (findTheElement("id=pr-write").isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Product_review_Page",
//					"Product_review_Page navigated - Verify Product_review_Page");
//			rpt.Pass("Product_review_Page is navigated - Verify Product_review_Page");
//			rpt.Category("CC - PDP Module -Verify Product_review_Page");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Product_review_Page",
//					"Product_review_Page is navigated -Verify Product_review_Page");
//			rpt.Fail("Product_review_Page is not navigated - Verify Product_review_Page");
//			rpt.Category("CC - PDP Module - Verify Product_review_Page");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(3000);
//		browser.navigate().back();
		//Thread.sleep(4000);
		//61
		if (findTheElement(
				"id=pr-reviewdisplay-middle-images")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify customer image",
					"customer image displayed - Verify customer image");
			rpt.Pass("customer image is displayed - Verify customer image");
			rpt.Category("CC - PDP Module - Verify customer image");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//click("link=WRITE A REVIEW");
		} else {
			rpt.createTest("CC - PDP Module - Verify customer image",
					"customer image NOT displayed - Verify customer image");
			rpt.Fail("customer image is not displayed - Verify customer image");
			rpt.Category("CC - PDP Module - Verify customer image");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		
		//62
		if (findTheElement(
				"link=See All Images")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify see all images",
					"See all images is navigating to respective page - Verify see all images");
			rpt.Pass("See all images is navigating to respective page - Verify see all images");
			rpt.Category("CC - PDP Module - Verify see all images");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("link=See All Images");
		} else {
			rpt.createTest("CC - PDP Module - Verify see all images",
					"See all images NOT navigating to respective page - Verify see all images");
			rpt.Fail("See all images NOT navigating to respective page - Verify see all images");
			rpt.Category("CC - PDP Module - Verify see all images");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		
		//63,64
		if (findTheElement(
				"id=productPageAdd2Cart_SPECIAL-OFFER")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify special offer",
					"Special offer is working properly - Verify special offer");
			rpt.Pass("Special offer is working properly - Verify special offer");
			rpt.Category("CC - PDP Module - Verify special offer");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=productPageAdd2Cart_SPECIAL-OFFER");
		} else {
			rpt.createTest("CC - PDP Module - Verify special offer",
					"Special offer NOT working properly - Verify special offer");
			rpt.Fail("Special offer NOT working properly - Verify special offer");
			rpt.Category("CC - PDP Module - Verify special offer");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=MiniShopCartCloseButton_2");
		Thread.sleep(2000);
		
		//65
		
		if (findTheElement(
				"xpath=//div[2]/div/div[2]/div[3]/div[2]/div[3]/div/div[2]/a")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify product special offer",
					"Product from special offer is navigated to its PDP page - Verify product special offer");
			rpt.Pass("Product from special offer is navigated to its PDP page - Verify product special offer");
			rpt.Category("CC - PDP Module - Verify product special offer");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[2]/div/div[2]/div[3]/div[2]/div[3]/div/div[2]/a");
		} else {
			rpt.createTest("CC - PDP Module - Verify product special offer",
					"Product from special offer NOT navigated to its PDP page - Verify product special offer");
			rpt.Fail("Product from special offer NOT navigated to its PDP page - Verify product special offer");
			rpt.Category("CC - PDP Module - Verify product special offer");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		browser.navigate().back();
		Thread.sleep(2000);
		
		//66,67
		if (findTheElement(
				"css=div.smart_home_bundle")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify  Smart home bundle",
					"Smart Home bundle is displayed and working properly - Verify  Smart home bundle");
			rpt.Pass("Smart Home bundle is displayed and working properly - Verify  Smart home bundle");
			rpt.Category("CC - PDP Module - Verify  Smart home bundle");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=productPageAdd2Cart_SMART-HOME");
		} else {
			rpt.createTest("CC - PDP Module - Verify  Smart home bundle",
					"Smart Home bundle NOT displayed and working properly - Verify  Smart home bundle");
			rpt.Fail("Smart Home bundle NOT displayed and working properly - Verify  Smart home bundle");
			rpt.Category("CC - PDP Module - Verify  Smart home bundle");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
	}

	// CC_PD_45
//	public void verifyC_A_V() throws Exception {
//		if (findTheElement("xpath=//*[@id=\'ci_espot_3074457345618265623_PDP_TOP_BROWSED_ESPOT\']").isDisplayed()
//				&& findTheElement("xpath=/html/body/div[8]/div/div[3]/div[7]/div/div/div[2]/div[1]/div")
//						.isDisplayed()) {
//			rpt.createTest("CC - PDP Module - Verify Customer_Also_Viewed Element",
//					"Customer_Also_Viewed Element displayed - Verify Customer_Also_Viewed Element");
//			rpt.Pass("Customer_Also_Viewed Element is displayed - Verify Customer_Also_Viewed Element");
//			rpt.Category("CC - PDP Module -Verify Customer_Also_Viewed Element");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//		} else {
//			rpt.createTest("CC - PDP Module - Verify Customer_Also_Viewed Element",
//					"Customer_Also_Viewed Element is displayed -Verify Customer_Also_Viewed Element");
//			rpt.Fail("Customer_Also_Viewed Element is not displayed - Verify Customer_Also_Viewed Element");
//			rpt.Category("CC - PDP Module - Verify Customer_Also_Viewed Element");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
	
		
}
