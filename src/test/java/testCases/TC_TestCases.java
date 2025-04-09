package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TestCases_Pg;

public class TC_TestCases {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc07_VerifyTestcasePage() {
		
		TestCases_Pg tc = new TestCases_Pg(driver);
		
		String actualTitile = driver.getTitle();
		String expectedTitle = "Automation Exercise";
		Assert.assertEquals(actualTitile, expectedTitle, "Page not found");
		
		tc.ClickOnTestCase();
		
		String actualTcPageTitile = driver.getTitle();
		String expectedTcPageTitle = "Automation Practice Website for UI Testing - Test Cases";
		Assert.assertEquals(actualTcPageTitile, expectedTcPageTitle, "Test Case Page not found");
  }
}