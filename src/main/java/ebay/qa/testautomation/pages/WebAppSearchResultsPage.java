package ebay.qa.testautomation.pages;

import java.util.List;

import org.openqa.selenium.By;

import ebay.qa.testautomation.reps.TestSearchResultItemCard;

public class WebAppSearchResultsPage extends WebAppPage{
	
	private List<TestSearchResultItemCard> resultItemCards;
	
	public int getNoOfResults(){
		
		String resultsNo = this.getWebDriver().findElement(By.className("rsHdr")).findElement(By.className("rcnt")).getText();
		
		return Integer.getInteger(resultsNo);
	}
	
	public void verifyNoOfResultsText(){
		
		String resultsText = this.getWebDriver().findElement(By.className("rsHdr")).findElement(By.className("kwcat")).getText();
		
		
		
	}
	
	
	/**
	 * goes through each card to get the details displayed
	 * 
	 */
	public void getItemCardDetails(int itemIndex){
		
	}
	
	/**
	 * gets all cards displayed
	 * 
	 */
	public List<TestSearchResultItemCard> getAllResultItemCards(){
		
	}

}
