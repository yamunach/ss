package com.grid;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
	System.out.println("A");
return new RemoteWebDriver(new URL("http://192.168.1.15:4444/wd/hub"), getBrowserCapabilities(browser));
}

private static DesiredCapabilities getBrowserCapabilities(String browserType) {
switch (browserType) {
case "firefox":
System.out.println("Opening firefox driver");
return DesiredCapabilities.firefox();
case "chrome":
System.out.println("Opening chrome driver");
return DesiredCapabilities.chrome();
case "iexplorer":
System.out.println("Opening IE driver");
return DesiredCapabilities.internetExplorer();
default:
System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
return DesiredCapabilities.firefox();
}
}
}
