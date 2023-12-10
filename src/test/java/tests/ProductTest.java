package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.BillingDetails;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProductAddToCart;
import pageobjects.ProductSearch;
import pageobjects.ShoppingCart;
import resources.Base;

public class ProductTest extends Base {
	
	public WebDriver driver;
	@BeforeMethod
	public void openApp() throws IOException, InterruptedException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}

	@Test(dataProvider="enterLoginData")
	public void productTest(String email, String password) throws InterruptedException { 
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccount().click();
		Thread.sleep(2000);
		landingPage.loginButton().click();
		Thread.sleep(2000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailInput().sendKeys(email);
		loginPage.passwordInput().sendKeys(password);
		Thread.sleep(2000);
		loginPage.loginButton().click();
		Thread.sleep(2000);
		
		//Screenshot failure test
		//Assert.assertTrue(false);
		
		ProductSearch productSearch = new ProductSearch(driver);
		productSearch.searchProduct().sendKeys("MacBook");
		Thread.sleep(2000);
		productSearch.searchButton().click();
		Thread.sleep(2000);
		
		if(productSearch.productName().isDisplayed()) {
			Thread.sleep(2000);
			productSearch.productName().click();
			Thread.sleep(2000);
		} else {
			
			System.out.println("There is no souch an Element");
		}
		
		
		ProductAddToCart addToCart = new ProductAddToCart(driver);
		Thread.sleep(2000);
		addToCart.quantity().clear();
		Thread.sleep(2000);
		addToCart.quantity().sendKeys("1");
		Thread.sleep(2000);
		addToCart.submitButton().click();
		Thread.sleep(2000);
		addToCart.dropdownCart().click();
		Thread.sleep(2000);
		addToCart.viewCart().click();
		
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.quantityInput().clear();
		Thread.sleep(2000);
		shoppingCart.quantityInput().sendKeys("1");
		Thread.sleep(2000);
		shoppingCart.checkoutButton().click();
		
		Thread.sleep(2000);
		BillingDetails billingDetails = new BillingDetails(driver);
		billingDetails.firstName().sendKeys("Test Name Credentials");
		//Thread.sleep(2000);
		billingDetails.lastName().sendKeys("Test Last Name Credentials");
		//Thread.sleep(2000);
		billingDetails.company().sendKeys("Test Company Credentials");
		//Thread.sleep(2000);
		billingDetails.adressOne().sendKeys("Adress One Credentials");
		//Thread.sleep(2000);
		billingDetails.city().sendKeys("City Credentials");
		//Thread.sleep(2000);
		billingDetails.postCode().sendKeys("Post Code Credentials");
		//Thread.sleep(2000);
		billingDetails.country().click();
		Thread.sleep(2000);
		billingDetails.region().click();
		Thread.sleep(2000);
		billingDetails.region().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		billingDetails.region().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		billingDetails.continiue().click();
		Thread.sleep(2000);
		billingDetails.addComment().sendKeys("Adding the comment...");
		billingDetails.agreeTearms().click();
		Thread.sleep(2000);
		billingDetails.confirmComment().click();
	}
	
	@DataProvider
	public Object[][] enterLoginData() {
		
		Object [][] data = {{"testingqa123@gmail.com","testingqa1987"}};
		return data;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		if(driver != null) {
			driver.close();
		}
	}

}
