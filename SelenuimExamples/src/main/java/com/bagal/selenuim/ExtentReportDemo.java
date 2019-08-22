package com.bagal.selenuim;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportDemo {
	WebDriver driver;
	
	@Test
	public void verifyTitle() {
		
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\bagal\\resources\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
		String title = driver.getTitle();
		assertTrue(title.contains("Google"));
		
	}

}
