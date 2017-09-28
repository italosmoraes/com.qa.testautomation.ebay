package ebay.qa.testautomation.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ebay.qa.testautomation.reps.TestSearchResultItemCard;
import ebay.qa.testautomation.test.SystemTest;

public class WebAppSortSearchResultsFeature {
	
	private final WebDriver webDriver;

	public WebAppSortSearchResultsFeature() {
		webDriver = SystemTest.testDriver.getDriver();
	}
	
	/**
	 * Select a criteria for sorting
	 * 
	 * @param criteria
	 */
	public void sortResultsBy(String criteria){
		
		WebElement sortList = webDriver.findElement(By.id("DashSortByContainer"));
		
		sortList.click();
		
		sortList.findElement(By.id("SortMenu")).findElement(By.linkText(criteria)).click();
		
		System.out.println("Selected sort criteria: " + criteria);
		
	}
	
	/**
	 * From current results in the page, verify order
	 * 
	 * @param resultsShown
	 */
	public void verifyCurrentSortOrder(ArrayList<TestSearchResultItemCard> resultsShown, String criteria){
		
		for(int x=0; x < resultsShown.size(); x++){
			
			
			
			
			
			
		}
		
	}

}
