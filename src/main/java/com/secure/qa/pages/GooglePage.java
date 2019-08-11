package com.secure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secure.qa.base.TestBase;

public class GooglePage extends TestBase{
	
	@FindBy(xpath="//input[@title='Search']")
	@CacheLookup
	WebElement googleSearchEdit;
	
	@FindBy(xpath="//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")
	@CacheLookup
	WebElement googleSearchBTN;
	
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultsPage enterSearchData(String data) throws InterruptedException {
		googleSearchEdit.sendKeys(data);
		googleSearchBTN.click();
		waitForPageReady();
		
		return new SearchResultsPage();
	}
	

}
