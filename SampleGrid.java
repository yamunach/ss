package com.grid;



import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SampleGrid {

	
	public static String baseurl="http://www.ebay.in/ ";
	public static String nodeurl="http://192.168.1.15:5566/wd/hub";
	public static WebDriver driver=null;
	


	 
@BeforeTest
public void setup() throws MalformedURLException, InterruptedException
{
	
	//File file = new File("D:\\chrome\\Chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
System.setProperty("webdriver.chrome.driver", "Browser\\chromedriver.exe");


  driver=new ChromeDriver();
	DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
	capabilities1.setBrowserName("chrome");
	capabilities1.setPlatform(Platform.WINDOWS);
	driver=new RemoteWebDriver(new URL(nodeurl),capabilities1);

	//driver=new ChromeDriver();
}
@Test
public static void click_login() throws MalformedURLException
{
	
	driver.get(baseurl);
	driver.manage().window().maximize();
	WebElement ebayloginclick=driver.findElement(By.xpath("html/body/div[3]/div/header/div/ul[1]/li[1]/span/a"));
	ebayloginclick.click();
	
}
@AfterTest
public void endsession()
{
	
	driver.quit();
}
}