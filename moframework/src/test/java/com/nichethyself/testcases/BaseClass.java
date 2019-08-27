package com.nichethyself.testcases;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.nichethyself.utilities.BrowserConfigDataProvider;
import com.nichethyself.utilities.BrowserFactory;
import com.nichethyself.utilities.ExcelDataProvider;
import com.nichethyself.utilities.Helper;
import com.nichethyself.utilities.Log4jDataConfigProvider;

public class BaseClass {

	WebDriver driver;
	ExcelDataProvider excel;
	BrowserConfigDataProvider config;
	Helper helper;
	ExtentReports reports;
	Logger logger;
	ExtentTest test;
	@BeforeSuite
	public void setupSuite() {

		excel = new ExcelDataProvider();
		config = new BrowserConfigDataProvider();
		helper = new Helper();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				new File("./Reports/NT.html"));// ExtentHtmlReporter(new
																				// File(System.getProperties("user.dir")+"/Reports/NT.html"));
		reports = new ExtentReports();
		reports.attachReporter(reporter);

	}

	@Parameters({"browser","urlToTested"})
	@BeforeClass
	public void setup(String browser,String url) {
		logger = Log4jDataConfigProvider.getLogger(BaseClass.class);
		//driver = BrowserFactory.startBrowser(driver, config.getBrowserData(), config.getUrl());
		
		driver = BrowserFactory.startBrowser(driver, browser, url);
		
		logger.info("sucessfully loaded all browser confiration");
		System.out.println(config.getDatafromConfig("name"));
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quiteBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE)
			helper.captureScreenShot(driver);

		reports.flush();
	}
}
