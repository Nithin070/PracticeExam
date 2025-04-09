package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AllProducts_Pg {
	
WebDriver driver;
	
	public AllProducts_Pg(WebDriver driver){// Constructor 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath="//*[contains(text(),'Products')]")
	WebElement Product;
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	WebElement firstProduct;
	
	@FindBy(xpath="//*[@id='search_product']")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id='submit_search']")
	WebElement search;
	
	@FindBy(xpath="//*[contains(text(), 'Stylish Dress')]")
	WebElement verifySearchedProduct;
	
	@FindBy(id="susbscribe_email")
	WebElement emailInput;
	
	@FindBy(id="subscribe")
	WebElement subscribeButtom;
	
	@FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
	WebElement verifySubscribe;
	
	@FindBy(xpath="//*[contains(text(),'Cart')]")
	WebElement cartButton;
	
	@FindBy(xpath="//*[contains(text(),'Subscription')]")
	WebElement verifySubscriptionText;
	
	
	public void ClickonProductButton() {
		Product.click();	
	}
	
	public void scrollToElement() { 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	}
	
	public void ClickonViewProduct() {
		firstProduct.click();
	}
	
	public void ClickonSearchbox() {
		searchBox.click();
	}
	
	public void searchboxInput() {
		searchBox.sendKeys("Stylish Dress");
	}
	
	public void searchButton() {
		search.click();
	}
	
	public void searchInputclear() {
		searchBox.clear();
	}
	
	public String getTextsearchedProduct() {
		String searchProName = verifySearchedProduct.getText();
		return searchProName;
	}
	
	public void inputEmailBox() {
		emailInput.sendKeys("test@mail.com");
	}
	
	public void clickOnSubscribeButton() {
		subscribeButtom.click();
	}
	
	public String getSuccessText() {
		String subscribeText = verifySubscribe.getText();
		return subscribeText;
	}
	
	public void clickOnCart() {
		cartButton.click();
	}
	
	public String getSubscribeText() {
		String getTextName = verifySubscriptionText.getText();
		return getTextName;
	}

}
