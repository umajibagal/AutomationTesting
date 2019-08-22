package assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Assignment1Gmail {
	WebDriver driver;
  @Test
  public void sendGmail() throws InterruptedException {
	  driver.get("https://www.gmail.com");
	  driver.findElement(By.id("identifierId")).sendKeys("bagalumaji");
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	  driver.findElement(By.name("password")).sendKeys("sai@sayaji");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	  driver.findElement(By.xpath("//div[text()='Compose']")).click();
	  driver.findElement(By.name("to")).sendKeys("ketan@paratussystems.com");
	  driver.findElement(By.name("subjectbox")).sendKeys("Ketan, I have done my assingment - UMESH");
	  driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("hello, Sir Ur Teaching is outstanding\n GN Sir");
	  driver.findElement(By.xpath("//div[text()='Send']")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
