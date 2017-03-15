package ebay.qa.testautomation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ebay.qa.testautomation.pages.WebAppAccountSignInPage;
import ebay.qa.testautomation.pages.WebAppUKHomePage;
import junit.framework.Assert;

public class AccountSignInTest extends SystemTest {

	public AccountSignInTest(String testName) {
		super(testName);
	}

	public void testSignInSuccess() {
		// TODO implement
	}

	public void testSignInFailed() {
		WebAppUKHomePage hp = new WebAppUKHomePage(SystemTest.testDriver.driver);

		SystemTest.activeData.addDataRecord("username@email.com");

		WebAppAccountSignInPage asp = hp.goToSignIn();

		asp.signIn(SystemTest.activeData.getDataRecord(), "testDataPass8876");

		Assert.assertTrue(SystemTest.testDriver.driver.getCurrentUrl().contains("/account/signin"));

		Assert.assertTrue(SystemTest.testDriver.driver.findElement(By.className("has-error-msg")).getText()
				.contains("Oops! There's a problem. It might be one of the following:"));

		Assert.assertTrue(SystemTest.testDriver.driver.findElement(By.className("has-error-msg")).getText()
				.contains("Your password or email doesn't match what we have for you. Please try again."));

		Assert.assertTrue(SystemTest.testDriver.driver.findElement(By.className("has-error-msg")).getText()
				.contains("You previously signed in with Facebook. If so, try that route."));

		Assert.assertTrue(SystemTest.testDriver.driver.findElement(By.className("has-error-msg")).getText()
				.contains("You haven't yet signed up for an account"));

		// TODO verify properties of the text shown
	}

	public void testSignInUserHasNoAccountFormIsShown() {
		WebAppUKHomePage hp = new WebAppUKHomePage(SystemTest.testDriver.driver);

		WebAppAccountSignInPage asp = hp.goToSignIn();

		asp.showRegisterNewAccountForm();

		WebElement container = SystemTest.testDriver.driver.findElement(By.className("signUpFormContainer"));

		Assert.assertTrue(container.getText().contains("Create an account"));
		
		Assert.assertTrue(container.getText().contains("First name"));
		
		Assert.assertTrue(container.getText().contains("Last name"));
		
		Assert.assertTrue(container.getText().contains("Email address"));
		
		Assert.assertTrue(container.getText().contains("Password"));
		
		Assert.assertTrue(container.getText().contains("Confirm password"));
		
		Assert.assertTrue(container.getText().contains("Where are you?"));
	}

}
