package ebay.qa.testautomation.test;

import org.openqa.selenium.WebElement;

import ebay.qa.testautomation.pages.WebAppSearchResultsPage;
import ebay.qa.testautomation.pages.WebAppUKHomePage;
import junit.framework.Assert;

/**
 * Represents the test of the search functionality on the top right of the
 * website
 * 
 * @author Italo
 *
 */

public class SearchBarTest extends SystemTest {

	public SearchBarTest(String testName) {
		super(testName);

	}

	public void testSearchPositive() {
		WebAppUKHomePage hp = new WebAppUKHomePage(SystemTest.testDriver.driver);

		SystemTest.activeData.addDataRecord("business card");

		// execute search
		WebAppSearchResultsPage rp = hp.doSearch(SystemTest.activeData.getDataRecord());

		Assert.assertTrue(
				rp.getResultsTitle().contains("Results for \"" + SystemTest.activeData.getDataRecord() + "\""));

		WebElement resultsCard = rp.getResultsCardShown();

		Assert.assertTrue(resultsCard.getText().contains(SystemTest.activeData.getDataRecord()));

		// TODO verify the results are shown in bold

		// TODO verify the resuls in the gsc-table-result div class

		// TODO verify the results in the gsc-expansionArea in both the title
		// and body levels

	}

	public void testSearchNegative() {
		WebAppUKHomePage hp = new WebAppUKHomePage(this.testDriver.driver);

		SystemTest.activeData.addDataRecord("sdjfnjsdfj");

		// execute search
		WebAppSearchResultsPage rp = hp.doSearch(SystemTest.activeData.getDataRecord());

		Assert.assertTrue(
				rp.getResultsTitle().contains("Results for \"" + SystemTest.activeData.getDataRecord() + "\""));

		WebElement errorCard = rp.getNoResultsDiv();

		Assert.assertTrue(errorCard.getText().contains(
				"Sorry we couldn’t find anything. Please check the spelling or alternatively chat to our friendly customer services team using the chat below."));
	}
	// TODO verify results pages numbers and relevance of content

	// TODO verify relevance of the results

	// TODO verify any levels of matching -like from the product profile, or
	// form the
	// description, or from links, etc

}
