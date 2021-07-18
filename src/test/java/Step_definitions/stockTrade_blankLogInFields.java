package Step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StockTrade_LogInblankFields;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class stockTrade_blankLogInFields {
	
	
	BrowserUtils util = new BrowserUtils();
	StockTrade_LogInblankFields blank = new StockTrade_LogInblankFields();
	
	
	
	
	@Given("i am on the trade journal log in page")
	public void i_am_on_the_trade_journal_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("StockTrade"));
	}

	@When("i leave username and password blank")
	public void i_leave_username_and_password_blank() {
		blank.blnkusername.sendKeys();
		blank.blnkpassword.sendKeys();
	   
	}

	
	@When("i click on sign in")
	public void i_click_on_sign_in() {
		blank.blnksigninbtn.click();

	}

	@Then("i shoud get message {string}")
	public void i_shoud_get_message(String string) {
		
	   
	}

}
