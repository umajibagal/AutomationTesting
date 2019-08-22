package gmailpo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends LoadableComponent<GmailLoginPage> {
	private GmailInbox gmailAccount;
	private WebDriverWait wait;

	@FindBy(id = "identifierId")
	private WebElement usernameField;

	@FindBy(id = "identifierNext")
	private WebElement usernameNextButton;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(id = "passwordNext")
	private WebElement passwordNextButton;

	private WebDriver driver;
	private String expectedTitle = "Gmail";

	public GmailLoginPage() {
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver32.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);

	}

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public GmailInbox login(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierNext"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext"))).click();	
		gmailAccount = new GmailInbox(driver);
		return gmailAccount;
	}

	@Override
	protected void load() {
		driver.get("http://www.gmail.com");
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),expectedTitle);
	}
}
