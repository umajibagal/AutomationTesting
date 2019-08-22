package com.bagal.selenuim;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoSuggestive {
	WebDriver driver;
  @Test
  public void autoDropDown() throws InterruptedException {
	  String windowName = driver.getWindowHandle();
	  driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	  driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	  driver.switchTo().parentFrame();
	  driver.findElement(By.id("deny")).click();  
  }
  @BeforeMethod
  public void beforeMethod() {
	//  System.setProperty("webdriver.gecko.driver", "src/main/java/com/bagal/resources/geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://www.makemytrip.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
