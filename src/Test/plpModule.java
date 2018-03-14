package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class plpModule extends Browser {
	Report rpt = new Report();
	Browser br = new Browser();
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;
	String filterByBrand="Panasonic";
	String filterByBadge="APC APCRBC109 RBC109 Repl Battery Cart 109 (RBC109)";
	String LogonId="user@test.com";
	String pwd="Royalcyber1";

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void executeAll() throws Exception 
	{

		plpPageDetails(); //TC 1
		addProductsToCompare(); //TC 6
		filterByBrand();
		filterByBadges();
		//filterByPrice(); //10 to check
		verifyHyperlink();
		verifyRatings();
		
		
		addProductToCart();
		updateQuantityBox(); //14
		strikeThroughPrice();
		wishList();
		verifyListView();
		verifyGridView();
		verifyPagination();
		verifySortBy();
		espot(); //not there in prod

	}

	// TC-1
	public void plpPageDetails() throws Exception{
		 Thread.sleep(8000);
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Audio");//categories
		 Thread.sleep(3000);
		  Map<String,String> fields= new HashMap<String,String>();
		     fields.put("Filter By", "//div[3]/div/div[2]/div/div/div/h3");
		     fields.put("Color", "//fieldset[2]/div/div/div/label");
		     fields.put("Price", "//fieldset[4]/div/div/div/label");
		     fields.put("Brand", "//fieldset[5]/div/div/div/label");
		     fields.put("Sort By", "//div[2]/div/span/label");
		     fields.put("List view Button", "//*[@id='WC_SearchBasedNavigationResults_pagination_link_list_categoryResults']");
		     fields.put("Grid view Button", "//div[2]/div/div/div[2]/div[2]/div[2]/div");
		     fields.put("List of products with images and details", "//div[@id='container_3074457345618271105']/div[3]/div[2]");
		     fields.put("Items per page", "//div[2]/div/span/span[2]");
		    
		     for(Map.Entry<String, String> field : fields.entrySet() )
		     {
		      if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		      {
		       rpt.createTest("CIRCUIT CITY - Verify PLP Page", "PLP Page field :"+field.getKey()+" is displayed in product Listing page");
		             rpt.Pass("PLP Page field :"+field.getKey()+" is displayed in product Listing page");
		             rpt.Category("CIRCUIT CITY - Verify PLP Page");
		             String path = rpt.CaptureScreen(browser, "ValidMessage");
		             rpt.imgPathPass(path);
		      }
		      else
		      {
		       rpt.createTest("CIRCUIT CITY - Verify PLP Page", "PLP Page field :"+field.getKey()+" is NOT displayed in product Listing page");
		             rpt.Fail("PLP Page field :"+field.getKey()+" is NOT displayed in product Listing page");
		             rpt.Category("CIRCUIT CITY - Verify PLP Page");
		             String path = rpt.CaptureScreen(browser, "InvalidMessage");
		             rpt.imgPathFail(path);
		      }
		}
		}

	// CC_PL_06
	public void addProductsToCompare() throws Exception {
		// click("xpath=//*[@id=\'compare_3074457345616726692\']");
		if (findTheElement("xpath=//li[1]/.//div[@class='compare_target']//label[contains(text(),'Compare')]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 1 to Compare");
			rpt.Pass("Compare Button Displayed - Adding Product 1 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//li[1]/.//div[@class='compare_target']//label[contains(text(),'Compare')]");// Product 1
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 1 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 1 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,90)");
		Thread.sleep(2000);

		// click("xpath=//*[@id=\'compare_3074457345616726694\']");
		if (findTheElement("xpath=//li[2]/.//div[@class='compare_target']//label[contains(text(),'Compare')]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 2 to Compare");
			rpt.Pass("Compare Button Displayed - Adding Product 2 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//li[2]/.//div[@class='compare_target']//label[contains(text(),'Compare')]");// Product 2
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 2 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 2 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// click("xpath=//*[@id=\'compare_3074457345616726862\']");
		if (findTheElement("xpath=//li[3]/.//div[@class='compare_target']//label[contains(text(),'Compare')]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 3 to Compare");
			rpt.Pass("Compare Button Displayed - Adding Product 3 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//li[3]/.//div[@class='compare_target']//label[contains(text(),'Compare')]");// Product 3
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 3 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 3 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
//		r.mouseWheel(13);
		Thread.sleep(6000);

		// click("xpath=//*[@id="compare_3074457345616726864"]");
		if (findTheElement("xpath=//li[4]/.//div[@class='compare_target']//label[contains(text(),'Compare')]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 4 to Compare");
			rpt.Pass("Compare Button Displayed - Adding Product 4 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//li[4]/.//div[@class='compare_target']//label[contains(text(),'Compare')]");// Product 4
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 4 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 4 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		// click("xpath=/html/body/div[6]/div/div[2]/a[2]");
		if (findTheElement("link=Clear All").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Clear all Button Displayed - for closing compare menu");
			rpt.Pass("Clear all Button Displayed -for closing compare menu");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("link=Clear All");// Clearing all products from Compare

		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Clear all Button Displayed - for closing compare menu");
			rpt.Fail("Clear all Button not Displayed -for closing compare menu");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_08
	public void filterByBrand() throws Exception {
		Thread.sleep(2000);
		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
//		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
//			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by price");
//			rpt.Pass("Drop down Displayed - for filter by price");
//			rpt.Category("CC - PLP Module - Filter by Price");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");// Dropdown click
//
//		} else {
//			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by price");
//			rpt.Fail("Drop down not Displayed - for filter by price");
//			rpt.Category("CC - PLP Module - Filter by Price");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Robot r = new Robot();
//		r.mouseWheel(2);
//		r.keyPress(KeyboardEvent.DOM_VK_UP);
//		Thread.sleep(1000);
//		r.keyPress(KeyboardEvent.DOM_VK_UP);
		// r.keyPress(KeyEvent.VK_ENTER);
		
		sendKeys("id=miniSearch",filterByBrand);
		Thread.sleep(2000);
		click("xpath=//form[@id='miniSearchForm']/input[7]");
		Thread.sleep(2000);
		
		if (findTheElement("css=div.product_listing_container").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Products Displayed - for filter by Brand");
			rpt.Pass("Products Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			//r.keyPress(KeyEvent.VK_ENTER);

		} else {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Products Displayed - for filter by Brand");
			rpt.Fail("Products not Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(8000);

	}

	// CC_PL_09
	public void filterByBadges() throws Exception 
	{

//		waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
//		Thread.sleep(2000);
//		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
//		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
//			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
//					"Drop down Displayed - for filter by Badges(Name)");
//			rpt.Pass("Drop down Displayed - for filter by Badges(Name)");
//			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");// Dropdown click
//
//		} else {
//			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
//					"Drop down Displayed - for filter by Badges(Name)");
//			rpt.Fail("Drop down not Displayed - for filter by Badges(Name)");
//			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(2000);
//		Robot r = new Robot();
//		Thread.sleep(2000);
//		r.keyPress(KeyboardEvent.DOM_VK_UP);
//		Thread.sleep(3000);
//
//		// r.keyPress(KeyEvent.VK_ENTER);
//		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
//			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
//					"Drop down Displayed - for filter by Badges(Name)");
//			rpt.Pass("Drop down Displayed - for filter by Badges(Name)");
//			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			r.keyPress(KeyEvent.VK_ENTER);
//
//		} else {
//			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
//					"Drop down Displayed - for filter by Badges(Name)");
//			rpt.Fail("Drop down not Displayed - for filter by Badges(Name)");
//			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(2000);
//		// waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		sendKeys("id=searchBox",filterByBadge);
		Thread.sleep(2000);
		//click("xpath=//form[@id='searchBox']/a[2]");
		Thread.sleep(2000);
		if (findTheElement("xpath=//form[@id='searchBox']/a[2]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Products Displayed - for filter by Badges(Name)");
			rpt.Pass("Products Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//form[@id='searchBox']/a[2]");
//			r.keyPress(KeyEvent.VK_ENTER);

		} else {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Products Displayed - for filter by Badges(Name)");
			rpt.Fail("Products not Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_10
	public void filterByPrice() throws Exception 
	{
		Thread.sleep(6000);
		waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by Price");
			rpt.Pass("Drop down Displayed - for filter by Price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");

		} else {
			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by Price");
			rpt.Fail("Drop down not Displayed - for filter by Price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
//		Robot r = new Robot();
//		r.keyPress(KeyboardEvent.DOM_VK_UP);
//		Thread.sleep(2000);
//		// r.keyPress(KeyEvent.VK_ENTER);
//		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
//			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
//			rpt.Pass("Drop down Displayed - for filter by Brand");
//			rpt.Category("CC - PLP Module - Filter by Brand");
//			String path = rpt.CaptureScreen(browser, "ValidMessage");
//			rpt.imgPathPass(path);
//			r.keyPress(KeyEvent.VK_ENTER);
//
//		} else {
//			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
//			rpt.Fail("Drop down not Displayed - for filter by Brand");
//			rpt.Category("CC - PLP Module - Filter by Brand");
//			String path = rpt.CaptureScreen(browser, "InvalidMessage");
//			rpt.imgPathFail(path);
//		}
//		Thread.sleep(4000);
	}

	// CC_PL_11
	public void verifyRatings() throws Exception {
		Thread.sleep(2000);
		click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Audio");//categories
		 Thread.sleep(3000);
		if (findTheElement(
				"xpath=//div[@class='product_listing_container']//li[1]//div[@class='pr-rating-stars']")
						.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify ratings", "Ratings Displayed - for verify ratings");
			rpt.Pass("Ratings Displayed - for verify ratings");
			rpt.Category("CC - PLP Module - verify ratings");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module - verify ratings", "Ratings Displayed - for verify ratings");
			rpt.Fail("Ratings not Displayed - for verify ratings");
			rpt.Category("CC - PLP Module - verify ratings");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_12
	public void verifyHyperlink() throws Exception {
		Thread.sleep(4000);
		// click("xpath=//*[@id="WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616684172_link_9b"]");
		if (findTheElement("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify hyperlink", "Hyperlink of product is navigated to respective page - for verify hyperlink");
			rpt.Pass("Hyperlink of product is navigated to respective page - for verify hyperlink");
			rpt.Category("CC - PLP Module - verify hyperlink");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']");

		} else {
			rpt.createTest("CC - PLP Module - verify hyperlink", "Hyperlink of product NOT navigated to respective page - for verify hyperlink");
			rpt.Fail("Hyperlink of product NOT navigated to respective page - for verify hyperlink");
			rpt.Category("CC - PLP Module - verify hyperlink");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		browser.navigate().back();
		Thread.sleep(3000);

	}

	// CC_PL_13
	public void addProductToCart() throws Exception {
		Thread.sleep(2000);
		//click("xpath=(//a[contains(text(),'BUY NOW')])[3]");
		if (findTheElement("xpath=(//a[contains(text(),'BUY NOW')])[3]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Adding product to cart",
					" Buy now Button Displayed - Adding product to cart");
			rpt.Pass(" Buy now Button Displayed - Adding product to cart");
			rpt.Category("CC - PLP Module - Adding product to cart");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=(//a[contains(text(),'BUY NOW')])[3]");

		} else {
			rpt.createTest("CC - PLP Module - Adding product to cart",
					" Buy now Button Displayed - Adding product to cart");
			rpt.Fail(" Buy now Button not Displayed - Adding product to cart");
			rpt.Category("CC - PLP Module - Adding product to cart");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=MiniShopCartCloseButton_2");
		Thread.sleep(4000);
	}
    //14
	public void updateQuantityBox()throws Exception
	{
		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']");
		Thread.sleep(1000);
		 findTheElement("xpath=//div[6]/input").clear();
		 Thread.sleep(1000);
		 sendKeys("xpath=//div[6]/input","2000");
		 Thread.sleep(1000);
		 click("id=add2CartBtn");
		 Thread.sleep(1000);
		 String message=findTheElement("css=div.container").getText();
		 String msg="Maximum Quantity is";
		 if(message.contains(msg))
		 {
			 rpt.createTest("CC - PLP Module - Update Quantity Box",
						" Message displayed for product quantity - Update Quantity Box");
				rpt.Pass(" Message displayed for product quantity - Update Quantity Box");
				rpt.Category("CC - PLP Module - Update Quantity Box");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				//click("xpath=(//a[contains(text(),'BUY NOW')])[3]");

			} else {
				rpt.createTest("CC - PLP Module - Update Quantity Box",
						"  Message NOT displayed for product quantity - Update Quantity Box");
				rpt.Fail(" Message NOT displayed for product quantity  - Update Quantity Box");
				rpt.Category("CC - PLP Module - Update Quantity Box");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 
			 
	}
	// CC_PL_15
	public void strikeThroughPrice() throws Exception {
		browser.navigate().back();
		String price=findTheElement("xpath=//li[3]/.//div[@class='product_price']").getText();
		Thread.sleep(2000);
		if (findTheElement("xpath=//li[3]/.//div[@class='product_price']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Strike through Price",
					"Strike through Price Displayed - for verify Strike through Price" +price);
			rpt.Pass("Strike through Price Displayed - for verify Strike through Price" +price);
			rpt.Category("CC - PLP Module - verify Strike through Price");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module - verify Strike through Price",
					"Strike through Price Displayed - for verify Strike through Price");
			rpt.Fail("Strike through Price not Displayed - for verify Strike through Price");
			rpt.Category("CC - PLP Module - verify Strike through Price");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}
  //16,17
	public void wishList() throws Exception {
		click("xpath=//li/div[2]/div/div[2]");
		Thread.sleep(2000);
		if (findTheElement("id=SignInPopup").isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Wishlist",
					"On adding product to wishlist from plp page,It asked for Login");
			rpt.Pass("On adding product to wishlist from plp page,It asked for Login" );
			rpt.Category("CC - PLP Module - verify Wishlist ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module - verify Wishlist",
					"On adding product to wishlist from plp page,It did NOT asked for Login");
			rpt.Fail("On adding product to wishlist from plp page,It did NOT asked for Login");
			rpt.Category("CC - PLP Module - verify Wishlist");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//div[@id='WC_AccountDisplay_div_2']/a"); //closing sigin popup
		Thread.sleep(2000);
		/*click("css=div.love_it_drop");
		Thread.sleep(2000);
		/* String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		       String childWindowTitle = getTitle();
		       System.out.print(childWindowTitle);
		       sendKeys("WC_AccountDisplay_FormInput_logonId_In_Logon_1",LogonId);
				sendKeys("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1",pwd);
				Thread.sleep(2000);
				click("id=WC_AccountDisplay_links_2"); //sign in
				Thread.sleep(2000);
		       browser.close(); 
		       browser.switchTo().window(parentWindow); 
		     }
		  }  
		Thread.sleep(2000);
		sendKeys("WC_AccountDisplay_FormInput_logonId_In_Logon_1",LogonId);
		Thread.sleep(2000);
		sendKeys("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1",pwd);
		Thread.sleep(2000);
		click("id=WC_AccountDisplay_links_2"); //sign in
		Thread.sleep(2000);
		click("id=wishListQuickLink_alt"); //wishlist
		Thread.sleep(2000);
		if (findTheElement("xpath=//div[@class='product_listing_container']").isDisplayed()) {
			rpt.createTest("CC - PLP Module",
					"Product is added to wishlist after signIn");
			rpt.Pass("Product is added to wishlist after signIn" );
			rpt.Category("CC - PLP Module ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module",
					"Product NOT added to wishlist after signIn");
			rpt.Fail("Product NOT added to wishlist after signIn");
			rpt.Category("CC - PLP Module");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("link=Remove"); */ 
	}
	
	// CC_PL_18
	public void verifyListView() throws Exception {
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Audio");//categories
		 Thread.sleep(3000);
		// click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_list_categoryResults\']");
		if (findTheElement("id=WC_SearchBasedNavigationResults_pagination_link_list_categoryResults")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify List_View", "List_View option Displayed - for verify List_View");
			rpt.Pass("List_View option Displayed - for verify List_View");
			rpt.Category("CC - PLP Module - verify List_View");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("id=WC_SearchBasedNavigationResults_pagination_link_list_categoryResults");

		} else {
			rpt.createTest("CC - PLP Module - verify List_View", "List_View option Displayed - for verify List_View");
			rpt.Fail("List_View option not Displayed - for verify List_View");
			rpt.Category("CC - PLP Module - verify List_View");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_19
	public void verifyGridView() throws Exception {
		// click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults\']");
		if (findTheElement("id=WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Grid_View", "Grid_View option Displayed - for verify Grid_View");
			rpt.Pass("Grid_View option Displayed - for verify Grid_View");
			rpt.Category("CC - PLP Module - verify Grid_View");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("id=WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults");

		} else {
			rpt.createTest("CC - PLP Module - verify Grid_View", "Grid_View option Displayed - for verify Grid_View");
			rpt.Fail("Grid_View option not Displayed - for verify Grid_View");
			rpt.Category("CC - PLP Module - verify Grid_View");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_20
	public void verifyPagination() throws Exception 
	{
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Robot r = new Robot();
//		for (int sec = 1; sec < 10; sec++) {
//			r.keyPress(KeyEvent.VK_PAGE_DOWN);
//			Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,7000)");
		Thread.sleep(5000);
		// click("xpath=//*[@id=\"WC_SearchBasedNavigationResults_pagination_link_2_categoryResults\"]");
		if (findTheElement("id=WC_SearchBasedNavigationResults_pagination_link_right_categoryResults_img")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Pagination",
					"Pagination option Displayed and is working - for verify Pagination");
			rpt.Pass("Pagination option Displayed and is working - for verify Pagination");
			rpt.Category("CC - PLP Module - verify Pagination");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("id=WC_SearchBasedNavigationResults_pagination_link_right_categoryResults_img");

		} else {
			rpt.createTest("CC - PLP Module - verify Pagination",
					"Pagination option Displayed - for verify Pagination");
			rpt.Fail("Pagination option not Displayed - for verify Pagination");
			rpt.Category("CC - PLP Module - verify Pagination");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_21
	public void verifySortBy() throws Exception {
		
		// click("xpath=//*[@id=\'pageSize_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//div[2]/div/span/label").isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify SortBy", "SortBy option Displayed - for verify SortBy");
			rpt.Pass("SortBy option Displayed - for verify SortBy");
			rpt.Category("CC - PLP Module - verify SortBy");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("xpath=//div[2]/div/div/div/span/span[2]");

		} else {
			rpt.createTest("CC - PLP Module - verify SortBy", "SortBy option Displayed - for verify SortBy");
			rpt.Fail("SortBy option not Displayed - for verify SortBy");
			rpt.Category("CC - PLP Module - verify SortBy");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
//		Robot r = new Robot();
//		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_ENTER);
		click("xpath=//div[@id='ui-id-10']");
		Thread.sleep(2000);
	}
	public void espot() throws Exception {
		Thread.sleep(2000);
		click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Audio");//categories
		 Thread.sleep(3000);
		 if (findTheElement("css=div.carouselWrapper").isDisplayed()) {
				rpt.createTest("CC - PLP Module - verify espot", "espot option Displayed - for verify espot");
				rpt.Pass("espot option Displayed - for verify espot");
				rpt.Category("CC - PLP Module - verify espot");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				//click("css=span.ui-selectmenu-text");

			} else {
				rpt.createTest("CC - PLP Module - verify espot", "espot option Displayed - for verify espot");
				rpt.Fail("espot option not Displayed - for verify espot");
				rpt.Category("CC - PLP Module - verify espot");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
	}
}
