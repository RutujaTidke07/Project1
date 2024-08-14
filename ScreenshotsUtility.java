package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenshotsUtility {
	
	WebDriver driver;
	@Test
	public static void ScreenShots1(WebDriver driver,String Filename)  {
		
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest1 = new File(
				"C:\\Users\\mayur.t\\OneDrive - Trinity Mobility Pvt Ltd\\Desktop\\Study Material with Recording\\STAR AGILE\\PROJECT\\Screenshots\\"
						+ Filename + System.currentTimeMillis() + ".png");

		try {
			Files.copy(src1, dest1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}
}
