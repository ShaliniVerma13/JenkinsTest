package poc;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.InstantiateDrivers;
import basePackage.TakeScreenshot;
import basePackage.UploadDocument;
import readConfigFile.PropertyFileReader;

public class TC01_OCS_Search extends InstantiateDrivers{
	
	
	String ActiveClientId=PropertyFileReader.ApplicationConfigReader("ActiveClientID_QA");
	String ProspectClientId=PropertyFileReader.ApplicationConfigReader("ProspectClientID_QA");
	String ActiveCoverNumber=PropertyFileReader.ApplicationConfigReader("ActiveCover_QA");
	String ActiveClaimNumber=PropertyFileReader.ApplicationConfigReader("ActiveClaim_QA");
	String InactiveCoverNumber=PropertyFileReader.ApplicationConfigReader("InactiveCover_QA");
	
	
	
	@Test(enabled=false)
	public void searchClient_NavigatetoClientDashboard() 
	{
		
		try
		{
		searchPage.enterSearchText(ActiveClientId);
		
		searchPage.clickSearchButton();
		
		searchPage.clickClientForDashboardNavigation(ActiveClientId);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ClientDashboardHeading")))));
		
		if(driver.findElement(By.xpath(PropertyFileReader.ElementLocatorReader("ClientDashboardHeading"))).isDisplayed())
		{
			System.out.println("Client Dashboard is displayed");
		}
		else
		{
			Assert.fail("Client Dashboard is not displayed. So the Test Case is failed!");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchClient_NavigatetoClientDashboard");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	
	@Test(enabled=false)
	public void searchActiveClient() 
	{
		
		try
		{
		searchPage.enterSearchText(ActiveClientId);
		
		searchPage.clickSearchButton();
		
		if(driver.findElement(By.xpath("//a[@title='Click for dashboard' and contains(@href,"+ActiveClientId+")]")).isDisplayed())
		{
			System.out.println("Client search Successfull");
		}
		else
		{
			Assert.fail("Client search Unsuccessfull");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchActiveClient");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	
	@Test(enabled=false)
	public void searchProspectClient() 
	{
		
		try
		{
		searchPage.enterSearchText(ProspectClientId);
		
		searchPage.clickSearchButton();
		
		if(driver.findElement(By.xpath("//a[@title='Click for dashboard' and contains(@href,'"+ProspectClientId+"')]")).isDisplayed())
		{
			System.out.println("Prospect Client search Successfull");
		}
		else
		{
			Assert.fail("Prospect Client search Unsuccessfull");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchProspectClient");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	

	@Test(enabled=false)
	public void searchActiveCover() 
	{
		
		try
		{
					
		searchPage.enterSearchText(ActiveCoverNumber);
		searchPage.ExpandCoverFilter();
		searchPage.checkActiveCoverCheckbox();	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)"); 
		searchPage.clickSearchButton();
		
		if(driver.findElement(By.xpath("//a[contains(@href,"+ActiveCoverNumber+")]")).isDisplayed())
		{
			System.out.println("Active Cover search Successfull");
		}
		else
		{
			Assert.fail("Active Cover search Unsuccessfull");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchActiveCover");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	

	@Test(enabled=true)
	public void searchInactiveCover() 
	{
		
		try
		{
					
		searchPage.enterSearchText(InactiveCoverNumber);
		searchPage.ExpandCoverFilter();
		searchPage.checkInactiveCoverCheckbox();	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)"); 
		searchPage.clickSearchButton();
		
		if(driver.findElement(By.xpath("//a[contains(@href,"+InactiveCoverNumber+")]")).isDisplayed())
		{
			System.out.println("InActive Cover search Successfull");
			if(driver.findElement(By.xpath("//span[@class='label label-danger']")).getText().equalsIgnoreCase("Lapsed"))
			{
				System.out.println("Cover is Inactive");
			}
			else
			{
				System.out.println("Cover is Active");
			}
			
		}
		else
		{
			Assert.fail("InActive Cover search Unsuccessfull");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchInactiveCover");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	@Test(enabled=true)
	public void searchActiveClaim() 
	{
		
		try
		{
					
		searchPage.enterSearchText(ActiveClaimNumber);
		searchPage.ExpandClaimFilter();
		searchPage.checkAllClaimCheckbox();	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)"); 
		searchPage.clickSearchButton();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='searchListContainer']//h4[contains(text(),'"+ActiveClaimNumber+"')]"))));
		if(driver.findElement(By.xpath("//div[@class='searchListContainer']//h4[contains(text(),'"+ActiveClaimNumber+"')]")).isDisplayed())
		{
			System.out.println("Active Claim search Successfull");
		}
		else
		{
			Assert.fail("Active Claim search Unsuccessfull");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"searchActiveClaim");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2, dependsOnMethods = { "searchClient" }, enabled=false)
	public void ValidateClientPageTopNavgationBar() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyFileReader.ElementLocatorReader("Client_Tab_Button"))));
		
		driver.findElementByXPath(PropertyFileReader.ElementLocatorReader("Client_Tab_Button")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='pageheadertext']")));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Communication')]")));
		
		List<WebElement> TopBar = driver.findElementsByXPath("//*[@id='mynewScrollspy']/li");
		
		
		TopBar.get(0).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Communication')]").isDisplayed())
		{
			Assert.assertTrue(true,"Communication section is displayed.");
		}
		else
		{
			Assert.fail("Communication section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(1).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Service Team')]").isDisplayed())
		{
			Assert.assertTrue(true,"Service Team section is displayed.");
		}
		else
		{
			
			Assert.fail("Service Team section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(2).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'General Information')]").isDisplayed())
		{
			Assert.assertTrue(true,"General Information section is displayed.");
		}
		else
		{
			
			Assert.fail("General Information section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(3).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Client / Risk Profile')]").isDisplayed())
		{
			Assert.assertTrue(true,"Client / Risk Profile section is displayed.");
		}
		else
		{
			
			Assert.fail("Client / Risk Profile section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(4).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Name(s) / Description(s)')]").isDisplayed())
		{
			Assert.assertTrue(true,"Name(s) / Description(s) section is displayed.");
		}
		else
		{
			
			Assert.fail("Name(s) / Description(s) section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(5).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Groupings')]").isDisplayed())
		{
			Assert.assertTrue(true,"Groupings section is displayed.");
		}
		else
		{
			
			Assert.fail("Groupings section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
		
		TopBar.get(6).click();
		
		Thread.sleep(1000);
		
		if(driver.findElementByXPath("//a[contains(text(),'Transaction Accounts')]").isDisplayed())
		{
			Assert.assertTrue(true,"Transaction Accounts section is displayed.");
		}
		else
		{
			
			Assert.fail("Transaction Accounts section is not displayed.");
			TakeScreenshot.takeScreenshot(driver,"ValidateClientPageTopNavgationBar");
		}
			
		
	}
	
	@Test(priority=3, dependsOnMethods = { "ValidateClientPageTopNavgationBar" }, enabled=false)
	public void uploadDocClientHeader()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.findElementByXPath("//*[@id='MasterClient2']").click();
		
		String projectPath = System.getProperty("user.dir");
		
		String filePath=projectPath+"\\DocsToBeUploaded\\Testfile.txt";
		
		UploadDocument.docUpload(filePath);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[text()='Additional Document Details']")));
		
		Select se = new Select(driver.findElement(By.xpath("//*[@id='firstDocumentCategoryList']")));
		 
		se.selectByIndex(3);
		
		driver.findElementByXPath("//*[@id='uploadsubmitbtn']").click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),' Success')]")));
		
		if(driver.findElementByXPath("//div[contains(text(),' Success')]").isDisplayed())
		{
			Assert.assertTrue(true,"Document Uploaded Successfully");
		}
		else
		{
			
			Assert.fail("Document upload was Unsuccessfull");
			TakeScreenshot.takeScreenshot(driver,"uploadDocClientHeader");
		}
	}
	
	
	
}
