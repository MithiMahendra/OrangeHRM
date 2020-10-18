package MyinfoTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.HomePage;
import MyinfoPageObjects.LoginPage;

public class TC_Myinfo_003 extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void browser() throws IOException, InterruptedException {

		driver = browserSetup();
		driver.get(URL);
		Thread.sleep(5000);

	}

	@Test(dataProvider = "getData")
	public void verifyContactDetails(String userName, String passWord) {
		LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys(userName);
		lp.passWord().sendKeys(passWord);
		lp.logInBtn().click();
		HomePage hp = new HomePage(driver);
		hp.getmyInfo().click();

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		Object[][] obj = new Object[1][2];
		obj[0][0] = "Admin";
		obj[0][1] = "admin123";

		return obj;

	}
}
