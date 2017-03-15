package ebay.qa.testautomation.util;

/**
 * Manages the data loading and usage during the tests
 * 
 * @author Italo
 *
 */

public class ActiveData {

	private String dataRecord;

	public ActiveData() {

	}

	public void addDataRecord(String data) {
		this.dataRecord = data;
	}
	
	public String getDataRecord(){
		return dataRecord;
	}

}
