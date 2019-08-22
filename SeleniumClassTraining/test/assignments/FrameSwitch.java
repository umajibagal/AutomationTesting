package assignments;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameSwitch {
	WebDriver driver;
	WebDriverWait wait;
	
	//@Test
	public void frameSwicth1() {
		driver.get("http://the-internet.herokuapp.com/frames");
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		try {
			driver.switchTo().frame(0);
		} catch (NoSuchFrameException e) {
			fail("no such frame present..");
		}
		WebElement textBox = driver.findElement(By.id("tinymce"));
		textBox.clear();
		textBox.sendKeys("Hello how r u ....");
		
		String actual = driver.findElement(By.id("tinymce")).getText();
		String exptecd = "Hello how r u ....";
		assertEquals(actual, exptecd);
		
		driver.switchTo().parentFrame();
		
		
	}
	
	@Test
	public void frameSwicth() {
		driver.get("https://www.toolsqa.com/iframe-practice-page");
		try {
			driver.switchTo().frame("iframe1");
		} catch (NoSuchFrameException e) {
			fail("no such frame present..");
		}
		driver.findElement(By.name("firstname")).sendKeys("Bagal");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("iframe2");
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		driver.switchTo().parentFrame();
		
	}
	
	//@Test
	public void windowSwitch() {
		driver.get("http://cookbook.seleniumacademy.com/Frames.html");
		try {
			driver.switchTo().frame("left");
		} catch (NoSuchFrameException e) {
			fail("no such frame present..");
		}
		String actualData = driver.findElement(By.xpath("//p[text()='This is Left Frame']")).getText();
		String expectedData = "This is Left Frame";
		
		assertEquals(actualData, expectedData);
		
		driver.switchTo().parentFrame();
	
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
