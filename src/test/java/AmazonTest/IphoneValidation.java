package AmazonTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AmezonBase.BaseClass;
import Pages.AddToCartPage;
import Pages.ProductPage;
import Pages.SearchPage;
import ReadConfigueFile.ReadPropertyFile;
import Utils.CommonUtility;

public class IphoneValidation extends BaseClass{

	private WebDriver driver;
	private SearchPage   SearchPage;
	private ProductPage ProductPage;
	private AddToCartPage AddToCartPage;
	public  String product = "Iphone";
	
	@BeforeMethod
	public void setUpBrowser() {
		driver = new ChromeDriver();
		logger.info("ChromeBrowser opens successfully ....");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ReadPropertyFile.getappUrl());
		CommonUtility.takeScreenshot(driver, "Amazon open");
		logger.info("Amazon application opens successfully ....");

	}
	
	@Test
	public void TestIphoneVisibility() throws InterruptedException {
		SearchPage = new SearchPage(driver);
		SearchPage.enterProductInSearchBar(product);
		logger.info("product entered in search bar ....");
		CommonUtility.takeScreenshot(driver, "product Entered");
		ProductPage = SearchPage.clickOnIphone();
		logger.info("clicked on Iphone ....");
		CommonUtility.waitForTime(5000);
		ProductPage.clickOnSelectedIphone();
		logger.info("clicked On SelectedIphone ....");
		CommonUtility.takeScreenshot(driver, "SelectedIphone Page");
		CommonUtility.waitForTime(5000);
		String getPrice = ProductPage.getIphonePrice();
		CommonUtility.takeScreenshot(driver, "product Page");
		System.out.println("Price of the Iphone is : " +getPrice);
		logger.info("Got price of the iphone ....");
		ProductPage.clickOnAddToCart();
		CommonUtility.takeScreenshot(driver, "Add Cart Page");
		CommonUtility.waitForTime(5000);
		AddToCartPage = ProductPage.clickOnGoToCart();
		logger.info("clicked On Go To Cart ....");
		CommonUtility.takeScreenshot(driver, "Gon To Cart Page");
		CommonUtility.waitForTime(5000);
		org.testng.Assert.assertTrue(AddToCartPage.verifyIphone());
		logger.info("verified Iphone successfully ....");
		
	}

	@AfterMethod
		public void takesFailedScereenshotTasteCase(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()) {
			CommonUtility.takeScreenshot(driver,result.getName());
			}
		driver.quit();
	    logger.info("*** chromeBrowser closed successfully: Test case ended ***");
	}
	
}
