package com.maven.selenium.appium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;

public class screenShot extends appiumCapabilities{
    String folder_name;
    DateFormat df;

@SuppressWarnings("deprecation")
@Test
public void testSeekBar() throws Exception {
	// get the x y cordinates
	WebElement seek_bar = driver.findElement(By.id("seek_bar"));
	int start = seek_bar.getLocation().getX();
	int end = seek_bar.getSize().getWidth();
	int y = seek_bar.getLocation().getY();

	@SuppressWarnings("rawtypes")
	TouchAction action = new TouchAction(driver);
	action.press(start, y).moveTo(end, y).release().perform();
	int moveTo = (int) (end * 0.4);
	action.press(start, y).moveTo(moveTo, y).release().perform();

	captureScreenShots();
}

public void captureScreenShots() throws IOException {
	folder_name = "screenshot";
	File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	new File(folder_name).mkdir();
	String file_name = df.format(new Date()) + ".png";
	FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
}
}