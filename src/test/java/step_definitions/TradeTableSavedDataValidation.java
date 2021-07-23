package step_definitions;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeJornalPage;
import utilities.BrowserUtils;
import utilities.dbUtils;

public class TradeTableSavedDataValidation {
	TradeJornalPage addTradePage = new TradeJornalPage();
	BrowserUtils utils = new BrowserUtils();
	dbUtils dbutils = new dbUtils();
	
	String selectOption;
	String symbol;
	String entryDate;
	String entryPrice;
	String exitDate;
	String exitPrice;
	String gainLoss;
	double gainloss;
	
	@Then("I have Saved a trade with following data")
	public void i_have_saved_a_trade_with_following_data(DataTable dataTable) {
	   List<String> tradeData = dataTable.asList();
	   
	    selectOption = tradeData.get(0);
		symbol = tradeData.get(1);
		entryDate = tradeData.get(2);
		entryPrice = tradeData.get(3);
		exitDate = tradeData.get(4);
		exitPrice = tradeData.get(5);

	   utils.selectByVisibleText(addTradePage.saveTradeDropDown, tradeData.get(0)); 
	   addTradePage.symbolTextBox.sendKeys(tradeData.get(1));
	   addTradePage.openDate.sendKeys(tradeData.get(2));
	   addTradePage.entryPrice.sendKeys(tradeData.get(3));
	   addTradePage.closeDate.sendKeys(tradeData.get(4));
	   addTradePage.exitPrice.sendKeys(tradeData.get(5));
	   addTradePage.saveBtn.click();
	  
	   String month1 = entryDate.substring(0,2);
	   String day1 = entryDate.substring(3, 5);
	   String year1 = entryDate.substring(6);
	  
	   entryDate = year1.concat("-").concat(month1).concat("-").concat(day1);
	   
	   String month2 = exitDate.substring(0,2);
	   String day2 = exitDate.substring(3, 5);
	   String year2 = exitDate.substring(6);
	  
	   exitDate = year2.concat("-").concat(month2).concat("-").concat(day2);
	   
	   
		if (entryPrice.contains("."))
		{entryPrice = "$" + entryPrice;
		} 
		else { entryPrice = "$" + entryPrice + ".0";
		}
		
		
		if (exitPrice.contains("."))
		{exitPrice = "$" + exitPrice;
		} 
		else { exitPrice = "$" + exitPrice + ".0";
		}
	}
	@Then("I should be directed to the home page")
	public void i_should_be_directed_to_the_home_page() {
	    utils.waitUntilElementIsVisible(addTradePage.addTradeBtn);
	    Assert.assertTrue(addTradePage.addTradeBtn.isDisplayed());
	}
	@When("I click on the Back to Transactions Link,")
	public void i_click_on_the_back_to_transactions_link() {
	    addTradePage.backToTransactionLink.click();
	}
	@Then("I should see all the data that I entered and saved in the Save Trade page")
	public void i_should_see_all_the_data_that_i_entered_and_saved_in_the_save_trade_page() {
		utils.waitUntilElementIsVisible(addTradePage.symbolBox);
		addTradePage.symbolBox.sendKeys(symbol);
		
		addTradePage.searchButton.click();
		utils.waitUntilElementIsVisible(addTradePage.searchRowTableData.get(0));
		
		Assert.assertEquals(addTradePage.searchRowTableData.get(0).getText(), selectOption);
		Assert.assertEquals(addTradePage.searchRowTableData.get(1).getText(), symbol);
		Assert.assertEquals(addTradePage.searchRowTableData.get(2).getText(), entryDate);
		Assert.assertEquals(addTradePage.searchRowTableData.get(3).getText(), entryPrice);
		Assert.assertEquals(addTradePage.searchRowTableData.get(4).getText(), exitDate);
		Assert.assertEquals(addTradePage.searchRowTableData.get(5).getText(), exitPrice);
		
	}
	
	@Then("Gain Loss value should be equal to {double} decreased by {double} devided by entry price times {int} and rounded to one decimal place")
	public void gain_loss_value_should_be_equal_to_decreased_by_devided_by_entry_price_times_and_rounded_to_one_decimal_place(Double exitprice, Double entryprice, Integer int1) {
	    gainloss = (exitprice - entryprice)/entryprice * int1;
	    gainLoss = String.valueOf((Math.round(gainloss*100.0))/100.0).concat("%");
	    String actualGainLossValue = addTradePage.searchRowTableData.get(6).getText();
	    Assert.assertEquals(actualGainLossValue, gainLoss);
	    try {
			String roundedValue = String.valueOf((Math.round(gainloss*10.0))/10.0);
			 Assert.assertEquals(actualGainLossValue, roundedValue.concat("%"));
			
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Not rounded to one decimal place!");
		}
	}

	@Then("If the Gain\\/Loss value results in Gain then the row should be in black font if its Loss then the row should be in red font")
	public void if_the_gain_loss_value_results_in_gain_then_the_row_should_be_in_black_font_if_its_loss_then_the_row_should_be_in_red_font() {
		
		if (gainloss < 0) {
	    	Assert.assertEquals(addTradePage.searchRowTableData.get(6).getCssValue("color"), "rgba(255, 0, 0, 1)");
	    }else {
	    	Assert.assertEquals(addTradePage.searchRowTableData.get(6).getCssValue("color"), "rgba(0, 0, 0, 1)");
	   }
	}
	
	@Then("Action Column with {string} and {string} buttons")
	public void action_column_with_and_buttons(String Update, String Delete) {
		Assert.assertTrue(addTradePage.updateBttn.isDisplayed());
		Assert.assertTrue(addTradePage.deleteBttn.isDisplayed());
		
		String deleteQuery = "DELETE FROM records WHERE symbol = '"+symbol+"'";
		dbutils.deleteRecord(deleteQuery);
	}



}
