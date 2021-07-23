package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeJornalPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class TradeAppAddTradeTestSteps {
	
	BrowserUtils utils = new BrowserUtils();
	TradeJornalPage page= new TradeJornalPage();
	String inputSymbol;
	String entryPrice;
	String exitPrice;
	@Given("I am on the app login page")
	public void i_am_on_the_app_login_page() {
	    Driver.getDriver().get("http://ec2-3-142-242-205.us-east-2.compute.amazonaws.com:8080/login");
	    utils.waitUntilElementIsVisible(page.username);
	    Assert.assertTrue(page.username.isDisplayed());
	    
	}

	@When("I enter valid username {string} and password \"superHelil123!\"combo")
	public void i_enter_valid_username_and_password_super_helil123_combo(String string) {
	    page.username.sendKeys(string);
	    page.password.sendKeys("SuperHelil123!");
	}

	@When("I click on signin button")
	public void i_click_on_signin_button() {
	   page.SignInBtn.click();
	}

	@Then("I should be in the trade home page")
	public void i_should_be_in_the_trade_home_page() {
	  utils.waitUntilElementIsVisible(page.addTradeBtn);
	  Assert.assertTrue(page.addTradeBtn.isDisplayed());
	}

	@When("I click on the add trade button")
	public void i_click_on_the_add_trade_button() {
	   page.addTradeBtn.click();
	}

	@Then("I should be directed to save trade form")
	public void i_should_be_directed_to_save_trade_form() {
	    utils.waitUntilElementIsVisible(page.saveBtn);
	    Assert.assertTrue(page.saveBtn.isDisplayed());
	}

	@When("I select {string} and enter symbol {string} entrydate {string} entryprice {string} exitdate {string} exitprice {string}")
	public void i_select_and_enter_symbol_entrydate_entryprice_exitdate_exitprice(String buyToOpen, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		this.entryPrice=entryPrice;
		this.exitPrice=exitPrice;
		inputSymbol=symbol;
	utils.selectByVisibleText(page.saveTradeDropDown, buyToOpen);
	 page.symbolTextBox.sendKeys(symbol);
	 page.openDate.sendKeys(entryDate);
	 page.entryPrice.sendKeys(entryPrice);
	 page.closeDate.sendKeys(exitDate);
	 page.exitPrice.sendKeys(exitPrice);
	 
	 
	}

	@When("I click the save button")
	public void i_click_the_save_button() {
	 page.saveBtn.click();  
	}

	// =============Goood Example how to Iterate through List of WebElements============
	@Then("the trade is displayed in the trade table")
	public void the_trade_is_displayed_in_the_trade_table() {
	    utils.waitUntilElementIsVisible(page.searchTableLocator);
	    for(WebElement element : page.dataTableSymbol) {
	    	String actualStockSymbol = element.getText();
	    	boolean flag= false;
	    	if(actualStockSymbol.equals(inputSymbol)) {
	    		flag=true;
	    		Assert.assertTrue(flag);
	    		break;
	    	}
	    	
	    }
	}
	
	//Data Table
	@When("I enter the following trade details")
	public void i_enter_the_following_trade_details(DataTable dataTable) {
	   List <String> list = dataTable.asList();
	   inputSymbol=list.get(1);
	   
	   utils.selectByVisibleText(page.saveTradeDropDown, list.get(0));
		 page.symbolTextBox.sendKeys(list.get(1));
		 page.openDate.sendKeys(list.get(2));
		 page.entryPrice.sendKeys(list.get(3));
		 page.closeDate.sendKeys(list.get(4));
		 page.exitPrice.sendKeys(list.get(5));
	   
	}
}
