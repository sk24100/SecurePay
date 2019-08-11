package steps;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.secure.qa.base.TestBase;
import com.secure.qa.pages.ContactUsPage;
import com.secure.qa.pages.GooglePage;
import com.secure.qa.pages.SearchResultsPage;
import com.secure.qa.pages.SecurePayPage;
import com.secure.qa.util.RandomUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ContactUsPageTest extends TestBase {

	RandomUtil randomUtil = new RandomUtil();
	GooglePage googlePage;
	SearchResultsPage searchResultsPage;
	SecurePayPage securePayPage;
	ContactUsPage contactUsPage;

	public ContactUsPageTest() {
		super();
	}

	@Given("^(?:i|I) launch contactus page from secure pay$")
	public void setUp() throws InterruptedException {
		initialization();
		googlePage = new GooglePage();
		searchResultsPage = googlePage.enterSearchData(prop.getProperty("usersearch"));
		securePayPage = searchResultsPage.clickOnSecurePay();
		contactUsPage = securePayPage.clickOnContactUs();
	}

	@Then("^(?:i|I) should be able validate if contactus page is loaded$")
	public void verifyContactUsPageLoads() {
		String title = contactUsPage.verifyContactPageTitle();

		Assert.assertTrue(title.contains("Contact Us – SecurePay"), "Contact us page not reachable");
	}

	@And("^(?:i|I) enter random value in First Name$")
	public void enterRandomFirstName() {
		String randomText = randomUtil.getRandomString(3, 10);
		contactUsPage.enterFirstName(randomText);
	}

	@And("^(?:i|I) enter random value in Last Name$")
	public void enterRandomLastName() {
		String randomText = randomUtil.getRandomString(4, 9);
		contactUsPage.enterLastName(randomText);
	}

	@And("^(?:i|I) enter random value in Email$")
	public void enterRandomEmail() {
		String randomText = randomUtil.getRandomEmail();
		contactUsPage.enterEmail(randomText + "@gmail.com");
	}

	@And("^(?:i|I) enter random Phone$")
	public void enterPhone() {
		String randomText = randomUtil.getRandomInteger();
		contactUsPage.enterphoneNumber(randomText);
	}

	@And("^(?:i|I) enter random URL$")
	public void enterURL() {
		String randomText = randomUtil.getRandomString(5, 7);
		contactUsPage.enterWebsiteURL("https://www." + randomText + ".com");
	}

	@And("^(?:i|I) enter random company Name$")
	public void enterCompanyName() throws InterruptedException {
		String randomText = randomUtil.getRandomString(5, 11);
		contactUsPage.enterCompanyName(randomText);
	}

	@And("^(?:i|I) enter random reason$")
	public void enterReason() throws InterruptedException {
		String reason = randomUtil.getRandomReason();
		contactUsPage.enterReason(reason);

	}

	@Then("^(?:i|I) close the browser$")
	public void tearDown() {
		driver.quit();
	}

}
