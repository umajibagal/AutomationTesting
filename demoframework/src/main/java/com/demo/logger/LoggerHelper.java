package com.demo.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	static Logger log;
	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/test/resources/configfiles/log4j.properties");
		log = Logger.getLogger(LoggerHelper.class);
		log.info("1 log ");
		log.info("2 log ");
		log.info("3 log ");
	}
}
