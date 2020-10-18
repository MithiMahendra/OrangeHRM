package MyinfoPageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import extentReports.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public String browser, URL;

	public WebDriver browserSetup() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mithi\\eclipse-workspace\\Myinfo\\Resources\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		browser = prop.getProperty("browser");
		URL = prop.getProperty("URL");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\mithi\\eclipse-workspace\\EndToEnd\\Resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@BeforeSuite
	public void setupExtentReports() {
		ExtentReportManager.setExtentReport(Base.getDateTime());
	}

	@AfterTest
	public void blushReport() {
		ExtentReportManager.setBlush();
	}

	public void takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy H:mm:ss");
		String date = sdf.format(d).toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "/Screenshots/" + testCaseName + "_" + date + ".png";
		FileUtils.copyFile(srcFile, new File(destFile));
	}

	public static String getDateTime() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM_dd_yyyy HH:mm:ss");
		String dateTime = df.format(d).replace(" ", "_").replace(":", "_");
		return dateTime;
	}

}
