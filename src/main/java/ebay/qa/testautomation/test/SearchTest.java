package ebay.qa.testautomation.test;

import org.junit.Assert;

import cucumber.api.java.en.And;
import ebay.qa.testautomation.pages.WebAppHomePage;
import ebay.qa.testautomation.pages.WebAppSearchResultsPage;
import ebay.qa.testautomation.reps.TestSearchResultItemCard;

public class SearchTest {

	private SystemTest t = new SystemTest();

	@And("^I navigate to '(.*)'")
	public void testSearchAllCategories(String url) {

		String searchText = "xbox";

		t.getTestDriver().get(url);

		WebAppHomePage wbp = new WebAppHomePage(t.getTestDriver());
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

		t.getTestDriver().get("");

		WebAppHomePage wbp = new WebAppHomePage(t.getTestDriver());
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
