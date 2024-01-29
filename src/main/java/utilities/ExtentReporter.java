/*package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporter {
	
static ExtentReports extentReport;
	
		public static ExtentReports getExtentReport() {
			
			String extentReportPath = System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "extentreport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
			reporter.config().setReportName("Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			extentReport = new ExtentReports();
			extentReport.attachReporter(reporter);
			extentReport.setSystemInfo("Operating System","Windows 10");
			extentReport.setSystemInfo("Tested By","Nikola");
			
			return extentReport;
		
	}

}
*/
