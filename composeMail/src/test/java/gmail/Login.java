package gmail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObj.ComposePageObj;
import pageObj.LoginPswdPage;
import pageObj.LoginUsrPage;
import utilities.base;


public class Login extends base{
	
	@Test(priority=1)
	public void fnUsrLogin()
	{
		System.out.println("gmail user login start");
		driverObj.get("https://www.gmail.com");
		driverObj.manage().window().maximize();
		Assert.assertEquals(driverObj.getTitle(), "Gmail");
		
		//for already exisiting user id, gmail is restricting for automated scripts.
		//hence create a dummy user id to test the same.
		LoginUsrPage g1 = new LoginUsrPage(driverObj);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#identifierId")));
		g1.getidentifier().sendKeys(userId);
		g1.getUsrClickNxt().click();
		Assert.assertFalse(g1.getUserInvalid().isDisplayed(),"incorrect user id");
		
		
		System.out.println("gmail user login end");
		
	}
	
	@Test(priority=2)
	public void fnPaswdLogin()
	{
		System.out.println("gmail paswd login start");
		
		LoginPswdPage g2 = new LoginPswdPage(driverObj);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		g2.getpassword().sendKeys(paswd);
		g2.getPaswdClickNxt().click();
		if(driverObj.findElements(By.xpath("//*[contains(text(),'Wrong password')]")).size()>0)
		{
			Assert.assertFalse(true,"incorrect password");
		}
		
		System.out.println("gmail paswd login end");
		
	}
	
	
	
	@BeforeClass
	 public void beforeClass() throws IOException {
		  System.out.println("beforeClass");
		  
		//Set the browser 
			driverObj=  initializedriver();
	 }
	
	@Test(priority=3,dataProvider="getComposeDetails")
	public void fncomposeMail(String to, String subjInp, String body) 
	{
		ComposePageObj g3 = new ComposePageObj(driverObj);
		String toEmailId = to;
		String subject = subjInp;
		String mesgBody = body;
		
		System.out.println("compose start");
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nM']/div[1]/div/div")));
		System.out.println("waitcompose start");
		g3.getcomposeBtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@aria-label='To']")));
		
		g3.gettoEmailId().sendKeys(toEmailId);
		g3.getsubjBox().sendKeys(subject);
		g3.getmesgBody().sendKeys(mesgBody);
		g3.getsendBtn().click();
		
		if(toEmailId.isEmpty())
		{
			if(driverObj.findElements(By.xpath("//*[text()='Please specify at least one recipient.']")).size() == 0)
			{
				Assert.assertFalse(true,"error message is not present for empty reciepient");
			}
			g3.gettoIdErrOk().click();
		}
		else
		{
			if((subject.isEmpty()) && (mesgBody.isEmpty())) {
				if(wait.until(ExpectedConditions.alertIsPresent()) == null) {
					Assert.assertFalse(true,"Alert is not present when subject and body is empty");
				}
				Assert.assertEquals(driverObj.switchTo().alert().getText(), "Send this message without a subject or text in the body?","incorrect alert message");
				
				
				//cancel and send again
				driverObj.switchTo().alert().dismiss();
				g3.getsendBtn().click();
				driverObj.switchTo().alert().accept();
			}
		}
		
		
		System.out.println("compose end");
		
	}
	
	@Test(priority=4)
	public void logout() 
	{
		//to logout
		 
		 ComposePageObj g3 = new ComposePageObj(driverObj);
		g3.getlogoutImg().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		g3.getlogoutBtn().click();
		
	}
 @DataProvider
 public Object[][] getComposeDetails() {
	  Object[][] data = {{"user1@gmail.com","Incubyte","Automation QA test for incubyte"},
	  		{"user1@gmail.com","",""},{"user1@gmail.com,user2@gmail.com","",""}};
   		  			     
     return data;
  
 }
 
@AfterSuite
 public void afterSuite() {
	 driverObj.close();
 }
	
	
}
