package pageobject.pageobject5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	HomePageObject homePage;
	WebDriver driver;
	
	@FindBy(className = "link")
	private WebElement contactUsLink;

	@FindBy(xpath="//a[@href='home.html']")
	private WebElement signOutLink;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signOutTest() {
		signOutLink.click();
	}

	public void contactUsTest() {
		contactUsLink.click();
	}

}
