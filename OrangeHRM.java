package Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Utility.ExcelSheetUtility;
import Utility.ScreenshotsUtility;

public class OrangeHRM {
	WebDriver driver;
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void StartReport() {
		htmlreporter = new ExtentSparkReporter("OrangeHrmExtentProjectReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		test = reports.createTest("ExtentTest");

		// Environmen deatails if required

		reports.setSystemInfo("User", "Rutuja");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("OS", "Window 10+");

		// // //conf.to change theame & feel //
		htmlreporter.config().setDocumentTitle("ExtendsReportProject"); //
		htmlreporter.config().setReportName("Test Report"); //
		htmlreporter.config().setTheme(Theme.STANDARD); //
	}

	@Test(dataProvider = "excelfile", dataProviderClass = ExcelSheetUtility.class)
	public void testcase(String Username, String Password) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);

		// ScreenShots

		ScreenshotsUtility.ScreenShots1(driver, "ORANGE-HRM");
		System.out.println("---------Screenshot Saved Successfully--------------");
		Thread.sleep(2000);

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Fail");
		System.out.println("-------------Login Successfully Done..!!!---------------");

		// LogOut

		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("-------------LogOut Successfully Done..!!!-------------");
		Thread.sleep(3000);
		ScreenshotsUtility.ScreenShots1(driver, "ORANGE-HRM");
	}

	@AfterMethod

	public void extendReport(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TestCase Pass Sucessfully");

		} else {
			test.log(Status.FAIL, "TestCase get Fail");
		}
	}

	@AfterClass
	public void tearDown() {
		reports.flush();
		
	}
}
