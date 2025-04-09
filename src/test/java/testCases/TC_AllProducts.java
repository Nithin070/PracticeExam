package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Baseclass;
import pages.AllProducts_Pg;
import utilities.HomeVerification;
import utilities.Scroll;

public class TC_AllProducts extends Baseclass {
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void tc08_VerifyAllProducts_and_ProductDetailPage() throws InterruptedException {
		
	AllProducts_Pg ap = new AllProducts_Pg(driver);
	
	String actualHomePageTitle = driver.getTitle();
	String expectedHomePageTitile = "Automation Exercise";
	Assert.assertEquals(actualHomePageTitle, expectedHomePageTitile, "Page not available");
	
	ap.ClickonProductButton();
	
	String actualAllProductsPageTitle = driver.getTitle();
	String expectedAllProductsPageTitle = "Automation Exercise - All Products";
	sa.assertEquals(actualAllProductsPageTitle, expectedAllProductsPageTitle, "Page not available");
	
	ap.scrollToElement();
	 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/product_details/1']")));
	
	ap.ClickonViewProduct();
	
	}
	
	@Test
	public void tc09_SearchProduct() {
		
	AllProducts_Pg ap = new AllProducts_Pg(driver);
	
	String actualHomePageTitle = driver.getTitle();
	String expectedHomePageTitile = "Automation Exercise";
	Assert.assertEquals(actualHomePageTitle, expectedHomePageTitile, "Page not available");
	
	ap.ClickonProductButton();
	
	String actualAllProductsPageTitle = driver.getTitle();
	String expectedAllProductsPageTitle = "Automation Exercise - All Products";
	sa.assertEquals(actualAllProductsPageTitle, expectedAllProductsPageTitle, "Page not available");
	
	ap.scrollToElement();
	ap.ClickonSearchbox();
	ap.searchboxInput();
	ap.searchButton();
	ap.searchInputclear();
	
	String actualSearchProductText = ap.getTextsearchedProduct();
	String expectedSearchProductText = "Stylish Dress";
	sa.assertEquals(actualSearchProductText,expectedSearchProductText, "Product not found");
	
	sa.assertAll();
	}
	
	@Test
	public void tc10_SubscriptionInhomePage() throws InterruptedException {
	
	AllProducts_Pg ap = new AllProducts_Pg(driver);
	HomeVerification vhp = new HomeVerification(driver);
	Scroll sc = new Scroll(driver);
	
	vhp.verifyHomePage();
	sc.scrollToElement(0, 8200);
	ap.inputEmailBox();
	ap.clickOnSubscribeButton();
	
	String actualSubscribeText = ap.getSuccessText();
	String expectedSubscribeText = "You have been successfully subscribed!";
	sa.assertEquals(actualSubscribeText, expectedSubscribeText, "Message not visible");
	
	sa.assertAll();
	}
	
	@Test
	public void tc11_SubscriptionInCart() throws InterruptedException {
	
	AllProducts_Pg ap = new AllProducts_Pg(driver);
	HomeVerification hv = new HomeVerification(driver);
	
	
	hv.verifyHomePage();
	ap.clickOnCart();

	String actualSubText = ap.getSubscribeText();
	String expectedSubText = "SUBSCRIPTION";
	sa.assertEquals(actualSubText, expectedSubText, "Text not visible");
	
	ap.inputEmailBox();
	ap.clickOnSubscribeButton();
	
	String actualSubscribeText = ap.getSuccessText();
	String expectedSubscribeText = "You have been successfully subscribed!";
	sa.assertEquals(actualSubscribeText, expectedSubscribeText, "Message not visible");
	
	sa.assertAll();
    }
}