package com.demo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.demo.utility.BrowserFactory;

public class LoginTestCRM {

	WebDriver driver;
	@Test
	public void loginApp() {
		driver = BrowserFactory.startApplication(driver, "chrome", "https://www.freecrm.com/index.html");
		System.out.println("Page Title : "+driver.getTitle());
	}
}
