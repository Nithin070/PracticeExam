package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Contact_Pg;

public class TC_ContactUs {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc06_ContactUs() {
		Contact_Pg cu = new Contact_Pg(driver);
		
		cu.ClickOnContactUs();

		String actualContactText = cu.getContactUsText();
		String expectedContactText = "GET IN TOUCH";
		Assert.assertEquals(actualContactText, expectedContactText, "Page Not Available");
		
		cu.inputContactName();
		cu.inputContactEmail();
		cu.inputContactSubject();
		cu.inputContactMsg();
		
		cu.uploadFile();
		cu.formSubmit();
		
		Alert alert = driver.switchTo().alert();	
		alert.accept();
		
		String actualSuccessMsg = cu.getSuccessMsg();
		String expectedSuccessMsg = "Success! Your details have been submitted successfully.";
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Error");
		
		cu.backToHome();
	}
	

}
