package testCases;

import org.testng.annotations.Test;

import base.Baseclass;
import pages.HandleWindows;

public class WindowsHandles_TC extends Baseclass {
	
	@Test
	public void windowsHandle() throws InterruptedException {
	
		HandleWindows hw = new HandleWindows(driver);
		
		hw.getParentWindowTitle();
		hw.getParentWindowHandle();
		hw.clickonTwitter();	
		hw.getChildWindowHandles();
		hw.getChildWindowTitle();	
	}	
}
