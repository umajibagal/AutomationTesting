package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GnailExplicitWait {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void gmailExplicitWait() {
	  driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bagalumaji@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();  
	
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sai@sayaji");;
		 
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		wait= new WebDriverWait(driver,15);
		
  }

  @AfterMethod
  public void afterMethod() {
  }

}
