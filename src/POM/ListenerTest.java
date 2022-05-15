package POM;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import Utility.Screenshots;

public class ListenerTest extends BaseClass implements ITestListener
{
	public void onTestStart(ITestResult result )
	{
		System.out.println("started " + result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Success "+ result.getName());
		try
		{
			Screenshots.Screenshot(driver,result.getName());
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result)
	{
		try
		{
			Screenshots.Screenshot(driver,result.getName());
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped " + result.getName());
	}
	
}

