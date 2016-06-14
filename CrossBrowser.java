package com.grid;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	
	public static String nodeurl="http://192.168.1.15:5566/wd/hub";
	WebDriver driver;
	
	@BeforeTest
	@Parameters( "browser")
	
	public void setup(String browser) throws Exception {
		System.setProperty("webdriver.chrome.driver","Browsers\\chromedownload\\chromedriver.exe");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
			capabilities1.setBrowserName("chrome");
			capabilities1.setPlatform(Platform.WINDOWS);
			driver=new RemoteWebDriver(new URL(nodeurl),capabilities1);
		} 
		else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("***********"+browser);
		  System.setProperty("webdriver.ie.driver","Browser\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setBrowserName("ie");
			capabilities.setPlatform(Platform.WINDOWS);
			driver=new RemoteWebDriver(new URL(nodeurl),capabilities);
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.get("http://rediffmail.com");
		driver.quit();
	}
}
