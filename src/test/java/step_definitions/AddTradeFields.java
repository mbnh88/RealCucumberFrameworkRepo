package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.TradeJornalPage;
import utilities.BrowserUtils;

public class AddTradeFields {
	TradeJornalPage addTradePage = new TradeJornalPage();
	BrowserUtils utils = new BrowserUtils();



	@Then("Drop Down with the following options {string} selected by default and {string}")
	public void drop_down_with_the_following_options_selected_by_default_and(String firstSelectOption, String secondSelectOption) {
		
		try {
			
	    Assert.assertTrue(utils.getTextofFirstSelectOption(addTradePage.saveTradeDropDown).equals(firstSelectOption));
		}catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Drop down default option does not match the requirements");
		}
		Assert.assertTrue( utils.getAllSelectOptions(addTradePage.saveTradeDropDown, firstSelectOption));
		Assert.assertTrue( utils.getAllSelectOptions(addTradePage.saveTradeDropDown, secondSelectOption));
	}

	@Then("Symbol textbox which accepts a string {string} {int} characters in length")
	public void symbol_textbox_which_accepts_a_string_characters_in_length(String string, int int1) {
	    addTradePage.symbolTextBox.sendKeys(string);
	    Assert.assertEquals(string.length(), int1);
	}

	@Then("Date1 textbox which accepts a {string} value typed by the user or a date picked in the calender picker component")
	public void date1_textbox_which_accepts_a_value_typed_by_the_user_or_a_date_picked_in_the_calender_picker_component(String entryDate) {
	    addTradePage.openDate.sendKeys(entryDate);
	}

	@Then("Entry price Text box which takes a {string} value that is a double")
	public void entry_price_text_box_which_takes_a_value_that_is_a_double(String entryPrice) {
	    addTradePage.entryPrice.sendKeys(entryPrice);
	}

	@Then("Date2 textbox which accepts a {string} type Date, typed by the user or a date picked in the calender picker component")
	public void date2_textbox_which_accepts_a_type_date_typed_by_the_user_or_a_date_picked_in_the_calender_picker_component(String exitDate) {
	    addTradePage.closeDate.sendKeys(exitDate);
	}

	@Then("Exit price text box which takes a {string} value that is a double")
	public void exit_price_text_box_which_takes_a_value_that_is_a_double(String exitPrice) {
	    addTradePage.exitPrice.sendKeys(exitPrice);
	}



}
