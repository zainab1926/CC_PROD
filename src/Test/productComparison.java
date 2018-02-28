package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class productComparison extends Browser
{
	Report rpt = new Report();
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;
	//Browser br  = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	
	public void executeAll() throws Exception
	{
		verifyProduct();
    	customerView();
		addedProduct();
		addToCart();
		compareProduct();
		//CC_CP_07 Invalid. Refer CIR-1577
//		compareCategory();
		verifyCompare();
		shareProduct();
		verifyEmail();
		verifyPrint();
		verifyRemove();
		verifySearch();
	}
	
	//CC_CP_01
	public void verifyProduct() throws Exception
	{
		//click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Product", "Search Text Box is Displayed - For Verify Product");
	         rpt.Pass("Search Text Box is Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Product", "Search Text Box NOT  Displayed - For Verify Product");
	         rpt.Fail("Search Text Box NOT Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Product", "Searching for Product is Displayed - For Verify Product");
	         rpt.Pass("Searching for Product is Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Product", "Searching for Product NOT Displayed - For Verify Product");
	         rpt.Fail("Searching for Product NOT Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		//click("xpath=//*[@id='autoSelectOption_0']/div/img");
		if(findTheElement("xpath=//*[@id='autoSelectOption_0']/div/img").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Product", "Selecting Product is Displayed - For Verify Product");
	         rpt.Pass("Selecting Product is Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='autoSelectOption_0']/div/img");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Product", "Selecting Product NOT Displayed - For Verify Product");
	         rpt.Fail("Selecting Product NOT Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
		
		Element = findTheElement("xpath=//div[@class='accessory '][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");  
		
//	    Robot r = new Robot();
	    /*for(int i=0;i<4;i++){*/
//	    r.keyPress(KeyEvent.VK_DOWN);
//	    r.keyRelease(KeyEvent.VK_DOWN);
	    
	   /* r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);*/
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//	    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
//	    r.mouseWheel(3);
	   /* Thread.sleep(5000);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);*/
//		click("xpath=//div[@class='accessory '][1]//label[contains(text(),'Compare')]"); //compare
		
		//Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_PAGE_UP);
//		r.keyRelease(KeyEvent.VK_PAGE_UP);
//		r.keyPress(KeyEvent.VK_PAGE_UP);
//		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
//		jse.executeScript("window.scrollBy(3000,0)");  
		
		Thread.sleep(3000);
		//click("xpath=//*[@id='compare_3074457345616683129']/label"); //compare 
		if(findTheElement("xpath=//div[@class='accessory '][1]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Product", "Compare for Product is Displayed - For Verify Product");
	         rpt.Pass("Compare for Product is Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='accessory '][1]//label[contains(text(),'Compare')]"); //compare 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Product", "Compare for Product NOT Displayed - For Verify Product");
	         rpt.Fail("Compare for Product NOT Displayed - For Verify Product");
	         rpt.Category("CC_Product Comparison - Verify Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		/*Screen s  = new Screen();
		Thread.sleep(6000);
		Pattern img=new Pattern("C:\\Users\\user\\workspace\\CC\\sikuli images\\compare_cc.png");
		Thread.sleep(5000);
		s.click(img);*/
	}
	
	//CC_CP_02
	public void customerView() throws Exception
	{
		//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
		if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Detail Page is Displayed - For Verify Customer View");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Detail Page NOT Displayed - For Verify Customer View");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Category Page is Displayed - For Verify Customer View");
	         rpt.Pass("Product Category Page is Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
//	 		click("xpath=//*[@id='departmentLink_3074457345616682178_alt']");
	 		click("xpath=//li[14]/.//a[@class='menuLink']");
	 		
		 }
	    else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Category Page NOT Displayed - For Verify Customer View");
	         rpt.Pass("Product Category Page NOT Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
/*
	    if(findTheElement("xpath=//li[5]/.//div[@class='cat-title']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Sub Category Page is Displayed - For Verify Customer View");
	         rpt.Pass("Product Category Page is Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[5]/.//div[@class='cat-title']");
	 		
		 }
	    else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Category Page NOT Displayed - For Verify Customer View");
	         rpt.Pass("Product Category Page NOT Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
 */
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)"); 
		
		//click("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727788_link_9b']");
//		if(findTheElement("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727788_link_9b']").isDisplayed())
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Customer View", "Product is Displayed - For Verify Customer View");
	         rpt.Pass("Product is Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
//	 		click("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727788_link_9b']");
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Customer View", "Product NOT Displayed - For Verify Customer View");
	         rpt.Fail("Product NOT Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
		
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    /*r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
		
		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)"); 
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='compare_3074457345616707434']/label");
		if(findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Compare is Displayed - For Verify Customer View");
	         rpt.Pass("Product Compare  is Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Customer View", "Product Compare NOT Displayed - For Verify Customer View");
	         rpt.Fail("Product Compare NOT Displayed - For Verify Customer View");
	         rpt.Category("CC_Product Comparison - Verify Customer View");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	}
	
	//CC_CP_03
	public void addedProduct()throws Exception
	{
		//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
		if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
			
		 {
	         rpt.createTest("CC - Product Comparison - Verify Added Product", "Product Detail Page is Displayed - For Verify Added Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Added Product", "Product Detail Page NOT Displayed - For Verify Added Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Added Product", "Product Category Page is Displayed - For Verify Added Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Added Product", "Product Category Page NOT Displayed - For Verify Added Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)"); 
		
		//click("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727788_link_9b']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Added Product", "Product is Displayed - For Verify Added Product");
	         rpt.Pass("Product is Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Added Product", "Product NOT Displayed - For Verify Added Product");
	         rpt.Fail("Product NOT Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)"); 

		
		Thread.sleep(4000);
		//click("xpath=//*[@id='compare_3074457345616707434']/label");
		if(findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Added Product", "Comparing Products Button is Displayed - For Verify Added Product");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Added Product", "Comparing Products Button NOT Displayed - For Verify Added Product");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(2000);
		//added
		/*Element = findTheElement("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);*/
		Thread.sleep(3000);
		
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
	    //click("xpath=//*[@id='compareButton_3074457345616734525']"); //compare
	    if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Added Product", "Adding Products To Compare is Displayed - For Verify Added Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
//	 	   jse.executeScript("window.scrollBy(0,2000)"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Added Product", "Adding Products To Compare NOT Displayed - For Verify Added Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Added Product");
	         rpt.Category("CC_Product Comparison - Verify Added Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	}
	
	//CC_CP_05
	public void addToCart()throws Exception
	{
		//click("xpath=//*[@id='comparePageAdd2Cart_1']"); //add to cart
		if(findTheElement("xpath=//a[@id='add2CartBtn_1']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Add To Cart", "Adding Products To Cart is Displayed - For Verify Add To Cart");
	         rpt.Pass("Adding Products To Cart is Displayed - For Verify Add To Cart");
	         rpt.Category("CC_Product Comparison - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//a[@id='add2CartBtn_1']"); //add to cart
	 	   	click("xpath=//a[@id='MiniShopCartCloseButton_2']"); //close
	 		Thread.sleep(4000);
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Add To Cart", "Adding Products To Cart NOT Displayed - For Verify Add To Cart");
	         rpt.Fail("Adding Products To Cart NOT Displayed - For Verify Add To Cart");
	         rpt.Category("CC_Product Comparison - Verify Add To Cart");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	}
	
	//CC_CP_06
   public void compareProduct()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Detail Page is Displayed - For Verify Compare Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Detail Page NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682178_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Category Page is Displayed - For Verify Compare Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Category Page NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)"); 
		Thread.sleep(4000);
		//click("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616727788_link_9b']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product is Displayed - For Verify Compare Product");
	         rpt.Pass("Product is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");  
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='compare_3074457345616707434']/label");
		if(findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][3]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][4]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][5]//label[contains(text(),'Compare')]");
		
		Thread.sleep(3000);
		 String message = "The maximum number of products that can be compared is 4. Please refine your selection.";
		   String comapremessage=getText("xpath=//div[@id='widget_product_comparison_popup']//p[contains(text(),'The maximum number of products that can be compared is 4. Please refine your selection.')]");
		   if(message.contains(comapremessage))
		   {
		    Thread.sleep(2000);
		    click("xpath=//div[@id='widget_product_comparison_popup']//a[contains(text(),'COMPARE NOW')]");
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
		
		
/*		if(findTheElement("xpath=//div[@class='product_option ']//a[contains(text(),'COMPARE NOW')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='product_option ']//a[contains(text(),'COMPARE NOW')]"); //Compare now
	 		Thread.sleep(4000);
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
*/		
		Thread.sleep(3000);
		if(findTheElement("xpath=//*[@id='comparePageRemoveItemMain_4']/img").isDisplayed())
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='comparePageRemoveItemMain_4']/img"); //remove
		 }
		
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		click("xpath=//*[@id='comparePageRemoveItemMain_3']/img"); //remove
		Thread.sleep(3000);
		click("xpath=//*[@id='comparePageRemoveItemMain_2']/img"); //remove
		Thread.sleep(3000);
		click("xpath=//*[@id='comparePageRemoveItemMain_1']/img"); //remove
		Thread.sleep(3000);
		
/*	    //click("xpath=//*[@id='compareButton_3074457345616734525']"); //compare
	    if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }*/
   
   }
   
   //CC_CP_07 Invalid. Refer CIR-1577
   public void compareCategory()throws Exception
   {
   	//click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
   	if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Search Text Box is Displayed - For Verify Compare Category");
	         rpt.Pass("Search Text Box is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Search Text Box NOT  Displayed - For Verify Compare Category");
	         rpt.Fail("Search Text Box NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Samsung");
		if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Searching for Product is Displayed - For Verify Compare Category");
	         rpt.Pass("Searching for Product is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Samsung tv");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Searching for Product NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Searching for Product NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='autoSelectOption_4']/div/img");
		if(findTheElement("xpath=//*[@id='autoSelectOption_4']/div/img").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Selecting Product is Displayed - For Verify Compare Category");
	         rpt.Pass("Selecting Product is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='autoSelectOption_4']/div/img");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Selecting Product NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Selecting Product NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
//		Robot r = new Robot();
//		for(int i=0; i<15; i++) 
//		{
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='compare_3074457345616688890']/label"); //dell product
		if(findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Comparing Products Button is Displayed - For Verify Compare Category");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]"); //dell product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Comparing Products Button NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		
		if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Search Text Box is Displayed - For Verify Compare Category");
	         rpt.Pass("Search Text Box is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Search Text Box NOT  Displayed - For Verify Compare Category");
	         rpt.Fail("Search Text Box NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Samsung");
		if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Searching for Product is Displayed - For Verify Compare Category");
	         rpt.Pass("Searching for Product is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Searching for Product NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Searching for Product NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='autoSelectOption_4']/div/img");
		if(findTheElement("xpath=//*[@id='autoSelectOption_4']/div/img").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Selecting Product is Displayed - For Verify Compare Category");
	         rpt.Pass("Selecting Product is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='autoSelectOption_4']/div/img");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Selecting Product NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Selecting Product NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
//		Robot r = new Robot();
//		for(int i=0; i<15; i++) 
//		{
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='compare_3074457345616688890']/label"); //dell product
		if(findTheElement("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Comparing Products Button is Displayed - For Verify Compare Category");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]"); //dell product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Comparing Products Button NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		
		
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]"); //lenovo
		//click("xpath=//*[@id='compareButton_3074457345616683133']");
		 if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Category", "Adding Products To Compare is Displayed - For Verify Compare Category");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Compare Category");
	         rpt.Category("Category");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][2]//a[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Category", "Adding Products To Compare NOT Displayed - For Verify Compare Category");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Compare Category");
	         rpt.Category("CC_Product Comparison - Verify Compare Category");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
   }
   
   //CC_CP_08
   public void verifyCompare()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Detail Page is Displayed - For Verify Compare Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Detail Page NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682169_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Category Page is Displayed - For Verify Compare Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product Category Page NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		//click("xpath=//*[@id='catalogEntry_img3074457345616727848']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product is Displayed - For Verify Compare Product");
	         rpt.Pass("Product is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Product NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Product NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		//click("xpath=//*[@id='compare_3074457345616727948']/label");
		if(findTheElement("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Pass("Comparing Products Button is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Comparing Products Button NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("xpath=//*[@id='compareButton_3074457345616727948']"); //compare
		 if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
//		browser.navigate().back();
		 
		 Thread.sleep(3000);
		 if(findTheElement("xpath=.//*[@id='compareBackLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=.//*[@id='compareBackLink']"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Compare Product", "Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Compare Product");
	         rpt.Category("CC_Product Comparison - Verify Compare Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
   }
  
   //CC_CP_09
   public void shareProduct()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Share Product", "Product Detail Page is Displayed - For Verify Share Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Share Product", "Product Detail Page NOT Displayed - For Verify Share Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682169_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Share Product", "Product Category Page is Displayed - For Verify Share Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Share Product", "Product Category Page NOT Displayed - For Verify Share Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='catalogEntry_img3074457345616727848']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Share Product", "Product is Displayed - For Verify Share Product");
	         rpt.Pass("Product is Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Share Product", "Product NOT Displayed - For Verify Share Product");
	         rpt.Fail("Product NOT Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		//click("xpath=//*[@id='compareButton_3074457345616727948']"); //compare
		 if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Share Product", "Adding Products To Compare is Displayed - For Verify Share Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Share Product", "Adding Products To Compare NOT Displayed - For Verify Share Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("xpath=//*[@id='sticky']/div/div[1]/div/a"); //share
		if(findTheElement("xpath=//div[@class='share_compare left']//a[@class='blue_button']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Share Product", "Share Button is Displayed - For Verify Share Product");
	         rpt.Pass("Share Button is Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//div[@class='share_compare left']//a[@class='blue_button']"); //share
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Share Product", "Share Button NOT Displayed - For Verify Share Product");
	         rpt.Fail("Share Button NOT Displayed - For Verify Share Product");
	         rpt.Category("CC_Product Comparison - Verify Share Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
   }
   
   //CC_CP_10
   public void verifyEmail()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Product Detail Page is Displayed - For Verify Email Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Product Detail Page NOT Displayed - For Verify Email Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682169_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Product Category Page is Displayed - For Verify Email Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Product Category Page NOT Displayed - For Verify Email Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		//click("xpath=//*[@id='catalogEntry_img3074457345616727848']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Product is Displayed - For Verify Email Product");
	         rpt.Pass("Product is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Product NOT Displayed - For Verify Email Product");
	         rpt.Fail("Product NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		//click("xpath=//*[@id='compareButton_3074457345616727948']"); //compare
		 if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Adding Products To Compare is Displayed - For Verify Email Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Adding Products To Compare NOT Displayed - For Verify Email Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		
		//click("xpath=//*[@id='sticky']/div/div[1]/div/div[2]/a[1]/img"); //email
		if(findTheElement("xpath=//div[@class='share_compare left']//a[@class='email_compare']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Email Button is Displayed - For Verify Email Product");
	         rpt.Pass("Email Button is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='share_compare left']//a[@class='email_compare']"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Email Button NOT Displayed - For Verify Email Product");
	         rpt.Fail("Email Button NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		sendKeys("xpath=//*[@id='shareCompareResult']/input[4]","test");
		//sendKeys("xpath=//*[@id='shareCompareResult']/input[5]","test");
		if(findTheElement("xpath=//*[@id='shareCompareResult']/input[5]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Name Text Box is Displayed - For Verify Email Product");
	         rpt.Pass("Name Text Box is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='shareCompareResult']/input[5]","test");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Name Text Box NOT Displayed - For Verify Email Product");
	         rpt.Fail("Name Text Box NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//sendKeys("xpath=//*[@id='shareCompareResult']/input[6]","zainab.f@royalcyber.com");
		if(findTheElement("xpath=//*[@id='shareCompareResult']/input[6]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Email Product", "Email Id Text Box is Displayed - For Verify Email Product");
	         rpt.Pass("Email Id Text Box is Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='shareCompareResult']/input[6]","zainab.f@royalcyber.com");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Email Product", "Email Id Text Box NOT Displayed - For Verify Email Product");
	         rpt.Fail("Email Id Text Box NOT Displayed - For Verify Email Product");
	         rpt.Category("CC_Product Comparison - Verify Email Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		click("xpath=//button[contains(text(),'SEND')]");
   }

   
   //CC_CP_11
   public void verifyPrint()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Product Detail Page is Displayed - For Verify Print Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Product Detail Page NOT Displayed - For Verify Print Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682169_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Product Category Page is Displayed - For Verify Print Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Product Category Page NOT Displayed - For Verify Print Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		//click("xpath=//*[@id='catalogEntry_img3074457345616727848']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Product is Displayed - For Verify Print Product");
	         rpt.Pass("Product is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Product NOT Displayed - For Verify Print Product");
	         rpt.Fail("Product NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		//click("xpath=//*[@id='compareButton_3074457345616727948']"); //compare
		if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Adding Products To Compare is Displayed - For Verify Print Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Adding Products To Compare NOT Displayed - For Verify Print Product");
	         rpt.Pass("Adding Products To Compare NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("xpath=//*[@id='sticky']/div/div[1]/div/div[2]/a[2]"); //print
		if(findTheElement("xpath=//div[@class='share_compare left']//a[@class='print_compare']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Print Button is Displayed - For Verify Print Product");
	         rpt.Pass("Print Button is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='share_compare left']//a[@class='print_compare']"); //print
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Print Button NOT Displayed - For Verify Print Product");
	         rpt.Fail("Print Button NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }

		Thread.sleep(3000);
	/*	if(findTheElement("cssSelector=button.cancel-popup-button").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Print Product", "Print Button is Displayed - For Verify Print Product");
	         rpt.Pass("Print Button is Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("cssSelector=button.cancel-popup-button"); //print
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Print Product", "Print Button NOT Displayed - For Verify Print Product");
	         rpt.Fail("Print Button NOT Displayed - For Verify Print Product");
	         rpt.Category("CC_Product Comparison - Verify Print Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }*/
		Actions action = new Actions(browser); 
//		String selectAll = Keys.chord(Keys.CONTROL,"w");
		String selectAll = Keys.chord(Keys.CONTROL + "w");
		
		action.sendKeys(selectAll);
 //       action.sendKeys(Keys.LEFT_CONTROL,"w");
        
//		Robot robot = new Robot();  // Robot class throws AWT Exception	
//       Thread.sleep(2000); // Thread.sleep throws InterruptedException	
//		robot.keyPress(KeyEvent.VK_ESCAPE) ;
 //       robot.keyRelease(KeyEvent.VK_ESCAPE) ;
//		driver.switchTo().alert().dismiss();
//		driver.switchTo().window(getWindowHandle());
//		click("xpath=//div[@id=\"print-header\"]//div[@class='Cancel']");
   }
   
   //CC_CP_12
   public void verifyRemove()throws Exception
   {
   	//click("xpath=//*[@id='allDepartmentsButton']/span"); //product
   	if(findTheElement("xpath=//li[1]/.//a[@class='departmentButton']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product Detail Page is Displayed - For Verify Remove Product");
	         rpt.Pass("Product Detail Page is Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//a[@class='departmentButton']"); //product
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product Detail Page NOT Displayed - For Verify Remove Product");
	         rpt.Fail("Product Detail Page NOT Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='departmentLink_3074457345616682169_alt']"); 
		if(findTheElement("xpath=//li[14]/.//a[@class='menuLink']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product Category Page is Displayed - For Verify Remove Product");
	         rpt.Pass("Product Category Page is Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[14]/.//a[@class='menuLink']"); 
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product Category Page NOT Displayed - For Verify Remove Product");
	         rpt.Fail("Product Category Page NOT Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
//		Robot r = new Robot();
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//li[1]/.//div[@class='product_image']");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		//click("xpath=//*[@id='catalogEntry_img3074457345616727848']");
		if(findTheElement("xpath=//li[1]/.//div[@class='product_image']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product is Displayed - For Verify Remove Product");
	         rpt.Pass("Product is Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//li[1]/.//div[@class='product_image']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Remove Product", "Product NOT Displayed - For Verify Remove Product");
	         rpt.Fail("Product NOT Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(4000);
//		for(int i=0; i<6; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }

		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]");
		//click("xpath=//*[@id='compareButton_3074457345616727948']"); //compare
		if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Remove Product", "Adding Products To Compare is Displayed - For Verify Remove Product");
	         rpt.Pass("Adding Products To Compare is Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 	    click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]"); //compare
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Remove Product", "Adding Products To Compare NOT Displayed - For Verify Remove Product");
	         rpt.Fail("Adding Products To Compare NOT Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		//click("xpath=//*[@id='comparePageRemoveItemMain_1']/img"); //remove
		if(findTheElement("xpath=//*[@id='comparePageRemoveItemMain_1']/img").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Remove Product", "Remove Button is Displayed - For Verify Remove Product");
	         rpt.Pass("Remove Button is Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='comparePageRemoveItemMain_1']/img"); //remove
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Remove Product", "Remove Button NOT Displayed - For Verify Remove Product");
	         rpt.Fail("Remove Button NOT Displayed - For Verify Remove Product");
	         rpt.Category("CC_Product Comparison - Verify Remove Product");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
   }
   
   //CC_CP_15
   public void verifySearch()throws Exception
   {
   	//click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
   	 if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Search", "Search Text Box is Displayed - For Verify Search");
	         rpt.Pass("Search Text Box is Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	         click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Search", "Search Text Box NOT  Displayed - For Verify Search");
	         rpt.Fail("Search Text Box NOT Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo");
		if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Search", "Searching for Product is Displayed - For Verify Search");
	         rpt.Pass("Searching for Product is Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","Lenovo");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Search", "Searching for Product NOT Displayed - For Verify Search");
	         rpt.Fail("Searching for Product NOT Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(3000);
		//click("xpath=//*[@id='autoSelectOption_4']/div/img");
		if(findTheElement("xpath=//*[@id='autoSelectOption_4']/div/img").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Search", "Selecting Product is Displayed - For Verify Search");
	         rpt.Pass("Selecting Product is Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		click("xpath=//*[@id='autoSelectOption_4']/div/img");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Search", "Selecting Product NOT Displayed - For Verify Search");
	         rpt.Fail("Selecting Product NOT Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		Thread.sleep(5000);
//		Robot r = new Robot();
//		for(int i=0; i<14; i++) {
//	        r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	    }
		
		Element = findTheElement("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]");
		jse.executeScript("arguments[0].scrollIntoView();", Element);
//		jse.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		click("xpath=//div[@class='owl-item'][1]//label[contains(text(),'Compare')]"); //dell product
		click("xpath=//div[@class='owl-item'][2]//label[contains(text(),'Compare')]"); //lenovo
		//click("xpath=//*[@id='compareButton_3074457345616683133']");
		if(findTheElement("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]").isDisplayed())
		 {
	         rpt.createTest("CC - Product Comparison - Verify Search", "Compare for Product is Displayed - For Verify Search");
	         rpt.Pass("Compare for Product is Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
	 		 click("xpath=//div[@class='owl-item'][1]//a[contains(text(),'Compare')]");
		 }
		 else
		 {
			 rpt.createTest("CC - Product Comparison - Verify Search", "Compare for Product NOT Displayed - For Verify Search");
	         rpt.Fail("Compare for Product NOT Displayed - For Verify Search");
	         rpt.Category("CC_Product Comparison - Verify Search");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
		
   }
}
