package POM;

import org.openqa.selenium.WebDriver;

import Utility.browserChrome;

public class SanityTestData {
	public static void main(String[] args) {
		
		WebDriver driver = browserChrome.browser("https://kite.zerodha.com");//to validate our url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String ActualPageTitle = "Kite - Zerodha's fast and elegant flagship trading platform";
		String CurrentPageTitle = driver.getTitle();
		System.out.println(CurrentPageTitle);
		if(ActualPageTitle.equals(CurrentPageTitle))
		{
			System.out.println("Page Title are matching");
		}
		else
		{
			System.out.println("Test Fail");
		}
	}

}
