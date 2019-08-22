package pageobject.pageobject4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class LoginTest {
	HomePageObject homepageobject;
  @Test
  public void loginTest() {
	 homepageobject.login("stc123", "12345");
	 assertEquals(homepageobject.getTitle(), "My account","Login Failed.");
  }
  @BeforeMethod
  public void beforeMethod() {
	  homepageobject = new HomePageObject();
	  homepageobject.get();
  }

  @AfterMethod
  public void afterMethod() {
	  homepageobject.closeBrowser();
  }

}
