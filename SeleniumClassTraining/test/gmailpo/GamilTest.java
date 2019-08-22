package gmailpo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
public class GamilTest {
	private GmailLoginPage gmailLogin;
	private GmailInbox gmailInbox;

	@Test
	public void loginTest() {
		gmailInbox = gmailLogin.login("bagalumaji", "sai@sayaji");
		gmailInbox.isLoaded();
		gmailInbox.compose();
		gmailInbox.signOut();
	}

	@BeforeMethod
	public void beforeMethod() {
		gmailLogin = new GmailLoginPage();
		gmailLogin.get();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
