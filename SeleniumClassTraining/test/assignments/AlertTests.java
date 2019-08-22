package assignments;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests {
	WebDriver driver;

	// @Test
	public void alertOk() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		try {
			Alert alert = driver.switchTo().alert();
			String str = alert.getText();

			alert.accept();

			assertEquals("I am a JS Alert", str);

			String resultext = driver.findElement(By.id("result")).getText();
			assertEquals(resultext, "You successfuly clicked an alert", "You have not clicked on alert");

		} catch (NoAlertPresentException e) {
			fail("Alert was expected but not seems appearing at this point..");
		}
	}

	// @Test
	public void alertOkCancelAndSendKey() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		try {
			Alert alert = driver.switchTo().alert();
			String okcanceltext = alert.getText();

			assertEquals("I am a JS prompt", okcanceltext, " you have not clicked alert");

			alert.sendKeys("bagal");
			alert.accept();
			String res = driver.findElement(By.id("result")).getText();
			assertEquals("You entered: bagal", res);
			// assertEquals("You entered: null", res);

		} catch (NoAlertPresentException e) {
			fail("Alert was expected but not seems apprearing at this point");
		}
	}

	// @Test
	public void alertOkCancel() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		try {
			Alert alert = driver.switchTo().alert();
			String canceltext = alert.getText();

			alert.dismiss();
			assertEquals("I am a JS Confirm", canceltext);

			String resultext = driver.findElement(By.id("result")).getText();
			assertEquals(resultext, "You clicked: Cancel", "You have not clicked on alert");

		} catch (NoAlertPresentException e) {
			fail("Alert was expected but seems not appeard at this point");
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void alertTests() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
		Thread.sleep(3000);
		try {
			driver.switchTo().window("Contact");
			driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search']")).click();
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("London");
			alert.accept();
		} catch (NoSuchWindowException e) {
			fail("Contact Us Window did not shown up");
		} catch (NoAlertPresentException e) {
			fail("Alert was expected but seems not appearing at this point.");
		}
		driver.close();
	}

}
