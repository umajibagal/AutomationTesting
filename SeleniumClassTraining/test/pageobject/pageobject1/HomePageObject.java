package pageobject.pageobject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageObject {
	private WebElement  userField;
	private WebElement passwordField;
	private WebElement submitButton;;
	private WebDriver driver;
	
	public HomePageObject() {
		System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://selenium-examples.nichethyself.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void login(String username,String password) {
		userField = driver.findElement(By.id("loginname"));
		userField.sendKeys(username);
		passwordField = driver.findElement(By.id("loginpassword"));
		passwordField.sendKeys(password);
		submitButton = driver.findElement(By.id("loginbutton"));
		submitButton.click();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void closeBrowser() {
		driver.quit();
	}
	
}
