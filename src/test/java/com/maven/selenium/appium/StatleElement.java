package com.maven.selenium.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class StatleElement {
	
	public IOSDriver driver = null;
	/*
	 * One way of catching the stale element
	 */
	public void clickOn(By locator, WebDriver driver, int timeout)
	{
	    final WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.refreshed(
	        ExpectedConditions.elementToBeClickable(locator)));
	    driver.findElement(locator).click();
	}
	
	
	/*
	 * Other way of finding the stale element exception
	 */
	public boolean clickElement(By by){
		boolean result = false;
		int attempt = 0;
		while(attempt<2){
			try{
				driver.findElement(by).click();
				result = true;
				break;
			}catch(Exception e){
				System.out.println(e);
			}
			attempt++;
		}
		return result;
	}
}
