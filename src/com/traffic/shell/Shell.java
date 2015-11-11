package com.traffic.shell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.traffic.test.ShellTest.MyUserInfo;

public class Shell {
	private InputStream shellIn;
	private OutputStream shellOut;
	private String host;
	private String password;
	private String user;
	private Session session = null;
	private Channel channel = null;
	private OutputStreamWriter ow = null;
	private BufferedWriter bw = null;
	private InputStreamReader ir = null;
	private BufferedReader br = null;
	private JSch jsch = new JSch();
	private final int SESSION_TIME_OUT = 60000;
	private final int CHANNEL_TIME_OUT = 60000;
	
	public Shell(){}
	
	/**
	 * @param host
	 * @param password
	 * @param user
	 */
	public Shell(String host,String password,String user){
		
		this.host = host;
		this.password = password;
		this.user = user;
	}
	
	public void connect(){
		try {
			session = jsch.getSession(user, host);
			session.setPassword(password);
			session.setUserInfo(new MyUserInfo() {
			});
			session.connect(SESSION_TIME_OUT);
			channel = session.openChannel("shell");
			shellOut = channel.getOutputStream();
			shellIn = channel.getInputStream();
			ir = new InputStreamReader(shellIn);
			br = new BufferedReader(ir);
			ow = new OutputStreamWriter(shellOut);
			bw = new BufferedWriter(ow);
			channel.connect(CHANNEL_TIME_OUT);
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disConnect(){
		try {
			if(shellIn!=null)
				shellIn.close();
			if(shellOut!=null)
				shellOut.close();
			if(ir!=null)
				ir.close();
			if(br!=null)
				br.close();
			if(ow!=null)
				ow.close();
			if(bw!=null)
				bw.close();
			if(session!=null)
				session.disconnect();
			if(channel!=null)
				channel.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public InputStream getShellIn() {
		return shellIn;
	}
	public void setShellIn(InputStream shellIn) {
		this.shellIn = shellIn;
	}
	public OutputStream getShellOut() {
		return shellOut;
	}
	public void setShellOut(OutputStream shellOut) {
		this.shellOut = shellOut;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public OutputStreamWriter getOw() {
		return ow;
	}
	public void setOw(OutputStreamWriter ow) {
		this.ow = ow;
	}
	public BufferedWriter getBw() {
		return bw;
	}
	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}
	public InputStreamReader getIr() {
		return ir;
	}
	public void setIr(InputStreamReader ir) {
		this.ir = ir;
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	public JSch getJsch() {
		return jsch;
	}
	public void setJsch(JSch jsch) {
		this.jsch = jsch;
	}
	public int getSESSION_TIME_OUT() {
		return SESSION_TIME_OUT;
	}
	public int getCHANNEL_TIME_OUT() {
		return CHANNEL_TIME_OUT;
	}
	
}
