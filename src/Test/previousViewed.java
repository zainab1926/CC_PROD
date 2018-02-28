package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class previousViewed extends Browser {

	Report rpt = new Report();
	Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void ExecuteCase() throws Exception {
		Login();
		compare_Previous();
		loveIt();
		shopNow();
	}

	// CC_PV_05/04s
	@BeforeTest
	public void Login() throws Exception {
		// click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		if (findTheElement(
				"xpath=//*[@id='Header_GlobalLogin_signInQuickLink']")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Login",
					"Login Displayed - For Verify Login");
			rpt.Pass("Login Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Login",
					"Login Page is NOT Displayed - For Verify Login");
			rpt.Fail("Login Page is NOT Displayed - For Verify Login");
			rpt.Category("CC_Previously Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		if (findTheElement(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify User Name",
					"User Name Displayed - For Verify User Name");
			rpt.Pass("User Name Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify User Name",
					"User Name is NOT Displayed - For Verify User Name");
			rpt.Fail("User Name Page is NOT Displayed - For Verify User Name");
			rpt.Category("CC_Previously Viewed - Verify User Name");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		// sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input","kanimozhi.p@royalcyber.com");
		if (findTheElement(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Entering User Name",
					"User Name Displayed - For Verify Entering User Name");
			rpt.Pass("User Name Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input","kanimozhi.p@royalcyber.com");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify User Name",
					"User Name is NOT Displayed - For Verify User Name");
			rpt.Fail("User Name Page is NOT Displayed - For Verify User Name");
			rpt.Category("CC_Previously Viewed - Verify User Name");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		
		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		
		if (findTheElement(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Password",
					"Password Displayed - For Verify Password");
			rpt.Pass("Password Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Password",
					"Password is NOT Displayed - For Verify Password");
			rpt.Fail("Password Page is NOT Displayed - For Verify Password");
			rpt.Category("CC_Previously Viewed - Verify Password");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		
		
		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input","Kanimozhi1234");
		if (findTheElement(
				"xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Entering Password",
					"Password Displayed - For Verify Entering Password");
			rpt.Pass("Password Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input","Kanimozhi1234");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Password",
					"Password is NOT Displayed - For Verify Password");
			rpt.Fail("Password Page is NOT Displayed - For Verify Password");
			rpt.Category("CC_Previously Viewed - Verify Password");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		//click("id=Header_GlobalLogin_WC_AccountDisplay_links_2");
		if (findTheElement(
				"id=Header_GlobalLogin_WC_AccountDisplay_links_2")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Login",
					"Login Displayed - For Verify Login");
			rpt.Pass("Login Displayed - For Verify Login");
			rpt.Category("CC_Previous Viewed - Verify Login ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=Header_GlobalLogin_WC_AccountDisplay_links_2");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Login",
					"Login is NOT Displayed - For Verify Login");
			rpt.Fail("Login Page is NOT Displayed - For Verify Login");
			rpt.Category("CC_Previously Viewed - Verify Login");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		
		
	}

	
	public void compare_Previous() throws Exception {
		Thread.sleep(30000);
		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
		if (findTheElement(
				"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products Displayed - For Verify Products");
			rpt.Pass("Products Displayed - For Verify Products");
			rpt.Category("CC_Previous Viewed - Verify Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products is NOT Displayed - For Verify Products");
			rpt.Fail("Products Page is NOT Displayed - For Verify Products");
			rpt.Category("CC_Previously Viewed - Verify Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		//click("id=departmentLink_3074457345616682180_alt");
		if (findTheElement(
				"id=departmentLink_3074457345616682180_alt")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Select Products",
					"Select Products Displayed - For Verify Select Products");
			rpt.Pass("Select Products Displayed - For Verify Select Products");
			rpt.Category("CC_Previous Viewed - Verify Select Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=departmentLink_3074457345616682180_alt");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Select Products is NOT Displayed - For Verify Select Products");
			rpt.Fail("Select Products Page is NOT Displayed - For Verify Select Products");
			rpt.Category("CC_Previously Viewed - Verify Select Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		/*
		 * click(
		 * "xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722799_link_9b']"
		 * ); browser.navigate().back();
		 * 
		 * click(
		 * "xpath=/html/body/div[3]/div[3]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/div[2]/div/a/img]"
		 * ); browser.navigate().back();
		 */
		Thread.sleep(30000);

		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Add Product To Compare",
					"Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Pass("Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previous Viewed - Verify Add Product To Compare ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[7]/label");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Add Product To Compare is NOT Displayed - For Verify Add Product To Compare");
			rpt.Fail("Add Product To Compare Page is NOT Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previously Viewed - Verify Add Product To Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		String beforeComparep1 = getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616722799_link_9b']");
		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);

		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Add Product To Compare",
					"Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Pass("Add Product To Compare Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previous Viewed - Verify Add Product To Compare ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[7]/label");
		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Add Product To Compare is NOT Displayed - For Verify Add Product To Compare");
			rpt.Fail("Add Product To Compare Page is NOT Displayed - For Verify Add Product To Compare");
			rpt.Category("CC_Previously Viewed - Verify Add Product To Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		String beforecomparep2 = getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616731405_link_9b']");
		Thread.sleep(2000);
		//click("xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Compare Previously Viewed",
					"Compare Previously Viewed Displayed - For Verify Compare Previously Viewed");
			rpt.Pass("Compare Previously Viewed Displayed - For Verify Compare Previously Viewed");
			rpt.Category("CC_Previous Viewed - Verify Compare Previously Viewed ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[4]/div/div[2]/a[1]");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Compare Previously Viewed is NOT Displayed - For Verify Compare Previously Viewed");
			rpt.Fail("Compare Previously Viewed Page is NOT Displayed - For Verify Compare Previously Viewed");
			rpt.Category("CC_Previously Viewed - Verify Compare Previouslt Viewed");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}


		String AftrerComparep1 = getText("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div[4]/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div[2]");
		String AftrerComparep2 = getText("xpath=/html/body/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div[4]/div/div/div[1]/div[2]/div/div[3]/div/div[3]/div[2]");
		if (beforeComparep1.equals(AftrerComparep1)
				&& beforecomparep2.equals(AftrerComparep2)) {
			System.out.println("Compare is working Fine And Passed");

		} else {
			System.out.println("Compare Functionality Failed");
		}
	}

	
	// CC_PV_06
	public void loveIt() throws Exception {
		Thread.sleep(30000);
		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
		if (findTheElement(
				"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products Displayed - For Verify Products");
			rpt.Pass("Products Displayed - For Verify Products");
			rpt.Category("CC_Previous Viewed - Verify Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Products",
					"Products is NOT Displayed - For Verify Products");
			rpt.Fail("Products Page is NOT Displayed - For Verify Products");
			rpt.Category("CC_Previously Viewed - Verify Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		//click("id=departmentLink_3074457345616682180_alt");
		if (findTheElement(
				"id=departmentLink_3074457345616682180_alt")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Selecting Products Displayed - For Verify Selecting Products");
			rpt.Pass("Selecting Products Displayed - For Verify Selecting Products");
			rpt.Category("CC_Previous Viewed - Verify Selecting Products ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=departmentLink_3074457345616682180_alt");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
					"Selecting Products is NOT Displayed - For Verify Selecting Products");
			rpt.Fail("Selecting Products Page is NOT Displayed - For Verify Selecting Products");
			rpt.Category("CC_Previously Viewed - Verify Selecting Products");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(30000);
		//click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img");
		if (findTheElement(
				"xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Love It Functionality",
					"Love It Functionality Displayed - For Verify Love It Functionality");
			rpt.Pass("Love It Functionality Displayed - For Verify Love It Functionality");
			rpt.Category("CC_Previous Viewed - Verify Love It Functionality ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/div/span[1]/div[2]/div[1]/a[1]/img");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Love It Functionality",
					"Love It Functionality is NOT Displayed - For Verify Love It Functionality");
			rpt.Fail("Love It Functionality Page is NOT Displayed - For Verify Love It Functionality");
			rpt.Category("CC_Previously Viewed - Verify Love It Functionality");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

	}

	
	// CC_PV_06
	public void shopNow() throws Exception {
		Thread.sleep(30000);
		//click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");
				if (findTheElement(
						"xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span")
						.isDisplayed()) {
					rpt.createTest("CC - Previous Viewed - Verify Products",
							"Products Displayed - For Verify Products");
					rpt.Pass("Products Displayed - For Verify Products");
					rpt.Category("CC_Previous Viewed - Verify Products ");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/a/span");

				} else {
					rpt.createTest("CC - Previous Viewed - Verify Products",
							"Products is NOT Displayed - For Verify Products");
					rpt.Fail("Products Page is NOT Displayed - For Verify Products");
					rpt.Category("CC_Previously Viewed - Verify Products");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

				//click("id=departmentLink_3074457345616682180_alt");
				if (findTheElement(
						"id=departmentLink_3074457345616682180_alt")
						.isDisplayed()) {
					rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
							"Selecting Products Displayed - For Verify Selecting Products");
					rpt.Pass("Selecting Products Displayed - For Verify Selecting Products");
					rpt.Category("CC_Previous Viewed - Verify Selecting Products ");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("id=departmentLink_3074457345616682180_alt");

				} else {
					rpt.createTest("CC - Previous Viewed - Verify Selecting Products",
							"Selecting Products is NOT Displayed - For Verify Selecting Products");
					rpt.Fail("Selecting Products Page is NOT Displayed - For Verify Selecting Products");
					rpt.Category("CC_Previously Viewed - Verify Selecting Products");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
		Thread.sleep(30000);
		//click("xpath=//*[@id='listViewAdd2Cart_3074457345616722799']");
		if (findTheElement(
				"xpath=//*[@id='listViewAdd2Cart_3074457345616722799']")
				.isDisplayed()) {
			rpt.createTest("CC - Previous Viewed - Verify Shop Now",
					"Shop Now Displayed - For Verify Shop Now");
			rpt.Pass("Shop Now Displayed - For Verify Shop Now");
			rpt.Category("CC_Previous Viewed - Verify Shop Now ");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id='listViewAdd2Cart_3074457345616722799']");

		} else {
			rpt.createTest("CC - Previous Viewed - Verify Shop Now",
					"Shop Now is NOT Displayed - For Verify Shop Now");
			rpt.Fail("Shop Now Page is NOT Displayed - For Verify Shop Now");
			rpt.Category("CC_Previously Viewed - Verify Shop Now");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		String SuccessMessage = getText("id=cartDropdownMessage");

		if (SuccessMessage.contains("Your item was added")) {
			System.out.println("Item was added Successfully and Passed");
		} else {
			System.out.println("Fail");
		}
	}

}
