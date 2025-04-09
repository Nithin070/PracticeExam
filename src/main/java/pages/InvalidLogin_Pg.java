package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class InvalidLogin_Pg {
	
WebDriver driver;
	
	public InvalidLogin_Pg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	
	@FindBy(xpath="//*[contains(text(),'Signup / Login')]")
	WebElement Signup_Login;
	
	@FindBy(xpath="//*[contains(text(),'Login to your account')]")
	WebElement VerifyLogin;
	
	@FindBy(xpath= "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement LoginEmail;
	
	@FindBy(name = "password")
	WebElement LoginPassword;
	
	@FindBy(xpath="//button[@type='submit' and @data-qa='login-button']")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[contains(text(),'Your email or password is incorrect!')]")
	WebElement InvalidLogin;
	
	
	public void ClickOnSignup_OR_Login() {
		Signup_Login.click();
    }
    
    public String getTextFromLoginPage() {
		return gu.getElementText(VerifyLogin);
	}
	
	public void inputLogin() {
		LoginEmail.sendKeys("aswin@gmail.com");
	}
	
	public void LoginPasswordInput() {
		LoginPassword.sendKeys("Atalla@1234");
	}
	
	public void ClickLoginButton() {
		LoginButton.click();
	}
	
	public String getInvalidAlertMessage() {
		String InvalidLoginAlert = InvalidLogin.getText();
		return InvalidLoginAlert;
	}

}
