package ebay.qa.testautomation.pages;

import org.openqa.selenium.WebDriver;

public class WebAppPage {
	
	private final WebDriver webDriver;
	
	public WebAppPage(WebDriver d){
		webDriver = d;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	
	
}
