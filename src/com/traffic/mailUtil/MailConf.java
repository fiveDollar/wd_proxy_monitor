package com.traffic.mailUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailConf {
	private String to = "";
	private String copyTo = "";
	private String from = "";
	private String smtp = "";
	private String password = "";
	public void init(){
		Properties p = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream("conf/mail.conf");
			p.load(in);
			this.to = p.getProperty("to");
			this.copyTo = p.getProperty("copy");
			this.from = p.getProperty("from");
			this.password = p.getProperty("password");
			this.smtp = p.getProperty("smtp");
		} catch (IOException e) {
			
		}finally{
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
			}
		}
	
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCopyTo() {
		return copyTo;
	}
	public void setCopyTo(String copyTo) {
		this.copyTo = copyTo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
