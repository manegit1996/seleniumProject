package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearch {
	
	WebDriver driver;
	
	public ProductSearch(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement searchProduct;
	
	
	public WebElement searchProduct() {
		
		return searchProduct;
	}
	
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	WebElement searchButton;
	
	public WebElement searchButton() {
		
		return searchButton;
	}
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement productName;
	
	public WebElement productName() {
		
		return productName;
	}
	
}
