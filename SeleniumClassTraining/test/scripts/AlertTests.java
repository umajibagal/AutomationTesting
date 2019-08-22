package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AlertTests {
	WebDriver driver;
 // @Test
  public void alertTests() throws InterruptedException {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.id("loginname")).sendKeys("stc123");
	  driver.findElement(By.id("loginbutton")).click();
	  Thread.sleep(3000);
	  try {
		  Alert alert = driver.switchTo().alert();
		  assertEquals("Please enter Password", alert.getText());
		  alert.accept();
		  Thread.sleep(3000);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }    
  }
  
 // @Test
  public void alertTestsOkCancel() throws InterruptedException {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.id("logo")).click();
	  Thread.sleep(3000);
	  try {
		  Alert alert = driver.switchTo().alert();
		  assertEquals("Do you wanna leave the page?", alert.getText());
		  alert.dismiss();
		  Thread.sleep(3000);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }  
		
  }
  
@Test
 public void alertTestsOkCancelAndSendkeys() throws InterruptedException {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
	 //Change the context from 1st page to the second page
	  try {
		  driver.switchTo().window("Contact");
	  }catch (NoSuchWindowException e) {
		  fail("Contact Us Window did not show up.");
	  }
	  driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search']")).click();
	  Thread.sleep(3000);
	  try {
		  Alert alert = driver.switchTo().alert();
		  //assertEquals("Do you wanna leave the page?", alert.getText());
		  alert.sendKeys("London");
		  alert.accept();
		  Thread.sleep(3000);
	  }catch (NoAlertPresentException e) {
		  fail("Alert was expected but seems not appearing at this point.");
	  }  
	  driver.close();
		
 }
 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
  }

  @AfterMethod
  public void afterMethod() {
  }

}
