package pageobject.pageobject5;

import org.testng.annotations.Test;

import pageobject.pageobject4.HomePageObject;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class TestDemo {
	HomePageObject homepageobject;
	MyAccountPage myaccount;

	@Test
	public void loginTest() {
		myaccount =homepageobject.login("stc123", "12345");
		assertEquals(homepageobject.getTitle(), "My account", "Login Failed.");
		myaccount.contactUsTest();
		myaccount.signOutTest();
	}

	@BeforeMethod
	public void beforeMethod() {
		homepageobject = new HomePageObject();
		homepageobject.get();
	}

	@AfterMethod
	public void afterMethod() {
		//homepageobject.closeBrowser();
	}
}