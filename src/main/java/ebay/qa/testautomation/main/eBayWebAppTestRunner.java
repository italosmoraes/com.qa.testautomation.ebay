package ebay.qa.testautomation.main;

import junit.framework.TestResult;
import junit.textui.ResultPrinter;

import java.util.Enumeration;

import org.junit.*;

import ebay.qa.testautomation.test.SystemTest;

/**
 * Main test program execution class
 * 
 * @author Italo
 *
 */

public class eBayWebAppTestRunner {

	public static void main(String[] args) {

		System.out.println("Running eBay Tests as a Java Program");

		SystemTest testC = new SystemTest("Full Regression Test", "http://www.ebay.co.uk", "chrome");
		SystemTest testF = new SystemTest("Full Regression Test", "http://www.ebay.co.uk", "firefox");
		
		//TestResult resultsC = junit.textui.TestRunner.run(testC.suite());
		TestResult resultsF = junit.textui.TestRunner.run(testF.suite());
		
		

		//getResults(resultsC, testC.getName());
		getResults(resultsF, testF.getName());


	}
	
	public static void getResults(TestResult res, String suiteName){
		if (res.errorCount() > 0) {
			Enumeration e = res.failures();
			while (e.hasMoreElements()) {
				System.out.println(e.nextElement());
			}

		}
		
		System.out.println("Test success, " + suiteName + ": " + res.wasSuccessful());

	}

}
