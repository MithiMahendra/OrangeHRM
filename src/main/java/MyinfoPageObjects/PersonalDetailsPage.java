package MyinfoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {
	public WebDriver driver;

	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "personal_txtEmpFirstName")
	WebElement firstName;

	@FindBy(id = "personal_txtEmpMiddleName")
	WebElement middleName;

	@FindBy(id = "personal_txtEmpLastName")
	WebElement lastName;

	@FindBy(id = "personal_txtEmployeeId")
	WebElement empID;

	@FindBy(id = "personal_txtOtherID")
	WebElement otherID;

	@FindBy(id = "personal_txtLicenNo")
	WebElement licenseNO;

	@FindBy(id = "personal_txtLicExpDate")
	WebElement licenseExpDate;

	@FindBy(id = "personal_txtNICNo")
	WebElement ssnNumber;

	@FindBy(id = "personal_txtSINNo")
	WebElement sinNumber;

	@FindBy(id = "personal_optGender_1")
	WebElement maleRadioButton;

	@FindBy(id = "personal_optGender_2")
	WebElement femaleRadioButton;

	@FindBy(id = "personal_cmbNation")
	WebElement nationalityDropDown;

	@FindBy(id = "personal_cmbMarital")
	WebElement maritalStatusDropDown;

	@FindBy(id = "personal_DOB")
	WebElement dateOfBirth;

	@FindBy(id = "personal_txtEmpNickName")
	WebElement nickName;

	@FindBy(id = "personal_chkSmokeFlag")
	WebElement smoker;

	@FindBy(id = "personal_txtMilitarySer")
	WebElement militaryService;

	@FindBy(id = "btnSave")
	WebElement edit;

	@FindBy(name = "custom1")
	WebElement bloodType;

	@FindBy(id = "btnEditCustom")
	WebElement bloodTypeEdit;

	@FindBy(id = "btnAddAttachment")
	WebElement attachmentEdit;

	public WebElement getFisrtName() {

		return firstName;
	}

	public WebElement getMiddleName() {

		return middleName;
	}

	public WebElement getLastName() {

		return lastName;
	}

	public WebElement getEmpID() {

		return empID;
	}

	public WebElement getOtherID() {

		return otherID;
	}

	public WebElement getLicenseNumber() {

		return licenseNO;
	}

	public WebElement getLicenseExpDate() {

		return licenseExpDate;
	}

	public WebElement getSsnNo() {

		return ssnNumber;
	}

	public WebElement getSinNumber() {

		return sinNumber;
	}

	public WebElement getMaleRadioButton() {

		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {

		return femaleRadioButton;
	}

	public WebElement getMaritalStatus() {

		return maritalStatusDropDown;
	}

	public WebElement getNationality() {

		return nationalityDropDown;
	}

	public WebElement getDateOfBirth() {

		return dateOfBirth;
	}

	public WebElement getNickName() {

		return nickName;
	}

	public WebElement getSmoker() {

		return smoker;
	}

	public WebElement getmilitaryService() {

		return militaryService;
	}

	public WebElement getEdit() {

		return edit;
	}

	public WebElement getBloodType() {

		return bloodType;
	}

	public WebElement getBloodTypeEdit() {

		return bloodTypeEdit;
	}

	public WebElement getAttachmentEdit() {

		return attachmentEdit;
	}

}
