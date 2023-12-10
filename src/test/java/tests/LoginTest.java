package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProductSearch;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openApp() throws IOException, InterruptedException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="enterLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {
		

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccount().click();
		landingPage.loginButton().click();
		Thread.sleep(2000);
	
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailInput().sendKeys(email);
		Thread.sleep(2000);
		loginPage.passwordInput().sendKeys(password);
		Thread.sleep(2000);
		loginPage.loginButton().click();
		Thread.sleep(2000);
		
		
		AccountPage accountPage = new AccountPage(driver);
		String actualResult;
		try {
			Thread.sleep(2000);
			accountPage.editAccInfo().isDisplayed();
			actualResult = "Successfull";
			Thread.sleep(2000);
			
		} catch(Exception e) {
			actualResult= "Failure";
		}
		
		Assert.assertEquals(actualResult, expectedStatus);
		
	}
	
	

	@DataProvider
	public Object[][] enterLoginData() {
		
		Object [][] data = {{"testingqa123@gmail.com","testingqa1987","Successfull"},{"dummy@test.com","dummy123","Failure"}};
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.close();
		}
	}
	

}
