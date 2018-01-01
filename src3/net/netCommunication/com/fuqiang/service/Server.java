package net.netCommunication.com.fuqiang.service;

import java.io.IOException;

import net.netCommunication.com.fuqiang.dao.ServersDao;

public class Server {
	private static ServersDao server;
	
	public static void startServerS() {
		server = new ServersDao();
			
			try {
				server.connect();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	public static void closeServers(){
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
