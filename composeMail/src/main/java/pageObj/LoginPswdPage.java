package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPswdPage {
	WebDriver driverObj;
	public LoginPswdPage(WebDriver obj)
	{
		driverObj= obj;
		PageFactory.initElements(driverObj, this);
	}
	
	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	WebElement password;
	
	@FindBy(css="#passwordNext > div > button > span")
	WebElement PaswdClickNxt;
	
	@FindBy(xpath="//*[contains(text(),'Wrong password')]")
	WebElement PaswdInvalid;	
			
		
	
	public WebElement getpassword(){
		return password;
	}
	public WebElement getPaswdClickNxt(){
		return PaswdClickNxt;
	}
	public WebElement getPaswdInvalid(){
		return PaswdInvalid;
	}
	
}
