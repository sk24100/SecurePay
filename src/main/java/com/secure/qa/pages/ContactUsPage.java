package com.secure.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.secure.qa.base.TestBase;

public class ContactUsPage extends TestBase {
	
	@FindBy(name="first-name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name="last-name")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="email-address")
	@CacheLookup
	WebElement emailAddress;
	
	@FindBy(name="phone-number")
	@CacheLookup
	WebElement phoneNumber;
	
	@FindBy(name="website-url")
	@CacheLookup
	WebElement websiteUrl;
	
	@FindBy(name="business-name")
	@CacheLookup	
	WebElement businessName;
	
	@FindBy(xpath="//select[@name='reason-for-enquiry']")
	@CacheLookup	
	WebElement reasonForEnquiry;
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactPageTitle() {
		return driver.getTitle();
		
	}
	
	public void enterFirstName(String randomdata) {
		firstName.clear();
		firstName.sendKeys(randomdata);
	}
	
	public void enterLastName(String randomdata) {
		lastName.clear();
		lastName.sendKeys(randomdata);
	}
	
	public void enterEmail(String randomdata) {
		emailAddress.clear();
		emailAddress.sendKeys(randomdata);
	}
	
	public void enterphoneNumber(String randomdata) {
		phoneNumber.sendKeys(randomdata);
	}
	
	public void enterWebsiteURL(String randomdata) {
		websiteUrl.clear();
		websiteUrl.sendKeys(randomdata);
	}
	
	public void enterCompanyName(String randomdata) {
		businessName.clear();
		businessName.sendKeys(randomdata);
	}
	
	public void enterReason(String randomdata) {
		new Select(reasonForEnquiry).selectByValue(randomdata);
	}

}
