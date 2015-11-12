package com.traffic.ping;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.traffic.server.Server;
import com.traffic.util.PropertiesUtil;
import com.traffic.util.ReadServerFromCnf;

public class PingServer {
	final static String SERVER_LIST_CONF_PATH =  "conf/serviceList.properties";
	final static String PROPERTIES_KEY = "externalServer";
	public static void main(String[] args) {
		while(true){
			ArrayList<Server> serverList = ReadServerFromCnf.getServer(SERVER_LIST_CONF_PATH,PROPERTIES_KEY);
			System.out.println(serverList);
			for (Server server : serverList) {
				for (int i = 0; i <= 15; i++) {
					if(PingUtil.ping(server.getIp(), 300000)){
						System.out.println(server.getIp()+" connected");
						break;
					}else{
						System.out.println(server.getIp()+"can't connect"+i);
						try {
							TimeUnit.MINUTES.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(i==15){
						System.out.println(server.getIp()+"can't connect"+i);
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
//	public static ArrayList<Server> getServer(){
//		Properties p =	PropertiesUtil.read(SERVER_LIST_CONF_PATH);
//		String externalServer = p.getProperty("externalServer");
//		ArrayList<Server> serverList = new ArrayList<>();
//		//clear externalServer data to server
//		String servers[] = externalServer.split("\\},\\{");
//		for (String serString : servers) {
//			serString = serString.replace("[{", "").replace("}]", "");
//			Server server = new Server();
//			server.setDeviceName(serString.split(",")[1].replace("device:", ""));
//			server.setIp(serString.split(",")[0].replace("host:", ""));
//			serverList.add(server);
//		}
//		return serverList;
//	}
	
}
