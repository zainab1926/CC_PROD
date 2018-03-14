package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckoutFlow extends Browser
{
	Report rpt = new Report();
	String paypalid="personal@circuitcity.com";
	String paypalpwd="12345678";
	String address="120 Greenwich St";
	String city="New York";
	String state="NY";
	String zipCode="10006";
	String creditCardNo="5555555555554444";
	String cvv="123";
	CommonUtils email = new CommonUtils();
	String name=email.getRandomString(6);
	String phoneNo=email.getRandomNumber(10);
	String emailid="user@test.com";
	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	
	public void executeAll() throws Exception
	{
//     	placeOrder_flow(); //for qa environment
		checkout_flow(); //for prod environment
		//paypalCheckout(); //for qa environment
	}
	
	//for prod environment
	public void checkout_flow()throws Exception
	{
		Thread.sleep(3000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Creative')]"); //product
		//click("xpath=//li[1]/.//div[@class='product_image']");
		click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(5000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Appliances");//categories
		Thread.sleep(4000);
//		     WebElement Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
//		     JavascriptExecutor jse = (JavascriptExecutor)browser;
//		      jse.executeScript("arguments[0].scrollIntoView();", Element);
//		      Thread.sleep(3000);
		//click("xpath=//li[2]/.//div[@class='product_image']"); //product
		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Cell Phones");//categories
		Thread.sleep(4000);
		//click("xpath=//li[3]/.//div[@class='product_image']"); //product
		click("xpath=//div[@class='product_listing_container']//li[3]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Movies & Music");//categories
		Thread.sleep(4000);
		//click("xpath=//li[4]/.//div[@class='product_image']"); //product
		click("xpath=//div[@class='product_listing_container']//li[4]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		//click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div[2]/div/a/b"); //save for later
		if(findTheElement("xpath=//b[contains(text(),'Save for Later')]").isDisplayed())
	        {
//				//System.out.println("Mini Cart Button displayed");
				rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product is moved to Save For Later from Cart");
		         rpt.Pass("Product is moved to Save For Later from Cart");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
//			    //click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div[2]/div/a/b"); //save for later
		         click("xpath=//b[contains(text(),'Save for Later')]");
			  }
			else
			{
				//System.out.println("Mini Cart Button NOT displayed");
				 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product NOT moved to Save For Later from Cart");
		         rpt.Fail("Product NOT moved to Save For Later from Cart");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
		}
		Thread.sleep(6000);
		  WebElement Element = findTheElement("xpath=//span[contains(text(),'Move to Cart')]");
		     JavascriptExecutor jse = (JavascriptExecutor)browser;
		         jse.executeScript("arguments[0].scrollIntoView();", Element);
		         Thread.sleep(3000);
		if(findTheElement("xpath=//span[contains(text(),'Move to Cart')]").isDisplayed())
       {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product is moved to Cart from Save For Later");
	         rpt.Pass("Product is moved to Cart from Save For Later");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		    //click("css=div.blue"); //save for later
//	         //click("xpath=//div[@id='ShopCartPagingDisplay']/div[2]/div/div[2]/div/div[2]/div/div/div/div/a/span");
//	         //click("xpath=.//*[@id='WC_ShopCartDisplay_div_6']/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/a[1]/span");
	         click("xpath=//span[contains(text(),'Move to Cart')]");
		  }
	else
		{
//			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product NOT moved to Cart from Save For Later");
	         rpt.Fail("Product NOT moved to Cart from Save For Later");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
	Thread.sleep(2000);
		
		
		click("link=READY TO CHECKOUT");
		Thread.sleep(2000);
		click("id=guestShopperContinue"); //chckout as guest
		Thread.sleep(2000);
		if(findTheElement("link=Back to Cart").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Back button is functional and navigated back to cart page");
	         rpt.Pass("Back button is functional and navigated back to cart page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		    click("link=Back to Cart"); //back to cart
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Back button NOT functional and navigated back to cart page");
	         rpt.Fail("Back button NOT functional and navigated back to cart page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(2000);
		click("link=READY TO CHECKOUT");
		Thread.sleep(2000);
		click("id=guestShopperContinue"); //chckout as guest
		Thread.sleep(2000);
		
		String chkoutpage=findTheElement("xpath=//div[@id='shippingActive']/h2").getText();
		System.out.println(chkoutpage);
		String actualtxt="1. Shipping";
		if(chkoutpage.contains(actualtxt))
       {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Guest Checkout is navigating to Shipping Page");
	         rpt.Pass("Guest Checkout is navigating to Shipping Page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Guest Checkout NOT navigating to Shipping Page");
	         rpt.Fail("Guest Checkout NOT navigating to Shipping Page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//invalid address
		 sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1","Qr 88, B.H.Area Kadma");
			Thread.sleep(3000);
			click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1","Jamshedpur");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1","Jharkhand");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1","831005");
			Thread.sleep(2000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1",emailid);
			Thread.sleep(2000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1",phoneNo);
			Thread.sleep(2000);
			click("id=summaryButton"); //continue
			Thread.sleep(2000);
			String chkoutpage1=findTheElement("id=errorToSuggestedAddressDiv_ShippingAddressForm").getText();
			System.out.println(chkoutpage1);
			String actualtxt1="The Address you have entered is not valid. Please enter a valid address";
			if(chkoutpage1.contains(actualtxt1))
	       {
				//System.out.println("Mini Cart Button displayed");
				rpt.createTest("CIRCUIT CITY - CHECKOUT", "Error message displayed for Invalid Address");
		         rpt.Pass("Error message displayed for Invalid Address");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			  }
			else
			{
				//System.out.println("Mini Cart Button NOT displayed");
				 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Error message NOT displayed for Invalid Address");
		         rpt.Fail("Error message NOT displayed for Invalid Address");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
			
		
		//address
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
			
			//billing method
			Map<String,String> fields= new HashMap<String,String>();
		       fields.put("Billing Address", ".//*[@id='billingAction1']/h3");
		       fields.put("Billing Information", ".//*[@id='paymentActive']/h3");
		       fields.put("Credit Card Type", ".//*[@id='paymentActive']/div[6]/img");
		       fields.put("PayPal", "/html/body/div");
		      // fields.put("Choose Files", ".//*[@id='batch-basic-info']/div[5]/div/div[1]/div/div[2]/label");
		      
		       for(Map.Entry<String, String> field : fields.entrySet() )
		       {
		        if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		        {
		         rpt.createTest("CIRCUIT CITY - CHECKOUT", "Fields :"+field.getKey()+" Displayed on the page");
		               rpt.Pass("Fields :"+field.getKey()+" Displayed on the page");
		               rpt.Category("CIRCUIT CITY - CHECKOUT");
		               String path = rpt.CaptureScreen(browser, "ValidMessage");
		               rpt.imgPathPass(path);
		        }
		        else
		        {
		         rpt.createTest("CIRCUIT CITY - CHECKOUT", "Fields :"+field.getKey()+" NOT Displayed on the page");
		               rpt.Fail("Fields :"+field.getKey()+" NOT Displayed on the page");
		               rpt.Category("CIRCUIT CITY - CHECKOUT");
		               String path = rpt.CaptureScreen(browser, "InvalidMessage");
		               rpt.imgPathFail(path);
		        }
		       }
			//paypal checkout
		       Thread.sleep(5000);
		       //click("xpath=/html/body/div");
		       Thread.sleep(3000);
		      //checkout with credit card
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-number")));
		       sendKeys("id=credit-card-number",creditCardNo);
		      
		       browser.switchTo().defaultContent();
		       Thread.sleep(2000);
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-cvv")));
		       sendKeys("id=cvv",cvv);
		       Thread.sleep(2000);
		       browser.switchTo().defaultContent();
		       Thread.sleep(2000);
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationYear")));
		       WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-year']"));
		       Select select = new Select(monthdd);
				select.selectByVisibleText("2022");
		       Thread.sleep(2000);
		       browser.switchTo().defaultContent();
		       Thread.sleep(3000);
		       click("id=submit"); //continue
		       Thread.sleep(6000);
		       WebElement Element1 = findTheElement("id=summaryButton");
				 JavascriptExecutor jse1 = (JavascriptExecutor)browser;
			      jse1.executeScript("arguments[0].scrollIntoView();", Element1);
			      Thread.sleep(3000);
		       click("id=summaryButton"); //place order
	}
	
	//for qa environment
	public void placeOrder_flow()throws Exception
	{ 
		Thread.sleep(3000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Creative')]"); //product
		click("xpath=//li[1]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(3000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Appliances");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Panasonic')]"); //product
		click("xpath=//li[2]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Cell Phones");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'CTA')]"); //product
		click("xpath=//li[3]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Movies & Music");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Panasonic')]"); //product
		click("xpath=//li[4]/.//div[@class='product_name']");
		Thread.sleep(8000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(2000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		//click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div[2]/div/a/b"); //save for later
		if(findTheElement("xpath=//b[contains(text(),'Save for Later')]").isDisplayed())
	        {
				//System.out.println("Mini Cart Button displayed");
				rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product is moved to Save For Later from Cart");
		         rpt.Pass("Product is moved to Save For Later from Cart");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			    //click("xpath=//div[@id='ShopCartPagingDisplay']/div/div[2]/div[2]/div/div[2]/div/a/b"); //save for later
		         click("xpath=//b[contains(text(),'Save for Later')]");
			  }
			else
			{
				//System.out.println("Mini Cart Button NOT displayed");
				 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product NOT moved to Save For Later from Cart");
		         rpt.Fail("Product NOT moved to Save For Later from Cart");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		 WebElement Element = findTheElement("xpath=//span[contains(text(),'Move to Cart')]");
	     JavascriptExecutor jse = (JavascriptExecutor)browser;
	         jse.executeScript("arguments[0].scrollIntoView();", Element);
	         Thread.sleep(3000);
		if(findTheElement("xpath=//span[contains(text(),'Move to Cart')]").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product is moved to Cart from Save For Later");
	         rpt.Pass("Product is moved to Cart from Save For Later");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		    //click("css=div.blue"); //save for later
	         //click("xpath=//div[@id='ShopCartPagingDisplay']/div[2]/div/div[2]/div/div[2]/div/div/div/div/a/span");
	         //click("xpath=.//*[@id='WC_ShopCartDisplay_div_6']/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div/a[1]/span");
	         click("xpath=//span[contains(text(),'Move to Cart')]");
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Product NOT moved to Cart from Save For Later");
	         rpt.Fail("Product NOT moved to Cart from Save For Later");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
	Thread.sleep(2000);
		
		
		click("link=READY TO CHECKOUT");
		Thread.sleep(2000);
		click("id=guestShopperContinue"); //chckout as guest
		Thread.sleep(2000);
		if(findTheElement("link=Back to Cart").isDisplayed())
        {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Back button is functional and navigated back to cart page");
	         rpt.Pass("Back button is functional and navigated back to cart page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		    click("link=Back to Cart"); //back to cart
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Back button NOT functional and navigated back to cart page");
	         rpt.Fail("Back button NOT functional and navigated back to cart page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(2000);
		click("link=READY TO CHECKOUT");
		Thread.sleep(2000);
		click("id=guestShopperContinue"); //chckout as guest
		Thread.sleep(2000);
		
		String chkoutpage=findTheElement("xpath=//div[@id='shippingActive']/h2").getText();
		System.out.println(chkoutpage);
		String actualtxt="1. Shipping";
		if(chkoutpage.contains(actualtxt))
       {
			//System.out.println("Mini Cart Button displayed");
			rpt.createTest("CIRCUIT CITY - CHECKOUT", "Guest Checkout is navigating to Shipping Page");
	         rpt.Pass("Guest Checkout is navigating to Shipping Page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		  }
		else
		{
			//System.out.println("Mini Cart Button NOT displayed");
			 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Guest Checkout NOT navigating to Shipping Page");
	         rpt.Fail("Guest Checkout NOT navigating to Shipping Page");
	         rpt.Category("CIRCUIT CITY - CHECKOUT");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//invalid address
		 sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1","Qr 88, B.H.Area Kadma");
			Thread.sleep(3000);
			click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1","Jamshedpur");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1","Jharkhand");
			Thread.sleep(3000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1","831005");
			Thread.sleep(2000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1",emailid);
			Thread.sleep(2000);
			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1",phoneNo);
			Thread.sleep(2000);
			click("id=summaryButton"); //continue
			Thread.sleep(2000);
			String chkoutpage1=findTheElement("id=errorToSuggestedAddressDiv_ShippingAddressForm").getText();
			System.out.println(chkoutpage1);
			String actualtxt1="The Address you have entered is not valid. Please enter a valid address";
			if(chkoutpage1.contains(actualtxt1))
	       {
				//System.out.println("Mini Cart Button displayed");
				rpt.createTest("CIRCUIT CITY - CHECKOUT", "Error message displayed for Invalid Address");
		         rpt.Pass("Error message displayed for Invalid Address");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			  }
			else
			{
				//System.out.println("Mini Cart Button NOT displayed");
				 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Error message NOT displayed for Invalid Address");
		         rpt.Fail("Error message NOT displayed for Invalid Address");
		         rpt.Category("CIRCUIT CITY - CHECKOUT");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
			
		
		//address
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
			
			//billing method
			Map<String,String> fields= new HashMap<String,String>();
		       fields.put("Billing Address", ".//*[@id='billingAction1']/h3");
		       fields.put("Billing Information", ".//*[@id='paymentActive']/h3");
		       fields.put("Credit Card Type", ".//*[@id='paymentActive']/div[6]/img");
		       fields.put("PayPal", "/html/body/div");
		      // fields.put("Choose Files", ".//*[@id='batch-basic-info']/div[5]/div/div[1]/div/div[2]/label");
		      
		       for(Map.Entry<String, String> field : fields.entrySet() )
		       {
		        if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		        {
		         rpt.createTest("CIRCUIT CITY - CHECKOUT", "Fields :"+field.getKey()+" Displayed on the page");
		               rpt.Pass("Fields :"+field.getKey()+" Displayed on the page");
		               rpt.Category("CIRCUIT CITY - CHECKOUT");
		               String path = rpt.CaptureScreen(browser, "ValidMessage");
		               rpt.imgPathPass(path);
		        }
		        else
		        {
		         rpt.createTest("CIRCUIT CITY - CHECKOUT", "Fields :"+field.getKey()+" NOT Displayed on the page");
		               rpt.Fail("Fields :"+field.getKey()+" NOT Displayed on the page");
		               rpt.Category("CIRCUIT CITY - CHECKOUT");
		               String path = rpt.CaptureScreen(browser, "InvalidMessage");
		               rpt.imgPathFail(path);
		        }
		       }
			//paypal checkout
		       Thread.sleep(5000);
		       //click("xpath=/html/body/div");
		       Thread.sleep(3000);
		      //checkout with credit card
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-number")));
		       sendKeys("id=credit-card-number",creditCardNo);
		      
		       browser.switchTo().defaultContent();
		       Thread.sleep(2000);
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-cvv")));
		       sendKeys("id=cvv",cvv);
		       Thread.sleep(2000);
		       browser.switchTo().defaultContent();
		       Thread.sleep(2000);
		       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationYear")));
		       WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-year']"));
		       Select select = new Select(monthdd);
				select.selectByVisibleText("2022");
		       Thread.sleep(2000);
		       browser.switchTo().defaultContent();
		       Thread.sleep(4000);
		       click("id=summaryButton"); //continue
		       Thread.sleep(6000);
//		       WebElement Element1 = findTheElement("id=summaryButton");
//				 JavascriptExecutor jse1 = (JavascriptExecutor)browser;
//			      jse1.executeScript("arguments[0].scrollIntoView();", Element1);
			      Thread.sleep(3000);
		       //click("id=summaryButton"); //place order
			      click("id=placeOrder"); //place order
		       Thread.sleep(3000);
		       String chkoutpage11=findTheElement("css=div.logo-bar").getText();
				System.out.println(chkoutpage11);
				//String actualtxt11="The Address you have entered is not valid. Please enter a valid address";
				if(chkoutpage11!=null)
		       {
					//System.out.println("Mini Cart Button displayed");
					rpt.createTest("CIRCUIT CITY - CHECKOUT", "Order is placed" );
			         rpt.Pass("Order is placed");
			         rpt.Category("CIRCUIT CITY - CHECKOUT");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				  }
				else
				{
					//System.out.println("Mini Cart Button NOT displayed");
					 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Order is NOT placed");
			         rpt.Fail("Order is NOT placed");
			         rpt.Category("CIRCUIT CITY - CHECKOUT");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}
		       
	}
	//paypal checkout
	  public void paypalCheckout ()throws Exception
	    {
		        Thread.sleep(3000);
//				click("id=allDepartmentsButton");
//				Thread.sleep(2000);
//				click("link=Audio");//categories
//				Thread.sleep(2000);
//				click("xpath=//a[contains(text(),'Creative')]"); //product
//				//click("xpath=//li[1]/.//div[@class='product_image']");
//				Thread.sleep(8000);
//				click("id=add2CartBtn");//add to cart
//				Thread.sleep(3000);
//				click("xpath=//a[@id='WC_BreadCrumbTrailDisplay_links_2a']/div[2]"); //continue shopping
//				Thread.sleep(2000);
				click("id=allDepartmentsButton");
				Thread.sleep(2000);
				click("link=Appliances");//categories
				Thread.sleep(2000);
				//click("xpath=//a[contains(text(),'Panasonic')]"); //product
				click("xpath=//li[2]/.//div[@class='product_name']");
				Thread.sleep(8000);
				click("id=add2CartBtn");//add to cart
				Thread.sleep(2000);
				click("id=GotoCartButton2"); //view my cart
				Thread.sleep(2000);
				click("link=READY TO CHECKOUT");
				Thread.sleep(2000);
				click("id=guestShopperContinue"); //chckout as guest
				Thread.sleep(2000);
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
				Thread.sleep(5000);
				 WebElement Element = findTheElement("id=submit");
			     JavascriptExecutor jse = (JavascriptExecutor)browser;
			      jse.executeScript("arguments[0].scrollIntoView();", Element);
			      Thread.sleep(3000);
			      
			   // Store the current window handle
			      String winHandleBefore = browser.getWindowHandle();
			      
			      click("id=paypal-button"); //paypal button
			      //browser.switchTo().frame(browser.findElement(By.css("div.xcomponent-component-frame xcomponent-visible")));
				//click("xpath=html/body/div/div[1]");
			      //click("xpath=/html/body/div/div[1]/img[1]");
				Thread.sleep(12000);
				
				//		 String winHandleBefore = driver.getWindowHandle();
			    // Perform the click operation that opens new window
		//	    driver.findElement(GetPageObject.OR_GetElement("AvailableJobs_Link")).click();
		//	    driver.close();
			    // Switch to new window opened
			    for(String winHandle : browser.getWindowHandles()){
			    	browser.switchTo().window(winHandle);
			    }
			    // Perform the actions on new window

			    Thread.sleep(9000);
//			    click("id=email");
			    click("xpath=//div[@id='passwordSection']//input[@id='email']");
			    sendKeys("xpath=//div[@id='passwordSection']//input[@id='email']",paypalid);
			    Thread.sleep(2000);
				sendKeys("xpath=//div[@id='passwordSection']//input[@id='password']",paypalpwd);
				Thread.sleep(2000);
				click("id=btnLogin"); //submit
				Thread.sleep(5000);
				click("id=confirmButtonTop"); //agree n continue
				Thread.sleep(8000);
			    
			    // Close the new window, if that window no more required
	//		    driver.close();
			    // Switch back to original browser (first window)
	//		    driver.switchTo().window(winHandleBefore);  
			    
				
				
				
/*				 String  handle= browser.getWindowHandle();
				 System.out.println(handle);
				
				 String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       Thread.sleep(5000);
				       
				       browser.close(); 
				       browser.switchTo().window(parentWindow); 
				     }
				  }  */ 
				//browser.switchTo().window("6442450945");
			/*	Thread.sleep(8000);
				//clickAndWaitForElement("id=email", "5000");
				sendKeys("id=email",paypalid);
				Thread.sleep(2000);
				sendKeys("id=password",paypalpwd);
				Thread.sleep(2000);
				click("id=btnLogin"); //submit
				Thread.sleep(5000);
				click("id=confirmButtonTop"); //agree n continue
				Thread.sleep(8000);
				String  handle1= browser.getWindowHandle();
				 System.out.println(handle1);
				click("id=placeOrder");
				Thread.sleep(5000);
				String chkoutpage11=findTheElement("css=div.logo-bar").getText();
				System.out.println(chkoutpage11);
				//String actualtxt11="The Address you have entered is not valid. Please enter a valid address";
				if(chkoutpage11!=null)
		       {
					//System.out.println("Mini Cart Button displayed");
					rpt.createTest("CIRCUIT CITY - CHECKOUT", "Order is placed via Paypal" );
			         rpt.Pass("Order is placed via Paypal");
			         rpt.Category("CIRCUIT CITY - CHECKOUT");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				  }
				else
				{
					//System.out.println("Mini Cart Button NOT displayed");
					 rpt.createTest("CIRCUIT CITY - CHECKOUT", "Order is NOT placed via Paypal");
			         rpt.Fail("Order is NOT placed via Paypal");
			         rpt.Category("CIRCUIT CITY - CHECKOUT");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}*/
	    }
}

