package com.OrangeHRM.Screnario2Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.zerodha.qa.Base.TestBase;

public class AdminPageOrangeHrm {

	
	
	WebDriver driver;

	public AdminPageOrangeHrm(WebDriver driver) {

		this.driver = driver;
	}

	// locaters
	private By alloptions = By.xpath("//ul[@class='oxd-main-menu']//li");
	//(//input[@class='oxd-input oxd-input--active'])[2]
	private By user = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By searchbutton = By.xpath("//button[@type='submit']");
	private By recordfound = By.xpath("//span[@class='oxd-text oxd-text--span']");

	private By userRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By userRolealloptions = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]");
	private By searchbutton1 = By.xpath("//button[@type='submit']");
	private By recordfound1 = By.xpath("//span[@class='oxd-text oxd-text--span']");
//select status , userstatus
	//private By selectStatus = By.xpath("  (//div[@class=\"oxd-select-text-input\"])[2]");
	//
	private By selectStatus = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	private By userStatusalloptions = By.xpath("(//div[@role='listbox'])//div");
	private By searchbutton2 = By.xpath("//button[@type='submit']");
	private By recordfound2 = By.xpath("//span[@class='oxd-text oxd-text--span']");

	// methods

	public void countoptions() {
		List<WebElement> list = driver.findElements(alloptions);
		System.out.println("Found Total count:" + list.size());

		for (WebElement i : list) {

			System.out.println(i.getText());

			if (i.getText().contains("Admin")) {

				i.click();
				break;
			}
		}
	}

	public void searchByUserName() {

		driver.findElement(user).sendKeys("Admin");
		System.out.println("User Search Suceessfully");
		driver.findElement(searchbutton).click();
		System.out.println("---- Search button Clicked----");
		String records1 = driver.findElement(recordfound).getText();
		System.out.println("Total displayed record" + records1);
		driver.navigate().refresh();
		System.out.println("Page is Refreshed");

	}

	public void searchByUserRole() {

		driver.findElement(userRole).sendKeys("Admin");
		System.out.println("Role Search Suceessfully");
		List<WebElement> list = driver.findElements(userRolealloptions);
		System.out.println("Found Total options:" + list.size());

		for (WebElement i : list) {

			System.out.println(i.getText());

			if (i.getText().contains("Admin")) {

				i.click();
				break;
			}

			driver.findElement(searchbutton1).click();
			System.out.println("---- Search button Clicked----");
			String records2 = driver.findElement(recordfound).getText();
			System.out.println("Total displayed record" + records2);
			driver.navigate().refresh();
			System.out.println("Page is Refreshed");

		}

	}

	public void searchByUserStatus() {

		driver.findElement(selectStatus).click();
		System.out.println("Status Search Suceessfully");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userStatusalloptions));
		List<WebElement> list1 = driver.findElements(userStatusalloptions);
		System.out.println("Found Total options:" + list1.size());

		for (WebElement i : list1) {

			System.out.println(i.getText());

			if (i.getText().contains("Enabled")) {

				i.click();
				break;
			}
		}
		driver.findElement(searchbutton2).click();
		System.out.println("---- Search button Clicked----");
		String records3 = driver.findElement(recordfound2).getText();
		System.out.println("Total displayed record" + records3);
		driver.navigate().refresh();
		System.out.println("Page is Refreshed");

		}
}
