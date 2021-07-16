package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TradeJornalPage {
	public TradeJornalPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//Login Page WebElements
	@FindBy(xpath= "//h2[@class='form-signin-heading']")
	 public WebElement PleaseSignIn;
	
    @FindBy (xpath="//input[@name='username']")
    public WebElement username;
    
    @FindBy (xpath="//input[@id='password']")
    public WebElement password;
    
    @FindBy (xpath="//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement SignInBtn;
    
    @FindBy (xpath="//div[@class='container']")
    public WebElement HomePage;
    
	// Add Trade WebElements
	@FindBy(xpath="//li[@class='nav-item active']//a[@class='nav-link']")
	public WebElement homePageTab;
	
	@FindBy(linkText="Add trade")
	public WebElement addTradeBtn;
	
	//SaveTrade WebElements
	@FindBy(xpath="//p[text()='Save Trade']")
	public WebElement saveTradeHeading;
	
	@FindBy(id="longTrade")
	public WebElement saveTradeDropDown;
	
	@FindBy(id="symbol")
	public WebElement symbolTextBox;
	
	@FindBy(id="openDate")
	public WebElement openDate;
	
	@FindBy(id="entry")
	public WebElement entryPrice;
	
	@FindBy(id="closeDate")
	public WebElement closeDate;
	
	@FindBy(id="exit")
	public WebElement exitPrice;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//a[text()='Back to Transactions']")
	public WebElement backToTransactionLink;
	
	//Homepage Tabs
	@FindBy(xpath= "//a[text()='Finom Group']")
	public WebElement finomGroupTab;
	
	@FindBy (xpath="//a[text()='Slack Channel']")
	public WebElement slackChannelTab;
	
	@FindBy (xpath="//a[@class='nav-link dropdown-toggle']")
	public WebElement toolsDropDown;
	
	@FindBy (xpath="//h1[@class='pageHeading']")
	public WebElement optionsCalculatorPage;

	@FindBy (xpath= "//a[@class='logo']")
	public WebElement todaysMarketPage;
	
	@FindBy ()
	public WebElement priceConverterPage;
	
	@FindBy (xpath="//div[@class='dropdown-menu show']//a[text()='Options Calculator']")
	public WebElement optionsCalculator;
	
	@FindBy (xpath="//div[@class='dropdown-menu show']//a[@href=\"https://finviz.com/\"]")
	public WebElement todaysMarketInfo;
	
	@FindBy (xpath="//div[@class='dropdown-menu show']//a[text()='Vol ETF/ETN Price Converter']")
	public WebElement priceConverter;
	
	// Update Trade
	@FindBy (xpath="//a[@class='btn btn-info btn-sm']")
	public WebElement updateBttn;
	
	@FindBy (xpath="//a[@class='btn btn-danger btn-sm']")
	public WebElement deleteBttn;
	
	//Search Functionality
	@FindBy(xpath="//input[@name='symbol']")
	public WebElement symbolBox;
	
	@FindBy(xpath="//input[@name='date']")
	public WebElement dateBox;
	
	@FindBy (xpath= "//button[text()='Search']")
	public WebElement searchButton;
	
	@FindBy (xpath="//table[@class='table table-bordered table-striped']")
	public WebElement searchTableLocator;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped']/tbody/tr/td[3]")
	public List <WebElement> dataTableOpenDate;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped']/tbody/tr/td[5]")
	public List <WebElement> dataTableExitDate;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List <WebElement> dataTableSymbol;
	
	@FindBy (xpath="//table[@class='table table-bordered table-striped']/tbody/tr")
	public WebElement searchTableFirstRow;
	
	@FindBy (xpath="/html/body/div/table/tbody/tr/td[8]/a[1]")
	public WebElement updateSearchBTTN;
	
	//Logout Functionality
	@FindBy (xpath="//button[text()='Logout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//h2[text()='Are you sure you want to log out?']")
	public WebElement logoutPageText;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary btn-block']")
	public WebElement logoutPageButton;
	
	@FindBy (xpath="//div[text()='You have been signed out']")
	public WebElement successfulLogoutMessage;
	
	//Trade Table list of column elements in a searched row
	@FindBy(xpath="//table[@class='table table-bordered table-striped']/tbody/tr/td")
	public List<WebElement> searchRowTableData;
}
