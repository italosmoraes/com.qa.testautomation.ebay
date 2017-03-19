package ebay.qa.testautomation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ebay.qa.testautomation.pages.WebAppHomePage;
import ebay.qa.testautomation.pages.WebAppSearchResultsPage;
import ebay.qa.testautomation.reps.TestSearchResultItemCard;
import junit.framework.Assert;

public class SearchTest extends SystemTest {

	public SearchTest(String testName) {
		super(testName);
	}

	public SearchTest(String testName, String url, String b) {
		super(testName, url, b);
	}

	public void testSearchAllCategories() {

		String searchText = "xbox";

		getTestDriver().get(getUrlUnderTest());

		WebAppHomePage wbp = new WebAppHomePage(getTestDriver());
		WebAppSearchResultsPage searchrp = wbp.doSearch(searchText);

		Assert.assertTrue(searchrp.getNoOfResults() > 0);
		Assert.assertTrue(searchrp.getNoOfResultsText().contains("results for " + searchText));
		
		//get all the cards
		
		//verify the card elements shown for each card

	}

	public void testSearchSpecificCategory(String searchTerm, String category) {

	}

}
