package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtentReport(String dateTime) {
		String path= (System.getProperty("user.dir"))+"/test-output/"+dateTime+".html";
		htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setDocumentTitle("AutomationTestReports");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "Mahendra");
		extent.setSystemInfo("BrowserName", "Chrome");
		
	}
	public static void setBlush() {
		extent.flush();
	}

}
