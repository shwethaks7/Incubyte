package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUsrPage {
	
	WebDriver driverObj;
	public LoginUsrPage(WebDriver obj)
	{
		driverObj= obj;
		PageFactory.initElements(driverObj, this);
	}
	
	@FindBy(css="#identifierId")
	WebElement identifierId;
	
	@FindBy(css="#identifierNext > div > button")
	WebElement getUsrClickNxt;
	
	@FindBy(xpath="//*[contains(text(),'find your Google Account')]")
	WebElement getUserInvalid;	
			
		
	
	public WebElement getidentifier(){
		return identifierId;
	}
	public WebElement getUsrClickNxt(){
		return getUsrClickNxt;
	}
	public WebElement getUserInvalid(){
		return getUserInvalid;
	}
	

}
