package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyGmailDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bagalumaji@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sai@sayaji");;
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		//xpath("//span[@class='RveJvd snByac']")).click(); 
	}
}
