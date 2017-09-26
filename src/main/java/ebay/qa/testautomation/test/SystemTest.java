package ebay.qa.testautomation.test;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ebay.qa.testautomation.util.TestDriver;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Represents the actions and attributes common to all tests and manages the
 * execution of all implemented tests
 * 
 * @author Italo
 *
 */

public class SystemTest extends TestCase {

	public static TestDriver testDriver;
	public static String browser;

	public SystemTest() {

	}

	// rump up
	@Before
	public void setUp() {

		System.out.println("Initiating test");

		// default browser
		browser = "chrome";

		System.out.println("Using default browser: " + browser);

		// get parameters
		setTestDriver(browser);

	}

	@After
	public void tearDown() {

		System.out.println("Finalizing tests.");

	}

	public WebDriver getTestDriver() {
		return testDriver.getDriver();
	}

	public void setTestDriver(String d) {
		testDriver = new TestDriver(d);
	}

}
