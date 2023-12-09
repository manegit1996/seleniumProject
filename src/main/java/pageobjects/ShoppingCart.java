package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	WebDriver driver;
	
	public ShoppingCart(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/input[1]")
	WebElement quantityInput;
	
	public WebElement quantityInput() {
		
		return quantityInput;
	}
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	public WebElement checkoutButton() {
		
		return checkoutButton;
	}

}

