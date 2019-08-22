package ddt.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooLoginPO extends LoadableComponent<YahooLoginPO> {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private YahooMyAccountPO myAccount;
	
	@FindBy(id = "login-username")
	private WebElement userNameField;

	@FindBy(id = "login-signin")
	private WebElement nextButton ;

	@FindBy(id = "login-passwd")
	private WebElement passwordField;

	@FindBy(id = "login-signin")
	private WebElement signInButton;

	public YahooLoginPO() {
		System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	public YahooLoginPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public YahooMyAccountPO yahooLogin(String username, String password) {
		userNameField.sendKeys(username);
		nextButton.click();
		passwordField.sendKeys(password);
		signInButton.click();
		return new YahooMyAccountPO(driver);	
	}

	@Override
	protected void load() {
		driver.get("https://login.yahoo.com");
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getTitle().contains("login"));
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}
}
