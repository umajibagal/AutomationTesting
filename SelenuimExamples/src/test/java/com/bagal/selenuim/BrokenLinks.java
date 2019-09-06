package com.bagal.selenuim;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks extends LoadableComponent<BrokenLinks> {
	WebDriver driver;

	@Test
	public void brokenLinkTest() {
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Links count : " + links.size());
		for (WebElement webElement : links) {
			checkLinkStatus(webElement.getAttribute("href"));
		}
	}

	public void checkLinkStatus(String urllink) {
		try {
				URL url = new URL(urllink);
				HttpURLConnection http = (HttpURLConnection)url.openConnection();
				
				http.setConnectTimeout(3000);
				http.connect();
				
				if(http.getResponseCode() == 200)
					System.out.println("Message  : "+http.getResponseMessage());
				
				if(http.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
					System.out.println("broken link : "+http.getResponseMessage());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

}
