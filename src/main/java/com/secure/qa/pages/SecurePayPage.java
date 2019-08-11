package com.secure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secure.qa.base.TestBase;

public class SecurePayPage extends TestBase {
	
	@FindBy(css="img[src*='securepay/images/logo.svg']")
	@CacheLookup
	WebElement securePayImg;
	
	@FindBy(css=".menu-support-container a[data-description='Support:Contact Us']")
	@CacheLookup
	WebElement contactUsLnk;
	
	public SecurePayPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySecurePageImage() {
		return securePayImg.isDisplayed();
		
	}
	
	public ContactUsPage clickOnContactUs() throws InterruptedException {
		
		contactUsLnk.click();
		Thread.sleep(3000);
		
		return new ContactUsPage();
	}

}
