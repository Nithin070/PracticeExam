package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeVerification {
	
	WebDriver driver;
	
	public HomeVerification(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public void verifyHomePage() {
    	String actualHomePageTitle = driver.getTitle();
    	String expectedHomePageTitile = "Automation Exercise";
    	Assert.assertEquals(actualHomePageTitle, expectedHomePageTitile, "Page not available");
    }

}
