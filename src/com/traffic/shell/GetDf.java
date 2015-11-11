package com.traffic.shell;

import java.util.Properties;

import com.traffic.util.PropertiesUtil;

public class GetDf {

	public static void main(String[] args) {
//		Shell shell = new Shell(host, password, user)
		Properties p = PropertiesUtil.read("conf/df_monitor_server.properties");
		System.out.println(p.get("server_list"));
	}
	
	public String getDf(){
		Properties p = PropertiesUtil.read("conf/df_monitor_server.properties");
//		System.out.println(p.get("server_list"));
		String[] server_list = p.get("server_list").toString().split(",");
		for (String serverInfo : server_list) {
			Shell shell = new Shell(serverInfo.split("@")[1].split(":")[0], serverInfo.split("@")[1].split(":")[1], serverInfo.split("@")[0]);
			
		}
		return null;
		
	}
}
