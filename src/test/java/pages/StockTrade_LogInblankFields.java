package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class StockTrade_LogInblankFields {
	
	
	public StockTrade_LogInblankFields() {
		
		PageFactory.initElements(Driver.getDriver(), this);
		
	}	
		@FindBy (xpath= "//input[@id='username']")
		public WebElement blnkusername;
		
		@FindBy (xpath= "//input[@id='password']")
		public WebElement blnkpassword;
		
		@FindBy (xpath= "//button[@class='btn btn-lg btn-primary btn-block']")
		public WebElement blnksigninbtn;
		
	

}
