package testDemoblaze;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseDemoblazeClass;
import pomDemoblaze.PomDemoblaze;

public class testDemoblaze extends BaseDemoblazeClass {
	
	PomDemoblaze demo;
	public testDemoblaze() {
		super();
	}
	
	@BeforeMethod
	public void intialsetup() {
		intiation();
		demo = new PomDemoblaze();
	}
	
	/* Checking Functionality of Sign up
*****************************************/
	
	@Test(priority=1)
	public void checkingfuctionalityofsignup() throws InterruptedException {
		demo.clickonsignupmenu();
		demo.enterusername();
		demo.enterpassword();
		demo.clickonsignupbutton();
		demo.verifysignup();
	}

	/* Checking Functionality of Login
*****************************************/
	
	@Test(priority=2)
	public void checkingfuctionalityoflogin() throws InterruptedException {
		demo.clickonloginmenu();
		demo.enterloginusername();
		demo.enterloginpassword();
		demo.clickonloginbutton();
		demo.clickonlaptops();
		demo.clickonproduct();
		demo.verifylogin();
	}
	
	/* Checking Functionality of Cart
*****************************************/

	@Test(priority=3)
	public void checkingfunctionalityofcart() throws InterruptedException {
		demo.clickonlaptops();
		demo.clickonproduct();
		demo.clickonaddtocart();
		demo.clickonalert();
		demo.clickoncartmenu();
		demo.verifycart();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
