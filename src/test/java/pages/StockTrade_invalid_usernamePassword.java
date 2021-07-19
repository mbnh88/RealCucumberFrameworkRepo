package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class StockTrade_invalid_usernamePassword {
	
	public StockTrade_invalid_usernamePassword() {
	

	PageFactory.initElements(Driver.getDriver(),this);

}
	
	@FindBy(xpath= "//h2[@class='form-signin-heading']")
	 public WebElement PleaseSignIn;


    @FindBy (xpath="//input[@name='username']")
    public WebElement invusername;
    
    @FindBy (xpath="//input[@id='password']")
    public WebElement invpassword;
    
    @FindBy (xpath="//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement SignInBtn;
    
    @FindBy (xpath="//div[@class='alert alert-danger']")
    public WebElement invalidCred;
}