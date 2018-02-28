package Test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Search extends Browser
{
	//public WebDriver browser = BrowserFactory.getBrowser("Browser","url");
	//WebDriver driver=new FirefoxDriver();
	 Report rpt  = new Report();
	
	public void execute_Alltestcases()throws Exception
	{
		verify_searchPageUI();
		verify_nosearch();
		alreadySearched();
		searchWithPname();
		searchWithItemNo();
		searchWithKeyword();
		searchWithDescription();
		searchWithCategoryname();
		//verifyDiscontinuedProducts();
		searchRelevance();
	    searchResultPage();
		verifyinvalidInput();
		verifySpecialCharacter();
		ConfinedSearch();
		spellChecker();
		categoryPage();
		//advancedSearch();
		typeAhead();
		sortingSearch();
		itemPerPage();
		
	}
	
	public void verify_searchPageUI()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
        Thread.sleep(2000);
    if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
      {
        rpt.createTest("CC - Search - Verify Search Product", "Product is Displayed - For Verify Search Product");
	    rpt.Pass("Product Displayed - For Verify Search Product");
		rpt.Category("CC_Search - Verify Search Product");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
	  }
   else 
	  {
	    rpt.createTest("CC - Search - Verify Search Product", "Product NOT Displayed - For Verify Search Product");
	    rpt.Fail("Product Displayed - For Verify Search Product");
		rpt.Category("CC_Search - Verify Search Product");
	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
	    rpt.imgPathFail(path);
	  }  	
	}
	public void verify_nosearch()throws Exception
	{

        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","");
        Thread.sleep(2000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify NO Search Product", "Product Displayed - For Verify NO Search Product");
	    rpt.Pass("Product Displayed - For Verify NO Search Product");
		rpt.Category("CC_Search - Verify NO Search Product");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
        }
        else
        {
        	rpt.createTest("CC - Search - Verify NO Search Product", "Product NOT Displayed - For Verify NO Search Product");
     	    rpt.Fail("Product Displayed - For Verify NO Search Product");
     		rpt.Category("CC_Search - Verify NO Search Product");
     	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
     	    rpt.imgPathFail(path);
        }
	}
	public void alreadySearched()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
        findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Already Searched Product", "Product Displayed - For Verify Already Searched Product");
	    rpt.Pass("Product Displayed - For Verify Already Searched Product");
		rpt.Category("CC_Search - Verify Already Searched Product");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
        }
        else
        {
        	 rpt.createTest("CC - Search - Verify Already Searched Product", "Product NOT Displayed - For Verify Already Searched Product");
     	    rpt.Fail("Product Displayed - For Verify Already Searched Product");
     		rpt.Category("CC_Search - Verify Already Searched Product");
     	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
     	    rpt.imgPathFail(path);
        }
	}
	public void searchWithPname()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Search With Product Name", "Product Displayed - For Verify Search With Product Name");
	    rpt.Pass("Product Displayed - For Verify Search With Product Name");
		rpt.Category("CC_Search - Verify Search With Product Name");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
        }
        else
        {
        	rpt.createTest("CC - Search - Verify Search With Product Name", "Product NOT Displayed - For Verify Search With Product Name");
    	    rpt.Fail("Product Displayed - For Verify Search With Product Name");
    		rpt.Category("CC_Search - Verify Search With Product Name");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }
    }
	public void searchWithItemNo()throws Exception
	{
	    click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
	    findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","1200");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Search With Item No", "Product Displayed - For Verify Search With Item No");
	    rpt.Pass("Product Displayed - For Verify Search With Item No");
		rpt.Category("CC_Search - Verify Search With Item No");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
        }
        else
	    {
        	rpt.createTest("CC - Search - Verify Search With Item No", "Product NOT Displayed - For Verify Search With Item No");
    	    rpt.Fail("Product Displayed - For Verify Search With Item No");
    		rpt.Category("CC_Search - Verify Search With Item No");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
	    }
	}
	public void searchWithKeyword()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
        findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","len");	
		Thread.sleep(2000);
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);
       if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
       {
       rpt.createTest("CC - Search - Verify Search With Keyword", "Product Displayed - For Verify Search With Keyword");
	    rpt.Pass("Product Displayed - For Verify Search With Keyword");
		rpt.Category("CC_Search - Verify Search With Keyword");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
       }
       else
       {
    	   rpt.createTest("CC - Search - Verify Search With Keyword", "Product NOT Displayed - For Verify Search With Keyword");
   	    rpt.Pass("Product Displayed - For Verify Search With Keyword");
   		rpt.Category("CC_Search - Verify Search With Keyword");
   	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	    rpt.imgPathFail(path);
       }
	}
	public void searchWithDescription()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
        findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","speaker");	
		Thread.sleep(2000);
	   click("xpath=//*[@id='autoSelectOption_0']");	
       Thread.sleep(4000);
       if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
       {
       rpt.createTest("CC - Search - Verify Search With Description", "Product Displayed - For Verify Search With Description");
	    rpt.Pass("Product Displayed - For Verify Search With Description");
		rpt.Category("CC_Search - Verify Search With Description");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
       }
       else
       {
    	   rpt.createTest("CC - Search - Verify Search With Description", "Product NOT Displayed - For Verify Search With Description");
   	    rpt.Fail("Product Displayed - For Verify Search With Description");
   		rpt.Category("CC_Search - Verify Search With Description");
   	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	    rpt.imgPathFail(path);
       }
	}
	public void searchWithCategoryname()throws Exception
	{
     click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
     findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","TV");	
		Thread.sleep(2000);
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);
       if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
       {
       rpt.createTest("CC - Search - Verify Search With Category Name", "Product Displayed - For Verify Search With Category Name");
	    rpt.Pass("Product Displayed - For Verify Search With Category Name");
		rpt.Category("CC_Search - Verify Search With Category Name");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
       }
       else
       {
    	   rpt.createTest("CC - Search - Verify Search With Category Name", "Product NOT Displayed - For Verify Search With Category Name");
   	    rpt.Fail("Product Displayed - For Verify Search With Category Name");
   		rpt.Category("CC_Search - Verify Search With Category Name");
   	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	    rpt.imgPathFail(path);
       }
	}
	/*public void verifyDiscontinuedProducts()throws Exception
	{
		click("xpath=//*[@id='searchBox']");
		

	}*/
	
	public void searchRelevance()throws Exception
	{
       click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
       findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","speaker");	
		Thread.sleep(2000);
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);
       if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
       {
       rpt.createTest("CC - Search - Verify Search With Relevance", "Product Displayed - For Verify Search With Relevance");
	    rpt.Pass("Product Displayed - For Verify Search With Relevance");
		rpt.Category("CC_Search - Verify Search With Relevance");
	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	    rpt.imgPathPass(path);
       }
       else
       {
    	   rpt.createTest("CC - Search - Verify Search With Relevance", "Product NOT Displayed - For Verify Search With Relevance");
   	    rpt.Fail("Product Displayed - For Verify Search With Relevance");
   		rpt.Category("CC_Search - Verify Search With Relevance");
   	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	    rpt.imgPathFail(path);
       }
	}
	
	public void searchResultPage()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");	
			Thread.sleep(2000);
		   click("xpath=//*[@id='autoSelectOption_0']");
	        Thread.sleep(4000);
	        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
	        {
	        rpt.createTest("CC - Search - Verify Search Result Page", "Product Displayed - For Verify Search Result Page");
	 	    rpt.Pass("Product Displayed - For Verify Result Page");
	 		rpt.Category("CC_Search - Verify Search Result Page");
	 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	 	    rpt.imgPathPass(path);
	        }
	        else
	        {
	     	   rpt.createTest("CC - Search - Verify Search Result Page", "Product NOT Displayed - For Verify Search Result Page");
	    	    rpt.Fail("Product Displayed - For Verify Search Result Page");
	    		rpt.Category("CC_Search - Verify Search Result Page");
	    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
	    	    rpt.imgPathFail(path);
	        }

	}
	public void verifyinvalidInput()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","!@#");
	        Thread.sleep(4000);
	        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
	        {
	        rpt.createTest("CC - Search - Verify Search With Invalid Input", "Product Displayed - For Verify Search Search With Invalid Input");
	 	    rpt.Pass("Product Displayed - For Verify Search With Invalid Input");
	 		rpt.Category("CC_Search - Verify Search Search With Invalid Input");
	 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	 	    rpt.imgPathPass(path);
	        }
	        else
	        {
	     	   rpt.createTest("CC - Search - Verify Search With Invalid Input", "Product NOT Displayed - For Verify Search With Invalid Input");
	    	    rpt.Fail("Product Displayed - For Verify Search With Invalid Input");
	    		rpt.Category("CC_Search - Verify Search With Invalid Input");
	    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
	    	    rpt.imgPathFail(path);
	        }
			/*Boolean errorMsg=findTheElement("xpath=//*[@id='PageHeading_5_-3014_2306']/h1").isDisplayed();
			 if(errorMsg)
	         {
	           System.out.println("Message Displayed:"+ errorMsg);
			//test = rpt.createTest("Circuit_City-Search, CIRCUIT CITY - Search :Error Message Displayed for invalid input:", errorMsg);

	           
	          }
	        else
	        {
	           System.out.println("Error Message NOT Displayed");
				//test = rpt.createTest("Circuit_City-Search, CIRCUIT CITY - Search :Error Message NOT Displayed for invalid input");

	        	
	         }*/

	}
	public void verifySpecialCharacter()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		 findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","***");	
	        Thread.sleep(4000);
	        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
	        {
	        rpt.createTest("CC - Search - Verify Search With Invalid Input - Special Character", "Product Displayed - For Verify Search Search With Invalid Input - Special Character");
	 	    rpt.Pass("Product Displayed - For Verify Search With Invalid Input - Special Character");
	 		rpt.Category("CC_Search - Verify Search Search With Invalid Input - Special Character");
	 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
	 	    rpt.imgPathPass(path);
	        }
	        else
	        {
	     	   rpt.createTest("CC - Search - Verify Search With Invalid Input - Special Character", "Product NOT Displayed - For Verify Search With Invalid Input - Special Character");
	    	    rpt.Fail("Product Displayed - For Verify Search With Invalid Input - Special Character");
	    		rpt.Category("CC_Search - Verify Search With Invalid Input - Special Character");
	    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
	    	    rpt.imgPathFail(path);
	        }
			/*Boolean errorMsg=findTheElement("xpath=//*[@id='errorPage']/h1").isDisplayed();
			 if(errorMsg)
	         {
	           System.out.println("Message Displayed:"+ errorMsg);
	           //test = extent.createTest("CIRCUIT CITY - Search :Error Message Displayed for special character:", errorMsg);

	          }
	        else
	        {
	           System.out.println("Error Message NOT Displayed");
	           //test = extent.createTest("CIRCUIT CITY - Search :Error Message NOT Displayed for special character");

	         }*/

	}
	public void ConfinedSearch()throws Exception
	{

		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Confined Search", "Product Displayed - For Verify Confined Search");
 	    rpt.Pass("Product Displayed - For Verify Confined Search ");
 		rpt.Category("CC_Search - Verify Confined Search");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Confined Search", "Product NOT Displayed - For Verify Confined Search");
    	    rpt.Fail("Product Displayed - For Verify Confined Search");
    		rpt.Category("CC_Search - Verify Confined Search");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }
	}
	public void spellChecker()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenov");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Spell Checker ", "Product Displayed - For Verify Spell Checker ");
 	    rpt.Pass("Product Displayed - For Verify Spell Checker ");
 		rpt.Category("CC_Search - Verify Spell Checker ");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Spell Checker ", "Product NOT Displayed - For Verify Spell Checker ");
    	    rpt.Fail("Product Displayed - For Verify Spell Checker ");
    		rpt.Category("CC_Search - Verify Spell Checker ");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }

	}
	public void categoryPage()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","monitor");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Category Page", "Product Displayed - For Verify Category Page");
 	    rpt.Pass("Product Displayed - For Verify Category Page");
 		rpt.Category("CC_Search - Verify Category Page");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Category Page", "Product NOT Displayed - For Verify Category Page");
    	    rpt.Pass("Product Displayed - For Verify Category Page");
    		rpt.Category("CC_Search - Verify Category Page");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }
	}
	/*public void advancedSearch()throws Exception
	{
		click("xpath=//*[@id='searchBox']");
		

	}*/
	public void typeAhead()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","sam");	
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Type Ahead", "Product Displayed - For Verify Type Ahead");
 	    rpt.Pass("Product Displayed - For Verify Type Ahead");
 		rpt.Category("CC_Search - Verify Type Ahead");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Type Ahead", "Product NOT Displayed - For Verify Type Ahead");
    	    rpt.Fail("Product Displayed - For Verify Type Ahead");
    		rpt.Category("CC_Search - Verify Type Ahead");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }

	}
	public void sortingSearch()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
		//click("xpath=//*[@id='orderBy_6_-3011_2310-button']");
		//click("xpath=//*[@id='orderBy_6_-3011_2310-button']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Sorting Search", "Product Displayed - For Verify Sorting Search");
 	    rpt.Pass("Product Displayed - For Verify Sorting Search");
 		rpt.Category("CC_Search - Verify Sorting Search");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Sorting Search", "Product NOT Displayed - For Verify Sorting Search");
    	    rpt.Fail("Product Displayed - For Verify Sorting Search");
    		rpt.Category("CC_Search - Verify Sorting Search");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }
	}
	public void itemPerPage()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").clear();
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");
		Thread.sleep(2000);
		click("xpath=//*[@id='autoSelectOption_0']");
		//click("xpath=//*[@id='pageSize_6_-3011_2310-button']");
		//click("xpath=//*[@id='pageSize_6_-3011_2310-button']");
        Thread.sleep(4000);
        if(findTheElement("xpath=//*[@id='SimpleSearchForm_SearchTerm']").isDisplayed())
        {
        rpt.createTest("CC - Search - Verify Items Per Page", "Product Displayed - For Verify Items Per Page");
 	    rpt.Pass("Product Displayed - For Verify Items Per Page");
 		rpt.Category("CC_Search - Verify Items Per Page");
 	    String path = rpt.CaptureScreen(browser, "ValidMessage");
 	    rpt.imgPathPass(path);
        }
        else
        {
     	   rpt.createTest("CC - Search - Verify Items Per Page", "Product NOT Displayed - For Verify Items Per Page");
    	    rpt.Fail("Product Displayed - For Verify Items Per Page");
    		rpt.Category("CC_Search - Verify Items Per Page");
    	    String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	    rpt.imgPathFail(path);
        }

	}
	
	
	
	
}
