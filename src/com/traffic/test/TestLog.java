package com.traffic.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLog {
	private static Logger logger = Logger.getLogger(TestLog.class);
	public static String log4jPath =  "conf/log4j.properties";
	public static void main(String[] args) {
		PropertyConfigurator.configure(log4jPath);
		logger.info("aaaa");
		
	}

}
