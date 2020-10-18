package stepDefenitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.testng.Assert;

import org.junit.runner.RunWith;

import MyinfoPageObjects.Base;
import MyinfoPageObjects.LoginPage;

@RunWith(Cucumber.class)
public class OrangeHRMLogin extends Base {

    @Given("^Intialize Browser$")
    public void intialize_browser() throws Throwable {
    	driver=browserSetup();
    	
    }

    @When("^Login with ValidUsername \"([^\"]*)\" and ValidPassword \"([^\"]*)\"$")
    public void login_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
    LoginPage lp = new LoginPage(driver);
    lp.userName().sendKeys(strArg1);
    lp.passWord().sendKeys(strArg2);
    lp.logInBtn().click();
    }

    @Then("^Login OrangeHRM is Successfull$")
    public void login_orangehrm_is_successfull() throws Throwable {
    	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    	driver.close();
    }

    @And("^Open \"([^\"]*)\"$")
    public void open_something(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    @When("^Login with Username (.+) and Password (.+)$")
    public void login_with_username_and_password(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
        lp.userName().sendKeys(username);
        lp.passWord().sendKeys(password);
        lp.logInBtn().click();
    	
    }

    @Then("^Login OrangeHRM is UnSuccessfull$")
    public void login_orangehrm_is_unsuccessfull() throws Throwable {
    	LoginPage lp = new LoginPage(driver);
    	Assert.assertEquals(lp.errorMsg().getText(),"Invalid credentials");
    	driver.close();
    	
    }

}
