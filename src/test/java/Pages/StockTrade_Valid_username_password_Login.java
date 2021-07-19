package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class StockTrade_Valid_username_password_Login {
	
	public StockTrade_Valid_username_password_Login() {
	
	PageFactory.initElements(Driver.getDriver(),this);
	}
	
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

}