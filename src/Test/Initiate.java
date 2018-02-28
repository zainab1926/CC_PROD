package Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Initiate {

	ExtentReports extent;
	ExtentTest test;
	public static WebDriver browser = BrowserFactory.getBrowser("browser","url");
	BrowserFactory br = new BrowserFactory();
	Report rpt = new Report();
	WebDriver wb;
		
	
	@BeforeClass
	public void Ini(){
		extent = Report.GetExtent();
//		System.setProperty("webdriver.gecko.driver", "C:\\CI_CD_CT\\Browser_Executables\\geckodriver.exe");
//		driver = new FirefoxDriver();

	}
	@SuppressWarnings("static-access")
	@Parameters({"browser","url","Module"})
	@Test
	public void checkHome(String Browser, String Url,String Module)throws Exception
	{
		
		rpt.createTest("CIRCUIT CITY", "Verify HomePage");
		br.getBrowser(Browser, Url);
		rpt.Pass("Browser that is passed as parameter from Jenkins is :"+Browser);
		rpt.Pass("URL that is passed as parameter from Jenkins is :"+Url);
		//test.log(Status.PASS,"Browser Opened As Expected");
		//br.captureScreenShot("HomePage");
		
		if (Module != null) 
		{
			
			if ("Registration".equalsIgnoreCase(Module)) {
				checkRegistration();
			} else if ("AddressBook".equalsIgnoreCase(Module)) {
				chkAddress_Book();
			} else if ("PersonalInformation".equalsIgnoreCase(Module)) {
				chkPersonalInfo();
			} 
			else if("Search".equalsIgnoreCase(Module)){
				chkSearch();
			}	
			else if("SignIn_Forgot_Password".equalsIgnoreCase(Module)){
				chkSignIn();
			}	
			else if("WishList".equalsIgnoreCase(Module)){
				chkWishList();
			}
			else if("changePassword".equalsIgnoreCase(Module)){
				chkchangePassword();
			}
			else if("productComparison".equalsIgnoreCase(Module)){
				chckproduct();
			}
			else if("savedPaymentMehods".equalsIgnoreCase(Module)){
				chksavedPaymentMehods();
			}
			else if("shoppingCart".equalsIgnoreCase(Module)){
				chkshoppingCart();
			}
			else if("Regression".equalsIgnoreCase(Module)){
				chkRegression();
			}
			else if("plpModule".equalsIgnoreCase(Module)){
				chkplpModule();
			}
			else if("orderHistoryModule".equalsIgnoreCase(Module)){
				chkorderHistoryModule();
			}
			else if("PDPModule".equalsIgnoreCase(Module)){
				chkPDPModule();
			}
			else if("previousViewed".equalsIgnoreCase(Module)){
				chkpreviousViewed();
			}
			else if("HomePage".equalsIgnoreCase(Module)){
				chkHomePage();
			}
			else if("CheckoutFlow".equalsIgnoreCase(Module)){
				chk_CheckoutFlow();
			}
			else if("Modules".equalsIgnoreCase(Module))
			{
				checkRegistration();
		      	chkAddress_Book();
				chkPersonalInfo();
				chkSignIn();
				chkchangePassword();
				chkWishList();
				chksavedPaymentMehods();
			}
			
			else if("All Modules".equalsIgnoreCase(Module))
			{
				chkHomePage();
				chkpreviousViewed();
				chkPDPModule();
				chkorderHistoryModule();
				chkRegression();
				checkRegistration();
		      	chkAddress_Book();
				chkPersonalInfo();
				chkSearch();
				chkSignIn();
				chkchangePassword();
				chkWishList();
				chckproduct();
				chksavedPaymentMehods();
				chkshoppingCart();
				chkplpModule();
				
			}	
		}
	}
	public void chk_CheckoutFlow()throws Exception
	{
		CheckoutFlow sc=new CheckoutFlow();
		sc.executeAll();
	}
	public void chkHomePage()throws Exception
	{
		HomePage sc=new HomePage();
		sc.ExecuteAll_HomePage();
	}
	public void chkpreviousViewed()throws Exception
	{
		previousViewed sc=new previousViewed();
		sc.ExecuteCase();
	}
	public void chkPDPModule()throws Exception
	{
		PDPModule sc=new PDPModule();
		sc.executeAll();
	}
	public void chkorderHistoryModule()throws Exception
	{
		orderHistoryModule sc=new orderHistoryModule();
		sc.executeAll();
	}
	public void chkplpModule()throws Exception
	{
		plpModule sc=new plpModule();
		sc.executeAll();
	}
	public void chkRegression()throws Exception
	{
		Regression sc=new Regression();
		sc.executeAll();
	}
	
	public void chkshoppingCart()throws Exception
	{
		shoppingCart sc=new shoppingCart();
		sc.executeAll();
	}
	public void chksavedPaymentMehods() throws Exception
	{
		savedPaymentMehods sp = new savedPaymentMehods();
		sp.executeAll();
	}
	public void chkchangePassword()throws Exception
	{
		changePassword reg  = new changePassword();
		reg.executeAllTestcase();
	}
	public void chkWishList()throws Exception
	{
		WishList reg  = new WishList();
		reg.executeAllTest();
	}
	public void chkSignIn()throws Exception
	{
		SignIn_Forgot_Password reg  = new SignIn_Forgot_Password();
		reg.executeAllTest();
	}
		
	public void checkRegistration()throws Exception
	{
		Registration reg  = new Registration();
		reg.executeAllTest();
	}
	
	public void chkPersonalInfo()throws Exception
	{
		PersonalInformation pi = new PersonalInformation();
		pi.executeAllTestcase();
	}
	
	public void chkAddress_Book()throws Exception
	{
		AddressBook add = new AddressBook();
		add.executeAllTest();
	}
	public void chkSearch()throws Exception
	{
		Search srch = new Search();
		srch.execute_Alltestcases();
	}
	public void chckproduct()throws Exception
	{
		productComparison p = new productComparison();
		p.executeAll();
	}
	
	public void checkFail()throws Exception
	{
		rpt.createTest("Testing - Fail Criteria for Circuit City","Checked");
//		test.log(Status.FAIL, "fail check started");
		rpt.Fail("Testing Fail - CIRCUIT CITY");
	
	}
	
	public void skipTest()
	{	
		rpt.createTest("SkipTest","Skipped");
//		throw new SkipException("Skipping Test");
		rpt.Skip("Test Skipped");
	}
		
	@AfterTest
	public void publishReport()throws Exception
	{
		extent.flush();
		
	}

}
