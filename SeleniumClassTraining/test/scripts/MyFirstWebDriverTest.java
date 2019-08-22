package scripts;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

 class MyFirstWebDriverTest1 {
	public static void main(String[] tttt) {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		String s1 = "My account";
		String s2 = driver.getTitle();
		if(s1.equalsIgnoreCase(s2))
			System.out.println("Test passed");
		else
			System.out.println("Test Fail");
	}
}
//8 locating tech
		// 1 - id

