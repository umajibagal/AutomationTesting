package assignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowHandlesTests {
	WebDriver driver;
	WebDriverWait wait;

	//@Test
	public void printAllWindowHandlesStringTest1() throws InterruptedException {
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		String parent = driver.getWindowHandle();
		System.out.println("Parent WindowHandle : " + parent);
		WebElement element = driver.findElement(By.id("button1"));
		for (int i = 0; i < 3; i++) {
			element.click();
			Thread.sleep(3000);
		}
		Set<String> allwindowhandle = driver.getWindowHandles();
		System.out.println("**************All window handle**********");
		for (String string : allwindowhandle) {
			System.out.println(string);
		}
		
		String p1 = driver.getWindowHandle();
		System.out.println(p1);
	}
	
	@Test
	public void printAllWindowHandlesStringTest() throws InterruptedException {
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.id("button1")).click();
		//driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		
		System.out.println("\nParent Window Title : "+driver.getTitle());
		
		Set<String> all = driver.getWindowHandles();
		for (String handle : all) {
			if(!parent.equals(handle)) {
				//System.out.println(driver.switchTo().window(handle).getTitle());
				//driver.close();
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//nav//span[text()='Blogs']")).click();
			}
		}
		driver.switchTo().window(parent);
		System.out.println("\nParent Window Title : "+driver.getTitle());		
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 15);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
