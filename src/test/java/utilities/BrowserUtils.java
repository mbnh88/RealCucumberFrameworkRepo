package utilities;

import java.util.List;

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
	
	public String getTextofFirstSelectOption(WebElement element) {
		letsSelect = new Select(element);
		return letsSelect.getFirstSelectedOption().getText();
	}
	
	public boolean getAllSelectOptions(WebElement element, String option) {
		letsSelect = new Select(element);
		 List<WebElement> allOptions = letsSelect.getOptions();
		 
		 for (WebElement listItem : allOptions) {
			if (listItem.getText().equals(option)) {
				return true;
			}
		}
		 return false;
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
	

}
