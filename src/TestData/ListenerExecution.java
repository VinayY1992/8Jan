package TestData;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.BaseClass;
import POM.ListenerTest;
import POM.ZerodhaLoginPage;
import Utility.ExcelData;
import Utility.browserChrome;

@Listeners(ListenerTest.class)
public class ListenerExecution extends BaseClass {
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver = browserChrome.browser("https://kite.zerodha.com");
	}
	@Test
	public void LoginWithCredential() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ZerodhaLoginPage login = new ZerodhaLoginPage(driver);
		 login.UserId(ExcelData.getdata("Sheet1", 0, 1));
		 login.password(ExcelData.getdata("Sheet1", 1, 1));
		 login.submitbutton();
		 Thread.sleep(1000);
		 login.Enterpin(ExcelData.getdata("Sheet1", 2, 1));
		 login.ContinueButton();
		 Assert.assertTrue(true);
		 System.out.println("vinay Yewale here");
	}
	@Test
	public void test()
	{
		System.out.println("Github prctic");
	}

}
