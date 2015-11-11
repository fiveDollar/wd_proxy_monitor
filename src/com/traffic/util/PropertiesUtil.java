package com.traffic.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties read(String fileName){
		Properties p = new Properties();
		try {
			InputStream in = new FileInputStream(fileName);
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
