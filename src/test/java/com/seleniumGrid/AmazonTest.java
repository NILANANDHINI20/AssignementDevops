package com.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest {

	public WebDriver driver;

	@Parameters({"browser"})
	@Test
	public void setup(@Optional("chrome") String browser) throws InterruptedException {
		
		System.out.println("Remote Driver Connectivity is Started!");

		if (browser.equalsIgnoreCase("chrome")) {

			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Chrome Browser Launched");

		} else if (browser.equalsIgnoreCase("firefox")) {
 
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Firefox Browser Launched");

		} else if (browser.equalsIgnoreCase("edge")) {

			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), new EdgeOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Edge Browser Launched");

		}
        //SCM TEST
		driver.manage().window().maximize();  		
		System.out.println("Remote Driver Connectivity is Completed!");
		Thread.sleep(10000);
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		System.out.println("Title is :" + driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Title: " + driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}
}
