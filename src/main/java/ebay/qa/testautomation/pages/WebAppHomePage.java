package ebay.qa.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebAppHomePage extends WebAppPage{
	
	
	public WebAppHomePage(WebDriver d) {
		super(d);
	}

	public WebAppSearchResultsPage doSearch(String searchTerm){
		
		this.getWebDriver().findElement(By.id("gh-ac")).sendKeys(searchTerm);

		this.getWebDriver().findElement(By.id("gh-btn")).click();
		
		return new WebAppSearchResultsPage();
		
	}
	
}
