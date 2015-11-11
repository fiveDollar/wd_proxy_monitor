package com.traffic.ping;

import com.traffic.mailUtil.Mail;
import com.traffic.mailUtil.MailConf;

public class PingMail {
	
	public static void send(String device){
		String html = "<div style='line-height:1.7;color:#000000;font-size:14px;font-family:Arial'><div>hi：<br>&nbsp;&nbsp;&nbsp; I want to reboot server "+device+"<br>&nbsp;&nbsp;&nbsp; Thanks.<br></div></div>";
		MailConf mc = new MailConf();
		mc.init();
		Mail.send(mc.getSmtp(), mc.getFrom(), mc.getTo(), "Reboot", html, mc.getFrom(), mc.getPassword());
		
	}
	
	public static void main(String[] args) {
		send("B1.14.yellow");
	}
}
