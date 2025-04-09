package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Logout_Pg {
	
	WebDriver driver;
	
	public Logout_Pg(WebDriver driver){// Constructor 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath= "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement LoginEmail;
	
	@FindBy(name = "password")
	WebElement LoginPassword;
	
	@FindBy(xpath="//button[@type='submit' and @data-qa='login-button']")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[contains(text(),'Merlin Mathew')]")
	WebElement VerifyLoginName;
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement LogoutButton;

	
	public void loginInput() {
		LoginEmail.sendKeys("merlinmw@gmail.com");
	}
	
	public void loginPassword() {	
		LoginPassword.sendKeys("Atalla@1234");
	}
	
	public void loginSubmit() {
		LoginButton.click();
	}
	
	public String getLoginName() {
		String getLoginName = VerifyLoginName.getText();
		return getLoginName;
	}
	
	
	public void logoutSession() {
		LogoutButton.click();
	}
}