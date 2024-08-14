package com.OrangeHRM.Scenario2;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.ScreenshotsUtility;

public class AdminPageOrangeHrmTest extends BaseClass {
	 
	WebDriver driver;
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void pageSetUp() {
		System.out.println("----Login Page-----");
		lp.getTitle();
		lp.doLogin();
	}

	@BeforeTest
	public void StartReport() {
		htmlreporter = new ExtentSparkReporter("Scenario2ProjectReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		test = reports.createTest("ExtentTest");

		// Environmen deatails if required

		reports.setSystemInfo("User", "Rutuja Tidke");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("OS", "Window 10+");

		// // //conf.to change theame & feel //
		htmlreporter.config().setDocumentTitle("ExtendsReportProject");
		htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
	}

	@Test(priority = 1)
	public void AllOptions() throws InterruptedException {
		Thread.sleep(2000);
		ap.countoptions();
	}

	@Test(priority = 2)
	public void searchByUserName() throws InterruptedException {
		Thread.sleep(2000);
		ap.searchByUserName();
	}

	@Test(priority = 3)
	public void searchByUserRole() throws InterruptedException {
		Thread.sleep(3000);
		ap.searchByUserRole();

	}

	@Test(priority = 4)
	public void searchByUserStatus() throws InterruptedException {
		Thread.sleep(20000);
		ap.searchByUserStatus();

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
