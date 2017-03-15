package ebay.qa.testautomation.test;

import org.openqa.selenium.WebDriver;

import ebay.qa.testautomation.util.ActiveData;
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

	private TestDriver testDriver;
	private String browser;
	private ActiveData activeData;
	private String urlUnderTest;
	private TestSuite suite;

	public SystemTest(String testName) {
		super(testName);
		browser = "chrome";
		urlUnderTest = "http://www.ebay.co.uk";
	}
	
	public SystemTest(String testName, String url, String b){
		super(testName);
		urlUnderTest = url;
		browser = b;
	}

	// rump up
	public void setUp() {

		System.out.println("Initiating test: " + this.getName());

		//get data
		activeData = new ActiveData();
		
		// get parameters
		setTestDriver(browser);

		getTestDriver().navigate().to(urlUnderTest); 
		
		

	}

	public void tearDown() {

		//getTestDriver().quit();

		System.out.println("Tests ran: " + suite.countTestCases());

		System.out.println("Finalizing tests.");

	}

	public Test suite() {
		suite = new TestSuite();
		suite.addTest(new SearchTest("testSearchAllCategories", urlUnderTest, browser));
		//suite.addTest(new SearchTest("testSearchSpecificCategory"));
		
		
		return suite;
	}

	public WebDriver getTestDriver() {
		return testDriver.getDriver();
	}

	public void setTestDriver(String d) {
		testDriver = new TestDriver(d);
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String b) {
		browser = b;
	}

	public ActiveData getActiveData() {
		return activeData;
	}

	public void setActiveData(ActiveData a) {
		activeData = a;
	}

	public String getUrlUnderTest() {
		return urlUnderTest;
	}

	public void setUrlUnderTest(String u) {
		urlUnderTest = u;
	}

	public TestSuite getSuite() {
		return suite;
	}

	public void setSuite(TestSuite s) {
		suite = s;
	}
	
	
}
