package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProducts_Pg {
	
	String QTY ="4";
	
	WebDriver driver;
	
	public AddProducts_Pg(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href, '/products')]")
	WebElement products;
	
	@FindBy(xpath="//img[contains(@src,'get_product_picture/2')]")
	WebElement image2;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
	WebElement fstProductaddTocart;
	
	@FindBy(xpath="//*[contains(text(),'Continue Shopping')]")
	WebElement contShopping;
	
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")
	WebElement secProductaddTocart;
	
	@FindBy(xpath="//*[contains(text(),'View Cart')]")
	WebElement viewCart;
	
	
	@FindBy(xpath="//*[contains(text(),'Men Tshirt')]")
	WebElement product1;
	
	@FindBy(xpath="//*[contains(text(),'400') and @class ='cart_total_price']")
	WebElement price1;
	
	
	@FindBy(xpath="//*[contains(text(),'Blue Top')]")
	WebElement product2;
	
	@FindBy(xpath="//*[contains(text(),'500') and @class ='cart_total_price']")
	WebElement price2;
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	WebElement firstProduct;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement beforeQTY;
	
	@FindBy(xpath="quantity")
	WebElement afterQTY;
	
	@FindBy(xpath="//button[@type='button']") 
	WebElement addToCart;
	
	@FindBy(xpath="//*[contains(text(),'4') and @class ='disabled']")
	WebElement cartQTY;
	
	@FindBy(xpath="//img[contains(@src,'get_product_picture/1')]")
	WebElement clickImage;
	
	public void ClickonProductButton() {
		products.click();
	}
	
	public void hoverOverImage2() {
		Actions action = new Actions(driver);
		action.moveToElement(image2).perform();
	}
	
	public void clickAddCartbuttonFst() {
		fstProductaddTocart.click();
	}
	
	public void clickContiShopbutton() {
		contShopping.click();
	}
	
	public void clickAddCartbuttonSec() {
		secProductaddTocart.click();
	}
	
	public void clickViewCartbutton() {
		viewCart.click();
	}
	
	public String get1stProductText() {
		String verifyProduct1 = product1.getText();
		return verifyProduct1;
	}
	
	public String FstProdPrice400() {
		return price1.getText();
	}
	
	public String get2ndProductText() {
		String verifyProduct2 = product2.getText();
		return verifyProduct2;
	}
	
	public String SndProdPrice500() {
		return price2.getText();
	}
	
	public void clickOnViewProduct() {
		firstProduct.click();
	}
	
	public void qtyClear() {
		beforeQTY.clear();
	}
	
	public void enterProductQTY() {
		beforeQTY.sendKeys("4");
		
	}
	
	public void clickIMG() {
		clickImage.click();
	}
	
	public String getProductQTYB4() {
	@SuppressWarnings("deprecation")
	String enteredString= beforeQTY.getAttribute("value");
	System.out.println("Entered String=" + enteredString);
	return enteredString;
	}
	
	public void addTocart() { 
		addToCart.click(); 	
	}
	
	public void viewCart() {	
		viewCart.click();
	}
	
	public String getCartQTY() {
	String verifyCartQTY = cartQTY.getText();
	System.out.println("Cart QTY=" +verifyCartQTY);
	return verifyCartQTY;
	}

}
