package MyinfoTestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.HomePage;
import MyinfoPageObjects.LoginPage;
import MyinfoPageObjects.PersonalDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC_Myinfo_006 extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void browser() throws IOException, InterruptedException {
		driver = browserSetup();
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(500);
	}

	@Test
	public void VerifyESSUserCanEditFields() {
		LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys("Admin");
		lp.passWord().sendKeys("admin123");
		lp.logInBtn().click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		HomePage hp = new HomePage(driver);
		hp.getmyInfo().click();
		hp.getPersonalDetails().click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		PersonalDetailsPage pdp = new PersonalDetailsPage(driver);
		WebDriverWait waits = new WebDriverWait(driver,10);
		waits.until(ExpectedConditions.visibilityOf(pdp.getEdit()));
		pdp.getEdit().click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.UP);
		waits.until(ExpectedConditions.visibilityOf(pdp.getFisrtName()));
		//clears the old data and enters new data
		pdp.getFisrtName().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getFisrtName().sendKeys(Keys.BACK_SPACE);
		pdp.getFisrtName().sendKeys("Mahendra");
		//clears the old data and enters new data
		pdp.getMiddleName().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getMiddleName().sendKeys(Keys.BACK_SPACE);
		pdp.getMiddleName().sendKeys("Mithi");
		//clears the old data and enters new data
		pdp.getLastName().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getLastName().sendKeys(Keys.BACK_SPACE);
		pdp.getLastName().sendKeys("Sivanarayana");
		//clears the old data and enters new data
		pdp.getOtherID().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getOtherID().sendKeys(Keys.BACK_SPACE);
		pdp.getOtherID().sendKeys("123");
		pdp.getFemaleRadioButton().click();
		Assert.assertTrue(pdp.getFemaleRadioButton().isSelected());
		Select se = new Select(pdp.getMaritalStatus());
		se.selectByVisibleText("Single");
		Select se2 = new Select(pdp.getNationality());
		se2.selectByVisibleText("Indian");
		//Clears old Data and enters new data
		pdp.getNickName().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getNickName().sendKeys(Keys.BACK_SPACE);
		pdp.getNickName().sendKeys("Mahi");
		pdp.getSmoker().click();
		pdp.getmilitaryService().sendKeys(Keys.CONTROL,Keys.chord("a"));
		pdp.getmilitaryService().sendKeys(Keys.BACK_SPACE);
		pdp.getmilitaryService().sendKeys("Yes");
		pdp.getEdit().click();
	}
	@AfterTest
	public void tearDown() {
		System.out.println("TestCase Passed");
		driver.close();
	}

}
