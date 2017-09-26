package ebay.qa.testautomation.test;

import java.util.ArrayList;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.qa.testautomation.pages.WebAppHomePage;
import ebay.qa.testautomation.pages.WebAppSearchResultsPage;
import ebay.qa.testautomation.reps.TestSearchResultItemCard;

public class SearchTest {

	private SystemTest t = new SystemTest();

	WebAppHomePage wbp;

	WebAppSearchResultsPage searchrp;
	
	String searchText;
	
	ArrayList<TestSearchResultItemCard> resultCards;

	@And("^I navigate to '(.*)'")
	public void testSearchAllCategories(String url) {

		t.getTestDriver().get(url);

		Assert.assertTrue(t.getTestDriver().getCurrentUrl().contains(url.replace("http://", "")));

	}

	@When("^I search for an item: '(.*)'")
	public void doSearch(String item) {

		wbp = new WebAppHomePage(t.getTestDriver());

		searchText = item;
		
		searchrp = wbp.doSearch(item);

		Assert.assertTrue(searchrp.getNoOfResultsText().contains(item));

		// get all the cards
		resultCards = searchrp.getAllResultItemCards();

		Assert.assertTrue(searchrp.verifyResultsItemCardsContentDisplayed());

	}
	
	@Then("^I get a list of matching results")
	public void verifySearchResults(){
		
		// verify result matches search
		for (TestSearchResultItemCard item : resultCards) {
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

		// click 5-10 of the links

		// check in which category they are shown

		// go back to the results page

		for (TestSearchResultItemCard item : searchrp.getAllResultItemCards()) {
			Assert.assertTrue(item.getTitleText().contains(searchText));
		}
	}

}
