package basePackage;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static void takeScreenshot(WebDriver driver,String TC_name) 
	{
		try {
					
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	    Date date = new Date(0);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\Selenium Screenshots\\"+TC_name+"_"+dateFormat.format(date)+".png"));
		} 
		catch (Exception e) {
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
	}
}
