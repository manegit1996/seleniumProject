package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import utilities.ExtentReporter;
import utilities.ExtentReporterDemo;

//Browser Setup
public class Base extends ExtentReporterDemo{
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		String propPath = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator +
													"resources" + File.separator + "data.properties";
													
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+ File.separator + "screenshots" +testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
	}
}
