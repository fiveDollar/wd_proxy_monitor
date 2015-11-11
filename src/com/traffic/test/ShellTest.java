package com.traffic.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class ShellTest {
	public static void main(String[] args) {
		String hostInfo = "root@115.159.2.233";
		JSch jsch = new JSch();
		String user = hostInfo.substring(0, hostInfo.indexOf('@'));
		String host = hostInfo.substring(hostInfo.indexOf('@') + 1);
		Session session = null;
		Channel channel = null;
		OutputStream out = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream in = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		try {
			session = jsch.getSession(user, host);
			session.setPassword("Iknowthat@@!221");
			session.setUserInfo(new MyUserInfo() {
			});
			session.connect(60000);
			channel = session.openChannel("shell");
			out = channel.getOutputStream();
			in = channel.getInputStream();
			ir = new InputStreamReader(in);
			br = new BufferedReader(ir);
			ow = new OutputStreamWriter(out);
			bw = new BufferedWriter(ow);
			channel.connect(60000);
			bw.write("df -h");
			bw.newLine();
			bw.flush();
			String line = null;
			while (true) {
				line = br.readLine();
				if (line != null)
					if(line.contains("vda1")){
						String data[] = line.split(" ");
						System.out.println(data[data.length-2]);
					}
				else {
					TimeUnit.SECONDS.sleep(3);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public static abstract class MyUserInfo implements UserInfo,
			UIKeyboardInteractive {
		public String getPassword() {
			return null;
		}

		public boolean promptYesNo(String str) {
			return true;
		}

		public String getPassphrase() {
			return null;
		}

		public boolean promptPassphrase(String message) {
			return false;
		}

		public boolean promptPassword(String message) {
			return false;
		}

		public void showMessage(String message) {
		}

		public String[] promptKeyboardInteractive(String destination,
				String name, String instruction, String[] prompt, boolean[] echo) {
			return null;
		}
	}
}
