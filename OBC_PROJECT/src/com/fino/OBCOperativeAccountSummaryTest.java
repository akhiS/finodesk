package com.fino;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fino.WebDriveCommon;;

public class OBCOperativeAccountSummaryTest extends WebDriveCommon {
	
	FirefoxDriver driver ;
	
	
	
	public static String intiatorCorporateID="", intiatorUserID, initiatorPassword, initiatorTransactionPwd;
	public static String approverCorporateID="", approverUserID, approverPassword, approverTransactionPwd;
	//private static final String inputFileNameOBC = commPropPSN.getProperty("inputFileNameOBC");
	//private static final String txnSrcFromDate = commPropPSN.getProperty("txnSrcFromDateOBC");
	//private static final String txnSrcToDate = commPropPSN.getProperty("txnSrcToDateOBC");
	
	@BeforeClass(groups=("Before"),description=(""))
	public void setUp() throws Exception
	{
		if (intiatorCorporateID.isEmpty())
		{
			intiatorCorporateID = JOptionPane.showInputDialog("Enter OBC Initiator Corporate ID:");
			intiatorUserID = JOptionPane.showInputDialog("Enter OBC Initiator User ID:");
			initiatorPassword = JOptionPane.showInputDialog("Enter OBC Initiator Password:");
//			intiatorCorporateID = "FINOFINTECHFOUNDATION";
//			intiatorUserID = "SANDIP";
//			initiatorPassword = "REDDAY456";
		}
		//System.out.println("Hi...."+commPropPSN.getProperty("OBCCorporateURL"));
		launchWebDriverWithProfile("firefox", commPropPSN.getProperty("OBCCorporateURL"));
		
		driver.findElement(By.linkText("Corporate User Login")).click();
		driver.findElement(By.id("AuthenticationFG.CORP_CORP_ID")).clear();
		driver.findElement(By.id("AuthenticationFG.CORP_CORP_ID")).sendKeys(intiatorCorporateID);
		driver.findElement(By.id("AuthenticationFG.CORP_USER_ID")).clear();
		driver.findElement(By.id("AuthenticationFG.CORP_USER_ID")).sendKeys(intiatorUserID);
		driver.findElement(By.id("STU_VALIDATE_CREDENTIALS")).click();
		driver.findElement(By.id("AuthenticationFG.ACCESS_CODE")).clear();
		driver.findElement(By.id("AuthenticationFG.ACCESS_CODE")).sendKeys(initiatorPassword);
		driver.findElement(By.id("VALIDATE_STU_CREDENTIALS")).click();
//		driver.findElement(By.id("chki")).click();
	//	driver.findElement(By.id("img")).click();
driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@class='midd-1']/div/div[3]/a[2]")).click();
				////////a[contains(@href, " +
				///"'https://www.obconline.co.in/BankAwayCorporate/sgonHttpHandler.aspx?Action.CorpUser.Init.001=Y&AppSignonBankId=022&AppType=Retail')]")).click();
		logInPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(groups="checkWAlkAway", description = "This test will be done only for one account to check credentials")
	public void initiateWalkAwayTransactions() throws Exception
	{
		//try
		{
			/* Check for initiator */
			//logInPage.loginOBC(intiatorCorporateID, initiatorPassword, intiatorUserID);
			//driver.get(baseUrl + "/");
			//driver.findElement(By.linkText("Corporate User Login")).click();
			//driver.findElement(By.linkText("Operative Accounts")).click();
			driver.findElement(By.id("Favourites_Operative-Accounts")).click();
			driver.manage().timeouts().pageLoadTimeout(90000, TimeUnit.SECONDS);
			
		try
		{
	        {
	       
	        	driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).clear();
    			driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).sendKeys();
    			//"765011000615");
	        }
		
			/*	            File file = new File(inputFileNameOBC);
	                FileReader fileReader = new FileReader(file);
	                BufferedReader bufferedReader = new BufferedReader(fileReader);
	                StringBuffer stringBuffer = new StringBuffer();
	                String line;
	                while ((line = bufferedReader.readLine()) != null)
	                {
	                	
	                	driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).clear();
	        			driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).sendKeys(line);//"765011000615");
	        			driver.findElement(By.id("LOAD_ACCOUNTS")).click();
	        			//driver.findElement(By.id("VIEW_TRANSACTION_HISTORY[0]0")).click();
	        			if (isElementPresent(driver, By.id("VIEW_TRANSACTION_HISTORY[0]0")))
	                    {
	        				mouseOverTheObject(logInPage.loadaccounts, By.xpath("//td/div/div/div/ul/li/a"));
	                    	//WebDriverWait wait = new WebDriverWait(driver, 300);
	        		    	//if(! (wait.until(ExpectedConditions.alertIsPresent())==null))
	        		    	 //{ 
	        		    	//	Alert alert = driver.switchTo().alert();
	        		    	//	alert.accept();
	        		    	//	driver.switchTo().defaultContent();
	        		    	 //}
	                    }
	        			mouseOverTheObject(logInPage.loadaccounts, By.id("VIEW_TRANSACTION_HISTORY[0]0"));
	        			driver.findElement(By.id("VIEW_TRANSACTION_HISTORY[0]0")).click();
//new Select (driver.findElement(By.linkText("View Transaction History"))).selectByVisibleText("View Transaction History");
	        			//driver.quit();
	        			
	        			driver.findElement(By.id("TransactionHistoryFG.FROM_TXN_DATE_Calendar_IMG")).click();
	        			driver.findElement(By.linkText("24")).click();
	        			driver.findElement(By.id("TransactionHistoryFG.TO_TXN_DATE_Calendar_IMG")).click();
	        			driver.findElement(By.linkText("27")).click();
	        			driver.findElement(By.id("SEARCH")).click();
	        			if(isElementPresent(driver, By.name("You have 1 Error Message[ACCTTX0083] [100130] The transactions do not exist for the account with the entered criteria.")))
	        			{
	        				//driver.manage().timeouts().implicitlyWait(90000, TimeUnit.SECONDS);
		        	    	driver.findElement(By.id("Button16346330")).click();
		        				
	        			}
	        			else
	        			{
	        				new Select(driver.findElement(By.id("TransactionHistoryFG.OUTFORMAT"))).selectByVisibleText("CSV file");
		        			driver.findElement(By.id("okButton")).click();	
	        			}
	                        //System.out.println("Dhiraj - Line: "+line);
	                        //stringBuffer.append(line);
	                        //stringBuffer.append("\n");
	                }
	                fileReader.close();
	    */            //System.out.println("Contents of file:");
	                //System.out.println(stringBuffer.toString());
	        
	        /*catch (IOException e)
	        {
	                e.printStackTrace();
	        }*/
	        
						
			//24-08-2015
			
			
			
 			//Dhiraj:JOptionPane.showMessageDialog(null, "Credentials are working fine.");
		}catch(Exception e){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\Reports\\errorCheckReports.png"));
			
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			Reporter.log("Error occured in trial login." +  writer.toString());
			driver.quit();}
		}
	}
	/*@Test(groups=("InitiateApprove"),description=("Merge Reports"),dependsOnMethods=("initiateWalkAwayTransactions"))
	public void initiateTransactions() throws Exception
	{
	 try
	 {	
       Clean Download Folders 
		File directory = new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\TestData\\Downloads");
		if (directory.exists()) 
			try {
				delete(directory);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
		}
		
		 Read Account numbers 
		List<String> processedAccList = new ArrayList<String>();
		File inputWorkbook = new File(inputFileNameOBC);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook); // Get the first sheet
		Sheet sheet = w.getSheet(0);
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell cell = sheet.getCell(0, i);
			processedAccList.add(cell.getContents());
		}
		
		//new Select(driver.findElement(By.name("Options.SelectList"))).selectByVisibleText("Account Statement");
		//driver.findElement(By.name("Action.Go")).click();
		
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		for (WebElement input : inputs) {((JavascriptExecutor) driver).executeScript(
		                "arguments[0].removeAttribute('readonly','readonly')",input);
		}
		
		for(String accountName: processedAccList)  
        {
			driver.findElement(By.id("Favourites_Operative-Accounts")).click();
			driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).clear();
			driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).sendKeys(accountName);
			driver.findElement(By.id("LOAD_ACCOUNTS")).click();
			WebElement mainMenu = driver.findElement(By.xpath("/*[@id='menu1']/div"));
			Actions builder = new Actions(driver);    
			builder.moveToElement(mainMenu).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, 5); 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='VIEW_TRANSACTION_HISTORY[0]0']")));  // until this submenu is found
			WebElement menuOption = driver.findElement(By.xpath("//*[@id='VIEW_TRANSACTION_HISTORY[0]0']"));
			menuOption.click();
			
			//String cssLocatorOfTheElement="//*[@id='VIEW_TRANSACTION_HISTORY[0]0']" ;   
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					           //StringBuilder stringBuilder = new StringBuilder();
					          // stringBuilder.append("var x = $(\'"+cssLocatorOfTheElement+"\');");
					           //stringBuilder.append("x.click();");
					          // js.executeScript(stringBuilder.toString());
			//Actions action = new Actions(driver);
			//WebElement mainMenu = driver.findElement(By.xpath("/*[@id='menu1']/div"));
			//action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//*[@id='VIEW_TRANSACTION_HISTORY[0]0']"))).click().build().perform();
			//WebElement drop= driver.findElement(By.className("menuPullDownHead"));
			//Select sel=new Select(drop);
			//sel.selectByValue("");
			//sel.selectByIndex(0);
			//driver.findElement(By.className("menuPullDownHead")).click();
			//driver.findElement(By.id("VIEW_TRANSACTION_HISTORY[0]0")).click();
			driver.findElement(By.id("TransactionHistoryFG.FROM_TXN_DATE_Calendar_IMG")).sendKeys(txnSrcFromDate);
			driver.findElement(By.id("TransactionHistoryFG.TO_TXN_DATE_Calendar_IMG")).sendKeys(txnSrcToDate);
			driver.findElement(By.id("SEARCH")).click();
			if (isElementPresent(driver, By.name("Action.Accounts.SaveAs.ExcelFormat")))
            	driver.findElement(By.name("Action.Accounts.SaveAs.ExcelFormat")).click();
			
			
			
			
			//driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).clear();
			//driver.findElement(By.id("AccountSummaryFG.ACCOUNT_NUMBER")).sendKeys(accountName);
		//driver.findElement(By.id("LOAD_ACCOUNTS")).click();
		//mouseOverTheObject(logInPage.loadaccounts, By.xpath("(//a[contains(text(),'View Transaction History')])[2]"));
		//driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("VIEW_TRANSACTION_HISTORY[0]0")).click();
		//Dhiraj:driver.findElement(By.linkText("VIEW_TRANSACTION_HISTORY[0]0")).click();
		
		//driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
		//driver.findElement(By.id("TransactionHistoryFG.FROM_TXN_DATE_Calendar_IMG")).click();
		//driver.findElement(By.linkText("24")).click();
		//driver.findElement(By.id("TransactionHistoryFG.TO_TXN_DATE_Calendar_IMG")).click();
		//driver.findElement(By.linkText("27")).click();
		//driver.findElement(By.id("SEARCH")).click();
			driver.findElement(By.name("txnSrchSortOrder")).click();
			driver.findElement(By.name("txnSrcFromDate")).clear();
			driver.findElement(By.name("txnSrcFromDate")).sendKeys(txnSrcFromDate);
			driver.findElement(By.name("txnSrcToDate")).clear();
			driver.findElement(By.name("txnSrcToDate")).sendKeys(txnSrcToDate);
			driver.findElement(By.xpath("(//input[@name='accountquery'])[5]")).click();
			driver.findElement(By.name("Action.Accounts.QuerySelection.QueryStatement")).click();
            if (isElementPresent(driver, By.name("Action.Accounts.SaveAs.ExcelFormat")))
            	driver.findElement(By.name("Action.Accounts.SaveAs.ExcelFormat")).click();
        }
          
		isElementPresent(driver, By.name("Action.Accounts.SaveAs.QueryStatement"));
		boolean b = isElementPresent(driver, By.name("Action.Accounts.SaveAs.QueryStatement"));
		if(b)
		{
			System.out.println("Dhiraj - true");
		}
		{
			System.out.println("Dhiraj - false");
		}
         Change File Extension 
        File folder = new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\TestData\\Downloads");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                File f = new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\TestData\\Downloads\\"+listOfFiles[i].getName()); 
                f.renameTo(new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\TestData\\Downloads\\"+i+".txt"));
            }
        }
        
         Merge Excel files 
        MergeReports.mergeAllReportsForOBC(txnSrcFromDate, txnSrcToDate);
           
		}catch (Exception e){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\Anita\\WorkSpace\\WebDriverDemoSAP\\Reports\\errorReports.png"));
			
             Log Out 
			Reporter.log("Error occured:" + e.toString());
		}//catch block ends here
		finally{
            driver.quit();
		}
	}
	
	private static void delete(File file) throws IOException {
		if (file.isDirectory()) {
			 directory is empty, then delete it  
			if (file.list().length == 0) {
				 file.delete();
	    		   System.out.println("Directory is deleted *: " + file.getAbsolutePath());
			} else {
				 list all the directory contents  
				String files[] = file.list();

				for (String temp : files) {
					 construct the file structure  
					File fileDelete = new File(file, temp);
					delete(fileDelete);
				}
			}
		} else {
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}
	
	
	private void mouseOverTheObject(WebElement element, By byElement) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 200); 
		Locatable hoverItem = (Locatable) element;
		Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		element.click();
	}
	
	
	@AfterClass(groups=("After"),description=("Tear down"))
	public void tearDown()
	{
		driver.quit();
	}
}*/
}