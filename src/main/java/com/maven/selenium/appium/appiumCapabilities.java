package com.maven.selenium.appium;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumCapabilities {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeTest
	public void setUpTest() throws InterruptedException{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withIPAddress("127.0.0.1")
				.usingPort(4723));
		service.start();
		Thread.sleep(5000L);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		String iOSAppPath = "/Users/madhukargudla/Library/Developer/Xcode/DerivedData/FacebookMe-fyzxpfzmoyqgjdeozmsyokpgqvxo/Build/Products/Debug-iphonesimulator/FacebookMe.app";
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "11.3");
		cap.setCapability("deviceName", "iPhone 8 Plus");
		cap.setCapability("app", iOSAppPath);
		cap.setCapability("noReset", "true");
		
		try{
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
	}
	@AfterTest
	public void tearDown(){
		if(driver != null)
			driver.quit();
			service.stop();
	}
	
	@Test
	/*
	 * sample test case to find elements on UI using element locator 'name'*/
	public void findElements(){
		driver.findElement(By.name("Friends"));
	}
	
}
