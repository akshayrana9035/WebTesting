package com.TestNg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testByConfigFile {

	static WebDriver driver;
	Properties prop = new Properties();
		
	@BeforeMethod
	public void setProperty() throws IOException {
/*
		Properties prop = new Properties();
			*/
		FileInputStream ip = new FileInputStream(
				"D:/Interview/Eclipse Interview workspace/WebTesting/src/test/java/config.properties");
	
		prop.load(ip);
		System.out.println("Property file setup to read Data");

		String browserName = prop.getProperty("browser");
		System.out.println("Browser Used: " + browserName);
		String baseUrl = prop.getProperty("qaUrl");
		System.out.println("URL Used: " + baseUrl);

		if (browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} 
		else if (browserName.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}

	@Test
	public void Test1() {
		// validate the title
		String qatitle = driver.getTitle();
		System.out.println("Title of URL is : " + qatitle);

		// Assertion use for validation
		
		Assert.assertEquals(qatitle, "ToolsQA", "Not a valid title");
	
		//Click on Element link
		
		//driver.findElement(By.xpath(prop.getProperty("Elements_xpath"))).click();
		
		
	}

	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		
		driver.quit();
	}

}
