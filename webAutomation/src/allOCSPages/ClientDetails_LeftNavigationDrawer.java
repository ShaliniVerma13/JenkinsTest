package allOCSPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.PageActions;
import readConfigFile.PropertyFileReader;

public class ClientDetails_LeftNavigationDrawer {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	PageActions pageActions=null;
	
	public ClientDetails_LeftNavigationDrawer(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 20);
		pageActions=new PageActions(driver);
	}
	
	public void clickClientTab()
	{
		pageActions.clickButton(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Client_Tab_Button"))));
	}

}
