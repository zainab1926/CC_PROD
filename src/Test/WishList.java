package Test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WishList extends Browser
{
	CommonUtils email = new CommonUtils();
	String name=email.getRandomString(6);
	String wishlist=email.getRandomString(6);
	String newwishlist=email.getRandomString(6);
	String recipient = email.getRandomString(6)+"@test.com";
	String sender = email.getRandomString(6)+"@test.com";
	String sender_name=email.getRandomString(6);
	Report rpt = new Report();
	//Browser br  = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	public void executeAllTest()throws Exception
	{
		    Thread.sleep(6000);
		    click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		    Thread.sleep(6000);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "user@test.com");
			Thread.sleep(6000);
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
			sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "Royalcyber1");
			click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
			Thread.sleep(5000);
			click("xpath=//a[contains(text(),'My Account')]"); //my acc
		//accountSummary();
		accountPage();
		wishList();
		wishListDisplay();
		newWishlist();
		changeWishlist();
		emailWishlist();
		deleteWishlist();
		
		removeProduct();
		addProduct(); 
//		verifyWishlist(); dynamic xpath
	}
	
	public void accountSummary()throws Exception
	{
		String Actual  = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").getText();
		Boolean welcmMsg = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").isDisplayed();
		String Expected="GOOD Morning";
	     if(Actual == Expected)
	                   {
		                
	    	            rpt.createTest("CC-Address Book-Check details", "Message"+Actual+" Displayed For Welcome Message:");
	    	            rpt.Info("Expected Message"+Expected+"Is Matching with "+Actual +"Message For Welcome Message:");
	    	            rpt.Pass("Message"+Expected+" Displayed- For Welcome Message:");
	    	            rpt.Category("CC_Address Book_Check_Details");
	      		        String path = rpt.CaptureScreen(browser, "ValidMessage");
	      		        rpt.imgPathPass(path);
	    	            
	                    }
	                      else
	                    {
		                 
	          	          rpt.createTest("CC-Address Book-Check details", "Message"+Actual+" Displayed- For Welcome Message:");
	          	          rpt.Info("Expected Message"+Expected+ "Not Matching with "+Actual +"Message");
	          	          rpt.Fail("Message"+Expected+" NOT Displayed- For Welcome Message:");  
	          	          rpt.Category("CC_Address Book_Check_Details");
	      		          String path = rpt.CaptureScreen(browser, "InvalidMessage");
	      		          rpt.imgPathFail(path);
	                     }
	     
	     
	}
	
	public void accountPage()throws Exception
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
		         
		         rpt.createTest("CC-WishList-Check Account Section", "Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Category("CC_WishList-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
 
			 }
			 else
			 {
		         rpt.createTest("CC-WishList-Check Account Section", "Message :"+id.getKey()+"is NOT Displayed - For Account Section");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Account Section");
		         rpt.Category("CC_WishList-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }
	}
	
	public void wishList()throws Exception
	{
		
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("Personal Wishlist", "WC_MyAccountSidebarDisplayf_links_4");
		 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
		         
		         rpt.createTest("CC-WishList-Check Account Section", "Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Category("CC_WishList-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);

			 }
			 else
			 {
		         rpt.createTest("CC-WishList-Check Account Section", "Message :"+id.getKey()+"is NOT Displayed - For Account Section");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Account Section");
		         rpt.Category("CC_WishList-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }
	}
	
	public void wishListDisplay()throws Exception
	{
		//click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']"); //personal wishlist
		if(findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify WishList", " Personal WishList Displayed - For Verify WishList");
	        rpt.Pass(" Personal WishList  Displayed - For Verify WishList");	
	        rpt.Category("CC_WishList - Verify WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']"); //personal wishlist

		}
		else
		{
			rpt.createTest("CC - WishList - Verify WishList", " Personal WishList  NOT Displayed - For Verify WishList");
		    rpt.Fail(" Personal WishList  NOT Displayed - For Verify WishList");	
		    rpt.Category("CC_WishList - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	
	public void newWishlist()throws Exception
	{
		//click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']");
		if(findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify WishList", " Personal WishList Displayed - For Verify New WishList");
	        rpt.Pass(" Personal WishList  Displayed - For Verify New WishList");	
	        rpt.Category("CC_WishList - Verify WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_4']"); //personal wishlist

		}
		else
		{
			rpt.createTest("CC - WishList - Verify WishList", " Personal WishList  NOT Displayed - For Verify New WishList");
		    rpt.Fail(" Personal WishList  NOT Displayed - For Verify New  WishList");	
		    rpt.Category("CC_WishList - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=//*[@id='multipleWishlistController_link_create']"); 
		Thread.sleep(5000);
		click("xpath=//*[@id='newListName']");
		//sendKeys("xpath=//*[@id='newListName']","dress"); 
		if(findTheElement("xpath=//*[@id='newListName']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify WishList", " New WishList Displayed - For Verify New WishList");
	        rpt.Pass(" New WishList  Displayed - For Verify New WishList");	
	        rpt.Category("CC_WishList - Verify WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("xpath=//*[@id='newListName']",wishlist);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify WishList", " New WishList NOT Displayed - For Verify New WishList");
		    rpt.Fail(" New WishList  NOT Displayed - For Verify New  WishList");	
		    rpt.Category("CC_WishList - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	        
		}
		
		//click("xpath=//*[@id='editShoppingListPopup_div_edit_save']"); //save
		if(findTheElement("xpath=//*[@id='CreateShoppingListPopup_div_create_save']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify WishList", " Save Button Displayed - For Verify New WishList");
	        rpt.Pass(" Save Button Displayed - For Verify New WishList");	
	        rpt.Category("CC_WishList - Verify WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='CreateShoppingListPopup_div_create_save']"); //save

		}
		else
		{
			rpt.createTest("CC - WishList - Verify WishList", " Save Button NOT Displayed - For Verify New WishList");
		    rpt.Fail(" Save Button NOT Displayed - For Verify New  WishList");	
		    rpt.Category("CC_WishList - Verify WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping"); //continue shopping pop up
	}
	
	public void changeWishlist()throws Exception
	{
		
		//click("xpath=//*[@id='multipleWishlistController_link_edit']");//rename
		if(findTheElement("xpath=//*[@id='multipleWishlistController_link_edit']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Change WishList", " Rename Button Displayed - For Verify Change WishList");
	        rpt.Pass(" Rename Button Displayed - For Verify Change WishList");	
	        rpt.Category("CC_WishList - Verify Change WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='multipleWishlistController_link_edit']");//rename

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Change WishList", " Rename Button NOT Displayed - For Verify Change WishList");
		    rpt.Fail(" Rename Button NOT Displayed - For Verify Change  WishList");	
		    rpt.Category("CC_WishList - Verify Change WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//click("id=editListName");
		Thread.sleep(3000);
		findTheElement("id=editListName").clear();
		//clear("id=editListName");
		//sendKeys("xpath=//*[@id='editListName']","test");
		if(findTheElement("id=editListName").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Change WishList", " WishList Displayed - For Verify Change WishList");
	        rpt.Pass(" WishList Displayed - For Verify Change WishList");	
	        rpt.Category("CC_WishList - Verify Change WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("id=editListName",newwishlist);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Change WishList", " WishList NOT Displayed - For Verify Change WishList");
		    rpt.Fail(" WishList NOT Displayed - For Verify Change WishList");	
		    rpt.Category("CC_WishList - Verify Change WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//click("xpath=//*[@id='editShoppingListPopup_div_edit_save']"); //save
		if(findTheElement("xpath=//*[@id='editShoppingListPopup_div_edit_save']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Change WishList", " Save Button Displayed - For Verify Change WishList");
	        rpt.Pass(" Save Button Displayed - For Verify Change WishList");	
	        rpt.Category("CC_WishList - Verify Change WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='editShoppingListPopup_div_edit_save']"); //save

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Change WishList", " Save Button NOT Displayed - For Verify Change WishList");
		    rpt.Fail(" Save Button NOT Displayed - For Verify Change WishList");	
		    rpt.Category("CC_WishList - Verify Change WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping"); //continue shopping
	}
	
	public void deleteWishlist()throws Exception
	{
		//click("xpath=//*[@id='multipleWishlistController_link_delete']"); //delete
		if(findTheElement("id=delete_popup_link").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Delete WishList", " Delete Button Displayed - For Verify Delete WishList");
	        rpt.Pass(" Delete Button Displayed - For Verify Change WishList");	
	        rpt.Category("CC_WishList - Verify Delete WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("id=delete_popup_link"); //delete

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Delete WishList", " Delete Button NOT Displayed - For Delete Change WishList");
		    rpt.Fail(" Delete Button NOT Displayed - For Verify Delete WishList");	
		    rpt.Category("CC_WishList - Verify Delete WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		//click("xpath=//*[@id='deleteShoppingListPopup_div_delete_yes']");
		if(findTheElement("id=deleteShoppingListPopup_div_delete_yes").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Delete WishList", " Yes Button Displayed - For Verify Delete WishList");
	        rpt.Pass(" Yes Button Displayed - For Verify Change WishList");	
	        rpt.Category("CC_WishList - Verify Delete WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("id=deleteShoppingListPopup_div_delete_yes");

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Delete WishList", " Yes Button NOT Displayed - For Delete Change WishList");
		    rpt.Fail(" Yes Button NOT Displayed - For Verify Delete WishList");	
		    rpt.Category("CC_WishList - Verify Delete WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("xpath=//*[@id='shoppingListCreateSuccessPopup_continue_shopping']/div[2]");
	}
	
	public void removeProduct()throws Exception
	{
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Creative')]"); //product
		//click("xpath=//li[1]/.//div[@class='product_name']");
		click("xpath=//div[@class='product_listing_container']//li[1]/.//div[@class='product_image']");
		Thread.sleep(3000);
		//click("css=img.icon.heartIcon"); //love it
		click("xpath=//div[@id='contentWrapper']//span[contains(text(),'Love It')]");
		Thread.sleep(3000);
		click("id=wishListQuickLink_alt"); //wishlist
		Thread.sleep(2000);
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Audio");//categories
		Thread.sleep(2000);
		//click("xpath=//a[contains(text(),'Creative')]"); //product
		click("xpath=//div[@class='product_listing_container']//li[2]/.//div[@class='product_image']");
		Thread.sleep(3000);
		//click("css=img.icon.heartIcon"); //love it
		click("xpath=//div[@id='contentWrapper']//span[contains(text(),'Love It')]");
		Thread.sleep(3000);
		click("id=wishListQuickLink_alt"); //wishlist
		Thread.sleep(2000);
//		click("xpath=//span[@id='multipleWishlistController_select-button']/span[2]");
//		Thread.sleep(2000);
//		 WebElement monthdd = browser.findElement(By.xpath("//ul[@id='multipleWishlistController_select-menu']/li[9]/div"));
//	       Select select = new Select(monthdd);
//			select.selectByVisibleText("Wish List");
		Thread.sleep(2000);
		
		//click("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616677177_links_14']");
		if(findTheElement("link=Remove").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Remove WishList", " Product is removed from wish list - For Verify Remove WishList");
	        rpt.Pass(" Product is removed from wish list - For Verify Remove WishList");	
	        rpt.Category("CC_WishList - Verify Remove WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("link=Remove");

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Remove WishList", " Product NOT removed from wish list - For Verify Remove WishList");
		    rpt.Fail(" Product NOT removed from wish list - For Verify Remove  WishList");	
		    rpt.Category("CC_WishList - Verify Remove WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("xpath=//*[@id='shoppingListCreateSuccessPopup_continue_shopping']");
	}
	
	public void emailWishlist()throws Exception
	{
		//click("xpath=//*[@id='multipleWishlistController_link_delete']"); //share
		if(findTheElement("xpath=//*[@id='share_popup_link']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Share Button Displayed - For Verify Email WishList");
	        rpt.Pass(" Share Button Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//*[@id='share_popup_link']");

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Share Button NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Share Button NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//*[@id='SendWishListForm_Recipient_Email']");
		//sendKeys("xpath=//*[@id='SendWishListForm_Recipient_Email']","zainab.f@royalcyber.com");
		if(findTheElement("xpath=//*[@id='SendWishListForm_Recipient_Email']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Recipient Email Displayed - For Verify Email WishList");
	        rpt.Pass(" Recipient Email Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("xpath=//*[@id='SendWishListForm_Recipient_Email']",recipient);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Recipient Email NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Recipient Email NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//*[@id='SendWishListForm_Recipient_Name']");
		//sendKeys("xpath=//*[@id='SendWishListForm_Recipient_Name']","Zainab");
		if(findTheElement("xpath=//*[@id='SendWishListForm_Recipient_Email']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Recipient Name Displayed - For Verify Email WishList");
	        rpt.Pass(" Recipient Name Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("xpath=//*[@id='SendWishListForm_Recipient_Name']",name);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Recipient Name NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Recipient Name NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//*[@id='SendWishListForm_Sender_Email']");
		//sendKeys("xpath=//*[@id='SendWishListForm_Sender_Email']","zfirdaus95@gmail.com");
		if(findTheElement("xpath=//*[@id='SendWishListForm_Sender_Email']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Sender Email Displayed - For Verify Email WishList");
	        rpt.Pass(" Sender Email Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("xpath=//*[@id='SendWishListForm_Sender_Email']",sender);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Sender Email NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Sender Email NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//*[@id='SendWishListForm_Sender_Name']");
		//sendKeys("xpath=//*[@id='SendWishListForm_Sender_Name']","Firdaus");
		if(findTheElement("xpath=//*[@id='SendWishListForm_Sender_Name']").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Sender Name Displayed - For Verify Email WishList");
	        rpt.Pass(" Sender Name Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		sendKeys("xpath=//*[@id='SendWishListForm_Sender_Name']",name);

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Sender Name NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Sender Name NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		//click("xpath=//*[@id='WC_WishListDisplay_links_1']/div[2]");
		if(findTheElement("id=WC_WishListDisplay_links_1").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Email WishList", " Save Button Displayed - For Verify Email WishList");
	        rpt.Pass(" Save Button Displayed - For Verify Email WishList");	
	        rpt.Category("CC_WishList - Verify Email WishList");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("id=WC_WishListDisplay_links_1");

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Email WishList", " Save Button NOT Displayed - For Verify Email WishList");
		    rpt.Fail(" Save Button NOT Displayed - For Verify Email  WishList");	
		    rpt.Category("CC_WishList - Verify Email WishList");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		click("xpath=//*[@id='shoppingListCreateSuccessPopup_continue_shopping']/div[2]"); //continue shopping
		//for signin out
		 Thread.sleep(2000);
//		   click("id=myAccountQuickLink");
//		   Thread.sleep(2000);
//		   click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	}
	
	public void addProduct()throws Exception
	{
		//click("xpath=//*[@id='shoppingListCreateSuccessPopup_continue_shopping']/div[2]"); //continue shopping
		//click("xpath=//*[@id='listViewAdd2Cart_3074457345616727849']"); //buy now
		if(findTheElement("xpath=//div[@class='productListingWidget wishlist']//a[contains(text(),'BUY NOW')]").isDisplayed())
		{		
		    rpt.createTest("CC - WishList - Verify Add Product", " Product is added to cart from wish list - For Verify Add Product");
	        rpt.Pass(" Product is added to cart from wish list - For Verify Add Product");	
	        rpt.Category("CC_WishList - Verify Add Product");
           String path = rpt.CaptureScreen(browser, "ValidMessage");
            rpt.imgPathPass(path);
    		click("xpath=//div[@class='productListingWidget wishlist']//a[contains(text(),'BUY NOW')]"); //buy now

		}
		else
		{
			rpt.createTest("CC - WishList - Verify Add Product", " Product NOT added to cart from wish list - For Verify Add Product");
		    rpt.Fail(" Product NOT added to cart from wish list - For Verify Add Product");	
		    rpt.Category("CC_WishList - Verify Add Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
		click("id=GotoCartButton2"); //view cart
		Thread.sleep(3000);
		click("id=MiniShopCartCloseButton_2");
		Thread.sleep(2000);
		click("id=wishListQuickLink_alt"); //wishlist
		Thread.sleep(2000);
		//click("css=img.icon.heartIconFilled");
		//click("css=div.love_it_drop");
		click("link=Remove");
		Thread.sleep(2000);
		click("id=shoppingListCreateSuccessPopup_continue_shopping");
		Thread.sleep(2000);
		 click("id=Header_GlobalLogin_signOutQuickLink");
		   Thread.sleep(2000);
		   click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	}
	
	public void verifyWishlist()throws Exception
	{
		 Map<String,String> fields= new HashMap<String,String>();
	   	  fields.put("Product Name", "/html/body/div[2]/div[2]/div[2]/div[1]/div/div[1]/label");
	   	  fields.put("Product Price", "//*[@id='logo']");
	   	  fields.put("Ratings", "//*[@id='searchBar']");
	   	 
	   		
	   		 for(Map.Entry<String, String> field : fields.entrySet() )
	   		 {
	   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
	   			 {
	   				 rpt.createTest("CIRCUIT CITY - Verify Wishlist", "Product Details :"+field.getKey()+" Displayed ");
	   		         rpt.Pass("Product Details :"+field.getKey()+" Displayed ");
	   		         rpt.Category("CIRCUIT CITY - Verify Wishlistt");
	   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
	   		         rpt.imgPathPass(path);
	   			 }
	   			 else
	   			 {
	   				 rpt.createTest("CIRCUIT CITY - Verify Wishlist", "Product Details :"+field.getKey()+" NOT Displayed");
	   		         rpt.Fail("Product Details :"+field.getKey()+" NOT Displayed");
	   		         rpt.Category("CIRCUIT CITY - Verify Wishlist");
	   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	   		         rpt.imgPathFail(path);
	   			 }
	   		 } 
	}
	
}
