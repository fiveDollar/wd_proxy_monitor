package com.traffic.ping;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.traffic.mailUtil.Mail;
import com.traffic.mailUtil.MailConf;
import com.traffic.server.Server;
import com.traffic.util.PropertiesUtil;
import com.traffic.util.ReadServerFromCnf;

public class PingServer {
	final static String SERVER_LIST_CONF_PATH =  "conf/serviceList.properties";
	final static String PROPERTIES_KEY = "externalServer";
	final static String MAIL_CONF = "conf/mail.comf";
	public static void main(String[] args) {
		while(true){
			ArrayList<Server> serverList = ReadServerFromCnf.getServer(SERVER_LIST_CONF_PATH,PROPERTIES_KEY);
			System.out.println(serverList);
			//ping serverList 中的server
			for (Server server : serverList) {
				//最多ping 15次,即会ping 45分钟如果45分钟都ping 不通则发送响应的邮件
				for (int i = 0; i <= 15; i++) {
					if(PingUtil.ping(server.getIp(), 300000)){
						System.out.println(server.getIp()+" connected");
						break;
					}else{
						System.out.println(server.getIp()+" can't connect"+i);
						try {
							TimeUnit.MINUTES.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(i==15){
						System.out.println(server.getIp()+" can't connect"+i);
						MailConf mc = new MailConf();
						mc.init(MAIL_CONF);
						Mail.send(mc.getSmtp(), mc.getFrom(), server.getOwner(), "cant connect server "+server.getIp(), "cant connect server "+server.getIp(), mc.getFrom(), mc.getPassword());
					}
				}
			}
			try {
				TimeUnit.MINUTES.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
