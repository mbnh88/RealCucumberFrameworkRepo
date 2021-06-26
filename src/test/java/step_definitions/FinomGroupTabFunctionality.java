package step_definitions;


import org.junit.Assert;
import Pages.TradeJornalPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class FinomGroupTabFunctionality {

	BrowserUtils utils = new BrowserUtils();
	TradeJornalPage tradePage = new TradeJornalPage();

	@Given("I am on the Stock Trading Tracking application homepage")
	public void i_am_on_the_stock_trading_tracking_application_homepage() {
		Driver.getDriver().get(PropertiesReader.getProperty("homePage"));
		utils.waitUntilElementIsVisible(tradePage.username);
		tradePage.username.sendKeys("Marat");
		tradePage.password.sendKeys("SuperMarat123!");
		tradePage.SignInBtn.click();
		Assert.assertTrue(tradePage.homePageTab.isDisplayed());
	}

	@When("I click on the tab titled {string}")
	public void i_click_on_the_tab_titled(String string) {
		utils.waitUntilElementIsVisible(tradePage.finomGroupTab);
		tradePage.finomGroupTab.click();
	}

	@Then("I should be directed to the Finom Group homepage titled {string}")
	public void i_should_be_directed_to_the_finom_group_homepage_titled(String homePageTitle) {
		utils.switchBrowserWindow();
		String actualTitle = Driver.getDriver().getTitle();
		utils.waitUntilTitleIs(tradePage.finomHomeLogo, homePageTitle);
		Assert.assertEquals(actualTitle, homePageTitle);
	}

}
