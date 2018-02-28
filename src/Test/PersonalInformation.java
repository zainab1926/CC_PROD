package Test;

import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.KeyEvent;	

import javax.swing.ImageIcon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

//import com.sun.jna.platform.unix.X11.Screen;

public class PersonalInformation extends Browser
{
	
	//maing a change for testing JEnkins
	//public WebDriver browser = BrowserFactory.getBrowser("Browser","url");
    Report rpt  = new Report();
	
	
	/*public void first(String browserName)throws Exception
	{
		/*browser = BrowserFactory.getBrowser(browserName);
		browser.get("http://cct-live.qa.coc.ibmcloud.com/webapp/wcs/stores/servlet/en/circuitcityb2c");*/
		
		/*chkLogin("zzz@gmail.com","zainab123");
		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a"); //my acc
	}*/
	
	/*public void chkLogin(String Username,String Password)throws Exception
	{
		//Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']/span");
		//Thread.sleep(4000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", Username);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", Password);
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a"); //my acc
			
	}*/
	
	public void executeAllTestcase()throws Exception
	{
		Thread.sleep(6000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(6000);

		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "user@test.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "Royalcyber1");
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		Thread.sleep(5000);
		click("xpath=//a[contains(text(),'My Account')]");
		verify_myAcc();
		//verify_edit(); functionality not there
		verify_displayedInfo();
		fieldValidation();
		verify_MyAcc();
		verifySettings();
		//verify_details();
		//mandatoryFields();
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
		 Thread.sleep(10000);
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {  
			 Thread.sleep(12000);
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				 //System.out.println(id.getKey() + " is displayed ");
		         
		         rpt.createTest("CC-Personal Information-Verify My Account", "Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Category("CC_Personal Information-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 //System.out.println(id.getKey() + " is not displayed ");

		         rpt.createTest("CC-Personal Information-Verify My Account", "Message :"+id.getKey()+" is NOT Displayed - For Verify My Account");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify My Account");
		         rpt.Category("CC_Personal Information-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }
		 
		/* Map<String,String> pid=new HashMap<String,String>();
		 pid.put("Welcome message", "container_MyAccountDisplayB2B");
		 pid.put("personalInfo", "WC_MyAccountCenterLinkDisplay_inputs_1");
		 pid.put("personal_infoEdit", "WC_MyAccountCenterLinkDisplay_inputs_1");
		 pid.put("recentOrder", "container_MyAccountDisplayB2B");
		 pid.put("viewOrder", "Processed_View_All_Orders");
		 pid.put("recurringOrder", "container_MyAccountDisplayB2B");
		 pid.put("viewRecurring", "Recurring_View_All_Orders");
		 
		 for(Map.Entry<String, String> id : pid.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				 System.out.println(id.getKey() + " is displayed ");
				 //test = extent.createTest("CIRCUIT CITY- Personal Information :"+id.getKey()+ " is displayed ");

			 }
			 else
			 {
				 System.out.println(id.getKey() + " is not displayed ");
				 //test = extent.createTest("CIRCUIT CITY- Personal Information :"+id.getKey()+ " is NOT displayed ");

			 }
		 }*/
	}
	
	/*public void verify_edit()throws Exception
	{
		click("xpath=//*[@id='WC_MyAccountCenterLinkDisplay_inputs_1']");
		

	     Boolean personal_infoPage = findTheElement("xpath=//*[@id='WC_RegistrationUpdateCommonPage_div_1']").isDisplayed();
	     if(personal_infoPage)
	     {
	      System.out.println(" Message Displayed:"+ personal_infoPage);
		  //  test = extent.createTest("CIRCUIT CITY - Personal Information :Error Message Displayed for Personal Information page:", personal_infoPage);

	      }
	        else
	     {
	     System.out.println("Message NOT Displayed");
		 //test = extent.createTest("CIRCUIT CITY - Personal Information :Error Message NOT Displayed for Personal Information page");
  	
	     }
	}*/
	
	public void verify_displayedInfo()throws Exception
	{
		Thread.sleep(5000);
		click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_0']");
		 Map<String,String> ids= new HashMap<String,String>();
		 ids.put("First Name", "WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1");
		 ids.put("Last Name", "WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1");
		 ids.put("Street Address", "WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1");
		 ids.put("City", "WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1");
		 ids.put("Country/Region", "WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_country_1-button");
		 ids.put("State/Province", "WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1");
		 ids.put("Zip code/Postal code", "WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1");
		 ids.put("Email", "WC_UserRegistrationAddForm_FormInput_email1_In_Register_1");
		 ids.put("Send me emails about store specials", "WC_UserRegistrationAddForm_EmailOption_Checkbox_1_Img");
		 ids.put("Phone no", "WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1");
		 ids.put("Preferred language", "WC_UserRegistrationAddForm_FormInput__preferredLanguage_In_Register_1-button");
		 ids.put("Preferred currency", "WC_UserRegistrationAddForm_FormInput__preferredCurrency_In_Register_1-button");
		 ids.put("Gender", "WC_UserRegistrationAddForm_FormInput_gender_In_Register_1-button");
		 ids.put("Birthday_year", "WC_PersonalInfoExtension_birth_year-button");
		 ids.put("Birthday_month", "WC_PersonalInfoExtension_birth_month-button");
		 ids.put("Birthday_date", "WC_PersonalInfoExtension_birth_date-button");
         ids.put("Country", "WC_PersonalInfoExtension_mobile_div_Country_dropdown-button");
		 ids.put("Mobile no_CountryCode", "WC_PersonalInfoExtension_mobile_div_mobileCountryCode");
		 ids.put("Mobile no","WC_PersonalInfoExtension_mobile_div_12");
		 ids.put("Send sms notification to mobile phone", "WC_UserRegistrationAddForm_FormInput_sendMeSMSNotification_In_Register_2_Img");
		 ids.put("Send sms promotions to mobile phone", "WC_UserRegistrationAddForm_FormInput_sendMeSMSPreference_In_Register_3_Img");
		 ids.put("Update", "WC_UserRegistrationUpdateForm_links_1");
		
		 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				 //System.out.println(id.getKey() + " is displayed ");
		         rpt.createTest("CC-Personal Information-Verify Displayed Information", "Message :"+id.getKey()+" Displayed - For Verify Displayed Information");
		         rpt.Pass("Message :"+ id.getKey() +" Displayed : For Verify Displayed Information");
		         rpt.Category("CC_Personal Information-Verify Displayed Information");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 //System.out.println(id.getKey() + " is not displayed ");
				 rpt.createTest("CC-Personal Information-Verify Displayed Information", "Message :"+id.getKey()+" is NOT Displayed - For Verify Displayed Information");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify Displayed Information");
		         rpt.Category("CC_Personal Information-Verify Displayed Information");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 }     
	}
	public void fieldValidation()throws Exception
	{
		//valid values
		System.out.println("in field vldtn");
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']");//first name
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']","test");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']");//last name
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']","user");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']");//street address
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']","349 US-1");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']");//city
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']","Mumbai");
		
		/*click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_country_1-button']/span[1]");//country
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']","India");
		
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1']");//state
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1']","WA");/*
	
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']");//zip code
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']","400057");
		
		/*click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']");//e mail
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']","zzz@gmail.com");/*
		
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");//phone no
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']","9090900099");
		
		/*click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput__preferredLanguage_In_Register_1-button']");//preferred language
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput__preferredLanguage_In_Register_1-button']","United States English");
		
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput__preferredCurrency_In_Register_1-button']/span[1]");//preferred currency
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput__preferredCurrency_In_Register_1-button']/span[1]","US Dollar");*/
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']");//zip code
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']","400057");
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");//phone no
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']","9090900099");
		
		/*click("xpath=html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div/div[2]/div/form/div[14]/span/span[1]");//gender
		Screen s  = new Screen();
		Thread.sleep(6000);
		Pattern img=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\Gender_CC.png");
		Thread.sleep(5000);
		s.click(img);
		
		click("xpath=//*[@id='WC_PersonalInfoExtension_birth_year-button']");//birthday year
		Screen scr  = new Screen();
		Pattern im=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\Birthyear_CC.png");
		Thread.sleep(3000);
		scr.click(im);
		
		
		click("xpath=//*[@id='WC_PersonalInfoExtension_birth_month-button']");//birthday month
		Screen sc  = new Screen();
		Thread.sleep(3000);
		Pattern im1=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\Birthmonth_CC.png");
		sc.click(im1);	
		
		click("xpath=//*[@id='WC_PersonalInfoExtension_birth_date-button']");//birthday date
		Screen scrr  = new Screen();
		Pattern ima=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\Birthdate_CC.png");
		Thread.sleep(3000);
		scrr.click(ima);*/
		
		/*click("xpath=//*[@id='WC_PersonalInfoExtension_mobile_div_mobileCountryCode']");*/ //mobile no extension
		
		
		click("xpath=//*[@id='WC_PersonalInfoExtension_mobile_div_12']");
		sendKeys("xpath=//*[@id='WC_PersonalInfoExtension_mobile_div_12']","9898989822");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");//update
		
		click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_0']");
		
		//for invalid data
		 /*String[] invalidFName={"1234567890","!@#$%"," "};
	        Thread.sleep(2000);
			
			for(String value :invalidFName)
			{

				sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']", value);
				
				click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

				 Thread.sleep(2000);
				Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_lastname']").isDisplayed();//error msg
				if(strMessage)
				{
					System.out.println("Message Displayed for name :"+ strMessage);
				}
				else
				{
					System.out.println("Error Message NOT Displayed");
				}
			}*/
		findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']").clear();
			click("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']");//first name
	        sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1']","test");

			String[] invalidLName={" "};
			 Thread.sleep(2000);
			   for(String value :invalidLName)
					{
				   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']").clear();
						sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']", value);
						
						click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

						 Thread.sleep(2000);
						 String Actual=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_lastname']").getText();

						Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_lastname']").isDisplayed();//error msg
						String Expected="The last name field cannot be empty";

						if(Actual.contains(Expected))
						{
							//System.out.println("Message Displayed for name :"+ strMessage);
							  rpt.createTest("CC-Personal Information-Invalid Name", "Message"+Expected+" Displayed- For Invalid Name");
							  //rpt.Info("Expected Message "+Expected+" Is Matching with "+Actual +"Message");
							  rpt.Pass("Message "+Expected+" Displayed- For Invalid Name");
							  rpt.Category("CC_Personal Information-Invalid Name");
						         String path = rpt.CaptureScreen(browser, "ValidMessage");
						         rpt.imgPathPass(path);
						}
						else
						{
							//System.out.println("Error Message NOT Displayed");

				              rpt.createTest("CC-Personal Information-Invalid Name", "Message"+Actual+" Displayed- For Invalid Name");
							   //rpt.Info("Expected Message "+Expected+ "Not Matching with "+Actual +"Message");
							   rpt.Fail("Message "+Expected+" NOT Displayed- For Invalid Name");
							   rpt.Category("CC_Personal Information-Invalid Name");
						         String path = rpt.CaptureScreen(browser, "InvalidMessage");
						         rpt.imgPathFail(path);

						}
	                 }
			   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']").clear();
			   sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']","user");
	
			  /* String[] streetAddress={"!@#$%"," "};
				 Thread.sleep(2000);
				   for(String value :streetAddress)
						{

							sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']", value);
							
							click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

							 Thread.sleep(2000);
							Boolean strMessage = findTheElement("xpath=").isDisplayed();//error msg is nt displaying
							if(strMessage)
							{
								System.out.println("Message Displayed for name :"+ strMessage);
							}
							else
							{
								System.out.println("Error Message NOT Displayed");
							}
		                 }*/
				
				click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']");//street address
				findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']").clear();
				sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']","349 US-1");
			   
				   String[] invalidCity={" "};
					 Thread.sleep(2000);
					   for(String value :invalidCity)
							{
						   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']").clear();
								sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']", value);
								
								click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

								 Thread.sleep(2000);
				                 String actualCity=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_4']").getText();

								Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_4']").isDisplayed();//error msg
								String expectedCity="The city field cannot be empty";

								if(actualCity.contains(expectedCity))
								{
									//System.out.println("Message Displayed for city :"+ strMessage);
									 rpt.createTest("CC-Personal Information-Invalid City", "Message"+expectedCity+" Displayed- For Invalid City");
									    //rpt.Info("Expected Message "+expectedCity+" Is Matching with "+actualCity +"Message");
									    rpt.Pass("Message "+expectedCity+" Displayed- For Invalid City");
									    rpt.Category("CC_Personal Information-Invalid City");
								         String path = rpt.CaptureScreen(browser, "ValidMessage");
								         rpt.imgPathPass(path);
								}
								else
								{
									//System.out.println("Error Message NOT Displayed");
									rpt.createTest("CC-Personal Information-Invalid City", "Message"+actualCity+" Displayed- For Invalid City");
									 //rpt.Info("Expected Message "+expectedCity+ "Not Matching with "+actualCity +"Message");
									 rpt.Fail("Message "+expectedCity+" NOT Displayed- For Invalid City");
									 rpt.Category("CC_Personal Information-Invalid City");
							         String path = rpt.CaptureScreen(browser, "InvalidMessage");
							         rpt.imgPathFail(path);

								}
			                 }
					   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']").clear();
					   sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_city_1']","Milford");
					   
					   /*String[] invalidState={" "};
						 Thread.sleep(2000);
						   for(String value :invalidState)
								{

									sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1-button']", value);
									
									click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

									 Thread.sleep(2000);
									Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_10']").isDisplayed();//error msg
									if(strMessage)
									{
										System.out.println("Message Displayed for name :"+ strMessage);
									}
									else
									{
										System.out.println("Error Message NOT Displayed");
									}
				                 }
						   
						   click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_state_1-button']");
							Screen sc1  = new Screen();
							Pattern Img=new Pattern("C:\\Automation\\Sikuli_Images\\State_CC.png");
							sc1.click(Img);*/
							
					   String[] invalidzipCode={" "};
						 Thread.sleep(2000);
						   for(String value :invalidzipCode)
								{
							   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']").clear();
									sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']", value);
									
									click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

									 Thread.sleep(2000);
			                            String actualZcode=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_13']").getText();

									Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_13']").isDisplayed();//error msg
									String expectedZcode="The ZIP code/postal code field cannot be empty.";

									if(actualZcode.contains(expectedZcode))
									{
										//System.out.println("Message Displayed for zip code :"+ strMessage);
										rpt.createTest("CC-Personal Information-Invalid Zip code", "Message"+expectedZcode+" Displayed- For Invalid Zip code");
									   // rpt.Info("Expected Message "+expectedZcode+" Is Matching with "+actualZcode +"Message");
									    rpt.Pass("Message "+expectedZcode+" Displayed- For Invalid Zip code");
									    rpt.Category("CC_Personal Information-Invalid Zip code");
								         String path = rpt.CaptureScreen(browser, "ValidMessage");
								         rpt.imgPathPass(path);


									}
									else
									{
										//System.out.println("Error Message NOT Displayed");
										rpt.createTest("CC-Personal Information-Invalid Zip code", "Message"+actualZcode+" Displayed- For Invalid Zip code");
										// rpt.Info("Expected Message "+expectedZcode+ "Not Matching with "+actualZcode +"Message");
										 rpt.Fail("Message "+expectedZcode+" NOT Displayed- For Invalid Zip code");
										 rpt.Category("CC_Personal Information-Invalid Zip code");
								         String path = rpt.CaptureScreen(browser, "InvalidMessage");
								         rpt.imgPathFail(path);


									}
				                 }
						   findTheElement("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']").clear();
						   sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_zipCode_1']","789234");
						   
						   String[] invalidEmailid={"1234567890","!@#$%"};
							 Thread.sleep(2000);
							   for(String value :invalidEmailid)
									{
								   findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']").clear();
										sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']", value);
										
										click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");  

										 Thread.sleep(2000);
										 String actualEid=findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_div_19']").getText();
										Boolean strMessage = findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_div_19']").isDisplayed();//error msg
										String expectedEid="The email entered is not in a valid format.";
										if(actualEid.contains(expectedEid))
										{
											//System.out.println("Message Displayed for email id :"+ strMessage);
											rpt.createTest("CC-Personal Information-Invalid Email id", "Message"+expectedEid+" Displayed- For Invalid Email id");
										    //rpt.Info("Expected Message "+expectedEid+" Is Matching with "+actualEid +"Message");
										    rpt.Pass("Message "+expectedEid+" Displayed- For Invalid Email id");
										    rpt.Category("CC_Personal Information-Invalid Email id");
									         String path = rpt.CaptureScreen(browser, "ValidMessage");
									         rpt.imgPathPass(path);


										}
										else
										{
											//System.out.println("Error Message NOT Displayed");
											rpt.createTest("CC-Personal Information-Invalid Email id", "Message"+actualEid+" Displayed- For Invalid Email id");
											 //rpt.Info("Expected Message "+expectedEid+ "Not Matching with "+actualEid +"Message");
											 rpt.Fail("Message "+expectedEid+" NOT Displayed- For Invalid Email id");
											 rpt.Category("CC_Personal Information-Invalid Email id");
									         String path = rpt.CaptureScreen(browser, "InvalidMessage");
									         rpt.imgPathFail(path);

										}
					                 }
							   findTheElement("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']").clear();
							   sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_email1_In_Register_1']","user@test.com");
							   click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");
	
							   
  }
	public void verify_MyAcc()throws Exception
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
    			 //System.out.println(id.getKey() + " is displayed ");
    			 rpt.createTest("CC-Personal Information-Verify My Account", "Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account");
		         rpt.Category("CC_Personal Information-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
    		 }
    		 else
    		 {
    			 //System.out.println(id.getKey() + " is not displayed ");
    			 rpt.createTest("CC-Personal Information-Verify My Account", "Message :"+id.getKey()+" is NOT Displayed - For Verify My Account");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify My Account");
		         rpt.Category("CC_Personal Information-Verify My Account");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
    		 }
    	 }		 
		
	}
	public void verifySettings()throws Exception
	{
		 System.out.println("in verifySettings");
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
				 //System.out.println(id.getKey() + " is displayed ");
				 rpt.createTest("CC-Personal Information-Verify Settings", "Message :"+id.getKey()+" Displayed - For Verify Settings");
		         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify Settings");
		         rpt.Category("CC_Personal Information-Verify Settings");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 //System.out.println(id.getKey() + " is not displayed ");
				 rpt.createTest("CC-Personal Information-Verify Settings", "Message :"+id.getKey()+" is NOT Displayed - For Verify Settings");
		         rpt.Fail("Message :"+id.getKey()+" NOT Displayed - For Verify Settings");
		         rpt.Category("CC_Personal Information-Verify Settings");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
	}
		 Thread.sleep(2000);
		   click("id=myAccountQuickLink");
		   Thread.sleep(2000);
		   click("xpath=//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
	}
     public void verify_details()throws Exception
	{
		System.out.println("in verify_details");
		fieldValidation();
	}
	
	/*public void mandatoryFields()throws Exception
	{
		System.out.println("in mandatoryFields");
		click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_0']");//personal info
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']");//last name
		sendKeys("//*[@id='WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1']","Ellie");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']");//street address
		sendKeys("xpath=//*[@id='WC_UserRegistrationUpdateForm_AddressEntryForm_FormInput_address1_1']","12 VB Gandhi Marg");
		
		click("xpath=//*[@id='WC_UserRegistrationUpdateForm_links_1']");//update
		
	}*/
//	click("xpath=//*[@id='Header_GlobalLogin_signOutQuickLink']"); //my acc
//	   Thread.sleep(5000);
//
//	   click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown_SignOut']"); //sign out
}	
