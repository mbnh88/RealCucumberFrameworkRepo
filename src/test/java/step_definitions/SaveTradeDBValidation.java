package step_definitions;

import java.util.List;

import org.junit.Assert;

import Pages.TradeJornalPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;
import utilities.dbUtils;

public class SaveTradeDBValidation {
	TradeJornalPage addTradePage = new TradeJornalPage();
	BrowserUtils utils = new BrowserUtils();
	dbUtils dbutils = new dbUtils();

	String selectedOption;
	String inputSymbol;
	String inputEntryDate;
	String inputEntryPrice;
	String inputExitDate;
	String inputExitPrice;
	
	//this step belongs to the Background. For now just hadrcoding the username and password
	@Given("I am external user logged in to the Stock Trade Tracking application")
	public void i_am_external_user_logged_in_to_the_stock_trade_tracking_application() {
	    Driver.getDriver().get(PropertiesReader.getProperty("tradeJournalURL"));
	    utils.waitUntilElementIsVisible(addTradePage.SignInBtn);
	    addTradePage.username.sendKeys("Aysel");
	    addTradePage.password.sendKeys("SuperAysel123!");
	    addTradePage.SignInBtn.click();
	    
	}

	@When("I click on the Add a Trade button")
	public void i_click_on_the_add_a_trade_button() {
		utils.waitUntilElementIsVisible(addTradePage.addTradeBtn);
		Assert.assertTrue(addTradePage.addTradeBtn.isDisplayed());
	    addTradePage.addTradeBtn.click();
	}

	@Then("I should be directed to a new page with Save Trade as the page heading")
	public void i_should_be_directed_to_a_new_page_with_save_trade_as_the_page_heading() {
	   Assert.assertEquals(addTradePage.saveTradeHeading.getText(), "Save Trade");
	}
	

	@Then("I select {string} on the dropdown")
	public void i_select_on_the_dropdown(String dropDownOption) {
	   utils.selectByVisibleText(addTradePage.saveTradeDropDown, dropDownOption);
	}

	@Then("I enter {string} on the Symbol field")
	public void i_enter_on_the_symbol_field(String symbol) {
		 addTradePage.symbolTextBox.sendKeys(symbol);
		 inputSymbol = symbol;
	}

	@Then("I enter {string} in the entry date field")
	public void i_enter_in_the_entry_date_field(String entryDate) {
		 addTradePage.openDate.sendKeys(entryDate);
		 inputEntryDate = entryDate;
	}

	@Then("I enter {string} for the entry price field")
	public void i_enter_for_the_entry_price_field(String entryPrice) {
		 addTradePage.entryPrice.sendKeys(entryPrice);
		 inputEntryPrice = entryPrice;
	}

	@Then("I enter {string} in the closing date field")
	public void i_enter_in_the_closing_date_field(String closingDate) {
		addTradePage.closeDate.sendKeys(closingDate);
		inputExitDate = closingDate;
	}

	@Then("I enter {string} to the exit price field")
	public void i_enter_to_the_exit_price_field(String exitPrice) {
		addTradePage.exitPrice.sendKeys(exitPrice);
		inputExitPrice = exitPrice;
	}

	@Then("I click on Save button")
	public void i_click_on_save_button() {
		addTradePage.saveBtn.click();
	}

	@Then("there are no issues with the fields submitted")
	public void there_are_no_issues_with_the_fields_submitted() {
		Assert.assertTrue(addTradePage.addTradeBtn.isDisplayed());
		
	}

	@Then("The trade information entered by the user should be saved in the application database.")
	public void the_trade_information_entered_by_the_user_should_be_saved_in_the_application_database() {
	  String selectQuery = "SELECT * FROM records WHERE symbol = '"+inputSymbol+"' AND entry_price = '"+inputEntryPrice+"'";
	  List<String> dblist = dbutils.selectARecord(selectQuery);
	 
	  Assert.assertEquals(dblist.get(3), inputSymbol);
	  Assert.assertEquals(dblist.get(5), inputEntryPrice);
	  Assert.assertEquals(dblist.get(7), inputExitPrice);
	 
	  String deleteQuery = "DELETE FROM records WHERE symbol = '"+inputSymbol+"'";
	  dbutils.deleteRecord(deleteQuery);
	}


}
