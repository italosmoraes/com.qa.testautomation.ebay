package ebay.qa.testautomation.test;

import cucumber.api.java.en.And;
import ebay.qa.testautomation.pages.WebAppSearchResultsPage;
import ebay.qa.testautomation.pages.WebAppSortSearchResultsFeature;

public class SearchResultsSortingTest{
	
	WebAppSortSearchResultsFeature sortf = new WebAppSortSearchResultsFeature();

	/**
	 * And I can sort the item by Best Match, Lowest Price + P&P, Highest Price, Newly listed, etc
	 * one method per each search form?
	 * 
	 * @param of
	 * @return
	 */
	
	@And("^I can sort the results by '(.*)'")
	public void sortResultsBy(String criteria){
		
		sortf.sortResultsBy(criteria);
		
		System.out.println("Verifying the sorting order...");
		
		
		
	}
	

}
