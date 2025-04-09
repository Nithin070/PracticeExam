package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Baseclass;
import pages.Logout_Pg;
import pages.Registration_Pg;

public class TC_LogoutUser extends Baseclass {

	@Test
	public void tc04_verifyLogoutUser() throws InterruptedException {

		Registration_Pg rh = new Registration_Pg(driver);
		rh.ClickOnSignup_OR_Login();

		rh.getTextFromLoginPage();

		Logout_Pg lp = new Logout_Pg(driver);

		lp.loginInput();
		lp.loginPassword();
		lp.loginSubmit();

		String actualLoginName = lp.getLoginName();
		String expectedLoginName = "Merlin Mathew";
		Assert.assertEquals(actualLoginName, expectedLoginName, "Incorrect Login Name");
		
		lp.logoutSession();

	}

}
