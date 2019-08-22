package ddt.testbase;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ddt.csv.ReadCSV;
import ddt.dao.LoginDao;
import ddt.pageobject.YahooLoginPO;
import ddt.pageobject.YahooMyAccountPO;
import ddt.poi.Xls_Reader;
import ddt.xls.ReadXLSUsingJXL;

public class LoginTestDB {
	private LoginDao dao;
	private YahooLoginPO yahooLogin;
	private YahooMyAccountPO myAccount;
	private ReadXLSUsingJXL readXLS;

	// @Test(dataProvider = "mySqlLoginData")
	public void loginTest(String username, String password) {
		myAccount = yahooLogin.yahooLogin(username, password);
		assertTrue(yahooLogin.getTitle().contains("India"));
		myAccount.myMail();
		myAccount.signOut();
	}

	// @Test(dataProvider = "jxlLoginData")
	public void loginTestJXL(String username, String password) {
		myAccount = yahooLogin.yahooLogin(username, password);
		assertTrue(yahooLogin.getTitle().contains("India"));
		myAccount.myMail();
		myAccount.signOut();
	}

	@Test(dataProvider = "csvLoginData")
	public void loginTestCSV(String username, String password) {
		myAccount = yahooLogin.yahooLogin(username, password);
		assertTrue(yahooLogin.getTitle().contains("India"));
		myAccount.myMail();
		myAccount.signOut();
	}
	
	//@Test(dataProvider = "xlsxLoginData")
	public void loginTestXLSX(String username, String password) {
		myAccount = yahooLogin.yahooLogin(username, password);
		assertTrue(yahooLogin.getTitle().contains("India"));
		myAccount.myMail();
		myAccount.signOut();
	}

	@BeforeMethod
	public void beforeMethod() {
		yahooLogin = new YahooLoginPO();
		yahooLogin.get();
	}

	@AfterMethod
	public void afterMethod() {
		// yahooLogin.closeBrowser();
	}

	@DataProvider(name = "mySqlLoginData")
	public Iterator loginDbData() {
		return new LoginDao().getData().iterator();
	}

	@DataProvider(name = "csvLoginData")
	public Iterator loginCSVData() {
		return new ReadCSV().readAllDataAtOnce("src//ddt//datafiles//logindata.csv").iterator();
	}
	
	@DataProvider(name = "jxlLoginData")
	public Object[][] loginJXLData() {
		Object[][] data = readXLS.getDataFromXLSUsingJXL("src//ddt//datafiles//demo.xls", "LoginData",
				"StartAndEnd");
		return (data);
	}
	
	
	@DataProvider(name = "xlsxLoginData")
	public Object[][] loginXLSXData() {
		//Object[][] data = new Xls_Reader().getDataFromXLSUsingJXL("src//ddt//datafiles//logindata.xls");
		return null;
	}
}
