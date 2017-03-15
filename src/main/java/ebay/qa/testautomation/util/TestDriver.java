package ebay.qa.testautomation.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestDriver {

	private WebDriver driver;

	public TestDriver(String b) {
		if (b.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
		} else if (b.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
			driver = new ChromeDriver();
		}

		else {

			System.out.println("browser specified was not found.");
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	

}
