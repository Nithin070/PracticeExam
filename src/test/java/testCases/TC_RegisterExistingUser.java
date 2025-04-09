package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.Baseclass;
import pages.RegisterExistingUser_Pg;

public class TC_RegisterExistingUser extends Baseclass {
	SoftAssert sa = new SoftAssert();
	
	@Test(groups="Test")
	public void tc05_verifyRegisterUserWithExistingEmail() {
		
		RegisterExistingUser_Pg reUser = new RegisterExistingUser_Pg(driver);
		
		reUser.signupLoginButton();
		
		
		String actual = reUser.getTextFromLoginPage();
		String expected = "Login to your account";
		sa.assertEquals(actual, expected, "Facing Issue");
		
		reUser.inputExistingUserName();
		reUser.inputExistingUserEmail();
		reUser.ExistingUserClickonSignUp();
		
		String actualErrorTitle = reUser.getalready_ExistText();
		String expectedErrorTitle = "Email Address already exist!";
		sa.assertEquals(actualErrorTitle,expectedErrorTitle, "Signup Success..!");
		
		sa.assertAll();
	}
}