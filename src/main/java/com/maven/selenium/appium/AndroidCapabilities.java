package com.maven.selenium.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class AndroidCapabilities {
	public AndroidDriver androidDriver;

	@BeforeTest
	public void setUpTest() {
		DesiredCapabilities cap = new DesiredCapabilities();
		String apkAppPath = "/Users/madhukargudla/Documents/Android app/android-examples-develop/ActivityLifecycle/app/build/intermediates/resources/instant-run/debug/resources-debug.apk";
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("deviceName", "Pixel");
		cap.setCapability("appPackage", "github.nisrulz.activitylifecycle");
		cap.setCapability("appActivity", "github.nisrulz.activitylifecycle.MainActivity");
		cap.setCapability("app", apkAppPath);

		try {
			androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		if (androidDriver != null)
			androidDriver.quit();
	}

	@Test
	public void androidTest() {
		MobileElement ele = (MobileElement) androidDriver.findElement(By.id("More options"));
		String name = ele.getText();
		System.out.println(name);
		Assert.assertTrue(ele.isDisplayed());
	}

}
