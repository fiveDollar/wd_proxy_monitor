package com.traffic.server;

public class Server {
//	private String hostInfo;
	private String ip;
	private String user;
	private String password;
	private String serverName;
	private String deviceName;
	private String owner;
	
	public Server(){}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Server [ip=" + ip + ", user=" + user + ", password=" + password
				+ ", serverName=" + serverName + ", deviceName=" + deviceName
				+ ", owner=" + owner + "]";
	}


	

	
}	
