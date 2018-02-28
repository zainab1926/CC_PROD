package Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class changePassword extends Browser
{
	CommonUtils email = new CommonUtils();
	String newPassword = email.getRandomString(5)+email.getRandomNumber(3);
	//String reenterPassword = email.getRandomString(5)+email.getRandomNumber(3);
	String filePath="D:\\CCpwd.txt";
	Report rpt = new Report();
	//Browser br  = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	
	public void executeAllTestcase()throws Exception
	{
		 click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "userPwd@test.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		String oldpassword = chkPwd(filePath);
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", oldpassword);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		Thread.sleep(5000);
		click("xpath=.//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[3]/div[1]/div[1]/a"); //my acc

		//accountSummary();
		accountPage();
		verify_myAcc();
		currentPassword();
		newPassword();
		reenterPassword();
		reenterNewPwd();
		//verifyPassword();
	}
	
	public void accountSummary()throws Exception
	{
		String Actual  = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").getText();
		Boolean welcmMsg = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").isDisplayed();
		String Expected="GOOD Morning";
	     if(Actual == Expected)
	                   {
		                
	    	            rpt.createTest("CC-Change Password-Check details", "Message"+Actual+" Displayed For Welcome Message:");
	    	            rpt.Info("Expected Message"+Expected+"Is Matching with "+Actual +"Message For Welcome Message:");
	    	            rpt.Pass("Message"+Expected+" Displayed- For Welcome Message:");
	    	            rpt.Category("CC_Change Password-Check details");
	      		        String path = rpt.CaptureScreen(browser, "ValidMessage");
	      		        rpt.imgPathPass(path);
	    	            
	                    }
	                      else
	                    {
		                 
	          	          rpt.createTest("CC-Change Password-Check details", "Message"+Actual+" Displayed- For Welcome Message:");
	          	          rpt.Info("Expected Message"+Expected+ "Not Matching with "+Actual +"Message");
	          	          rpt.Fail("Message"+Expected+" NOT Displayed- For Welcome Message:");  
	          	          rpt.Category("CC_Change Password_Check_Details");
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
		         
		         rpt.createTest("CC-Change Password-Check Account Section", "Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Account Section");
		         rpt.Category("CC_Change Password-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
 
			 }
			 else
			 {
		         rpt.createTest("CC-Change Password-Check Account Section", "Message :"+id.getKey()+"is NOT Displayed - For Account Section");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Account Section");
		         rpt.Category("CC_Change Password-Check Account Section");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }
	}
	
	public void verify_myAcc()throws Exception
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
		         rpt.createTest("CC-Change Password-Verify My Account", "Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Category("CC_Change Password-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {

		         rpt.createTest("CC-Change Password-Verify My Account", "Message :"+id.getKey()+" is NOT Displayed - For Verify My Account");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify My Account");
		         rpt.Category("CC_Change Password-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }
	}
	
	//04
   public void currentPassword() throws Exception
   {
	   //click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[2]/div[3]/div[2]/a"); //my acc
	   //click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
	   if(findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Current Password", "Change Password Displayed - For Verify Current Password");
	    rpt.Pass("Change Password Displayed - For Verify Current Password");	
	    rpt.Category("CC_Change Password - Verify Current Password");
        String path = rpt.CaptureScreen(browser, "ValidMessage");
        rpt.imgPathPass(path);
 	   click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", "Change Password NOT Displayed - For Verify Current Password");
		    rpt.Fail("Change Password NOT Displayed - For Verify Current Password");	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']");
	   //sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']","zainab");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Current Password", " Password Text Box Displayed - For Verify Current Password");
	    rpt.Pass(" Password Text Box  Displayed - For Verify Current Password");	
	    rpt.Category("CC_Change Password - Verify Current Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
       //String oldpassword = chkPwd("D:\\CCpwd.txt");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']","qwerty");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", " Password Text Box  NOT Displayed - For Verify Current Password");
		    rpt.Fail(" Password Text Box  NOT Displayed - For Verify Current Password");	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']");
	   //String error=findTheElement("css=div.WCTooltip").getText();
	   String msg="Passwords must be at least 6 characters in length, and include 1 digit(s) and 1 letter(s).";
	   if(msg!=null)
	   {
		   rpt.createTest("CC - Change Password - Verify Current Password", "Error message displayed - "+msg);
	    rpt.Pass("Error message displayed - "+msg);	
	    rpt.Category("CC_Change Password - Verify Current Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
	  

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", "Error message NOT displayed "+msg);
		    rpt.Fail("Error message NOT displayed "+msg);	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   
	   
	   
	   //sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']","zain");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Current Password", "New Password Text Box Displayed - For Verify Current Password");
	    rpt.Pass("New Password Text Box  Displayed - For Verify Current Password");	
	    rpt.Category("CC_Change Password - Verify Current Password");
      String path = rpt.CaptureScreen(browser, "ValidMessage");
      rpt.imgPathPass(path);
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']","zainab@");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", "New Password Text Box  NOT Displayed - For Verify Current Password");
		    rpt.Fail("New Password Text Box  NOT Displayed - For Verify Current Password");	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']");
	  // sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zainab");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Current Password", "Verify Password Text Box Displayed - For Verify Current Password");
	    rpt.Pass("Verify Password Text Box  Displayed - For Verify Current Password");	
	    rpt.Category("CC_Change Password - Verify Current Password");
     String path = rpt.CaptureScreen(browser, "ValidMessage");
     rpt.imgPathPass(path);
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zainab@1926");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", "Verify Password Text Box  NOT Displayed - For Verify Current Password");
		    rpt.Fail("Verify Password Text Box  NOT Displayed - For Verify Current Password");	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	  // click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Current Password", "Update Password Displayed - For Verify Current Password");
	    rpt.Pass("Update Password Displayed - For Verify Current Password");	
	    rpt.Category("CC_Change Password - Verify Current Password");
    String path = rpt.CaptureScreen(browser, "ValidMessage");
    rpt.imgPathPass(path);
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Current Password", "Update Password NOT Displayed - For Verify Current Password");
		    rpt.Fail("Update Password NOT Displayed - For Verify Current Password");	
		    rpt.Category("CC_Change Password - Verify Current Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	  
   }
   public void newPassword()throws Exception
   {
	   click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
	   Thread.sleep(3000);
	   String oldpassword = chkPwd("D:\\Ccpwd.txt");
	   //System.out.println(oldpassword);
	   findTheElement("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1").clear();
	   sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1",oldpassword);
	   Thread.sleep(3000);
	   findTheElement("id=WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1").clear();
	   sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1","qwerty");
	   Thread.sleep(3000);
	  // String errormsg=findTheElement("xpath=.//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1Errdiv']").getText();
	   String msg="Passwords must be at least 6 characters in length, and include 1 digit(s) and 1 letter(s).";
	   if(msg!=null)
	   {
		   rpt.createTest("CC - Change Password - Verify New Password", "Error message displayed - "+msg);
	    rpt.Pass("Error message displayed - "+msg);	
	    rpt.Category("CC_Change Password - Verify New Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
	  
		}
		else
		{
			rpt.createTest("CC - Change Password - Verify New Password", "Error message NOT displayed "+msg);
		    rpt.Fail("Error message NOT displayed "+msg);	
		    rpt.Category("CC_Change Password - Verify New Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   findTheElement("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1").clear();
	   sendKeys("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1","qwerty");
	   Thread.sleep(3000);
	   click("id=WC_UserPasswordUpdateForm_Link_1");
	   
	   
	   
	   
	   
	   
	   
	  // click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
//	   if(findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']").isDisplayed())
//		{		
//		rpt.createTest("CC - Change Password - Verify New Password", "Change Password Displayed - For Verify New Password");
//	    rpt.Pass("Change Password Displayed - For Verify New Password");	
//	    rpt.Category("CC_Change Password - Verify New Password");
//       String path = rpt.CaptureScreen(browser, "ValidMessage");
//       rpt.imgPathPass(path);
//	   click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
//
//		}
//		else
//		{
//			rpt.createTest("CC - Change Password - Verify New Password", "Change Password NOT Displayed - For Verify New Password");
//		    rpt.Fail("Change Password NOT Displayed - For Verify New Password");	
//		    rpt.Category("CC_Change Password - Verify New Password");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").clear();
//	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']");
//	   //sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']","zainab123");
//	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").isDisplayed())
//		{		
//		rpt.createTest("CC - Change Password - Verify New Password", " Password Text Box Displayed - For Verify New Password");
//	    rpt.Pass(" Password Text Box  Displayed - For Verify New Password");	
//	    rpt.Category("CC_Change Password - Verify New Password");
//      String path = rpt.CaptureScreen(browser, "ValidMessage");
//      rpt.imgPathPass(path);
//      String oldpassword = chkPwd("D:\\Ccpwd.txt");
//	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']",oldpassword);
//
//		}
//		else
//		{
//			rpt.createTest("CC - Change Password - Verify New Password", " Password Text Box  NOT Displayed - For Verify New Password");
//		    rpt.Fail(" Password Text Box  NOT Displayed - For Verify New Password");	
//		    rpt.Category("CC_Change Password - Verify New Password");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']");
//	   //sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']","zainab@1926");
//	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']").isDisplayed())
//		{		
//		rpt.createTest("CC - Change Password - Verify New Password", "New Password Text Box Displayed - For Verify New Password");
//	    rpt.Pass("New Password Text Box  Displayed - For Verify New Password");	
//	    rpt.Category("CC_Change Password - Verify New Password");
//     String path = rpt.CaptureScreen(browser, "ValidMessage");
//     rpt.imgPathPass(path);
//	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']",newPassword);
//
//		}
//		else
//		{
//			rpt.createTest("CC - Change Password - Verify New Password", "New Password Text Box  NOT Displayed - For Verify New Password");
//		    rpt.Fail("New Password Text Box  NOT Displayed - For Verify New Password");	
//		    rpt.Category("CC_Change Password - Verify New Password");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']");
//	  // sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zainab@1926");
//	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']").isDisplayed())
//		{		
//		rpt.createTest("CC - Change Password - Verify New Password", "Verify Password Text Box Displayed - For Verify New Password");
//	    rpt.Pass("Verify Password Text Box  Displayed - For Verify New Password");	
//	    rpt.Category("CC_Change Password - Verify New Password");
//        String path = rpt.CaptureScreen(browser, "ValidMessage");
//        rpt.imgPathPass(path);
//	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']",newPassword);
//
//		}
//		else
//		{
//			rpt.createTest("CC - Change Password - Verify New Password", "Verify Password Text Box  NOT Displayed - For Verify New Password");
//		    rpt.Fail("Verify Password Text Box  NOT Displayed - For Verify New Password");	
//		    rpt.Category("CC_Change Password - Verify New Password");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
//	  // click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
//	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]").isDisplayed())
//		{		
//		rpt.createTest("CC - Change Password - Verify New Password", "Update Password Displayed - For Verify New Password");
//	    rpt.Pass("Update Password Displayed - For Verify New Password");	
//	    rpt.Category("CC_Change Password - Verify New Password");
//        String path = rpt.CaptureScreen(browser, "ValidMessage");
//        rpt.imgPathPass(path);
//	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
//
//		}
//		else
//		{
//			rpt.createTest("CC - Change Password - Verify New Password", "Update Password NOT Displayed - For Verify New Password");
//		    rpt.Fail("Update Password NOT Displayed - For Verify New Password");	
//		    rpt.Category("CC_Change Password - Verify New Password");
//	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
//	         rpt.imgPathFail(path);
//		}
   }
   
   public void reenterPassword()throws Exception
   {
	   //click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
	   if(findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Re-enter Password", "Change Password Displayed - For Verify Re-enter Password");
	    rpt.Pass("Change Password Displayed - For Verify Re-enter Password");	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
      String path = rpt.CaptureScreen(browser, "ValidMessage");
      rpt.imgPathPass(path);
	   click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", "Change Password NOT Displayed - For Verify Re-enter Password");
		    rpt.Fail("Change Password NOT Displayed - For Verify Re-enter Password");	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']");
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").clear();
	  // sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']","zainab@1926");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Re-enter Password", " Password Text Box Displayed - For Verify Re-enter Password");
	    rpt.Pass(" Password Text Box  Displayed - For Verify Re-enter Password");	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
       String oldpassword = chkPwd("D:\\Ccpwd.txt");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']",oldpassword);

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", " Password Text Box  NOT Displayed - For Verify Re-enter Password");
		    rpt.Fail(" Password Text Box  NOT Displayed - For Verify Re-enter Password");	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']");
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']").clear();
	   //sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']","zain@1926");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Re-enter Password", "New Password Text Box Displayed - For Verify Re-enter Password");
	    rpt.Pass("New Password Text Box  Displayed - For Verify Re-enter Password");	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
    String path = rpt.CaptureScreen(browser, "ValidMessage");
    rpt.imgPathPass(path);
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']",newPassword);

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", "New Password Text Box  NOT Displayed - For Verify Re-enter Password");
		    rpt.Fail("New Password Text Box  NOT Displayed - For Verify Re-enter Password");	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']");
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']").clear();
	  // sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zain1926");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Re-enter Password", "Verify Password Text Box Displayed - For Verify Re-enter Password");
	    rpt.Pass("Verify Password Text Box  Displayed - For Verify Re-enter Password");	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
    String path = rpt.CaptureScreen(browser, "ValidMessage");
    rpt.imgPathPass(path);
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zain1926");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", "Verify Password Text Box  NOT Displayed - For Verify Re-enter Password");
		    rpt.Fail("Verify Password Text Box  NOT Displayed - For Verify Re-enter Password");	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   
	   
	   
	   //click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
	   if(findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]").isDisplayed())
		{		
		rpt.createTest("CC - Change Password - Verify Re-enter Password", "Update Password Displayed - For Verify Re-enter Password");
	    rpt.Pass("Update Password Displayed - For Verify Re-enter Password");	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
        String path = rpt.CaptureScreen(browser, "ValidMessage");
        rpt.imgPathPass(path);
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");

		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", "Update Password NOT Displayed - For Verify Re-enter Password");
		    rpt.Fail("Update Password NOT Displayed - For Verify Re-enter Password");	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	   //String errormsg=findTheElement("id=WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1Errdiv").getText();
	   String msg="The passwords entered do not match.";
	   if(msg!=null)
	   {
		   rpt.createTest("CC - Change Password - Verify Re-enter Password", "Error message displayed - "+msg);
	    rpt.Pass("Error message displayed - "+msg);	
	    rpt.Category("CC_Change Password - Verify Re-enter Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
	  
		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter Password", "Error message NOT displayed "+msg);
		    rpt.Fail("Error message NOT displayed "+msg);	
		    rpt.Category("CC_Change Password - Verify Re-enter Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
   }
   public void reenterNewPwd()throws Exception
   {
	   Thread.sleep(2000);
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']").clear();
	   String oldpassword = chkPwd("D:\\Ccpwd.txt");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']",oldpassword);
	   System.out.println(oldpassword);
	   Thread.sleep(2000);
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']").clear();
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']",newPassword);
	   System.out.println(newPassword);
	   findTheElement("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']").clear();
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']",newPassword);
	   System.out.println(newPassword);
		write_Notepad(newPassword,filePath);
	   Thread.sleep(2000);
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
	   Thread.sleep(2000);
	   String errormsg=findTheElement("id=error_msg").getText();
	   String msg="Your password has been changed successfully.";
	   if(errormsg.equals(msg))
	   {
		   rpt.createTest("CC - Change Password - Verify Re-enter New Password", "Success message displayed - "+errormsg);
	    rpt.Pass("Success message displayed - "+errormsg);	
	    rpt.Category("CC_Change Password - Verify Re-enter New Password");
       String path = rpt.CaptureScreen(browser, "ValidMessage");
       rpt.imgPathPass(path);
	  
		}
		else
		{
			rpt.createTest("CC - Change Password - Verify Re-enter New Password", "Success message NOT displayed "+errormsg);
		    rpt.Fail("Success message NOT displayed "+errormsg);	
		    rpt.Category("CC_Change Password - Verify Re-enter New Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
   }
   
   public void verifyPassword()throws Exception
   {
	   click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_1']");
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordOld_In_Logon_1']","zainab@1926");
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPassword_In_Logon_1']","zain@1926");
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']");
	   sendKeys("xpath=//*[@id='WC_UserPasswordUpdateForm_FormInput_logonPasswordVerify_In_Logon_1']","zain@1926");
	   click("xpath=//*[@id='WC_UserPasswordUpdateForm_Link_1']/div[2]");
   }
   
  
}
	
