package com.OrangeHRM.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import com.OrangeHRM.Screnario2Pages.AdminPageOrangeHrm;
import com.OrangeHRM.Screnario2Pages.LoginPageOrangeHrm;




public class BaseClass {
 

	public WebDriver driver;
	
	public LoginPageOrangeHrm lp;
    public AdminPageOrangeHrm ap;

	
    
    @BeforeTest
	
	public void SetUpBrowser() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		lp=new LoginPageOrangeHrm (driver);
		ap=new AdminPageOrangeHrm  (driver);
	}
	
//	@BeforeClass
//	public void pageSetUp() {
//		
//		System.out.println("----Login Page-----");
//		lp.getTitle();
//		lp.doLogin();
//	}
}
