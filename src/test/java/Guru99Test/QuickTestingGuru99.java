package Guru99Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuickTestingGuru99 {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		// --------------------Config Prop file read-----------------//

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:/Interview/Eclipse Interview workspace/WebTesting/src/test/java/config.properties/");
		prop.load(ip);

		String baseUrl = prop.getProperty("URL");
		System.out.println("URL link: " + baseUrl);

		String browserName = prop.getProperty("browser");
		System.out.println("Browser open: " + browserName);

		if (browserName.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// ------------------------------------------------------------------------------//
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
		System.out.println("URL Open in chrome browser");

		driver.findElement(By.xpath(prop.getProperty("EmailId_xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("Sbumit_button_xpath"))).click();
		
		
	}
}
