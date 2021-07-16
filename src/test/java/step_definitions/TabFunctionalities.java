package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import Pages.TradeJornalPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TabFunctionalities {

	BrowserUtils utils = new BrowserUtils();
	TradeJornalPage tradePage = new TradeJornalPage();

	// Background
	@Given("I am on the Stock Trading Tracking application homepage")
	public void i_am_on_the_stock_trading_tracking_application_homepage() {
		Driver.getDriver().get(PropertiesReader.getProperty("homePage"));
		utils.waitUntilElementIsVisible(tradePage.username);
		tradePage.username.sendKeys("Marat");
		tradePage.password.sendKeys("SuperMarat123!");
		tradePage.SignInBtn.click();
		Assert.assertTrue(tradePage.homePageTab.isDisplayed());
		Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	// Finom Tab
	@When("I click on the tab titled Finom Group")
	public void i_click_on_the_tab_titled_finom_group() {
		utils.waitUntilElementIsVisible(tradePage.finomGroupTab);
		tradePage.finomGroupTab.click();
	}

	@Then("I should be directed to the Finom Group homepage titled {string}")
	public void i_should_be_directed_to_the_finom_group_homepage_titled(String string) {
		utils.switchBrowserWindow();
		String actualTitle = Driver.getDriver().getTitle();
		utils.waitUntilTitleIs(string);
		Assert.assertEquals(actualTitle, string);
	}

	// Slack test logged In
	@When("I click on the tab titled Slack Channel")
	public void i_click_on_the_tab_titled_slack_channel() {
		tradePage.slackChannelTab.click();
		utils.switchBrowserWindow();
	}

	@Given("I am logged into the PrimeTech_SDET_Batch1 slack channel")
	public void i_am_logged_into_the_prime_tech_sdet_batch1_slack_channel() {
		Assert.assertTrue(!tradePage.slackSignInBtn.isDisplayed());
	}

	@Then("I should be directed to the {string} slack channel")
	public void i_should_be_directed_to_the_slack_channel(String string) {
		utils.waitUntilElementIsVisible(tradePage.PrimeTechSlackLogo);
		Assert.assertTrue(tradePage.PrimeTechSlackLogo.isDisplayed());

	}

	// Slack test not logged in
	@When("I am not logged into my slack account")
	public void i_am_not_logged_into_my_slack_account() {
		utils.waitUntilElementIsVisible(tradePage.slackSignInBtn);
		Assert.assertTrue(tradePage.slackSignInBtn.isDisplayed());
	}

	@Then("I should be directed to the Slack sign in page titled {string}")
	public void i_should_be_directed_to_the_slack_sign_in_page_titled(String expectedTitle) {
		String actualTitle = Driver.getDriver().getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	// Tools Tab
	@Given("I have clicked on the Tools dropdown")
	public void i_have_clicked_on_the_tools_dropdown() {
		tradePage.toolsDropDown.click();
	}

	// Options Calculator
	@When("I click the Options Calculator option")
	public void i_click_the_options_calculator_option() {
		tradePage.optionsCalculator.click();
		utils.switchBrowserWindow();
	}

	@Then("I should be directed to the Options Calculator homepage titled {string}")
	public void i_should_be_directed_to_the_options_calculator_homepage_titled(String string) {
		utils.waitUntilElementIsVisible(tradePage.optionsCalculatorPage);
		String actualTitle = Driver.getDriver().getTitle();
		Assert.assertEquals(actualTitle, string);
	}

	// Vol ETF\\/ETN Price Converter
	@When("I click the Vol ETF\\/ETN Price Converter option")
	public void i_click_the_vol_etf_etn_price_converter_option() {
		tradePage.priceConverter.click();
//		Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Then("I should be directed to the Vol ETF\\/ETN Price Converter homepage titled {string}")
	public void i_should_be_directed_to_the_vol_etf_etn_price_converter_homepage_titled(String string) {
		
//		try {
//			utils.waitUntilTitleIs(string);
//			// utils.switchBrowserWindow();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		utils.waitUntilTitleIs(string);
		String actualTitle = Driver.getDriver().getTitle();
		Assert.assertEquals(actualTitle, string);

	}

	// Today's Market Info
	@When("I click the Todays Market Info option")
	public void i_click_the_todays_market_info_option() {
		tradePage.todaysMarketInfo.click();
		utils.switchBrowserWindow();
	}

	@Then("I should be directed to the Finviz Stock Screener homepage titled {string}")
	public void i_should_be_directed_to_the_finviz_stock_screener_homepage_titled(String string) {
		utils.waitUntilElementIsVisible(tradePage.todaysMarketPage);
		String actualTitle = Driver.getDriver().getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, string);
	}

}
