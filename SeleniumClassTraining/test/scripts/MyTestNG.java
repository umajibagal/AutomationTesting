package scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTestNG {
	WebDriver driver=null;
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("bagalumaji");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("sai@sayaji");
		Thread.sleep(2000);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		
		String value = "gmail";
		String  actual = driver.getTitle();
		assertEquals(value, actual);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}

}
