package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeJornalPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class LogoutFunctionalityTestSteps {
	TradeJornalPage page = new TradeJornalPage();
	BrowserUtils utils = new BrowserUtils();
	@Given("I am logged into the Trade Journal Application")
	public void i_am_logged_into_the_trade_journal_application() {
		Driver.getDriver().get("http://ec2-3-142-242-205.us-east-2.compute.amazonaws.com:8080/login");
		page.username.sendKeys("Marat");
		page.password.sendKeys("SuperMarat123!");
		page.SignInBtn.click();
	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		utils.waitUntilElementIsVisible(page.HomePage);
		Assert.assertTrue(page.HomePage.isDisplayed());
	}

	@When("I click the Logout button")
	public void i_click_the_logout_button() {
	    page.logoutBtn.click();
	}

	@Then("I should be on a new page")
	public void i_should_be_on_a_new_page() {
	    utils.waitUntilElementIsVisible(page.logoutPageButton);
	    Assert.assertTrue(page.logoutPageButton.isDisplayed());
	}

	@Then("see the following message: {string}")
	public void see_the_following_message(String string) {
	    String actual = page.logoutPageText.getText();
	    Assert.assertEquals(actual, string);
	}

	@Then("I click the LogoutPage button")
	public void i_click_the_logoutPage_button() {
	page.logoutPageButton.click();   
	}

	@Then("I should be succesfully logged out")
	public void i_should_be_succesfully_logged_out() {
		String expected= "You have been signed out";
	   String actual= page.successfulLogoutMessage.getText();
	   Assert.assertEquals(actual, expected);
	}

	@Then("I should see the Trade Journal Login page")
	public void i_should_see_the_trade_journal_login_page() {
	    Assert.assertTrue(page.SignInBtn.isDisplayed());
	}


}
