package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class Regression extends Browser
{
	CommonUtils email = new CommonUtils();
	String Logon_ID = email.getRandomString(6)+"@test.com";
	String pwd=email.getRandomString(6)+email.getRandomNumber(1);
	String newpwd=email.getRandomString(6)+email.getRandomNumber(1);
	String name=email.getRandomString(6);
	String phoneNo=email.getRandomNumber(10);
	String nickname=email.getRandomString(6);
	String cardNo="4470330769941000";
	String wishlist=email.getRandomString(6);
	String newwishlist=email.getRandomString(6);
	String recipient = email.getRandomString(6)+"@test.com";
	String sender = email.getRandomString(6)+"@test.com";
	String sender_name=email.getRandomString(6);
	String product="lenovo";
	String address="120 Greenwich St";
	String city="New York";
	String state="NY";
	String zipCode="10006";
	String creditCardNo="5555555555554444";
	String cvv="123";
	
	
	Report rpt = new Report();
	@SuppressWarnings("static-access")
	@Parameters({"browser","url","Module"})
	@Test
	public void executeAll()throws Exception
	{
//		homePage();
//		registration();
//		logIn();
//		forgotPassword();
//		personalInformation();
//		addAddress();
		savedCards();
		addCards(); 
//		newWishlist();
//		changeWishlist();
//		deleteWishlist();
//		emailWishlist();
//		changePassword();
//		searchWithProduct();
//		productCompare();
//		plpPageDetails();
//	    plpPageAddProduct();
//	    plpPageCompare();
//		PDP_page();
//		addToCart();
//		addToWishlist();
//		productQuantity();
//		promoCode();
//		checkOut();
//		installation();
//		checkoutAsGuest(); //add in the end
	}

	public void homePage() throws Exception
	{	
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.contains("CircuitCity Electronics, Camera, Video, Photo, Appliances, Accessories"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Home Page Title", "Home Page is displayed : " +HomePagetitle);
	         rpt.Pass("Home Page is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Home Page Title");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Home Page Title", "Home Page NOT displayed");
	         rpt.Fail("Home Page NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Home Page Title");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//header
		
		 Map<String,String> fields= new HashMap<String,String>();
   	  fields.put("FREE SHIPPING over $35*", "/html/body/div[2]/div[2]/div[2]/div[1]/div/div[1]/label");
   	  //fields.put("24/7 Help | 1-877-234-8013 or Live Chat", "/html/body/div[2]/div[2]/div[2]/div[1]/div/div[2]");
   	  fields.put("Circuit City Logo", "//*[@id='logo']");
   	  fields.put("Search Box", "//*[@id='searchBar']");
   	  fields.put("Deal of the Day", "/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/a/div[2]/p[1]/span");
   	  fields.put("Save $250 on Apple 13.3 MacBook Pro", "/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/a/div[2]/p[2]");
   	  fields.put("Sign In", "//*[@id='Header_GlobalLogin_signInQuickLink']");
   	   fields.put("WishList", "//*[@id='wishListQuickLink_alt']");
   	   fields.put("Cart", "//*[@id='widget_minishopcart']");
   		
   		 for(Map.Entry<String, String> field : fields.entrySet() )
   		 {
   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
   			 {
   				 rpt.createTest("CIRCUIT CITY - Verify Header Content", "Header Content :"+field.getKey()+" Displayed ");
   		         rpt.Pass("Header Content :"+field.getKey()+" Displayed ");
   		         rpt.Category("CIRCUIT CITY - Verify Header Content");
   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
   		         rpt.imgPathPass(path);
   			 }
   			 else
   			 {
   				 rpt.createTest("CIRCUIT CITY - Verify Header Content", "Header Content :"+field.getKey()+" NOT Displayed");
   		         rpt.Fail("Header Content :"+field.getKey()+" NOT Displayed");
   		         rpt.Category("CIRCUIT CITY - Verify Header Content");
   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
   		         rpt.imgPathFail(path);
   			 }
   		 }
				 
		
		//category navigation
		Map<String,String> ids1= new HashMap<String,String>();
		 ids1.put("Products", "allDepartmentsButton");
		 ids1.put("Deals", "departmentButton_deals");
		 ids1.put("Services", "departmentButton_service");
		 ids1.put("Brands", "departmentButton_brands");
		 ids1.put("The City","departmentButton_thecity");
		 
		 
		 click("id=allDepartmentsButton"); //products
		 click("id=departmentButton_deals"); //deals
		 click("id=departmentButton_service"); //services
		 click("id=departmentButton_brands"); //brands
		 click("id=departmentButton_thecity"); //the city
		 
		 for(Map.Entry<String, String> id : ids1.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				
   	         rpt.createTest("CIRCUIT CITY - Verify Category Navigation", "Category :"+id.getKey()+" Displayed and is navigated to "+id.getKey()+" Page");
   	         rpt.Pass("Category :"+id.getKey()+" Displayed and is navigated to "+id.getKey()+" Page");
   	         rpt.Category("CIRCUIT CITY - Verify Category Navigation");
   	         String path = rpt.CaptureScreen(browser, "ValidMessage");
   	         rpt.imgPathPass(path);


			 }
			 else
			 {
			 rpt.createTest("CIRCUIT CITY - Verify Category Navigation", "Category :"+id.getKey()+"is NOT Displayed and NOT navigated to "+id.getKey()+" Page");
   	         rpt.Pass("Category :"+id.getKey()+"is NOT Displayed and NOT navigated to "+id.getKey()+" Page");
   	         rpt.Category("CIRCUIT CITY - Verify Category Navigation");
   	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	         rpt.imgPathFail(path);
			 }
		 }
		 
		 //search 
		 String searchbox=findTheElement("id=searchBar").getText();
		 System.out.println(searchbox);
			if(findTheElement("id=searchBar").isDisplayed())
			 {
		         rpt.createTest("CIRCUIT CITY - Verify Search Box", "Search Box is displayed : " +searchbox);
		         rpt.Pass("Search Box is displayed : " +searchbox);
		         rpt.Category("CIRCUIT CITY - Verify Search Box");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 rpt.createTest("CIRCUIT CITY - Verify Search Box", "Search Box NOT displayed");
		         rpt.Fail("Search Box NOT displayed");
		         rpt.Category("CIRCUIT CITY - Verify Search Box");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 
		 click("id=contentImage_1_HeaderStoreLogo_Content"); //logo
		 Thread.sleep(3000);
		 //footer
		
			/* Map<String,String> fields1= new HashMap<String,String>();
		   	  fields1.put(" 24/7 Support", "/html/body/div[4]/div[1]/div[1]/span[1]");
		   	 // fields1.put("Have a question? We're here to help.", "/html/body/div[4]/div[1]/div[1]/span[2]");
		   	  fields1.put("CHAT", "/html/body/div[4]/div[1]/div[1]/span[3]/a[1]");
		   	  fields1.put("CALL", "/html/body/div[4]/div[1]/div[1]/span[3]/a[2]");
		   	  fields1.put("EMAIL", "/html/body/div[4]/div[1]/div[1]/span[3]/a[3]");
		   	  fields1.put("Price Match Guarantee", "/html/body/div[4]/div[1]/div[3]/div[1]");
		   	  fields1.put("Free Shipping Over $35", "/html/body/div[4]/div[1]/div[3]/div[2]");
		   	   fields1.put("Schedule Service", "/html/body/div[4]/div[1]/div[3]/div[3]");
		   	   fields1.put("Subscribe", "//*[@id='footerSubscribe']");
		   	// fields1.put("My Account", "/html/body/div[5]/div[3]/div/div[1]/div/h3");
		   	//fields1.put("Sign in or Create Account", "/html/body/div[5]/div[3]/div/div[1]/ul/li[1]/a");
		   	//fields1.put("Wishlist", "/html/body/div[5]/div[3]/div/div[1]/ul/li[2]/a");
		   	//fields1.put("Rebates", "/html/body/div[5]/div[3]/div/div[1]/ul/li[3]/a");
		   	 //fields1.put("Customer Service", "/html/body/div[5]/div[3]/div/div[2]/div/h3");
		   	 fields1.put("Order Status", "/html/body/div[5]/div[3]/div/div[2]/ul/li[1]/a");
		   	 fields1.put("Order History", "/html/body/div[5]/div[3]/div/div[2]/ul/li[2]/a");
		   	 fields1.put("Shipping & Delivery", "/html/body/div[5]/div[3]/div/div[2]/ul/li[3]/a");
		   	 fields1.put("Return & Exchange Policy", "/html/body/div[5]/div[3]/div/div[2]/ul/li[4]/a");
		   	 fields1.put("Return an Item", "/html/body/div[5]/div[3]/div/div[2]/ul/li[5]/a");
		   	 fields1.put("Contact Us", "/html/body/div[5]/div[3]/div/div[2]/ul/li[6]/a");/*
		   	// fields1.put("Help", "/html/body/div[5]/div[3]/div/div[2]/ul/li[7]/a");
		   	 * 
		   	 
		   	  //fields1.put("Support & Service", "/html/body/div[5]/div[3]/div/div[3]/div/h3");
		   	// fields1.put("Customer Service", "/html/body/div[5]/div[3]/div/div[2]/div/h3");
		   	// fields1.put("Protection Plans", "/html/body/div[5]/div[3]/div/div[3]/ul/li[2]/a");
		   	 //fields1.put("Trade-In Program", "/html/body/div[5]/div[3]/div/div[3]/ul/li[3]/a");
		   	 //fields1.put("Product Recalls", "/html/body/div[5]/div[3]/div/div[3]/ul/li[4]/a");
		   	// fields1.put("Privacy & Security", "/html/body/div[5]/div[3]/div/div[3]/ul/li[5]/a");
		   	 //fields1.put("Feedback", "/html/body/div[5]/div[3]/div/div[3]/ul/li[6]/a");
		   	 //fields1.put("Installations", "/html/body/div[5]/div[3]/div/div[3]/ul/li[7]/a");
		   	  // fields1.put("Company Overview", "/html/body/div[5]/div[3]/div/div[4]/div/h3");
		   	 //fields1.put("About Us", "/html/body/div[5]/div[3]/div/div[4]/ul/li[1]/a");
		   	 //fields1.put("Our Story", "/html/body/div[5]/div[3]/div/div[4]/ul/li[2]/a");
		   	 //fields1.put("Careers", "/html/body/div[5]/div[3]/div/div[4]/ul/li[3]/a");
		   	 //fields1.put("Partner With Us", "/html/body/div[5]/div[3]/div/div[4]/ul/li[4]/a");
		   	 fields1.put("Connect With Us", "/html/body/div[4]/div[4]/h3");
		   	  fields1.put("Twitter", "/html/body/div[4]/div[4]/div[1]/a[1]");
		   	  fields1.put("Facebook", "/html/body/div[4]/div[4]/div[1]/a[2]");
		   	  fields1.put("Youtube", "/html/body/div[4]/div[4]/div[1]/a[3]");
		   	  fields1.put("Pinterest", "/html/body/div[4]/div[4]/div[1]/a[4]");
		   	  fields1.put("Instagram", "/html/body/div[4]/div[4]/div[1]/a[5]");
		   	  fields1.put("Google plus", "/html/body/div[4]/div[4]/div[1]/a[6]");
		   	  // fields1.put("Symantec", "/html/body/div[4]/div[5]/table");
		   	   fields1.put("TERMS", "/html/body/div[4]/div[5]/a[1]");
		   	 fields1.put("PRIVACY", "/html/body/div[4]/div[5]/a[2]");
		   	  
		   		
		   		 for(Map.Entry<String, String> field : fields1.entrySet() )
		   		 {
		   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content :"+field.getKey()+" Displayed ");
		   		         rpt.Pass("Footer Content :"+field.getKey()+" Displayed ");
		   		         rpt.Category("CIRCUIT CITY - Verify Footer Content");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			 }
		   			 else
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content :"+field.getKey()+" NOT Displayed");
		   		         rpt.Fail("Footer Content :"+field.getKey()+" NOT Displayed");
		   		         rpt.Category("CIRCUIT CITY - Verify Footer Content");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			 }
		   		 }*/
		   		String myAcc=findTheElement("id=footerWrapper").getText();
				 System.out.println(myAcc);
					if(findTheElement("id=footerWrapper").isDisplayed())
					 {
				         rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content is displayed");
				         rpt.Pass("Footer Content is displayed : " +myAcc);
				         rpt.Category("CIRCUIT CITY - Verify Footer Content");
				         String path = rpt.CaptureScreen(browser, "ValidMessage");
				         rpt.imgPathPass(path);
					 }
					 else
					 {
						 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content NOT displayed");
				         rpt.Fail("Footer Content NOT displayed");
				         rpt.Category("CIRCUIT CITY - Verify Footer Content");
				         String path = rpt.CaptureScreen(browser, "InvalidMessage");
				         rpt.imgPathFail(path);
					 }		 
		   		 
	}	
		   
	public void registration() throws Exception
		   		{
		Thread.sleep(3000);
		   			click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		   			Thread.sleep(3000);
		   			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']");//create acc
		   			
		   			click("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']");
		   			sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']", name);
		   			
		   			
		   			//LastName
		   			click("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']");
		   			sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']", name);
		   			
		   			//email id
		   			click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
		   			sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", Logon_ID);
		   			
		   			//password
		   			click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']");
		   			sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']", pwd);
		   			
		   			//confirm password
		   			click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']");
		   			sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']", pwd);
		   			
		   			//mobile number
		   			click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");
		   			sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']", phoneNo);
		   			
		   			//create account button
		   			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");
		   			
		   			String HomePagetitle=Browser.getTitle();
					System.out.println(HomePagetitle);
					
					if(HomePagetitle.equals("My Account"))
					{
				         rpt.createTest("CIRCUIT CITY - Verify Registration", "Registration is successful : " +HomePagetitle);
				         rpt.Pass("Registration is successful : " +HomePagetitle);
				         rpt.Category("CIRCUIT CITY - Verify Registration");
				         String path = rpt.CaptureScreen(browser, "ValidMessage");
				         rpt.imgPathPass(path);
					 }
					 else
					 {
						 rpt.createTest("CIRCUIT CITY - Verify Registration", "Registration NOT successful");
				         rpt.Fail("Registration NOT successful");
				         rpt.Category("CIRCUIT CITY - Verify Registration");
				         String path = rpt.CaptureScreen(browser, "InvalidMessage");
				         rpt.imgPathFail(path);
					 }
		   		//logout
					Thread.sleep(3000);
		   			//click("id=Header_GlobalLogin_loggedInDropdown_SignOut");
		   			click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[2]/a/span")	;
		   		}
	public void logIn() throws Exception
	{
		    click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
			Thread.sleep(3000);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", Logon_ID);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", pwd);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
			Thread.sleep(3000);
			click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
			
			String HomePagetitle=Browser.getTitle();
			System.out.println(HomePagetitle);
			
			if(HomePagetitle.equals("My Account"))
			{
				//System.out.println("Passed");
				 rpt.createTest("CIRCUIT CITY - Verify logIn", "LogIn is successfull and navigated to home page : " +HomePagetitle);
		         rpt.Pass("LogIn is successfull and navigated to home page : " +HomePagetitle);
		         rpt.Category("CIRCUIT CITY - Verify logIn");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Failed");
				rpt.createTest("CIRCUIT CITY - Verify logIn", "LogIn NOT successfull and NOT navigated to home page");
		         rpt.Fail("LogIn NOT successfull and NOT navigated to home page");
		         rpt.Category("CIRCUIT CITY - Verify logIn");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
	}
	
	public void forgotPassword() throws Exception
	{
		click("id=Header_GlobalLogin_signOutQuickLink"); //my acc icon
		Thread.sleep(2000);
		click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[2]/a/span")	;
		Thread.sleep(2000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		click("id=Header_GlobalLogin_WC_AccountDisplay_links_1"); //forgot pwd
		//sendKeys("id=WC_PasswordResetForm_FormInput_logonId_In_ResetPasswordForm_1",Logon_ID);
		if(findTheElement("id=WC_PasswordResetForm_FormInput_logonId_In_ResetPasswordForm_1").isDisplayed())
		 {
	         rpt.createTest("CIRCUIT CITY - Verify Forgot Password", "Forgot Password text box is displayed and giving registered email id ");
	         rpt.Pass("Forgot Password text box is displayed and giving registered email id");
	         rpt.Category("CIRCUIT CITY - Verify Forgot Password");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         sendKeys("id=WC_PasswordResetForm_FormInput_logonId_In_ResetPasswordForm_1",Logon_ID);
		 }
		 else
		 {
			 rpt.createTest("CIRCUIT CITY - Verify Forgot Password", "Forgot Password text box NOT displayed and NOT giving registered email id");
	         rpt.Fail("Forgot Password text box NOT displayed and NOT giving registered email id");
	         rpt.Category("CIRCUIT CITY - Verify Forgot Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		click("id=WC_PasswordResetForm_Link_2"); //submit
	}
	
	public void personalInformation() throws Exception
	{
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", Logon_ID);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", pwd);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
		Thread.sleep(3000);
		click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
		
		click("id=WC_MyAccountSidebarDisplayf_links_0"); //personal info
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.equals("Personal Information"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Personal Information", "Personal Information page is displayed : " +HomePagetitle);
	         rpt.Pass("Personal Information page is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Personal Information");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Personal Information", "Personal Information page NOT displayed");
	         rpt.Fail("Personal Information page NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Personal Information");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
		sendKeys("id=WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1",address);
		sendKeys("id=WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1",city);
		sendKeys("id=WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1",state); 
		sendKeys("id=WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		
		click("id=WC_UserRegistrationUpdateForm_links_1"); //submit
	}
	
	public void addAddress() throws Exception
	{
		click("id=WC_MyAccountSidebarDisplayf_links_2"); //address book
		Thread.sleep(3000);
		//click("id=WC_AjaxAddressBookForm_links_1"); //add address
		//Thread.sleep(3000);
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.equals("Your Addresses"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Add Address ", "Add Shipping Address page is displayed : " +HomePagetitle);
	         rpt.Pass("Add Shipping Address page is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Add Address");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Add Address", "Add Shipping Address page NOT displayed");
	         rpt.Fail("Add Shipping Address page NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Add Address");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("id=WC_AjaxAddressBookForm_links_1"); //add address
		Thread.sleep(3000);
		sendKeys("id=WC_AccountForm_NameEntryForm_FormInput_lastName_1",name);
		sendKeys("id=WC_AccountForm_AddressEntryForm_FormInput_address1_1",address);
		click("id=WC_AccountForm_AddressEntryForm_FormInput_address2_1");
		sendKeys("id=WC_AccountForm_AddressEntryForm_FormInput_city_1",city);
		sendKeys("id=WC_AccountForm_AddressEntryForm_FormInput_state_1",state); 
		sendKeys("id=WC_AccountForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		sendKeys("id=nickName",nickname);
		sendKeys("id=WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1",phoneNo);
		click("id=WC_AjaxAddressBookForm_links_4a");
		Thread.sleep(5000);
	/*	doubleClick("id=Header_GlobalLogin_signOutQuickLink");
		Thread.sleep(3000);
		click("id=Header_GlobalLogin_loggedInDropdown_SignOut");//sign out
*/		
	}
	
	public void savedCards() throws Exception
	{
		//logIn();
		//added 
		  click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "user@test.com");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "Royalcyber1");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");//sign in
			Thread.sleep(3000);
			click("xpath=.//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
			Thread.sleep(3000);
	  click("xpath=//div[@id='section_list_settings']/ul/li[5]/a[@id='WC_MyAccountSidebarDisplayf_links_0']"); //payment methods
	  String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.equals("Payment Method"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Saved Cards ", "Payment Method page is displayed : " +HomePagetitle);
	         rpt.Pass("Payment Method page is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Saved Cards");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Saved Cards", "Payment Method page NOT displayed");
	         rpt.Fail("Payment Method page NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Saved Cards");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	
	}
	public void addCards() throws Exception
	{
		//logIn();
		/*click("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/p/a");
		doubleClick("id=braintree-hosted-field-number");
		//Thread.sleep(5000);
		sendKeys("id=card-number", cardNo);
		click("id=card-number"); //card name
		//Thread.sleep(5000);
		sendKeys("id=pay_temp_account_name",name);
		//Thread.sleep(5000);
		click("id=cvv"); //cvv
		//Thread.sleep(8000);
		sendKeys("id=cvv","123");
		click("id=expiration-month"); //exp month
		Thread.sleep(5000);
		  Robot r = new Robot();
		  r.keyPress(KeyboardEvent.DOM_VK_UP);
		  Thread.sleep(1000);
		  r.keyPress(KeyboardEvent.DOM_VK_UP);
		   r.keyPress(KeyEvent.VK_ENTER);
		   click("id=expiration-year"); //exp year 
		   r.keyPress(KeyboardEvent.DOM_VK_UP);
			  Thread.sleep(1000);
			  r.keyPress(KeyboardEvent.DOM_VK_UP);
			  r.keyPress(KeyEvent.VK_ENTER);
			  
		click("xpath=//*[@id='preferred_billing_select-button']/span[1]"); //add
		click("id=ui-id-8");
		click("id=submit");*/
		
		click("xpath=//*[@id='edit_card']/div/p/a");
		  boolean a = findTheElement("id=card-number").isEnabled();
		  click("id=card-number");
		  Thread.sleep(5000);
		  click("name=braintree-hosted-field-number");
		  Thread.sleep(2000);
		  sendKeys("name=braintree-hosted-field-number",creditCardNo);
		  
		  sendKeys("id=pay_temp_account_name", name);
		  Thread.sleep(2000);
		  click("id=cvv");
		  sendKeys("id=cvv", cvv);
		  Thread.sleep(2000);
		//  click("id=expiration-year");
		  
		 /* //using select for dropdown
		  select("id=expiration-year", "2020");*/
		  browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationMonth")));
		  WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-month']")); 
			Select select = new Select(monthdd);
			select.selectByVisibleText("03 - March");
			/*productName []= { "mouse","keyboard","montor"};
			browser.findElement(By.xpath("//div[@class='product_name]/.//a[contains(text(),'"+productName[i]+"')])");*/
			//browser.switchTo().defaultContent();
			Thread.sleep(40000);
		    Robot r = new Robot();
//		    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		     r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		     Thread.sleep(2000);
//		     r.keyPress(KeyEvent.VK_ENTER);
		     Thread.sleep(2000);
		     click("id=preferred_billing_select-button");
		     Thread.sleep(2000);
		     r.keyPress(KeyEvent.VK_PAGE_DOWN);
		     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		     Thread.sleep(2000);
		     r.keyPress(KeyEvent.VK_ENTER);
		     Thread.sleep(2000);
		     sendKeys("id=WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_lastName_1",name);
		     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_address1_1",address);
		     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_city_1",city);
		     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_state_1",state);
		     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		     sendKeys("id=WC_UserRegistrationAddForm_FormInput_email1_In_Register_1",Logon_ID);
		     sendKeys("id=WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1",phoneNo);
		     click("id=submit");
		     Thread.sleep(3000);
		     if(findTheElement("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]").isDisplayed())
		     {
					//System.out.println("Passed");
					 rpt.createTest("CIRCUIT CITY - Verify Add Cards ", "New Credit Card is added successfully ");
			         rpt.Pass("New Credit Card is added successfully");
			         rpt.Category("CIRCUIT CITY - Verify Add Cards");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					//System.out.println("Failed");
					rpt.createTest("CIRCUIT CITY - Verify Add Cards", "New Credit Card NOT added successfully");
			         rpt.Fail("New Credit Card NOT added successfully");
			         rpt.Category("CIRCUIT CITY - Verify Add Cards");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}
		     Thread.sleep(3000);
		   //  click("xpath=//*[@id='edit_card']/div[2]/div[1]/span/a[2]"); //delete
		     if(findTheElement("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]/span/a[2]").isDisplayed())
		     {
		    	 click("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]/span/a[2]"); //delete
					 rpt.createTest("CIRCUIT CITY - Verify Delete Cards ", "Credit Card is deleted successfully ");
			         rpt.Pass("Credit Card is deleted successfully ");
			         rpt.Category("CIRCUIT CITY - Verify Delete Cards");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					//System.out.println("Failed");
					rpt.createTest("CIRCUIT CITY - Verify Delete Cards", "Credit Card NOT deleted successfully ");
			         rpt.Fail("Credit Card NOT deleted successfully");
			         rpt.Category("CIRCUIT CITY - Verify Delete Cards");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}
		     Thread.sleep(2000);
		   click("xpath=/html/body/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[3]/div/div/a[1]/div[2]");  
		   Thread.sleep(5000);
		   //for adding card again
		   click("xpath=//*[@id='edit_card']/div/p/a");
			  boolean b = findTheElement("id=card-number").isEnabled();
			  click("name=braintree-hosted-field-number");
			  Thread.sleep(3000);
			  sendKeys("name=braintree-hosted-field-number",creditCardNo);
			  
			  sendKeys("id=pay_temp_account_name", name);
			  Thread.sleep(2000);
			  click("id=cvv");
			  sendKeys("id=cvv", cvv);
			  Thread.sleep(2000);
			  click("id=expiration-year");
			  //Robot r = new Robot();
			  r.keyPress(KeyEvent.VK_PAGE_DOWN);
			     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			     r.keyPress(KeyEvent.VK_PAGE_DOWN);
			     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			     Thread.sleep(2000);
			     r.keyPress(KeyEvent.VK_ENTER);
			     Thread.sleep(2000);
			     click("id=preferred_billing_select-button");
			     Thread.sleep(2000);
			     r.keyPress(KeyEvent.VK_PAGE_DOWN);
			     r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			     Thread.sleep(2000);
			     r.keyPress(KeyEvent.VK_ENTER);
			     Thread.sleep(2000);
			     sendKeys("id=WC_QuickCheckoutAddressForm_NameEntryForm_FormInput_lastName_1",name);
			     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_address1_1",address);
			     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_city_1",city);
			     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_state_1",state);
			     sendKeys("id=WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
			     sendKeys("id=WC_UserRegistrationAddForm_FormInput_email1_In_Register_1",Logon_ID);
			     sendKeys("id=WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1",phoneNo);
			     click("id=submit");
	}
	
	public void newWishlist() throws Exception
	{
		Thread.sleep(3000);
		click("id=WC_MyAccountSidebarDisplayf_links_4");
		Thread.sleep(5000);
		click("id=multipleWishlistController_link_create");
		Thread.sleep(3000);
		sendKeys("id=newListName",wishlist);
		
		click("id=CreateShoppingListPopup_div_create_save");
		Thread.sleep(2000);
		String wl="Wish list successfully created.";
		if(wl.contains("Wish list successfully created."))
		{
			 rpt.createTest("CIRCUIT CITY - Verify New Wishlist ", "New Wishlist is created ");
	         rpt.Pass("New Wishlist is created");
	         rpt.Category("CIRCUIT CITY - Verify New Wishlist");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	        //click("id=shoppingListCreateSuccessPopup_continue_shopping");
		}
		else
		{
			rpt.createTest("CIRCUIT CITY - Verify New Wishlist", "New Wishlist NOT created");
	         rpt.Fail("New Wishlist NOT created");
	         rpt.Category("CIRCUIT CITY - Verify New Wishlist");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}	
//		click("id=shoppingListCreateSuccessPopup_continue_shopping");
	}
	public void changeWishlist() throws Exception
	{
		click("id=multipleWishlistController_link_edit");
		Thread.sleep(2000);
		clear("id=editListName");
		
		sendKeys("id=editListName",newwishlist);
		
		click("id=editShoppingListPopup_div_edit_save"); //save
		Thread.sleep(2000);
		String alert="Wish list name successfully changed.";
		if(alert.contains("Wish list name successfully changed."))
		{
			 rpt.createTest("CIRCUIT CITY - Verify Change Wishlist ", "Wishlist Name is updated " +alert);
	         rpt.Pass("Wishlist Name is updated " +alert);
	         rpt.Category("CIRCUIT CITY - Verify Change Wishlist");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CIRCUIT CITY - Verify Change Wishlist", "Wishlist Name NOT updated");
	         rpt.Fail("Wishlist Name NOT updated");
	         rpt.Category("CIRCUIT CITY - Verify Change Wishlist");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}	
	}
	public void deleteWishlist() throws Exception
	{
		click("id=shoppingListCreateSuccessPopup_continue_shopping"); //continue shopping
		Thread.sleep(3000);
		click("id=delete_popup_link");
		Thread.sleep(3000);
		click("id=deleteShoppingListPopup_div_delete_yes");
		Thread.sleep(2000);
		String alert="Wish list successfully delete.";
		if(alert.contains("Wish list successfully delete."))
		{
			 rpt.createTest("CIRCUIT CITY - Verify Delete Wishlist ", "Wishlist Name is deleted : " +alert);
	         rpt.Pass("Wishlist Name is deleted : " +alert);
	         rpt.Category("CIRCUIT CITY - Verify Delete Wishlist");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CIRCUIT CITY - Verify Delete Wishlist", "Wishlist Name NOT deleted");
	         rpt.Fail("Wishlist Name NOT deleted");
	         rpt.Category("CIRCUIT CITY - Verify Delete Wishlist");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("id=shoppingListCreateSuccessPopup_continue_shopping");
	}
	public void emailWishlist() throws Exception
	{
		click("id=multipleWishlistController_link_create");
		Thread.sleep(3000);
		sendKeys("id=newListName",wishlist);
		Thread.sleep(3000);
		click("id=CreateShoppingListPopup_div_create_save");
		Thread.sleep(2000);
		click("id=share_popup_link");
		Thread.sleep(3000);
		sendKeys("id=SendWishListForm_Recipient_Email",recipient);
		Thread.sleep(3000);
		sendKeys("id=SendWishListForm_Recipient_Name",name);
		Thread.sleep(3000);
		sendKeys("id=SendWishListForm_Sender_Email",sender);
		Thread.sleep(3000);
		sendKeys("id=SendWishListForm_Sender_Name",sender_name);
		Thread.sleep(3000);
		click("id=WC_WishListDisplay_links_1"); //save
		String alert="Your e-mail has been sent.";
		if(alert.contains("Your e-mail has been sent."))
		{
			 rpt.createTest("CIRCUIT CITY - Verify Email Wishlist ", "Wishlist Name is Emailed " +alert);
	         rpt.Pass("Wishlist Name is Emailed " +alert);
	         rpt.Category("CIRCUIT CITY - Verify Email Wishlist");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CIRCUIT CITY - Verify Email Wishlist", "Wishlist Name NOT Emailed");
	         rpt.Fail("Wishlist Name NOT Emailed");
	         rpt.Category("CIRCUIT CITY - Verify Email Wishlist");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping");
	}
	public void changePassword() throws Exception
	{
		Thread.sleep(3000);
		click("id=WC_MyAccountSidebarDisplayf_links_1");
		Thread.sleep(3000);
		sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1",pwd);
		Thread.sleep(3000);
		sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1",newpwd);
		Thread.sleep(3000);
		sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1",newpwd);
		click("id=WC_UserPasswordUpdateForm_Link_1"); //update
		String alert="Your password has been changed successfully.";
		if(alert.contains("Your password has been changed successfully."))
		{
			 rpt.createTest("CIRCUIT CITY - Verify Change Password ", "Change Password is successful " +alert);
	         rpt.Pass("Change Password is successful " +alert);
	         rpt.Category("CIRCUIT CITY - Verify Change Password");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CIRCUIT CITY - Verify Change Password", "Change Password is successful");
	         rpt.Fail("Change Password is successful");
	         rpt.Category("CIRCUIT CITY - Verify Change Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
	}
	public void searchWithProduct() throws Exception
	{
		Thread.sleep(3000);
		sendKeys("id=SimpleSearchForm_SearchTerm",product);
		Thread.sleep(3000);
		click("id=autoSelectOption_4");
		Thread.sleep(3000);
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.contains("Lenovo 10M9000RUS TS M710T i5 8GB 1TB"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Search With Product ", "Search With Product is displayed : " +HomePagetitle);
	         rpt.Pass("Search With Product is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Add Address");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Search With Product", "Search With Product NOT displayed");
	         rpt.Fail("Search With Product NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Search With Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
//		doubleClick("id=Header_GlobalLogin_signOutQuickLink");
//		Thread.sleep(3000);
//		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");//sign out
		
	}	
	
	public void productCompare() throws Exception
	{
//		Thread.sleep(3000);
//		 logIn();
		 Thread.sleep(3000);
		 click("id=allDepartmentsButton"); // Select Products
		 click("id=departmentLink_3074457345616682169_alt"); //Select Category
		 Thread.sleep(3000);
		 //click("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616689614_link_9b");
		 //click("xpath=//div[@class='product_listing_container']/ul/li[1])");
		// click("xpath=(//div[@class='product']./div[@class='product_header']./div[@class='product_image'])[1]");
		 click("xpath=//li[1]/.//div[@class='product_image'] ");
	 //lines added for scroll down 	 
//		 JavascriptExecutor jse = (JavascriptExecutor)driver;
//		  jse.executeScript("window.scrollBy(0,250)", "");
		 
		 WebElement Element = findTheElement("id=ci_product_3074457345618265623_ADD01SSC9787AO");
		 JavascriptExecutor jse = (JavascriptExecutor)browser;
	      jse.executeScript("arguments[0].scrollIntoView();", Element);
		  
	      
	      
	      
		 //click("id=compare_3074457345616689334");
		 Thread.sleep(3000);
		 click("id=compare_3074457345616684384");
		 Thread.sleep(3000);
		 click("id=compare_3074457345616689334");
		 //click("id=compare_3074457345616689334");
		 Thread.sleep(3000);
		 click("id=compareButton_3074457345616689334");
		 Thread.sleep(2000);
		 
//		 WebElement Element1 = findTheElement("id=add2CartBtn_1");
//		 JavascriptExecutor jse1 = (JavascriptExecutor)browser;
//	      jse1.executeScript("arguments[0].scrollIntoView();", Element1);
	      
		 Robot r = new Robot();
		    r.keyPress(KeyEvent.VK_PAGE_DOWN);
		    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		 boolean a = findTheElement("id=add2CartBtn_1").isEnabled();
		 Thread.sleep(6000);
		 click("id=add2CartBtn_1");
		 String message = "Your item was added";
		 String cartMessage=getText("xpath=//*[@id='cartDropdownMessage']");
		 if(message.contains(cartMessage))
		 {
		  rpt.createTest("CIRCUIT CITY - Verify add to cart working properly from product compare page", "Product added to cart from product compare page");
		        rpt.Pass("Product added to cart from product compare page");
		        rpt.Category("CIRCUIT CITY - Product added to cart from product compare page");
		        String path = rpt.CaptureScreen(browser, "ValidMessage");
		        rpt.imgPathPass(path);
		 }
		 else
		 {
		  rpt.createTest("CIRCUIT CITY - Verify add to card working properly from compare product page", "Product not added to cart from product compare page");
		        rpt.Fail("Product not added to cart from product compare page");
		        rpt.Category("CIRCUIT CITY - Product not added to cart from product compare page");
		        String path = rpt.CaptureScreen(browser, "InvalidMessage");
		        rpt.imgPathFail(path);
		 }
		 Thread.sleep(2000);
		 click("id=WC_BreadCrumbTrailDisplay_links_2a");
		 }
		 
		public void plpPageDetails() throws Exception{
		 
		 click("id=allDepartmentsButton"); // Select Products
		 click("id=departmentLink_3074457345616682171_alt"); //Select Category
		 Thread.sleep(3000);
		  Map<String,String> fields= new HashMap<String,String>();
		     fields.put("Filter By", "//*[@id='facet_nav_collapsible_5_-3004_3074457345618265611']/h3");
		     fields.put("Color", "//*[@id='section_button_ads_f10019_ntk_cs_5_-3004_3074457345618265611']");
		     fields.put("Price", "//*[@id='section_button_1_5_-3004_3074457345618265611']");
		     fields.put("Brand", "//*[@id='section_button_mfName_ntk_cs_5_-3004_3074457345618265611']");
		     fields.put("Sort By", "//*[@id='container_3074457345618272604']/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]");
		     fields.put("List view Button", "//*[@id='WC_SearchBasedNavigationResults_pagination_link_list_categoryResults']");
		     fields.put("Grid view Button", "//*[@id='container_3074457345618272604']/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div");
		     fields.put("List of products with images and details", "//*[@id='container_3074457345618272604']/div[3]/div[2]/div[1]/div[2]/ul");
		     fields.put("Items per page", "//*[@id='container_3074457345618272604']/div[3]/div[2]/div[1]/div[3]");
		    
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

		public void plpPageAddProduct() throws Exception{
		 click("id=listViewAdd2Cart_3074457345616689606");
		 String message = "Your item was added";
		 String cartMessage=getText("xpath=//*[@id='cartDropdownMessage']");
		 if(message.contains(cartMessage))
		 {
		  rpt.createTest("CIRCUIT CITY - Verify add to cart working properly from product listing page", "Product added to cart from product listing page");
		        rpt.Pass("Product added to cart from product listing page");
		        rpt.Category("CIRCUIT CITY - Verify product listing page");
		        String path = rpt.CaptureScreen(browser, "ValidMessage");
		        rpt.imgPathPass(path);
		        
		 }
		 else
		 {
		  rpt.createTest("CIRCUIT CITY - Verify add to card working properly from product listing page", "Product not added to cart from product listing page");
		        rpt.Fail("Product not added to cart from product listing page");
		        rpt.Category("CIRCUIT CITY - Verify product listing page");
		        String path = rpt.CaptureScreen(browser, "InvalidMessage");
		        rpt.imgPathFail(path);
		 }
		 Thread.sleep(3000);
		 click("id=MiniShopCartCloseButton_2");
		}

		public void plpPageCompare() throws Exception{
		 Thread.sleep(2000);
		 click("id=compare_3074457345616689332");
		 
		 WebElement Element = findTheElement("id=compare_3074457345616689334");
		 JavascriptExecutor jse = (JavascriptExecutor)browser;
	      jse.executeScript("arguments[0].scrollIntoView();", Element);
	      
		    Thread.sleep(2000);
		 click("id=compare_3074457345616689334");
		 Thread.sleep(2000);
		 click("id=compare_3074457345616689606");
		
		 WebElement Element1 = findTheElement("id=compare_3074457345616689610");
		 JavascriptExecutor jse1 = (JavascriptExecutor)browser;
	      jse1.executeScript("arguments[0].scrollIntoView();", Element);
		 
		    Thread.sleep(2000);
		 click("id=compare_3074457345616689610");
		 Thread.sleep(3000);
		 click("id=compare_3074457345616689612");
		 Thread.sleep(3000);
		 String message = "The maximum number of products that can be compared is 4. Please refine your selection.";
		 String comapremessage=getText("xpath=//*[@id='widget_product_comparison_popup']/div/div[3]/div/div/div/div[2]/p");
		 if(message.contains(comapremessage))
		 {
		  Thread.sleep(2000);
		  click("xpath=//*[@id='widget_product_comparison_popup']/div/div[3]/div/div/div/div[3]/div/div[1]/a");
		  rpt.createTest("CIRCUIT CITY", "Verify upto 4 products are added to comapre in product listing page - "+comapremessage+"");
		        rpt.Pass(""+comapremessage+" - "+getTitle()+"");
		        rpt.Category("CIRCUIT CITY - Verify product listing page");
		        String path = rpt.CaptureScreen(browser, "ValidMessage");
		        rpt.imgPathPass(path);
		        
		 }
		 else
		 {
		  rpt.createTest("CIRCUIT CITY", "Verify upto 4 products are added to comapre in product listing page - "+comapremessage+"");
		        rpt.Fail("Able to add more than 4 products to comapre in product listing page");
		        rpt.Category("CIRCUIT CITY - Verify product listing page");
		        String path = rpt.CaptureScreen(browser, "InvalidMessage");
		        rpt.imgPathFail(path);
		 }
		 
		 
		}
		public void PDP_page() throws Exception
		{
			//logIn();
			click("id=allDepartmentsButton");
			click("id=departmentLink_3074457345616682169_alt");
			click("id=catalogEntry_img3074457345616698776");
			Thread.sleep(3000);
			
			 Map<String,String> fields= new HashMap<String,String>();
		   	  fields.put("Name", "//*[@id='PageHeading_3074457345618265621']");
		   	  fields.put("Image", "//*[@id='productMainImage_3074457345616698776']");
		   	  fields.put("Price", "//*[@id='promotionalPrice_3074457345616698776']");
		   	  fields.put("Description", "//*[@id='container_3074457345618272605']/div[2]/div[1]/div[4]/div[3]/h3");
		   	  fields.put("Availability", "//*[@id='container_3074457345618272605']/div[2]/div[2]/div[5]/div[3]");
		   	  fields.put("Quantity", "//*[@id='PDPquantity_3074457345616698776']");
		   	   fields.put("Add to cart", "//*[@id='add2CartBtn']");
		   	   fields.put("Add to wishlist", "//*[@id='3074457345616698776addToShoppingList']");
		   	  fields.put("Breadcrumb", "//*[@id='widget_breadcrumb']");
		   		
		   		 for(Map.Entry<String, String> field : fields.entrySet() )
		   		 {
		   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify PDP Page", "PDP Page field :"+field.getKey()+" Displayed ");
		   		         rpt.Pass("PDP Page field :"+field.getKey()+" Displayed ");
		   		         rpt.Category("CIRCUIT CITY - Verify PDP Page");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			 }
		   			 else
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify PDP Page", "PDP Page field :"+field.getKey()+" NOT Displayed");
		   		         rpt.Fail("PDP Page field :"+field.getKey()+" NOT Displayed");
		   		         rpt.Category("CIRCUIT CITY - Verify PDP Page");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			 }
		   		 }
		}
		   		public void addToCart() throws Exception
				{
		   			click("id=allDepartmentsButton");
					click("id=departmentLink_3074457345616682169_alt");
					click("id=catalogEntry_img3074457345616698776");
					Thread.sleep(3000);
		   			click("id=add2CartBtn"); //add to cart
		   			Thread.sleep(3000);
		   			String alert="Your item was added";
		   			if(alert.contains("Your item was added"))
		   			{
		   				 rpt.createTest("CIRCUIT CITY - Verify Add To Cart ", "Product is added to cart " +alert);
		   		         rpt.Pass("Product is added to cart " +alert);
		   		         rpt.Category("CIRCUIT CITY - Verify Add To Cart");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			}
		   			else
		   			{
		   				rpt.createTest("CIRCUIT CITY - Verify Add To Cart", "Product NOT added to cart");
		   		         rpt.Fail("Product NOT added to cart");
		   		         rpt.Category("CIRCUIT CITY - Verify Add To Cart");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			}
				}
		   	
		   		public void addToWishlist() throws Exception
				{
		   			Thread.sleep(3000);
		   			click("id=MiniShopCartCloseButton_2"); //close button
		   			Thread.sleep(3000);
		   			//click("id=3074457345616698776addToShoppingList"); //wishlist
		   			
		   			if(findTheElement("id=3074457345616698776addToShoppingListBtn").isDisplayed())
		   			{
		   				click("id=3074457345616698776addToShoppingListBtn"); //wishlist
		   				 rpt.createTest("CIRCUIT CITY - Verify Add To Wishlist ", "Product is added to wishlist ");
		   		         rpt.Pass("Product is added to wishlist ");
		   		         rpt.Category("CIRCUIT CITY - Verify Add To Wishlist");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			}
		   			else
		   			{
		   				rpt.createTest("CIRCUIT CITY - Verify Add To Wishlist", "Product NOT added to wishlist ");
		   		         rpt.Fail("Product NOT added to wishlist ");
		   		         rpt.Category("CIRCUIT CITY - Verify Add To Wishlist");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		 
		   			}
		   			
		   			/*click("id=WC_AccountDisplay_FormInput_logonId_In_Logon_1");
					sendKeys("id=WC_AccountDisplay_FormInput_logonId_In_Logon_1", Logon_ID);
					click("id=WC_AccountDisplay_FormInput_logonPassword_In_Logon_1");
					sendKeys("id=WC_AccountDisplay_FormInput_logonPassword_In_Logon_1", pwd);
					click("id=WC_AccountDisplay_links_2");//sign in */
				    Thread.sleep(3000);
					//Thread.sleep(3000);
					//click("xpath=/html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[3]/div[1]/div[1]/a"); //my acc
		   			
				}
		   		public void productQuantity() throws Exception
				{
		   			click("id=allDepartmentsButton");
					click("id=departmentLink_3074457345616682171_alt");
					Thread.sleep(3000);
					click("id=WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616689334_link_9b");
					Thread.sleep(3000);
		   			click("id=add2CartBtn"); //add to cart
		   			Thread.sleep(3000);
		   			click("id=MiniShopCartCloseButton_2"); //close button
		   			Thread.sleep(3000);
		   			click("id=minishopcart_total");
		   			Thread.sleep(3000);
		   			click("id=GotoCartButton1");
		   			Thread.sleep(5000);
		   			//String price_before=findTheElement("xpath=/html/body/div[3]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[1]/span[2]").getText();
		   			//System.out.println(price_before);
		   			Thread.sleep(5000);
		   			click("xpath=//*[@id='ShopCartPagingDisplay']/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div[1]"); //increasing quantity
		   			Thread.sleep(5000);
		   			
		   			Thread.sleep(5000);
		   			//String price_after=findTheElement("xpath=/html/body/div[3]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[1]/span[2]").getText();
		   			//System.out.println(price_after);
		   			
		   			if(findTheElement("xpath=//*[@id='ShopCartPagingDisplay']/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/a").isDisplayed())
		   			{
		   				click("xpath=//*[@id='ShopCartPagingDisplay']/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/a"); //update
		   				rpt.createTest("CIRCUIT CITY - Verify Product Quantity ", "Product Quantity is increased and order total is re-calculated based on quantity " );
		   		         rpt.Pass("Product Quantity is increased and order total is re-calculated based on quantity");
		   		         rpt.Category("CIRCUIT CITY - Verify Product Quantity");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			}
		   			else
		   			{
		   				rpt.createTest("CIRCUIT CITY - Verify Product Quantity", "Product Quantity NOT increased and order total is NOT re-calculated based on quantity");
		   		         rpt.Fail("Product Quantity NOT increased and order total is NOT re-calculated based on quantity");
		   		         rpt.Category("CIRCUIT CITY - Verify Product Quantity");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			}
		   			
		   			promoCode();
		   			Thread.sleep(5000);
		   			click("xpath=//*[@id='page']/div[4]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[8]/a"); //rdy to chckout
		   			Thread.sleep(3000);
		   			/*sendKeys("id=WC_CheckoutLogon_FormInput_logonId",Logon_ID);
		   			sendKeys("id=WC_CheckoutLogon_FormInput_logonPassword",pwd);
		   			Thread.sleep(3000);
		   			click("id=guestShopperLogon"); //submit */
		   			click("id=button"); //add adress
		   			Thread.sleep(5000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1",address);
		   			Thread.sleep(3000);
		   			click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1",city);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1",state);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //use this address
		   			Thread.sleep(5000);
		   			//payment
		   			sendKeys("id=card-number",creditCardNo);
		   			Thread.sleep(2000);
		   			sendKeys("id=cvv",cvv);
		   			
		   			select("id=expiration-year", "2020");
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //update
		   			Thread.sleep(2000);
		   			click("id=placeOrder"); //place order
		   			Thread.sleep(2000);
		   			
		   			
		   			
		   			
		   			
				}
		   		public void promoCode() throws Exception
				{
		   			if(findTheElement("id=promoCode").isDisplayed())
		   			{
		   				String total=getText("id=promoCode");
		   				
		   				//System.out.println("Promo Code is displayed and is functional for each product  - " +total);
		   				rpt.createTest("CIRCUIT CITY - Verify Promo Code", "Promo Code field is displayed and is functional for each product");
		   		         rpt.Pass("Promo Code field is displayed and is functional for each product");
		   		         rpt.Category("CC_Shopping Cart - Verify Promo Code");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   		 		sendKeys("id=promoCode","10PERCOFF");
		   			}
		   			else
		   			{
		   				//System.out.println("Promo Code NOT displayed and NOT functional for each product");
		   				rpt.createTest("CC - Shopping Cart - Verify Promo Code", "Promo Code field NOT displayed and NOT functional for each product");
		   		         rpt.Fail("Promo Code field NOT displayed and NOT functional for each product");
		   		         rpt.Category("CC_Shopping Cart - Verify Promo Code");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			}
		   			click("id=WC_PromotionCodeDisplay_links_1"); //apply button
				}
		   		public void checkOut() throws Exception
				{
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_CheckoutLogon_FormInput_logonId",Logon_ID);
		   			sendKeys("id=WC_CheckoutLogon_FormInput_logonPassword",pwd);
		   			Thread.sleep(3000);
		   			click("id=guestShopperLogon"); //submit
		   			Thread.sleep(5000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1",address);
		   			Thread.sleep(3000);
		   			click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1",city);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1",state);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //use this address
		   			Thread.sleep(5000);
		   			//payment
		   			sendKeys("id=card-number",creditCardNo);
		   			sendKeys("id=cvv",cvv);
		   			
		   			select("id=expiration-year", "2020");
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //update
		   			Thread.sleep(2000);
		   			click("id=placeOrder"); //place order
		   			Thread.sleep(2000);
				}
		   		public void installation() throws Exception
				{
		   			sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS");
		   			Thread.sleep(3000);
		   			click("id=autoSelectOption_2");
		   			Thread.sleep(3000);
		   			Robot r = new Robot();
		   			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		   			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		   			Thread.sleep(5000);
		   			//click("id=product_name_3074457345616837668");
		   			doubleClick("xpath=//*[@id='product_name_3074457345616837668']/div"); //installation
		   			Thread.sleep(3000);
		   			click("id=add2CartBtn");
		   			Thread.sleep(3000);
		   			click("id=MiniShopCartCloseButton_2"); //close button
		   			Thread.sleep(3000);
		   			click("id=minishopcart_total");
		   			Thread.sleep(3000);
		   			click("id=GotoCartButton1");
		   			Thread.sleep(5000);
		   			
		   			click("xpath=//*[@id='page']/div[4]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[8]/a"); //rdy to chckout
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_CheckoutLogon_FormInput_logonId",Logon_ID);
		   			sendKeys("id=WC_CheckoutLogon_FormInput_logonPassword",pwd);
		   			Thread.sleep(3000);
		   			click("id=guestShopperLogon"); //submit
		   			Thread.sleep(5000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1",address);
		   			Thread.sleep(3000);
		   			click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1",city);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1",state);
		   			Thread.sleep(3000);
		   			sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //use this address
		   			Thread.sleep(5000);
		   			//payment
		   			sendKeys("id=card-number",creditCardNo);
		   			sendKeys("id=cvv",cvv);
		   			
		   			select("id=expiration-year", "2020");
		   			Thread.sleep(2000);
		   			click("id=summaryButton"); //update
		   			Thread.sleep(2000);
		   			click("id=placeOrder"); //place order
		   			Thread.sleep(2000);
		   			
		   			
		   			
		   			String alert=findTheElement("xpath=/html/body/div[1]/div[5]/div[2]/div[2]").getText();
		   			System.out.println(alert);
		   			if(alert.contains("Cart: $2,071.10"))
		   			{
		   				 rpt.createTest("CIRCUIT CITY - Verify Product Installation ", "Product with installation type is added and done checkout");
		   		         rpt.Pass("Product with installation type is added and done checkout");
		   		         rpt.Category("CIRCUIT CITY - Verify Product Installation ");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			}
		   			else
		   			{
		   				rpt.createTest("CIRCUIT CITY - Verify Product Installation ", "Product with installation type NOT added and done checkout");
		   		         rpt.Fail("Product with installation type NOT added and done checkout");
		   		         rpt.Category("CIRCUIT CITY - Verify Product Installation ");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			}
				}
		   		
		   		
		   		//to add in the end
		   		public void checkoutAsGuest() throws Exception
				{
		   			//click("xpath=/html/body/div[1]/div[5]/div[1]/a"); //
		   			click("id=allDepartmentsButton");
					click("id=departmentLink_3074457345616682169_alt");
					click("id=catalogEntry_img3074457345616698776");
					Thread.sleep(3000);
		   			click("id=add2CartBtn"); //add to cart
		   			click("id=MiniShopCartCloseButton_2"); //close button
		   			Thread.sleep(3000);
		   			click("id=minishopcart_total");
		   			Thread.sleep(3000);
		   			click("id=GotoCartButton1");
		   			Thread.sleep(3000);
		   			click("xpath=/html/body/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[7]/a"); //rdy to chckout
		   			Thread.sleep(3000);
		   			String alert="Sign in ";
		   			if(alert.contains("Sign in "))
		   			{
		   				 rpt.createTest("CIRCUIT CITY - Verify Ready To Checkout ", "Sign in and Guest checkout page is displayed");
		   		         rpt.Pass("Sign in and Guest checkout page is displayed");
		   		         rpt.Category("CIRCUIT CITY - Verify Ready To Checkout");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			}
		   			else
		   			{
		   				rpt.createTest("CIRCUIT CITY - Verify Ready To Checkout", "Sign in and Guest checkout page NOT displayed");
		   		         rpt.Fail("Sign in and Guest checkout page NOT displayed");
		   		         rpt.Category("CIRCUIT CITY - Verify Ready To Checkout");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			}
		   			
				}
	
		
}
