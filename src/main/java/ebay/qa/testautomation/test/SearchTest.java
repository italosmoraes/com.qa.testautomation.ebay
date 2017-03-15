package ebay.qa.testautomation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

		getTestDriver().findElement(By.id("gh-ac")).sendKeys(searchText);

		getTestDriver().findElement(By.id("gh-btn")).click();
		
		//verify No of Results for item
		String resultsNo = getTestDriver().findElement(By.className("rsHdr")).findElement(By.className("rcnt")).getText();
		String resultsText = getTestDriver().findElement(By.className("rsHdr")).findElement(By.className("kwcat")).getText();
		
		Assert.assertTrue(!resultsNo.isEmpty());
		Assert.assertTrue(resultsText.contains("results for " + searchText));
		
		//verify searchResultsCards presented have the searchItem in the titl
		List<WebElement> resultsList = getTestDriver().findElements(By.className("sresult"));
		System.out.println("Found " + resultsList.size() + " results Items in the first page");
		
		for(WebElement resultItemRow: resultsList){
			Assert.assertTrue(resultItemRow.findElement(By.className("lvtitle")).getText().toLowerCase().contains(searchText.toLowerCase()));
			System.out.println("Result item " + resultItemRow.getAttribute("id") + "has expected search term");
			
			Assert.assertTrue(resultItemRow.findElement(By.className("lvprice")).isDisplayed());
			Assert.assertTrue(resultItemRow.findElement(By.className("lvformat")).isDisplayed());
			Assert.assertTrue(resultItemRow.findElement(By.className("lvshipping")).isDisplayed());
			
			WebElement e = resultItemRow.findElement(By.className("lvformat"));
			String lvformatText = e.getText();
			if(lvformatText.length() == 0){
				Assert.assertTrue(resultItemRow.findElement(By.className("logoBin")).isDisplayed());
			}
			
			
			
			
			
		}
		
		//And the resulting items cards have: postage price, No of bids, price or show BuyItNow tag
		

	}

	public void testSearchSpecificCategory(String searchTerm, String category) {

	}

}
