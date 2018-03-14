package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class shoppingCart extends Browser
{
	Report rpt = new Report();
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;
	//Browser br  = new Browser();
	//WebDriver wd;
	
	/*@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test*/
	String promocode="10PERCOFF";
	String address="120 Greenwich St";
	String city="New York";
	String state="NY";
	String zipCode="10006";
	String paypalid="personal@circuitcity.com";
	String paypalpwd="12345678";
	CommonUtils email = new CommonUtils();
	String name=email.getRandomString(6);
	String phoneNo=email.getRandomNumber(10);
	String emailid="user@test.com";
	
	
	
	public void executeAll() throws Exception
	{
		verifyminiCart();
		quantityIncrease();
////		modalWindow(); N/A
		productAdded();
////		closeButton(); N/A
		viewCart();
		continueShopping();
		recommendedAccessory();
		addToCart();
		////allAccessory(); N/A
////		miniCartDisplay();
////		productDisplay();
//	//	itemsInCart();
//	//	close_Button();
//	//	verifyDisplay();
//	//	productTitle();
//	//	subTotal();
//	//	goToCart();
		shoppingCart();
		verifySKU();
		productImage();
//		wishList();
        remove();
		availability();
		quantity();
		price();
		totalPrice();
////		lineSeparator(); N/A
		promoCode(); 
		promoCodeText(); 
		applyButton();
		orderTotal();
//		guestDetails();
		checkOut();
//		userName(); N/A
//		Password(); N/A
//		forgotPassword();N/A
//		signincheckout();N/A
//		keepTrack();N/A
//		moveItems();N/A
//		saveForLater();N/A
//		shoppingList();N/A
//		saveProducts();N/A
//		manageProduct();N/A
	}
	
	//CC_A&C_01
	public void verifyminiCart()throws Exception
	{
		click("id=allDepartmentsButton"); //products
		
		Thread.sleep(5000);//"id=CatalogEntryProdImg_3074457345616727788"
		click("link=Audio"); //audio
		Thread.sleep(5000);
		//click("id=CatalogEntryProdImg_3074457345616727788"); 
		Thread.sleep(5000);
		if(findTheElement("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Mini Cart", "Product Detail Page is Displayed - For Verify Mini Cart");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Mini Cart");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("xpath=//a[contains(text(),'Asus')]"); 
	 		click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']");
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Mini Cart", "Product Detail Page NOT Displayed - For Verify Mini Cart");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Mini Cart");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		
		if(findTheElement("xpath=//*[@id='widget_minishopcart']/span").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify Mini Cart", "Mini Cart is Displayed - For Verify Mini Cart");
	         rpt.Pass("Mini Cart is Displayed - For Verify Mini Cart");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify Mini Cart", "Mini Cart is NOT displayed - For Verify Mini Cart");
	         rpt.Fail("Mini Cart is NOT displayed - For Verify Mini Cart");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	} 
	
	public void quantityIncrease()throws Exception
	{
		Thread.sleep(5000);
		//click("id=add2CartBtn"); //add to cart
		if(findTheElement("id=add2CartBtn").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Quantity Increase", "Add To Cart is Displayed - For Verify Quantity Increase");
	         rpt.Pass("Add To Cart is Displayed - For Verify Quantity Increase");
	         rpt.Category("CC_Shopping Cart - Verify Quantity Increase");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=add2CartBtn"); //add to cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Quantity Increase", "Add To Cart NOT Displayed - For Verify Quantity Increase");
	         rpt.Fail("Add To Cart NOT Displayed - For Verify Quantity Increase");
	         rpt.Category("CC_Shopping Cart - Verify Quantity Increase");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//CC_03
		if(findTheElement("id=cartDropdownMessage ").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Modal window", "Mini cart modal window is opened after adding product to cart - For Verify Modal window");
	         rpt.Pass("Mini cart modal window is opened after adding product to cart - For Verify Modal window");
	         rpt.Category("CC_Shopping Cart - Verify Modal window");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("id=add2CartBtn"); //add to cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Modal window", "Mini cart modal window NOT opened after adding product to cart - For Verify Modal window");
	         rpt.Fail("Mini cart modal window NOT opened after adding product to cart - For Verify Modal window");
	         rpt.Category("CC_Shopping Cart - Verify Modal window");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		if(findTheElement("id=MiniShopCartCloseButton_2").isDisplayed())
		{
			//click("xpath=//*[@id='MiniShopCartCloseButton_2']"); //close
			//System.out.println("Close Button is present and is functional");
			rpt.createTest("CC - Shopping Cart - Verify Close Button", "Close Button is present and is functional - For Verify Close Button");
	         rpt.Pass("Close Button is present and is functional - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("id=MiniShopCartCloseButton_2"); //close
		}
		else
		{
			//System.out.println("Close Button is NOT present and is functional");
			 rpt.createTest("CC - Shopping Cart - Verify Close Button", "Close Button is NOT present and is functional - For Verify Close Button");
	         rpt.Fail("Close Button is NOT present and is functional - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=//*[@id='minishopcart_total']"); //mini shop button
		Thread.sleep(3000);
		if(findTheElement("xpath=//*[@id='cartDropdown']/div[1]/div[2]/span[1]").isDisplayed())
		{
			String total=getText("xpath=//*[@id='cartDropdown']/div[1]/div[2]/span[1]");
			//System.out.println("Total count increased after adding product to cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Quantity Increase", "Total count increased after adding product to cart - " +total );
	         rpt.Pass("Total count increased after adding product to cart - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Quantity Increase");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Total Count NOT increased after adding product to cart");
			 rpt.createTest("CC - Shopping Cart - Verify Quantity Increase", "Total Count NOT increased after adding product to cart - For Verify Quantity Increase");
	         rpt.Fail("Total Count NOT increased after adding product to cart - For Verify Quantity Increase");
	         rpt.Category("CC_Shopping Cart - Verify Quantity Increase");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
	}
	
	public void modalWindow()throws Exception
	{
		Thread.sleep(5000);
		click("xpath=//*[@id='MiniShopCartCloseButton_1']"); //close mini cart
		Thread.sleep(5000);
		//click("xpath=//*[@id='minishopcart_total']"); //mini cart
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Maximise Window", "Mini Cart is Displayed - For Verify Maximise Window");
	         rpt.Pass("Mini Cart is Displayed - For Verify Maximise Window");
	         rpt.Category("CC_Shopping Cart - Verify Maximise Window");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='minishopcart_total']"); //mini cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Maximise Window", "Mini Cart NOT Displayed - For Verify Maximise Window");
	         rpt.Pass("Mini Cart NOT Displayed - For Verify Maximise Window");
	         rpt.Category("CC_Shopping Cart - Verify Maximise Window");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		if(findTheElement("id=quick_cart").isDisplayed())
		{
			//System.out.println("Mini Cart is Maximised on clicking Mini Cart Button");
			rpt.createTest("CC - Shopping Cart - Verify Maximise Window", "Mini Cart is Maximised on clicking Mini Cart Button - For Verify Maximise Window");
	         rpt.Pass("Mini Cart is Maximised on clicking Mini Cart Button - For Verify Maximise Window");
	         rpt.Category("CC_Shopping Cart - Verify Maximise Window");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Mini Cart NOT Maximised on clicking Mini Cart Button");
			 rpt.createTest("CC - Shopping Cart - Verify Maximise Window", "Mini Cart NOT Maximised on clicking Mini Cart Button - For Verify Maximise Window");
	         rpt.Pass("Mini Cart NOT Maximised on clicking Mini Cart Button - For Verify Maximise Window");
	         rpt.Category("CC_Shopping Cart - Verify Maximise Window");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//CC_A&C_05
	public void productAdded()throws Exception
	{
		Thread.sleep(5000);
		//click("xpath=//*[@id='MiniShopCartCloseButton_1']"); //close mini cart
		//click("xpath=//*[@id='minishopcart_total']"); //mini cart
		//Thread.sleep(5000);
		/*if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		{
			String total=getText("xpath=//li[1]/.//div[@class='product_image']");
			//System.out.println("Product Added in Cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Product Added", "Product Added in Cart  - " +total);
	         rpt.Pass("Product Added in Cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Product Added");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Product NOT Added in Cart");
			 rpt.createTest("CC - Shopping Cart - Verify Product Added", "Product NOT Added in Cart");
	         rpt.Pass("Product NOT Added in Cart");
	         rpt.Category("CC_Shopping Cart - Verify Product Added");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}*/
		click("xpath=//*[@id='MiniShopCartCloseButton_1']");
	}
	//
	public void closeButton()throws Exception
	{
		click("xpath=//*[@id='MiniShopCartCloseButton_1']"); //close mini cart
		Thread.sleep(8000); //"id=allDepartmentsButton"
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); //tv and home theatre
		Thread.sleep(5000);
		//click("id=CatalogEntryProdImg_3074457345616727788"); 
		Thread.sleep(8000);
		if(findTheElement("id=CatalogEntryProdImg_3074457345616727860").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Close Button", "Product Detail Page is Displayed - For Verify Close Button");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=CatalogEntryProdImg_3074457345616727860"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Close Button", "Product Detail Page NOT Displayed - For Verify Close Button");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("id=add2CartBtn"); //add to cart
		Thread.sleep(5000);
		if(findTheElement("id=add2CartBtn").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Close Button", "Add To Cart is Displayed - For Verify Close Button");
	         rpt.Pass("Add To Cart is Displayed - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=add2CartBtn"); //add to cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Close Button", "Add To Cart NOT Displayed - For Verify Close Button");
	         rpt.Fail("Add To Cart NOT Displayed - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		if(findTheElement("id=MiniShopCartCloseButton_2").isDisplayed())
		{
			//click("xpath=//*[@id='MiniShopCartCloseButton_2']"); //close
			//System.out.println("Close Button is present and is functional");
			rpt.createTest("CC - Shopping Cart - Verify Close Button", "Close Button is present and is functional - For Verify Close Button");
	         rpt.Pass("Close Button is present and is functional - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("id=MiniShopCartCloseButton_2"); //close
		}
		else
		{
			//System.out.println("Close Button is NOT present and is functional");
			 rpt.createTest("CC - Shopping Cart - Verify Close Button", "Close Button is NOT present and is functional - For Verify Close Button");
	         rpt.Fail("Close Button is NOT present and is functional - For Verify Close Button");
	         rpt.Category("CC_Shopping Cart - Verify Close Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//CC_A&C_08
	public void viewCart()throws Exception
	{
//		click("xpath=//*[@id='MiniShopCartCloseButton_1']"); //close mini cart
		Thread.sleep(5000);
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		click("link=Audio"); //tv and home theatre
		Thread.sleep(5000);
		//click("id=CatalogEntryProdImg_3074457345616727788"); 
		Thread.sleep(5000);
		if(findTheElement("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify View Cart", "Product Detail Page is Displayed - For Verify View Cart");
	         rpt.Pass("Product Detail Page is Displayed - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("xpath=//a[contains(text(),'Panasonic')]"); 
	         click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']");
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify View Cart", "Product Detail Page NOT Displayed - For Verify View Cart");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("id=add2CartBtn"); //add to cart
		Thread.sleep(5000);
		if(findTheElement("id=add2CartBtn").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify View Cart", "Add To Cart is Displayed - For Verify View Cart");
	         rpt.Pass("Add To Cart is Displayed - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=add2CartBtn"); //add to cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify View Cart", "Add To Cart NOT Displayed - For Verify View Cart");
	         rpt.Fail("Add To Cart NOT Displayed - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(2000);
		click("id=GotoCartButton2"); //view cart
		Thread.sleep(3000);
		if(findTheElement("xpath=//div[@id='orderItemDisplay']/div/div/div/h1").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify View Cart", "View Cart Button is navigated to shopping cart page - For Verify View Cart");
	         rpt.Pass("View Cart Button is navigated to shopping cart page - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("xpath=//div[@id='orderItemDisplay']/div/div/div/h1"); //view cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify View Cart", "View Cart Button NOT navigated to shopping cart page - For Verify View Cart");
	         rpt.Fail("View Cart Button NOT navigated to shopping cart page - For Verify View Cart");
	         rpt.Category("CC_Shopping Cart - Verify View Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		return;
		//click("xpath=//*[@id='MiniShopCartCloseButton_2']"); //close modal window
	}
	
	public void continueShopping()throws Exception
	{
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		click("link=Audio"); 
		Thread.sleep(5000);
		//click("id=CatalogEntryProdImg_3074457345616727788"); 
		Thread.sleep(5000);
		if(findTheElement("xpath=//div[@class='product_listing_container']//li[3]/.//div[@class='product_name']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Product Detail Page is Displayed - For Verify Continue Shopping");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("xpath=//a[contains(text(),'Magic Chef')]"); 
	         click("xpath=//div[@class='product_listing_container']//li[3]/.//div[@class='product_name']");
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Product Detail Page NOT Displayed - For Verify Continue Shopping");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("id=add2CartBtn"); //add to cart
		Thread.sleep(5000);
		if(findTheElement("id=add2CartBtn").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Add To Cart is Displayed - For Verify Continue Shopping");
	         rpt.Pass("Add To Cart is Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=add2CartBtn"); //add to cart
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Add To Cart NOT Displayed - For Verify Continue Shopping");
	         rpt.Fail("Add To Cart NOT Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("xpath=//*[@id='GotoCartButton2']"); //view cart
		Thread.sleep(5000);
		//click("xpath=//*[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		if(findTheElement("xpath=//*[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Continue Shopping Button is Displayed - For Verify Continue Shopping");
	         rpt.Pass("Continue Shopping Button is Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Continue Shopping", "Continue Shopping Button NOT Displayed - For Verify Continue Shopping");
	         rpt.Fail("Continue Shopping Button NOT Displayed - For Verify Continue Shopping");
	         rpt.Category("CC_Shopping Cart - Verify Continue Shopping");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
	}
	//CC_A&C_13
	public void recommendedAccessory()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']"); //search bar
		Thread.sleep(5000);
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(8000);
		//click("xpath=.//*[@id='autoSelectOption_0']/div/img");
		if(findTheElement("xpath=.//*[@id='autoSelectOption_0']/div/img").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Recommended Accessory", "Product Detail Page is Displayed - For Verify Recommended Accessory");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Recommended Accessory");
	         rpt.Category("CC_Shopping Cart - Verify Recommended Accessory");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=.//*[@id='autoSelectOption_0']/div/img"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Recommended Accessory", "Product Detail Page NOT Displayed - For Verify Recommended Accessory");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Recommended Accessory");
	         rpt.Category("CC_Shopping Cart - Verify Recommended Accessory");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		/*Robot r =new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
		
//		WebElement scroll = findTheElement("xpath=html/body/div[10]/div/div[3]/div[3]/div/h2");
//		scroll.sendKeys(Keys.PAGE_DOWN);
//		Thread.sleep(5000);
		Thread.sleep(3000);
//		 WebElement Element = findTheElement("xpath=html/body/div[10]/div/div[3]/div[3]/div/h2");
//	     JavascriptExecutor jse = (JavascriptExecutor)browser;
//	      jse.executeScript("arguments[0].scrollIntoView();", Element);
//	      Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1000)");
		 
		 Map<String,String> ids= new HashMap<String,String>();
		 ids.put("Product Image", "//div[2]/div[2]/a/img");
		 ids.put("Product Name", "//a[contains(text(),'Lenovo ')]");
		 ids.put("Product Price", "//div[3]/div[2]/div/span");
		 ids.put("Buy Now", "//a[contains(text(),'BUY NOW')]");
		
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath="  +id.getValue()+ "").isDisplayed())
			 {
				
    	         rpt.createTest("CC - Shopping Cart - Verify Recommended Accessory", "Message :"+id.getKey()+" Displayed - For Verify Recommended Accessory");
    	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify Recommended Accessory");
    	         rpt.Category("CC_Shopping Cart - Verify Recommended Accessory");
    	         String path = rpt.CaptureScreen(browser, "ValidMessage");
    	         rpt.imgPathPass(path);

			 }
			 else
			 {
				 rpt.createTest("CC - Shopping Cart - Verify My Account Page", "Message :"+id.getKey()+"is NOT Displayed - For Verify Recommended Accessory");
    	         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify Recommended Accessory");
    	         rpt.Category("CC_Shopping Cart - Verify Recommended Accessory");
    	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	         rpt.imgPathFail(path);
			 }
		 }
		 if(findTheElement("xpath=//div[@id='hideMoreAccessory']/h4/span").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify All Accessory", "All Accessory is Displayed - For Verify All Accessory");
	         rpt.Pass("Add To Cart Button is Displayed - For Verify All Accessory");
	         rpt.Category("CC_Shopping Cart - Verify All Accessory");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		//click("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img"); //see all accessory
	         click("xpath=//div[@id='hideMoreAccessory']/h4/span");
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify All Accessory", "Add To Cart Button NOT Displayed - For Verify All Accessory");
	         rpt.Fail("Add To Cart Button NOT Displayed - For Verify All Accessory");
	         rpt.Category("CC_Shopping Cart - Verify All Accessory");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		// click("xpath=.//*[@id='listViewAdd2Cart_3074457345616683129']"); //buy now
		 
	}
	public void addToCart()throws Exception
	{
		 //click("xpath=.//*[@id='listViewAdd2Cart_3074457345616683129']"); //buy now
		 Thread.sleep(5000);
		 if(findTheElement("xpath=//div[@class='accessory '][1]//a[contains(text(),'BUY NOW')]").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Add To Cart Button is Displayed and is functional - For Verify Add To Cart");
	         rpt.Pass("Add To Cart Button is Displayed and is functional - For Verify Add To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
			 click("xpath=//div[@class='accessory '][2]//a[contains(text(),'BUY NOW')]"); //buy now
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Add To Cart Button NOT Displayed and functional - For Verify Add To Cart");
	         rpt.Fail("Add To Cart Button NOT Displayed and functional - For Verify Add To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		 Thread.sleep(5000);
		 //click("id=MiniShopCartCloseButton_2"); //close
		 //Thread.sleep(5000);
		 click("xpath=//*[@id='minishopcart_total']"); //mini shop button
			Thread.sleep(3000);
//			if(findTheElement("xpath=//*[@id='cartDropdown']/div[1]/div[2]/span[1]").isDisplayed())
//			{
//				String total=getText("xpath=//*[@id='cartDropdown']/div[1]/div[2]/span[1]");
//				//System.out.println("Total count increased after adding product to cart  - " +total);
//				 rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Total count increased after adding product to cart  - " +total);
//		         rpt.Pass("Total count increased after adding product to cart  - " +total);
//		         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
//		         String path = rpt.CaptureScreen(browser, "ValidMessage");
//		         rpt.imgPathPass(path);
//			}
//			else
//			{
//				//System.out.println("Total Count NOT increased after adding product to cart");
//				 rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Total Count NOT increased after adding product to cart");
//		         rpt.Fail("Total Count NOT increased after adding product to cart");
//		         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
//		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//		         rpt.imgPathFail(path);
//			}
			Thread.sleep(3000);
			click("xpath=//*[@id='GotoCartButton1']"); //go to cart
	}
	//CC_A&C_16
	public void allAccessory()throws Exception
	{
		//click("xpath=//*[@id='MiniShopCartCloseButton_1']"); //close mini cart
		browser.navigate().back();
		Thread.sleep(5000);
//		WebElement scroll = findTheElement("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img");
//		scroll.sendKeys(Keys.PAGE_DOWN);
//		Thread.sleep(5000);
		 WebElement Element = findTheElement("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img");
	     JavascriptExecutor jse = (JavascriptExecutor)browser;
	      jse.executeScript("arguments[0].scrollIntoView();", Element);
	      Thread.sleep(3000);
		//click("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img"); //see all accessory
		Thread.sleep(5000);
		if(findTheElement("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify All Accessory", "All Accessory is Displayed - For Verify All Accessory");
	         rpt.Pass("Add To Cart Button is Displayed - For Verify All Accessory");
	         rpt.Category("CC_Shopping Cart - Verify All Accessory");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=html/body/div[10]/div/div[3]/div[3]/div/div[7]/h4/span[2]/img"); //see all accessory
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify All Accessory", "Add To Cart Button NOT Displayed - For Verify All Accessory");
	         rpt.Fail("Add To Cart Button NOT Displayed - For Verify All Accessory");
	         rpt.Category("CC_Shopping Cart - Verify All Accessory");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }

		//click("xpath=//*[@id='listViewAdd2Cart_3074457345616692891']"); //buy now
		if(findTheElement("id=listViewAdd2Cart_3074457345616692891").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Add To Cart Button is Displayed - For Verify Add To Cart");
	         rpt.Pass("Add To Cart Button is Displayed - For Verify Add To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=listViewAdd2Cart_3074457345616692891"); //buy now
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify Add To Cart", "Add To Cart Button NOT Displayed - For Verify Add To Cart");
	         rpt.Fail("Add To Cart Button NOT Displayed - For Verify Add To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	}
	
	//Mini Cart
	public void miniCartDisplay()throws Exception
	{
		if(findTheElement("xpath=//*[@id='widget_minishopcart']").isDisplayed())
          {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CC - Shopping Cart - Verify Mini Cart Display", "Mini Cart Button displayed - For Verify Mini Cart Display");
	         rpt.Pass("Mini Cart Button displayed - For Verify Mini Cart Display");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		  }
		else
		{
			System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CC - Shopping Cart - Verify Mini Cart Display", "Mini Cart Button NOT displayed - For Verify Mini Cart Display");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Mini Cart Display");
	         rpt.Category("CC_Shopping Cart - Verify Mini Cart Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	
	//CC_A&C_19
	public void productDisplay()throws Exception
	{
		//click("xpath=//*[@id='minishopcart_total']"); //mini cart
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CC - Shopping Cart - Verify Product Display", "Mini Cart Button displayed - For Verify Product Display");
	         rpt.Pass("Mini Cart Button displayed - For Verify Product Display");
	         rpt.Category("CC_Shopping Cart - Verify Product Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CC - Shopping Cart - Verify Product Display", "Mini Cart Button NOT displayed - For Verify Product Display");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Product Display");
	         rpt.Category("CC_Shopping Cart - Verify Product Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		if(findTheElement("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]").isDisplayed())
		{
			String total=getText("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]");
			//System.out.println("Total products displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Product Display", "Total products displayed in mini cart  - " +total);
	         rpt.Pass("Total products displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Product Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Total products NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Product Display", "Total products NOT displayed in mini cart");
	         rpt.Fail("Total products NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Product Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void itemsInCart()throws Exception
	{
		//click("xpath=//*[@id='minishopcart_total']"); //mini cart
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CC - Shopping Cart - Verify Items In Cart", "Mini Cart Button displayed - For Verify Items In Cart");
	         rpt.Pass("Mini Cart Button displayed - For Verify Items In Cart");
	         rpt.Category("CC_Shopping Cart - Verify Items In Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CC - Shopping Cart - Verify Items In Cart", "Mini Cart Button NOT displayed - For Verify Items In Cart");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Items In Cart");
	         rpt.Category("CC_Shopping Cart - Verify Items In Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		if(findTheElement("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/h3").isDisplayed())
		{
			String total=getText("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/h3");
			//System.out.println("Items displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Items In Cart", "Items displayed in mini cart  - " +total);
	         rpt.Pass("Items displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Items In Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Items NOT displayed in mini cart");
			 rpt.createTest("CC - Shopping Cart - Verify Items In Cart", "Items NOT displayed in mini cart");
	         rpt.Fail("Items NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Items In Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void close_Button()throws Exception
	{
		//click("xpath=//*[@id='minishopcart_total']"); //mini cart
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CC - Shopping Cart - Verify close_Button", "Mini Cart Button displayed - For Verify close_Button");
	         rpt.Pass("Mini Cart Button displayed - For Verify close_Button");
	         rpt.Category("CC_Shopping Cart - Verify close_Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CC - Shopping Cart - Verify close_Button", "Mini Cart Button NOT displayed - For Verify close_Button");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify close_Button");
	         rpt.Category("CC_Shopping Cart - Verify close_Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		if(findTheElement("xpath=//*[@id='MiniShopCartCloseButton_1']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='MiniShopCartCloseButton_1']");
			//System.out.println("Close Button displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify close_Button", "Close Button displayed in mini cart  - " +total);
	         rpt.Pass("Close Button displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify close_Button");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Close Button NOT displayed in mini cart");
			 rpt.createTest("CC - Shopping Cart - Verify close_Button", "Close Button NOT displayed in mini cart");
	         rpt.Fail("Close Button NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify close_Button");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=//*[@id='MiniShopCartCloseButton_1']");
	}
	public void verifyDisplay()throws Exception
	{
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Display", "Mini Cart Button displayed - For Verify Display");
	         rpt.Pass("Mini Cart Button displayed - For Verify Display");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Display", "Mini Cart Button NOT displayed - For Verify Display");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Display");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		if(findTheElement("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/div[1]/a/img").isDisplayed())
		{
			//String total=getText("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/div[1]/a/img");
			//System.out.println("Product Image displayed in mini cart ");
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Image displayed in mini cart - For Verify Display");
	         rpt.Pass("Product Image displayed in mini cart - For Verify Display");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Product Image NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Image NOT displayed in mini cart - For Verify Display");
	         rpt.Fail("Product Image NOT displayed in mini cart - For Verify Display");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		if(findTheElement("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[1]").isDisplayed())
		{
			String total=getText("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[1]");
			//System.out.println("Product Name displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Name displayed in mini cart  - " +total);
	         rpt.Pass("Product Name displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Product Name NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Name NOT displayed in mini cart");
	         rpt.Fail("Product Name NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		if(findTheElement("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[3]").isDisplayed())
		{
			String total=getText("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[3]");
			//System.out.println("Product Price displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Price displayed in mini cart  - " +total);
	         rpt.Pass("Product Price displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Product Price NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Price NOT displayed in mini cart");
	         rpt.Fail("Product Price NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		if(findTheElement("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]").isDisplayed())
		{
			String total=getText("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]");
			//System.out.println("Product Quantity displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Quantity displayed in mini cart  - " +total);
	         rpt.Pass("Product Quantity displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Product Quantity NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Display", "Product Quantity NOT displayed in mini cart");
	         rpt.Fail("Product Quantity NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Display");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}	
	
	public void productTitle()throws Exception
	{
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Product Title", "Mini Cart Button displayed - For Verify Product Title");
	         rpt.Pass("Mini Cart Button displayed - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Product Title", "Mini Cart Button NOT displayed - For Verify Product Title");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		if(findTheElement("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[1]").isEnabled())
		{
			rpt.createTest("CC - Shopping Cart - Verify Product Title", "Product Title is functional - For Verify Product Title");
	         rpt.Pass("Product Title is functional - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	        // click("xpath=//*[@id='minishopcart_total']");
			click("xpath=html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[1]/div/span[1]"); //product title
			//System.out.println("Product Title is functional");
		}
		else
		{
			//System.out.println("Product Title is NOT functional");
			rpt.createTest("CC - Shopping Cart - Verify Product Title", "Product Title is NOT functional - For Verify Product Title");
	         rpt.Fail("Product Title is NOT functional - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//CC_A&C_24
	public void subTotal()throws Exception
	{
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Sub Total", "Mini Cart Button displayed - For Verify Sub Total");
	         rpt.Pass("Mini Cart Button displayed - For Verify Sub Total");
	         rpt.Category("CC_Shopping Cart - Verify Sub Total");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Sub Total", "Mini Cart Button NOT displayed - For Verify Sub Total");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Sub Total");
	         rpt.Category("CC_Shopping Cart - Verify Sub Total");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		if(findTheElement("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]").isDisplayed())
		{
			String total=getText("xpath=/html/body/div[7]/div[2]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[1]/div[2]/span[1]");
			//System.out.println("Sub Total of Product Quantity displayed in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Sub Total", "Sub Total of Product Quantity displayed in mini cart  - " +total);
	         rpt.Pass("Sub Total of Product Quantity displayed in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Sub Total");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Sub Total of Product Quantity NOT displayed in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Sub Total", "Sub Total of Product Quantity NOT displayed in mini cart");
	         rpt.Fail("Sub Total of Product Quantity NOT displayed in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Sub Total");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void goToCart()throws Exception
	{
		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Go To Cart", "Mini Cart Button displayed - For Verify Go To Cart");
	         rpt.Pass("Mini Cart Button displayed - For Verify Go To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Go To Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Go To Cart", "Mini Cart Button NOT displayed - For Verify Go To Cart");
	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Go To Cart");
	         rpt.Category("CC_Shopping Cart - Verify Go To Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='GotoCartButton1']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='GotoCartButton1']");
			//System.out.println("Go To Cart Button is displayed and is functional in mini cart  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Go To Cart", "Go To Cart Button is displayed and is functional in mini cart  - " +total);
	         rpt.Pass("Go To Cart Button is displayed and is functional in mini cart  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Go To Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
			click("xpath=//*[@id='GotoCartButton1']");
		}
		else
		{
			//System.out.println("Go To Cart Button is NOT displayed and NOT functional in mini cart");
			rpt.createTest("CC - Shopping Cart - Verify Go To Cart", "Go To Cart Button is NOT displayed and NOT functional in mini cart");
	         rpt.Fail("Go To Cart Button is NOT displayed and NOT functional in mini cart");
	         rpt.Category("CC_Shopping Cart - Verify Go To Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//shopping cart page
	//CC_A&C_26
	public void shoppingCart()throws Exception
	{
//		click("xpath=.//*[@id='allDepartmentsButton']/span"); //products
//		Thread.sleep(5000);
//		click("xpath=.//*[@id='departmentLink_3074457345616682178_alt']"); //tv n home theatre
//		Thread.sleep(5000);
//		//click("xpath=./html/body/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/div[2]/div/a/img"); //product image
//		Thread.sleep(5000);
//		if(findTheElement("id=CatalogEntryProdImg_3074457345616727788").isDisplayed())
//		 {
//	         rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Product Detail Page is Displayed - For Verify Shopping Cart");
//	         rpt.Pass("Product Detail Page is Displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	 		click("id=CatalogEntryProdImg_3074457345616727788"); 
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Product Detail Page NOT Displayed - For Verify Shopping Cart");
//	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
//		//click("xpath=./html/body/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/div[2]/div/a/img");
//		Thread.sleep(5000);
//		//click("id=add2CartBtn"); //add to cart
//		if(findTheElement("id=add2CartBtn").isDisplayed())
//		 {
//	         rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Add To Cart Button is Displayed - For Verify Shopping Cart");
//	         rpt.Pass("Add To Cart Button is Displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("id=add2CartBtn");
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Add To Cart Button NOT Displayed - For Verify Shopping Cart");
//	         rpt.Fail("Add To Cart Button NOT Displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
//		Thread.sleep(5000);
//		click("xpath=//*[@id='MiniShopCartCloseButton_2']"); //close modal window
//		Thread.sleep(5000);
//		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
//        {
//			rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Mini Cart Button displayed - For Verify Shopping Cart");
//	         rpt.Pass("Mini Cart Button displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
//		  }
//		else
//		{
//			 rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Mini Cart Button NOT displayed - For Verify Shopping Cart");
//	         rpt.Fail("Mini Cart Button NOT displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//		//click("xpath=//*[@id='GotoCartButton1']"); //goto cart
//		if(findTheElement("xpath=//*[@id='GotoCartButton1']").isDisplayed())
//        {
//			rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Go To Cart Button displayed - For Verify Shopping Cart");
//	         rpt.Pass("Go To Cart Button displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("xpath=//*[@id='GotoCartButton1']"); //goto cart
//		  }
//		else
//		{
//			 rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Go To Cart Button NOT displayed - For Verify Shopping Cart");
//	         rpt.Fail("Go To Cart Button NOT displayed - For Verify Shopping Cart");
//	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
		
		String cart=findTheElement("id=orderItemDisplay").getText();
		String actual="Cart: ";
		if(cart.contains(actual))
		{
			rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Shopping Cart page is displayed - For Verify Shopping Cart");
	         rpt.Pass("Shopping Cart page is displayed - For Verify Shopping Cart");
	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	        // click("xpath=//*[@id='GotoCartButton1']"); //goto cart
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Shopping Cart", "Shopping Cart page is NOT displayed - For Verify Shopping Cart");
	         rpt.Fail("Shopping Cart page is NOT displayed - For Verify Shopping Cart");
	         rpt.Category("CC_Shopping Cart - Verify Shopping Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//CC_A&C_32
	public void verifySKU()throws Exception
	{
		  Map<String,String> xpaths= new HashMap<String,String>();
		  //xpaths.put("Product Image", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div/a/img");
		  xpaths.put("Product Name", "//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div/a");
		  xpaths.put("SKU", "//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/b");
		  xpaths.put("Save For Later", "//b[contains(text(),'Save for Later')]");
		  xpaths.put("Remove", "//b[contains(text(),'Remove')]");
		     for(Map.Entry<String, String> xpath : xpaths.entrySet() )
		     {
		      if(findTheElement("xpath="+xpath.getValue()+"").isDisplayed())
		      {
		             rpt.createTest("CC_Shopping Cart - Verify SKU", "Message :"+xpath.getKey()+" Displayed - For Verify SKU");
		             rpt.Pass("Message :"+xpath.getKey()+" Displayed - For Verify SKU");
		             rpt.Category("CC_Shopping Cart - Verify SKU");
		             String path = rpt.CaptureScreen(browser, "ValidMessage");
		             rpt.imgPathPass(path);
		      }
		      else
		      {
		             rpt.createTest("CC_Shopping Cart - Verify SKU", "Message is NOT :"+xpath.getKey()+" Displayed - For Verify SKU");
		             rpt.Fail("Message :"+xpath.getKey()+" NOT Displayed - For Verify SKU");
		             rpt.Category("CC_Shopping Cart - Verify SKU");
		             String path = rpt.CaptureScreen(browser, "InvalidMessage");
		             rpt.imgPathFail(path);
		      }
		      }
	}
	public void productImage()throws Exception
	{
		//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div/a/img"); //product image
		Thread.sleep(5000);
		if(findTheElement("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div/a").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Product Title", "Product Title is functional - For Verify Product Title");
	         rpt.Pass("Product Image is functional - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div/a"); //product title
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Product Title", "Product Title NOT functional - For Verify Product Title");
	         rpt.Fail("Product Title NOT functional - For Verify Product Title");
	         rpt.Category("CC_Shopping Cart - Verify Product Title");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("id=GotoCartButtonTemp");
		Thread.sleep(2000);
		
	}
	//CC_A&C_34
	public void wishList()throws Exception
	{
//		if(findTheElement("xpath=//*[@id='minishopcart_total']").isDisplayed())
//        {
//			rpt.createTest("CC - Shopping Cart - Verify WishList", "Mini Cart Button displayed - For Verify WishList");
//	         rpt.Pass("Mini Cart Button displayed - For Verify WishList");
//	         rpt.Category("CC_Shopping Cart - Verify WishList");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("xpath=//*[@id='minishopcart_total']"); //mini cart
//		  }
//		else
//		{
//			 rpt.createTest("CC - Shopping Cart - Verify WishList", "Mini Cart Button NOT displayed - For Verify WishList");
//	         rpt.Fail("Mini Cart Button NOT displayed - For Verify WishList");
//	         rpt.Category("CC_Shopping Cart - Verify WishList");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//		if(findTheElement("xpath=//*[@id='GotoCartButton1']").isDisplayed())
//        {
//			rpt.createTest("CC - Shopping Cart - Verify WishList", "Go To Cart Button displayed - For Verify WishList");
//	         rpt.Pass("Go To Cart Button displayed - For Verify WishList");
//	         rpt.Category("CC_Shopping Cart - Verify WishList");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("xpath=//*[@id='GotoCartButton1']"); //goto cart
//		  }
//		else
//		{
//			 rpt.createTest("CC - Shopping Cart - Verify WishList", "Go To Cart Button NOT displayed - For Verify WishList");
//	         rpt.Fail("Go To Cart Button NOT displayed - For Verify WishList");
//	         rpt.Category("CC_Shopping Cart - Verify WishList");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//		Thread.sleep(5000);
		
		click("xpath=//b[contains(text(),'Save for Later')]"); //save for later
		Thread.sleep(3000);
		//click("css=span.love_it_text"); //wishlist
		
		
		
		//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/a[1]/b"); //wishlist
		if(findTheElement("css=span.love_it_text").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify WishList", "WishList Button displayed - For Verify WishList");
	         rpt.Pass("WishList Button displayed - For Verify WishList");
	         rpt.Category("CC_Shopping Cart - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("css=span.love_it_text"); //wishlist
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify WishList", "WishList Button NOT displayed - For Verify WishList");
	         rpt.Fail("WishList Button NOT displayed - For Verify WishList");
	         rpt.Category("CC_Shopping Cart - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void remove()throws Exception
	{
		//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/a[2]/b"); //remove
		Thread.sleep(5000);
		if(findTheElement("xpath=//b[contains(text(),'Remove')]").isDisplayed())
        {
			rpt.createTest("CC - Shopping Cart - Verify Remove", "Remove Button displayed and functional - For Verify Remove");
	         rpt.Pass("Remove Button displayed and functional - For Verify Remove");
	         rpt.Category("CC_Shopping Cart - Verify Remove");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//b[contains(text(),'Remove')]"); //remove
		  }
		else
		{
			 rpt.createTest("CC - Shopping Cart - Verify Remove", "Remove Button NOT displayed and functional - For Verify Remove");
	         rpt.Fail("Remove Button NOT displayed and functional - For Verify Remove");
	         rpt.Category("CC_Shopping Cart - Verify Remove");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
     }
	public void availability()throws Exception
	{
		//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/span"); //remove
		Thread.sleep(5000);
		if(findTheElement("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/span").isDisplayed())
		{
			String total=getText("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/span");
			//System.out.println("Availability is displayed for every product and is functional  - " +total);
			//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/span"); //remove
			rpt.createTest("CC - Shopping Cart - Verify availability", "Availability is displayed for every product and is functional  - " +total);
	         rpt.Pass("Availability is displayed for every product and is functional  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify availability");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Availability is NOT displayed for every product and NOT functional");
			 rpt.createTest("CC - Shopping Cart - Verify availability", "Availability is NOT displayed for every product and NOT functional");
	         rpt.Fail("Availability is NOT displayed for every product and NOT functional");
	         rpt.Category("CC_Shopping Cart - Verify availability");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
     }
	public void quantity()throws Exception
	{
		if(findTheElement("xpath=//*[@id='qty_1']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='qty_1']");
			click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div"); //add
			Thread.sleep(5000);
			click("link=Update"); //update
			//System.out.println("Quantity is displayed for every product and is functional  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify quantity", "Quantity is displayed for every product and is functional   " +total);
	         rpt.Pass("Quantity is displayed for every product and is functional  " +total);
	         rpt.Category("CC_Shopping Cart - Verify quantity");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Quantity is NOT displayed for every product and NOT functional");
			 rpt.createTest("CC - Shopping Cart - Verify quantity", "Quantity is NOT displayed for every product and NOT functional");
	         rpt.Fail("Quantity is NOT displayed for every product and NOT functional");
	         rpt.Category("CC_Shopping Cart - Verify quantity");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//38
	public void price()throws Exception
	{
		if(findTheElement("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div[2]/div[2]/span").isDisplayed())
		{
			String total=getText("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div/div/div/div[2]/div[2]/span");
			//System.out.println("Price is displayed for each product  - " +total);
			//click("xpath=//*[@id='GotoCartButton1']");
			rpt.createTest("CC - Shopping Cart - Verify price", "Price is displayed for each product  - " +total);
	         rpt.Pass("Price is displayed for each product  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify price");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Price is NOT displayed for each product");
			 rpt.createTest("CC - Shopping Cart - Verify price", "Price is NOT displayed for each product");
	         rpt.Fail("Price is NOT displayed for each product");
	         rpt.Category("CC_Shopping Cart - Verify price");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//39
	public void totalPrice()throws Exception 
	{
		if(findTheElement("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[5]").isDisplayed())
		{
			//String total=getText("css=div.data total_amout");
			String total=getText("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[5]");
			rpt.createTest("CC - Shopping Cart - Verify Total price", "Total Price is displayed for each product  - " +total);
	         rpt.Pass("Total Price is displayed for each product  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Total price");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Total Price is NOT displayed for each product");
			 rpt.createTest("CC - Shopping Cart - Verify Total price", "Total Price is NOT displayed for each product");
	         rpt.Fail("Total Price is NOT displayed for each product");
	         rpt.Category("CC_Shopping Cart - Verify Total price");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}	
	public void lineSeparator()throws Exception 
	{
		if(findTheElement("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[4]").isDisplayed())
		{
			String total=getText("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[4]");
			//System.out.println("Line Seaparator is displayed for each product  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify lineSeparator", "Line Seaparator is displayed for each product");
	         rpt.Pass("Line Seaparator is displayed for each product");
	         rpt.Category("CC_Shopping Cart - Verify lineSeparator");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
			
		}
		else
		{
			//System.out.println("Line Seaparator is NOT displayed for each product");
			rpt.createTest("CC - Shopping Cart - Verify lineSeparator", "Line Seaparator is NOT displayed for each product");
	         rpt.Fail("Line Seaparator is NOT displayed for each product");
	         rpt.Category("CC_Shopping Cart - Verify lineSeparator");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void promoCode()throws Exception 
	{
		if(findTheElement("id=promoCode").isDisplayed())
		{
			String total=getText("id=promoCode");
			
			//System.out.println("Promo Code is displayed and is functional for each product  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify lineSeparator", "Promo Code is displayed and is functional for each product  - " +total);
	         rpt.Pass("Promo Code is displayed and is functional for each product  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify lineSeparator");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("id=promoCode");
		}
		else
		{
			//System.out.println("Promo Code NOT displayed and NOT functional for each product");
			rpt.createTest("CC - Shopping Cart - Verify lineSeparator", "Promo Code NOT displayed and NOT functional for each product");
	         rpt.Fail("Promo Code NOT displayed and NOT functional for each product");
	         rpt.Category("CC_Shopping Cart - Verify lineSeparator");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void promoCodeText()throws Exception 
	{
		//sendKeys("id=promoCode","10PERCOFF");
		if(findTheElement("id=promoCode").isDisplayed())
		{
			String total=getText("id=promoCode");
			
			//System.out.println("Promo Code is displayed and is functional for each product  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify promoCodeText", "Promo Code field is displayed and is functional for each product");
	         rpt.Pass("Promo Code field is displayed and is functional for each product");
	         rpt.Category("CC_Shopping Cart - Verify promoCodeText");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("id=promoCode",promocode);
		}
		else
		{
			//System.out.println("Promo Code NOT displayed and NOT functional for each product");
			rpt.createTest("CC - Shopping Cart - Verify promoCodeText", "Promo Code field NOT displayed and NOT functional for each product");
	         rpt.Fail("Promo Code field NOT displayed and NOT functional for each product");
	         rpt.Category("CC_Shopping Cart - Verify promoCodeText");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void applyButton()throws Exception 
	{
		if(findTheElement("xpath=//a[@id='WC_PromotionCodeDisplay_links_1']/div[2]").isDisplayed())
		{
			String total=getText("xpath=//a[@id='WC_PromotionCodeDisplay_links_1']/div[2]");
			//click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/form/div[3]/div/a/div[2]");
			//System.out.println("Apply Button is displayed and is functional for each product  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify applyButton", "Apply Button is displayed and is functional for each product  - " +total);
	         rpt.Pass("Apply Button is displayed and is functional for each product  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify applyButton");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
			click("xpath=//a[@id='WC_PromotionCodeDisplay_links_1']/div[2]");

		}
		else
		{
			//System.out.println("Apply Button NOT displayed and NOT functional for each product");
			rpt.createTest("CC - Shopping Cart - Verify applyButton", "Apply Button NOT displayed and NOT functional for each product");
	         rpt.Fail("Apply Button NOT displayed and NOT functional for each product");
	         rpt.Category("CC_Shopping Cart - Verify applyButton");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//44
	public void orderTotal()throws Exception
	{
		Map<String,String> xpaths= new HashMap<String,String>();
		  xpaths.put("Order Subtotal", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[1]/span[2]");
		  xpaths.put("Promo", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/span[2]");
		  xpaths.put("Order Total", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[5]/span[2]");
		  //xpaths.put("Remove", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/a[2]/b");
		     for(Map.Entry<String, String> xpath : xpaths.entrySet() )
		     {
		      if(findTheElement("xpath="+xpath.getValue()+"").isDisplayed())
		      {
		             rpt.createTest("CC_Shopping Cart - Verify Order Total", "Message :"+xpath.getKey()+" Displayed - For Verify Order Total");
		             rpt.Pass("Message :"+xpath.getKey()+" Displayed - For Verify Order Total");
		             rpt.Category("CC_Shopping Cart - Verify Order Total");
		             String path = rpt.CaptureScreen(browser, "ValidMessage");
		             rpt.imgPathPass(path);
		      }
		      else
		      {
		             rpt.createTest("CC_Shopping Cart - Verify Order Total", "Message is NOT :"+xpath.getKey()+" Displayed - For Verify Order Total");
		             rpt.Fail("Message :"+xpath.getKey()+" NOT Displayed - For Verify Order Total");
		             rpt.Category("CC_Shopping Cart - Verify Order Total");
		             String path = rpt.CaptureScreen(browser, "InvalidMessage");
		             rpt.imgPathFail(path);
		      }
		      }
	}
	//46
	public void guestDetails()throws Exception
	{
		Map<String,String> xpaths= new HashMap<String,String>();
		  xpaths.put("Checkout as guest", "//*[@id='guestShopperContinue']");
		  xpaths.put("Create an account", "/html/body/form/div[2]/div/div[2]/div/div[3]/a/div[2]");
		  //xpaths.put("Order Total", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[6]/span[2]");
		  //xpaths.put("Remove", "/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/a[2]/b");
		     for(Map.Entry<String, String> xpath : xpaths.entrySet() )
		     {
		      if(findTheElement("xpath="+xpath.getValue()+"").isDisplayed())
		      {
		             rpt.createTest("CC_Shopping Cart - Verify Guest Details", "Message :"+xpath.getKey()+" Displayed - For Verify Guest Details");
		             rpt.Pass("Message :"+xpath.getKey()+" Displayed - For Verify Guest Details");
		             rpt.Category("CC_Shopping Cart - Verify Guest Details");
		             String path = rpt.CaptureScreen(browser, "ValidMessage");
		             rpt.imgPathPass(path);
		      }
		      else
		      {
		             rpt.createTest("CC_Shopping Cart - Verify Guest Details", "Message is NOT :"+xpath.getKey()+" Displayed - For Verify Guest Details");
		             rpt.Fail("Message :"+xpath.getKey()+" NOT Displayed - For Verify Guest Details");
		             rpt.Category("CC_Shopping Cart - Verify Guest Details");
		             String path = rpt.CaptureScreen(browser, "InvalidMessage");
		             rpt.imgPathFail(path);
		      }
		      }
	}
	//47
	public void checkOut()throws Exception 
	{
		//click("link=READY TO CHECKOUT");
		if(findTheElement("link=READY TO CHECKOUT").isDisplayed())
		{
			
			rpt.createTest("CC - Shopping Cart - Verify checkOut", "Ready To Checkout is displayed and is functional ");
	         rpt.Pass("Ready To Checkout is displayed and is functional" );
	         rpt.Category("CC_Shopping Cart - Verify checkOut");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("link=READY TO CHECKOUT");
		}
		else
		{
			//System.out.println("Checkout Button NOT displayed and NOT functional for each product");
			rpt.createTest("CC - Shopping Cart - Verify checkOut", "Ready To Checkout NOT displayed and functional");
	         rpt.Fail("Ready To Checkout NOT displayed and functional");
	         rpt.Category("CC_Shopping Cart - Verify checkOut");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
		Thread.sleep(2000);
		click("id=guestShopperContinue");
//		if(findTheElement("xpath=//*[@id='guestShopperContinue']").isDisplayed())
//		{
//			String total=getText("xpath=//*[@id='guestShopperContinue']");
//			click("xpath=//*[@id='guestShopperContinue']");
//			//System.out.println("Checkout Button is displayed and is functional for each product  - " +total);
//			rpt.createTest("CC - Shopping Cart - Verify checkOut", "Checkout as guest is displayed  - " +total);
//	         rpt.Pass("Checkout as guest is displayed  - " +total);
//	         rpt.Category("CC_Shopping Cart - Verify checkOut");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	         click("xpath=//*[@id='guestShopperContinue']");
//		}
//		else
//		{
//			//System.out.println("Checkout Button NOT displayed and NOT functional for each product");
//			rpt.createTest("CC - Shopping Cart - Verify checkOut", "Checkout as guest NOT displayed");
//	         rpt.Fail("Checkout as guest NOT displayed");
//	         rpt.Category("CC_Shopping Cart - Verify checkOut");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
		
		
		
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1").clear();
	    sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1",address);
		Thread.sleep(3000);
		//findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1").clear();
		click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1",city);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1",state);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		Thread.sleep(2000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1",emailid);
		Thread.sleep(2000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1",phoneNo);
		Thread.sleep(2000);
		click("id=summaryButton"); //continue
		Thread.sleep(3000);
		click("xpath=//a[contains(text(),'Back to Cart')]"); //back to cart
		
		
	}
	//49
	public void userName()throws Exception
	{
		if(findTheElement("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']");
			//click("xpath=//*[@id='guestShopperContinue']");
			//System.out.println("User name is displayed  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify userName", "User name is displayed  - " +total);
	         rpt.Pass("User name is displayed  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify userName");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("User name NOT displayed ");
			rpt.createTest("CC - Shopping Cart - Verify userName", "User name NOT displayed ");
	         rpt.Fail("User name NOT displayed ");
	         rpt.Category("CC_Shopping Cart - Verify userName");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	public void Password()throws Exception
	{
		if(findTheElement("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonPassword']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonPassword']");
			//click("xpath=//*[@id='guestShopperContinue']");
			//System.out.println("User password is displayed  - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Password", "User Password is displayed  - " +total);
	         rpt.Pass("User Password is displayed  - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Password");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("User password NOT displayed ");
			rpt.createTest("CC - Shopping Cart - Verify Password", "User Password NOT displayed ");
	         rpt.Fail("User Password NOT displayed ");
	         rpt.Category("CC_Shopping Cart - Verify Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//51
	public void forgotPassword()throws Exception
	{
		if(findTheElement("xpath=//*[@id='WC_CheckoutLogonf_links_1']").isDisplayed())
		{
			String total=getText("xpath=//*[@id='WC_CheckoutLogonf_links_1']");
			//System.out.println("Forgot password is displayed and is functional - " +total);
			rpt.createTest("CC - Shopping Cart - Verify Password", "Forgot password is displayed and is functional - " +total);
	         rpt.Pass("Forgot password is displayed and is functional - " +total);
	         rpt.Category("CC_Shopping Cart - Verify Password");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='WC_CheckoutLogonf_links_1']");
		}
		else
		{
			//System.out.println("Forgot password NOT displayed and functional");
			rpt.createTest("CC - Shopping Cart - Verify Password", "Forgot password NOT displayed and functional ");
	         rpt.Fail("Forgot password NOT displayed and functional");
	         rpt.Category("CC_Shopping Cart - Verify Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//52
	public void signincheckout()throws Exception
	{
		//click("xpath=//*[@id='widget_minishopcart']");
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='widget_minishopcart']").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify signincheckout", "Mini Cart is Displayed - For Verify signincheckout");
	         rpt.Pass("Mini Cart is Displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='widget_minishopcart']");
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify signincheckout", "Mini Cart is NOT displayed - For Verify signincheckout");
	         rpt.Fail("Mini Cart is NOT displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=/html/body/div[2]/div/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div[2]/a/span");
		Thread.sleep(5000);
		click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[8]/a");
		Thread.sleep(5000);
		//sendKeys("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']","zainab.firdaus@royalcyber.com");
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify signincheckout", "User Name is Displayed - For Verify signincheckout");
	         rpt.Pass("User Name is Displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']","zainab.firdaus@royalcyber.com");
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify signincheckout", "User Name is NOT displayed - For Verify signincheckout");
	         rpt.Fail("User Name is NOT displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//sendKeys("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonPassword']","zain@1926");
		if(findTheElement("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonId']").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify signincheckout", "User Password is Displayed - For Verify signincheckout");
	         rpt.Pass("User Password is Displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='WC_CheckoutLogon_FormInput_logonPassword']","zain@1926");
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify signincheckout", "User Password is NOT displayed - For Verify signincheckout");
	         rpt.Fail("User Password is NOT displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		//click("xpath=/html/body/form/div[2]/div/div[1]/div[2]/div/div[1]/div/a/div[2]"); //sign in
		if(findTheElement("xpath=/html/body/form/div[2]/div/div[1]/div[2]/div/div[1]/div/a/div[2]").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify signincheckout", "Sign In Button is Displayed - For Verify signincheckout");
	         rpt.Pass("Sign In Button is Displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=/html/body/form/div[2]/div/div[1]/div[2]/div/div[1]/div/a/div[2]"); //sign in
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify signincheckout", "Sign In Button is NOT displayed - For Verify signincheckout");
	         rpt.Fail("Sign In Button is NOT displayed - For Verify signincheckout");
	         rpt.Category("CC_Shopping Cart - Verify signincheckout");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//59
	public void keepTrack()throws Exception
	{
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); //tv and home theatre
		Thread.sleep(5000);
		//click("id=CatalogEntryProdImg_3074457345616727788"); 
		Thread.sleep(8000);
		if(findTheElement("id=CatalogEntryProdImg_3074457345616727788").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify keepTrack", "Product Detail Page is Displayed - For Verify keepTrack");
	         rpt.Pass("Product Detail Page is Displayed - For Verify keepTrack");
	         rpt.Category("CC_Shopping Cart - Verify keepTrack");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=CatalogEntryProdImg_3074457345616727788"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify keepTrack", "Product Detail Page NOT Displayed - For Verify keepTrack");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify keepTrack");
	         rpt.Category("CC_Shopping Cart - Verify keepTrack");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		click("xpath=/html/body/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div/div[2]/a[1]/span"); //view my cart
		Thread.sleep(5000);
		if(findTheElement("xpath=/html/body/div[2]/div/div/div[1]/div/div/div[1]/span").isDisplayed())
		{
			//System.out.println("Free Shipping details displayed");
			rpt.createTest("CC - Shopping Cart - Verify keepTrack", "Free Shipping details displayed - For Verify keepTrack");
	         rpt.Pass("Free Shipping details displayed - For Verify keepTrack");
	         rpt.Category("CC_Shopping Cart - Verify keepTrack");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Free Shipping details NOT displayed");
			 rpt.createTest("CC - Shopping Cart - Verify keepTrack", "Free Shipping details NOT displayed - For Verify keepTrack");
	         rpt.Fail("Free Shipping details NOT displayed - For Verify keepTrack");
	         rpt.Category("CC_Shopping Cart - Verify keepTrack");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	//64
	public void moveItems()throws Exception
	{
		click("xpath=/html/body/div[1]/div[5]/div[1]/a"); //back to cart
		Thread.sleep(5000);
		//click("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/a[1]/b"); //save for later
		if(findTheElement("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/a[1]/b").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify moveItems", "Save For Later is Displayed - For Verify moveItems");
	         rpt.Pass("Save For Later is Displayed - For Verify moveItems");
	         rpt.Category("CC_Shopping Cart - Verify moveItems");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/a[1]/b"); //sign in
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify moveItems", "Save For Later is NOT displayed - For Verify moveItems");
	         rpt.Fail("Save For Later is NOT displayed - For Verify moveItems");
	         rpt.Category("CC_Shopping Cart - Verify moveItems");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		
	}
	
	public void saveForLater()throws Exception
	{
		//click("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/a[1]/span"); //wishlist
		if(findTheElement("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/a[1]/span").isDisplayed())
		{
			 //System.out.println("Mini Cart is displayed");
			 rpt.createTest("CC - Shopping Cart - Verify saveForLater", "WishList is Displayed - For Verify saveForLater");
	         rpt.Pass("WishList is Displayed - For Verify saveForLater");
	         rpt.Category("CC_Shopping Cart - Verify saveForLater");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=/html/body/div[1]/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/a[1]/span"); //wishlist
		}
		else
		{
			//System.out.println("Mini Cart is NOT displayed");
			rpt.createTest("CC - Shopping Cart - Verify saveForLater", "WishList is NOT displayed - For Verify saveForLater");
	         rpt.Fail("WishList is NOT displayed - For Verify saveForLater");
	         rpt.Category("CC_Shopping Cart - Verify saveForLater");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
	}
	//69
	public void shoppingList()throws Exception
	{
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		//click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); //tv and home theatre
		if(findTheElement("xpath=//*[@id='departmentLink_3074457345616682178_alt']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Product Detail Page is Displayed - For Verify shoppingList");
	         rpt.Pass("Product Detail Page is Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=CatalogEntryProdImg_3074457345616727788"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Product Detail Page NOT Displayed - For Verify shoppingList");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		click("xpath=/html/body/div[3]/div[3]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div/a/img");
		
		Thread.sleep(5000);
		//click("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img"); //luv it
		if(findTheElement("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Luv it icon is Displayed - For Verify shoppingList");
	         rpt.Pass("Luv it icon is Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img"); //luv it
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Luv it icon NOT Displayed - For Verify shoppingList");
	         rpt.Fail("Luv it icon NOT Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//click("id=wishListQuickLink_alt"); //wishlist
		if(findTheElement("id=wishListQuickLink_alt").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify shoppingList", "wishlist is Displayed - For Verify shoppingList");
	         rpt.Pass("wishlist is Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=wishListQuickLink_alt"); //wishlist
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify shoppingList", "wishlist NOT Displayed - For Verify shoppingList");
	         rpt.Fail("wishlist NOT Displayed - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//click("id=listViewAdd2Cart_3074457345616727861"); //buy now
		if(findTheElement("id=listViewAdd2Cart_3074457345616727861").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Product is moved to cart - For Verify shoppingList");
	         rpt.Pass("Product is moved to cart - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=listViewAdd2Cart_3074457345616727861"); //buy now
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify shoppingList", "Product NOT moved to cart - For Verify shoppingList");
	         rpt.Fail("Product NOT moved to cart - For Verify shoppingList");
	         rpt.Category("CC_Shopping Cart - Verify shoppingList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		click("xpath=/html/body/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div/div/div/div/div/div[2]/a[1]/span"); //view my cart
		Thread.sleep(5000);
	}
	public void saveProducts()throws Exception
	{
		click("id=allDepartmentsButton"); //products
		Thread.sleep(5000);
		//click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); //tv and home theatre
		if(findTheElement("xpath=//*[@id='departmentLink_3074457345616682178_alt']").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify saveProducts", "Product Detail Page is Displayed - For Verify saveProducts");
	         rpt.Pass("Product Detail Page is Displayed - For Verify saveProducts");
	         rpt.Category("CC_Shopping Cart - Verify saveProducts");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=CatalogEntryProdImg_3074457345616727788"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify saveProducts", "Product Detail Page NOT Displayed - For Verify saveProducts");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify saveProducts");
	         rpt.Category("CC_Shopping Cart - Verify saveProducts");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		click("xpath=/html/body/div[3]/div[3]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div/a/img");
		//Thread.sleep(5000);
		click("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img"); //luv it
		if(findTheElement("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify saveProducts", "Luv it icon is Displayed - For Verify saveProducts");
	         rpt.Pass("Luv it icon is Displayed - For Verify saveProducts");
	         rpt.Category("CC_Shopping Cart - Verify saveProducts");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=/html/body/div[8]/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/div/div/span/div[2]/div[1]/img"); //luv it
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify saveProducts", "Luv it icon NOT Displayed - For Verify saveProducts");
	         rpt.Pass("Luv it icon NOT Displayed - For Verify saveProducts");
	         rpt.Category("CC_Shopping Cart - Verify saveProducts");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
	}
	
	//71
	public void manageProduct()throws Exception
	{
		//click("id=wishListQuickLink_alt"); //wishlist
		if(findTheElement("id=wishListQuickLink_alt").isDisplayed())
		 {
	         rpt.createTest("CC - Shopping Cart - Verify manageProduct", "wishlist is Displayed - For Verify manageProduct");
	         rpt.Pass("wishlist is Displayed - For Verify manageProduct");
	         rpt.Category("CC_Shopping Cart - Verify manageProduct");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("id=wishListQuickLink_alt"); //wishlist
		 }
		 else
		 {
			 rpt.createTest("CC - Shopping Cart - Verify manageProduct", "wishlist NOT Displayed - For Verify manageProduct");
	         rpt.Fail("wishlist NOT Displayed - For Verify manageProduct");
	         rpt.Category("CC_Shopping Cart - Verify manageProduct");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		if(findTheElement("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727861_links_14").isDisplayed())
		{
			String total=getText("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727861_links_14");
			
			//System.out.println("Remove button is displayes and is functional - " +total);
			rpt.createTest("CC - Shopping Cart - Verify manageProduct", "Remove button is displayed and is functional - " +total);
	         rpt.Pass("Remove button is displayed and is functional - " +total);
	         rpt.Category("CC_Shopping Cart - Verify manageProduct");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727861_links_14");
		}
		else
		{
			//System.out.println("Remove button NOT displayes and NOT functional");
			rpt.createTest("CC - Shopping Cart - Verify manageProduct", "Remove button NOT displayed and NOT functional");
	         rpt.Fail("Remove button NOT displayed and NOT functional");
	         rpt.Category("CC_Shopping Cart - Verify manageProduct");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	
}
