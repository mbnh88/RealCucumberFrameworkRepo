package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeJornalPage;
import utilities.BrowserUtils;

public class AddTradeInvalidTest {
	TradeJornalPage addTradePage = new TradeJornalPage();
	BrowserUtils utils = new BrowserUtils();
	String actualErrorMessage;
	
	@Then("the system should display the error message {string} for the Symbol input field")
	public void the_system_should_display_the_error_message_for_the_symbol_input_field(String expectedErrorMessage) {
		actualErrorMessage = addTradePage.symbolTextBox.getAttribute("validationMessage");
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@When("I enter {string} for the Symbol")
	public void i_enter_for_the_symbol(String symbol) {
	   addTradePage.symbolTextBox.sendKeys(symbol);
	}
	@Then("the system should display the error message {string} for the Entry Date input field")
	public void the_system_should_display_the_error_message_for_the_entry_date_input_field(String expectedErrorMessage) {
		actualErrorMessage = addTradePage.openDate.getAttribute("validationMessage");
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@Then("I enter {string} in the Entry date field and {string} in the entry price field")
	public void i_enter_in_the_entry_date_field_and_in_the_entry_price_field(String entryDate, String entryPrice) {
	    addTradePage.openDate.sendKeys(entryDate);
	    addTradePage.entryPrice.sendKeys(entryPrice);
	}
	@Then("the system should display the error message {string} for the Exit Date input field")
	public void the_system_should_display_the_error_message_for_the_exit_date_input_field(String expectedErrorMessage) {
		actualErrorMessage = addTradePage.closeDate.getAttribute("validationMessage");
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@When("I enter {string} in the Exit Date input field")
	public void i_enter_in_the_exit_date_input_field(String exitDate) {
	    addTradePage.closeDate.sendKeys(exitDate);
	}
	@Then("the system should display the error message {string} for the Exit Price input field")
	public void the_system_should_display_the_error_message_for_the_exit_proce_input_field(String expectedErrorMessage) {
		actualErrorMessage = addTradePage.exitPrice.getAttribute("validationMessage");
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}



}
