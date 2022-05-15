package TestData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.ZerodhaLoginPage;
import Utility.ExcelData;
import Utility.Screenshots;
import Utility.browserChrome;
import io.netty.handler.codec.http.HttpContentEncoder.Result;



public class TestLogin {
	WebDriver driver;
	ZerodhaLoginPage login;
	@BeforeTest
	  public void beforeTest() {
		  System.out.println("test = Login with Credentials & click on Submit button");
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println(" We are executing Positive testcaess for Zerodha login page");   
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  driver = browserChrome.browser("https://kite.zerodha.com");
	  }
	  @Test(priority=-1)
	  public void LoginCredential() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		 login = new ZerodhaLoginPage(driver);
		 login.UserId(ExcelData.getdata("Sheet1", 0, 1));
		 login.password(ExcelData.getdata("Sheet1", 1, 1));
		 login.submitbutton();
		 Thread.sleep(1000);
		 login.Enterpin(ExcelData.getdata("Sheet1", 2, 1));
		 login.ContinueButton(); 
	  }
	  @Test
	  public void LoginWithoutCredentials()
	  {
		  login = new ZerodhaLoginPage(driver);
		  login.submitbutton();
	  }
	  @Test (priority = 1,dependsOnMethods = {"LoginWithoutCredentials"})
	  public void ForgotPassClick()
	  {
		  login = new ZerodhaLoginPage(driver);
		  login.ForgotPass();
	  }
	  @Test(priority = 2,dependsOnMethods = {"LoginWithoutCredentials"})
	  public void ClickOnSignUp() throws InterruptedException
	  {
		  login = new ZerodhaLoginPage(driver);
		  login.Signup();
		 Set<String> a=driver.getWindowHandles();
		 ArrayList<String> i = new ArrayList(a);
		 driver.switchTo().window(i.get(1));
		  Thread.sleep(5000);
  
	  }
	  
	@Test
	  public void KiteLogo()
	  {
		  login = new ZerodhaLoginPage(driver);
		  login.Logo();  
	  }
	  @AfterMethod
	  public void afterMethod() throws InterruptedException, IOException {
		  Thread.sleep(3000);
		  Screenshots.Screenshot(driver, "abc"); 
	  }
	  @AfterClass
	  public void afterClass() throws IOException {
		  
	  }
	  @AfterTest
	  public void afterTest() {
		  System.out.println("Test pass");
	  }
	  
	/*WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.out.println("Welcome to Zerodha Login Page testing hub");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Positive Testing");
	}
	@BeforeMethod
	public void OpenBrowser() throws InterruptedException
	{
		driver =browserChrome.browser("https://kite.zerodha.com");
	}
	@Test
	public void LoginWithValidCredential() throws EncryptedDocumentException, IOException{
		ZerodhaLoginPage login2 = new ZerodhaLoginPage(driver);
		login2.UserId("CZ4358");
		login2.password("Logitech@99");
		login2.submitbutton();
	}
	@Test (priority = 1)
	public void EnterPin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(5000);
		ZerodhaLoginPage login = new ZerodhaLoginPage(driver);
		login.Enterpin(ExcelData.getdata("Sheet1", 2, 1));
		login.ContinueButton();
	}
	@AfterMethod
	public void aftermethod() throws InterruptedException
	{
	Thread.sleep(3000);
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Positive Testing completed");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("Thank You !!!");
	}*/
	
	
	

}
