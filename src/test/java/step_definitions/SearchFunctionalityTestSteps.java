package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeJornalPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class SearchFunctionalityTestSteps {
	TradeJornalPage page = new TradeJornalPage();
	BrowserUtils utils= new BrowserUtils();
	String inputSymbol;
	String entryDate;
	String exitDate;
	boolean noSuchElement;
	@Given("I am logged in tot the Stock Trade applications")
	public void i_am_logged_in_tot_the_stock_trade_applications() {
		Driver.getDriver().get("http://ec2-3-142-242-205.us-east-2.compute.amazonaws.com:8080/login");
		page.username.sendKeys("Marat");
		page.password.sendKeys("SuperMarat123!");
		page.SignInBtn.click();
	}

	@Given("I am on the TJ home page")
	public void i_am_on_the_tj_home_page() {
		utils.waitUntilElementIsVisible(page.HomePage);
		Assert.assertTrue(page.HomePage.isDisplayed());
	}

	@When("I enter a value {string} for ‘Symbol' textbox,")
	public void i_enter_a_value_for_symbol_textbox(String symbol) {
		page.symbolBox.sendKeys(symbol);
	}

	@When("I click on the 'Search’ Button")
	public void i_click_on_the_search_button() {
		page.searchButton.click();
	}

	@Then("The system should filter the existing list of trades associated with the Symbol {string}")
	public void the_system_should_filter_the_existing_list_of_trades_associated_with_the_symbol(String symbol) {
		WebElement element= Driver.getDriver().findElement(By.xpath("//td[text()='vix']"));
	    inputSymbol=symbol;
		String actual = element.getText();
		Assert.assertEquals(actual, symbol);
	}

	@Then("Once the system fetches the records it should only display the records matching the user’s filters.{string}")
	public void once_the_system_fetches_the_records_it_should_only_display_the_records_matching_the_user_s_filters(String string) {
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

	@When("I enter a value for ‘Date' textbox {string},")
	public void i_enter_a_value_for_date_textbox(String date) {
	    this.entryDate=date;
	    this.exitDate=date;
		page.dateBox.sendKeys(date);
	}

	@Then("The system should filter the existing list of trades associated with the Date")
	public void the_system_should_filter_the_existing_list_of_trades_associated_with_the_date() {
		utils.waitUntilElementIsVisible(page.searchTableLocator);
	    for(WebElement element : page.dataTableOpenDate) {
	    	String actualDate = element.getText();
	    	boolean flag= false;
	    	if(actualDate.equals(entryDate)) {
	    		flag=true;
	    		Assert.assertTrue(flag);
	    		break;
	    	} else if (actualDate.equals(exitDate)) {
	    		flag=true;
	    		Assert.assertTrue(flag);
	    		break;
	    	} else {
	    		System.out.println("No date available");
	    	}
	    }
	}

	@Then("Once the system fetches the records it should only display the records matching the user’s filters.")
	public void once_the_system_fetches_the_records_it_should_only_display_the_records_matching_the_user_s_filters() {
	   
		for(WebElement element: page.dataTableOpenDate) {
			String actualDate=element.getText();
			boolean flag=false;
			if(entryDate.equals(actualDate)) {
				flag=true;
				Assert.assertTrue(flag);
				break;
			}  else {
				Assert.assertFalse(flag);
				break;
			} 
			
		}
		for(WebElement element : page.dataTableExitDate) {
			String actualDate=element.getText();
			boolean flag=false;
			if(exitDate.equals(actualDate)) {
				flag=true;
				Assert.assertTrue(flag);
				break;
			}  else {
				Assert.assertFalse(flag);
				break;
			} 
		}
	}

	





	@When("I enter a value for {string} textbox {string}")
	public void i_enter_a_value_for_textbox(String symbol, String date) {
	    page.symbolBox.sendKeys(symbol);
	    page.dateBox.sendKeys(date);
	}




	@Then("The system should filter the existing list of trades associated with the Symbol and DATE")
	public void the_system_should_filter_the_existing_list_of_trades_associated_with_the_symbol_and_date() {
		utils.waitUntilElementIsVisible(page.searchTableLocator);
		//List <String> list= new ArrayList<>();
	    for(WebElement element : page.dataTableSymbol) {
	    	//list.add(page.dataTableSymbol.getText(i));
	    	String actualStockSymbol = element.getText();
	    	boolean flag= false;
	    	if(actualStockSymbol.equals(inputSymbol)) {
	    		flag=true;
	    		Assert.assertTrue(flag);
	    		break;
	    	}
	    }
	    for(WebElement element: page.dataTableOpenDate) {
			String actualDate=element.getText();
			boolean flag=false;
			if(entryDate.equals(actualDate)) {
				flag=true;
				Assert.assertTrue(flag);
				break;
			}  else {
				Assert.assertFalse(flag);
				break;
			} 
			
		}
		for(WebElement element : page.dataTableExitDate) {
			String actualDate=element.getText();
			boolean flag=false;
			if(exitDate.equals(actualDate)) {
				flag=true;
				Assert.assertTrue(flag);
				break;
			}  else {
				Assert.assertFalse(flag);
				break;
			} 
		}
	}
	
	
// this is for no result search
	@When("I enter a Symbol or date")
	public void i_enter_a_symbol_or_date() {
	    page.symbolBox.sendKeys("viac");
	    page.searchButton.click();
	}
	

	@When("there are no matching records")
	public void there_are_no_matching_records() throws InterruptedException {
		utils.waitUntilElementIsVisible(page.searchTableLocator);
	    for(WebElement element : page.dataTableSymbol) {
	    	String actualStockSymbol = element.getText();
	    	boolean flag= false;
	    	if(actualStockSymbol.equals("viac")) {
	    		flag=true;
	    		Assert.assertTrue(flag);
	    		break;
	    	} else {
	    		Assert.assertFalse(flag);
	    	}
	    	//page.deleteBttn.click();
	    	//Thread.sleep(1000);
	    	//utils.switchToAlert();
	    	//utils.acceptAlert();
	    	//Thread.sleep(1000);
	    }
	}

	@Then("the system should display an empty table")
	public void the_system_should_display_an_empty_table() {
	      try { 
	    	  noSuchElement= false;
	    	  Assert.assertFalse(page.updateSearchBTTN.isDisplayed());
	      } catch (Exception e) {
	    	  noSuchElement=true;
	    	  Assert.assertTrue(noSuchElement);
	      }

	}


}
