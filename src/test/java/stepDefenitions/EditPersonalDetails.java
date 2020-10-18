package stepDefenitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.HomePage;
import MyinfoPageObjects.LoginPage;
import MyinfoPageObjects.PersonalDetailsPage;

@RunWith(Cucumber.class)
public class EditPersonalDetails extends Base{

    @Given("^User logged into OrangeHRM \"([^\"]*)\" with Username \"([^\"]*)\",Password \"([^\"]*)\"$")
    public void user_logged_into_orangehrm_something_with_username_somethingpassword_something(String strArg1, String strArg2, String strArg3) throws Throwable {
    	driver=browserSetup();
    	driver.manage().window().maximize();
    	Thread.sleep(4000);
    	driver.get(strArg1);
    	LoginPage lp = new LoginPage(driver);
		lp.userName().sendKeys(strArg2);
		lp.passWord().sendKeys(strArg3);
		lp.logInBtn().click();
    }

    @When("^User Entered data into fields present in Personal Details$")
    public void user_entered_data_into_fields_present_in_personal_details() throws Throwable {
    	HomePage hp = new HomePage(driver);
		hp.getmyInfo().click();
		hp.getPersonalDetails().click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PersonalDetailsPage pdp = new PersonalDetailsPage(driver);
		pdp.getEdit().click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.UP);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

    @Then("^User is able to enter Data in Personal data fields$")
    public void user_is_able_to_enter_data_in_personal_data_fields() throws Throwable {
    	System.out.println("ESS User able edit Personal Details");
        
    }

}
