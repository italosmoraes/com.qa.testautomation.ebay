package ebay.qa.testautomation.reps;

/**
 * Representation of the results item card
 */

public class TestSearchResultItemCard {

	private String id;
	private String titleText;
	private String shipPriceText;
	private String offerPriceText;
	private String noOfBidsText; //only if type is "auction"
	private String offerType;
	private boolean buyItNowTagShown;

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getShipPriceText() {
		return shipPriceText;
	}

	public void setShipPriceText(String shipPriceText) {
		this.shipPriceText = shipPriceText;
	}

	public String getOfferPriceText() {
		return offerPriceText;
	}

	public void setOfferPriceText(String offerPriceText) {
		this.offerPriceText = offerPriceText;
	}

	public String getNoOfBidsText() {
		return noOfBidsText;
	}

	public void setNoOfBidsText(String noOfBidsText) {
		this.noOfBidsText = noOfBidsText;
	}

	public boolean isBuyItNowTagShown() {
		return buyItNowTagShown;
	}

	public void setBuyItNowTagShown(boolean buyItNowTagShown) {
		this.buyItNowTagShown = buyItNowTagShown;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	
	

}
