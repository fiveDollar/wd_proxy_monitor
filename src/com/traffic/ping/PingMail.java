package com.traffic.ping;

import com.traffic.mailUtil.Mail;
import com.traffic.mailUtil.MailConf;

public class PingMail {
	
	public static void send(String device,String ip){
		String html = "<div style='line-height:1.7;color:#000000;font-size:14px;font-family:Arial'><div>hi：<br>&nbsp;&nbsp;&nbsp; I want to reboot device:"+device+"  ip:"+ip+"<br>&nbsp;&nbsp;&nbsp; Thanks.<br></div></div>";
		MailConf mc = new MailConf();
		mc.init("conf/mail.conf");
		Mail.send(mc.getSmtp(), mc.getFrom(), mc.getTo(), "Reboot "+device, html, mc.getFrom(), mc.getPassword());
	}
	
	public static void main(String[] args) {
		send("B1.14.yellow","");
	}
}
