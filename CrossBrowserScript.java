package com.grid;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {

	WebDriver driver;

	@BeforeTest
	@Parameters("browesr")
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\yamuna\\WorkspaceNew\\MySelProject\\Browsers\\chromedownload\\chromedriver.exe ");
			driver = new ChromeDriver();
		} 
	else if (browser.equalsIgnoreCase("IE")) {
			System.out.println("***********"+browser);
			System.setProperty("webdriver.ie.driver","E:\\yamuna\\WorkspaceNew\\MySelProject\\Browsers\\chromedownload\\chromedriver.exe ");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.get("http://rediffmail.com");
	}

}