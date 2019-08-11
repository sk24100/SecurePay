package com.secure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secure.qa.base.TestBase;

import junit.framework.Assert;

public class SearchResultsPage extends TestBase {

	@FindBy(xpath="//div[@id='tvcap']//h3[contains(text(),'SecurePay')]")
	@CacheLookup
	WebElement securePayLnk;
	
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public SecurePayPage clickOnSecurePay() throws InterruptedException {
		securePayLnk.click();		
		Thread.sleep(4000);
		
		return new SecurePayPage();
	}
}
