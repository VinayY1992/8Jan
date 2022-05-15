package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserChrome {
	
	public static WebDriver browser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"G:\\SOFTWARE TESTING\\chrome new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
