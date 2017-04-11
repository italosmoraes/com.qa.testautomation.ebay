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

		// Assert.assertTrue(searchrp.getNoOfResults() > 0);
		Assert.assertTrue(searchrp.getNoOfResultsText().contains("results for " + searchText));

		// get all the cards
		searchrp.getAllResultItemCards();

		Assert.assertTrue(searchrp.verifyResultsItemCardsContentDisplayed());

		// verify result matches search
		for(TestSearchResultItemCard item : searchrp.getAllResultItemCards()){
			System.out.println(item.getId() + ":" + " has title " + item.getTitleText());
			Assert.assertTrue(item.getTitleText().toLowerCase().contains(searchText.toLowerCase()));
		}

	}

	/**
	 * Then the search results combination match the item+category correctly
	 * 
	 * @param searchTerm
	 * @param category
	 */
	public void testSearchSpecificCategory() {
		String searchText = "xbox";
		String category = "Books, Comics & Magazines";

		getTestDriver().get(getUrlUnderTest());

		WebAppHomePage wbp = new WebAppHomePage(getTestDriver());
		WebAppSearchResultsPage searchrp = wbp.doSearchPerCategory(searchText, category);

		// Assert.assertTrue(searchrp.getNoOfResults() > 0);
		Assert.assertTrue(searchrp.getNoOfResultsText().contains("results for " + searchText));

		// get all the cards
		searchrp.getAllResultItemCards();

		Assert.assertTrue(searchrp.verifyResultsItemCardsContentDisplayed());

		// verify result matches search
		
		//click 5-10 of the links
		
		//check in which category they are shown
		
		//go back to the results page
		
		for(TestSearchResultItemCard item : searchrp.getAllResultItemCards()){
			Assert.assertTrue(item.getTitleText().contains(searchText));
		}
	}

}
