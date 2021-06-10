package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePageObj {
	WebDriver driverObj;
	public ComposePageObj(WebDriver obj)
	{
		driverObj= obj;
		PageFactory.initElements(driverObj, this);
	}
	
	@FindBy(xpath="//div[@class='nM']/div[1]/div/div")
	WebElement composeBtn;
	
	@FindBy(xpath="//textarea[@aria-label='To']")
	WebElement toEmailId;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subjBox;	
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	WebElement mesgBody;
	
	@FindBy(xpath="//tr[@class='btC']/td[1]/div/div[2]/div[1]")
	WebElement sendBtn;
	
	@FindBy(xpath="//*[text()='Please specify at least one recipient.']")
	WebElement toIdErrTxt;
	
	@FindBy(xpath="//button[@name='ok']")
	WebElement toIdErrOk;
	
	@FindBy(xpath="//*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a/img")
	WebElement logoutImg;
	
	@FindBy(xpath="//*[text()='Sign out']")
	WebElement logoutBtn;
	
	public WebElement getlogoutImg(){
		return logoutImg;
	}
	
	public WebElement getlogoutBtn(){
		return logoutBtn;
	}
		
	public WebElement gettoIdErrOk(){
		return toIdErrOk;
	}
	
	public WebElement gettoIdErrTxt(){
		return toIdErrTxt;
	}
	
	public WebElement getcomposeBtn(){
		return composeBtn;
	}
	public WebElement gettoEmailId(){
		return toEmailId;
	}
	public WebElement getsubjBox(){
		return subjBox;
	}
	public WebElement getmesgBody(){
		return mesgBody;
	}
	public WebElement getsendBtn(){
		return sendBtn;
	}
}
