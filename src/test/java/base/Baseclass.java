package base;

import java.io.FileReader;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		//driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo"); // For Windows Handling study purpose
		
		//driver.get("https://www.demoblaze.com/.");
		
		driver.manage().window().maximize();
	}


	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
