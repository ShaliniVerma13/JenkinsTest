package allOCSPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.PageActions;
import readConfigFile.PropertyFileReader;

public class SearchPage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	PageActions pageActions=null;
	Actions actions=null;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 20);
		pageActions=new PageActions(driver);
		actions=new Actions(driver);
	}
	
	public void enterSearchText(String textToBeSearched)
	{
		pageActions.enterDataintoTextbox(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Textbox"))), textToBeSearched);
		
	}
	
	public void clickSearchButton() {
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Button"))));
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Button"))));
				
	}
	
	public void clickClientForDashboardNavigation(String Id){
		
		pageActions.clickButton(driver.findElement(By.xpath("//a[@title='Click for dashboard' and contains(@href,"+Id+")]")));
	}
	
	public void clickDocUploadIcon_SearchResult()
	{
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("DocUploadicon_SearchResult"))));
	}

	public void ExpandCoverFilter()
	{
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ExpandCoverFilter")))).build().perform();
		
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ExpandCoverFilter"))));
	}
	public void checkActiveCoverCheckbox()
	{
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeActiveCoverCheckbox")))).build().perform();
		
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeActiveCoverCheckbox"))));
	}
	
	public void checkInactiveCoverCheckbox()
	{
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeInactiveCoverCheckbox")))).build().perform();
		
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeInactiveCoverCheckbox"))));
	}
	
	public void ExpandClaimFilter()
	{
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ExpandClaimFilter")))).build().perform();
		
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ExpandClaimFilter"))));
	}
	
	public void checkAllClaimCheckbox()
	{
		
		actions.moveToElement(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeAllClaimsCheckbox")))).build().perform();
		
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("IncludeAllClaimsCheckbox"))));
	}
}
