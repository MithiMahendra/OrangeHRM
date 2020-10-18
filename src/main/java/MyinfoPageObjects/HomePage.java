package MyinfoPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admin;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIM;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leave;

	@FindBy(id = "menu_time_viewTimeModule")
	WebElement time;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	WebElement recruitment;

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfo;

	@FindBy(id = "menu__Performance")
	WebElement performace;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboard;

	@FindBy(id = "menu_directory_viewDirectory")
	WebElement directory;

	@FindBy(id = "menu_maintenance_purgeEmployee")
	WebElement maintenance;

	@FindBy(id = "menu_buzz_viewBuzz")
	WebElement buzz;

	@FindBy(id = "MP_link")
	WebElement marketplace;

	@FindBy(id = "Subscriber_link")
	WebElement subscribe;

	@FindBy(xpath = "//a[@class='help-icon-div']/span")
	WebElement help;

	@FindBy(id = "notification")
	WebElement notification;

	@FindBy(id = "welcome")
	WebElement welcome;

	@FindBy(linkText = "Personal Details")
	WebElement personalDetails;

	@FindBy(linkText = "Contact Deatils")
	WebElement contactDetails;

	@FindBy(linkText = "Emergency Contacts")
	WebElement emergencyContacts;

	@FindBy(linkText = "Dependents")
	WebElement dependents;

	@FindBy(linkText = "Immigration")
	WebElement immigration;

	@FindBy(linkText = "Job")
	WebElement job;

	@FindBy(linkText = "Salary")
	WebElement salary;

	@FindBy(linkText = "Tax Exemptions")
	WebElement taxExemptions;

	@FindBy(linkText = "Report-to")
	WebElement reportTo;

	@FindBy(linkText = "Qualifications")
	WebElement qualifications;

	@FindBy(linkText = "Memberships")
	WebElement memberships;

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getPim() {
		return PIM;
	}

	public WebElement getLeave() {
		return leave;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getRecruitment() {
		return recruitment;
	}

	public WebElement getmyInfo() {
		return myInfo;
	}

	public WebElement getPerformace() {
		return performace;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getDirectory() {
		return directory;
	}

	public WebElement getMaintenance() {
		return maintenance;
	}

	public WebElement getBuzz() {
		return buzz;
	}

	public WebElement getMarketplace() {
		return marketplace;
	}

	public WebElement getSubscribe() {
		return subscribe;
	}

	public WebElement getHelp() {
		return help;
	}

	public WebElement getNotification() {
		return notification;
	}

	public WebElement getWelcome() {
		return welcome;
	}

	public WebElement getPersonalDetails() {
		return personalDetails;
	}

	public WebElement contactDetails() {
		return contactDetails;
	}

	public WebElement getEmergencyContacts() {

		return emergencyContacts;
	}

	public WebElement getDependents() {
		return dependents;
	}

	public WebElement getImmigration() {
		return immigration;
	}

	public WebElement getJob() {
		return job;
	}

	public WebElement getSalary() {
		return salary;
	}

	public WebElement getTaxExemptions() {
		return taxExemptions;
	}

	public WebElement getReportTo() {
		return reportTo;
	}

	public WebElement getQualifications() {
		return qualifications;
	}

	public WebElement getMemberships() {
		return memberships;
	}

}
