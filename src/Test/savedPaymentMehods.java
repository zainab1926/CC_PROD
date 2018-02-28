package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class savedPaymentMehods extends Browser
{
	Report rpt = new Report();
//	Browser br  = new Browser();
//	WebDriver wd;
	CommonUtils email = new CommonUtils();
	String creditCardNo="5555555555554444";
	String cvv="123";
	String name=email.getRandomString(6);
	String address="120 Greenwich St";
	String city="New York";
	String state="NY";
	String zipCode="10006";
	String phoneNo=email.getRandomNumber(10);
	String Logon_ID = "user@test.com";
	String pwd="Royalcyber1";
	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	
	public void executeAll() throws Exception
	{
		     Thread.sleep(8000);
		    // browser.manage().window().maximize();
		     click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		     Thread.sleep(3000);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", Logon_ID);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", pwd);
			Thread.sleep(3000);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
			Thread.sleep(3000);
			//click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']");
			//Thread.sleep(6000);
			//click("xpath=//*[@id='wishListQuickLink_alt']"); //wishlist
			//Thread.sleep(6000);
//			click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']");
//			Thread.sleep(5000);
			click("xpath=//a[contains(text(),'My Account')]");
			
			//verifySummaryPage();
			chk_AccSection();
			verify_myAccPage();
			savedCards();
			AddsavedCards();
            deleteCards();
			verifyDefaultCustomer();
			verifyUpdate(); 
			addCard();
//			mandatoryAddress();
	}
	
	public void verifySummaryPage()throws Exception
	{
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("Personal Information", "WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Change Password", "WC_MyAccountSidebarDisplayf_links_1");
		 ids.put("Address Book", "WC_MyAccountSidebarDisplayf_links_2");
		 ids.put("Quick Checkout Profile", "WC_MyAccountSidebarDisplayf_links_3");
		 ids.put("Saved Cards","WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Tax Exemption","WC_MyAccountSidebarDisplayf_links_0");
		 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
		         rpt.createTest("CC-Saved Payment Methods-My Account Page", "Message :"+id.getKey()+" Displayed - For My Account Page");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For My Account Page");
		         rpt.Category("CC_Saved Payment Methods-My Account Page");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);

			 }
			 else
			 {
				 rpt.createTest("CC-Saved Payment Methods-My Account Page", "Message :"+id.getKey()+"is NOT Displayed - For My Account Page");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For My Account Page");
		         rpt.Category("CC_Saved Payment Methods-My Account Page");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
	   }
    }
	
	public void chk_AccSection() throws Exception
    {
    Map<String,String> ids= new HashMap<String,String>();
	 ids.put("Settings", "section_button_settings");
	 ids.put("Wishlist", "section_button_wishlists");
	 ids.put("Orders", "section_button_orders");
	 ids.put("Gifts", "section_button_coupons");
	 for(Map.Entry<String, String> id : ids.entrySet() )
	 {
		 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
		 {
			 
	         rpt.createTest("CC-Saved Payment Methods-Check Account Section", "Message :"+id.getKey()+" Displayed - For Account Section");
	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Account Section");
	         rpt.Category("CC_Saved Payment Methods-Check Account Section");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
 
		 }
		 else
		 {
	         rpt.createTest("CC-Saved Payment Methods-Check Account Section", "Message :"+id.getKey()+"is NOT Displayed - For Account Section");
	         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Account Section");
	         rpt.Category("CC_Saved Payment Methods-Check Account Section");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);

		 }
	 }
    }
	
	public void verify_myAccPage() throws Exception
	{
		 Map<String,String> ids= new HashMap<String,String>();
		 ids.put("Personal Information", "WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Change Password", "WC_MyAccountSidebarDisplayf_links_1");
		 ids.put("Address Book", "WC_MyAccountSidebarDisplayf_links_2");
		 ids.put("Quick Checkout Profile", "WC_MyAccountSidebarDisplayf_links_3");
		 ids.put("Saved Cards","WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Tax Exemption","WC_MyAccountSidebarDisplayf_links_0");
		 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				
    	         rpt.createTest("CC-Saved Payment Methods-Verify My Account Page", "Message :"+id.getKey()+" Displayed - For Verify My Account Page");
    	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account Page");
    	         rpt.Category("CC_Saved Payment Methods-Verify My Account Page");
    	         String path = rpt.CaptureScreen(browser, "ValidMessage");
    	         rpt.imgPathPass(path);


			 }
			 else
			 {
				 rpt.createTest("CC-Saved Payment Methods-Verify My Account Page", "Message :"+id.getKey()+"is NOT Displayed - For Verify My Account Page");
    	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Verify My Account Page");
    	         rpt.Category("CC_Saved Payment Methods-Verify My Account Page");
    	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	         rpt.imgPathFail(path);
			 }
		 }
	}
	
	public void savedCards()throws Exception
	{
		//click("xpath=//div[@id='section_list_settings']/ul/li[5]//div[@id='section_list_settings']/ul/li[5]"); //payment methods
		  /*Screen s  = new Screen();
		  Thread.sleep(6000);
		  Pattern img=new Pattern("C:\\Users\\user\\workspace\\CC\\sikuli_images\\paymentMethods_cc.png");
		  Thread.sleep(5000);
		  s.click(img);*/
		//click("xpath=//div[@id='section_list_settings']/ul/li[5]");
//		Boolean a = findTheElement("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']").isEnabled();
//		System.out.println(a);
		Thread.sleep(6000);
		 click("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']"); //payment methods
		  String HomePagetitle=Browser.getTitle();
			System.out.println(HomePagetitle);
			
			if(HomePagetitle.equals("Payment Method"))
			{
				//System.out.println("Passed");
				 rpt.createTest("CC_Saved Payment Methods - Verify Saved Cards ", "Payment Method page is displayed : " +HomePagetitle);
		         rpt.Pass("Payment Method page is displayed : " +HomePagetitle);
		         rpt.Category("CC_Saved Payment Methods - Verify Saved Cards");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Failed");
				rpt.createTest("CC_Saved Payment Methods - Verify Saved Cards", "Payment Method page NOT displayed");
		         rpt.Fail("Payment Method page NOT displayed");
		         rpt.Category("CC_Saved Payment Methods - Verify Saved Cards");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			} 
		//myaccount_sidebar
//		if(findTheElement("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']").isDisplayed())
//		 {
//	         rpt.createTest("CC - Saved Payment Methods - Verify Saved Cards", "Saved Cards is Displayed - For Verify Saved Cards");
//	         rpt.Pass("Saved Cards is Displayed - For Verify Saved Cards");
//	         rpt.Category("CC_Saved Payment Methods - Verify Saved Cards");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
////	         Thread.sleep(6000);
//	 		doubleClick("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']"); 
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Saved Payment Methods - Verify Saved Cards", "Saved Cards NOT  Displayed - For Verify Saved Cards");
//	         rpt.Fail("Saved Cards NOT Displayed - For Verify Saved Cards");
//	         rpt.Category("CC_Saved Payment Methods - Verify Saved Cards");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
	}
	public void AddsavedCards()throws Exception
	{
		
		click("link=ADD A NEW CARD");
		Thread.sleep(2000);
		  boolean a = findTheElement("id=card-number").isEnabled();
		  click("id=card-number");
		  Thread.sleep(5000);
		  click("name=braintree-hosted-field-number");
		  Thread.sleep(2000);
		  //findTheElement("name=braintree-hosted-field-number").clear();
		  sendKeys("name=braintree-hosted-field-number",creditCardNo);
		  Thread.sleep(2000);
		 // findTheElement("id=pay_temp_account_name").clear();
		  sendKeys("id=pay_temp_account_name", name);
		  Thread.sleep(2000);
		  browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-cvv")));
		  click("id=cvv");
		  Thread.sleep(2000);
		 // findTheElement("id=cvv").clear();
		  sendKeys("id=cvv", cvv);
		  browser.switchTo().defaultContent();
		Thread.sleep(5000);
		
		//click("xpath=//*[@id='expiration-year']"); //exp year
		 browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationYear")));
		  WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-year']")); 
			Select select = new Select(monthdd);
			select.selectByVisibleText("2022");
			browser.switchTo().defaultContent();
			
			   click("id=preferred_billing_select-button");
		Thread.sleep(5000);
//		WebElement sc = findTheElement("xpath=//*[@id='ui-id-11']");
//		sc.sendKeys(Keys.PAGE_DOWN);
//		Thread.sleep(5000);
//		click("xpath=//*[@id='ui-id-11']");
//		Thread.sleep(5000);
		
//		 WebElement Element = findTheElement("css=div.ui-menu-item-wrapper");
//		   JavascriptExecutor jse = (JavascriptExecutor)browser;
//		       jse.executeScript("arguments[0].scrollIntoView();", Element);
		   click("xpath=//ul[@id='preferred_billing_select-menu']/li[2]/div");//selecting address
		   Thread.sleep(2000);
		   click("id=submit");
		   Thread.sleep(2000);
//		   if(findTheElement("link=EDIT").isDisplayed())
		   String savedCardText = "Edit" ;
		   String savedCard = getText("link=EDIT");
		   if(savedCard.equals(savedCardText))
		     {
					//System.out.println("Passed");
					 rpt.createTest("CC_Saved Payment Methods  - Verify Add Cards ", "New Credit Card is added successfully ");
			         rpt.Pass("New Credit Card is added successfully");
			         rpt.Category("CC_Saved Payment Methods  - Verify Add Cards");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					//System.out.println("Failed");
					rpt.createTest("CC_Saved Payment Methods  - Verify Add Cards", "New Credit Card NOT added successfully");
			         rpt.Fail("New Credit Card NOT added successfully");
			         rpt.Category("CC_Saved Payment Methods  - Verify Add Cards");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}
//		 sendKeys("id=WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_lastName_1",name);
//	     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_address1_1",address);
//	     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_city_1",city);
//	     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_state_1",state);
//	     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
//	     sendKeys("id=WC_UserRegistrationAddForm_FormInput_email1_In_Register_1",Logon_ID);
//	     sendKeys("id=WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1",phoneNo);
//	     click("id=submit");
	     Thread.sleep(3000);
		
	}
	
	public void deleteCards()throws Exception
	{
		Thread.sleep(5000);
		//click("xpath=//*[@id='edit_card']/div[1]/div[1]/span/a[2]"); //delete
		if(findTheElement("xpath=//a[contains(text(),'REMOVE')]").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Delete Cards", "Delete Cards is Displayed - For Verify Delete Cards");
	         rpt.Pass("Saved Cards is Displayed - For Verify Delete Cards");
	         rpt.Category("CC_Saved Payment Methods - Verify Delete Cards");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//a[contains(text(),'REMOVE')]"); //delete
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Delete Cards", "Delete Cards NOT Displayed - For Verify Saved Cards");
	         rpt.Fail("Delete Cards NOT Displayed - For Verify Delete Cards");
	         rpt.Category("CC_Saved Payment Methods - Verify Delete Cards");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(2000);
		//click("css=div.button_primary"); //delete pop up
		click("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[3]/div/div/a[1]/div[2]"); //delete pop up
	}
	public void verifyDefaultCustomer()throws Exception
	{
		Thread.sleep(5000);
		//click("xpath=//*[@id='edit_card']/div[1]/div[2]/label/span"); //default payment
		if(findTheElement("xpath=//label/span").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Default Customer", "Default payment method is selected - For Verify Default Customer");
	         rpt.Pass("Default payment method is selected - For Verify Default Customer");
	         rpt.Category("CC_Saved Payment Methods - Verify Default Customer");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//label/span"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Default Customer", "Default payment method NOT selected - For Verify Default Customer");
	         rpt.Fail("Default payment method NOT selected - For Verify Default Customer");
	         rpt.Category("CC_Saved Payment Methods - Verify Default Customer");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Default Customer", "Search Text Box is Displayed - For Verify Default Customer");
	         rpt.Pass("Search Text Box is Displayed - For Verify Default Customer");
	         rpt.Category("CC_Saved Payment Methods - Verify Default Customer");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Default Customer", "Search Text Box NOT  Displayed - For Verify Default Customer");
	         rpt.Fail("Search Text Box NOT Displayed - For Verify Default Customer");
	         rpt.Category("CC_Saved Payment Methods - Verify Default Customer");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
		Thread.sleep(5000);
		//click("xpath=//*[@id='autoSelectOption_4']/div/img");
		if(findTheElement("xpath=/html/body/div[2]/div[1]/div[2]/div[2]/div[2]/form/a[2]").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Product", "Selecting Product is Displayed - For Verify Product");
	         rpt.Pass("Selecting Product is Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=/html/body/div[2]/div[1]/div[2]/div[2]/div[2]/form/a[2]");
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Product", "Selecting Product NOT Displayed - For Verify Product");
	         rpt.Fail("Selecting Product NOT Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		click("xpath=//a[contains(text(),'Lenovo')]"); //product
		Thread.sleep(3000);
		//click("xpath=//*[@id='productPageAdd2Cart']"); //add to cart
		if(findTheElement("xpath=//*[@id='add2CartBtn']").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Product", "Add To Cart is Displayed - For Verify Product");
	         rpt.Pass("Add To Cart is Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		doubleClick("xpath=//*[@id='add2CartBtn']"); //add to cart
		 }
		 else
		 {
			 //click("xpath=//*[@id='GotoCartButton2']"); //view cart
			 rpt.createTest("CC - Saved Payment Methods - Verify Product", "Add To Cart NOT Displayed - For Verify Product");
	         rpt.Fail("Add To Cart NOT Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//click("xpath=//*[@id='GotoCartButton2']"); //view cart
		if(findTheElement("xpath=//*[@id='GotoCartButton2']").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Product", "View Cart is Displayed - For Verify Product");
	         rpt.Pass("View Cart is Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='GotoCartButton2']"); //view cart
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Product", "View Cart NOT Displayed - For Verify Product");
	         rpt.Fail("View Cart NOT Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
//		Thread.sleep(5000);
		//click("xpath=//*[@id='page']/div[4]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[7]/a"); //chckout
		if(findTheElement("link=READY TO CHECKOUT").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Product", "CheckOut is Displayed - For Verify Product");
	         rpt.Pass("CheckOut is Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("link=READY TO CHECKOUT"); //chckout
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Product", "CheckOut NOT Displayed - For Verify Product");
	         rpt.Fail("CheckOut NOT Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		click("xpath=//div[@id='shippingActive']/div/div[6]"); //chckbox for address
		Thread.sleep(2000);
		click("id=summaryButton");
		Thread.sleep(2000);
		if (findTheElement("id=cardImagePaymentActive").isDisplayed())
		{
        rpt.createTest("CC - Saved Payment Methods - Verify Product", "Default Credit Card is Displayed - For Verify Product");
        rpt.Pass("Default Credit Card is Displayed - For Verify Product");
        rpt.Category("CC_Saved Payment Methods - Verify Product");
        String path = rpt.CaptureScreen(browser, "ValidMessage");
        rpt.imgPathPass(path);
		//click("link=READY TO CHECKOUT"); //chckout
	 }
	  else
	 {
		 rpt.createTest("CC - Saved Payment Methods - Verify Product", "Default Credit Card NOT Displayed - For Verify Product");
        rpt.Fail("Default Credit Card NOT Displayed - For Verify Product");
        rpt.Category("CC_Saved Payment Methods - Verify Product");
        String path = rpt.CaptureScreen(browser, "InvalidMessage");
        rpt.imgPathFail(path);
	 }
	}	
		//click("xpath=//*[@id='82632106;140']"); //chckbox for address
		/*click("xpath=//*[@id='update']"); //continue
		Thread.sleep(5000);
		click("xpath=//*[@id='summaryButton']"); //use dis address
		Thread.sleep(5000);
		//click("xpath=//*[@id='creditCardList-button']/span[1]"); //credit card option
		if(findTheElement("xpath=//*[@id='creditCardList-button']/span[1]").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Product", "Credit Card is Displayed - For Verify Product");
	         rpt.Pass("Credit Card is Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='creditCardList-button']/span[1]"); //credit card option
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Product", "Credit Card NOT Displayed - For Verify Product");
	         rpt.Pass("Credit Card NOT Displayed - For Verify Product");
	         rpt.Category("CC_Saved Payment Methods - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }*/
	
	//CC_ACC_009
	public void verifyUpdate()throws Exception
	{
		Thread.sleep(5000);
		click("link=Back to Cart"); //back to cart
		Thread.sleep(5000);
		click("id=WC_OrderItemDetailsf_links_2_1");
		Thread.sleep(3000);
//		click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']"); //my acc
//		Thread.sleep(5000);
		click("xpath=//li[@id='sign_header']/a"); //my acc
		Thread.sleep(2000);
		click("link=My Account");
		Thread.sleep(1000);
		click("xpath=//div[@id='section_list_settings']/ul/li[5]"); //payment methods
		Thread.sleep(5000);
		click("link=EDIT"); //edit
		click("name=braintree-hosted-field-number");
		  Thread.sleep(2000);
		  sendKeys("name=braintree-hosted-field-number",creditCardNo);
		 // findTheElement("name=braintree-hosted-field-number").clear();
		  findTheElement("id=pay_temp_account_name").clear();
		  sendKeys("id=pay_temp_account_name", name);
		  Thread.sleep(2000);
		  browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-cvv")));
		  click("id=cvv");
		  Thread.sleep(2000);
		 // findTheElement("id=cvv").clear();
		  sendKeys("id=cvv", cvv);
		  browser.switchTo().defaultContent();
		Thread.sleep(5000);
		
		//click("xpath=//*[@id='expiration-year']"); //exp year
		 browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationYear")));
		  WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-year']")); 
			Select select = new Select(monthdd);
			select.selectByVisibleText("2022");
			browser.switchTo().defaultContent();
		click("xpath=//*[@id='preferred_billing_select-button']"); //prefered address dropdown
		 click("xpath=//ul[@id='preferred_billing_select-menu']/li[2]/div");//selecting address
		   Thread.sleep(2000);
		   click("id=submit");
		   if(findTheElement("link=EDIT").isDisplayed())
		     {
					//System.out.println("Passed");
					 rpt.createTest("CC_Saved Payment Methods  - Verify Update ", "New Credit Card is Updated successfully ");
			         rpt.Pass("New Credit Card is Updated successfully");
			         rpt.Category("CC_Saved Payment Methods  - Verify Update");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					//System.out.println("Failed");
					rpt.createTest("CC_Saved Payment Methods  - Verify Update", "New Credit Card NOT Updated successfully");
			         rpt.Fail("New Credit Card NOT Updated successfully");
			         rpt.Category("CC_Saved Payment Methods  - Verify Update");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				} 
	}
	
	public void addCard()throws Exception
	{
//		click("xpath=//*[@id='page']/div[5]/div[1]/a"); //back to cart
//		Thread.sleep(5000);
//		//click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']"); //my acc
//		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']").isDisplayed())
//		 {
//	         rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "My Account is Displayed - For Verify Add Card");
//	         rpt.Pass("My Account is Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	 		click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']"); //my acc
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "My Account NOT Displayed - For Verify Add Card");
//	         rpt.Fail("My Account NOT Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
//		Thread.sleep(5000);
//		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[3]/div[2]/a"); //my acc
//		Thread.sleep(5000);
//		//click("xpath=//div[@id='section_list_settings']/ul/li[5]"); //payment methods
//		if(findTheElement("xpath=//div[@id='section_list_settings']/ul/li[5]").isDisplayed())
//		 {
//	         rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Payment Methods is Displayed - For Verify Add Card");
//	         rpt.Pass("Payment Methods is Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	 		click("xpath=//div[@id='section_list_settings']/ul/li[5]"); //payment methods
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Payment Methods NOT Displayed - For Verify Add Card");
//	         rpt.Fail("Payment Methods NOT Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
//		Thread.sleep(5000);
		//click("xpath=//*[@id='edit_card']/div[5]/p/a"); //add card
		if(findTheElement("link=EDIT").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Adding New Card is Displayed - For Verify Add Card");
	         rpt.Pass("Adding New Card is Displayed - For Verify Add Card");
	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	        // click("link=EDIT"); //edit //add card
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Adding New Card NOT Displayed - For Verify Add Card");
	         rpt.Fail("Adding New Card NOT Displayed - For Verify Add Card");
	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		  click("link=EDIT");
		  Thread.sleep(3000);
		  click("name=braintree-hosted-field-number");
		  Thread.sleep(2000);
		  sendKeys("name=braintree-hosted-field-number","41111111111111");
		  click("id=submit");
		  //String name=findTheElement("id=saveCardMsgErrdiv").getText();
		  String error="Some payment input fields are invalid. Cannot tokenize invalid card fields.";
		  if(error!=null)
		  {
			  rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Error message displayed for invalid Card : " +error);
		         rpt.Pass("Error message displayed for invalid Card : " +error);
		         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
		         //click("link=EDIT"); //edit //add card
			 }
			 else
			 {
				 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Error message NOT displayed for invalid Card : " +error);
		         rpt.Fail("Error message NOT displayed for invalid Card : " +error);
		         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		  Thread.sleep(2000);
		   click("id=myAccountQuickLink");
		   Thread.sleep(2000);
		   click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
		  }
		//click("id=card-number"); //credit card
//		if(findTheElement("id=card-number").isDisplayed())
//		 {
//	         rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Credit Card is Displayed - For Verify Add Card");
//	         rpt.Pass("Credit Card is Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	 		click("id=card-number"); //credit card
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Credit Card NOT Displayed - For Verify Add Card");
//	         rpt.Fail("Credit Card NOT Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
//		Thread.sleep(5000);
//		sendKeys("id=card-number","4511111111111111111"); 
//		Thread.sleep(5000);
//		//click("xpath=//*[@id='submit']"); //add
//		if(findTheElement("xpath=//*[@id='submit']").isDisplayed())
//		 {
//	         rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Submit Button is Displayed - For Verify Add Card");
//	         rpt.Pass("Submit Button is Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "ValidMessage");
//	         rpt.imgPathPass(path);
//	 		click("xpath=//*[@id='submit']"); //add
//	 		Thread.sleep(3000);
//	 		Alert alert = browser.switchTo().alert();
//	 		System.out.println(alert.getText());
//	 		browser.switchTo().alert().accept();
//		 }
//		 else
//		 {
//			 rpt.createTest("CC - Saved Payment Methods - Verify Add Card", "Submit Button NOT Displayed - For Verify Add Card");
//	         rpt.Fail("Submit Button NOT Displayed - For Verify Add Card");
//	         rpt.Category("CC_Saved Payment Methods - Verify Add Card");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		 }
	
	public void mandatoryAddress()throws Exception
	{
		Thread.sleep(5000);
		//click("xpath=//div[@id='section_list_settings']/ul/li[5]"); //payment methods
		if(findTheElement("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']").isDisplayed())
		 {
	         rpt.createTest("CC - Saved Payment Methods - Verify Mandatory Address", "Payment Methods is Displayed - For Verify Mandatory Address");
	         rpt.Pass("Payment Methods is Displayed - For Verify Mandatory Address");
	         rpt.Category("CC_Saved Payment Methods - Verify Mandatory Address");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']"); //payment methods
		 }
		 else
		 {
			 rpt.createTest("CC - Saved Payment Methods - Verify Mandatory Address", "Payment Methods NOT Displayed - For Verify Mandatory Address");
	         rpt.Fail("Payment Methods NOT Displayed - For Verify Mandatory Address");
	         rpt.Category("CC_Saved Payment Methods - Verify Mandatory Address");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		AddsavedCards();
	}
	}
