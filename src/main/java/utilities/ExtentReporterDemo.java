package utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterDemo {
	
	static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	@BeforeSuite
	public static ExtentReports reportSetup() {
		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
		
	}
	
	@AfterSuite
	public static void reportTearDow() {
		
		extent.flush();
	}


}
