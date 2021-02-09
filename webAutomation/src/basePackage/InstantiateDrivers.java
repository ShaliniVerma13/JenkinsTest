package basePackage;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import readConfigFile.PropertyFileReader;

public class InstantiateDrivers {
	
public ChromeDriver driver;
public WebDriverWait wait=null;
public allOCSPages.SearchPage searchPage;
public allOCSPages.ClientDetails_LeftNavigationDrawer leftNavigationMenu;
public allOCSPages.ClientInformationPage clientInformationPage;
	
	@BeforeMethod
	public void initializeDrivers() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(PropertyFileReader.ApplicationConfigReader("OCS_QA_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='overlay']/div/h3/i"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Button")))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("Search_Button")))));
		searchPage=new allOCSPages.SearchPage(driver);
		leftNavigationMenu = new allOCSPages.ClientDetails_LeftNavigationDrawer(driver);
		clientInformationPage= new allOCSPages.ClientInformationPage(driver);
		
	}



	
	@AfterMethod
	public void closeBrowser()
	{
		//driver.quit();
	}

	

}
