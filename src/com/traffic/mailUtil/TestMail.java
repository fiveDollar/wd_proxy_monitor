package com.traffic.mailUtil;

public class TestMail {
	public static void main(String[] args) {
		MailConf mc = new MailConf();
		mc.init("conf/mail.conf");
		System.out.println(mc.getCopyTo());
		System.out.println(mc.getFrom());
		System.out.println(mc.getPassword());
		System.out.println(mc.getSmtp());
		System.out.println(mc.getTo());
	}
}
