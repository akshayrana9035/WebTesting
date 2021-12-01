package com.TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	 WebDriver driver;
	 
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		String baseUrl="https://google.com";	
		driver.get(baseUrl);
	}
	
	@Test (priority=1)
	public void googleTitleTest() {
		String gtitle=driver.getTitle();
		System.out.println("Title of google URL is : "+gtitle);
				
		/*-- No need to write in place of this we are using Assertion
		if(gtitle.equals("Google")) {
		System.out.println("Pass");
		}else
			System.out.println("False");
		*/
		
		Assert.assertEquals(gtitle,"Google123","Tile is not matched");
		
	}
	
	
	@Test(priority=2, groups="Text Box Test")
	public void textBoxDisplayTest() {
		//driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed());
	}
	
	@Test(priority=3,groups="Text Box Test")
	public void textBoxEnableTest() {
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isEnabled();
		
	}
	
	@Test(priority=4,groups="Text Box Test")
	public void textBoxSelectedTest() {
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isSelected();
	}
	
	@Test(priority=5,groups="Link Test")
	public void mailLinkTest() {
		driver.findElement(By.linkText("Gmail"));
	}
	
	@Test(priority=6,groups="Link Test")
	public void imagesLinkTest() {
		driver.findElement(By.linkText("Images"));
	}
	
	@Test(priority=7,groups="Button Test")
	public void searchButtonTest() {
		driver.findElement(By.xpath("//input[@value='Google Search']"));
		
	}
	
	@Test(priority=8,groups="Button Test")
	public void feelingLuckyButtontest() {
		driver.findElement(By.xpath("//input[@class='RNmpXc']"));
	}
	

	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		//Thread.sleep(5000);
		driver.quit();
	}
	

}
