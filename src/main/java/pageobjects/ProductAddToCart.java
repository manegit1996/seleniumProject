package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddToCart {
	
	WebDriver driver;
	
	public ProductAddToCart(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-quantity")
	WebElement quantity;
	
	public WebElement quantity() {
		return quantity;
	}
	
	@FindBy(id="button-cart")
	WebElement submitButton;
	
	public WebElement submitButton() {
		
		return submitButton;
	}
	
	@FindBy(xpath="//header/div[1]/div[1]/div[3]/div[1]/button[1]")
	WebElement dropdownCart;
	
	public WebElement dropdownCart() {
		
		return dropdownCart;
	}
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]")
	WebElement viewCart;
	
	public WebElement viewCart() {
		
		return viewCart;
	}
}
