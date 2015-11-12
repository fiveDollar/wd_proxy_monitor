package com.traffic.util;

import java.util.ArrayList;
import java.util.Properties;

import com.traffic.server.Server;

public class ReadServerFromCnf {
	public static ArrayList<Server> getServer(String serverListConfPath,String key){
		Properties p =	PropertiesUtil.read(serverListConfPath);
		String externalServer = p.getProperty(key);
		ArrayList<Server> serverList = new ArrayList<>();
		//clear externalServer data to server
		String servers[] = externalServer.split("\\},\\{");
		for (String serString : servers) {
			serString = serString.replace("[{", "").replace("}]", "");
			Server server = new Server();
			String serfeature[] = serString.split(",");
			for (String feature : serfeature) {
				if(feature.contains("host:"))
					server.setIp(feature.replace("host:", ""));
				else if(feature.contains("device:"))
					server.setDeviceName(feature.replace("device:", ""));
				else if(feature.contains("password:"))
					server.setPassword(feature.replace("password:", ""));
				else if(feature.contains("user:"))
					server.setUser(feature.replace("user:", ""));
				else if(feature.contains("owner:"))
					server.setOwner(feature.replace("owner:", ""));
				else 
					System.out.println(feature);
			}
			serverList.add(server);
		}
		return serverList;
	}
}
