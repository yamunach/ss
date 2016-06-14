package com.grid;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestA {

public static RemoteWebDriver driver;
public static String appURL = "http://www.google.com";

@BeforeClass
@Parameters({ "browser" })
public void setUp(String browser) throws MalformedURLException {
System.out.println("*******************");
driver = Browser.getDriver(browser);
driver.manage().window().maximize();
}

@Test
public void testGooglePageTitleInFirefox() throws InterruptedException {
/*driver.navigate().to(appURL);
String strPageTitle = driver.getTitle();
Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");*/

	driver.get("http://www.rediff.com");
	driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("login1")).sendKeys("yamuna230510");
    driver.findElement(By.id("password")).sendKeys("sreehari@123");
    Thread.sleep(30000);
    driver.findElement(By.xpath("//div[1]/input")).click();
    //driver.findElement(By.name("proceed")).click();	  
    Thread.sleep(30000);
    System.out.println("After sleep");
    if(driver.findElement(By.id("Username")).getText().equals("yamuna230510")){
    	System.out.println("logged in successfully");
    }
		else{		

	
	System.out.println("login error");
		}

}

@AfterClass
public void tearDown() {
if (driver != null) {
System.out.println("Closing browser");
driver.close();
}
}

}
