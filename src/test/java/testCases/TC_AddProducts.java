package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Baseclass;
import pages.AddProducts_Pg;
import utilities.HomeVerification;
import utilities.Scroll;

public class TC_AddProducts extends Baseclass {
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled=false)
	public void tc12_addProductInCart() throws InterruptedException {
	HomeVerification vhp = new HomeVerification(driver);
	Scroll sc = new Scroll(driver);
	AddProducts_Pg ap = new AddProducts_Pg(driver);
	vhp.verifyHomePage();
	sc.scrollToElement(0,500);
	//ap.hoverOverImage2();
	
	ap.clickAddCartbuttonFst();
	ap.clickContiShopbutton();
	ap.clickAddCartbuttonSec();
	ap.clickViewCartbutton();

	String actualProd1 = ap.get1stProductText();
	String expectedProd1 = "Men Tshirt";
	sa.assertEquals(actualProd1, expectedProd1, "Text not visible");
	
	String actualPrice1 = ap.FstProdPrice400();
	String expectedPrice1 = "Rs. 400";
	sa.assertEquals(actualPrice1, expectedPrice1, "Price not visible");
	
	String actualProd2 = ap.get2ndProductText();
	String expectedProd2 = "Blue Top";
	Assert.assertEquals(actualProd2, expectedProd2, "Text not visible");

	String actualPrice2 = ap.SndProdPrice500();
	String expectedPrice2 = "Rs. 500";
	sa.assertEquals(actualPrice2, expectedPrice2, "Price not visible");

	sa.assertAll();
	
	
	}
	@Test
	public void tc13_verifyProductQTYinCart() throws InterruptedException {
	Scroll sc = new Scroll(driver);
	HomeVerification vhp = new HomeVerification(driver);
	AddProducts_Pg ap = new AddProducts_Pg(driver);
	vhp.verifyHomePage();
	sc.scrollToElement(0, 500);
	Thread.sleep(5000);
	ap.clickOnViewProduct();
	
	String actualProductTitle = driver.getTitle();
	String expectedProductTitile = "Automation Exercise - Product Details";
	Assert.assertEquals(actualProductTitle, expectedProductTitile, "Page not available");
	
	ap.qtyClear();
	
	ap.enterProductQTY();
	Thread.sleep(5000);
	ap.clickIMG();
	Thread.sleep(3000);
	ap.getProductQTYB4();
	Thread.sleep(3000);
	ap.addTocart();
	Thread.sleep(3000);
	ap.viewCart();
	Thread.sleep(3000);
	ap.getCartQTY();
	Thread.sleep(3000);
	
	String productQTY = ap.getProductQTYB4();
	String cartQTY = ap.getCartQTY();
	sa.assertEquals(productQTY, cartQTY,"Product QTY is missmatching");
	
	//Screenshots.captureScreenshot(driver, "Test Failed");
	
	sa.assertAll();
	
	}
}
