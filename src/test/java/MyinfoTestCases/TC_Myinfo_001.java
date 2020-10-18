package MyinfoTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.LoginPage;

public class TC_Myinfo_001 extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void browser() throws IOException, InterruptedException {

		driver = browserSetup();
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(5000);

	}
	// Verify ESS User Login with Valid User name and valid password

	@Test(dataProvider = "testData")

	public void verifyUser(String userName, String passWord) {
		LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys(userName);
		lp.passWord().sendKeys(passWord);
		lp.logInBtn().click();
		if (!driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			Assert.assertTrue(lp.errorMsg().getText().equalsIgnoreCase("Invalid credentials"));
			System.out.println(lp.errorMsg().getText());
		} else {
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("OrangeHRM"));
		}

	}

	@DataProvider(name = "testData")
	public Object[][] getData() {

		Object[][] obj = new Object[1][2];
		obj[0][0] = "Admin";
		obj[0][1] = "admin123";

		return obj;

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
