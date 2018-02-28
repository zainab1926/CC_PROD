package Test;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class PDPModule extends Browser {

	Report rpt = new Report();
	Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void executeAll() throws Exception {
		Login();
		verifyPDpage();
		chk_UISection();
		editQuantity();
		addToCart_PD();
		addToWishlist_PD();
		verifyBreadcrumb();
		verifyMiniCart();
		pdImageZoom();
		sendMail_Share();
		verifyColorOption();
		verifyinWishlistPage();
		verifyPriceDetails();
		verifyCategoryandProductHighlights();
		verifyTradeinCashAndPriceMatch();
		verifyTabs();
		VerifyWriteReviews();
		verifyC_A_V();

	}

	public void Login() throws Exception {
		// Registering User
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		sendKeys(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input",
				"zainab.firdaus@royalcyber.com");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		sendKeys(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input",
				"zain@1926");
		click("id=Header_GlobalLogin_WC_AccountDisplay_links_2");// Signin Button
		Thread.sleep(8000);
		click("id=Header_GlobalLogin_signOutQuickLink");
		Thread.sleep(3000);
	}

	// Step_to_PD_Page
	public void verifyPDpage() throws Exception {
		Thread.sleep(3000);
		click("xpath=//*[@id='allDepartmentsButton']/span");
		click("xpath=//*[@id=\'departmentLink_3074457345616682173_alt\']");
		Thread.sleep(5000);
		waitForPageElementToLoad("xpath=//*[@class=\'product_listing_container\']");
		Robot r = new Robot();
		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyboardEvent.DOM_VK_PAGE_DOWN);
		Thread.sleep(3000);
		Screen s = new Screen();
		Thread.sleep(6000);
		Pattern img = new Pattern("C:\\Projects\\Circuit City\\CC\\Screenshots\\skl_pd_click.png");
		Thread.sleep(5000);
		s.click(img);
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
			rpt.Pass("Add_TO_Cart Button Displayed - FAdding Product to cart");
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
		Thread.sleep(2000);
		click("id=GotoCartButton2");
		Thread.sleep(3000);
		click("id=WC_OrderItemDetailsf_links_2_1");
		Thread.sleep(3000);
		browser.navigate().back();
		browser.navigate().back();
		Thread.sleep(4000);
		waitForPageElementToBeDisplayed("id=widget_product_image_viewer_2_-3021_3074457345618265628");

	}

	// CC_PD_03
	public void addToWishlist_PD() throws Exception {

		// click("id=3074457345616726692addToShoppingList");
		if (findTheElement("id=3074457345616726692addToShoppingList").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Add Product to Wishlist",
					"Add_TO_Wishlist Button Displayed - Adding Product to Wishlist");
			rpt.Pass("Add_TO_Wishlist Button Displayed - FAdding Product to Wishlist");
			rpt.Category("CC - PDP Module - Add Products to Wishlist");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=3074457345616726692addToShoppingList");
		} else {
			rpt.createTest("CC - PDP Module - Add Products to Wishlist",
					"Add_TO_Wishlist Button Displayed - Adding Product to Wishlist");
			rpt.Fail("Add_TO_Wishlist Button not Displayed - Adding Product to Wishlist");
			rpt.Category("CC - PDP Module - Add Products to Wishlist");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img");
		Thread.sleep(3000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping");
	}

	// CC_PD_06
	public void editQuantity() throws Exception {
		// click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[1]");
		if (findTheElement("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[1]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Change Quantity(Plus)",
					"Quantity_plus Button Displayed - Change Quantity(Plus)");
			rpt.Pass("Quantity_plus Button Displayed - Change Quantity(Plus)");
			rpt.Category("CC - PDP Module - Change Quantity(Plus)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[1]");
		} else {
			rpt.createTest("CC - PDP Module - Change Quantity(Plus)",
					"Quantity_plus Button Displayed - Change Quantity(Plus)");
			rpt.Fail("Quantity_plus Button not Displayed - Change Quantity(Plus)");
			rpt.Category("CC - PDP Module - Change Quantity(Plus)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[2]");
		if (findTheElement("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[2]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Change Quantity(Minus)",
					"Quantity_minus Button Displayed - Change Quantity(Minus)");
			rpt.Pass("Quantity_minus Button Displayed - Change Quantity(Minus)");
			rpt.Category("CC - PDP Module - Change Quantity(Minus)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[8]/div/div[2]/div[2]/div[5]/div[6]/div[1]/div[2]");
		} else {
			rpt.createTest("CC - PDP Module - Change Quantity(Minus)",
					"Quantity_minus Button Displayed - Change Quantity(Minus)");
			rpt.Fail("Quantity_minus Button not Displayed - Change Quantity(Minus)");
			rpt.Category("CC - PDP Module - Change Quantity(Minus)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		click("id=PDPquantity_3074457345616726692");
		// sendKeys("id=PDPquantity_3074457345616726692","1");
		if (findTheElement("id=PDPquantity_3074457345616726692").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Change Quantity(Manually)",
					"Quantity_textbox Button Displayed - Change Quantity(Manually)");
			rpt.Pass("Quantity_textbox Button Displayed - Change Quantity(Manually)");
			rpt.Category("CC - PDP Module - Change Quantity(Manually)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("id=PDPquantity_3074457345616726692", "1");
		} else {
			rpt.createTest("CC - PDP Module - Change Quantity(Manually)",
					"Quantity_textbox Displayed - Change Quantity(Manually)");
			rpt.Fail("Quantity_textbox Button not Displayed - Change Quantity(Manually)");
			rpt.Category("CC - PDP Module - Change Quantity(Manually)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
	}

	// CC_PD_08
	public void verifyBreadcrumb() throws Exception {

		if (findTheElement("xpath=/html/body/div[8]/div/div[2]/div[1]/div[1]/ul").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Change Quantity(Manually)",
					"Quantity_textbox Button Displayed - Change Quantity(Manually)");
			rpt.Pass("Quantity_textbox Button Displayed - Change Quantity(Manually)");
			rpt.Category("CC - PDP Module - Change Quantity(Manually)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=WC_BreadCrumb_Link_2_2_-3028_3074457345618265627");
		} else {
			rpt.createTest("CC - PDP Module - Change Quantity(Manually)",
					"Quantity_textbox Displayed - Change Quantity(Manually)");
			rpt.Fail("Quantity_textbox Button not Displayed - Change Quantity(Manually)");
			rpt.Category("CC - PDP Module - Change Quantity(Manually)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		browser.navigate().back();

	}

	// CC_PD_09
	public void verifyMiniCart() throws Exception {
		click("id=productPageAdd2Cart");
		Thread.sleep(2000);
		click("id=MiniShopCartCloseButton_2");
		Thread.sleep(3000);
		click("id=widget_minishopcart");
		Thread.sleep(5000);
		Map<String, String> ids = new HashMap<String, String>();
		ids.put("Product Name", "MiniShopCartProdName_1060431");// Keeponchanging
		ids.put("Product Image", "MiniShopCartProdImg_1060431");
		ids.put("Go to Cart", "GotoCartButton1");
		for (Map.Entry<String, String> id : ids.entrySet()) {
			if (findTheElement("xpath=//*[@id='" + id.getValue() + "']").isDisplayed()) {
				rpt.createTest("CC-PDP Module -Check MiniCart - UI section",
						"Message :" + id.getKey() + " Displayed - For MiniCart - UI section");
				rpt.Pass("Message :" + id.getKey() + " Displayed - For MiniCart - UI section");
				rpt.Category("CC_PDP Module -Check MiniCart - UI section");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);

			} else {
				rpt.createTest("CC-PDP Module -Check MiniCart - UI section",
						"Message :" + id.getKey() + "is NOT Displayed - For MiniCart - UI section");
				rpt.Pass("Message :" + id.getKey() + " NOT Displayed - For MiniCart - UI section");
				rpt.Category("CC_PDP Module -Check MiniCart - UI section");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		}
		Thread.sleep(2000);
		if (findTheElement("xpath=//*[@class=\'subtotal\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Check MiniCart - UI section",
					"Subtotal_Div Button Displayed - Check MiniCart - UI section");
			rpt.Pass("Subtotal_Div Button Displayed - Check MiniCart - UI section");
			rpt.Category("CC - PDP Module - Check MiniCart - UI section");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Check MiniCart - UI section",
					"Subtotal_Div Displayed - Check MiniCart - UI section");
			rpt.Fail("Subtotal_Div Button not Displayed - Check MiniCart - UI section");
			rpt.Category("CC - PDP Module - Check MiniCart - UI section");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("id=MiniShopCartCloseButton_1");
	}

	// CC_PD_11
	public void pdImageZoom() throws Exception {

		Thread.sleep(3000);
		click("id=productMainImage_3074457345616726692");
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
	}

	// CC_PD_15
	public void sendMail_Share() throws Exception {
		click("xpath=//*[@class=\'blue_button\']");
		if (findTheElement("xpath=//*[@class=\'blue_button\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Share button with options is displayed - Verify Share/send Mail");
			rpt.Pass("Share button with options is displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module -Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=email-friend-link");
		} else {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Share button with options is displayed -Verify Share/send Mail");
			rpt.Fail("Share button with options is not displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module - Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("xpath=//input[@name=\'firstName\']");
		sendKeys("xpath=//input[@name=\'firstName\']", "Arunkumar");
		click("xpath=//input[@name=\'lastName\']");
		sendKeys("xpath=//input[@name=\'lastName\']", "R");// sender
		Thread.sleep(1000);
		click("xpath=//input[@name=\'friend_firstName\']");
		sendKeys("xpath=//input[@name=\'friend_firstName\']", "Ramya");
		click("xpath=//input[@name=\'friend_lastName\']");
		sendKeys("xpath=//input[@name=\'friend_lastName\']", "Raju");// Recipient
		Thread.sleep(1000);
		click("xpath=//input[@name=\'toEmail\']");
		sendKeys("xpath=//input[@name=\'toEmail\']", "ramya@royalcyber.com");
		click("xpath=//textarea[@name=\'message\']");
		sendKeys("xpath=//textarea[@name=\'message\']", "Test");// emailandmessage
		Thread.sleep(4000);
		if (findTheElement("xpath=//button[@class='ui-button ui-corner-all ui-widget'][1]").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Send Button is displayed - Verify Share/send Mail");
			rpt.Pass("Send Button is displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module -Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//button[@class='ui-button ui-corner-all ui-widget'][1]");
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
		if (findTheElement("id=clickableErrorMessageImg").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Mail_Sent is displayed - Verify Share/send Mail");
			rpt.Pass("Mail_Sent is displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module -Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=clickableErrorMessageImg");
		} else {
			rpt.createTest("CC - PDP Module - Verify Share/send Mail",
					"Mail_Sent is displayed -Verify Share/send Mail");
			rpt.Fail("Mail_Sent is not displayed - Verify Share/send Mail");
			rpt.Category("CC - PDP Module - Verify Share/send Mail");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
	}

	// CC_PD_12,13,36
	public void verifyColorOption() throws Exception {
		Thread.sleep(3000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("id=catalogEntry_img3074457345616686067");
		Thread.sleep(4000);

		// click("id=attrValue_Color_entitledItem_3074457345616721769-button");
		if (findTheElement("id=attrValue_Color_entitledItem_3074457345616686067-button").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Color option",
					"Color_Option_dropdown is displayed - Verify Color option");
			rpt.Pass("Color_Option_dropdown is displayed - Verify Color option");
			rpt.Category("CC - PDP Module -Verify Color option");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=attrValue_Color_entitledItem_3074457345616686067-button");
		} else {
			rpt.createTest("CC - PDP Module - Verify Color option",
					"Color_Option_dropdown is displayed -Verify Color option");
			rpt.Fail("Color_Option_dropdown is not displayed - Verify Color option");
			rpt.Category("CC - PDP Module - Verify Color option");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Robot r = new Robot();
		Thread.sleep(3000);
		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		// CC_PD_13
		if (findTheElement("xpath=//*[@class=\'in-stock\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Color option", "In_stock is displayed - Verify Color option");
			rpt.Pass("In_stock is displayed - Verify Color option");
			rpt.Category("CC - PDP Module -Verify Color option");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Color option", "In_stock is displayed -Verify Color option");
			rpt.Fail("In_stock is not displayed - Verify Color option");
			rpt.Category("CC - PDP Module - Verify Zoom Color option");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		browser.navigate().back();
	}

	// CC_PD_22,23
	public void verifyinWishlistPage() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyboardEvent.DOM_VK_PAGE_UP);
		Thread.sleep(2000);
		r.keyPress(KeyboardEvent.DOM_VK_PAGE_UP);
		Thread.sleep(2000);
		click("id=3074457345616726692addToShoppingList");
		Thread.sleep(2000);
		click("id=wishListQuickLink_alt");
		String id_pdt = findTheElement("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616726693_link_9b")
				.getText();
		if (id_pdt.equals("3M PF170C4B 17.0 Gold Privacy Filter")) {
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

		click("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616726693_link_9b");
		Thread.sleep(4000);
		click("xpath=//[@class=\'top namePartPriceContainer\']");
		String vfy = findTheElement("xpath=//*[@class=\'main_header\']").getText();
		if (vfy.equals("3M PF170C4B 17.0 Gold Privacy Filter")) {
			rpt.createTest("CC - PDP Module - Verify Product in Wishlist",
					"Product is matched - Verify Product from Wishlist");
			rpt.Pass("Product is matched - Verify Product from Wishlist");
			rpt.Category("CC - PDP Module -Verify Product from Wishlist");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Product from Wishlist",
					"Product is matched -Verify Product from Wishlist");
			rpt.Fail("Product is not matched - Verify Product from Wishlist");
			rpt.Category("CC - PDP Module - Verify Product from Wishlist");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
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
		Thread.sleep(3000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("id=catalogEntry_img3074457345616686067");
		Thread.sleep(3000);
		// CC_PD_36
		if (findTheElement("xpath=//*[@class=\'definingAttributes\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Category Element",
					"Category Element is displayed - Verify Category Element");
			rpt.Pass("Category Element is displayed - Verify Category Element");
			rpt.Category("CC - PDP Module -Verify Category Element");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Category Element",
					"Category Element is displayed -Verify Category Element");
			rpt.Fail("Category Element is not displayed - Verify Category Element");
			rpt.Category("CC - PDP Module - Verify Category Element");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_PD_40
		if (findTheElement("xpath=//*[@class=\'prodHighLightContainer\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Product_Highlights",
					"Product_Highlightsis displayed - Verify Product_Highlights");
			rpt.Pass("Product_Highlights is displayed - Verify Product_Highlights");
			rpt.Category("CC - PDP Module -Verify Product_Highlights");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Product_Highlights",
					"Product_Highlights is displayed -Verify Product_Highlights");
			rpt.Fail("Product_Highlights is not displayed - Verify Product_Highlights");
			rpt.Category("CC - PDP Module - Verify Product_Highlights");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		if (findTheElement("xpath=//*[@class=\'whatsIncludedContainer\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Product includes element",
					"Product includes element displayed - Verify Product includes element");
			rpt.Pass("Product includes element is displayed - Verify Product includes element");
			rpt.Category("CC - PDP Module -Verify Product includes element");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Product includes element",
					"Product includes element is displayed -Verify Product includes element");
			rpt.Fail("Product includes element is not displayed - Verify Product includes element");
			rpt.Category("CC - PDP Module - Verify Product includes element");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// cc_PD_42,43
	public void verifyTradeinCashAndPriceMatch() throws Exception {
		if (findTheElement("xpath=//*[@class=\'trade_in\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Trade_in_for_cash",
					"Trade_in_for_cash displayed - Verify Trade_in_for_cash");
			rpt.Pass("Trade_in_for_cash is displayed - Verify Trade_in_for_cash");
			rpt.Category("CC - PDP Module -Verify Trade_in_for_cash");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//a[@href=\"/en/shop/tradeinprogram\"][0]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Trade_in_for_cash",
					"Trade_in_for_cash is displayed -Verify Trade_in_for_cash");
			rpt.Fail("Trade_in_for_cash is not displayed - Verify Trade_in_for_cash");
			rpt.Category("CC - PDP Module - Verify Trade_in_for_cash");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		browser.navigate().back();
		Thread.sleep(3000);
		if (findTheElement("xpath=//*[@class=\'priceMatchGurantee\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Price Match Guarantee",
					"Price Match Guarantee displayed - Verify Price Match Guarantee");
			rpt.Pass("Price Match Guarantee is displayed - Verify Price Match Guarantee");
			rpt.Category("CC - PDP Module -Verify Price Match Guarantee");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//a[@href=\"http://qalive.circuitcity.com/en/shop/pricematch\"]");
		} else {
			rpt.createTest("CC - PDP Module - Verify Price Match Guarantee",
					"Price Match Guarantee is displayed -Verify Price Match Guarantee");
			rpt.Fail("Price Match Guarantee is not displayed - Verify Price Match Guarantee");
			rpt.Category("CC - PDP Module - Verify Price Match Guarantee");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		browser.navigate().back();
		Thread.sleep(3000);
	}

	// CC_PD_49,51,56
	public void verifyTabs() throws Exception {
		click("id=tab1");
		Thread.sleep(2000);
		if (findTheElement("id=pdp-tab-default").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs displayed - Verify Tabs");
			rpt.Pass("Tabs is displayed - Verify Tabs");
			rpt.Category("CC - PDP Module -Verify Tabs");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs is displayed -Verify Tabs");
			rpt.Fail("Tabs is not displayed - Verify Tabs");
			rpt.Category("CC - PDP Module - Verify Tabs");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// CC_PD_51
		click("id=tab3");
		Thread.sleep(2000);
		if (findTheElement("id=pr-review-display").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs displayed - Verify Tabs");
			rpt.Pass("Tabs is displayed - Verify Tabs");
			rpt.Category("CC - PDP Module -Verify Tabs");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Tabs", "Tabs is displayed -Verify Tabs");
			rpt.Fail("Tabs is not displayed - Verify Tabs");
			rpt.Category("CC - PDP Module - Verify Tabs");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		// CC_PD_56
		click("id=tab4");
		Thread.sleep(2000);
		if (findTheElement("xpath=//*[@class=\'compare_main pdp-compare\']").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Compare_Widget",
					"Compare_Widget displayed - Verify Compare_Widget");
			rpt.Pass("Compare_Widget is displayed - Verify Compare_Widget");
			rpt.Category("CC - PDP Module -Verify Compare_Widget");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Compare_Widget",
					"Compare_Widget is displayed -Verify Compare_Widget");
			rpt.Fail("Compare_Widget is not displayed - Verify Compare_Widget");
			rpt.Category("CC - PDP Module - Verify Compare_Widget");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PD_60
	public void VerifyWriteReviews() throws Exception {
		click("id=tab3");
		Thread.sleep(2000);
		if (findTheElement(
				"xpath=//a[@href=\'http://qalive.circuitcity.com/ProductWriteReviewView?catalogId=3074457345616676668&langId=-1&storeId=10801&productId=BELF8J023BT04&pr_merchant_id=885912&pr_api_key=ceb6662d-6e08-40d8-aecb-6fe61bebc0f3&pr_merchant_group_id=49993&pr_page_id=BELF8J023BT04\']")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Write_review_hyperlink",
					"Write_review_hyperlink displayed - Verify Write_review_hyperlink");
			rpt.Pass("Write_review_hyperlink is displayed - Verify Write_review_hyperlink");
			rpt.Category("CC - PDP Module -Verify Write_review_hyperlink");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=xpath=//a[@href=\'http://qalive.circuitcity.com/ProductWriteReviewView?catalogId=3074457345616676668&langId=-1&storeId=10801&productId=BELF8J023BT04&pr_merchant_id=885912&pr_api_key=ceb6662d-6e08-40d8-aecb-6fe61bebc0f3&pr_merchant_group_id=49993&pr_page_id=BELF8J023BT04\']");
		} else {
			rpt.createTest("CC - PDP Module - Verify Write_review_hyperlink",
					"Write_review_hyperlink is displayed -Verify Write_review_hyperlink");
			rpt.Fail("Write_review_hyperlink is not displayed - Verify Write_review_hyperlink");
			rpt.Category("CC - PDP Module - Verify Write_review_hyperlink");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);

		if (findTheElement("id=pr-write").isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Product_review_Page",
					"Product_review_Page navigated - Verify Product_review_Page");
			rpt.Pass("Product_review_Page is navigated - Verify Product_review_Page");
			rpt.Category("CC - PDP Module -Verify Product_review_Page");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Product_review_Page",
					"Product_review_Page is navigated -Verify Product_review_Page");
			rpt.Fail("Product_review_Page is not navigated - Verify Product_review_Page");
			rpt.Category("CC - PDP Module - Verify Product_review_Page");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		browser.navigate().back();
		Thread.sleep(4000);
	}

	// CC_PD_45
	public void verifyC_A_V() throws Exception {
		if (findTheElement("xpath=//*[@id=\'ci_espot_3074457345618265623_PDP_TOP_BROWSED_ESPOT\']").isDisplayed()
				&& findTheElement("xpath=/html/body/div[8]/div/div[3]/div[7]/div/div/div[2]/div[1]/div")
						.isDisplayed()) {
			rpt.createTest("CC - PDP Module - Verify Customer_Also_Viewed Element",
					"Customer_Also_Viewed Element displayed - Verify Customer_Also_Viewed Element");
			rpt.Pass("Customer_Also_Viewed Element is displayed - Verify Customer_Also_Viewed Element");
			rpt.Category("CC - PDP Module -Verify Customer_Also_Viewed Element");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
		} else {
			rpt.createTest("CC - PDP Module - Verify Customer_Also_Viewed Element",
					"Customer_Also_Viewed Element is displayed -Verify Customer_Also_Viewed Element");
			rpt.Fail("Customer_Also_Viewed Element is not displayed - Verify Customer_Also_Viewed Element");
			rpt.Category("CC - PDP Module - Verify Customer_Also_Viewed Element");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

}
