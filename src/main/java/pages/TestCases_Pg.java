package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestCases_Pg {
	WebDriver driver;
	
	public TestCases_Pg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/test_cases' and contains(text(), 'Test Cases')]")
	WebElement TestCases;
	
	public void ClickOnTestCase() {
		TestCases.click();
	}
}
