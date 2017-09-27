package ebay.qa.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
