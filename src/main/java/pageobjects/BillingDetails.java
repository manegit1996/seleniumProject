package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingDetails {
	WebDriver driver;
	
	public BillingDetails(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-payment-firstname")
	WebElement firstName;
	
	public WebElement firstName() {
		return firstName;
	}
	
	@FindBy(id="input-payment-lastname")
	WebElement lastName;
	
	public WebElement lastName() {
		return lastName;
	}
	
	@FindBy(id="input-payment-company")
	WebElement company;
	
	public WebElement company() {
		return company;
	}
	
	@FindBy(id="input-payment-address-1")
	WebElement adressOne;
	
	public WebElement adressOne() {
		return adressOne;
	}
	
	@FindBy(id="input-payment-city")
	WebElement city;
	
	public WebElement city() {
		return city;
	}
	
	@FindBy(id="input-payment-postcode")
	WebElement postCode;
	
	public WebElement postCode() {
		return postCode;
	}
	
	@FindBy(xpath="//option[contains(text(),'United States')][1]")
	WebElement country;
	
	public WebElement country() {
		return country;
	}
	
	@FindBy(id="input-payment-zone")
	WebElement region;
	
	public WebElement region() {
		return region;
	}
	
	@FindBy(id="button-payment-address")
	WebElement continiue;
	
	public WebElement continiue() {
		return continiue;
	}
	
	@FindBy(name="comment")
	WebElement addComment;
	
	public WebElement addComment() {
		return addComment;
		
	}
	
	@FindBy(id="button-payment-method")
	WebElement confirmComment;
	
	public WebElement confirmComment() {
		return confirmComment;
	}
	
	@FindBy(name="agree")
	WebElement agreeTearms;
	
	public WebElement agreeTearms() {
		return agreeTearms;
	}
}
