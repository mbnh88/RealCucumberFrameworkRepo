package utilities;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	Alert alert;
	WebDriverWait wait;
	Select letsSelect;

	public void waitUntilAlertIsPresent() {
	 wait= new WebDriverWait(Driver.getDriver(), 10);
	  wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitUntilElementIsVisible(WebElement ELEMENT) {
		 wait= new WebDriverWait(Driver.getDriver(), 10);
		  wait.until(ExpectedConditions.visibilityOf(ELEMENT));
		}
	
	public void waitUntilTitleIs(WebElement ELEMENT, String title) {
		 wait= new WebDriverWait(Driver.getDriver(), 10);
		  wait.until(ExpectedConditions.titleIs(title));
		}
	
	public void switchToAlert() {
		
		 alert = Driver.getDriver().switchTo().alert();
	}
	public String alertGetText() {
		 
		return alert.getText();
		 
	}
	public void acceptAlert() {
		 
		 alert.accept();
	}
	public void dismissAlert() {
		 
		 alert.dismiss();
	}
	public void sendKeys() {
		alert.sendKeys(PropertiesReader.getProperty("name"));
		
	}
	public void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect= new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}
	public void toClear(WebElement element) throws InterruptedException {
		for(int i = 0; i < element.getText().length(); i++) {
			element.sendKeys(Keys.COMMAND + "a");
			Thread.sleep(1000);
			element.sendKeys(Keys.BACK_SPACE);
		
	
	}
}
	
	public void clearValueOfTheField(WebElement element) throws InterruptedException {
		String temp =element.getAttribute("value");
		for(int i = 0; i < temp.length(); i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public void switchBrowserWindow() {
		String parentWindow = Driver.getDriver().getWindowHandle();
		Set<String> handles = Driver.getDriver().getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				Driver.getDriver().switchTo().window(windowHandle);
			}
		}
	}
	
	
}
