package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
	public void productTest(String email, String password) throws InterruptedException, IOException { 
		
		ExtentTest loginNav = extent.createTest("Product Test. Navigating to login page..", "login page");
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
		loginNav.log(Status.INFO, "Successfully login to proucts page..");
		Thread.sleep(2000);
		

		
		ProductSearch productSearch = new ProductSearch(driver);
		ExtentTest inputProduct = extent.createTest("Product Test. Searching product name in input..", "product in input");
		productSearch.searchProduct().sendKeys("MacBook");
		inputProduct.log(Status.INFO, "entering product name..");
		Thread.sleep(2000);
		productSearch.searchButton().click();
		Thread.sleep(2000);
		
		if(productSearch.productName().isDisplayed()) {
			Thread.sleep(2000);
			productSearch.productName().click();
			Thread.sleep(2000);
			inputProduct.log(Status.INFO, "clicking on product..");
		} else {
			
			System.out.println("There is no souch an Element");
			inputProduct.log(Status.ERROR, "there is no souch a product..");
			takeScreenshot("Product test",driver);
			
		}
		
		
		ProductAddToCart addToCart = new ProductAddToCart(driver);
		ExtentTest addTocartProd = extent.createTest("Product Test. Adding product to cart..", "adding to cart");
		Thread.sleep(2000);
		addToCart.quantity().clear();
		Thread.sleep(2000);
		addToCart.quantity().sendKeys("1");
		addTocartProd.log(Status.INFO, "adding quantity for product..");
		Thread.sleep(2000);
		addToCart.submitButton().click();
		addTocartProd.log(Status.INFO, "submiting the product..");
		Thread.sleep(2000);
		addToCart.dropdownCart().click();
		Thread.sleep(2000);
		addToCart.viewCart().click();
		addTocartProd.log(Status.INFO, "clicking on cart..");
		
		
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		ExtentTest cartProduct = extent.createTest("Cart Test, cart page..", "on cart page");
		shoppingCart.quantityInput().clear();
		Thread.sleep(2000);
		shoppingCart.quantityInput().sendKeys("1");
		cartProduct.log(Status.INFO, "entering quiantity of product in cart..");
		Thread.sleep(2000);
		shoppingCart.checkoutButton().click();
		cartProduct.log(Status.INFO, "cart checkout..");
		
		
		Thread.sleep(2000);
		BillingDetails billingDetails = new BillingDetails(driver);
		ExtentTest billingDet = extent.createTest("Billing Test, billing page..", "bill page");
		billingDet.log(Status.INFO, "entering required credentials for billing..");
		billingDetails.firstName().sendKeys("Test Name Credentials");
		Thread.sleep(2000);
		billingDetails.lastName().sendKeys("Test Last Name Credentials");
		//Thread.sleep(2000);
		billingDetails.company().sendKeys("Test Company Credentials");
		Thread.sleep(2000);
		billingDetails.adressOne().sendKeys("Adress One Credentials");
		//Thread.sleep(2000);
		billingDetails.city().sendKeys("City Credentials");
		Thread.sleep(2000);
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
		billingDet.log(Status.INFO, "payment card requiered..");
	}
	
	@DataProvider
	public Object[][] enterLoginData() {
		
		Object [][] data = {{"selenumtest888@gmail.com","seleniumtest888"}};
		
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
