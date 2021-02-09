package basePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import readConfigFile.PropertyFileReader;

public class UploadDocument {
	
	public static void docUpload(String filePath)
	{
		
		
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		try{

			Robot robot = new Robot();
			robot.delay(10000);
			
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(2000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void AdditionalDocDetailsPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PropertyFileReader.ElementLocatorReader("DocUploadPopupHeading"))));
		
		Select se = new Select(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("DocCategoryList"))));
		 
		se.selectByIndex(3);
		
		driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("UploadButton"))).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PropertyFileReader.ElementLocatorReader("DocSuccessMsg"))));
		
		if(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("DocSuccessMsg"))).isDisplayed())
		{
			Assert.assertTrue(true,"Document Uploaded Successfully");
		}
		else
		{
			
			Assert.fail("Document upload was Unsuccessfull");
			TakeScreenshot.takeScreenshot(driver,"AdditionalDocDetailsPopup");
		}
	}

}
