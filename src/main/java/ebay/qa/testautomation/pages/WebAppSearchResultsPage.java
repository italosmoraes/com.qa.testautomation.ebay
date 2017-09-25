package ebay.qa.testautomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ebay.qa.testautomation.reps.TestSearchResultItemCard;
import junit.framework.Assert;

public class WebAppSearchResultsPage extends WebAppPage {

	private ArrayList<TestSearchResultItemCard> resultItemCards;

	public WebAppSearchResultsPage(WebDriver d) {
		super(d);
		resultItemCards = new ArrayList<TestSearchResultItemCard>();
	}

	public int getNoOfResults() {

		String resultsNo = this.getWebDriver().findElement(By.className("rsHdr")).findElement(By.className("rcnt"))
				.getText();

		// TODO needs a number handler

		return Integer.getInteger(resultsNo);
	}

	public String getNoOfResultsText() {

		return this.getWebDriver().findElement(By.className("rsHdr")).findElement(By.className("kwcat")).getText();

	}

	/**
	 * goes through each card to get the details displayed
	 * 
	 */
	public void getItemCardDetails(int itemIndex) {

	}

	/**
	 * gets all cards displayed
	 * 
	 */
	public ArrayList<TestSearchResultItemCard> getAllResultItemCards() {

		System.out.println("Getting all the search results Item Cards");

		List<WebElement> resultsList = getWebDriver().findElements(By.className("sresult"));
		System.out.println("Found " + resultsList.size() + " results Items in the first page");

		TestSearchResultItemCard itemCard = null;

		for (WebElement card : resultsList) {

			itemCard = new TestSearchResultItemCard();

			itemCard.setId(card.getAttribute("id"));

			itemCard.setTitleText(card.findElement(By.className("lvtitle")).getText());

			itemCard.setOfferPriceText(card.findElement(By.className("lvprice")).getText());

			// shows postage price
			itemCard.setShipPriceText(card.findElement(By.className("lvshipping")).getText());

			// shows type of offering, if bid or buyitnow
			// may contain bids or title=buyt it now or classified ad or
			// buyitnoworbestoffer
			// does not matter at this point, I only need to know if: lvformat
			// has a title or a "bid" text
			WebElement offerFormat = card.findElement(By.className("lvformat"));
			String lvformat = card.findElement(By.className("lvformat")).getText();
			if (lvformat == "") {
				itemCard.setOfferType(card.findElement(By.className("lvformat")).getAttribute("title"));
			} else {
				itemCard.setOfferType(lvformat);
			}

			this.resultItemCards.add(itemCard);

		}

		return this.resultItemCards;
	}

	public boolean verifyResultsItemCardsContentDisplayed() {

		System.out.println("Verifying card items content");

		boolean contentDisplayed = false;

		for (TestSearchResultItemCard card : this.resultItemCards) {
			WebElement item = this.getWebDriver().findElement(By.id(card.getId()));

			contentDisplayed = item.findElement(By.className("lvtitle")).isDisplayed();

			contentDisplayed = item.findElement(By.className("lvprice")).isDisplayed();

			contentDisplayed = item.findElement(By.className("lvshipping")).isDisplayed();

			contentDisplayed = item.findElement(By.className("lvformat")).isDisplayed();

		}

		if (contentDisplayed) {
			System.out.println("All Result Items content displayed correctly");
		} else {
			System.out.println("Error displaying content");
		}

		return contentDisplayed;
	}
	
	public boolean verifyResultItemsMatchesSearch(String searchText){
		
		System.out.println("Verifying results matches the search text:" + searchText);
		return false;
		
	}
	

	public boolean verifyResultItemsMatchesSearchVariations(String searchText){
		
		//need to know how the website handles variations like PS4 and playstation 4!
		
		System.out.println("Verifying results matches the search text or registered variations:" + searchText);
		return false;
	}

}
