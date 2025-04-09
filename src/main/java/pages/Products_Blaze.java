package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.GeneralUtilities;

public class Products_Blaze {
	
WebDriver driver;
	
	public Products_Blaze(WebDriver driver){// Constructor 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']")
	WebElement galaxyS6;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(xpath="//*[contains(text(),'Samsung galaxy s6')]")
	WebElement productElem;
	
	@FindBy(xpath="//*[contains(text(),'Place Order')]")
	WebElement placeOrderElmt;
	
	//Order Place
	
	@FindBy(id="name")
	WebElement nameElem;
	
	@FindBy(id="country")
	WebElement countryElem;
	
	
	@FindBy(id="city")
	WebElement cityElem;
	
	@FindBy(id="card")
	WebElement cardElem;
	
	
	@FindBy(id="month")
	WebElement monthElem;
	
	@FindBy(id="year")
	WebElement yearElem;
	
	@FindBy(xpath="//*[contains(text(),'Purchase')]")
	WebElement purchaseElem;
	
	@FindBy(xpath="//*[contains(text(),'Thank you for your purchase!')]")
	WebElement successElem;
	
	@FindBy(xpath="//*[contains(text(),'OK')]")
	WebElement oK;
	
	@FindBy(id="logout2")
	WebElement logoutElem;
	
	
	
	public void selectMobile() {
		galaxyS6.click();
    }
	
	public void clickOnAddtoCart() {
		addToCart.click();
    }
	
	public void clickOnCart() {
		cart.click();
    }
	
	public void productVerify() {	
        Assert.assertTrue(productElem.isDisplayed(), "Product is NOT displayed in the cart!");
        System.out.println("Product is successfully displayed in the cart.");
		}
	
	public void clickOnPlaceOrder() {
		placeOrderElmt.click();
    }
	
	public void name() {
		nameElem.sendKeys("Nithin John");
	}
	
	public void country() {
		countryElem.sendKeys("India");
	}
	
	public void city() {
		cityElem.sendKeys("Trivandrum");
	}
	
	public void cc() {
		cardElem.sendKeys("5895-6954-6954-0252");
	}
	
	public void month() {
		monthElem.sendKeys("Jan");
	}
	
	public void year() {
		yearElem.sendKeys("2026");
	}
	
	public void clickOnPurchase() {
		purchaseElem.click();
	}
	
	public String getSuccessText() {
		return gu.getElementText(successElem);
	}
	
	public void clickOnoK() {
		oK.click();
	}
	
	public void clickOnLogout() {
		logoutElem.click();
	}
		
	  }

