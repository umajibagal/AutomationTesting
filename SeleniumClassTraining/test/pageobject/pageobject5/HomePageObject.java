package pageobject.pageobject5;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePageObject extends LoadableComponent<HomePageObject> {
	protected WebDriver driver;
	private MyAccountPage myaccount;
	@FindBy(id="loginname")
	private WebElement userField;
	
	@FindBy(id="loginpassword")
	private WebElement passField;
	
	@FindBy(id="loginbutton")
	private WebElement submitButton;
	
	private String expectedTitle="STC Tourism";
	public HomePageObject() {
		System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		PageFactory.initElements(driver, this);
		
	}
	public MyAccountPage login(String username,String password) {
		userField.sendKeys(username);
		passField.sendKeys(password);
		submitButton.click();
		myaccount =  new MyAccountPage(driver);
		return myaccount;
	}

	public void closeBrowser() {
		driver.quit();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	@Override
	protected void load() {
		driver.get("http://selenium-examples.nichethyself.com");
		
	}
	@Override
	protected void isLoaded() throws Error {
		
		assertEquals(driver.getTitle(),expectedTitle,"Page Load Failed.");
		
	}
}
