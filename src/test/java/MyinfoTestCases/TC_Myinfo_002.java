package MyinfoTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.LoginPage;
import org.junit.Assert;

public class TC_Myinfo_002 extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void browser() throws IOException, InterruptedException {
		driver = browserSetup();
		driver.manage().window().maximize();
		Thread.sleep(5000);

	}

	@Test(dataProvider = "getData")
	public void verifyUser(String userName3, String passWord3) {
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys(userName3);
		lp.passWord().sendKeys(passWord3);
		lp.logInBtn().click();

		Assert.assertEquals(lp.errorMsg().getText(), "Invalid credentials");

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		Object[][] obj = new Object[3][2];
		obj[0][0] = "Adminadmin";
		obj[0][1] = "admin123";
		obj[1][0] = "Admin123";
		obj[1][1] = "admin123";
		obj[2][0] = "Adminadmin";
		obj[2][1] = "admin12345";
		return obj;
	}
	@AfterTest
	public void teatDown() {
		System.out.println("Browsers are closed");
		driver.quit();
	}
}
