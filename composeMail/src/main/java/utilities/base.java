package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public static WebDriver driverObj;//another class cannot modify the driver obj. so this ll b modified only after null assignment.
	public Properties prop;
	public static String userId="shakuSri7@gmail.com";
	public static  String paswd="Bangalore@123";
	public WebDriverWait wait;
	
	public WebDriver initializedriver() throws IOException{
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		prop= new Properties();
   		//FileInputStream fp = new FileInputStream("C:\\Users\\shwet\\eclipseWorkspace1\\composeMail\\src\\test\\java\\utilities\\data.properties");
		FileInputStream fp = new FileInputStream(userDir+"\\src\\main\\java\\resource\\data.properties");
		prop.load(fp);
   		userId=prop.getProperty("userId");
   		paswd=prop.getProperty("paswd");
   		
   		//added the webdrivermanager dependency
   		WebDriverManager.chromedriver().setup();
		driverObj = new ChromeDriver();
		driverObj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wait = new WebDriverWait(driverObj,5);
		return driverObj;
		
	}
	
	public static void getScreenShot() throws IOException
	{
		
		System.out.println("getScreenShot");
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		 //get current date time with Date()
		 Date date = new Date();

		 // Now format the date
		 String date1= dateFormat.format(date);
		 date1=date1.replace(" ", "");
		 date1=date1.replace(":", "");

		 // Print the Date
		 System.out.println(date1);
		 String userDir = System.getProperty("user.dir");
		 System.out.println(userDir);
		 String fileName = userDir+"\\scrr1_"+date1+".png";
		 System.out.println(fileName);
		File src =((TakesScreenshot)(driverObj)).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File(fileName));
			
	}

}
