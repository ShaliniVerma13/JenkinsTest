package genericTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.TakeScreenshot;
import readConfigFile.PropertyFileReader;

public class Search_OCS {
	
	public static void searchClient_OCS(WebDriver driver, String ClientId)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Textbox"))));
		
		//String ClientId=PropertyFileReader.ApplicationConfigReader("ClientID_QA");
			
		driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Textbox"))).sendKeys(ClientId);
		
		driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Button"))).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@title='Click for dashboard' and contains(@href,"+ClientId+")]")));
		
		if(driver.findElement(By.xpath("//a[@title='Click for dashboard' and contains(@href,"+ClientId+")]")).isDisplayed())
		{
			System.out.println("Client searched successfully.");
		}
		else
		{
			
			Assert.fail("Client search unsuccessfull");
			TakeScreenshot.takeScreenshot(driver,"searchClient_OCS");
		}
	}

}
