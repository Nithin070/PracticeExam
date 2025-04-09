
package testCases;

import org.testng.asserts.SoftAssert;

import base.Baseclass;
import pages.InvalidLogin_Pg;
import pages.Login_Pg;
import pages.Registration_Pg;
import utilities.Screenshots;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RegisterUser extends Baseclass {
	SoftAssert sa = new SoftAssert();

	@Test
	public void tc01_VerifyHomePage() throws EncryptedDocumentException, IOException {
		
		Registration_Pg rh = new Registration_Pg(driver);
		
		rh.ClickOnSignup_OR_Login();
		
		String actual = rh.getTextFromLoginPage();
		String expected = "Login to your account";
		sa.assertEquals(actual, expected, "Facing Issue");
		
		rh.inputNewUserName();
		rh.inputNewUserEmail();
		rh.ClickonSignUp();

		String actualRegisterPageTitle = driver.getTitle();
		String expectedRegisterPageTitile = "Automation Exercise - Signup";
		Assert.assertEquals(actualRegisterPageTitle, expectedRegisterPageTitile, "Page not available");
		
		rh.Radio1_Click();
		rh.Radio2_Click();
		rh.PasswordInput();
		rh.SelectDOBday();
		
		String actualResultDOBday = rh.SelectDOBday();
		String expectedResultDOBday = "5";
		sa.assertEquals(actualResultDOBday, expectedResultDOBday, "Dropdown not selected");
		
		rh.SelectDOBmonth();
		rh.SelectDOByear();
		
		rh.SelectNewsLtrCheckBox();	
		rh.SelectSpecialOffers();
		
		rh.sendKeyFirstName();
		rh.sendKeyLastName();
		rh.sendKeyCompany();
		rh.sendKeyAddress1();
		rh.sendKeyAddress2();
		rh.selectCountryDrop();
		rh.sendKeyState();
		rh.sendKeyCity();
		rh.sendKeyZip();
		rh.sendKeyMobile();
		rh.submitRegForm();
		rh.getAccountCreatedText();
		
		String actualAccountCreate = rh.getAccountCreatedText();
		String expectedAccountCreate = "ACCOUNT CREATED!";
		sa.assertEquals(actualAccountCreate, expectedAccountCreate, "Account not created");
		
		rh.ClickonContinue();
		
		String actualLoginName = rh.getLoginUserName();
		String expectedLoginName = "AnuElza";
		sa.assertEquals(actualLoginName, expectedLoginName, "Incorrect Login Name");
		
		rh.ClickonDeleteAC();
		
		String actualAcDelete = rh.getAccDeleteText();
		String expectedAcDelete = "ACCOUNT DELETED!";
		sa.assertEquals(actualAcDelete, expectedAcDelete, "Account Deleted!");
		
		sa.assertAll();

	}
		@Test
		public void tc02_verifyLoginwithCorrectEmailandPassword() throws EncryptedDocumentException, IOException {
			
		Login_Pg lp = new Login_Pg(driver);
		lp.ClickOnSignup_OR_Login();
		
		String actual = lp.getTextFromLoginPage();
		String expected = "Login to your account";
		Assert.assertEquals(actual, expected, "Facing Issue");
		
		lp.inputLogin();
		lp.LoginPasswordInput();
		lp.ClickLoginButton();	
		
		String actualLoginName = lp.getLoginUserName();
		String expectedLoginName = "Amal Devis";
		sa.assertEquals(actualLoginName, expectedLoginName, "Incorrect Login Name");
		
		Screenshots.captureScreenshot(driver, "Login Test");
		
		sa.assertAll();
				
	}
		@Test
		public void tc03_verifyLoginwithIncorrectEmailandPassword() {
		
		InvalidLogin_Pg ilp = new InvalidLogin_Pg(driver);
		
		ilp.ClickOnSignup_OR_Login();
		ilp.inputLogin();
		ilp.LoginPasswordInput();
		ilp.ClickLoginButton();
		
		String actual = ilp.getInvalidAlertMessage();
		String expected = "Your email or password is incorrect!";
		sa.assertEquals(actual, expected, "Facing Issue");
		
		sa.assertAll();
	
	}
		
	
}
