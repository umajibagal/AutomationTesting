package assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Assignment5CompareProducts {
	WebDriver driver =new FirefoxDriver();;
  @Test
  public void compareTest() {
	  driver.get("https://www.gsmarena.com/");
	  driver.findElement(By.xpath("//a[text()='Apple']")).click();
	  driver.findElement(By.xpath("//a[text()='Compare']")).click();
	  
	  WebElement firstitem =  driver.findElement(By.xpath("//span[text()='iPad Pro 12.9 (2018)']"));
	  if(!firstitem.isSelected())
		  firstitem.click();
	  
	  WebElement seconditem = driver.findElement(By.xpath("//span[text()='iPad Pro 11']"));
	  if(!seconditem.isSelected())
	  	seconditem.click();
	  
	  String actualFirstItemSelected = firstitem.getText();
	  String expectedFirst = "iPad Pro 12.9 (2018)";
	  
	  assertEquals(actualFirstItemSelected, expectedFirst,"Items does not matching");
	  
	  String actualSecondItemSelected = seconditem.getText();
	  String expectedSecondItem = "iPad Pro 11";
	  
	  assertEquals(actualSecondItemSelected, expectedSecondItem,"Items does not matching");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 // System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
	//  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(61, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
