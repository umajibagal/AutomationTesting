package pageobject.pageobject2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageObject {
	private By userLocator = By.id("loginname");
	private By passLocator = By.id("loginpassword");
	private By submitLocator = By.id("loginbutton");
	
	private WebDriver driver;
	public HomePageObject() {
		System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://selenium-examples.nichethyself.com");
	}
	public void login(String username,String password) {
		driver.findElement(userLocator).sendKeys(username);
		driver.findElement(passLocator).sendKeys(password);
		driver.findElement(submitLocator).click();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void closeBrowser() {
		driver.close();
	}
}
