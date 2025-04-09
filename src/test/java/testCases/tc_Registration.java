package testCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Baseclass;
import pages.Products_Blaze;
import pages.Registration_Blaze;

public class tc_Registration extends Baseclass {
	
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled= false)
	public void tc01_VerifyRegistration() throws InterruptedException {
		Registration_Blaze rb = new Registration_Blaze(driver);
		
		rb.clickOnSignup();
		Thread.sleep(5000);
		rb.inputUserName();
		Thread.sleep(5000);
		rb.inputPassword();
		Thread.sleep(5000);
		//rb.clickOnSignupButton();
	}
	
	@Test(priority=1)
	public void tc02_VerifyLogin() throws InterruptedException {
		Registration_Blaze rb = new Registration_Blaze(driver);
		rb.clickOnlogin();
		Thread.sleep(5000);
		rb.inputLoginUserName();
		Thread.sleep(5000);
		rb.inputLoginPassword();
		Thread.sleep(5000);
		rb.clickOnLogInButton();
		Thread.sleep(5000);
		
		String actualUserName = rb.getTextFromLoginPage();
		String expectedUserName = "Welcome Nithin070";
		sa.assertEquals(actualUserName,expectedUserName, "Login Fail...!");
		
		//Product
		Products_Blaze pb = new Products_Blaze(driver) ;
		pb.selectMobile();
		Thread.sleep(3000);
		pb.clickOnAddtoCart();
		Thread.sleep(3000);
        
		Alert alert = driver.switchTo().alert();
	    
	    String actualAlertMessage = alert.getText();
	    System.out.println("Alert Message: " + actualAlertMessage);

	    // Verify the alert message
	    String expectedAlertMessage = "Product added.";
	    sa.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert message does not match!");

	    // Accept (click OK on the alert)
	    alert.accept();
	    
		pb.clickOnCart();
		Thread.sleep(3000);
	    pb.productVerify();
	    Thread.sleep(3000);
	    pb.clickOnPlaceOrder();
	    Thread.sleep(3000);
	    
	    pb.name();
	    pb.country();
	    pb.city();
	    pb.cc();
	   
	    pb.month();
	    pb.year();
	    
	    pb.clickOnPurchase();
	    
	    Thread.sleep(5000);
	    
	    
        Alert successAlert = driver.switchTo().alert();
	    
	    String actualSuccessAlert = successAlert.getText();
	    System.out.println("Alert Message: " + actualAlertMessage);
	    
	    String expectedSuccessAlert = "Thank you for your purchase!";
	    sa.assertEquals(actualSuccessAlert, expectedSuccessAlert, "Alert message does not match!");
	    
	    successAlert.accept();
	    
	    pb.clickOnLogout();
	    
	    sa.assertAll();
		
	}
	}
	
