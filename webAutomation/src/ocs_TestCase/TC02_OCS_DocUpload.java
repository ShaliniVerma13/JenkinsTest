package ocs_TestCase;

import java.io.IOException;


import org.testng.annotations.Test;

import basePackage.InstantiateDrivers;
import basePackage.TakeScreenshot;
import basePackage.UploadDocument;
import readConfigFile.PropertyFileReader;

public class TC02_OCS_DocUpload  extends InstantiateDrivers {
	
	String ActiveClientId=PropertyFileReader.ApplicationConfigReader("ActiveClientID_QA");
			
	@Test
	public void UploadDocOnClientSearchResult() throws IOException, InterruptedException{
		
		try{
		searchPage.enterSearchText(ActiveClientId);
		
		searchPage.clickSearchButton();
		
		searchPage.clickDocUploadIcon_SearchResult();
		
		String projectPath = System.getProperty("user.dir");
		
		String filePath=projectPath+"\\DocsToBeUploaded\\Testfile.txt";
		
		UploadDocument.docUpload(filePath);
		
		UploadDocument.AdditionalDocDetailsPopup(driver);
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"UploadDocOnClientSearchResult");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
	}

	
	@Test
	public void uploadDocClientHeader()
	{
		try{		 
		searchPage.enterSearchText(ActiveClientId);
		
		searchPage.clickSearchButton();
		
		searchPage.clickClientForDashboardNavigation(ActiveClientId);
		
		leftNavigationMenu.clickClientTab();
				
		clientInformationPage.clickHeaderDocUploadIcon();
		
		String projectPath = System.getProperty("user.dir");
		
		String filePath=projectPath+"\\DocsToBeUploaded\\Testfile.txt";
		
		UploadDocument.docUpload(filePath);
		
		UploadDocument.AdditionalDocDetailsPopup(driver);
		}
		catch (Exception e) {
			// TODO: handle exception
			TakeScreenshot.takeScreenshot(driver,"uploadDocClientHeader");
			System.out.println("*************Exception***********");
			e.printStackTrace();
		}
	}
	
}
