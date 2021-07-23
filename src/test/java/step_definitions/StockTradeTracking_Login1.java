package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StockTrade_Valid_username_password_Login;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class StockTradeTracking_Login1 {
	
	BrowserUtils util = new BrowserUtils();
	StockTrade_Valid_username_password_Login stock = new StockTrade_Valid_username_password_Login();
	
//	Given i am on the stock trade tracking homepage
//	Then signin text should be displayed
//	When i enter valid username and password
//	Then i should be able to click on signin button
//	And i should be directed to the home page
	
	
	@Given("i am on the stock trade tracking homepage")
	public void i_am_on_the_stock_trade_tracking_homepage() {

		Driver.getDriver().get(PropertiesReader.getProperty("StockTrade"));
	}


	
	@Then("signin text should be displayed")
	public void signin_text_should_be_displayed() {
		Assert.assertTrue(stock.PleaseSignIn.isDisplayed()); 
	}

   @When("i enter valid username {string} and password {string}")
   public void i_enter_valid_username_and_password(String username, String password) {
		stock.username.sendKeys(username);
		stock.password.sendKeys(password);	
		} 
	
   
	@Then("i should be able to click on signin button")
	public void signin_button_should_be_displayed() {
         stock.SignInBtn.click();
	}

	@And("i should be directed to the home page")
	public void i_should_be_directed_to_the_home_page() {
		Assert.assertTrue(stock.HomePage.isDisplayed());
	    
	}
	
	


}
