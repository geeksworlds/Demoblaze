package stepDefination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Demoblaze {

	WebDriverWait wait;
	WebDriver driver;
	
	@Given("User should be on url {string}")
	public void user_should_be_on_url(String string) {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(string);
		driver.manage().window().maximize();
	}

	@When("User click on signup button")
	public void user_click_on_signup_button() {
		driver.findElement(By.id("signin2")).click();
	}

	@When("Enter username as {string}")
	public void enter_username_as(String string) {
		driver.findElement(By.id("sign-username")).sendKeys(string);
	}

	@When("Enter password as {string}")
	public void enter_password_as(String string) {
		driver.findElement(By.id("sign-password")).sendKeys(string);
	}

	@When("Cick on Sign up button")
	public void cick_on_sign_up_button() throws InterruptedException {
		driver.findElement(By.cssSelector("#signInModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")).click();
		Thread.sleep(2000);
	}

	@Then("Alert should display as {string}")
	public void alert_should_display_as(String string) {
		Alert alert = driver.switchTo().alert();
		String actualtext = alert.getText();
	    if(actualtext == string) {
	      	System.out.println("Actual text and Expected text are same");
	    }
	    else {
	    	System.out.println("Actual text and Expected text are not same");
	    }
	    
	    Assert.assertEquals(string, actualtext);
	}


	@Then("Click on Ok button on alert")
	public void click_on_ok_button_on_alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
		driver.close();
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		driver.findElement(By.id("login2")).click();
	}

	@When("Enter Login username as {string}")
	public void enter_login_username_as(String string) {
	    driver.findElement(By.id("loginusername")).sendKeys(string);
	}

	@When("Enter Login password as {string}")
	public void enter_login_password_as(String string) {
		driver.findElement(By.id("loginpassword")).sendKeys(string);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
	    driver.findElement(By.cssSelector("#logInModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")).click();
	    Thread.sleep(2000);
	}

	@When("Click on Laptops option")
	public void click_on_laptops_option() {
		driver.findElement(By.linkText("Laptops")).click();
	}

	@When("Click on any Laptop name")
	public void click_on_any_laptop_name() throws InterruptedException {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook Pro"))).click();
		Thread.sleep(2000);
	}

	@Then("It should open new page with image of laptop and ADD TO CART button")
	public void it_should_open_new_page_with_image_of_laptop_and_add_to_cart_button() {
	    Boolean addtocartbutton = driver.findElement(By.cssSelector("a.btn")).isDisplayed();
	    System.out.println("If button is displayed then results should be true. Results = " + addtocartbutton);
	    
	    Boolean productimage = driver.findElement(By.cssSelector(".item > img:nth-child(1)")).isDisplayed();
	    System.out.println("If button is displayed then results should be true. Results = " + productimage);
	    driver.close();
	}

	@When("User clicks on Laptops option")
	public void user_clicks_on_laptops_option() {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops"))).click();
	}

	@When("Click on any Laptop name from options")
	public void click_on_any_laptop_name_from_options() {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook air"))).click();
	}

	@When("Clicks ADD TO CART")
	public void clicks_add_to_cart() {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))).click();
	}

	@When("Click on OK in alert")
	public void click_on_ok_in_alert() throws InterruptedException {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}

	@When("Go to cart page")
	public void go_to_cart_page() throws InterruptedException {
	    driver.findElement(By.id("cartur")).click();
	    Thread.sleep(2000);
	}

	@Then("Cart should have that products added in it")
	public void cart_should_have_that_products_added_in_it() {
	    Boolean cartproduct = driver.findElement(By.cssSelector(".success")).isDisplayed();
	    System.out.println("If product is added then results should be true. Results = " + cartproduct);
	    driver.close();
	}
	
}
