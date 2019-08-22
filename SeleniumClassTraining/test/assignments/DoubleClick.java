package assignments;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleClick {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void doubleClickTest() {
		driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
		WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions builder = new Actions(driver);
		builder.doubleClick(doubleclick).perform();
		String actual;
		Alert alert = null;
		try {
		    alert = driver.switchTo().alert();
			
		} catch (NoAlertPresentException e) {
			fail("No such alert present ....");
		}

		actual  = alert.getText();
		alert.accept();
		assertEquals(actual, "You double clicked me.. Thank You..");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);

	}

	@AfterMethod
	public void afterMethod() {
	}

}
