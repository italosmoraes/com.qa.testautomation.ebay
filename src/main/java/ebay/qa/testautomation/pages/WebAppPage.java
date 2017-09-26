package ebay.qa.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebAppPage {
	
	private final WebDriver webDriver;
	
	public WebAppPage(WebDriver d){
		webDriver = d;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public boolean hasText(String text){
		
		System.out.println("Verifying text: " +text+ " is displayed...");
		
		return webDriver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed();
		
	}
	
}
