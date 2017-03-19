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
	}

	public int getNoOfResults() {

		String resultsNo = this.getWebDriver().findElement(By.className("rsHdr")).findElement(By.className("rcnt"))
				.getText();

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
		// verify searchResultsCards presented have the searchItem in the title
		List<WebElement> resultsList = getWebDriver().findElements(By.className("sresult"));
		System.out.println("Found " + resultsList.size() + " results Items in the first page");

		ArrayList<TestSearchResultItemCard> resultCardsList = new ArrayList<TestSearchResultItemCard>();

		TestSearchResultItemCard itemCard = null;

		for (WebElement card : resultsList) {

			itemCard = new TestSearchResultItemCard();

			itemCard.setId(card.getAttribute("id"));

			itemCard.setTitleText(card.findElement(By.className("lvtitle")).getText());

			itemCard.setOfferPriceText(card.findElement(By.className("lvprice")).getText());

			// shows postage price
			itemCard.setShipPriceText(card.findElement(By.className("lvshipping")).getText());

			// shows type of offering, if bid or buyitnow
			WebElement offerFormat = card.findElement(By.className("lvformat"));
			itemCard.setNoOfBidsText(card.findElement(By.className("lvformat")).getText());
			if(offerFormat.)

			// Shows Buy it Now tag if the type is not bid

		}

		return resultCardsList;
	}

}
