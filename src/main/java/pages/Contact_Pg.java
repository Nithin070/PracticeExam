package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Contact_Pg {
	WebDriver driver;
	
	String filePath = "C:\\Users\\nithi\\Downloads\\Kingfisher.jpg";
	
	public Contact_Pg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath="//*[contains(text(),' Contact us')]")
	WebElement Contact_Us;
	
	@FindBy(xpath="//*[contains(text(),'Get In Touch')]")
	WebElement VerifyContactUs;
	
	@FindBy(name="name")
	WebElement ContactName;
	
	@FindBy(name="email")
	WebElement ContactEmail;
	
	@FindBy(name="subject")
	WebElement ContactSubject;
	
	@FindBy(id="message")
	WebElement ContactMsg;
	
	@FindBy(name="upload_file")
	WebElement UploadFile;
	
	@FindBy(name="submit")
	WebElement SubmitForm;
	
	@FindBy(xpath= "//*[contains(@class, 'status alert alert-success')]")
	WebElement VerifySuccess;
	
	@FindBy(xpath= "//*[contains(@class, 'fa fa-angle-double-left')]")
	WebElement backHome;
	
	
	public void ClickOnContactUs() {
		Contact_Us.click();
    }
	
	public String getContactUsText() {
		return gu.getElementText(VerifyContactUs);
	}
	
	public void inputContactName() {
		ContactName.sendKeys("Thomas Philip");
	}
	
	public void inputContactEmail() {
		ContactEmail.sendKeys("thomasph@gmail.com");
	}
	
	public void inputContactSubject() {
		ContactSubject.sendKeys("Purchase");
	}
	
	public void inputContactMsg() {
		ContactMsg.sendKeys("Hi..Hi..Hi");
	}
	
	public void uploadFile() {
		UploadFile.sendKeys(filePath);
		System.out.println("File Uploaded Successfully");
	}
	
	public void formSubmit() {
		SubmitForm.submit();
	}
	
	public String getSuccessMsg() {
		String SuccessMsg = VerifySuccess.getText();
		return SuccessMsg;	
	}
	
	public void backToHome() {
		backHome.click();
	}
}
