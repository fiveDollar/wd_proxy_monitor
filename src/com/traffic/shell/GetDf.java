package com.traffic.shell;

import java.util.ArrayList;

import com.traffic.mailUtil.Mail;
import com.traffic.mailUtil.MailConf;
import com.traffic.server.Server;
import com.traffic.util.ReadServerFromCnf;

public class GetDf {
	final static String SERVER_LIST_PAHT = "conf/df_monitor_server.properties";
	final static String SERVER_LIST_KEY = "server_list";
	public static void main(String[] args) {
		ArrayList<Server> serverList = ReadServerFromCnf.getServer(SERVER_LIST_PAHT, SERVER_LIST_KEY);
		for (Server server : serverList) {
			String result = getDf(server);
			if(result.split("9[5-9]%").length>1||result.split("100%").length>1){
				MailConf mc = new MailConf();
				mc.init("conf/dfmail.conf");
				Mail.send(mc.getSmtp(), mc.getFrom(), server.getOwner(),server.getIp() + "磁盘即将占满", result, mc.getFrom(), mc.getPassword());
			}
		}

	}
	
	public static String getDf(Server server){
		Shell shell = new Shell(server.getIp(), server.getPassword(), server.getUser());
		shell.connect();
		String result = shell.command("df -h", 1000);
		shell.disConnect();
		return result;
	}
	
	
}
