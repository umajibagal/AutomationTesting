package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentJuly17 {
	WebDriver driver;
  @Test
  public void compareItems() {
	  driver.get("https://www.gsmarena.com/");
	  driver.findElement(By.xpath("//a[text()='Apple']")).click();
	  driver.findElement(By.xpath("//a[text()='Compare']")).click();
	  driver.findElement(By.xpath("")).click();
	
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
