package com.maven.selenium.appium;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class brokenImages {

	/**
	 * response.statusLine().getStatusCode() != 200 This is the crucial line to print the broken images 
	 * which says if statuCode is not equal to 200 then its a broken image
	 */
	
	private ChromeDriver driver;
	private int invalidImageCount;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/Users/madhukargudla/Documents/Jars/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");
	}
	
	@Test
	public void invalidImage(){
		try{
			invalidImageCount = 0;
			
			List<WebElement> imageList = driver.findElements(By.tagName("img"));
			System.out.println("Image count" +imageList.size());
			for(WebElement imageElement : imageList){
				if(imageElement != null){
					verifyActiveImage(imageElement);
				}
			}
			System.out.println("total count of invalid images" +invalidImageCount);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	@AfterClass
	public void tearDown(){
			if(driver!=null){
				driver.quit();
		}
	}
	
	public void verifyActiveImage(WebElement imageElement){
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imageElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code: HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
