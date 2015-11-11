package com.traffic.ping;

import java.net.InetAddress;

public class PingUtil {
	public static void main(String[] args) {
		System.out.println(ping("192.184.41.50",300000));
	}
	public static boolean ping(String host,int connectTimeOut){
		InetAddress address;
		try {
			address = InetAddress.getByName(host);
			return address.isReachable(connectTimeOut);
		} catch (Exception e) {
			return false;
		}
	}
}
