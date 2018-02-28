package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

public class plpModule extends Browser {
	Report rpt = new Report();
	Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	public void executeAll() throws Exception {

		verifyPLPpage();
		addProductsToCompare();
		filterByPrice();
		filterByBadges();
		filterByBrand();
		verifyHyperlink();
		verifyRatings();
		strikeThroughPrice();
		addProductToCart();
		verifyListView();
		verifyGridView();
		verifyPagination();
		verifyShowBy();

	}

	// UI
	public void verifyPLPpage() throws Exception {
		click("xpath=//*[@id='allDepartmentsButton']/span");
		Thread.sleep(3000);
		click("xpath=//*[@id=\'departmentLink_3074457345616682173_alt\']");
		Thread.sleep(2000);
	}

	// CC_PL_06
	public void addProductsToCompare() throws Exception {
		// click("xpath=//*[@id=\'compare_3074457345616726692\']");
		if (findTheElement("xpath=//*[@id=\'compare_3074457345616726692\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 1 to Compare");
			rpt.Pass("Compare Button Displayed - FAdding Product 1 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'compare_3074457345616726692\']");// Product 1
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 1 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 1 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// click("xpath=//*[@id=\'compare_3074457345616726694\']");
		if (findTheElement("xpath=//*[@id=\'compare_3074457345616726694\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 2 to Compare");
			rpt.Pass("Compare Button Displayed - FAdding Product 2 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'compare_3074457345616726694\']");// Product 2
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 2 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 2 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		// click("xpath=//*[@id=\'compare_3074457345616726862\']");
		if (findTheElement("xpath=//*[@id=\'compare_3074457345616726862\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 3 to Compare");
			rpt.Pass("Compare Button Displayed - FAdding Product 3 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'compare_3074457345616726862\']");// Product 3
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 3 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 3 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		r.mouseWheel(13);
		Thread.sleep(6000);

		// click("xpath=//*[@id="compare_3074457345616726864"]");
		if (findTheElement("xpath=//*[@id=\"compare_3074457345616726864\"]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 4 to Compare");
			rpt.Pass("Compare Button Displayed - FAdding Product 4 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\"compare_3074457345616726864\"]");// Product 4
		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Compare Button Displayed - Adding Product 4 to Compare");
			rpt.Fail("Compare Button not Displayed - Adding Product 4 to Compare");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
		// click("xpath=/html/body/div[6]/div/div[2]/a[2]");
		if (findTheElement("xpath=/html/body/div[6]/div/div[2]/a[2]").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Clear all Button Displayed - for closing compare menu");
			rpt.Pass("Clear all Button Displayed -for closing compare menu");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=/html/body/div[6]/div/div[2]/a[2]");// Clearing all products from Compare

		} else {
			rpt.createTest("CC - PLP Module - Add Products to Compare",
					"Clear all Button Displayed - for closing compare menu");
			rpt.Fail("Clear all Button not Displayed -for closing compare menu");
			rpt.Category("CC - PLP Module - Add Products to Compare");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_08
	public void filterByPrice() throws Exception {
		Thread.sleep(2000);
		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by price");
			rpt.Pass("Drop down Displayed - for filter by price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");// Dropdown click

		} else {
			rpt.createTest("CC - PLP Module - Filter by Price", "Drop down Displayed - for filter by price");
			rpt.Fail("Drop down not Displayed - for filter by price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Robot r = new Robot();
		r.mouseWheel(2);
		r.keyPress(KeyboardEvent.DOM_VK_UP);
		Thread.sleep(1000);
		r.keyPress(KeyboardEvent.DOM_VK_UP);
		// r.keyPress(KeyEvent.VK_ENTER);
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Price", "Option Displayed - for filter by price");
			rpt.Pass("Option Displayed - for filter by price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			r.keyPress(KeyEvent.VK_ENTER);// Selecting an option

		} else {
			rpt.createTest("CC - PLP Module - Filter by Price", "Option Displayed - for filter by price");
			rpt.Fail("option not Displayed - for filter by price");
			rpt.Category("CC - PLP Module - Filter by Price");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(8000);

	}

	// CC_PL_09
	public void filterByBadges() throws Exception {

		waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		Thread.sleep(2000);
		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Drop down Displayed - for filter by Badges(Name)");
			rpt.Pass("Drop down Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");// Dropdown click

		} else {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Drop down Displayed - for filter by Badges(Name)");
			rpt.Fail("Drop down not Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		Robot r = new Robot();
		Thread.sleep(2000);
		r.keyPress(KeyboardEvent.DOM_VK_UP);
		Thread.sleep(3000);

		// r.keyPress(KeyEvent.VK_ENTER);
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Drop down Displayed - for filter by Badges(Name)");
			rpt.Pass("Drop down Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			r.keyPress(KeyEvent.VK_ENTER);

		} else {
			rpt.createTest("CC - PLP Module - Filter by Badges(Name)",
					"Drop down Displayed - for filter by Badges(Name)");
			rpt.Fail("Drop down not Displayed - for filter by Badges(Name)");
			rpt.Category("CC - PLP Module - Filter by Badges(Name)");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		// waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
	}

	// CC_PL_10
	public void filterByBrand() throws Exception {
		Thread.sleep(6000);
		waitForPageElementToLoad("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		// click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
			rpt.Pass("Drop down Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']");

		} else {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
			rpt.Fail("Drop down not Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyboardEvent.DOM_VK_UP);
		Thread.sleep(2000);
		// r.keyPress(KeyEvent.VK_ENTER);
		if (findTheElement("xpath=//*[@id=\'orderBy_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
			rpt.Pass("Drop down Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			r.keyPress(KeyEvent.VK_ENTER);

		} else {
			rpt.createTest("CC - PLP Module - Filter by Brand", "Drop down Displayed - for filter by Brand");
			rpt.Fail("Drop down not Displayed - for filter by Brand");
			rpt.Category("CC - PLP Module - Filter by Brand");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(4000);
	}

	// CC_PL_11
	public void verifyRatings() throws Exception {
		Thread.sleep(2000);
		if (findTheElement(
				"xpath=/hmtl/body/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/div[4]/div/section/section/section[1]/div/div[1]")
						.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify ratings", "Ratings Displayed - for verify ratings");
			rpt.Pass("Ratings Displayed - for verify ratings");
			rpt.Category("CC - PLP Module - verify ratings");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module - verify ratings", "Ratings Displayed - for verify ratings");
			rpt.Fail("Ratings not Displayed - for verify ratings");
			rpt.Category("CC - PLP Module - verify ratings");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_12
	public void verifyHyperlink() throws Exception {
		Thread.sleep(4000);
		// click("xpath=//*[@id="WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616684172_link_9b"]");
		if (findTheElement("xpath=//*[@id=\"WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616684172_link_9b\"]")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify hyperlink", "hyperlink Displayed - for verify hyperlink");
			rpt.Pass("hyperlink Displayed - for verify hyperlink");
			rpt.Category("CC - PLP Module - verify hyperlink");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\"WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616684172_link_9b\"]");

		} else {
			rpt.createTest("CC - PLP Module - verify hyperlink", "Ratings Displayed - for verify hyperlink");
			rpt.Fail("hyperlink not Displayed - for verify hyperlink");
			rpt.Category("CC - PLP Module - verify hyperlink");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		browser.navigate().back();
		Thread.sleep(3000);

	}

	// CC_PL_13
	public void addProductToCart() throws Exception {
		click("xpath=//*[@id=\'listViewAdd2Cart_3074457345616726692\']");
		if (findTheElement("xpath=//*[@id=\'listViewAdd2Cart_3074457345616726692\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - Adding product to cart",
					" Buy now Button Displayed - Adding product to cart");
			rpt.Pass(" Buy now Button Displayed - Adding product to cart");
			rpt.Category("CC - PLP Module - Adding product to cart");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("xpath=//*[@id=\'listViewAdd2Cart_3074457345616726692\']");

		} else {
			rpt.createTest("CC - PLP Module - Adding product to cart",
					" Buy now Button Displayed - Adding product to cart");
			rpt.Fail(" Buy now Button not Displayed - Adding product to cart");
			rpt.Category("CC - PLP Module - Adding product to cart");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(1000);
		click("xpath=//*[@id=\"MiniShopCartCloseButton_2\"]");
		Thread.sleep(4000);
	}

	// CC_PL_15
	public void strikeThroughPrice() throws Exception {
		if (findTheElement("xpath=//*[@id=\'listPrice_3074457345616726864\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Strike through Price",
					"Strike through Price Displayed - for verify Strike through Price");
			rpt.Pass("Strike through Price Displayed - for verify Strike through Price");
			rpt.Category("CC - PLP Module - verify Strike through Price");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);

		} else {
			rpt.createTest("CC - PLP Module - verify Strike through Price",
					"Strike through Price Displayed - for verify Strike through Price");
			rpt.Fail("Strike through Price not Displayed - for verify Strike through Price");
			rpt.Category("CC - PLP Module - verify Strike through Price");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
	}

	// CC_PL_18
	public void verifyListView() throws Exception {
		// click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_list_categoryResults\']");
		if (findTheElement("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_list_categoryResults\']")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify List_View", "List_View option Displayed - for verify List_View");
			rpt.Pass("List_View option Displayed - for verify List_View");
			rpt.Category("CC - PLP Module - verify List_View");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_list_categoryResults\']");

		} else {
			rpt.createTest("CC - PLP Module - verify List_View", "List_View option Displayed - for verify List_View");
			rpt.Fail("List_View option not Displayed - for verify List_View");
			rpt.Category("CC - PLP Module - verify List_View");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_19
	public void verifyGridView() throws Exception {
		// click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults\']");
		if (findTheElement("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults\']")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Grid_View", "Grid_View option Displayed - for verify Grid_View");
			rpt.Pass("Grid_View option Displayed - for verify Grid_View");
			rpt.Category("CC - PLP Module - verify Grid_View");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("xpath=//*[@id=\'WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults\']");

		} else {
			rpt.createTest("CC - PLP Module - verify Grid_View", "Grid_View option Displayed - for verify Grid_View");
			rpt.Fail("Grid_View option not Displayed - for verify Grid_View");
			rpt.Category("CC - PLP Module - verify Grid_View");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_20
	public void verifyPagination() throws Exception {
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Robot r = new Robot();
		for (int sec = 1; sec < 10; sec++) {
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}
		Thread.sleep(15000);
		// click("xpath=//*[@id=\"WC_SearchBasedNavigationResults_pagination_link_2_categoryResults\"]");
		if (findTheElement("xpath=//*[@id=\"WC_SearchBasedNavigationResults_pagination_link_2_categoryResults\"]")
				.isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify Pagination",
					"Pagination option Displayed - for verify Pagination");
			rpt.Pass("Pagination option Displayed - for verify Pagination");
			rpt.Category("CC - PLP Module - verify Pagination");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("xpath=//*[@id=\"WC_SearchBasedNavigationResults_pagination_link_2_categoryResults\"]");

		} else {
			rpt.createTest("CC - PLP Module - verify Pagination",
					"Pagination option Displayed - for verify Pagination");
			rpt.Fail("Pagination option not Displayed - for verify Pagination");
			rpt.Category("CC - PLP Module - verify Pagination");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(3000);
	}

	// CC_PL_21
	public void verifyShowBy() throws Exception {
		// click("xpath=//*[@id=\'pageSize_4_-3011_3074457345618265606-button\']");
		if (findTheElement("xpath=//*[@id=\'pageSize_4_-3011_3074457345618265606-button\']").isDisplayed()) {
			rpt.createTest("CC - PLP Module - verify ShowBy", "ShowBy option Displayed - for verify ShowBy");
			rpt.Pass("ShowBy option Displayed - for verify ShowBy");
			rpt.Category("CC - PLP Module - verify ShowBy");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			click("xpath=//*[@id=\'pageSize_4_-3011_3074457345618265606-button\']");

		} else {
			rpt.createTest("CC - PLP Module - verify ShowBy", "ShowBy option Displayed - for verify ShowBy");
			rpt.Fail("ShowBy option not Displayed - for verify ShowBy");
			rpt.Category("CC - PLP Module - verify ShowBy");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyboardEvent.DOM_VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);

	}

}
