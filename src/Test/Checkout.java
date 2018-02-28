package Test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Checkout extends Browser {
	Report rpt = new Report();
	Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	
	public void ExecuteAll_Checkout() throws Exception
	{
		//ch_VerifyShippingBillingAddress();
		//ch_VerifyFirstColumn();
		//ch_VerifyFirstName();
	
		//ch_VerifyEmailPhone();
		//ch_sameAddressforBilling();
		ch_BillingAddressFields();
		//ch_deleteAddedAddress();
		
	}
	
	public void ch_pageNavigation() throws Exception
	{
		Thread.sleep(4000);
		//click("xpath=//a[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722768_link_9b']");
		if (findTheElement(
				 "xpath=//a[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722768_link_9b']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- select product functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- selecting product functionality Verification");
				rpt.Pass("Checkout – select product functionality Displayed - For Verify Checkout page- Selecting product functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – selecting product Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//a[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722768_link_9b']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Product Selected ");

			} else {
				rpt.createTest("CC - Checkout - Verify CheckoutPage - twitter functionality Verification",
						" Checkout – select product Verification Page is NOT Displayed - For Verify Checkout - select product functionality Verification");
				rpt.Fail("Checkout - select product functionality Verification is NOT Displayed - For Verify Home Page_Footer - twitter functionality Verification");
				rpt.Category("CC_ Checkout - Verify Home Page_Footer - select product functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality – Product is not selected");
			}

		Thread.sleep(4000);
		//click("xpath=//a[@id='add2CartBtn']");
		
		if (findTheElement(
				 "xpath=//a[@id='add2CartBtn']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click Add to Cart functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Add to Cart functionality Verification");
				rpt.Pass("Checkout – Click Add to Cart functionality Displayed - For Verify Checkout page- Click Add to Cart functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Add to CartVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//a[@id='add2CartBtn']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Add to cart button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Add to Cart functionality Verification",
						" Checkout – Click Add to Cart Verification Page is NOT Displayed - For Verify Checkout - Click Add to Cart functionality Verification");
				rpt.Fail("Checkout - Click Add to Cart functionality Verification is NOT Displayed - For Verify Checkout_ – Click add To cart functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Add to Cart functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Add to cart button is not clicked");
			}

		Thread.sleep(4000);
		//click("id=MiniShopCartCloseButton_2");
		if (findTheElement(
				 "id=MiniShopCartCloseButton_2")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click Click Mini Cart Close  functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Click Mini Cart Close  functionality Verification");
				rpt.Pass("Checkout – Click Click Mini Cart Close  functionality Displayed - For Verify Checkout page- Click Click Mini Cart Close  functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Click Mini Cart Close Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=MiniShopCartCloseButton_2");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Mini Cart Close  button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click Mini Cart Close  functionality Verification",
						" Checkout – Click Click Mini Cart Close  Verification Page is NOT Displayed - For Verify Checkout - Click Click Mini Cart Close  functionality Verification");
				rpt.Fail("Checkout - Click Click Mini Cart Close  functionality Verification is NOT Displayed - For Verify Checkout_ – Click Click Mini Cart Close  functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Click Mini Cart Close  functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Mini Cart Close  button is not clicked");
			}

		Thread.sleep(4000);
		//click("id=widget_minishopcart");
		if (findTheElement(
				 "id=widget_minishopcart")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- click Minicart shop icon functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Minicart shop icon functionality Verification");
				rpt.Pass("Checkout – Click Click Minicart shop icon functionality Displayed - For Verify Checkout page- Click Click Minicart shop icon functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Minicart shop iconVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=widget_minishopcart");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Click Minicart shop icon button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click Minicart shop icon functionality Verification",
						" Checkout –Click Minicart shop icon Verification Page is NOT Displayed - For Verify Checkout - Click Minicart shop icon functionality Verification");
				rpt.Fail("Checkout - Click Minicart shop icon functionality Verification is NOT Displayed - For Verify Checkout_ – Click Click Minicart shop icon functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Minicart shop icon functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Click Minicart shop icon button is not clicked");
			}

		Thread.sleep(4000);
		//click("id=GotoCartButton1");
		if (findTheElement(
				 "id=GotoCartButton1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click Go to Cart button functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Go to Cart button functionality Verification");
				rpt.Pass("Checkout –Click Go to Cart button functionality Displayed - For Verify Checkout page- Click Go to Cart button functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Go to Cart buttonVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=GotoCartButton1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Go to Cart button button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click Go to Cart button functionality Verification",
						" Checkout –Click Go to Cart button Verification Page is NOT Displayed - For Verify Checkout - Click Go to Cart button functionality Verification");
				rpt.Fail("Checkout - Click Go to Cart button functionality Verification is NOT Displayed - For Verify Checkout_ –Click Go to Cart button functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Go to Cart button functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality – Go to Cart button is not clicked");
			}

		Thread.sleep(4000);
		//click("xpath=//a[@class='button_secondary']");
		if (findTheElement(
				 "id=widget_minishopcart")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click READY TO CHECKOUT button functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click READY TO CHECKOUT button functionality Verification");
				rpt.Pass("Checkout –Click READY TO CHECKOUT button functionality Displayed - For Verify Checkout page- Click READY TO CHECKOUT button functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click READY TO CHECKOUT buttonVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//a[@class='button_secondary']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –READY TO CHECKOUT button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click READY TO CHECKOUT button functionality Verification",
						" Checkout –Click READY TO CHECKOUT button Verification Page is NOT Displayed - For Verify Checkout - Click READY TO CHECKOUT button functionality Verification");
				rpt.Fail("Checkout - Click READY TO CHECKOUT button functionality Verification is NOT Displayed - For Verify Checkout_ –Click READY TO CHECKOUT button functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click READY TO CHECKOUT button functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality – READY TO CHECKOUT  button is not clicked");
			}

		Thread.sleep(5000);
		//click("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']");
		if (findTheElement(
				 "xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Clicking User Name Textbox functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Clicking User Name Textbox functionality Verification");
				rpt.Pass("Checkout –Clicking User Name Textbox functionality Displayed - For Verify Checkout page- Clicking User Name Textbox functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Clicking User Name TextboxVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – User Name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Clicking User Name Textbox functionality Verification",
						" Checkout –Clicking User Name Textbox Verification Page is NOT Displayed - For Verify Checkout - Clicking User Name Textbox functionality Verification");
				rpt.Fail("Checkout - Clicking User Name Textbox functionality Verification is NOT Displayed - For Verify Checkout_ –Clicking User Name Textbox functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Clicking User Name Textbox functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –User Name Text box is not clicked");
			}

		Thread.sleep(5000);
		//sendKeys("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']","kanimozhi.p@royalcyber.com");
		if (findTheElement(
				 "xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Enter User Name into User Name functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Enter User Name into User Name functionality Verification");
				rpt.Pass("Checkout –Enter User Name into User Name functionality Displayed - For Verify Checkout page- Enter User Name into User Name functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Enter User Name into User NameVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonId']","kanimozhi.p@royalcyber.com");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – User Name is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Enter User Name into User Name functionality Verification",
						" Checkout –Enter User Name into User Name Verification Page is NOT Displayed - For Verify Checkout - Enter User Name into User Name functionality Verification");
				rpt.Fail("Checkout - Enter User Name into User Name functionality Verification is NOT Displayed - For Verify Checkout_ –Enter User Name into User Name functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Enter User Name into User Name functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –User name is not entered");
			}

		//click("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']");
		if (findTheElement(
				 "xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click Password Text box functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Password Text box functionality Verification");
				rpt.Pass("Checkout –Click Password Text box functionality Displayed - For Verify Checkout page- Click Password Text box functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Password Text boxVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Password Text Box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click Password Text box functionality Verification",
						" Checkout –Click Password Text box Verification Page is NOT Displayed - For Verify Checkout - Click Password Text box functionality Verification");
				rpt.Fail("Checkout - Click Password Text box functionality Verification is NOT Displayed - For Verify Checkout_ –Click Password Text box functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Password Text box functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Password is not clicked");
			}

		//sendKeys("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']","Kanimozhi1234");
		if (findTheElement(
				 "xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Enter Password into Password Text box functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Enter Password into Password Text box functionality Verification");
				rpt.Pass("Checkout –Enter Password into Password Text box functionality Displayed - For Verify Checkout page- Enter Password into Password Text box functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Enter Password into Password Text boxVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("xpath=//input[@id='WC_CheckoutLogon_FormInput_logonPassword']","Kanimozhi1234");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Password is Entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Enter Password into Password Text box functionality Verification",
						" Checkout –Enter Password into Password Text box Verification Page is NOT Displayed - For Verify Checkout - Enter Password into Password Text box functionality Verification");
				rpt.Fail("Checkout - Enter Password into Password Text box functionality Verification is NOT Displayed - For Verify Checkout_ –Enter Password into Password Text box functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Enter Password into Password Text box functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Password is not Entered");
			}

		//click("xpath=//a[@id='guestShopperLogon']");
		if (findTheElement(
				 "xpath=//a[@id='guestShopperLogon']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout- Click Signin Button  functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout- Click Signin Button  functionality Verification");
				rpt.Pass("Checkout –Click Signin Button  functionality Displayed - For Verify Checkout page- Click Signin Button  functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout – Click Signin Button Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//a[@id='guestShopperLogon']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –SignIn button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout Footer – Click Signin Button  functionality Verification",
						" Checkout –Click Signin Button  Verification Page is NOT Displayed - For Verify Checkout - Click Signin Button  functionality Verification");
				rpt.Fail("Checkout - Click Signin Button  functionality Verification is NOT Displayed - For Verify Checkout_ –Click Signin Button  functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout page - Click Signin Button  functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout Functionality –Sign in button is not clicked");
			}

		
		Thread.sleep(3000);
		
	}

	
	public void ch_deleteAddedAddress() throws Exception
	{
		Thread.sleep(4000);
		previousViewed pv= new previousViewed();
		pv.Login();
		Thread.sleep(2000);
		click("xpath=//a[@href='https://qalive.circuitcity.com/AjaxLogonForm?myAcctMain=1&catalogId=3074457345616676668&langId=-1&storeId=10801']");
		Thread.sleep(3000);
		click("xpath=//a[@id='WC_MyAccountSidebarDisplayf_links_2']");
		Thread.sleep(3000);
		click("xpath=//a[@id='WC_AjaxAddressBookForm_links_2']");
		Thread.sleep(3000);
		click("xpath=//a[@id='clickableErrorMessageImg']");
		Thread.sleep(3000);
		click("xpath=//a[@id='myAccountQuickLink']");
		Thread.sleep(3000);
		click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']");
		
		
		
	}
	public void ch_VerifyShippingBillingAddress() throws Exception
	{
		ch_pageNavigation();
		Thread.sleep(3000);
		String Title=browser.getTitle();
		System.out.println(Title);
		
		
		if (Title.equals("CircuitCityB2C - Shipping and Billing Display"))
		{
			System.out.println("Shipping And Billing address page is displayed");
		}
		else
		{
			System.out.println("Shipping And Billing address page is NOT displayed");
		}
	}
	
	//CC_A&C_04-Verify "1. Shipping"  text is displayed as title for 1st column.
	public void ch_VerifyFirstColumn() throws Exception
	{
		Thread.sleep(2000);
		ch_pageNavigation();
		Thread.sleep(4000);
		String FirstTitle=getText("xpath=/html/body/div[1]/div[6]/div/div[1]/div[1]/h2");
		System.out.println(FirstTitle);
		
		
		if (FirstTitle.equals("1. Shipping"))
		{
			System.out.println("Shipping is displayed as First Column");
		}
		else
		{
			System.out.println("Shipping is not displayed as First Column");
		}
	}
	
	//CC_A&C_08- Verify First Name
	
	/*public void ch_VerifyFirstName() throws Exception
	{
		ch_pageNavigation();
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("First Name", "WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1"); 
		 ids.put("Last Name", "WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		 ids.put("Street Address1", "WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1");
		 ids.put("City", "WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1");
		 ids.put("State", "WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1");
		 ids.put("Zip Code", "WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1");
		 
		                   
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isEnabled())
			 {
				 Thread.sleep(3000);
				 click("xpath=//*[@id='"+id.getValue()+"']");
					sendKeys("xpath=//*[@id='"+id.getValue()+"']","Test");
					click("id=shippingActive");
			 }
			 
			 else
			 {
				System.out.println("Fail"); 
			 }
			
			 
		 }
		 System.out.println("First Name, Last Name, Street Address, City , State, Zip Code fields are dispalyed and Editable");
		 //browser.switchTo().alert().dismiss();
		// select("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_country_1-button", "Tuvalu");
		 }
	*/
	//CC_A&C_16- Email and Phone Number
	public void ch_VerifyEmailPhone() throws Exception
	{
		ch_pageNavigation();
		String username = findTheElement("xpath=//*[@id='WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1']").getAttribute("value");
		System.out.println(username);
		String password = findTheElement("xpath=//*[@id='WC_ShippingAddressForm__AddressEntryForm_FormInput_phone1_1']").getAttribute("value");
		System.out.println(password);
		
		
		//String Testt=findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1").getText();
		//String s=getText("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1");
//		click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1");
		
	}
	
	
	//CC_A&C_18- Same Address for billing
	public void ch_sameAddressforBilling() throws Exception
	{
		ch_pageNavigation();
		Thread.sleep(6000);
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click First Name Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click First Name Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click First Name Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click First Name Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click First Name Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –First Name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click First Name Text box in shipping address functionality Verification",
						" Checkout –Click First Name Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click First Name Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click First Name Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click First Name Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click First Name Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –First Name Text box is not clicked");
			}

		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1","Kanimozhi");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Enter first name  functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Enter first name  functionality Verification");
				rpt.Pass("Checkout –Enter first name  functionality Displayed - For Verify Checkout_ Shipping Address - Enter first name  functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Enter first name Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1","Kanimozhi");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –First Name is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Enter first name  functionality Verification",
						" Checkout –Enter first name  Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Enter first name  functionality Verification");
				rpt.Fail("Checkout - Enter first name  functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Enter first name  functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Enter first name  functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –First Name is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click Last Name Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click Last Name Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click Last Name Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click Last Name Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click Last Name Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Last Name text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click Last Name Text box in shipping address functionality Verification",
						" Checkout –Click Last Name Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click Last Name Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click Last Name Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click Last Name Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click Last Name Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –Last Name textbox is not clicked");
			}

		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1","Kanimozhi");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Enter Last Name functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Enter Last Name functionality Verification");
				rpt.Pass("Checkout –Enter Last Name functionality Displayed - For Verify Checkout_ Shipping Address - Enter Last Name functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Enter Last NameVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1","Kanimozhi");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Last Name is Entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Enter Last Name functionality Verification",
						" Checkout –Enter Last Name Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Enter Last Name functionality Verification");
				rpt.Fail("Checkout - Enter Last Name functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Enter Last Name functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Enter Last Name functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –Last Name is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click Address Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click Address Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click Address Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click Address Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click Address Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Street name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click Address Text box in shipping address functionality Verification",
						" Checkout –Click Address Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click Address Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click Address Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click Address Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click Address Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address – Street Name Text box is not clicked");
			}

		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1","100-198 CHICAGO AVE");
		
		Thread.sleep(2000);
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click City Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click City Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click City Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click City Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click City Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –City Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click City Text box in shipping address functionality Verification",
						" Checkout –Click City Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click City Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click City Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click City Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click City Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –City Text box is not clicked");
			}

		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1","Evanston");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Enter Street Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Enter Street Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Enter Street Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Enter Street Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Enter Street Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1","Evanston");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Street name textbox is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Enter Street Text box in shipping address functionality Verification",
						" Checkout –Enter Street Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Enter Street Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Enter Street Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Enter Street Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Enter Street Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –Street name is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1");
		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1","Chennai");
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click State Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click State Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click State Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click State Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click State Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – State Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click State Text box in shipping address functionality Verification",
						" Checkout –Click State Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click State Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click State Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click State Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click State Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address – State Text box is not clicked");
			}

		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1","IL");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Enter State Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Enter State Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Enter State Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Enter State Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Enter State Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1","IL");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –State textbox is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Enter State Text box in shipping address functionality Verification",
						" Checkout –Enter State Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Enter State Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Enter State Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Enter State Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Enter State Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –State text box is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Click Zipcode Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Click Zipcode Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Click Zipcode Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Click Zipcode Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Click Zipcode Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Zipcode Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Click Zipcode Text box in shipping address functionality Verification",
						" Checkout –Click Zipcode Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Click Zipcode Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Click Zipcode Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Click Zipcode Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Click Zipcode Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address – Zipcode Text box is not clicked");
			}

		//sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1","60202");
		if (findTheElement(
				 "id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Enter Zip Code Text box in shipping address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Enter Zip Code Text box in shipping address functionality Verification");
				rpt.Pass("Checkout –Enter Zip Code Text box in shipping address functionality Displayed - For Verify Checkout_ Shipping Address - Enter Zip Code Text box in shipping address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Enter Zip Code Text box in shipping addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1","60202");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Zipcode textbox is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Enter Zip Code Text box in shipping address functionality Verification",
						" Checkout –Enter Zip Code Text box in shipping address Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Enter Zip Code Text box in shipping address functionality Verification");
				rpt.Fail("Checkout - Enter Zip Code Text box in shipping address functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Enter Zip Code Text box in shipping address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Enter Zip Code Text box in shipping address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address –Zipcode text box is not entered");
			}

		Thread.sleep(3000);
		
		click("id=shippingActive");
		//click("xpath=//button[@id='shippingButton']");
		if (findTheElement(
				 "xpath=//button[@id='shippingButton']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Clicking USE THIS ADDRESS button functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Clicking USE THIS ADDRESS button functionality Verification");
				rpt.Pass("Checkout –Clicking USE THIS ADDRESS button functionality Displayed - For Verify Checkout_ Shipping Address - Clicking USE THIS ADDRESS button functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Clicking USE THIS ADDRESS buttonVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//button[@id='shippingButton']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –USE THIS ADDRESS button is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Clicking USE THIS ADDRESS button functionality Verification",
						" Checkout –Clicking USE THIS ADDRESS button Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Clicking USE THIS ADDRESS button functionality Verification");
				rpt.Fail("Checkout - Clicking USE THIS ADDRESS button functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Clicking USE THIS ADDRESS button functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Clicking USE THIS ADDRESS button functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Shipping Address – USE THIS ADDRESS button is not clicked ");
			}

		Thread.sleep(3000);
		
		boolean CheckStatus =findTheElement("xpath=//div[@id='sameAs1']").isEnabled();
		
		
		boolean b=true;
		
		if(CheckStatus= b)
		{
			System.out.println("Same As Shipping Address Check Box is Checked");
		
		}
		else
		{
			System.out.println("Same as shipping address check box is not selected & Case Failed");
		}
		
		
	}
	
	// Billing Address field verification
	
	public void ch_BillingAddressFields() throws Exception
	{
		//ch_deleteAddedAddress();
		ch_sameAddressforBilling();
		Thread.sleep(9000);
		//click("xpath=//div[@id='sameAs1']");
		if (findTheElement(
				 "xpath=//div[@id='sameAs1']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Shipping Address- Clicking Same as this address  functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Shipping Address- Clicking Same as this address  functionality Verification");
				rpt.Pass("Checkout –Clicking Same as this address  functionality Displayed - For Verify Checkout_ Shipping Address - Clicking Same as this address  functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Shipping Address – Clicking Same as this address Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[@id='sameAs1']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Same as this address  is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Shipping Address – Clicking Same as this address  functionality Verification",
						" Checkout –Clicking Same as this address  Verification Page is NOT Displayed - For Verify Checkout_ Shipping Address - Clicking Same as this address  functionality Verification");
				rpt.Fail("Checkout - Clicking Same as this address  functionality Verification is NOT Displayed - For Verify Checkout_ Shipping Address _ –Clicking Same as this address  functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Shipping Address - Clicking Same as this address  functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Same as this address  is not clicked ");
			}

		Thread.sleep(4000);
		//click("xpath=//div[@id='showAddNewBillingAddress1']");
		if (findTheElement(
				 "xpath=//div[@id='showAddNewBillingAddress1']")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Clicking Add a New Billing Address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Clicking Add a New Billing Address functionality Verification");
				rpt.Pass("Checkout –Clicking Add a New Billing Address functionality Displayed - For Verify Checkout_ Billing Address - Clicking Add a New Billing Address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Clicking Add a New Billing AddressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[@id='showAddNewBillingAddress1']");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Add a New Billing Address is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Clicking Add a New Billing Address functionality Verification",
						" Checkout –Clicking Add a New Billing Address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Clicking Add a New Billing Address functionality Verification");
				rpt.Fail("Checkout - Clicking Add a New Billing Address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Clicking Add a New Billing Address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Clicking Add a New Billing Address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Add a New Billing Address is not clicked ");
			}

		
		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click First name Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click First name Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click First name Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click First name Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click First name Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –First Name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click First name Text box in Billing address functionality Verification",
						" Checkout –Click First name Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click First name Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click First name Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click First name Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click First name Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address –First name Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1","Circuit");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter First Name functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter First Name functionality Verification");
				rpt.Pass("Checkout –Enter First Name functionality Displayed - For Verify Checkout_ Billing Address - Enter First Name functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter First NameVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_firstName_1","Circuit");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –First name is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter First Name functionality Verification",
						" Checkout –Enter First Name Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter First Name functionality Verification");
				rpt.Fail("Checkout - Enter First Name functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter First Name functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter First Name functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – First name is not entered");
			}

		Thread.sleep(2000);
		
		click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_lastName_1");
		if (findTheElement(
				 "id=widget_minishopcart")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click Last Name name Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click Last Name name Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click Last Name name Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click Last Name name Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click Last Name name Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=widget_minishopcart");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Last Name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click Last Name name Text box in Billing address functionality Verification",
						" Checkout –Click Last Name name Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click Last Name name Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click Last Name name Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click Last Name name Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click Last Name name Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Last name Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_lastName_1","City");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_lastName_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter Last Name functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter Last Name functionality Verification");
				rpt.Pass("Checkout –Enter Last Name functionality Displayed - For Verify Checkout_ Billing Address - Enter Last Name functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter Last NameVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_lastName_1","City");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Last Name is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter Last Name functionality Verification",
						" Checkout –Enter Last Name Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter Last Name functionality Verification");
				rpt.Fail("Checkout - Enter Last Name functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter Last Name functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter Last Name functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Last Name is not entered");
			}

		Thread.sleep(2000);
		

		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click Street Name name Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click Street Name name Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click Street Name name Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click Street Name name Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click Street Name name Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Street Name Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click Street Name name Text box in Billing address functionality Verification",
						" Checkout –Click Street Name name Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click Street Name name Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click Street Name name Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click Street Name name Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click Street Name name Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Street name Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1","100-198 CHICAGO AVE");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter Street Name functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter Street Name functionality Verification");
				rpt.Pass("Checkout –Enter Street Name functionality Displayed - For Verify Checkout_ Billing Address - Enter Street Name functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter Street NameVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_address1_1","100-198 CHICAGO AVE");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Street Name is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter Street Name functionality Verification",
						" Checkout –Enter Street Name Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter Street Name functionality Verification");
				rpt.Fail("Checkout - Enter Street Name functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter Street Name functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter Street Name functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Street Name is not entered");
			}


		Thread.sleep(2000);
		

		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click State Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click State Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click State Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click State Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click State Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – State Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click State Text box in Billing address functionality Verification",
						" Checkout –Click State Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click State Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click State Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click State Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click State Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – State Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1","Evanston");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter State functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter State functionality Verification");
				rpt.Pass("Checkout –Enter State functionality Displayed - For Verify Checkout_ Billing Address - Enter State functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter StateVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_state_1","Evanston");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –State is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter State functionality Verification",
						" Checkout –Enter State Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter State functionality Verification");
				rpt.Fail("Checkout - Enter State functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter State functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter State functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – State is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click City Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click City Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click City Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click City Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click City Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – City Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click City Text box in Billing address functionality Verification",
						" Checkout –Click City Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click City Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click City Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click City Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click City Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – City Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1","IL");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter City functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter City functionality Verification");
				rpt.Pass("Checkout –Enter City functionality Displayed - For Verify Checkout_ Billing Address - Enter City functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter CityVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_city_1","IL");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –City is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter City functionality Verification",
						" Checkout –Enter City Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter City functionality Verification");
				rpt.Fail("Checkout - Enter City functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter City functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter City functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – City is not entered");
			}


		Thread.sleep(2000);
		
		
		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click Zip Code Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click Zip Code Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click Zip Code Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click Zip Code Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click Zip Code Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – ZIPCODE Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click Zip Code Text box in Billing address functionality Verification",
						" Checkout –Click Zip Code Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click Zip Code Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click Zip Code Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click Zip Code Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click Zip Code Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Zipcode Text box is not clicked ");
			}

		//sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1","60202");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Enter Zipcode functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Enter Zipcode functionality Verification");
				rpt.Pass("Checkout –Enter Zipcode functionality Displayed - For Verify Checkout_ Billing Address - Enter Zipcode functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Enter ZipcodeVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=WC_BillingAddressForm_AddressEntryForm_FormInput_zipCode_1","60202");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality –Zipcode is entered");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Enter Zipcode functionality Verification",
						" Checkout –Enter Zipcode Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Enter Zipcode functionality Verification");
				rpt.Fail("Checkout - Enter Zipcode functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Enter Zipcode functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Enter Zipcode functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Zipcode is not entered");
			}

		Thread.sleep(2000);
		
		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_email1_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_email1_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click Email Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click Email Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click Email Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click Email Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click Email Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_email1_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Email Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click Email Text box in Billing address functionality Verification",
						" Checkout –Click Email Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click Email Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click Email Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click Email Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click Email Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Email Text box is not clicked ");
			}

		Thread.sleep(2000);
		
		//click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_phone1_1");
		if (findTheElement(
				 "id=WC_BillingAddressForm_AddressEntryForm_FormInput_phone1_1")
					.isDisplayed()) {
				rpt.createTest("CC - Checkout - Verify Checkout_Billing Address- Click Phone Number Text box in Billing address functionality Verification",
						"Checkout – Product is Displayed - For Verify Checkout_Billing Address- Click Phone Number Text box in Billing address functionality Verification");
				rpt.Pass("Checkout –Click Phone Number Text box in Billing address functionality Displayed - For Verify Checkout_ Billing Address - Click Phone Number Text box in Billing address functionality Verification");
				rpt.Category("CC_Checkout - Verify Checkout_ Billing Address – Click Phone Number Text box in Billing addressVerification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=WC_BillingAddressForm_AddressEntryForm_FormInput_phone1_1");
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_Checkout – Functionality – Phone Number Text box is clicked");

			} else {
				rpt.createTest("CC - Checkout - Verify Checkout_ Billing Address – Click Phone Number Text box in Billing address functionality Verification",
						" Checkout –Click Phone Number Text box in Billing address Verification Page is NOT Displayed - For Verify Checkout_ Billing Address - Click Phone Number Text box in Billing address functionality Verification");
				rpt.Fail("Checkout - Click Phone Number Text box in Billing address functionality Verification is NOT Displayed - For Verify Checkout_ Billing Address _ –Click Phone Number Text box in Billing address functionality Verification");
				rpt.Category("CC_ Checkout - Verify checkout_ Billing Address - Click Phone Number Text box in Billing address functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
				rpt.chkBugs("Mahesh");
		        rpt.chkdebug("CC_ Checkout_ Billing Address – Phone Number Text box is not clicked ");
			}

		
		Thread.sleep(4000);
		
		Thread.sleep(10000);
		
		click("xpath=//*[@id='credit-card-number']");
		sendKeys("xpath=//*[@id='credit-card-number']","5555555555554444");
		Thread.sleep(2000);
		
				
		
		doubleClick("xpath=//*[@id='cvv']");
		sendKeys("xpath=//*[@id='cvv']","555");
		Thread.sleep(2000);
		
		
		
		
		// Month dropdown
		
		// Year Drop down
		
		click("id=submit");
		
		
		//getText("xpath=//div[@class='cart-heading']");
		
		
		
	}
	
	

	
}
	
	

