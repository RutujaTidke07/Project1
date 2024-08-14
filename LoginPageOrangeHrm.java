package com.OrangeHRM.Screnario2Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.OrangeHRM.Base.BaseClass;

public class LoginPageOrangeHrm {

	private WebDriver driver;

	public LoginPageOrangeHrm(WebDriver driver) {

		this.driver = driver;

	}

	// Locators
    //Encapsulation OOPS principle
	private By username = By.xpath("//input[@name = 'username']");
	private By password = By.xpath("//input[@name = 'password']");
	private By login = By.xpath("//button[@type = 'submit']");

	// Methods

	public String getTitle() {
		
		Assert.assertTrue(driver.getTitle().contains("HRM"), "Title is not matching");
		System.out.println("Title is matched: " +  driver.getTitle());
		return driver.getTitle();
		
		
	}

	public void doLogin() {

		driver.findElement(username).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(login).click();
	}
}
