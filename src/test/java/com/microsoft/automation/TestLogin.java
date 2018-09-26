package com.microsoft.automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Login.Login;


public class TestLogin {
	
	private WebDriver driver;
	private Login login; 
	
	@BeforeMethod
	public void BeforeTest()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://mywipro.wipro.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login = new Login(driver);
	}
	
	@Test
	public void LoginTest()
	{
		try {
		System.out.println("Test Started");
		login.LoginPage("mkumarm3@wipro.com", "Oct@2018");
		login.ClickLogin();
		System.out.println("Test Ended");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}
	
	@AfterMethod
	public void AfterTest()
	{
		driver.quit();
		
	}
	
}
