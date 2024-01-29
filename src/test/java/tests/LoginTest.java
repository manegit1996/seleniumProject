package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProductSearch;
import resources.Base;
import utilities.ExtentReporterDemo;

public class LoginTest extends Base {
	
	
	@BeforeSuite
	public void setUpExtentReports() {
		ExtentReporterDemo.reportSetup();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void openApp() throws IOException, InterruptedException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="enterLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {
		
		ExtentTest landing = extent.createTest("Login Test. Test for my account landing page started..", "myacc landing page");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccount().click();
		Thread.sleep(2000);
		landingPage.loginButton().click();
		Thread.sleep(2000);
		landing.log(Status.INFO, "Successfully came to login page..");
		Thread.sleep(2000);
	
		
		ExtentTest loginInputs = extent.createTest("Login Test.Test for success login", "login test success");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailInput().sendKeys(email);
		loginInputs.log(Status.INFO, "entering valid email address..");
		Thread.sleep(2000);
		loginPage.passwordInput().sendKeys(password);
		loginInputs.log(Status.INFO, "entering valid password..");
		Thread.sleep(2000);
		loginPage.loginButton().click();
		Thread.sleep(2000);

		

		// Testing with wrong credentials
		AccountPage accountPage = new AccountPage(driver);
		String actualResult;
		try {
			Thread.sleep(2000);
			accountPage.editAccInfo().isDisplayed();
			actualResult = "Successfull";
			Thread.sleep(2000);
		
		
		} catch(Exception e) {
			ExtentTest loginFaliure = extent.createTest("Login Test.Test for faliure login", "login faliure");
			actualResult= "Failure";
			loginFaliure.log(Status.FAIL, "Login failed. Wrong credentials..");
			takeScreenshot("Login test",driver);
			
		}
		
		Assert.assertEquals(actualResult, expectedStatus);
	
	}
	
	
	@DataProvider
	public Object[][] enterLoginData() {
		
		Object [][] data = {{"testchat0@gmail.com","test9","Successfull"},{"dummy@test.com","dummy123","Failure"}};
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.close();
		}
	}
	
	@AfterSuite
	public void tearDownExtentReports() {
		
		ExtentReporterDemo.reportTearDow();
	}
	

}
