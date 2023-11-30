package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	
	  WebDriver driver;

		public SearchPage(WebDriver driver) {
		       this.driver = driver;
		       PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
		private WebElement entersIphone;

		@FindBy(xpath = "//div[@class='left-pane-results-container']//descendant::div[@aria-label='iphone 15']")
		private WebElement clickOnSelectedIphone;
		
		public void enterProductInSearchBar(String entertext) {
			entersIphone.sendKeys(entertext);
		}	
		
		public ProductPage clickOnIphone() {
			clickOnSelectedIphone.click();
			return new ProductPage(driver);
		}		
}
