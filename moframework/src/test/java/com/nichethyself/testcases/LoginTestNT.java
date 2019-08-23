package com.nichethyself.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nichethyself.pages.NTLoginPO;
import com.nichethyself.utilities.ExcelDataProvider;
import com.nichethyself.utilities.Log4jDataConfigProvider;

public class LoginTestNT  extends BaseClass{
	
	@Test
	public void loginApp() {
	
		test = reports.createTest("login to NTHOME");
		NTLoginPO ntlogin = PageFactory.initElements(driver, NTLoginPO.class);
		logger = Log4jDataConfigProvider.getLogger(LoginTestNT.class);
		logger.info("driver loaded sucessfully");
		test.info("login successfully");
		String ps = excel.getNumericDdata("Login", 0, 1)+"".toString();
		ntlogin.loginNT(excel.getStringData("Login", 0, 0), ps);
		test.pass("Login passed");
		logger.info("login sucessfully");
	}
}
