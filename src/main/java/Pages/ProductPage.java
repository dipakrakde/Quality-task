package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	
	 WebDriver driver;

		public ProductPage(WebDriver driver) {
		       this.driver = driver;
		       PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath ="//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='6']")
		private WebElement selectIphone;
		

		@FindBy(xpath ="//div[@class='a-box-inner']//descendant::span[@data-a-size='xl']")
		private WebElement iphonePrice;
		
		@FindBy(xpath ="//input[@id='add-to-cart-button']")
		private WebElement selectAddToCart;
		

		@FindBy(xpath ="//div[@id='sw-atc-buy-box']//span[@class='a-button-inner']//a[contains(text(),'Go to Cart')]")
		private WebElement selectGoToCart;
		
		public void clickOnSelectedIphone() {
			selectIphone.click();
		}
		
		public String getIphonePrice() {
			return iphonePrice.getText();
		}
		
		public void clickOnAddToCart() {
			selectAddToCart.click();
		}
		
		public AddToCartPage clickOnGoToCart() {
			selectGoToCart.click();
			return new AddToCartPage(driver);
		}
}
