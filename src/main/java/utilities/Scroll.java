package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {
	private WebDriver driver;
	
    public Scroll(WebDriver driver) {
	     this.driver = driver;
	    }

	public void scrollToElement(int x, int y) {
	     JavascriptExecutor jse = (JavascriptExecutor) driver;
	     jse.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	    }
	}
