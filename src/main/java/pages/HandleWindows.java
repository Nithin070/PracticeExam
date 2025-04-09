package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandleWindows {
	
	WebDriver driver;
	public String parentWindow;
	
	public HandleWindows(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Follow On Twitter")
	WebElement twitterButton;
	
	//get Parent Window Title
	public void getParentWindowTitle() {
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title = " + parentTitle);
	}
	
	// To get ParentWindowHandle
	public void getParentWindowHandle() {
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window = " + parentWindow);
	}
	
	//Click on Twitter button
	public void clickonTwitter() {
		twitterButton.click();	
	}
	
	//Multiple window handles will get - here we are using method is - "LinkedHashSet"
	public void getChildWindowHandles() {
	Set<String> childWindowHandles = driver.getWindowHandles();       //getWindowHandles function to return a set of String
	List<String> windows = new ArrayList<String>(childWindowHandles); //Above returned Strings push to the ArrayList
	driver.switchTo().window(windows.get(1));                         //"0" is parentWindow and "1" is childWindow
	}
	
	public void getChildWindowTitle() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(10000);
		String childWindowTitle = driver.getTitle();
		System.out.println("Child Window Title = " + childWindowTitle);
		driver.close();
		Thread.sleep(3000);
	}
}