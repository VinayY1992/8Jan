package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	public static void Screenshot(WebDriver driver,String name) throws IOException {
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File destination = new File("H:\\New folder (2)\\"+name+" "+timestamp+".jpg");
		FileHandler.copy(source, destination);
	}

}
