package com.traffic.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			InputStream in = new FileInputStream("conf/mail.conf");
			p.load(in);
			System.out.println(p.getProperty("to"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

