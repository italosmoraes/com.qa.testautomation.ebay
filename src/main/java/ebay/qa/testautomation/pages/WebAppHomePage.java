package ebay.qa.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebAppHomePage extends WebAppPage{
	
	
	public WebAppHomePage(WebDriver d) {
		super(d);
	}

	public WebAppSearchResultsPage doSearch(String searchTerm){
		
		System.out.println("Performing search from Home Page");
		
		this.getWebDriver().findElement(By.id("gh-ac")).sendKeys(searchTerm);

		this.getWebDriver().findElement(By.id("gh-btn")).click();
		
		return new WebAppSearchResultsPage(this.getWebDriver());
		
	}

	public WebAppSearchResultsPage doSearchPerCategory(String searchTerm, String category){
		
		System.out.println("Performing search from Home Page for a Specific Category");
		
		this.getWebDriver().findElement(By.id("gh-ac")).sendKeys(searchTerm);
		
		WebElement selectDiv = this.getWebDriver().findElement(By.id("gh-cat-box"));
		Select catSelect = new Select(selectDiv.findElement(By.id("gh-cat")));
		
		catSelect.selectByVisibleText(category);

		this.getWebDriver().findElement(By.id("gh-btn")).click();
		
		return new WebAppSearchResultsPage(this.getWebDriver());
		
	}
	
}
