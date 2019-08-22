package pageobject.pageobject3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	private WebDriver driver;
	
	@FindBy(id="loginname")
	private WebElement userloginField;
	
	@FindBy(id ="loginpassword")
	private WebElement passwordField;
	
	@FindBy(id ="loginbutton")
	private WebElement submitButton;
	
	public HomePageObject() {
		System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		PageFactory.initElements(driver, this);
		driver.get("http://selenium-examples.nichethyself.com");
	}
	public void login(String username,String password) {
		userloginField.sendKeys(username);
		passwordField.sendKeys(password);
		submitButton.click();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void closeBrowser() {
		driver.quit();
	}
	 
}
