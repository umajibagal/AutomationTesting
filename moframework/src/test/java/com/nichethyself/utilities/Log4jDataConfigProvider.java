package com.nichethyself.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4jDataConfigProvider {
	private static boolean root=false;
	public static Logger getLogger(Class cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("./Configs/log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}
}
