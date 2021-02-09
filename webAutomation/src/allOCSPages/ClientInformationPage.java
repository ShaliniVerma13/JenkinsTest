package allOCSPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.PageActions;
import readConfigFile.PropertyFileReader;

public class ClientInformationPage {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	PageActions pageActions=null;
	
	public ClientInformationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 20);
		pageActions=new PageActions(driver);
	}
	
	public void clickHeaderDocUploadIcon() {
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("DocUploadicon_ClientPageHeader"))));
		
	}
	

}
