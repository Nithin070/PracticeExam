package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.ReadExcelData;

public class Registration_Pg {
	
	WebDriver driver;
	
	public Registration_Pg(WebDriver driver){// Constructor 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	ReadExcelData red = new ReadExcelData();
	
	@FindBy(xpath="//*[contains(text(),'Signup / Login')]")
	WebElement Signup_Login;
	
	@FindBy(xpath="//*[contains(text(),'Login to your account')]")
	WebElement VerifyLogin;
	
	@FindBy(name = "name")
	WebElement NewUserName;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[3]")
	WebElement NewUserEmail;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement Signupbutton;
	
	@FindBy(id="id_gender1")
	WebElement radio1;
	
	@FindBy(id="id_gender2")
	WebElement radio2;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="days")
	WebElement DOB_Day;
	
	@FindBy(id="months")
	WebElement DOB_Month;
	
	@FindBy(id="years")
	WebElement DOB_Year;
	
	@FindBy(id="newsletter")
	WebElement news_letter;
	
	@FindBy(id="optin")
	WebElement Special_Offers;
	
	/* Address Info */
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement First_Name;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement Last_Name;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement Company;

	@FindBy(xpath="//input[@id='address1']")
	WebElement addrez1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement addrez2;
	
	@FindBy(id= "country")
    WebElement selectcountry;
    
    @FindBy(xpath="//input[@id='state']")
	WebElement objState;
    
    @FindBy(xpath="//input[@id='city']")
   	WebElement objCity;
    
    @FindBy(xpath="//input[@id='zipcode']")
   	WebElement objZipcode;
    
    @FindBy(xpath="//input[@id='mobile_number']")
   	WebElement objMobile;
    
    @FindBy(xpath="//*[contains(text(),'Create Account')]")
    WebElement objCreateAcc;
    
    
    @FindBy(xpath="//*[contains(text(),'Account Created!')]")
    WebElement objAccCreate;
    
    @FindBy(xpath="//*[contains(text(),'Continue')]")
    WebElement ContinueButton;
    
    @FindBy(xpath="//*[contains(text(),'AnuElza')]")
    WebElement VerifyLoginName;
    
    @FindBy(xpath="//*[contains(text(),'Delete Account')]")
    WebElement deleteButton;
    
    @FindBy(xpath="//*[contains(text(),'Account Deleted!')]")
    WebElement verifyACdelete;
    
    
    public void ClickOnSignup_OR_Login() {
		Signup_Login.click();
    }
    
    public String getTextFromLoginPage() {
		return gu.getElementText(VerifyLogin);
	}
	
	public void inputNewUserName() throws EncryptedDocumentException, IOException {
		String newUName = red.getData(1, 0);
		NewUserName.sendKeys(newUName);
	}
	
	public void inputNewUserEmail() throws EncryptedDocumentException, IOException {
		String newUEmail = red.getData(1, 2);
		NewUserEmail.sendKeys(newUEmail);
	}
	
	public void ClickonSignUp() {
		Signupbutton.submit();
	}
	
	public void Radio1_Click() {
		radio1.click();
		System.out.println("Radio Button Option Mr. Selected");
    }
	
	public void Radio2_Click() {
		radio2.click();
		System.out.println("Radio Button Option Mrs. Selected");
    }
	
	public void PasswordInput() {
		Password.sendKeys("Atalla@1234");
	}
	
	public String SelectDOBday() {
		return gu.getSelectedValueFromDropDown(DOB_Day, "5");
	}
	
	public void SelectDOBmonth() {
		Select MonthDropDown = new Select(DOB_Month);
		MonthDropDown.selectByValue("5");
	}
	
	public void SelectDOByear() {
		Select YearDropDown = new Select(DOB_Year);
		YearDropDown.selectByValue("1995");
	}
	
	public boolean SelectNewsLtrCheckBox() {
		news_letter.click();
		boolean b = news_letter.isSelected();
		System.out.println(b);
		return true;	
	}

	public boolean SelectSpecialOffers() {
		Special_Offers.click();
		boolean b = Special_Offers.isSelected();
		System.out.print(b);
		return true;
	}
	
	/* Account Info */
	
	public void sendKeyFirstName() {
		First_Name.sendKeys("Benjamin");
	}
	
	public void sendKeyLastName() {
		Last_Name.sendKeys("Thomas");
	}
	
	public void sendKeyCompany() {
		Company.sendKeys("RDX");
	}
	
	public void sendKeyAddress1() {
		addrez1.sendKeys("Parayil Pullad P.O");
	}
	
	public void sendKeyAddress2() {
		addrez2.sendKeys("Thiruvalla");
	}
	
	public void selectCountryDrop() {
		Select drop1 = new Select(selectcountry);
				drop1.selectByValue("Singapore");
	}
	
	public void sendKeyState() {
		objState.sendKeys("Kerala");
	}
	
	public void sendKeyCity() {
		objCity.sendKeys("Pathanamthitta");
	}
	
	public void sendKeyZip() {
		objZipcode.sendKeys("689548");
	}
	
	public void sendKeyMobile() {
		objMobile.sendKeys("9745454555");
	}
	
	public void submitRegForm() {
		objCreateAcc.click();
	}
	
	public String getAccountCreatedText() {
		return gu.getElementText(objAccCreate);	
	}
	
	public void ClickonContinue() {
		ContinueButton.click();
	}
	
	public String getLoginUserName() {
		String LoginName = VerifyLoginName.getText();
		return LoginName;
	}
	
	public void ClickonDeleteAC() {
		deleteButton.click();
	}
	
	public String getAccDeleteText() {
		String verifyAccDeleteText = verifyACdelete.getText();
		return verifyAccDeleteText;
	}
}
