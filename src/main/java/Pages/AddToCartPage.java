package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	 WebDriver driver;

		public AddToCartPage(WebDriver driver) {
		       this.driver = driver;
		       PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath ="//span[contains(text(),'SAMSUNG Galaxy Z Flip 5 Cell Phone, Unlocked Android Smartphone, 256GB, Compact, Foldable Design, One-Hand Control, Best Selfies, 12MP Camera, Large Cover Screen, U…')]")
		private WebElement addediphone;
		
		public boolean verifyIphone() {
			 return addediphone.isDisplayed();
		}
		
}
