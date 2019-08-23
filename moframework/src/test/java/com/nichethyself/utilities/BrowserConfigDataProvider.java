package com.nichethyself.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class BrowserConfigDataProvider {

	Properties pro;
	Logger logger;
	public BrowserConfigDataProvider() {
		File file = new File("./Configs/config.properties");
		logger = Log4jDataConfigProvider.getLogger(BrowserConfigDataProvider.class);
		try {

			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			logger.info("File loaded successfully");
		} catch (IOException e) {
			System.out.println("unable to load config properties file >> " + e.getMessage());
			logger.info("unable to load config file from : "+file.getAbsolutePath());
		}
	}

	public String getDatafromConfig(String key) {
		return pro.getProperty("name");
	}

	public String getBrowserData() {
		return pro.getProperty("browser");
	}

	public String getUrl() {
		return pro.getProperty("qaUrl");
	}
}
