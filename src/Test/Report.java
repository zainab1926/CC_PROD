package Test;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityModelProvider;


public class Report {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
		
	private static String filePath = "C:\\Users\\user\\workspace\\CC\\test-output\\myReport.html";
	public static WebDriver browser = BrowserFactory.getBrowser("browser","URL");
	static String imagePath="C:\\Users\\user\\workspace\\CC\\Screenshots\\";
	
		
	private static long counter =0;
	BrowserFactory br = new BrowserFactory();
	public static ExtentReports GetExtent(){
		if (extent != null)
                    return extent; //avoid creating new instance of html file
                extent = new ExtentReports();		
		extent.attachReporter(getHtmlReporter());
//		extent.setSystemInfo("OS", "Windows 10");
//		extent.setSystemInfo("UserName", "Mahesh");
		
		return extent;
	}
 
	private static ExtentHtmlReporter getHtmlReporter() {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("CIRCUIT-CITY");
        htmlReporter.config().setReportName("CIRCUIT-CITY : Regression Suite");
        
        //htmlReporter.loadXMLConfig("C:\\Users\\madhusudhan\\workspace\\CC\\extent-config.xml");
        return htmlReporter;
        
	}
		
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;	
	}
	public static ExtentTest Pass(String Message)
	{
		test.pass(Message);
		test.assignCategory("CIRCUIT_CITY : Regression");
		return test;
	}
	public static  ExtentTest Fail(String FailMessage)
	{
		test.fail(FailMessage);
		test.assignCategory("CIRCUIT_CITY : Regression");
		test.warning(FailMessage);
		test.error(FailMessage);
		return test;
		
		
	}
	public static ExtentTest Skip(String SkipMessage)
	{
		test.skip(SkipMessage);
		test.assignCategory("CIRCUIT_CITY : Regression");
		
		return test;
	}

	public static ExtentTest Info(String InfoMessage)throws Exception
	{
		test.info(InfoMessage);
		return test;
	}
	public static ExtentTest imgPathPass(String path)throws Exception
	{
		test.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		return test;
		
	}
	public static ExtentTest imgPathFail(String path)throws Exception
	{
		test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		return test;
		
		
	}
	
	public static ExtentTest Category(String Category)throws Exception
	{
		test.assignCategory(Category);
		return test;
	}
	
	public static ExtentTest chkBugs(String Bugs)throws Exception
	{
		test.assignAuthor(Bugs);
		return test;
	}
	public static ExtentTest chkdebug(String dbg)throws Exception
	{
		//test.debug(dbg);
		test.error(dbg);

		return test;
	}
	
	
//	public static ExtentTest vdoPath()throws Exception,ATUTestRecorderException
//	{
//		ATUTestRecorder rec;
//		rec = new ATUTestRecorder("C:\\CI_CD_CT\\Test_Videos\\","Test_Video",false);
//		rec.start();
//		test.log(Status.PASS, test.addScreencastFromPath(rec));
//		return test;
//	}
	
	
	
		
	public static String CaptureScreen(WebDriver driver,String imgName)
	{

		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		String fileName = imagePath+imgName+(++counter)+".png";
		File oDest = new File(fileName);
		try
		{
			FileUtils.copyFile(oScnShot, oDest);
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return fileName;
	}
	
  /* public static String CaptureFullScreen(WebDriver driver,String imgName)
   { 
	   Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
       try 
       {
		ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/ErrorScreenshots/FullPageScreenshot.png"));
	} 
       catch (IOException e)
       {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  

	return imgName;
	   
   }*/
}
