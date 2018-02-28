package Test;

/**
 * Functional Decomposition Framework
 *  Mahesh NVS 30/5/2016
 *
 * 
 */
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class BrowserFactory {
	
	static ExtentReports extent;
	static ExtentTest test;
//	static WebDriver driver;
	public static WebDriver browser = null;
	
	
	public static WebDriver getBrowser(String browserName,String url) {
		if (browser == null) {
			try {

//				String browserName = CommonUtils.readFromConfig("Browser");

				if ("FF".equalsIgnoreCase(browserName)) {
					browser = loadFireFoxDriver(url);
				} else if ("IE".equalsIgnoreCase(browserName)) {
					browser = loadIEDriver(url);
				} else if ("chrome".equalsIgnoreCase(browserName)) {
					browser = loadChromeDriver(url);
				} 
				//else if("Android".equalsIgnoreCase(browserName)){
//					browser = loadAndroid(url);
//				}
				
			} catch (Exception exception) {
			}

		}

		return browser;
	}

	
	private static RemoteWebDriver loadFireFoxDriver(String url) throws Exception {

		String loadffProfile = CommonUtils.readFromConfig("loadffProfile");
		RemoteWebDriver remoteDriver = null;
		FirefoxProfile profile = null;

		if ("true".equalsIgnoreCase(loadffProfile)) {
			String profilePath = CommonUtils.readFromConfig("FIREFOXPROFILEDIR");
			File profileDir = new File(profilePath);
			profile = new FirefoxProfile(profileDir);
			profile.setAcceptUntrustedCertificates(false);
		}

		if ("true".equalsIgnoreCase(loadffProfile)) {
			remoteDriver = new FirefoxDriver(profile);
		} else {
			extent = Report.GetExtent();
			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setAcceptInsecureCerts(true);
		    browser  = new FirefoxDriver(dc);	
		    Browser br = new Browser();
		    br.go(url);
		    String appTitle = br.getTitle();
			test=extent.createTest("Checking Application Title - HomePage");
			if(br.getTitle().contains(appTitle))
			{
				test.pass("Application Title :"+appTitle+" is Matching");
				
			}
			else
			{
			test.fail("Application Title Not Matching");
			}
		
		}
		return remoteDriver;

	}

	
	private static RemoteWebDriver loadIEDriver(String url) throws Exception {

		RemoteWebDriver remoteDriver = null;
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

		System.setProperty("webdriver.ie.driver",
				"C:\\Automation\\IEDriverServer.exe");
		remoteDriver = new InternetExplorerDriver(capabilities);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		 browser  = new FirefoxDriver(dc);	
		    Browser br = new Browser();
		    br.go(url);
		
		return remoteDriver;

	}


	private static RemoteWebDriver loadChromeDriver(String url) throws Exception {

		RemoteWebDriver remoteDriver = null;
		String hostOS = CommonUtils.getHostOperatingSystem();

		if (hostOS.equalsIgnoreCase("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/browser_exe/chrome/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\chromedriver.exe");
		}		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
		remoteDriver = new ChromeDriver(capabilities);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		 	browser  = new ChromeDriver(dc);	
		    Browser br = new Browser();
		    br.go(url);
		return remoteDriver;
	}
	
//	private static RemoteWebDriver loadAndroid(String url)throws Exception
//	{
//		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		//capabilities setting for Samsung S8 - Browser stack
//		capabilities.setCapability("browserstack.debug", "true");
//		capabilities.setCapability("device", "Samsung Galaxy S8");
//		capabilities.setCapability("realMobile", "true");
//		capabilities.setCapability("os_version", "7.0");
//		System.out.println("Executing test on Samsung S8(Android) on Browser Stack cloud!");
//		BrowserStackURL= "https://" + BS_USERNAME + ":" + BS_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//		Drive     r = new RemoteWebDriver(new URL(BrowserStackURL), capabilities);
//		break;
//
//	}

}
