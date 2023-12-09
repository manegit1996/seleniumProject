package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement emailInput;
	
	@FindBy(id="input-password")
	WebElement passwordInput;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	
	public WebElement emailInput() {
		
		return emailInput;
	}
	
	public WebElement passwordInput() {
		
		return passwordInput;
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}

}
