package com.bagal.selenuim;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BlankNewTab {
	
	@Test
	public void newBlankTab() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");
		
	}
}
