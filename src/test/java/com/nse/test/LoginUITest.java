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

import com.nse.base.WebDriverWrapper;


public class LoginUITest extends WebDriverWrapper {

	@Test
	public void validateTitleTest() 
	{
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		 
		
	}
	@Test
	public void UIcomponentTest() {
		
		boolean userNameTEsxBox = driver.findElement(By.id("txtUsername")).isDisplayed();
		boolean passwordTEsxBox = driver.findElement(By.id("txtPassword")).isDisplayed();
		boolean loginButton = driver.findElement(By.id("btnLogin")).isDisplayed();
		boolean forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot")).isDisplayed();
		String forgotPasswordText = driver.findElement(By.partialLinkText("Forgot")).getText();
		
		Assert.assertTrue(userNameTEsxBox);
		Assert.assertTrue(passwordTEsxBox);
		Assert.assertTrue(loginButton);
		Assert.assertTrue(forgotPasswordLink);
		
		Assert.assertEquals(forgotPasswordText, "Forgot your password?");
		
}
	}
