package com.nse.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginUITest {
	private WebDriver driver;
	
	
	@BeforeMethod
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
	
	@Test
	public void validateTitleTest() 
	{
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		 
		
	}
	@Test
	public void UIcomponentTest() {
		
		Boolean userNameTEsxBox = driver.findElement(By.id("txtUsername")).isDisplayed();
		Boolean passwordTEsxBox = driver.findElement(By.id("txtPassword")).isDisplayed();
		Boolean loginButton = driver.findElement(By.id("btnLogin")).isDisplayed();
		Boolean forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot")).isDisplayed();
		String forgotPasswordText = driver.findElement(By.partialLinkText("Forgot")).getText();
		
		Assert.assertTrue(userNameTEsxBox);
		Assert.assertTrue(passwordTEsxBox);
		Assert.assertTrue(loginButton);
		Assert.assertTrue(forgotPasswordLink);
		
		Assert.assertEquals(forgotPasswordText, "Forgot your password?");
		
}
	}
