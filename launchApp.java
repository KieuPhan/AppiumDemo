package com.appium.android;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class launchApp {
	
	 AppiumDriver<MobileElement> driver;
	 DesiredCapabilities capabilities;

	 
		Process p;
		 // Set path of your node.exe file.
		 // Progra~1 represents Program Files folder.
		 String nodePath = "C:\\Program Files (x86)\\Appium\\node.exe";
		 // Set path of your appium.js file.
		 String appiumJSPath = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
		 String cmd = nodePath + " " + appiumJSPath;
		 //AdroidDriver driver;

		 // This method Is responsible for starting appium server.
		 public void appiumStart() throws IOException, InterruptedException {
		  // Execute command string to start appium server.
		  p = Runtime.getRuntime().exec(cmd);
		  // Provide wait time of 10 mins to start appium server properly.
		  // If face any error(Could not start a new session...) then Increase
		  // this time to 15 or 20 mins.
		  Thread.sleep(10000);
		  if (p != null) {
		   System.out.println("Appium server Is started now.");
		  }
		 }

		 // This method Is responsible for stopping appium server.
		 public void appiumStop() throws IOException {
		  if (p != null) {
		   p.destroy();
		  }
		  System.out.println("Appium server Is stopped now.");
		 }
	 
	 
	@BeforeTest
	public  void setup() throws Exception{
		//Here
		appiumStop();
	  	  appiumStart();
	        capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platform", "Android");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("platformVersion", "5.0.2");
	        capabilities.setCapability("deviceName", "SAMSUNG-SM-G850A");
	        capabilities.setCapability("appPackage", "com.android.browser");
	        capabilities.setCapability("appActivity", "com.android.browser.BrowserActivity");
	        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
	        //capabilities.setCapability("autoWebview", true);
	 
	        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        driver.get("http://amazon.com");
	 
	        System.out.println(driver.getPageSource());
	}
		
	@Test
	public void method(){
	}
	
	
}
