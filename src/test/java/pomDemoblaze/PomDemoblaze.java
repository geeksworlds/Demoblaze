package pomDemoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseDemoblazeClass;
import environmentVariables.TimeUtilities;
import junit.framework.Assert;

public class PomDemoblaze extends BaseDemoblazeClass {

	/* WEB ELEMENTS 
**********************/
	
	@FindBy(id="signin2")
	WebElement SignupMenu;
	
	@FindBy(id="sign-username")
	WebElement Username;
	
	@FindBy(id="sign-password")
	WebElement Password;
	
	@FindBy(css="#signInModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")
	WebElement SignupButton;
	
	@FindBy(id="login2")
	WebElement LoginMenu;
	
	@FindBy(id="loginusername")
	WebElement LoginUsername;
	
	@FindBy(id="loginpassword")
	WebElement LoginPassword;
	
	@FindBy(css="#logInModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")
	WebElement LoginButton;
	
	@FindBy(linkText="Laptops")
	WebElement Laptops;
	
	@FindBy(linkText="MacBook Pro")
	WebElement Product;
	
	@FindBy(css=".item > img:nth-child(1)")
	WebElement ProductImage;
	
	@FindBy(css="a.btn")
	WebElement AddtocartButton;
	
	@FindBy(id="cartur")
	WebElement CartMenu;
	
	@FindBy(css=".success")
	WebElement CartProduct;
	
	public PomDemoblaze() {
		PageFactory.initElements(driver, this);
	}
	
	/* Checking Functionality of Sign up
*****************************************/
	
	public void clickonsignupmenu() {
		SignupMenu.click();
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void enterusername() {
		Username.sendKeys(prop.getProperty("username"));
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void enterpassword() { 
		Password.sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void clickonsignupbutton() {
		SignupButton.click();
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void verifysignup() throws InterruptedException {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actualtext = alert.getText();
		if(prop.getProperty("loginexpectedtext").equals(actualtext)) {
	    	System.out.println("Expected and Actual text are same");
	    }
	    else {
	    	System.out.println("Expected and Actual text are not same");
	    }
	    Assert.assertEquals(prop.getProperty("loginexpectedtext"), actualtext);
	    alert.accept();
	}
	
	/* Checking Functionality of Login
****************************************/	
	public void clickonloginmenu() {
		LoginMenu.click();
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void enterloginusername() {
		LoginUsername.sendKeys(prop.getProperty("username"));
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void enterloginpassword() {
		LoginPassword.sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void clickonloginbutton() {
		LoginButton.click();
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void clickonlaptops() throws InterruptedException {
		Thread.sleep(2000);
		Laptops.click();
		Thread.sleep(2000);
	}
	public void clickonproduct() throws InterruptedException {
		Product.click();
		Thread.sleep(2000);
	}
	public void verifylogin() {
		if(ProductImage.isDisplayed()) {
			System.out.println("Image is displayed");
		}
		else {
			System.out.println("Image is not displayed");
		}
		
		if(AddtocartButton.isDisplayed()) {
			System.out.println("Add to cart button is displayed");
		}
		else {
			System.out.println("Add to cart button is not displayed");
		}
	}
	
	/* Checking Functionality of Cart
***************************************/
	public void clickonaddtocart() throws InterruptedException {
		AddtocartButton.click();
		Thread.sleep(2000);
	}
	public void clickonalert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts().pageLoadTimeout(TimeUtilities.waittime, TimeUnit.SECONDS);
	}
	public void clickoncartmenu() throws InterruptedException {
		CartMenu.click();
		Thread.sleep(2000);
	}
	public void verifycart() {
		if(CartProduct.isDisplayed()) {
			System.out.println("Product is displayed in cart");
		}
		else {
			System.out.println("Product is not displayed in cart");
		}
	}
}

