package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class RegisterExistingUser_Pg {
	
	WebDriver driver;
	
	public RegisterExistingUser_Pg(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath="//*[contains(text(),'Signup / Login')]")
	WebElement Signup_Login;
	
	@FindBy(xpath="//*[contains(text(),'Login to your account')]")
	WebElement VerifyLogin;
	
	@FindBy(name = "name")
	WebElement ExistingUserName;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[3]")
	WebElement ExistingUserEmail;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement Signupbutton;
	
	@FindBy(xpath="//*[contains (text(),'Email Address already exist!')]")
	WebElement getTextFromLoginPage;
	
	
	public void signupLoginButton() {
		Signup_Login.click();
	}
	
	public String getTextFromLoginPage() {
		return gu.getElementText(VerifyLogin);
	}
	
	public void inputExistingUserName() {
		ExistingUserName.sendKeys("Merlin Mathew");
	}
	
	public void inputExistingUserEmail() {
		ExistingUserEmail.sendKeys("merlinmw@gmail.com");	
	}
	
	public void ExistingUserClickonSignUp() {
		Signupbutton.submit();
	}
	
	public String getalready_ExistText() {
		return gu.getElementText(getTextFromLoginPage);
	}
	
}