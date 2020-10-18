package MyinfoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername")
	WebElement userName;
	@FindBy(id="txtPassword")
	WebElement passWord;
	@FindBy(id="btnLogin")
	WebElement logInBtn;
	@FindBy(id="spanMessage")
	WebElement errorMsg;
	
	public WebElement userName() {
		return userName;
	}
	public WebElement passWord() {
		return passWord;
	}
	public WebElement logInBtn() {
		return logInBtn;
	}
	public WebElement errorMsg() {
		return errorMsg;
	}

}
