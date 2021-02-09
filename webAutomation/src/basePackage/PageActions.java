package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import readConfigFile.PropertyFileReader;



public class PageActions {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	public PageActions(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 20);
	}

	public void clickButton(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	public void enterDataintoTextbox(WebElement element, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
	public void selectVisibleTextfromDropdown(WebElement element, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Select se = new Select(element);
		 
		se.selectByVisibleText(text);;
	}
	
	public void selectByIndexfromDropdown(WebElement element, int index)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Select se = new Select(element);
		 
		se.selectByIndex(index);
	}
	
}
