package com.traffic.ping;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.traffic.util.PropertiesUtil;

public class PingServer {
	static Properties p =	PropertiesUtil.read("conf/serviceList.properties");
	
	public static void main(String[] args) {
		while(true){
			String[] serverList = p.getProperty("externalServer").split(",");
			for (String server : serverList) {
				String host = server.split("@")[0];
				for (int i = 0; i <= 15; i++) {
					if(PingUtil.ping(host, 300000)){
						break;
					}else{
						try {
							TimeUnit.MINUTES.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(i==15){
						System.out.println(host+"cant connect"+i);
					}
				}
			}
			try {
				TimeUnit.MINUTES.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
