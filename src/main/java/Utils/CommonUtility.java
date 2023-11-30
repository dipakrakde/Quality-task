package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonUtility {


	WebDriver driver;

	public static void takeScreenshot(WebDriver driver,String screenShotName) {

	   java.io.File  srcFile = ((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new java.io.File("./TestStepsScreenshots/"+screenShotName+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void verifyTitleOfThePage(WebDriver driver,String expitleOfThepge) {
		String actualTitleoftThepge = driver.getTitle();
		try {
			Assert.assertEquals(actualTitleoftThepge, expitleOfThepge);
			System.out.println("Title of the page varified: Test case passed...");
		} catch (Exception e) {
			System.out.println("Title of the page is not matched: Test case failed......");
		}
	}

	public static void waitForTime(int time ) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickOnElement(WebDriver driver,String path) {
		driver.findElement(By.xpath(path)).click();
	}

	public static void sendData(WebDriver driver,String path,String data) {
		driver.findElement(By.xpath(path)).sendKeys(data);
	}

	public static void verifyPageDisplayed(WebDriver driver,String path) {
		WebElement actualPage = driver.findElement(By.xpath(path));
		try {
			if(actualPage.isDisplayed()) {
				System.out.println("Expected Page displayed: Test case pass... ");
			}
		} catch (Exception e) {
			System.out.println("Expected Page not displayed: Test case fail... ");
		}
	}


}
