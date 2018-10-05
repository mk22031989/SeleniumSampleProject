package com.microsoft.automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Login.Login;
import XlsXlsXHelpers.XlsXlsxHelper;


public class TestLogin {
	
	private WebDriver driver;
	private Login login; 
	
	@BeforeMethod
	public void BeforeTest()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login = new Login(driver);
	}
	
	@Test(enabled = false)
	public void LoginTest()
	{
		try {
		System.out.println("Test Started");
		login.LoginPage(driver,"mkumarm3@wipro.com", "Oct@2018");
		login.ClickLogin();
		System.out.println("Test Ended");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}
	
	@Test(enabled = false)
	public void LoginTestUsingKeyBoard()
	{
		try {
		System.out.println("Test Started Using Keboard Actions");
		login.LoginUsingKeboardActions("mkumarm3@wipro.com", "Oct@2018");
		System.out.println("Test Ended");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}
	
	@Test(enabled = false)
	public void TestDD()
	{
		login.SelectBootStrapDD(driver, "//a[@class='dropdown-toggle'][text()='Men']", "//div[@class='dropdownLinksBlock']/ul/li/a[text()='T-Shirts'][contains(@onclick,'Men')]");
	}
	
	@Test
	public void TestExcel() throws IOException
	{
		XlsXlsxHelper _helper = new XlsXlsxHelper();
		Object [][] data =_helper.ReadFromExcel(".xlsx", "Test Suite");
		for(int i =0; i<=data.length;i++)
		{
			for(int j=0;j<=2;j++)
			{
				System.out.println(data[i][j]);
			}
			
		}
	}
	
	@AfterMethod
	public void AfterTest()
	{
		driver.quit();
		
	}
	
}
