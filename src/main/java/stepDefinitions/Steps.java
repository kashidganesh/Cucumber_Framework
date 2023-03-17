package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass {

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

		/*
		 * try { WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); }
		 */
	}

	@When("User opans URL {string}")
	public void user_opans_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String password) {
		lp.setUserName(Email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(2000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Thread.sleep(1000);
		// lp.clickLogout();

//		WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().build().perform();

//		WebElement ele = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", ele);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();

	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String string) {
		driver.close();
	}

	@Then("close browser")
	public void close_browser() {

	}

	// Customer feature step definations...

	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on customer Menu Item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setFirstName("Ganesh");
		addCust.setLastName("Kashid");
		addCust.setGender("Male");
		addCust.setDob("3/04/2005");
		addCust.setCompanyName("TestQA");
		// Registered - default
		// the custome cannot be in the both 'Guests' and Registered customer roles
		// Add the customer to'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setAdminContent("This is for testing......");

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string};")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

}
