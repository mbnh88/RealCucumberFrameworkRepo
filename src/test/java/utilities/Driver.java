package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;

public class Driver {
	private static final String sauceHub="https://oauth-amijerbi.mo-b1763:3844f6ac-d5de-43ff-a57c-0e4f506cf1c1@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	private static WebDriver driver;
	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = PropertiesReader.getProperty("browser");
		}
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			switch (browser) {
			case "firefox":
				FirefoxDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				InternetExplorerDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "chrome":
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "headless":
			default:
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-extensions");
				options.addArguments("--proxy-server='direct://'");
				options.addArguments("--proxy-bypass-list=*");
				options.addArguments("--start-maximized");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				
			}
			
		}
		return driver;
	}
	
	
	// saucelabs configs
		public static void sauceLabsSetUp() {
			MutableCapabilities sauceOptions = new MutableCapabilities();
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setExperimentalOption("w3c", true);
			browserOptions.setCapability("platformName", "Windows 8.1");
			browserOptions.setCapability("browserVersion", "80.0");
			browserOptions.setCapability("sauce:options", sauceOptions);
		    try {
				driver = new RemoteWebDriver(new URL(sauceHub), browserOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
