package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Baseclass;
import pages.XLReaderSample_Pg;
import utilities.Screenshots;

public class TC_XLReading extends Baseclass {
	SoftAssert sa = new SoftAssert();

	@Test
	public void tc02_verifyLoginwithCorrectEmailandPassword() throws EncryptedDocumentException, IOException {
		
	XLReaderSample_Pg xlrS = new XLReaderSample_Pg(driver);
	xlrS.ClickOnSignup_OR_Login();
	
	String actual = xlrS.getTextFromLoginPage();
	String expected = "Login to your account";
	Assert.assertEquals(actual, expected, "Facing Issue");
	
	xlrS.inputLogin();
	xlrS.LoginPasswordInput();
	xlrS.ClickLoginButton();	
	
	String actualLoginName = xlrS.getLoginUserName();
	String expectedLoginName = "Amal Devis";
	sa.assertEquals(actualLoginName, expectedLoginName, "Incorrect Login Name");
	
	Screenshots.captureScreenshot(driver, "Login Test");
	
	sa.assertAll();
}
	}
