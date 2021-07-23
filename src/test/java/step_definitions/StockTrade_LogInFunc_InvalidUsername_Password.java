package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StockTrade_invalid_usernamePassword;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class StockTrade_LogInFunc_InvalidUsername_Password {

	BrowserUtils util = new BrowserUtils();

	StockTrade_invalid_usernamePassword Invalid = new StockTrade_invalid_usernamePassword();

	@Given("i am on the trade journal page")
	public void i_am_on_the_trade_journal_page() {

		Driver.getDriver().get(PropertiesReader.getProperty("StockTrade"));

	}

	@When("when i enter invalid username {string} and password {string}")
	public void when_i_enter_invalid_username_and_password(String invusername, String invpassword) {
		Invalid.invusername.sendKeys("yamina");
		Invalid.invpassword.sendKeys("superyamina123");
	}

	@When("click on signIn")
	public void click_on_sign_in() {
		Invalid.SignInBtn.click();
	}

	@Then("i should get a message {string}")
	public void i_should_get_a_message(String errorMessage) {

		util.waitUntilElementIsVisible(Invalid.invalidCred);
		String actualErrorMessageHeader = Invalid.invalidCred.getText();
		Assert.assertEquals(actualErrorMessageHeader, errorMessage);

	}

			}
			
	   
			
		

