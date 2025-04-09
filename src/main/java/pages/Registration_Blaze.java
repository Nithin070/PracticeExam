package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Registration_Blaze {
WebDriver driver;
	
	public Registration_Blaze(WebDriver driver){// Constructor 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	//Registration
	@FindBy(id="signin2")
	WebElement Register;   
	
	@FindBy(id="sign-username")
	WebElement userName;
	
	@FindBy(id="sign-password")
	WebElement password;
	
	@FindBy(xpath="//button[@onclick='register()']")
	WebElement SignUp;
	
	//Login
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement loginuserName;
	
	@FindBy(id="loginpassword")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement loginButton;
	
	
	
	//Registration
	public void clickOnSignup() {
		Register.click();
    }
	
	public void inputUserName() {
		userName.sendKeys("Nithin070");
    }
	
	public void inputPassword() {
		password.sendKeys("Test@123");
    }
	
	public void clickOnSignupButton() {
		SignUp.click();
    }
	
	
	
	//Login
	public void clickOnlogin() {
		login.click();
    }
	
	public void inputLoginUserName() {
		loginuserName.sendKeys("Nithin070");
		
    }
	
	public void inputLoginPassword() {
		loginPassword.sendKeys("Test@123");
		
    }
	
	public void clickOnLogInButton() {
		loginButton.click();
    }
	
	public String getTextFromLoginPage() {
		return gu.getElementText(VerifyLogin);
	}
	
	

}
