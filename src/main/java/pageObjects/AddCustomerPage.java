package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu = By.xpath("//nav[@class='mt-2']/ul/li[4]/a/p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//nav[@class='mt-2']/ul/li[4]/ul/li/a/p[contains(text(),'Customers')]");

	By btnAddnew = By.xpath(" //i[@class=\"fas fa-plus-square\"]");

	By txtEmail = By.xpath("//input[@type='email']");
	By txtPassword = By.xpath("//input[@type='password']");

	By txtcustomerRoles = By.xpath("//div[@id='customer-info']/div[2]/div[10]/div[2]/div/div[1]/div");

	By lstitemAdminstrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemGuests = By.xpath("//li[@data-offset-index='2'][contains(text(),'Guests')]");
	By lstitemVendor = By.xpath("//li[@data-offset-index='3'][contains(text(),'Registered')]");

	By drpmgrOfVendor = By.id("VendorId");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");

	By txtDob = By.xpath("//input[@id='DateOfBirth']");

	By txtComanyName = By.xpath("//input[@id='Company']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save-continue']");

	// Actions Method

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {

		if (!role.equals("Vendors")) {
			ldriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		//ldriver.findElement(txtcustomerRoles).clear();
		ldriver.findElement(txtcustomerRoles).click();

		WebElement listitem;

		Thread.sleep(3000);

		if (role.equals("Administrators")) {
			listitem = ldriver.findElement(lstitemAdminstrators);
		} else if (role.equals("Guests")) {
			listitem = ldriver.findElement(lstitemGuests);
		} else if (role.equals("Registered")) {
			listitem = ldriver.findElement(lstitemRegistered);
		} else if (role.equals("Vendors")) {
			listitem = ldriver.findElement(lstitemVendor);
		} else {
			listitem = ldriver.findElement(lstitemGuests);
		}
		listitem.click();

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,1000)");
//		js.executeScript("argument[0].click();", listitem);
	}

	public void setManagerOfVendor(String value) {
		// ldriver.findElement(drpmgrOfVendor).click();
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));

		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();

		} else if (gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		} else {
			ldriver.findElement(rdMaleGender).click();
		}
	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtComanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}

}
