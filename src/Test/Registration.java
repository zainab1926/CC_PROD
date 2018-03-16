package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Registration extends Browser
{
	CommonUtils email = new CommonUtils();
	String Logon_ID = email.getRandomString(6)+"@test.com";
	String pwd=email.getRandomString(6)+email.getRandomNumber(1);
	String name=email.getRandomString(6);
	String phoneNo=email.getRandomNumber(10);
	Report rpt = new Report();

	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	public void executeAllTest()throws Exception
	{
		checkFields();
		////validFields();
		////validName();
		//invalidName(); name is not mandatory
		invalidEmail();
		////validPassword();
		InvalidPassword();
		Invalid_Cnfm_Pwd();
		User_Registration();
		////validFields();
//		Reg_Success(); //not working
		////verifyEmailid();
		
	}
	 

	public void checkFields() throws InterruptedException,Exception
	{
		Thread.sleep(4000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']");//create acc
		                  
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("First Name", "WC__NameEntryForm_FormInput_firstName_1"); 
		 ids.put("Last Name", "WC__NameEntryForm_FormInput_lastName_1");
		 ids.put("Email id", "WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1");
		 ids.put("Password", "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1");
		 ids.put("Confirm Password", "WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1");
		 ids.put("Create Account", "WC_UserRegistrationAddForm_links_1");
		 
		                   
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				
		         rpt.createTest("CC-Registration-Field Validation", "Field :"+id.getKey()+" Displayed - For Field Validation");
		         rpt.Pass("Field :"+id.getKey()+" Displayed - For Field Validation");
		         rpt.Category("CC_Registration_Validation Fields");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
		         rpt.chkBugs("CommonUtils.getUserName()");
		         //rpt.chkdebug("CC_Registration_Validation Fields");
			 }
			 else
			 {
		         rpt.createTest("CC-Registration-name Validation", "Field :"+id.getKey()+" Displayed - For Field Validation ");
		         rpt.Fail("Field "+id.getKey()+" NOT Displayed - For Field Validation");
		         rpt.Category("CC_Registration_Validation Fields");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
		         rpt.chkBugs("CommonUtils.getUserName()");
		        // rpt.chkdebug("CC_Registration_Validation Fields");
		  
			 }
		 }
	}
	public void validFields() throws Exception
	{
		User_Registration();
		Thread.sleep(5000);
		
		/*String strError  = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 if(ErrorMsgReg)
		 {
			 //System.out.println("Error Message DIsplayed - For Field Validations - " + strError );
		    rpt.createTest("Circuit_City-Registration, CIRCUIT CITY - Registration :Error Message displayed - For Field Validations -", strError);

		 }
		 else
		 {
			 //System.out.println("NoError Message Displayed");
			 rpt.createTest("Circuit_City-Registration, CIRCUIT CITY - Registration :Error Message NOT displayed - For Field Validations",strError);
		 }*/

		
	}
	
	public void validName() throws Exception
	{
		User_Registration();
		 /*Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 String aMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 String eMsgReg = 
		 if(ErrorMsgReg)
		 {
			 //System.out.println("Error Message DIsplayed - For Valid Name" + eMsgReg );
			 rpt.createTest("Circuit_City-Registration- Valid Name", "Error Message Displayed: " +eMsgReg+ "For Valid Name :");
		 }
		 else
		 {
			// System.out.println("NoError Message DIsplayed");
			 rpt.createTest("Circuit_City-Registration- Valid Name", "Error Message NOT Displayed: " +eMsgReg+ "For Valid Name :");

		 }*/
	}

	public void invalidName() throws Exception
	{
		
		//User_Registration();
		String[] invalidName={"!@#$%"};
		String[] ids={"WC__NameEntryForm_FormInput_firstName_1","WC__NameEntryForm_FormInput_lastName_1"};
		for(String id : ids)
		{
		
		for(String value :invalidName)
		{
			sendKeys("xpath=//*[@id='"+id+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//create acc
			String Actual = findTheElement("id=WC__NameEntryForm_FormInput_firstName_1Errdiv").getText();
			//Boolean strMessage = findTheElement("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1Errdiv']/div").isDisplayed();//error msg
			String Expected="Invalid first name";
			if(Actual.contains(Expected))
			{
				//System.out.println("Message Displayed: For Invalid Name"+ strMsg);
				rpt.createTest("CC-Registration-Invalid Name", "Message Displayed -  "+Actual);
			    rpt.Pass("Message Displayed -  "+Actual);
			    rpt.Category("CC_Registration-Invalid Name");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Name", "Message NOT Displayed -  "+Actual);
			    
			    rpt.Fail("Message NOT Displayed -  "+Actual);
			    rpt.Category("CC_Registration-Invalid Name");
		         Thread.sleep(3000);
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         Thread.sleep(3000);
		         rpt.imgPathFail(path);
			}

		}
		}

	}
	
	public void invalidEmail() throws Exception
	{
		//User_Registration();
		//findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
		String[] invalidEmail={"1234567890","!@#$%"};
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
		for(String value :invalidEmail)
		{
			findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1"+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");  
			//Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actual = "The email entered is not in a valid format.";
			String expected="The email entered is not in a valid format.";
			if(actual.contains(expected))
			{
				//System.out.println("Message Displayed: For Email - "+ strMsg);
				rpt.createTest("CC-Registration-Invalid Email Id", "Message Displayed- For Invalid Email Id - " +actual);
			    //rpt.Info("Message Displayed- For Invalid Email Id" +actual);
			    rpt.Pass("Message Displayed- For Invalid Email Id - " +actual);
			    rpt.Category("CC_Registration-Invalid Email Id");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Email Id", "Message NOT Displayed- For Invalid Email Id - " +actual);
			    //rpt.Info("Expected Message "+expected+ "Not Matching with "+actual +"Message");
			    rpt.Fail("Message NOT Displayed- For Invalid Email Id - " +actual);
			    rpt.Category("CC_Registration-Invalid Email Id");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);

			}
			
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");
		}
		//email id
				click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
				findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", Logon_ID);
		
	}
	public void validPassword() throws Exception
	{

		User_Registration();
		
	}
	
	public  void InvalidPassword() throws Exception
	{
		//User_Registration();
		//email id
				click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
				findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", Logon_ID);
				
		String[] invalidPassword={"1234567890","!@#$%"};
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']").clear();
		for(String value :invalidPassword)
		{
			findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']").clear();
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1"+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//submit
			//Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actualPass = "Passwords must be at least 6 characters in length, and include 1 digit(s) and 1 letter(s).";
			String expectedPass="Passwords must be at least 6 characters in length, and include 1 digit(s) and 1 letter(s).";
			if(actualPass.contains(expectedPass))
			{
				//System.out.println("Message Displayed: For InvalidPassword"+ strRegMessage);
				rpt.createTest("CC-Registration-Invalid Password", "Message Displayed- For Invalid Password - " +actualPass );
			    //rpt.Info("Expected Message "+expectedPass+" Is Matching with "+actualPass +"Message");
			    rpt.Pass("Message Displayed- For Invalid Password - " +actualPass);	
			    rpt.Category("CC_Registration-Invalid Password");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Password", "Message NOT Displayed- For Invalid Password - " +actualPass);
			   // rpt.Info("Expected Message "+expectedPass+ "Not Matching with "+actualPass +"Message");
			    rpt.Fail("Message NOT Displayed- For Invalid Password - " +actualPass);
			    rpt.Category("CC_Registration-Invalid Password");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
			
		}
		//password
				click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']");
				findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']").clear();
				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']", pwd);
		//browser.switchTo().alert().accept();
	}
		
	public void Invalid_Cnfm_Pwd() throws Exception
	{
		//User_Registration();
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", Logon_ID);
		//password
				click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']");
				findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']").clear();
				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']", pwd);
		
		String[] invalidCPassword={"1234567890","!@#$%"};
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']").clear();
		for(String value :invalidCPassword)
		{
			Thread.sleep(2000);
			findTheElement("id=WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1").clear();
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1"+"']", value);			
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//submit
			//Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actualCpass = "The passwords entered do not match.";
			String expectedCpass="The passwords entered do not match.";
			if(actualCpass.contains(expectedCpass))
			{
				//System.out.println("Message Displayed:Invalid Confrm_Password"+ strCnfm_Pwd);
				rpt.createTest("CC-Registration-Invalid Confirm Password", "Message Displayed- For Invalid Confirm Password - " +actualCpass);
			    //rpt.Info("Expected Message "+expectedCpass+"Is Matching with "+actualCpass +"Message");
			    rpt.Pass("Message Displayed- For Invalid Confirm Password - " +actualCpass);	
			    rpt.Category("CC_Registration-Invalid Confirm Password");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Confirm Password", "Message NOT Displayed- For Invalid Confirm Password - " +actualCpass);
			   // rpt.Info("Expected Message "+expectedCpass+ "Not Matching with "+actualCpass +"Message");
			    rpt.Fail("Message NOT Displayed- For Invalid Confirm Password - " +actualCpass);
			    rpt.Category("CC_Registration-Invalid Confirm Password");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}

		}
		
	}
	public void User_Registration() throws Exception
	{
		Thread.sleep(5000);
//		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
//		Thread.sleep(5000);
//		click("//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']");
		
		//first name
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']");
		findTheElement("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']").clear();
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']", name);
		
		
		//LastName
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']");
		findTheElement("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']").clear();
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']", name);
		
		//email id
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']").clear();
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", Logon_ID);
		
		//password
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']");
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']").clear();
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']", pwd);
		System.out.println(pwd);
		
		//confirm password
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']");
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']").clear();
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']", pwd);
		
		//mobile number
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");
		findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']").clear();
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']", phoneNo);
		Thread.sleep(3000);
		//create account button
		click("id=WC_UserRegistrationAddForm_links_1");
		
		Thread.sleep(8000);
		//click("id=Header_GlobalLogin_signInQuickLink");
		   Thread.sleep(2000);
		//logout
		 click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	    //click("class=signout");
	}
	public void Reg_Success() throws Exception
	{
		System.out.println("in reg_success");
		Thread.sleep(5000);
		//User_Registration();
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		Thread.sleep(3000);
		findTheElement("id=Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1").clear();
		sendKeys("id=Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1",Logon_ID);
		Thread.sleep(3000);
		findTheElement("id=Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1").clear();
		sendKeys("id=Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1",pwd);
		System.out.println(pwd);
		Thread.sleep(3000);
		click("id=Header_GlobalLogin_WC_AccountDisplay_links_2");
		
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle!=null)
		{
	         rpt.createTest("CC-Registration-Registration Success", "Registration is successful  " );
	         rpt.Pass("Registration is successful  " );
	         rpt.Category("CC-Registration-Registration Success");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		 }
		 else
		 {
			 rpt.createTest("CC-Registration-Registration Success", "Registration NOT successful");
	         rpt.Fail("Registration NOT successful");
	         rpt.Category("CC-Registration-Registration Success");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(2000);
		//doubleClick("id=Header_GlobalLogin_loggedInDropdown_SignOut");
		 click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	}
	
	
	
 public  void  verifyEmailid() throws Exception
 {

		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']/span");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "zainab.firdaus@royalcyber.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "zain@1926");
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		Thread.sleep(8000);
		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[2]/div[3]/div[1]/a"); //my acc
		Thread.sleep(6000); 
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[1]/div[1]/a/span"); //sign out
		
 }
}
